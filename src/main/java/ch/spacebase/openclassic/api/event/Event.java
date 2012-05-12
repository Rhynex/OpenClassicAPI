package ch.spacebase.openclassic.api.event;

/**
 * Represents an event.
 */
public abstract class Event {

	private final EventType type;
	
	public Event(EventType type) {
		this.type = type;
	}
	
	/**
	 * Gets the type of event this is.
	 * @return The event's type.
	 */
	public final EventType getType() {
		return this.type;
	}
	
	/**
	 * The possible types of events.
	 */
	public enum EventType {
		/** Called when a plugin is enabled. */
		PLUGIN_ENABLE,
		/** Called when a plugin is disabled. */
		PLUGIN_DISABLE;
	}
	
}
