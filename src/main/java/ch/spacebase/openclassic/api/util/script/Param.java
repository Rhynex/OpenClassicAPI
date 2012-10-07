package ch.spacebase.openclassic.api.util.script;

public class Param {
	
	private String name;
	private Object value;
	
	public Param(String name, Object value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Object getValue() {
		return this.value;
	}
	
}
