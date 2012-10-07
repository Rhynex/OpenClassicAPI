package ch.spacebase.openclassic.api.event;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.event.game.EventDispatchEvent;
import ch.spacebase.openclassic.api.plugin.Plugin;

public class EventManager {

	private Map<String, List<Listener>> listeners = new HashMap<String, List<Listener>>();
	
	public List<Listener> getListeners(Plugin plugin) {
		return this.listeners.containsKey(plugin.getDescription().getName()) ? this.listeners.get(plugin.getDescription().getName()) : new ArrayList<Listener>();
	}
	
	public void registerListener(Listener listen, Plugin plugin) {
		if(!this.listeners.containsKey(plugin.getDescription().getName())) {
			this.listeners.put(plugin.getDescription().getName(), new ArrayList<Listener>());
		}
		
		this.listeners.get(plugin.getDescription().getName()).add(listen);
	}
	
	public void unregisterListener(Listener listen, Plugin plugin) {
		if(this.listeners.containsKey(plugin.getDescription().getName())) {
			this.listeners.get(plugin.getDescription().getName()).remove(listen);
		}
	}
	
	public void unregisterListeners(Plugin plugin) {
		this.listeners.remove(plugin.getDescription().getName());
	}
	
	/**
	 * Dispatches the given event.
	 * @param event Event to dispatch.
	 */
	public <T extends Event> T dispatch(T event) {
		if(OpenClassic.getGame() == null || OpenClassic.getGame().getPluginManager() == null) return event;
		for(Priority pri : Priority.values()) {
			this.dispatch(new EventDispatchEvent(event, pri), pri);
			this.dispatch(event, pri);
		}
		
		return event;
	}
	
	private void dispatch(Event event, Priority pri) {
		for(String plugin : this.listeners.keySet()) {
			for(Listener listen : this.listeners.get(plugin)) {
				if(!OpenClassic.getGame().getPluginManager().isPluginEnabled(plugin)) continue;
				Method methods[] = this.getMethodsFor(listen, event.getClass(), pri);
				if(methods != null && methods.length > 0) {
					for(Method method : methods) {
						try {
							method.invoke(listen, event);
						} catch(Exception e) {
							OpenClassic.getLogger().severe("Failed to call event " + event.getType().name() + " for plugin " + plugin + "!");
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	/**
	 * Gets the methods that handle the given event class.
	 * @param listen Listener to look in.
	 * @param clazz Class to look for.
	 * @return Methods that handle the event.
	 */
	private Method[] getMethodsFor(Listener listen, Class<? extends Event> clazz, Priority pri) {
		List<Method> methods = new ArrayList<Method>();
		
		for(Method method : listen.getClass().getMethods()) {
			Class<?> params[] = method.getParameterTypes();
			if(params.length == 1 && params[0] == clazz && method.getAnnotation(EventHandler.class) != null && method.getAnnotation(EventHandler.class).priority() == pri) methods.add(method);
		}
		
		return methods.toArray(new Method[methods.size()]);
	}
	
}
