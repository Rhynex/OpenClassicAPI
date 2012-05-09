package ch.spacebase.openclassic.api.plugin;

import java.io.File;

import ch.spacebase.openclassic.api.config.Configuration;


public abstract class Plugin {

	private PluginDescription description;
	private Configuration config;
	private File dataFolder;
	private boolean enabled;
	
	public Plugin(PluginDescription description) {
		this.description = description;
		this.dataFolder = new File("plugins/" + description.getName());
		this.config = new Configuration(new File(this.dataFolder, "config.yml"));
	}
	
	public abstract void onEnable();
	
	public abstract void onDisable();
	
	public PluginDescription getDescription() {
		return this.description;
	}
	
	public Configuration getConfig() {
		return this.config;
	}
	
	public File getDataFolder() {
		return this.dataFolder;
	}
	
	public boolean isEnabled() {
		return this.enabled;
	}
	
	public void setEnabled(boolean enable) {
		this.enabled = enable;
	}
	
	@Override
	public String toString() {
		return this.getDescription().getFullName();
	}
	
}
