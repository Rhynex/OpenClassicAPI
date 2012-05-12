package ch.spacebase.openclassic.api.event.plugin;

import ch.spacebase.openclassic.api.plugin.Plugin;

public class PluginDisableEvent extends PluginEvent {

	public PluginDisableEvent(Plugin plugin) {
		super(EventType.PLUGIN_DISABLE, plugin);
	}
	
}
