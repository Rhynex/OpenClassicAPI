package me.steveice10.openclassic.api.plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import me.steveice10.openclassic.api.config.Configuration;
import me.steveice10.openclassic.api.event.Listener;

public abstract class Plugin {

	private PluginDescription description;
	private Configuration config;
	private File dataFolder;
	private boolean enabled;
	private List<Listener> listeners = new ArrayList<Listener>();
	
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
	
	protected void addListener(Listener listener) {
		this.listeners.add(listener);
	}
	
	public List<Listener> getListeners() {
		return this.listeners;
	}
	
}
