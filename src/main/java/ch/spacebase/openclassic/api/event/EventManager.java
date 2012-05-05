package ch.spacebase.openclassic.api.event;

import java.lang.reflect.Method;

import ch.spacebase.openclassic.api.OpenClassic;


public class EventManager {

	public void callEvent(Event event) {
		for(Listener listen : OpenClassic.getServer().getPluginManager().getListeners()) {
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
