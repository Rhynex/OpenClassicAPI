package ch.spacebase.openclassic.api.level.generator.normal.decorator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.column.Chunk;
import ch.spacebase.openclassic.api.level.generator.biome.Decorator;

public class FlowerDecorator implements Decorator {

	private static final List<BlockType> flowers = new ArrayList<BlockType>();

	static {
		flowers.add(VanillaBlock.DANDELION);
		flowers.add(VanillaBlock.ROSE);
	}

	@Override
	public void populate(Level level, Chunk chunk, Random random) {
		if(chunk.getY() < 4) return;
		int total = random.nextInt(15);
		BlockType flower = this.getRandomFlower(random);
		for(int count = 0; count < total; count++) {
			int dx = random.nextInt(16);
			int dz = random.nextInt(16);
			int dy = getHighestWorkableBlock(level, chunk, dx, dz);
			if (dy == -1) continue;
			level.setBlockAt(dx, dy, dz, flower);
		}
	}

	private BlockType getRandomFlower(Random random) {
		int which = random.nextInt(flowers.size());
		return flowers.get(which);
	}

	private int getHighestWorkableBlock(Level level, Chunk c, int px, int pz) {
		int y = 15;
		while(level.getBlockTypeAt(px, y, pz) != VanillaBlock.GRASS) {
			y--;
			if(y == 0 || level.getBlockTypeAt(px, y, pz) == VanillaBlock.WATER) {
				return -1;
			}
		}

		y++;
		return y;
	}
}
