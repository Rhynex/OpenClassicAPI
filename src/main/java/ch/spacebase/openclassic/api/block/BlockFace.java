package ch.spacebase.openclassic.api.block;

/**
 * Represents the faces of a block.
 */
public enum BlockFace {

	/** The upper face. */
	UP(0, 1, 0, 1),
	/** The lower face. */
	DOWN(0, -1, 0, 0),
	/** The northern face. */
	NORTH(-1, 0, 0, 3),
	/** The southern face. */
	SOUTH(1, 0, 0, 2),
	/** The eastern face. */
	EAST(0, 0, -1, 5),
	/** The western face. */
	WEST(0, 0, 1, 4);
	
	private static final BlockFace nsew[] = new BlockFace[] { NORTH, SOUTH, EAST, WEST };
	
	private int modx;
	private int mody;
	private int modz;
	private int inverted;
	
	private BlockFace(int modx, int mody, int modz, int inverted) {
		this.modx = modx;
		this.mody = mody;
		this.modz = modz;
		this.inverted = inverted;
	}
	
	/**
	 * Gets the X shift of this face from a block.
	 * @return The X shift.
	 */
	public int getModX() {
		return this.modx;
	}
	
	/**
	 * Gets the Y shift of this face from a block.
	 * @return The Y shift.
	 */
	public int getModY() {
		return this.mody;
	}
	
	/**
	 * Gets the Z shift of this face from a block.
	 * @return The Z shift.
	 */
	public int getModZ() {
		return this.modz;
	}
	
	/**
	 * Gets the inverse of this face.
	 * @return The inverse of this face.
	 */
	public BlockFace invert() {
		return values()[this.inverted];
	}
	
	/**
	 * Gets an array containing the north, south, east, and west faces.
	 * @return The array containing the faces.
	 */
	public static BlockFace[] nsew() {
		return nsew;
	}
	
}
