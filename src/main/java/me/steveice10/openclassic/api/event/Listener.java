package me.steveice10.openclassic.api.event;

import java.lang.reflect.Method;

public abstract class Listener {

	public final Method getMethodFor(Event event) {
		for(Method method : this.getClass().getMethods()) {
			Class<?> params[] = method.getParameterTypes();
			if(params.length == 1 && params[0] == event.getClass()) return method;
		}
		
		return null;
	}
	
}
