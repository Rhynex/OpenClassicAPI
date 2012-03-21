package me.steveice10.openclassic.api.network.msg;

public class IdentificationMessage extends Message {

	public static final byte NOT_OP = 0x00;
	public static final byte OP = 0x64;
	
	private int protocolVersion;
	private String usernameOrServerName;
	private String verificationKeyOrMotd;
	private byte op;
	
	public IdentificationMessage(int protocolVersion, String usernameOrServerName, String verificationKeyOrMotd, byte op) {
		this.protocolVersion = protocolVersion;
		this.usernameOrServerName = usernameOrServerName;
		this.verificationKeyOrMotd = verificationKeyOrMotd;
		this.op = op;
	}
	
	public int getProtocolVersion() {
		return this.protocolVersion;
	}
	
	public String getUsernameOrServerName() {
		return this.usernameOrServerName;
	}
	
	public String getVerificationKeyOrMotd() {
		return this.verificationKeyOrMotd;
	}
	
	public byte getOp() {
		return this.op;
	}
	
	public String toString() {
		return "IdentificationMessage{protocol=" + protocolVersion + ",usernameorservername=" + usernameOrServerName + ",verificationkeyormotd=" + verificationKeyOrMotd + ",op=" + op + "}";
	}
	
}
