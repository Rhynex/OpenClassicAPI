package ch.spacebase.openclassic.api.block.physics;

import ch.spacebase.openclassic.api.Position;
import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockFace;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.block.Blocks;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.block.physics.BlockPhysics;
import ch.spacebase.openclassic.api.inventory.ItemStack;
import ch.spacebase.openclassic.api.item.Item;
import ch.spacebase.openclassic.api.level.Level;

/**
 * Physics used in liquids to make it flow.
 */
public class LiquidPhysics implements BlockPhysics {

	private int type;
	private int flow;
	
	public LiquidPhysics(int type, int flow) {
		this.type = type;
		this.flow = flow;
	}
	
	@Override
	public void update(Block block) {
		boolean moving = false;
		int y = block.getPosition().getBlockY();
		
		while (true) {
			y--;
			if (block.getLevel().getBlockTypeAt(block.getPosition().getBlockX(), y, block.getPosition().getBlockZ()) != VanillaBlock.AIR || !this.canMove(block.getLevel(), block.getPosition().getBlockX(), y, block.getPosition().getBlockZ())) {
				break;
			}

			if (block.getLevel().setBlockAt(block.getPosition().getBlockX(), y, block.getPosition().getBlockZ(), Blocks.get(this.type, 0))) {
				moving = true;
			} else {
				break;
			}
			
			if(this.type == VanillaBlock.LAVA.getId()) {
				break;
			}
		}

		y++;
		if (this.type == VanillaBlock.WATER.getId() || !moving) {
			int x = block.getPosition().getBlockX();
			int yy = block.getPosition().getBlockY();
			int z = block.getPosition().getBlockZ();
			moving = moving | this.canFlow(block, block.getLevel(), x - 1, yy, z) | this.canFlow(block, block.getLevel(), x + 1, yy, z) | this.canFlow(block, block.getLevel(), x, yy, z - 1) | this.canFlow(block, block.getLevel(), x, yy, z + 1);
		}

		if (moving) {
			block.getLevel().delayTick(new Position(block.getLevel(), block.getPosition().getBlockX(), y, block.getPosition().getBlockZ()), Blocks.get(this.type, block.getData()));
		}
	}
	
	private boolean canMove(Level level, int x, int y, int z) {
		if (this.type == VanillaBlock.WATER.getId()) {
			for (int bx = x - 2; bx <= x + 2; bx++) {
				for (int by = y - 2; by <= y + 2; by++) {
					for (int bz = z - 2; bz <= z + 2; bz++) {
						BlockType block = level.getBlockTypeAt(bx, by, bz);
						if (block != null && block == VanillaBlock.SPONGE) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	private boolean canFlow(Block block, Level level, int x, int y, int z) {
		if(block.getData() >= this.flow || (level.getBlockIdAt(x, y, z) == this.type && level.getData(x, y, z) <= block.getData())) {
			return false;
		}
		
		if (level.getBlockTypeAt(x, y, z) == VanillaBlock.AIR) {
			if (!this.canMove(level, x, y, z)) {
				return false;
			}

			if (level.setBlockAt(x, y, z, Blocks.get(this.type, block.getData() + 1))) {
				level.delayTick(new Position(level, x, y, z), Blocks.get(this.type, block.getData() + 1));
			}
		}

		return false;
	}

	@Override
	public void onPlace(Block block, BlockFace against) {
		block.getLevel().delayTick(block.getPosition(), Blocks.get(this.type, block.getData()));
	}
	
	@Override
	public boolean canPlace(Block block) {
		return true;
	}

	@Override
	public void onBreak(Block block) {
	}

	@Override
	public void onNeighborChange(Block block, Block neighbor) {
		if(block.getData() != 0) {
			boolean connect = false;
			for(BlockFace face : BlockFace.values()) {
				if(face == BlockFace.DOWN) continue;
				Block relative = block.getRelative(face);
				if(relative.getTypeId() == block.getTypeId() && relative.getData() < block.getData()) {
					connect = true;
					break;
				}
			}
			
			if(!connect) {
				block.setType(VanillaBlock.AIR);
				return;
			}
		}
		
		if (neighbor.getType() != VanillaBlock.AIR) {
			if (this.type == VanillaBlock.WATER.getId() && neighbor.getType() == VanillaBlock.LAVA || neighbor.getType() == VanillaBlock.WATER && this.type == VanillaBlock.LAVA.getId()) {
				block.setType(VanillaBlock.STONE);
				return;
			}
		}

		block.getLevel().delayTick(block.getPosition(), block.getType());
	}
	
	@Override
	public boolean canHarvest(Item item) {
		return false;
	}
	
	@Override
	public boolean onInteracted(ItemStack item, Block block) {
		return false;
	}

}
