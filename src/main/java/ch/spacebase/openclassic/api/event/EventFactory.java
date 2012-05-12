package ch.spacebase.openclassic.api.event;

import java.lang.reflect.Method;

import ch.spacebase.openclassic.api.OpenClassic;

/**
 * A factory for building and calling events.
 */
public class EventFactory {

	/**
	 * Calls the given event.
	 * @param Event to call.
	 */
	public static void callEvent(Event event) {
		for(Listener listen : OpenClassic.getServer().getPluginManager().getListeners()) {
			if(!OpenClassic.getServer().getPluginManager().getPlugin(listen).isEnabled()) continue;
			
			Method methods[] = listen.getMethodsFor(event.getClass());
			if(methods != null && methods.length > 0) {
				for(Method method : methods) {
					try {
						method.invoke(listen, event);
					} catch(Exception e) {
						OpenClassic.getLogger().severe("Failed to call event " + event.getType().name() + "!");
						e.printStackTrace();
					}
				}
			}
		}
	}
	
}
