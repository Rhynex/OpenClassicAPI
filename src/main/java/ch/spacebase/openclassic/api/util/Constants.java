package ch.spacebase.openclassic.api.util;

/**
 * Constant variables used by OpenClassic.
 */
public class Constants {
	
	/**
	 * The server's current version.
	 */
	public static final String VERSION = "0.1";
	
	/**
	 * The server's protocol version.
	 */
	public static final byte PROTOCOL_VERSION = 0x07;
	
	/**
	 * Number of milliseconds between each tick
	 */
	public static final int TICK_MILLISECONDS = 50;
	
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
