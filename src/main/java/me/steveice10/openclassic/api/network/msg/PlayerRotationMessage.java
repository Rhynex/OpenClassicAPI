package me.steveice10.openclassic.api.network.msg;

public class PlayerRotationMessage extends Message {
	
	private byte playerId;
	private byte yaw;
	private byte pitch;
	
	public PlayerRotationMessage(byte playerId, byte yaw, byte pitch) {
		this.playerId = playerId;
		this.yaw = yaw;
		this.pitch = pitch;
	}
	
	public byte getPlayerId() {
		return this.playerId;
	}
	
	public byte getYaw() {
		return this.yaw;
	}
	
	public byte getPitch() {
		return this.pitch;
	}
	
	public String toString() {
		return "PlayerRotationMessage{playerid=" + playerId + ",yaw=" + yaw + ",pitch=" + pitch + "}";
	}
	
}
