package ch.spacebase.openclassic.api.event.block;

import com.zachsthings.onevent.Event;

import ch.spacebase.openclassic.api.block.Block;

/**
 * Represents an event involving a block.
 */
public abstract class BlockEvent extends Event {

	private Block block;
	
	public BlockEvent(Block block) {
		this.block = block;
	}
	
	/**
	 * Gets the block involved in this event.
	 * @return The block involved.
	 */
	public Block getBlock() {
		return this.block;
	}
	
}
