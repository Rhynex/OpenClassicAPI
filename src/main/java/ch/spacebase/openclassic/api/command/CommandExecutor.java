package ch.spacebase.openclassic.api.command;

import java.lang.reflect.Method;

import ch.spacebase.openclassic.api.command.annotation.Command;


public abstract class CommandExecutor {

	public final Method getCommandMethod(String command) {
		for(Method method : this.getClass().getMethods()) {
			Class<?> params[] = method.getParameterTypes();
			if(params.length == 3 && method.getAnnotation(Command.class) != null) {
				for(String alias : method.getAnnotation(Command.class).aliases()) {
					if(alias.equalsIgnoreCase(command)) return method;
				}
			}
		}
			
		return null;
	}
	
}
