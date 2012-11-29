package ch.spacebase.openclassic.api.level.column;

import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.level.generator.biome.Biome;
import ch.spacebase.openclassic.api.util.storage.BlockStore;

public interface Chunk {

	public Column getColumn();
	
	public int getX();
	
	public int getY();
	
	public int getZ();
	
	public int getWorldX();
	
	public int getWorldY();
	
	public int getWorldZ();
	
	public Block getBlock(int x, int y, int z);
	
	public Block getBlockRelative(int x, int y, int z);
	
	public byte getBlockAt(int x, int y, int z);
	
	public byte getData(int x, int y, int z);
	
	public void setBlockAt(int x, int y, int z, BlockType type);
	
	public int blockIndex(int x, int y, int z);
	
	public BlockStore getBlockStore();
	
	/**
	 * Gets the biome at the given coordinates.
	 * @param x X to get the biome at.
	 * @param y Y to get the biome at.
	 * @param z Z to get the biome at.
	 * @return The biome at the given coordinates.
	 */
	public Biome getBiome(int x, int y, int z);
	
}
