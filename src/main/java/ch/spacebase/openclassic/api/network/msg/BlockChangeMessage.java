package ch.spacebase.openclassic.api.network.msg;

public class BlockChangeMessage extends Message {
	
	private short x;
	private short y;
	private short z;
	private byte type;
	
	public BlockChangeMessage(short x, short y, short z, byte type) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.type = type;
	}
	
	public short getX() {
		return this.x;
	}
	
	public short getY() {
		return this.y;
	}
	
	public short getZ() {
		return this.z;
	}
	
	public byte getBlock() {
		return this.type;
	}
	
	public String toString() {
		return "BlockChangeMessage{x=" + x + ",y=" + y + ",z=" + z + ",block=" + type + "}";
	}
	
}
