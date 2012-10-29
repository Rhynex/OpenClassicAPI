package ch.spacebase.openclassic.api.level.generator.normal.biome;

import java.util.Random;

import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.generator.biome.Biome;
import ch.spacebase.openclassic.api.level.generator.normal.decorator.BeachDecorator;
import ch.spacebase.openclassic.api.util.storage.BlockStore;

import net.royawesome.jlibnoise.NoiseQuality;
import net.royawesome.jlibnoise.module.modifier.Turbulence;
import net.royawesome.jlibnoise.module.source.Perlin;

public class OceanBiome extends Biome {

	private Perlin base = new Perlin();
	private Turbulence noise = new Turbulence();

	public OceanBiome() {
		super(0, new BeachDecorator());
		this.base.setNoiseQuality(NoiseQuality.BEST);
		this.base.setOctaveCount(6);
		this.base.setFrequency(0.3);
		this.base.setPersistence(0.12);
		this.base.setLacunarity(0.5);
		this.noise.SetSourceModule(0, this.base);
		this.noise.setFrequency(0.3);
		this.noise.setRoughness(2);
		this.noise.setPower(0.5);
	}

	@Override
	public void generateColumn(Level level, int x, int y, int z, BlockStore blockData, Random random) {
		this.base.setSeed((int) level.getSeed());
		this.noise.setSeed((int) level.getSeed());
		int height = (int) ((this.noise.GetValue(x / 16.0 + 0.005, 0.05, z / 16.0 + 0.005) + 1.0) * 4.0 + 4);
		for(int dy = y; dy < y + 16; dy++) {
			if (dy >= 63 || dy < 0) continue;
			blockData.set(x, dy, z, this.getBlockByLayer(height, dy));
		}
	}

	protected BlockType getBlockByLayer(int top, int dy) {
		BlockType type;
		if (dy >= top) {
			type = VanillaBlock.WATER;
		} else if (dy + 4 >= top) {
			type = VanillaBlock.SAND;
		} else if (dy + 7 >= top) {
			type = VanillaBlock.DIRT;
		} else if (dy > 0) {
			type = VanillaBlock.STONE;
		} else {
			type = VanillaBlock.BEDROCK;
		}

		return type;
	}

	@Override
	public String getName() {
		return "Ocean";
	}

}
