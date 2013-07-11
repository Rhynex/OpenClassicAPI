package ch.spacebase.openclassic.api.level.column;

import java.util.List;

import ch.spacebase.openclassic.api.Position;
import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.block.complex.ComplexBlock;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.generator.biome.BiomeManager;

public interface Column {

	public Level getLevel();
	
	public int getX();
	
	public int getZ();
	
	public int getWorldX();
	
	public int getWorldZ();
	
	public Block getBlock(int x, int y, int z);
	
	public Block getBlockRelative(int x, int y, int z);
	
	public byte getBlockAt(int x, int y, int z);
	
	public byte getData(int x, int y, int z);
	
	public void setBlockAt(int x, int y, int z, BlockType type);
	
	public int getHighestOpaque(int x, int z);
	
	public boolean isLit(int x, int y, int z);
	
	public float getBrightness(int x, int y, int z);
	
	public Chunk getChunk(int y);
	
	public Chunk getChunkFromBlock(int y);
	
	public List<Chunk> getChunks();
	
	public void save();
	
	public BiomeManager getBiomeManager();
	
	public void setBiomeManager(BiomeManager manager);
	
	/**
	 * Checks whether there is a complex block at the given position.
	 * @param pos Position of the block.
	 * @return Whether the block is complex.
	 */
	public boolean isComplex(Position pos);
	
	/**
	 * Checks whether there is a complex block at the given coordinates.
	 * @param x X of the block.
	 * @param y Y of the block.
	 * @param z Z of the block.
	 * @return Whether the block is complex.
	 */
	public boolean isComplex(int x, int y, int z);
	
	/**
	 * Gets the complex block at the given position.
	 * @param pos Position of the block.
	 * @return The complex block at the given position.
	 */
	public ComplexBlock getComplexBlock(Position pos);
	
	/**
	 * Gets the complex block at the given coordinates.
	 * @param x X of the block.
	 * @param y Y of the block.
	 * @param z Z of the block.
	 * @return The complex block at the given coordinates.
	 */
	public ComplexBlock getComplexBlock(int x, int y, int z);
	
	/**
	 * Sets the complex block at the given position.
	 * @param pos Position of the block.
	 * @param complex The new complex block to set.
	 */
	public void setComplexBlock(Position pos, ComplexBlock complex);
	
	/**
	 * Sets the complex block at the given coordinates.
	 * @param x X of the block.
	 * @param y Y of the block.
	 * @param z Z of the block.
	 * @param complex The new complex block to set.
	 */
	public void setComplexBlock(int x, int y, int z, ComplexBlock complex);
	
}
