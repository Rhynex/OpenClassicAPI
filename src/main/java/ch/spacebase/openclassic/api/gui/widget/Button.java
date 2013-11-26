package ch.spacebase.openclassic.api.gui.widget;

import ch.spacebase.openclassic.api.gui.Screen;

/**
 * Represents a button.
 */
public abstract class Button extends Widget {
	
	private String text;
	private boolean active = true;
	private ButtonCallback callback;

	public Button(int id, int x, int y, Screen parent, String text) {
		this(id, x, y, 200, 20, parent, text);
	}
	
	public Button(int id, int x, int y, int width, int height, Screen parent, String text) {
		super(id, x, y, width, height, parent);
		this.text = text;
	}
	
	/**
	 * Gets the button's text.
	 * @return The button's text.
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Sets the button's text.
	 * @param text Text to set.
	 */
	public void setText(String text) {
		this.text = text;
		if(this.text == null) this.text = "";
	}
	
	/**
	 * Returns true if this button is active.
	 * @return True if the button is active.
	 */
	public boolean isActive() {
		return this.active;
	}
	
	/**
	 * Sets whether the button is active.
	 * @param active Whether the button is active.
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	/**
	 * Gets the callback of this button.
	 * @return This button's callback.
	 */
	public ButtonCallback getCallback() {
		return this.callback;
	}
	
	/**
	 * Sets the callback of this button.
	 * @param callback Callback of this button.
	 * @return This button.
	 */
	public Button setCallback(ButtonCallback callback) {
		this.callback = callback;
		return this;
	}

}
