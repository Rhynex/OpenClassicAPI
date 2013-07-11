package ch.spacebase.openclassic.api.block.physics;

import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockFace;
import ch.spacebase.openclassic.api.inventory.ItemStack;
import ch.spacebase.openclassic.api.item.Item;

/**
 * Represents a block's physics.
 */
public interface BlockPhysics {

	/**
	 * Called when a update occurs on the block.
	 * @param block Block to update.
	 */
	public void update(Block block);
	
	/**
	 * Called to check whether the block can be placed.
	 */
	public boolean canPlace(Block block);
	
	/**
	 * Called when the block is placed.
	 * @param block Block being placed.
	 * @param against BlockFace being placed against
	 */
	public void onPlace(Block block, BlockFace against);
	
	/**
	 * Called when the block is broken.
	 * @param block Block being broken.
	 */
	public void onBreak(Block block);

	/**
	 * Called when a neighbor block is changed.
	 * @param block Block to update.
	 * @param neighbor Neighbor being changed.
	 */
	public void onNeighborChange(Block block, Block neighbor);
	
	/**
	 * Checks whether the given item can harvested this block.
	 * @param block Item used to break this block.
	 * @return Whether this block can be harvested.
	 */
	public boolean canHarvest(Item item);
	
	/**
	 * Called when the block is interacted
	 * @param item ItemStack used to interact the block.
	 * @param block The block that was interacted.
	 * @return Whether anything happened as a result.
	 */
	public boolean onInteracted(ItemStack item, Block block);
	
}
