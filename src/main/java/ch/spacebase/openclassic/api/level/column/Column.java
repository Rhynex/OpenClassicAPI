package ch.spacebase.openclassic.api.level.column;

import java.util.List;

import ch.spacebase.openclassic.api.level.Level;

public interface Column {

	public Level getLevel();
	
	public int getX();
	
	public int getZ();
	
	public int getWorldX();
	
	public int getWorldZ();
	
	public byte getBlockAt(int x, int y, int z);
	
	public void setBlockAt(int x, int y, int z, byte id);
	
	public int getHighestOpaque(int x, int z);
	
	public boolean isLit(int x, int y, int z);
	
	public float getBrightness(int x, int y, int z);
	
	public Chunk getChunk(int y);
	
	public Chunk getChunkFromBlock(int y);
	
	public List<? extends Chunk> getChunks();
	
	public void save();
	
}
