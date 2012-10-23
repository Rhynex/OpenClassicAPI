package ch.spacebase.openclassic.api.level.generator.biome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.generator.Generator;
import ch.spacebase.openclassic.api.level.generator.Populator;
import ch.spacebase.openclassic.api.util.Constants;
import ch.spacebase.openclassic.api.util.storage.TripleIntByteArray;

public abstract class BiomeGenerator extends Generator {
	
	protected final BiomeMap biomes = new BiomeMap();
	private final List<Populator> populators = new ArrayList<Populator>();

	public BiomeGenerator() {
		this.registerBiomes();
		for(Populator populator : this.populators) {
			if(populator instanceof BiomePopulator) return;
		}
		
		this.populators.add(new BiomePopulator());
	}

	public abstract void registerBiomes();

	protected void setSelector(BiomeSelector selector) {
		this.biomes.setSelector(selector);
	}

	public BiomeSelector getSelector() {
		return this.biomes.getSelector();
	}

	public void register(Biome biome) {
		this.biomes.addBiome(biome);
	}

	@Override
	public void generate(Level level, int x, int y, int z, TripleIntByteArray blocks, Random rand) {
		this.generate(level, x, y, z, level.getBiomeManager(x, z, true), blocks, rand);
	}

	public BiomeManager generateBiomes(Level level, int x, int z) {
		final Simple2DBiomeManager manager = new Simple2DBiomeManager(x, z);
		byte[] biomeData = new byte[Constants.CHUNK_AREA];
		for(int xx = x; xx < x + Constants.CHUNK_WIDTH; ++xx) {
			for(int zz = z; zz < z + Constants.CHUNK_DEPTH; ++zz) {
				biomeData[(zz & 0xf) << 4 | (xx & 0xf)] = (byte) this.biomes.getBiome(xx, zz, level.getSeed()).getId();
			}
		}
		
		manager.deserialize(biomeData);
		return manager;
	}

	protected abstract void generate(Level level, int x, int y, int z, BiomeManager manager, TripleIntByteArray blocks, Random rand);

	@Override
	public List<Populator> getPopulators(Level level) {
		return this.populators;
	}

	public void addPopulators(Populator... p) {
		this.populators.addAll(Arrays.asList(p));
	}

	public Biome getBiome(int x, int y, int z, long seed) {
		return biomes.getBiome(x, y, z, seed);
	}

	public Biome getBiome(int x, int z, long seed) {
		return biomes.getBiome(x, z, seed);
	}

	public Set<Biome> getBiomes() {
		return biomes.getBiomes();
	}

	public BiomeMap getBiomeMap() {
		return biomes;
	}

	public int indexOf(Biome biome) {
		return biomes.indexOf(biome);
	}
	
}
