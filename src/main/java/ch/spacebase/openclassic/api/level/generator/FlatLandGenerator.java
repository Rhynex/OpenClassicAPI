package ch.spacebase.openclassic.api.level.generator;

import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.util.Constants;

/**
 * Generates a flat map.
 */
public class FlatLandGenerator extends Generator {
	
	@Override
	public void generate(long seed, int x, int y, int z, byte blocks[]) {
		this.rand.setSeed(seed);
		for(int xx = x; xx <= x + Constants.CHUNK_WIDTH; xx++) {
			for(int yy = y; yy <= y + Constants.CHUNK_HEIGHT; yy++) {
				for(int zz = z; zz <= z + Constants.CHUNK_DEPTH; zz++) {
					if(yy <= 1) {
						blocks[coordsToBlockIndex(xx, yy, zz)] = VanillaBlock.BEDROCK.getId();
					} else if(yy <= Constants.COLUMN_HEIGHT / 2 - 4) {
						blocks[coordsToBlockIndex(xx, yy, zz)] = VanillaBlock.STONE.getId();
					} else if(yy <= Constants.COLUMN_HEIGHT / 2 - 1) {
						blocks[coordsToBlockIndex(xx, yy, zz)] = VanillaBlock.DIRT.getId();
					} else if(yy == Constants.COLUMN_HEIGHT / 2) {
						blocks[coordsToBlockIndex(xx, yy, zz)] = VanillaBlock.GRASS.getId();
					}
				}
			}
		}
	}

	@Override
	public String getName() {
		return "flat";
	}

}
