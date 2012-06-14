package ch.spacebase.openclassic.api.block.physics;

import ch.spacebase.openclassic.api.block.Block;

/**
 * Represents a block's physics.
 */
public interface BlockPhysics {

	/**
	 * Called when a update occurs on the block.
	 * @param Block to update.
	 */
	public void update(Block block);
	
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

	/**
	 * Called when a neighbor block is changed.
	 * @param Block to update.
	 * @param Neighbor being changed.
	 */
	public void onNeighborChange(Block block, Block neighbor);
	
}
