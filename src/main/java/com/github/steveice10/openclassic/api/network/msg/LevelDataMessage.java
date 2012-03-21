package com.github.steveice10.openclassic.api.network.msg;

import java.util.Arrays;

public class LevelDataMessage extends Message {

	private short length;
	private byte[] data;
	private byte percent;
	
	public LevelDataMessage(short length, byte[] data, byte percent) {
		this.length = length;
		this.data = data;
		this.percent = percent;
	}
	
	public short getLength() {
		return this.length;
	}
	
	public byte[] getData() {
		return this.data;
	}
	
	public byte getPercent() {
		return this.percent;
	}
	
	public String toString() {
		return "LevelDataMessage{length=" + length + ",data=" + Arrays.toString(data) + ",percent=" + percent + "}";
	}
	
}
