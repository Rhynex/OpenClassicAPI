package ch.spacebase.openclassic.api.level.generator.biome;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ch.spacebase.openclassic.api.Position;

public class BiomeMap {

	private final Map<Integer, Biome> map = new HashMap<Integer, Biome>();
	private BiomeSelector selector;

	public Biome getBiomeRaw(int index) {
		return this.map.get(Math.abs(index) % this.map.size());
	}

	public void setSelector(BiomeSelector selector) {
		this.selector = selector;
		selector.parent = this;
	}

	public void addBiome(Biome biome) {
		this.map.put(this.map.size(), biome);
	}

	public Biome getBiome(int x, int z, long seed) {
		return this.getBiome(x, 0, z, seed);
	}

	public Biome getBiome(Position pos, long seed) {
		return this.getBiome(pos.getBlockX(), pos.getBlockY(), pos.getBlockZ(), seed);
	}

	public Biome getBiome(int x, int y, int z, long seed) {
		if(this.selector == null) {
			throw new IllegalStateException("BiomeSelector not set!");
		}
		
		return this.selector.pickBiome(x, y, z, seed);
	}

	public Set<Biome> getBiomes() {
		return new HashSet<Biome>(this.map.values());
	}

	public BiomeSelector getSelector() {
		return selector;
	}

	public int indexOf(Biome biome) {
		for(int index = 0; index < this.map.size(); index++) {
			if(this.map.get(index) == biome) return index;
		}
		
		return -1;
	}
	
}
