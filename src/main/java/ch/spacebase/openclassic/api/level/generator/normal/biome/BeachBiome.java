package ch.spacebase.openclassic.api.level.generator.normal.biome;

import java.util.Random;

import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.generator.biome.Biome;
import ch.spacebase.openclassic.api.util.storage.BlockStore;

public class BeachBiome extends Biome {

	public BeachBiome() {
		super(8);
	}

	@Override
	public void generateColumn(Level level, int x, int y, int z, BlockStore blockData, Random random) {
		int height = 64;
		for(int dy = y; dy < y + 16; dy++) {
			blockData.set(x, dy, z, this.getBlock(height, dy));
		}
	}

	@Override
	public String getName() {
		return "Beach";
	}

	protected BlockType getBlock(int top, int dy) {
		BlockType ret;
		if (dy > top) {
			ret = VanillaBlock.AIR;
		} else if (dy == top) {
			ret = VanillaBlock.SAND;
		} else if (dy + 4 >= top) {
			ret = VanillaBlock.DIRT;
		} else if (dy != 0) {
			ret = VanillaBlock.STONE;
		} else {
			ret = VanillaBlock.BEDROCK;
		}

		return ret;
	}

}
