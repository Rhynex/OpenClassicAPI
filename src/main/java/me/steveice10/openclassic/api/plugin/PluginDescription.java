package me.steveice10.openclassic.api.plugin;

public class PluginDescription {

	private String name;
	private String version;
	private String mainClass;
	
	public PluginDescription(String name, String version, String mainClass) {
		this.name = name;
		this.version = version;
		this.mainClass = mainClass;
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
	
}
