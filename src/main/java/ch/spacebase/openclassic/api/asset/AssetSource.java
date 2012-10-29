package ch.spacebase.openclassic.api.asset;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipFile;

import ch.spacebase.openclassic.api.OpenClassic;

public enum AssetSource {

	JAR,
	FILE,
	URL;
	
	public DataInputStream getInputStream(String file) throws IOException {
		switch(this) {
			case JAR:
				InputStream in = OpenClassic.class.getResourceAsStream(file);
				if(OpenClassic.getGame().getConfig() != null && !OpenClassic.getGame().getConfig().getString("settings.resourcepack", "none").equals("none")) {
					ZipFile zip = new ZipFile(new File(OpenClassic.getGame().getDirectory(), "resourcepack/" + OpenClassic.getClient().getConfig().getString("settings.texturepack", "none")));
					if(zip.getEntry(file.startsWith("/") ? file.substring(1, file.length()) : file) != null) {
						in = zip.getInputStream(zip.getEntry(file.startsWith("/") ? file.substring(1, file.length()) : file));
					}
					
					zip.close();
				}
				
				return new DataInputStream(in);
			case FILE:
				File f = new File(file);
				if(!f.exists()) {
					if(!f.getParentFile().exists()) {
						f.getParentFile().mkdirs();
					}
					
					f.createNewFile();
				}
				
				return new DataInputStream(new FileInputStream(f));
			default:
				return null; // TODO
		}
	}
	
	public DataOutputStream getOutputStream(String file) throws IOException {
		switch(this) {
			case FILE:
				File f = new File(file);
				if(!f.exists()) {
					if(!f.getParentFile().exists()) {
						f.getParentFile().mkdirs();
					}
					
					f.createNewFile();
				}
				
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
