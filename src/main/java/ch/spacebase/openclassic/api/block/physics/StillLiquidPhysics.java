package ch.spacebase.openclassic.api.block.physics;

import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockFace;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.block.physics.BlockPhysics;

public class StillLiquidPhysics implements BlockPhysics {

	private byte id;
	
	public StillLiquidPhysics(byte id) {
		this.id = id;
	}
	
	@Override
	public void update(Block block) {
	}

	@Override
	public void onPlace(Block block) {
	}

	@Override
	public void onBreak(Block block) {
	}

	@Override
	public void onNeighborChange(Block block, Block neighbor) {
		boolean moving = false;
		for(BlockFace face : BlockFace.values()) {
			if(face != BlockFace.UP && block.getRelative(face) != null && block.getRelative(face).getType() == VanillaBlock.AIR) {
				moving = true;
			}
		}

		if (neighbor.getType() != VanillaBlock.AIR) {
			if (this.id == VanillaBlock.STATIONARY_WATER.getId() && neighbor.getType() == VanillaBlock.STATIONARY_LAVA || neighbor.getType() == VanillaBlock.STATIONARY_WATER && this.id == VanillaBlock.STATIONARY_LAVA.getId()) {
				block.setType(VanillaBlock.STONE);
				return;
			}
		}

		if (moving) {
			block.setTypeId((byte) (this.id - 1), false);
			block.getLevel().delayTick(block.getPosition(), (byte) (this.id - 1));
		}
	}

}
