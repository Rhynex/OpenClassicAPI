package ch.spacebase.openclassic.api.network.msg;

public class LevelFinalizeMessage extends Message {

	private short width;
	private short height;
	private short depth;
	
	public LevelFinalizeMessage(short width, short height, short depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
	
	public short getWidth() {
		return this.width;
	}
	
	public short getHeight() {
		return this.height;
	}
	
	public short getDepth() {
		return this.depth;
	}
	
	public String toString() {
		return "LevelFinalizeMessage{width=" + width + ",height=" + height + ",depth=" + depth + "}";
	}
	
}
