package ch.spacebase.openclassic.api.translate;

import java.io.File;
import java.io.InputStream;

import ch.spacebase.openclassic.api.config.Configuration;
import ch.spacebase.openclassic.api.config.yaml.YamlConfig;

/**
 * A language pack for use in a translator.
 */
public class Language {

	private String name;
	private String langCode;
	private Configuration lang;

	@Deprecated
	/**
	 * Due to changes in API this method is now deprecated.
	 * Replaced by method Language(String name, String langCode, String file).
	 */
	public Language(String name, String file) {
		this.name = name;
		this.langCode = "undefined";
		this.lang = new YamlConfig(new File(file));
		this.lang.load();
	}

	@Deprecated
	/**
	 * Due to changes in API this method is now deprecated.
	 * Replaced by method Language(String name, String langCode, InputStream in).
	 */
	public Language(String name, InputStream in) {
		this.name = name;
		this.langCode = "undefined";
		this.lang = new YamlConfig();
		this.lang.load(in);
	}

	public Language(String name, String langCode, String file) {
		this.name = name;
		this.langCode = langCode;
		this.lang = new YamlConfig(new File(file));
		this.lang.load();
	}

	public Language(String name, String langCode, InputStream in) {
		this.name = name;
		this.langCode = langCode;
		this.lang = new YamlConfig();
		this.lang.load(in);
	}

	/**
	 * Gets the name of this language.
	 * @return This language's name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the native name of this language.
	 * @return This language's native name.
	 */
	public String getLangCode() {
		return this.langCode;
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
