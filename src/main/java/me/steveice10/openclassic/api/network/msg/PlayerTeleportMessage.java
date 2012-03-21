package me.steveice10.openclassic.api.network.msg;

public class PlayerTeleportMessage extends Message {
	
	private byte playerId;
	private double x;
	private double y;
	private double z;
	private byte yaw;
	private byte pitch;
	
	public PlayerTeleportMessage(byte playerId, double x, double y, double z, byte yaw, byte pitch) {
		this.playerId = playerId;
		this.x = x;
		this.y = y;
		this.z = z;
		this.yaw = yaw;
		this.pitch = pitch;
	}
	
	public byte getPlayerId() {
		return this.playerId;
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
		return "PlayerTeleportMessage{playerid=" + playerId + ",x=" + x + ",y=" + y + ",z=" + z + ",yaw=" + yaw + ",pitch=" + pitch + "}";
	}
	
}
