package ch.spacebase.openclassic.api.network.msg.custom;

import ch.spacebase.openclassic.api.network.msg.Message;

public class LevelColorMessage extends Message {

	private String type;
	private int value;
	
	public LevelColorMessage(String type, int value) {
		this.type = type;
		this.value = value;
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return "LevelColorMessage{type=" + type + ",value=" + value + "}";
	}

	@Override
	public Object[] getParams() {
		return new Object[] { type, value };
	}

	@Override
	public byte getOpcode() {
		return 21;
	}
	
}
