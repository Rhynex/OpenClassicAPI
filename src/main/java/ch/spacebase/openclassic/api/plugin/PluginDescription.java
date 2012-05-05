package ch.spacebase.openclassic.api.plugin;

public class PluginDescription {

	private String name;
	private String version;
	private String mainClass;
	private String depends[];
	
	public PluginDescription(String name, String version, String mainClass, String depends) {
		this.name = name;
		this.version = version;
		this.mainClass = mainClass;
		this.depends = depends.split(", ");
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
	
}
