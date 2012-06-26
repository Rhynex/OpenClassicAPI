package ch.spacebase.openclassic.api.network.msg.custom;

import ch.spacebase.openclassic.api.network.msg.Message;

public class KeyChangeMessage extends Message {

	private int key;
	private boolean pressed;
	
	public KeyChangeMessage(int key, boolean pressed) {
		this.key = key;
		this.pressed = pressed;
	}
	
	public int getKey() {
		return this.key;
	}
	
	public boolean isPressed() {
		return this.pressed;
	}

	@Override
	public Object[] getParams() {
		return new Object[] { this.key, this.pressed ? (byte) 1 : (byte) 0 };
	}
	
	@Override
	public String toString() {
		return "KeyChangeMessage{key=" + key + ",pressed=" + pressed + "}";
	}
	
	@Override
	public byte getOpcode() {
		return 20;
	}
	
}
