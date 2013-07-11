package ch.spacebase.openclassic.api.block.physics;

import java.util.Random;

import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockFace;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.block.physics.BlockPhysics;
import ch.spacebase.openclassic.api.inventory.ItemStack;
import ch.spacebase.openclassic.api.item.Item;

/**
 * Physics used for reeds.
 */
public class ReedPhysics implements BlockPhysics {

	private Random rand = new Random();
	
	@Override
	public void update(Block block) {
		if(!this.canPlace(block)) {
			block.setType(VanillaBlock.AIR);
			return;
		}
		
		if(this.rand.nextInt(20) == 0) {
			Block relative = block.getRelative(BlockFace.DOWN);
			for(int count = 0; relative.getType() == VanillaBlock.REEDS; relative = relative.getRelative(BlockFace.DOWN)) {
				count++;
				if(count >= 3) return;
			}
			
			block.getRelative(BlockFace.UP).setType(VanillaBlock.REEDS);
		}
	}

	@Override
	public void onPlace(Block block, BlockFace against) {
	}
	
	@Override
	public boolean canPlace(Block block) {
		Block b = block.getRelative(BlockFace.DOWN);
		return ((b.getType() == VanillaBlock.GRASS || b.getType() == VanillaBlock.SAND) && this.hasWater(b)) || b.getType() == VanillaBlock.REEDS;
	}

	@Override
	public void onBreak(Block block) {
	}

	@Override
	public void onNeighborChange(Block block, Block neighbor) {
		Block b = block.getRelative(BlockFace.DOWN);
		if(!((b.getType() == VanillaBlock.GRASS || b.getType() == VanillaBlock.SAND) && this.hasWater(b)) && b.getType() != VanillaBlock.REEDS) {
			block.setType(VanillaBlock.AIR);
		}
	}
	
	private boolean hasWater(Block b) {
		for(BlockFace face : BlockFace.nsew()) {
			if(b.getRelative(face).getTypeId() == VanillaBlock.WATER.getId() || b.getRelative(face).getTypeId() == VanillaBlock.STATIONARY_WATER.getId()) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean canHarvest(Item item) {
		return true;
	}
	
	@Override
	public boolean onInteracted(ItemStack item, Block block) {
		return false;
	}

}
