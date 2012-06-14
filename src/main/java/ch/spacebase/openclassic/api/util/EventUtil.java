package ch.spacebase.openclassic.api.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import ch.spacebase.openclassic.api.event.Event;
import ch.spacebase.openclassic.api.event.EventHandler;
import ch.spacebase.openclassic.api.event.Listener;

public class EventUtil {

	/**
	 * Gets the methods that handle the given event class.
	 * @param Class to look for.
	 * @return Methods that handle the event.
	 */
	public static Method[] getMethodsFor(Listener listen, Class<? extends Event> clazz) {
		List<Method> methods = new ArrayList<Method>();
		
		for(Method method : listen.getClass().getMethods()) {
			Class<?> params[] = method.getParameterTypes();
			if(params.length == 1 && params[0] == clazz && method.getAnnotation(EventHandler.class) != null) methods.add(method);
		}
		
		return methods.toArray(new Method[methods.size()]);
	}
	
}
