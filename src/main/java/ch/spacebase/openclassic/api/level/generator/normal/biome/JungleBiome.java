package ch.spacebase.openclassic.api.level.generator.normal.biome;

import java.util.Random;

import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.generator.biome.Biome;
import ch.spacebase.openclassic.api.level.generator.normal.decorator.ShrubDecorator;
import ch.spacebase.openclassic.api.level.generator.normal.decorator.TreeDecorator;
import ch.spacebase.openclassic.api.util.storage.BlockStore;

public class JungleBiome extends Biome {

	public JungleBiome() {
		super(10, new TreeDecorator(), new ShrubDecorator());
	}

	@Override
	public void generateColumn(Level level, int x, int y, int z, BlockStore blockData, Random random) {
		int height = 66;
		for(int dy = y; dy < y + 16; dy++) {
			blockData.set(x, dy, z, this.getBlock(height, dy));
		}
	}

	@Override
	public String getName() {
		return "Jungle";
	}

	protected BlockType getBlock(int top, int dy) {
		BlockType type;
		if (dy > top) {
			type = VanillaBlock.AIR;
		} else if (dy == top) {
			type = VanillaBlock.GRASS;
		} else if (dy + 4 >= top) {
			type = VanillaBlock.DIRT;
		} else if (dy != 0) {
			type = VanillaBlock.STONE;
		} else {
			type = VanillaBlock.BEDROCK;
		}

		return type;
	}

}
