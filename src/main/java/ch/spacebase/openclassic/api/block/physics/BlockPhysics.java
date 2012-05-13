package ch.spacebase.openclassic.api.block.physics;

import ch.spacebase.openclassic.api.block.Block;

/**
 * Represents a block's physics.
 */
public interface BlockPhysics {

	/**
	 * Called when a update occurs on the block.
	 * @param Block to update.
	 * @return Whether anything was changed.
	 */
	public boolean update(Block block);
	
	/**
	 * Called when the block is placed.
	 * @param Block being placed.
	 */
	public void onPlace(Block block);
	
	/**
	 * Called when the block is broken.
	 * @param Block being broken.
	 */
	public void onBreak(Block block);
	
}
