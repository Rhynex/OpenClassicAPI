package ch.spacebase.openclassic.api.item.physics;

import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.inventory.ItemStack;
import ch.spacebase.openclassic.api.player.Player;

public abstract class ItemPhysics {

	/**
	 * Called when a player right clicks a block with the item.
	 * @param item ItemStack that is being right clicked with.
	 * @param player Player that right clicked.
	 * @param block Block that was right clicked.
	 * @return Whether anything happened as a result.
	 */
	public abstract boolean onRightClick(ItemStack item, Player player, Block block);

	/**
	 * Called when a player left clicks a block with the item.
	 * @param item ItemStack that is being left clicked with.
	 * @param player Player that left clicked.
	 * @param block Block that was left clicked.
	 */
	public abstract void onLeftClick(ItemStack item, Player player, Block block);
	
	/**
	 * Called when a player right clicks the air.
	 * @param item ItemStack being right clicked with.
	 * @param player Player that right clicked.
	 * @return Whether anything happened.
	 */
	public boolean onRightClick(ItemStack item, Player player) {
		return false;
	}
	
	/**
	 * Gets the break speed of this item on the given block.
	 * @param type Block type that is being clicked.
	 * @return The break speed of the item.
	 */
	public float getBreakSpeed(BlockType type) {
		return 1;
	}
	
}
