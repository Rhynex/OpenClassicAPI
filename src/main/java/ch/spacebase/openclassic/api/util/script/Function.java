package ch.spacebase.openclassic.api.util.script;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Function {

	private String code;
	private List<Param> params;
	
	public Function(String code, Param... params) {
		this.code = code;
		this.params = params != null ? new ArrayList<Param>(Arrays.asList(params)) : new ArrayList<Param>();
	}
	
	public String getCode() {
		return this.code;
	}
	
	public List<Param> getParams() {
		return new ArrayList<Param>(this.params);
	}
	
	public void addParam(String name, Object value) {
		this.params.add(new Param(name, value));
	}
	
	public void addParam(Param param) {
		this.params.add(param);
	}
	
	public void removeParam(String name) {
		for(Param param : this.params) {
			if(param.getName().equals(name)) {
				this.params.remove(param);
				break;
			}
		}
	}
	
	public void removeParam(Param param) {
		this.params.remove(param);
	}
	
}
