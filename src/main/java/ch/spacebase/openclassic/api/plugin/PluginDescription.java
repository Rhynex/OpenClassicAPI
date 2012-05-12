package ch.spacebase.openclassic.api.plugin;

import ch.spacebase.openclassic.api.plugin.PluginManager.LoadOrder;

public class PluginDescription {

	private String name;
	private String version;
	private String mainClass;
	private String depends[];
	private LoadOrder order;
	
	public PluginDescription(String name, String version, String mainClass, String depends, String order) {
		this.name = name;
		this.version = version;
		this.mainClass = mainClass;
		this.depends = (depends != null ? depends.split(", ") : new String[] { });
		this.order = LoadOrder.valueOf(order.toUpperCase());
	}
	
	public String getFullName() {
		return this.getName() + " v" + this.getVersion();
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getVersion() {
		return this.version;
	}
	
	public String getMainClass() {
		return this.mainClass;
	}
	
	public String[] getDependencies() {
		return this.depends;
	}
	
	public LoadOrder getLoadOrder() {
		return this.order;
	}
	
}
