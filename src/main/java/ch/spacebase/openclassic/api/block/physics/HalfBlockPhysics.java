package ch.spacebase.openclassic.api.block.physics;

import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockFace;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.block.physics.BlockPhysics;

/**
 * Physics used to make half blocks join.
 */
public class HalfBlockPhysics implements BlockPhysics {

	private BlockType block;
	private BlockType full;
	
	public HalfBlockPhysics(BlockType block, BlockType full) {
		this.block = block;
		this.full = full;
	}
	
	@Override
	public void update(Block block) {
	}
	
	@Override
	public void onPlace(Block block) {
		Block relative = block.getRelative(BlockFace.DOWN);
		if(relative != null && relative.getType() == this.block) {
			block.setType(VanillaBlock.AIR);
			relative.setType(this.full);
		}
	}

	@Override
	public void onBreak(Block block) {
	}

	@Override
	public void onNeighborChange(Block block, Block neighbor) {
	}

}
