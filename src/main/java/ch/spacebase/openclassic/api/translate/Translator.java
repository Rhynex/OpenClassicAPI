package ch.spacebase.openclassic.api.translate;

import java.util.HashMap;
import java.util.Map;

import ch.spacebase.openclassic.api.OpenClassic;

public class Translator {

	private final Map<String, Language> languages = new HashMap<String, Language>();
	private String def;
	
	public String getDefault() {
		return this.def;
	}
	
	public void setDefault(String lang) {
		this.def = lang;
	}
	
	public void register(Language lang) {
		this.languages.put(lang.getName(), lang);
	}
	
	public Language get(String lang) {
		return this.languages.get(lang);
	}
	
	public String translate(String text) { 
		return this.translate(text, OpenClassic.getClient().getConfig().getString("options.language", "en_US"));
	}
	
	public String translate(String text, String lang) {
		if(this.get(lang) == null) {
			if(this.get(this.def) != null) {
				return this.get(this.def).translate(text);
			} else {
				return "<missing language>";
			}
		} else {
			String result = this.get(lang).translate(text);
			if(result.equals("<missing translation>")) {
				return this.get(this.def).translate(text);
			}
			
			return result;
		}
	}
	
}
