package ch.spacebase.openclassic.api.util.io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * A set of utilities for I/O interactions.
 */
public class IOUtils {

	/**
	 * Reads a string from a DataInputStream.
	 * @param in DataInputStream to read from.
	 * @return The string read from the stream.
	 * @throws IOException if an I/O error occurs.
	 */
	public static String readString(DataInputStream in) throws IOException {
		StringBuilder builder = new StringBuilder();
		
		for(int length = in.readShort(); length > 0; length--) {
			builder.append(in.readChar());
		}
		
		return builder.toString();
	}
	
	/**
	 * Writes a string to a DataInputStream.
	 * @param out DataOutputStream to write to.
	 * @param str The string to write.
	 * @throws IOException if an I/O error occurs.
	 */
	public static void writeString(DataOutputStream out, String str) throws IOException {
		out.writeShort(str.length());
		
		for(char letter : str.toCharArray()) {
			out.writeChar(letter);
		}
	}
	
	/**
	 * Compares two input streams.
	 * @param in1 First input stream.
	 * @param in2 Second input stream.
	 * @return Whether the input streams are equal in content.
	 * @throws IOException if an I/O error occurs.
	 */
	public static boolean contentEquals(InputStream in1, InputStream in2) throws IOException {
		if(!(in1 instanceof BufferedInputStream)) {
			in1 = new BufferedInputStream(in1);
		}

		if(!(in2 instanceof BufferedInputStream)) {
			in2 = new BufferedInputStream(in2);
		}

		int ch = in1.read();
		while(ch != -1) {
			int ch2 = in2.read();
			if(ch != ch2) {
				return false;
			}
			
			ch = in1.read();
		}

		return in2.read() == -1;
	}
	
	public static void copy(InputStream in, File to) throws IOException {
		if(!to.exists()) {
			if(!to.getParentFile().exists()) {
				try {
					to.getParentFile().mkdirs();
				} catch(SecurityException e) {
					e.printStackTrace();
				}
			}
			
			try {
				to.createNewFile();
			} catch(SecurityException e) {
				e.printStackTrace();
			}
		} else {
			try {
				to.delete();
				to.createNewFile();
			} catch(SecurityException e) {
				e.printStackTrace();
			}
		}
		
		FileOutputStream out = new FileOutputStream(to);
		byte buffer[] = new byte[2048];
		while(in.read(buffer) != -1) {
			out.write(buffer);
		}
		
		out.close();
	}
	
	/**
	 * Default private constructor
	 */
	private IOUtils() {
	}
	
}
