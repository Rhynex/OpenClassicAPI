package ch.spacebase.openclassic.api.block.physics;

import ch.spacebase.openclassic.api.Position;
import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.block.physics.BlockPhysics;
import ch.spacebase.openclassic.api.level.Level;

/**
 * Physics used in liquids to make it flow.
 */
public class LiquidPhysics implements BlockPhysics {

	private byte id;
	
	public LiquidPhysics(byte id) {
		this.id = id;
	}
	
	@Override
	public void update(Block block) {
		boolean moving = false;
		boolean cont = true;
		int y = block.getPosition().getBlockY();
		
		while (cont) {
			y--;
			if (block.getLevel().getBlockTypeAt(block.getPosition().getBlockX(), y, block.getPosition().getBlockZ()) != VanillaBlock.AIR || !this.canMove(block.getLevel().getBlockAt(block.getPosition().getBlockX(), y, block.getPosition().getBlockZ()))) {
				break;
			}

			if (cont = block.getLevel().setBlockIdAt(block.getPosition().getBlockX(), y, block.getPosition().getBlockZ(), this.id)) {
				moving = true;
			}
			
			if(this.id == VanillaBlock.LAVA.getId()) {
				cont = false;
			}
		}

		y++;
		Block b = block.getLevel().getBlockAt(block.getPosition().getBlockX(), y, block.getPosition().getBlockZ());
		if (this.id == VanillaBlock.WATER.getId() || !moving) {
			int x = block.getPosition().getBlockX();
			int yy = block.getPosition().getBlockY();
			int z = block.getPosition().getBlockZ();
			moving = moving | this.canFlow(block.getLevel(), x - 1, yy, z) | this.canFlow(block.getLevel(), x + 1, yy, z) | this.canFlow(block.getLevel(), x, yy, z - 1) | this.canFlow(block.getLevel(), x, yy, z + 1);
		}

		if (moving) {
			block.getLevel().delayTick(b.getPosition(), this.id);
		}
	}
	
	private boolean canMove(Block block) {
		if(block == null) return false;
		
		if (this.id == VanillaBlock.WATER.getId()) {
			for (int x = block.getPosition().getBlockX() - 2; x <= block.getPosition().getBlockX() + 2; x++) {
				for (int y = block.getPosition().getBlockY() - 2; y <= block.getPosition().getBlockY() + 2; y++) {
					for (int z = block.getPosition().getBlockZ() - 2; z <= block.getPosition().getBlockZ() + 2; z++) {
						Block b = block.getLevel().getBlockAt(x, y, z);
						if (b != null && b.getType() == VanillaBlock.SPONGE) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	private boolean canFlow(Level level, int x, int y, int z) {
		if (level.getBlockTypeAt(x, y, z) == VanillaBlock.AIR) {
			if (!this.canMove(level.getBlockAt(x, y, z))) {
				return false;
			}

			if (level.setBlockIdAt(x, y, z, this.id)) {
				level.delayTick(new Position(level, x, y, z), this.id);
			}
		}

		return false;
	}

	@Override
	public void onPlace(Block block) {
		block.getLevel().delayTick(block.getPosition(), this.id);
	}

	@Override
	public void onBreak(Block block) {
	}

	@Override
	public void onNeighborChange(Block block, Block neighbor) {
		if (neighbor.getType() != VanillaBlock.AIR) {
			if (this.id == VanillaBlock.WATER.getId() && neighbor.getType() == VanillaBlock.LAVA || neighbor.getType() == VanillaBlock.WATER && this.id == VanillaBlock.LAVA.getId()) {
				block.setType(VanillaBlock.STONE);
				return;
			}
		}

		block.getLevel().delayTick(block.getPosition(), block.getTypeId());
	}

}
