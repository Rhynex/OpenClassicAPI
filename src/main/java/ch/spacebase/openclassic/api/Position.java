package ch.spacebase.openclassic.api;

import ch.spacebase.openclassic.api.level.Level;

/**
 * Represents a point in a world.
 */
public class Position implements Cloneable {

	private Level level;
	private double x;
	private double y;
	private double z;
	private byte yaw;
	private byte pitch;
	
	public Position(Level level, double x, double y, double z) {
		this(level, x, y, z, (byte) 0, (byte) 0);
	}
	
	public Position(Level level, double x, double y, double z, byte yaw, byte pitch) {
		this.level = level;
		this.x = x;
		this.y = y;
		this.z = z;
		this.yaw = yaw;
		this.pitch = pitch;
	}
	
	/**
	 * Gets the level this position is located in.
	 * @return The level.
	 */
	public Level getLevel() {
		return this.level;
	}
	
	/**
	 * Gets the X coordinate of this position.
	 * @return The X coordinate.
	 */
	public double getX() {
		return this.x;
	}
	
	/**
	 * Gets the Y coordinate of this position.
	 * @return The Y coordinate.
	 */
	public double getY() {
		return this.y;
	}
	
	/**
	 * Gets the Z coordinate of this position.
	 * @return The Z coordinate.
	 */
	public double getZ() {
		return this.z;
	}
	
	/**
	 * Gets the X coordinate of the block at this position.
	 * @return The block's X coordinate.
	 */
	public int getBlockX() {
		return (int) Math.floor(this.getX());
	}
	
	/**
	 * Gets the Y coordinate of the block at this position.
	 * @return The block's Y coordinate.
	 */
	public int getBlockY() {
		return (int) Math.floor(this.getY());
	}
	
	/**
	 * Gets the Z coordinate of the block at this position.
	 * @return The block's Z coordinate.
	 */
	public int getBlockZ() {
		return (int) Math.floor(this.getZ());
	}
	
	/**
	 * Gets the yaw of this position.
	 * @return The yaw coordinate.
	 */
	public byte getYaw() {
		return this.yaw;
	}
	
	/**
	 * Gets the pitch of this position.
	 * @return The pitch.
	 */
	public byte getPitch() {
		return this.pitch;
	}
	
	/**
	 * Sets the level this position is located in.
	 * @param The level.
	 */
	public void setLevel(Level level) {
		this.level = level;
	}
	
	/**
	 * Sets the X coordinate of this position.
	 * @param The X coordinate.
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * Sets the Y coordinate of this position.
	 * @param The Y coordinate.
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * Sets the Z coordinate of this position.
	 * @param The Z coordinate.
	 */
	public void setZ(double z) {
		this.z = z;
	}
	
	/**
	 * Sets the yaw of this position.
	 * @param The yaw.
	 */
	public void setYaw(byte yaw) {
		this.yaw = yaw;
	}
	
	/**
	 * Sets the pitch of this position.
	 * @param The pitch.
	 */
	public void setPitch(byte pitch) {
		this.pitch = pitch;
	}
	
	/**
	 * Adds the specified position's coordinates to this position's coordinates.
	 */
	public Position add(Position pos) {
		return this.add(pos.getX(), pos.getY(), pos.getZ());
	}
	
	/**
	 * Adds the specified coordinates to this position's coordinates.
	 */
	public Position add(double x, double y, double z) {
		this.x += x;
		this.y += y;
		this.z += z;
		
		return this;
	}
	
	/**
	 * Subtracts the specified position's coordinates from this position's coordinates.
	 */
	public Position subtract(Position pos) {
		return this.subtract(pos.getX(), pos.getY(), pos.getZ());
	}
	
	/**
	 * Subtracts the specified coordinates from this position's coordinates.
	 */
	public Position subtract(double x, double y, double z) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
		
		return this;
	}
	
	/**
	 * Multiplies this position's coordinates by the specified position's coordinates.
	 */
	public Position multiply(Position pos) {
		return this.multiply(pos.getX(), pos.getY(), pos.getZ());
	}
	
	/**
	 * Multiplies this position's coordinates by the specified coordinates.
	 */
	public Position multiply(double x, double y, double z) {
		this.x *= x;
		this.y *= y;
		this.z *= z;
		
		return this;
	}
	
	/**
	 * Divides this position's coordinates by the specified position's coordinates.
	 */
	public Position divide(Position pos) {
		return this.divide(pos.getX(), pos.getY(), pos.getZ());
	}
	
	/**
	 * Divides this position's coordinates by the specified coordinates.
	 */
	public Position divide(double x, double y, double z) {
		this.x /= x;
		this.y /= y;
		this.z /= z;
		
		return this;
	}
	
	/**
	 * Clones this Position.
	 */
	@Override
	public Position clone() {
		return new Position(this.level, this.x, this.y, this.z, this.yaw, this.pitch);
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Position)) return false;
		
		Position pos = (Position) o;
		return this.x == pos.x && this.y == pos.y && this.z == pos.z && this.yaw == pos.yaw && this.pitch == pos.pitch && this.level.getName().equals(pos.getLevel().getName());
	}
	
}
