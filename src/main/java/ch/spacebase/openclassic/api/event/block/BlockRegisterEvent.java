package ch.spacebase.openclassic.api.event.block;

import com.zachsthings.onevent.Event;
import com.zachsthings.onevent.HandlerList;

import ch.spacebase.openclassic.api.block.BlockType;

/**
 * Called when a block is registered.
 */
public class BlockRegisterEvent extends Event {

	private static final HandlerList handlers = new HandlerList();
	
	private BlockType type;
	
	public BlockRegisterEvent(BlockType type) {
		this.type = type;
	}
	
	/**
	 * Gets the registered BlockType.
	 * @return The registered BlockType.
	 */
	public BlockType getBlock() {
		return this.type;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

}
