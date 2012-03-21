package me.steveice10.openclassic.api.network.msg;

public class PlayerSpawnMessage extends Message {
	
	private byte playerId;
	private String name;
	private double x;
	private double y;
	private double z;
	private byte yaw;
	private byte pitch;
	
	public PlayerSpawnMessage(byte playerId, String name, double x, double y, double z, byte yaw, byte pitch) {
		this.playerId = playerId;
		this.name = name;
		this.x = x;
		this.y = y;
		this.z = z;
		this.yaw = yaw;
		this.pitch = pitch;
	}
	
	public byte getPlayerId() {
		return this.playerId;
	}
	
	public String getName() {
		return this.name;
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
	
	public byte getYaw() {
		return this.yaw;
	}
	
	public byte getPitch() {
		return this.pitch;
	}
	
	public String toString() {
		return "PlayerSpawnMessage{playerid=" + playerId + ",name=" + name + ",x=" + x + ",y=" + y + ",z=" + z + ",yaw=" + yaw + ",pitch=" + pitch + "}";
	}
	
}
