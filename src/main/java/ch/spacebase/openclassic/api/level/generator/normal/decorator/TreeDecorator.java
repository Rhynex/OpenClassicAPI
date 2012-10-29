package ch.spacebase.openclassic.api.level.generator.normal.decorator;

import java.util.Random;

import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockFace;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.column.Chunk;
import ch.spacebase.openclassic.api.level.generator.biome.Decorator;

public class TreeDecorator implements Decorator {

	@Override
	public void populate(Level level, Chunk chunk, Random random) {
		if(chunk.getY() < 4) return;
		if(random.nextInt(100) <= 30) return;
		int px = random.nextInt(16);
		int pz = random.nextInt(16);
		int py = getHighestWorkableBlock(level, chunk, px, pz);
		px = chunk.getWorldX() + px;
		pz = chunk.getWorldZ() + pz;
		if(py == -1) return;
		this.generateSmallTree(level, chunk, random, px, py, pz);
	}

	private void generateSmallTree(Level level, Chunk c, Random ra, int cx, int cy, int cz) {
		int height = 5 + ra.nextInt(2);
		if (height == 0) return;
		int oneWidth = 1;
		int twoWidth = 2;
		Block b = level.getBlockAt(cx, cy + height, cz);
		b.setType(VanillaBlock.LEAVES);
		b.getRelative(BlockFace.NORTH).setType(VanillaBlock.LEAVES);
		b.getRelative(BlockFace.EAST).setType(VanillaBlock.LEAVES);
		b.getRelative(BlockFace.SOUTH).setType(VanillaBlock.LEAVES);
		b.getRelative(BlockFace.WEST).setType(VanillaBlock.LEAVES);

		for(int k = 1; k <= oneWidth; k++) {
			for(int i = -1; i <= 1; i++) {
				for(int j = -1; j <= 1; j++) {
					Block bc = b.getRelative(i, -k, j);
					if(bc.getType() == VanillaBlock.AIR || bc.getType() == VanillaBlock.LEAVES) {
						bc.setType(VanillaBlock.LEAVES);
					}
				}
			}
		}

		for(int k = oneWidth + 1; k <= oneWidth + twoWidth; k++) {
			for(int i = -2; i <= 2; i++) {
				for(int j = -2; j <= 2; j++) {
					if(!(j == 2 && i == 2) && !(j == -2 && i == 2) && !(j == 2 && i == -2) && !(j == -2 && i == -2)) {
						Block bc = b.getRelative(i, -k, j);
						if(bc.getType() == VanillaBlock.AIR || bc.getType() == VanillaBlock.LEAVES) {
							bc.setType(VanillaBlock.LEAVES);
						}
					}
				}
			}
		}

		for(int i = 0; i < height; i++) {
			b = b.getRelative(BlockFace.DOWN);
			b.setType(VanillaBlock.LOG);
		}
	}

	private int getHighestWorkableBlock(Level level, Chunk c, int px, int pz) {
		int y = c.getWorldY() + 15;
		int pozx = c.getWorldX() + px;
		int pozz = c.getWorldZ() + pz;
		while(level.getBlockTypeAt(pozx, y, pozz) != VanillaBlock.DIRT && level.getBlockTypeAt(pozx, y, pozz) != VanillaBlock.GRASS) {
			y--;
			if(y == 0 || level.getBlockTypeAt(pozx, y, pozz) == VanillaBlock.WATER) {
				return -1;
			}
		}

		y++;
		return y;
	}
}
