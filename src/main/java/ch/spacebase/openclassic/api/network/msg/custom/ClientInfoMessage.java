package ch.spacebase.openclassic.api.network.msg.custom;

import ch.spacebase.openclassic.api.network.msg.Message;

public class ClientInfoMessage extends Message {

	private String version;
	
	public ClientInfoMessage(String version) {
		this.version = version;
	}
	
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
