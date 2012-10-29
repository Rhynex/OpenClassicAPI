package ch.spacebase.openclassic.api.asset.text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ch.spacebase.openclassic.api.asset.Asset;
import ch.spacebase.openclassic.api.asset.AssetSource;

public class TextFile extends Asset {

	private List<String> lines = new ArrayList<String>();
	
	public TextFile(String file, AssetSource source) {
		super(file, source);
	}
	
	public String getLine(int line) {
		return this.lines.get(line);
	}
	
	public void setLine(int line, String str) {
		if(this.lines.size() <= line) this.lines.add(line, "");
		this.lines.set(line, str);
	}
	
	public List<String> getLines() {
		return new ArrayList<String>(this.lines);
	}
	
	public void setLines(String lines[]) {
		this.setLines(Arrays.asList(lines));
	}
	
	public void setLines(List<String> lines) {
		this.lines.clear();
		this.lines.addAll(lines);
	}

	@Override
	public void load(DataInputStream in) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(in));
		String line = null;
		while((line = read.readLine()) != null) {
			this.lines.add(line);
		}
		
		read.close();
	}

	@Override
	public void save(DataOutputStream out) throws IOException {
		BufferedWriter write = new BufferedWriter(new OutputStreamWriter(out));
		for(String line : this.lines) {
			write.write(line);
			write.newLine();
		}
	}
	
}
