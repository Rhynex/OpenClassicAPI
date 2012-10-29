package ch.spacebase.openclassic.api.level.generator.normal.decorator;

import java.util.Random;

import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.column.Chunk;
import ch.spacebase.openclassic.api.level.generator.biome.Decorator;
import ch.spacebase.openclassic.api.util.Constants;

public class ShrubDecorator implements Decorator {

	private static final byte AMOUNT = 1;
	private static final byte SIZE = 2;

	@Override
	public void populate(Level level, Chunk chunk, Random random) {
		if(chunk.getY() < 4) return;
		if(random.nextInt(4) != 0) return;
		int x = random.nextInt(16) + chunk.getWorldX();
		int z = random.nextInt(16) + chunk.getWorldZ();
		int y = getHighestWorkableBlock(level, x, z);
		if(y == -1) return;
		for(int i = 0; i < AMOUNT; i++) {
			this.generateShrub(level, random, x, y, z);
		}
	}

	private void generateShrub(Level level, Random random, int x, int y, int z) {
		if(this.canBuildShrub(level, x, y, z)) return;
		level.setBlockAt(x, y, z, VanillaBlock.LOG);
		for(byte yy = SIZE; yy > -1; yy--) {
			for(byte xx = (byte) -yy; xx < yy + 1; xx++) {
				for(byte zz = (byte) -yy; zz < yy + 1; zz++) {
					if(Math.abs(xx) == yy && Math.abs(zz) == yy && random.nextBoolean()) continue;
					Block block = level.getBlockAt(x + xx, y - yy + SIZE, z + zz);
					BlockType type = block.getType();
					if(!type.isOpaque() && type != VanillaBlock.LOG) {
						block.setType(VanillaBlock.LEAVES);
					}
				}
			}
		}
	}

	private boolean canBuildShrub(Level level, int x, int y, int z) {
		BlockType type = level.getBlockTypeAt(x, y - 1, z);
		return type == VanillaBlock.DIRT || type == VanillaBlock.GRASS;
	}

	private int getHighestWorkableBlock(Level level, int x, int z) {
		int y = Constants.COLUMN_HEIGHT - 1;
		BlockType type;
		while ((type = level.getBlockTypeAt(x, y, z)) == VanillaBlock.AIR || type == VanillaBlock.LEAVES) {
			y--;
			if (y == 0 || level.getBlockTypeAt(x, y, z) == VanillaBlock.WATER) {
				return -1;
			}
		}

		y++;
		return y;
	}
}
