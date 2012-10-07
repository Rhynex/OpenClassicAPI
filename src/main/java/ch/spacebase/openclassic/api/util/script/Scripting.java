package ch.spacebase.openclassic.api.util.script;

import bsh.EvalError;
import bsh.Interpreter;

public class Scripting {

	public static Object run(Function func) {
		Interpreter i = new Interpreter();
		try {
			for(Param param : func.getParams()) {
				i.set(param.getName(), param.getValue());
			}
			
			return i.eval(func.getCode());
		} catch(EvalError e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
