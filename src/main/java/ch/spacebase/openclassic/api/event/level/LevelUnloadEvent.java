package ch.spacebase.openclassic.api.event.level;

import com.zachsthings.onevent.Cancellable;
import com.zachsthings.onevent.HandlerList;

import ch.spacebase.openclassic.api.level.Level;

/**
 * Called when a level is unloaded.
 */
public class LevelUnloadEvent extends LevelEvent implements Cancellable {

	private static final HandlerList handlers = new HandlerList();
	
	private boolean cancelled = false;
	
	public LevelUnloadEvent(Level level) {
		super(level);
	}

	@Override
	public boolean isCancelled() {
		return this.cancelled;
	}

	@Override
	public void setCancelled(boolean cancel) {
		this.cancelled = cancel;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

}
