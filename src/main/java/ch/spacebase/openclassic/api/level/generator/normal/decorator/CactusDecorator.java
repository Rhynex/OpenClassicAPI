package ch.spacebase.openclassic.api.level.generator.normal.decorator;

import java.util.Random;

import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.column.Chunk;
import ch.spacebase.openclassic.api.level.generator.biome.Decorator;
import ch.spacebase.openclassic.api.util.Constants;

public class CactusDecorator implements Decorator {

	@Override
	public void populate(Level level, Chunk chunk, Random random) {
		if(chunk.getY() < 4) return;
		if(random.nextInt(100) <= 50) return;
		int px = random.nextInt(16);
		int pz = random.nextInt(16);
		int py = this.getHighestWorkableBlock(level, chunk, px, pz);
		px = chunk.getWorldX() + px;
		pz = chunk.getWorldZ() + pz;
		if(py == -1) return;
		int height = random.nextInt(3) + 1;
		for(int y = py; y < py + height; y++) {
			level.setBlockAt(px, y, pz, VanillaBlock.CACTUS);
		}
	}

	private int getHighestWorkableBlock(Level level, Chunk c, int px, int pz) {
		int y = Constants.COLUMN_HEIGHT;
		int pozx = c.getWorldX() + px;
		int pozz = c.getWorldZ() + pz;
		while(level.getBlockTypeAt(pozx, y, pozz) != VanillaBlock.SAND && level.getBlockTypeAt(pozx, y, pozz) != VanillaBlock.SANDSTONE) {
			y--;
			if(y == 0 || level.getBlockTypeAt(pozx, y, pozz) == VanillaBlock.WATER) {
				return -1;
			}
		}

		y++;
		return y;
	}
}
