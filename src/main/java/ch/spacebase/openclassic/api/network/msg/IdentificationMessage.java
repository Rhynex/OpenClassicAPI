package ch.spacebase.openclassic.api.network.msg;

/**
 * Sent/Recieved during the identification process.
 */
public class IdentificationMessage extends Message {
	
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
	
	/**
	 * Gets the sent/recieved protocol version.
	 * @return The protocol version.
	 */
	public int getProtocolVersion() {
		return this.protocolVersion;
	}
	
	/**
	 * Gets the player's name if the message is being recieved or the server name if it is being sent.
	 * @return The username or server name.
	 */
	public String getUsernameOrServerName() {
		return this.usernameOrServerName;
	}
	
	/**
	 * Gets the verification key if the message is being recieved or the motd if it is being sent.
	 * @return The verification key or motd.
	 */
	public String getVerificationKeyOrMotd() {
		return this.verificationKeyOrMotd;
	}
	
	/**
	 * Gets whether this player is an OP. (unused when recieving)
	 * @return Whether the player is an OP.
	 */
	public byte getOp() {
		return this.op;
	}
	
	@Override
	public String toString() {
		return "IdentificationMessage{protocol=" + protocolVersion + ",usernameorservername=" + usernameOrServerName + ",verificationkeyormotd=" + verificationKeyOrMotd + ",op=" + op + "}";
	}

	@Override
	public Object[] getParams() {
		return new Object[] { this.usernameOrServerName, this.verificationKeyOrMotd, this.protocolVersion, this.op };
	}
	
	@Override
	public byte getOpcode() {
		return 0;
	}
	
}
