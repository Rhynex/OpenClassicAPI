package ch.spacebase.openclassic.api.level.generator.biome;

public class EmptyBiomeManager extends BiomeManager {

	public EmptyBiomeManager(int x, int z) {
		super(x, z);
	}
	
	@Override
	public Biome getBiome(int x, int y, int z) {
		return null;
	}

	@Override
	public byte[] serialize() {
		return null;
	}

	@Override
	public void deserialize(byte[] bytes) {
	}

	@Override
	public EmptyBiomeManager clone() {
		return new EmptyBiomeManager(this.getX(), this.getZ());
	}

}
