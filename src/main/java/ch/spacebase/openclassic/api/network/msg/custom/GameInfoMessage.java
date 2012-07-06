package ch.spacebase.openclassic.api.network.msg.custom;

import ch.spacebase.openclassic.api.network.msg.Message;

/**
 * Contains info about a custom client.
 */
public class GameInfoMessage extends Message {

	private String version;
	
	public GameInfoMessage(String version) {
		this.version = version;
	}
	
	/**
	 * Gets the version of the client.
	 * @return The client's version.
	 */
	public String getVersion() {
		return this.version;
	}

	@Override
	public Object[] getParams() {
		return new Object[] { this.version };
	}
	
	@Override
	public String toString() {
		return "ClientInfoMessage{version=" + version + "}";
	}
	
	@Override
	public byte getOpcode() {
		return 16;
	}
	
}
