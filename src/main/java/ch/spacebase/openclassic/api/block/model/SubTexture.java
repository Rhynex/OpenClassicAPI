package ch.spacebase.openclassic.api.block.model;

/**
 * Represents a part of a bigger texture.
 */
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

	/**
	 * Gets the X of the SubTexture's first point.
	 * @return The X of the first point.
	 */
	public int getX1() {
		return this.x1;
	}

	/**
	 * Gets the Y of the SubTexture's first point.
	 * @return The Y of the first point.
	 */
	public int getY1() {
		return this.y1;
	}

	/**
	 * Gets the X of the SubTexture's second point.
	 * @return The X of the second point.
	 */
	public int getX2() {
		return this.x2;
	}

	/**
	 * Gets the Y of the SubTexture's second point.
	 * @return The Y of the second point.
	 */
	public int getY2() {
		return this.y2;
	}

	/**
	 * Gets the parent this SubTexture belongs to.
	 * @return The SubTexture's parent.
	 */
	public Texture getParent() {
		return this.parent;
	}

	/**
	 * Gets the texture ID of this SubTexture.
	 * @return The SubTexture's texture ID.
	 */
	public int getId() {
		return this.id;
	}
	
}
