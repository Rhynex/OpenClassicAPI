package ch.spacebase.openclassic.api.network.msg;

public class PlayerOpMessage extends Message {
	
	public static final byte OP = 0x64;
	public static final byte DEOP = 0x00;
	
	private byte op;
	
	public PlayerOpMessage(byte op) {
		this.op = op;
	}
	
	public byte getOp() {
		return this.op;
	}
	
	public String toString() {
		return "PlayerOpMessage{op=" + op + "}";
	}
	
}
