package ch.spacebase.openclassic.api.level.generator.biome;

public abstract class BiomeManager implements Cloneable {
	
	private final int x;
	private final int z;

	public BiomeManager(int x, int z) {
		this.x = x;
		this.z = z;
	}

	public final int getX() {
		return this.x;
	}

	public final int getZ() {
		return this.z;
	}

	public abstract Biome getBiome(int x, int y, int z);

	public abstract byte[] serialize();

	public abstract void deserialize(byte[] bytes);

	@Override
	public abstract BiomeManager clone();
	
}
