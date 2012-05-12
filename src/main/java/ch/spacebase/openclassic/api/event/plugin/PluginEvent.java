package ch.spacebase.openclassic.api.event.plugin;

import ch.spacebase.openclassic.api.event.Event;
import ch.spacebase.openclassic.api.plugin.Plugin;

public abstract class PluginEvent extends Event {

	private Plugin plugin;
	
	public PluginEvent(EventType type, Plugin plugin) {
		super(type);
		this.plugin = plugin;
	}
	
	public Plugin getPlugin() {
		return this.plugin;
	}
	
}
