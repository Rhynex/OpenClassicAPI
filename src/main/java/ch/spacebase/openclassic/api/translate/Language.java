package ch.spacebase.openclassic.api.translate;

import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.asset.AssetSource;
import ch.spacebase.openclassic.api.asset.text.YamlFile;

/**
 * A language pack for use in a translator.
 */
public class Language {

	private String name;
	private YamlFile lang;
	
	public Language(String name, String file, AssetSource source) {
		this.name = name;
		this.lang = OpenClassic.getGame().getAssetManager().load(file, source, YamlFile.class);
	}
	
	/**
	 * Gets the name of this language.
	 * @return This language's name.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Adds a translation to this language instance.
	 * @param key Key to use for the translation.
	 * @param translation Translation to add.
	 */
	public void addTranslation(String key, String translation) {
		this.lang.setValue(key, translation);
	}
	
	/**
	 * Translates the given key to text from this language.
	 * @param key Key to translate.
	 * @return The translated text.
	 */
	public String translate(String key) {
		if(this.lang.contains(key)) {
			return this.lang.getString(key);
		} else {
			return "<missing translation>";
		}
	}
	
}
