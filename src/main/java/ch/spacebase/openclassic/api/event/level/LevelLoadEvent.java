package ch.spacebase.openclassic.api.event.level;

import com.zachsthings.onevent.HandlerList;

import ch.spacebase.openclassic.api.level.Level;

/**
 * Called when a level is loaded.
 */
public class LevelLoadEvent extends LevelEvent {

	private static final HandlerList handlers = new HandlerList();
	
	public LevelLoadEvent(Level level) {
		super(level);
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}

}
