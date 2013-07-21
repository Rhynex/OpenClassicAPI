package ch.spacebase.openclassic.api.event.level;

import com.zachsthings.onevent.HandlerList;

import ch.spacebase.openclassic.api.Position;
import ch.spacebase.openclassic.api.level.Level;

/**
 * Called when a level's spawn is changed.
 */
public class SpawnChangeEvent extends LevelEvent {

	private static final HandlerList handlers = new HandlerList();
	
	private Position old;
	
	public SpawnChangeEvent(Level level, Position old) {
		super(level);
		this.old = old;
	}
	
	/**
	 * Gets the level's old spawn.
	 * @return The level's old spawn.
	 */
	public Position getOldSpawn() {
		return this.old;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

}
