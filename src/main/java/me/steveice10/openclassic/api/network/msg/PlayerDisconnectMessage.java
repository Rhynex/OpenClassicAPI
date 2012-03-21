package me.steveice10.openclassic.api.network.msg;

public class PlayerDisconnectMessage extends Message {
	
	private String message;
	
	public PlayerDisconnectMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public String toString() {
		return "PlayerDisconnectMessage{message=" + message + "}";
	}
	
}
