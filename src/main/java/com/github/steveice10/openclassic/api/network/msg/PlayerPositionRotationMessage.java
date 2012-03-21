package com.github.steveice10.openclassic.api.network.msg;

public class PlayerPositionRotationMessage extends Message {
	
	private byte playerId;
	private double xChange;
	private double yChange;
	private double zChange;
	private byte yaw;
	private byte pitch;
	
	public PlayerPositionRotationMessage(byte playerId, double xChange, double yChange, double zChange, byte yaw, byte pitch) {
		this.playerId = playerId;
		this.xChange = xChange;
		this.yChange = yChange;
		this.zChange = zChange;
		this.yaw = yaw;
		this.pitch = pitch;
	}
	
	public byte getPlayerId() {
		return this.playerId;
	}
	
	public double getXChange() {
		return this.xChange;
	}
	
	public double getYChange() {
		return this.yChange;
	}
	
	public double getZChange() {
		return this.zChange;
	}
	
	public byte getYaw() {
		return this.yaw;
	}
	
	public byte getPitch() {
		return this.pitch;
	}
	
	public String toString() {
		return "PlayerPositionRotationMessage{playerid=" + playerId + ",xchange=" + xChange + ",ychange=" + yChange + ",zchange=" + zChange + ",yaw=" + yaw + ",pitch=" + pitch + "}";
	}
	
}
