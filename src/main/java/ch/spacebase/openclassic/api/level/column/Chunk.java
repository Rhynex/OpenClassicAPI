package ch.spacebase.openclassic.api.level.column;

import ch.spacebase.openclassic.api.level.generator.biome.Biome;

public interface Chunk {

	public Column getColumn();
	
	public int getX();
	
	public int getY();
	
	public int getZ();
	
	public int getWorldX();
	
	public int getWorldY();
	
	public int getWorldZ();
	
	public byte getBlockAt(int x, int y, int z);
	
	public void setBlockAt(int x, int y, int z, byte id);
	
	public int blockIndex(int x, int y, int z);
	
	/**
	 * Gets the biome at the given coordinates.
	 * @param x X to get the biome at.
	 * @param y Y to get the biome at.
	 * @param z Z to get the biome at.
	 * @return The biome at the given coordinates.
	 */
	public Biome getBiome(int x, int y, int z);
	
}
