package ch.spacebase.openclassic.api.level.generator.normal.decorator;

import java.util.Random;

import net.royawesome.jlibnoise.NoiseQuality;
import net.royawesome.jlibnoise.module.source.Perlin;

import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.column.Chunk;
import ch.spacebase.openclassic.api.level.generator.biome.Decorator;

public class CaveDecorator implements Decorator {
	private Perlin noise = new Perlin();

	public CaveDecorator() {
		this.noise.setNoiseQuality(NoiseQuality.BEST);
		this.noise.setOctaveCount(8);
		this.noise.setFrequency(2);
	}

	@Override
	public void populate(Level level, Chunk chunk, Random random) {
		this.noise.setSeed((int) level.getSeed());
		int x = chunk.getWorldX();
		int y = chunk.getWorldY();
		int z = chunk.getWorldZ();
		int px = x + random.nextInt(16);
		int py = y + random.nextInt(16);
		int pz = z + random.nextInt(16);
		for(int dx = x; dx < x + 16; dx++) {
			for(int dz = z; dz < z + 16; dz++) {
				for(int dy = y; dy < y + 16; dy++) {
					if(Math.sqrt(Math.pow(dx - px, 2) + Math.pow(dy - py, 2) + Math.pow(dz - pz, 2)) > 6) {
						continue;
					}

					if(this.noise.GetValue(dx / 5.0 + 0.005, dy / 5.0 + 0.005, dz / 5.0 + 0.005) > 0 && level.getBlockTypeAt(dx, dy, dz) == VanillaBlock.STONE) {
						level.setBlockAt(dx, dy, dz, VanillaBlock.AIR);
					}
				}
			}
		}
	}
}
