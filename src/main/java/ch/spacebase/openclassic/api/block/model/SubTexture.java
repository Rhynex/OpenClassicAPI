package ch.spacebase.openclassic.api.block.model;

public class SubTexture {
	
	private Texture parent;
	private int id;
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public SubTexture(Texture parent, int id, int x, int y, int length) {
		this(parent, id, x, y, length, length);
	}

	public SubTexture(Texture parent, int id, int x, int y, int xLength, int yLength) {
		this.parent = parent;
		this.id = id;
		this.x1 = x;
		this.x2 = x + xLength;
		this.y1 = y;
		this.y2 = y + yLength;
	}

	public int getX1() {
		return this.x1;
	}

	public int getY1() {
		return this.y1;
	}

	public int getX2() {
		return this.x2;
	}

	public int getY2() {
		return this.y2;
	}

	public Texture getParent() {
		return this.parent;
	}

	public int getId() {
		return this.id;
	}
	
}
