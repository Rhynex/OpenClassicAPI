package ch.spacebase.openclassic.api.util;

/**
 * Constant variables used by OpenClassic.
 */
public class Constants {
	
	/**
	 * The server's current version.
	 */
	public static final String SERVER_VERSION = "1.1";
	
	/**
	 * The client's current version.
	 */
	public static final String CLIENT_VERSION = "1.1";
	
	/**
	 * The protocol version.
	 */
	public static final byte PROTOCOL_VERSION = 0x07;
	
	/**
	 * The OpenClassic protocol version.
	 */
	public static final byte OPENCLASSIC_PROTOCOL_VERSION = 1;
	
	/**
	 * Number of ticks per second
	 */
	public static final int TICKS_PER_SECOND = 20;
	
	/**
	 * Number of milliseconds between each tick.
	 */
	public static final int TICK_MILLISECONDS = 1000 / TICKS_PER_SECOND;
	
	/**
	 * Number of milliseconds between each physics tick
	 */
	public static final int PHYSICS_PER_SECOND = 10;
	
	/**
	 * Represents the packet code for a player who isn't an op.
	 */
	public static final byte NOT_OP = 0x00;
	
	/**
	 * Represents the packet code for a player who is an op.
	 */
	public static final byte OP = 0x64;

	/**
	 * The distance between the player's feet and the player's eyes.
	 */
	public static final float FOOT_EYE_DISTANCE = 1.59375f;
	
	/**
	 * The URL of the Minecraft website.
	 */
	public static final String MINECRAFT_URL = "https://minecraft.net/";

	/**
	 * The player's eye height relative to their Y coordinate.
	 */
	public static final float EYE_HEIGHT = 1.62f;
	
	/**
	 * The width of a chunk.
	 */
	public static final int CHUNK_WIDTH = 16;
	
	/**
	 * The height of a chunk.
	 */
	public static final int CHUNK_HEIGHT = 16;
	
	/**
	 * The height of a column.
	 */
	public static final int COLUMN_HEIGHT = 256;
	
	/**
	 * The depth of a chunk.
	 */
	public static final int CHUNK_DEPTH = 16;
	
	/**
	 * The area of a chunk.
	 */
	public static final int CHUNK_AREA = CHUNK_WIDTH * CHUNK_HEIGHT * CHUNK_DEPTH;
	
	/**
	 * Default private constructor
	 */
	private Constants() {
	}
	
}
