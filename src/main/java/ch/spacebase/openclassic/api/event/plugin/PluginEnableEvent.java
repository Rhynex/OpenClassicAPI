package ch.spacebase.openclassic.api.event.plugin;

import ch.spacebase.openclassic.api.plugin.Plugin;

public class PluginEnableEvent extends PluginEvent {

	public PluginEnableEvent(Plugin plugin) {
		super(EventType.PLUGIN_ENABLE, plugin);
	}
	
}
