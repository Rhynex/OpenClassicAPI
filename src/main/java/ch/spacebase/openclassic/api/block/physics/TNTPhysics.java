package ch.spacebase.openclassic.api.block.physics;

import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockFace;
import ch.spacebase.openclassic.api.inventory.ItemStack;
import ch.spacebase.openclassic.api.item.Item;

public class TNTPhysics implements BlockPhysics {

	@Override
	public void update(Block block) {
	}

	@Override
	public boolean canPlace(Block block) {
		return true;
	}

	@Override
	public void onPlace(Block block, BlockFace against) {
	}

	@Override
	public void onBreak(Block block) {
	}

	@Override
	public void onNeighborChange(Block block, Block neighbor) {
	}

	@Override
	public boolean canHarvest(Item item) {
		return true;
	}

	@Override
	public boolean onInteracted(ItemStack item, Block block) {
		block.getLevel().explode(block.getPosition().getBlockX(), block.getPosition().getBlockY(), block.getPosition().getBlockZ(), 4);
		return true;
	}

}
