package ch.spacebase.openclassic.api.settings;

/**
 * A setting.
 */
public abstract class Setting {

	private String name;
	private String configKey;
	
	public Setting(String name, String configKey) {
		this.name = name;
		this.configKey = configKey;
	}
	
	/**
	 * Gets the name of this setting.
	 * @return The setting's name.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets this setting's config key.
	 * @return The setting's config key.
	 */
	public String getConfigKey() {
		return this.configKey;
	}
	
	/**
	 * Gets the string value of this setting.
	 * @return The setting's string value.
	 */
	public abstract String getStringValue();
	
	/**
	 * Toggles this setting.
	 */
	public abstract void toggle();
	
}
