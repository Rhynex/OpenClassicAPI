package ch.spacebase.openclassic.api.level.generator.biome;

public class Biomes {

	private static final Biome[] biomes = new Biome[256];

	protected static void register(Biome biome) {
		biomes[biome.getId()] = biome;
	}

	public static Biome getBiome(int id) {
		return biomes[id];
	}

}
