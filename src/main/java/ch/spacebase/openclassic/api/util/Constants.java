package ch.spacebase.openclassic.api.util;

/**
 * Constant variables used by OpenClassic.
 */
public class Constants {
	
	/**
	 * The server's current version.
	 */
	public static final String SERVER_VERSION = "1.0.3";
	
	/**
	 * The client's current version.
	 */
	public static final String CLIENT_VERSION = "1.0.10";
	
	/**
	 * The server's protocol version.
	 */
	public static final byte PROTOCOL_VERSION = 0x07;
	
	/**
	 * Number of ticks per second
	 */
	public static final int TICKS_PER_SECOND = 20;
	
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
	 * Default private constructor
	 */
	private Constants() {
	}
	
}
