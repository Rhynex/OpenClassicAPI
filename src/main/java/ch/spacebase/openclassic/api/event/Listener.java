package ch.spacebase.openclassic.api.event;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class Listener {

	protected final Method[] getMethodsFor(Class<? extends Event> clazz) {
		List<Method> methods = new ArrayList<Method>();
		
		for(Method method : this.getClass().getMethods()) {
			Class<?> params[] = method.getParameterTypes();
			if(params.length == 1 && params[0] == clazz && method.getAnnotation(EventHandler.class) != null) methods.add(method);
		}
		
		return methods.toArray(new Method[methods.size()]);
	}
	
}
