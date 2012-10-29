package ch.spacebase.openclassic.api.level.generator.biome;

import ch.spacebase.openclassic.api.util.Constants;

public class Simple2DBiomeManager extends BiomeManager {

	private byte[] biomes = new byte[Constants.CHUNK_AREA];

	public Simple2DBiomeManager(int x, int z) {
		super(x, z);
	}

	@Override
	public Biome getBiome(int x, int y, int z) {
		x &= 0xf;
		z &= 0xf;
		return Biomes.getBiome(this.biomes[z << 4 | x]);
	}

	@Override
	public byte[] serialize() {
		byte[] data = new byte[Constants.CHUNK_AREA];
		System.arraycopy(this.biomes, 0, data, 0, this.biomes.length);
		return data;
	}

	@Override
	public void deserialize(byte[] bytes) {
		this.biomes = bytes;
	}

	@Override
	public Simple2DBiomeManager clone() {
		Simple2DBiomeManager manager = new Simple2DBiomeManager(this.getX(), this.getZ());
		manager.deserialize(this.serialize());
		return manager;
	}

}
