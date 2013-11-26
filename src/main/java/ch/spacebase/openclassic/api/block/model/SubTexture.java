package ch.spacebase.openclassic.api.block.model;

/**
 * Represents a part of a bigger texture.
 */
public class SubTexture implements Cloneable {
	
	private Texture parent;
	private float x;
	private float y;
	private float width;
	private float height;

	public SubTexture(Texture parent, float x, float y, float length) {
		this(parent, x, y, length, length);
	}

	public SubTexture(Texture parent, float x, float y, float xLength, float yLength) {
		this.parent = parent;
		this.x = x;
		this.y = y;
		this.width = xLength;
		this.height = yLength;
	}

	/**
	 * Gets the X of the SubTexture's first point.
	 * @return The X of the first point.
	 */
	public float getX1() {
		return this.x;
	}

	/**
	 * Gets the Y of the SubTexture's first point.
	 * @return The Y of the first point.
	 */
	public float getY1() {
		return this.y;
	}

	/**
	 * Gets the X of the SubTexture's second point.
	 * @return The X of the second point.
	 */
	public float getX2() {
		return this.x + this.width;
	}

	/**
	 * Gets the Y of the SubTexture's second point.
	 * @return The Y of the second point.
	 */
	public float getY2() {
		return this.y + this.height;
	}
	
	/**
	 * Gets the width of the SubTexture.
	 * @return The SubTexture's width.
	 */
	public float getWidth() {
		return this.width;
	}

	/**
	 * Gets the height of the SubTexture.
	 * @return The SubTexture's height.
	 */
	public float getHeight() {
		return this.height;
	}

	/**
	 * Gets the parent this SubTexture belongs to.
	 * @return The SubTexture's parent.
	 */
	public Texture getParent() {
		return this.parent;
	}
	
	public SubTexture clone() {
		return new SubTexture(this.parent, this.x, this.y, this.width, this.height);
	}
	
	@Override
	public String toString() {
		return "SubTexture{parent=" + this.parent.getTexture() + ",x=" + this.x + ",y=" + this.y + ",xLength=" + this.width + ",yLength=" + this.height + "}";
	}
	
}
