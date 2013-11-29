package ch.spacebase.openclassic.api.block.physics;

import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockFace;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.block.physics.BlockPhysics;

/**
 * Physics used in falling blocks.
 */
public class FallingBlockPhysics implements BlockPhysics {

	private BlockType block;
	
	public FallingBlockPhysics(BlockType block) {
		this.block = block;
	}
	
	@Override
	public void update(Block block) {
		this.fall(block);
	}

	@Override
	public void onPlace(Block block) {
		this.fall(block);
	}

	@Override
	public void onBreak(Block block) {
	}

	@Override
	public void onNeighborChange(Block block, Block neighbor) {
		this.fall(block);
	}
	
	private void fall(Block block) {
		Block relative = block.getRelative(BlockFace.DOWN);
		if(relative != null && relative.getType().canPlaceIn()) {
			block.setType(VanillaBlock.AIR);
			relative.setType(this.block);
			block.getLevel().delayTick(relative.getPosition());
		}
	}

}
