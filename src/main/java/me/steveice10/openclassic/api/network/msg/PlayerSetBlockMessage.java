package me.steveice10.openclassic.api.network.msg;

public class PlayerSetBlockMessage extends Message {
	
	private short x;
	private short y;
	private short z;
	private boolean place;
	private byte type;
	
	public PlayerSetBlockMessage(short x, short y, short z, boolean place, byte type) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.place = place;
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
	
	public boolean isPlacing() {
		return place;
	}
	
	public byte getBlock() {
		return this.type;
	}
	
	public String toString() {
		return "PlayerSetBlockMessage{x=" + x + ",y=" + y + ",z=" + z + ",place=" + place + ",block=" + type + "}";
	}
	
}
