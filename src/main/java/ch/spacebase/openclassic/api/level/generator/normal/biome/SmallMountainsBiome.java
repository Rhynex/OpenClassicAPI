package ch.spacebase.openclassic.api.level.generator.normal.biome;

import java.util.Random;

import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.generator.biome.Biome;
import ch.spacebase.openclassic.api.level.generator.normal.decorator.CaveDecorator;
import ch.spacebase.openclassic.api.level.generator.normal.decorator.FlowerDecorator;
import ch.spacebase.openclassic.api.level.generator.normal.decorator.OreDecorator;
import ch.spacebase.openclassic.api.level.generator.normal.decorator.TreeDecorator;
import ch.spacebase.openclassic.api.util.storage.BlockStore;
import net.royawesome.jlibnoise.NoiseQuality;
import net.royawesome.jlibnoise.module.source.RidgedMulti;

public class SmallMountainsBiome extends Biome {

	private RidgedMulti noise = new RidgedMulti();

	public SmallMountainsBiome() {
		super(9, new FlowerDecorator(), new TreeDecorator(), new CaveDecorator(), new OreDecorator());
		this.noise.setNoiseQuality(NoiseQuality.BEST);
		this.noise.setOctaveCount(10);
		this.noise.setFrequency(0.4);
		this.noise.setLacunarity(0.10);
	}

	@Override
	public void generateColumn(Level level, int x, int y, int z, BlockStore blockData, Random random) {
		this.noise.setSeed((int) level.getSeed());
		int height = (int) ((this.noise.GetValue(x / 16.0 + 0.005, 0.05, z / 16.0 + 0.005) + 1.0) * 5.0 + 60.0);
		for(int dy = y; dy < y + 16; dy++) {
			blockData.set(x, dy, z, this.getBlock(height, dy));
		}
	}

	@Override
	public String getName() {
		return "Small Mountains";
	}

	protected BlockType getBlock(int top, int dy) {
		BlockType type;
		if (dy > top) {
			type = VanillaBlock.AIR;
		} else if (dy == top && dy >= 63) {
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
