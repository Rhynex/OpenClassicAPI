package ch.spacebase.openclassic.api.level.column;

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
	
}
