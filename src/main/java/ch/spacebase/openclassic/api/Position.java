package ch.spacebase.openclassic.api;

import ch.spacebase.openclassic.api.level.Level;

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
	
	public Level getLevel() {
		return this.level;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double getZ() {
		return this.z;
	}
	
	public int getBlockX() {
		return (int) Math.floor(this.getX());
	}
	
	public int getBlockY() {
		return (int) Math.floor(this.getY());
	}
	
	public int getBlockZ() {
		return (int) Math.floor(this.getZ());
	}
	
	public byte getYaw() {
		return this.yaw;
	}
	
	public byte getPitch() {
		return this.pitch;
	}
	
	public void setLevel(Level level) {
		this.level = level;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public void setZ(double z) {
		this.z = z;
	}
	
	public void setYaw(byte yaw) {
		this.yaw = yaw;
	}
	
	public void setPitch(byte pitch) {
		this.pitch = pitch;
	}
	
	public Position add(Position pos) {
		return this.add(pos.getX(), pos.getY(), pos.getZ());
	}
	
	public Position add(double x, double y, double z) {
		this.x += x;
		this.y += y;
		this.z += z;
		
		return this;
	}
	
	public Position subtract(Position pos) {
		return this.subtract(pos.getX(), pos.getY(), pos.getZ());
	}
	
	public Position subtract(double x, double y, double z) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
		
		return this;
	}
	
	public Position multiply(Position pos) {
		return this.multiply(pos.getX(), pos.getY(), pos.getZ());
	}
	
	public Position multiply(double x, double y, double z) {
		this.x *= x;
		this.y *= y;
		this.z *= z;
		
		return this;
	}
	
	public Position divide(Position pos) {
		return this.divide(pos.getX(), pos.getY(), pos.getZ());
	}
	
	public Position divide(double x, double y, double z) {
		this.x /= x;
		this.y /= y;
		this.z /= z;
		
		return this;
	}
	
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
