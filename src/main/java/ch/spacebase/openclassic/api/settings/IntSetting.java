package ch.spacebase.openclassic.api.settings;

import org.apache.commons.lang3.Validate;

import ch.spacebase.openclassic.api.OpenClassic;

/**
 * An integer setting.
 */
public class IntSetting extends Setting {

	private String stringVals[];
	
	public IntSetting(String name, String configKey, String stringVals[]) {
		super(name, configKey);
		Validate.notNull(stringVals, "stringVals cannot be null.");
		this.stringVals = stringVals;
	}
	
	/**
	 * Gets this setting's value.
	 * @return The setting's value.
	 */
	public int getValue() {
		return OpenClassic.getGame().getConfig().getInteger(this.getConfigKey(), 0);
	}
	
	/**
	 * Sets this setting's value.
	 * @param The setting's value.
	 */
	public void setValue(int value) {
		Validate.isTrue(value >= 0 && value < this.stringVals.length, "Value must be >= 0 and < stringVals.length");
		OpenClassic.getGame().getConfig().setValue(this.getConfigKey(), value);
		OpenClassic.getGame().getConfig().save();
	}
	
	/**
	 * Applies a default value to this setting if it is not set.
	 * @param The setting's default value.
	 */
	public void setDefault(int value) {
		if(!OpenClassic.getGame().getConfig().contains(this.getConfigKey())) {
			OpenClassic.getGame().getConfig().setValue(this.getConfigKey(), value);
			OpenClassic.getGame().getConfig().save();
		}
	}

	@Override
	public String getStringValue() {
		int val = this.getValue();
		if(val >= this.stringVals.length) {
			val = this.stringVals.length - 1;
		}
		
		return this.stringVals[val];
	}

	@Override
	public void toggle() {
		this.setValue((this.getValue() + 1) % this.stringVals.length);
	}

}
