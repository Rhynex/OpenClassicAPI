package ch.spacebase.openclassic.api.asset;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import ch.spacebase.openclassic.api.OpenClassic;

public enum AssetSource {

	JAR,
	FILE,
	URL;
	
	public DataInputStream getInputStream(String file) {
		switch(this) {
			case JAR:
				return new DataInputStream(OpenClassic.class.getResourceAsStream(file));
			default:
				return null; // TODO
		}
	}
	
	public DataOutputStream getOutputStream(String file) throws IOException {
		switch(this) {
			case FILE:
				return new DataOutputStream(new FileOutputStream(file));
			default:
				return null;
		}
	}

	public String getPath(File dir, String file) {
		if(this == FILE) {
			return new File(dir, file).getPath();
		}
		
		return file;
	}
	
}
