package ch.spacebase.openclassic.api.util;

/**
 * Constant variables used by OpenClassic.
 */
public class Constants {
	
	/**
	 * OpenClassic's current version.
	 */
	public static final String VERSION = "1.2.9";
	
	/**
	 * The protocol version.
	 */
	public static final byte PROTOCOL_VERSION = 7;
	
	/**
	 * The OpenClassic protocol version.
	 */
	public static final byte OPENCLASSIC_PROTOCOL_VERSION = 5;
	
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
	 * The URL of the Minecraft website using https.
	 */
	public static final String MINECRAFT_URL_HTTPS = "https://minecraft.net/";
	
	/**
	 * The URL of the Minecraft website using http.
	 */
	public static final String MINECRAFT_URL_HTTP = "http://minecraft.net/";
	
	/**
	 * Default private constructor
	 */
	private Constants() {
	}
	
}
