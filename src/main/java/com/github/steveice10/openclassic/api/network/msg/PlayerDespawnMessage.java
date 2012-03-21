package com.github.steveice10.openclassic.api.network.msg;

public class PlayerDespawnMessage extends Message {
	
	private byte playerId;
	
	public PlayerDespawnMessage(byte playerId) {
		this.playerId = playerId;
	}
	
	public byte getPlayerId() {
		return this.playerId;
	}
	
	public String toString() {
		return "PlayerDespawnMessage{playerid=" + playerId + "}";
	}
	
}
