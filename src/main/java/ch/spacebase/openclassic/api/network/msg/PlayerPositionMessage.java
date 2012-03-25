package ch.spacebase.openclassic.api.network.msg;

public class PlayerPositionMessage extends Message {
	
	private byte playerId;
	private double xChange;
	private double yChange;
	private double zChange;
	
	public PlayerPositionMessage(byte playerId, double xChange, double yChange, double zChange) {
		this.playerId = playerId;
		this.xChange = xChange;
		this.yChange = yChange;
		this.zChange = zChange;
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
	
	public String toString() {
		return "PlayerPositionMessage{playerid=" + playerId + ",xchange=" + xChange + ",ychange=" + yChange + ",zchange=" + zChange + "}";
	}
	
}
