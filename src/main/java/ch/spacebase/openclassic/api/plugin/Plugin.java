package ch.spacebase.openclassic.api.plugin;

import java.io.File;

import ch.spacebase.openclassic.api.config.Configuration;

/**
 * Represents a plugin.
 */
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
	
	/**
	 * Called when the plugin is loaded.
	 */
	public void onLoad() {
	}
	
	/**
	 * Called when the plugin is enabled.
	 */
	public void onEnable() {
	}
	
	/**
	 * Called when the plugin is disabled.
	 */
	public void onDisable() {
	}
	
	/**
	 * Gets the plugin's description.
	 * @return The plugin's description.
	 */
	public PluginDescription getDescription() {
		return this.description;
	}
	
	/**
	 * Gets the plugin's configuration.
	 * @return The plugin's configuration.
	 */
	public Configuration getConfig() {
		return this.config;
	}
	
	/**
	 * Gets the plugin's data folder.
	 * @return The plugin's data folder.
	 */
	public File getDataFolder() {
		return this.dataFolder;
	}
	
	/**
	 * Returns true if the plugin is enabled.
	 * @return If the plugin is enabled.
	 */
	public boolean isEnabled() {
		return this.enabled;
	}
	
	/**
	 * Sets whether the plugin is enabled.
	 * @param Whether the plugin is enabled.
	 */
	public void setEnabled(boolean enable) {
		this.enabled = enable;
	}
	
	@Override
	public String toString() {
		return this.getDescription().getFullName();
	}
	
}
