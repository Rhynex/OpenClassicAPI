package com.github.steveice10.openclassic.api.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class IOUtils {

	public static String readString(DataInputStream in) throws IOException {
		StringBuilder builder = new StringBuilder();
		
		for(int length = in.readShort(); length > 0; length--) {
			builder.append(in.readChar());
		}
		
		return builder.toString();
	}
	
	public static void writeString(DataOutputStream out, String str) throws IOException {
		out.writeShort(str.length());
		
		for(char letter : str.toCharArray()) {
			out.writeChar(letter);
		}
	}
	
	private IOUtils() {
	}
	
}
