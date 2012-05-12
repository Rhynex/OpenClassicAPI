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
	 * @param Position to add.
	 * @return This position after adding.
	 */
	public Position add(Position pos) {
		return this.add(pos.getX(), pos.getY(), pos.getZ());
	}
	
	/**
	 * Adds the specified coordinates to this position's coordinates.
	 * @param X to add.
	 * @param Y to add.
	 * @param Z to add.
	 * @return This position after adding.
	 */
	public Position add(double x, double y, double z) {
		this.x += x;
		this.y += y;
		this.z += z;
		
		return this;
	}
	
	/**
	 * Subtracts the specified position's coordinates from this position's coordinates.
	 * @param Position to subtract.
	 * @return This position after subtracting.
	 */
	public Position subtract(Position pos) {
		return this.subtract(pos.getX(), pos.getY(), pos.getZ());
	}
	
	/**
	 * Subtracts the specified coordinates from this position's coordinates.
	 * @param X to subtract.
	 * @param Y to subtract.
	 * @param Z to subtract.
	 * @return This position after subtracting.
	 */
	public Position subtract(double x, double y, double z) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
		
		return this;
	}
	
	/**
	 * Multiplies this position's coordinates by the specified position's coordinates.
	 * @param Position to multiply by.
	 * @return This position after multiplying.
	 */
	public Position multiply(Position pos) {
		return this.multiply(pos.getX(), pos.getY(), pos.getZ());
	}
	
	/**
	 * Multiplies this position's coordinates by the specified coordinates.
	 * @param X to multiply by.
	 * @param Y to multiply by.
	 * @param Z to multiply by.
	 * @return This position after multiplying.
	 */
	public Position multiply(double x, double y, double z) {
		this.x *= x;
		this.y *= y;
		this.z *= z;
		
		return this;
	}
	
	/**
	 * Divides this position's coordinates by the specified position's coordinates.
	 * @param Position to divide by.
	 * @return This position after dividing.
	 */
	public Position divide(Position pos) {
		return this.divide(pos.getX(), pos.getY(), pos.getZ());
	}
	
	/**
	 * Divides this position's coordinates by the specified coordinates.
	 * @param X to divide by.
	 * @param Y to divide by.
	 * @param Z to divide by.
	 * @return This position after dividing.
	 */
	public Position divide(double x, double y, double z) {
		this.x /= x;
		this.y /= y;
		this.z /= z;
		
		return this;
	}

    /**
     * Gets the distance between this position and another.
     * WARNING: Very costly.
	 *
     * @param Other position.
     * @return Distance between the positions.
     */
    public double distance(Position pos) {
        return Math.sqrt(this.distanceSquared(pos));
    }

    /**
     * Get the squared distance between this position and another.
     * @param Other position.
     * @return Square distance between the positions.
     */
    public double distanceSquared(Position pos) {
        return Math.pow(this.x - pos.x, 2) + Math.pow(this.y - pos.y, 2) + Math.pow(this.z - pos.z, 2);
    }
    
    /**
     * Zeros all the values of this position.
     * @return This position after zeroing.
     */
    public Position zero() {
    	this.x = 0;
    	this.y = 0;
    	this.z = 0;
    	
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
		if(o == null || !(o instanceof Position)) return false;
		if(this == o) return true;
		
		Position pos = (Position) o;
		return Double.doubleToLongBits(this.x) == Double.doubleToLongBits(pos.x) && Double.doubleToLongBits(this.y) == Double.doubleToLongBits(pos.y) && Double.doubleToLongBits(this.z) == Double.doubleToLongBits(pos.z) && this.yaw == pos.yaw && this.pitch == pos.pitch && (this.level == null || pos.level == null ? this.level == pos.level : this.level.getName().equals(pos.level.getName()));
	}
	
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (int) Double.doubleToLongBits(this.x);
		hash = 31 * hash + (int) Double.doubleToLongBits(this.y);
		hash = 31 * hash + (int) Double.doubleToLongBits(this.z);
		hash = 31 * hash + this.yaw;
		hash = 31 * hash + this.pitch;
		hash = 31 * hash + (this.level == null || this.level.getName() == null ? 0 : this.level.getName().hashCode());
		
		return hash;
	}
	
}
