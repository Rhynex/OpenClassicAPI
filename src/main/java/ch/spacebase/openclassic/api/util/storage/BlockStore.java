package ch.spacebase.openclassic.api.util.storage;

import ch.spacebase.openclassic.api.block.BlockType;

public class BlockStore {

	private byte blocks[];
	private byte data[];
	private int width;
	private int height;
	private int depth;

	public BlockStore(int width, int height, int depth) {
		this.blocks = new byte[width * height * depth];
		this.data = new byte[width * height * depth];
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
	
	public byte[] getBlocks() {
		return this.blocks;
	}
	
	public byte[] getData() {
		return this.data;
	}
	
	public void setBlocks(byte blocks[]) {
		this.blocks = blocks;
	}
	
	public void setData(byte data[]) {
		this.data = data;
	}

	public byte getBlock(int x, int y, int z) {
		return this.blocks[index(x, y, z)];
	}

	public byte getData(int x, int y, int z) {
		return this.data[index(x, y, z)];
	}

	public void set(int x, int y, int z, byte block, byte data) {
		data &= 0xf;
		//this.store[index(x, y, z)] = pack(block, data);
		this.blocks[index(x, y, z)] = block;
		this.data[index(x, y, z)] = data;
	}
	
	public void set(int x, int y, int z, BlockType type) {
		this.set(x, y, z, type.getId(), type.getData());
	}

	public int index(int x, int y, int z) {
		x &= this.width - 1;
		y &= this.height - 1;
		z &= this.depth - 1;
		return (x * this.width + y) * this.depth + z;
	}
	
}
