package ch.spacebase.openclassic.api.level.generator.biome;

public abstract class BiomeSelector {

	protected BiomeMap parent;

	public final Biome pickBiome(int x, int z, long seed) {
		return this.pickBiome(x, 0, z, seed);
	}

	public abstract Biome pickBiome(int x, int y, int z, long seed);
	
}
