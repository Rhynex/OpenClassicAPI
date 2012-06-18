package ch.spacebase.openclassic.api.event;

import java.lang.reflect.Method;
import java.util.SortedMap;
import java.util.TreeMap;

import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.util.EventUtil;

/**
 * A factory for building and calling events.
 */
public class EventFactory {

	/**
	 * Calls the given event.
	 * @param event Event to call.
	 */
	public static <T extends Event> T callEvent(T event) {
		if(OpenClassic.getGame() == null || OpenClassic.getGame().getPluginManager() == null) return event;
		
		SortedMap<Method, Listener> calling = new TreeMap<Method, Listener>(new PrioritySorter());
		for(Listener listen : OpenClassic.getGame().getPluginManager().getListeners()) {
			if(!OpenClassic.getGame().getPluginManager().getPlugin(listen).isEnabled()) continue;
			
			Method methods[] = EventUtil.getMethodsFor(listen, event.getClass());
			if(methods != null && methods.length > 0) {
				for(Method method : methods) {
					calling.put(method, listen);
				}
			}
		}
		
		for(Method method : calling.keySet()) {
			try {
				method.invoke(calling.get(method), event);
			} catch(Exception e) {
				OpenClassic.getLogger().severe("Failed to call event " + event.getType().name() + "!");
				e.printStackTrace();
			}
		}
		
		return event;
	}
	
}
