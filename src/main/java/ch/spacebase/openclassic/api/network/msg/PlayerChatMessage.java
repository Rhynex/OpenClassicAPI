package ch.spacebase.openclassic.api.network.msg;

public class PlayerChatMessage extends Message {
	
	private byte playerId;
	private String message;
	
	public PlayerChatMessage(byte playerId, String message) {
		this.playerId = playerId;
		this.message = message;
	}
	
	public byte getPlayerId() {
		return this.playerId;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public String toString() {
		return "PlayerChatMessage{playerid=" + playerId + ",message=" + message + "}";
	}
	
}
