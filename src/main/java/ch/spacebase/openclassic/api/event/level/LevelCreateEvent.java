package ch.spacebase.openclassic.api.event.level;

import com.zachsthings.onevent.HandlerList;

import ch.spacebase.openclassic.api.level.Level;

/**
 * Called when a level is created.
 */
public class LevelCreateEvent extends LevelEvent {

	private static final HandlerList handlers = new HandlerList();
	
	public LevelCreateEvent(Level level) {
		super(level);
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

}
