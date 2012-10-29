package ch.spacebase.openclassic.api.level.generator.normal;

import java.util.Random;

import ch.spacebase.openclassic.api.Position;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.generator.VanillaBiome;
import ch.spacebase.openclassic.api.level.generator.biome.BiomeGenerator;
import ch.spacebase.openclassic.api.level.generator.biome.BiomeManager;
import ch.spacebase.openclassic.api.level.generator.normal.populator.SmoothPopulator;
import ch.spacebase.openclassic.api.level.generator.selector.DefaultSelector;
import ch.spacebase.openclassic.api.util.storage.BlockStore;

public class NormalGenerator extends BiomeGenerator {

	@Override
	public void registerBiomes() {
		this.setSelector(new DefaultSelector(2.0, 2.0, 0.35, 0.05, false));
		this.register(VanillaBiome.OCEAN);
		this.register(VanillaBiome.PLAIN);
		this.register(VanillaBiome.DESERT);
		this.register(VanillaBiome.MOUNTAINS);
		this.register(VanillaBiome.FOREST);
		this.register(VanillaBiome.TAIGA);
		this.register(VanillaBiome.SWAMP);
		this.register(VanillaBiome.BEACH);
		this.register(VanillaBiome.SMALL_MOUNTAINS);
		this.register(VanillaBiome.JUNGLE);
		this.addPopulators(new SmoothPopulator());
	}

	@Override
	public String getName() {
		return "VanillaNormal";
	}

	@Override
	protected void generate(Level level, int x, int y, int z, BiomeManager manager, BlockStore blocks, Random rand) {
	}
	
	@Override
	public Position findInitialSpawn(Level level) {
		Random rand = new Random(level.getSeed());
		int x = rand.nextInt(2000);
		int z = rand.nextInt(2000);
		while(this.getSelector().pickBiome(x, z, level.getSeed()) == VanillaBiome.OCEAN) {
			x = rand.nextInt(2000);
			z = rand.nextInt(2000);
		}
		
		return new Position(level, x, 256, z);
	}

}
