package me.steveice10.openclassic.api.block;

public enum BlockFace {

	UP(0, 1, 0),
	DOWN(0, -1, 0),
	NORTH(1, 0, 0),
	SOUTH(-1, 0, 0),
	EAST(0, 0, 1),
	WEST(0, 0, -1);
	
	private int modx;
	private int mody;
	private int modz;
	
	private BlockFace(int modx, int mody, int modz) {
		this.modx = modx;
		this.mody = mody;
		this.modz = modz;
	}
	
	public int getModX() {
		return this.modx;
	}
	
	public int getModY() {
		return this.mody;
	}
	
	public int getModZ() {
		return this.modz;
	}
	
}
