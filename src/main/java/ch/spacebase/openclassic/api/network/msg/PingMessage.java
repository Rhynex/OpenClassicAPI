package ch.spacebase.openclassic.api.network.msg;

/**
 * Sent to ping the client.
 */
public class PingMessage extends Message {

	@Override
	public String toString() {
		return "PingMessage{}";
	}
	
	@Override
	public byte getOpcode() {
		return 1;
	}
	
}
