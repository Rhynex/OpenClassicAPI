package ch.spacebase.openclassic.api.asset;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class Asset {

	private String file;
	private AssetSource source;
	
	public Asset(String file, AssetSource source) {
		this.file = file;
		this.source = source;
	}
	
	public DataInputStream getInputStream() {
		return this.source.getInputStream(this.file);
	}
	
	public DataOutputStream getOutputStream() throws IOException {
		return this.source.getOutputStream(this.file);
	}
	
	public String getFile() {
		return this.file;
	}
	
	public AssetSource getSource() {
		return this.source;
	}
	
	public void load() throws IOException {
		DataInputStream in = this.getInputStream();
		if(in != null) {
			this.load(in);
			in.close();
		}
	}
	
	public abstract void load(DataInputStream in) throws IOException;
	
	public void save() throws IOException {
		DataOutputStream out = this.getOutputStream();
		if(out != null) {
			this.save(out);
			out.close();
		}
	}
	
	public abstract void save(DataOutputStream out) throws IOException;
	
}
