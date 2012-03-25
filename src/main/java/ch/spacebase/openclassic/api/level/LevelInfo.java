package ch.spacebase.openclassic.api.level;

import ch.spacebase.openclassic.api.Position;

public class LevelInfo {

	private String name;
	private Position spawn;
	private short width;
	private short height;
	private short depth;
	
	public LevelInfo(String name, Position spawn, short width, short height, short depth) {
		this.name = name;
		this.spawn = spawn;
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Position getSpawn() {
		return this.spawn;
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
	
}
