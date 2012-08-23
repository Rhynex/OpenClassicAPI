package ch.spacebase.openclassic.api.translate;

import java.io.File;
import java.io.InputStream;

import ch.spacebase.openclassic.api.config.Configuration;

public class Language {

	private String name;
	private Configuration lang;
	
	public Language(String name, String file) {
		this.name = name;
		this.lang = new Configuration(new File(file));
		this.lang.load();
	}
	
	public Language(String name, InputStream in) {
		this.name = name;
		this.lang = new Configuration(in);
		this.lang.load();
	}
	
	public String getName() {
		return this.name;
	}
	
	public String translate(String key) {
		if(this.lang.contains(key)) {
			return this.lang.getString(key);
		} else {
			return "<missing translation>";
		}
	}
	
}
