package me.steveice10.openclassic.api.event;

import java.lang.reflect.Method;

import me.steveice10.openclassic.api.OpenClassic;

public class EventManager {

	public void callEvent(Event event) {
		for(Listener listen : OpenClassic.getServer().getPluginManager().getListeners()) {
			Method method = listen.getMethodFor(event);
			if(method != null) {
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
