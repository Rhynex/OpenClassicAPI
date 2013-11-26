package ch.spacebase.openclassic.api.gui.widget;

import ch.spacebase.openclassic.api.gui.Screen;

/**
 * A text label.
 */
public abstract class Label extends Widget {

	private String text;
	private boolean xCenter;
	private boolean scaled;
	
	public Label(int id, int x, int y, Screen parent, String text) {
		this(id, x, y, parent, text, false);
	}
	
	public Label(int id, int x, int y, Screen parent, String text, boolean xCenter) {
		this(id, x, y, parent, text, xCenter, false);
	}

	public Label(int id, int x, int y, Screen parent, String text, boolean xCenter, boolean scaled) {
		super(id, x, y, 0, 0, parent);
		this.text = text;
		this.xCenter = xCenter;
		this.scaled = scaled;
	}
	
	/**
	 * Gets the text in this label.
	 * @return The text in this label.
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Gets whether the text should be centered on the x coordinate of the widget.
	 */
	public boolean useXCenter() {
		return this.xCenter;
	}
	
	/**
	 * Gets whether the text is scaled up 2x or not.
	 * @return Whether the text is scaled.
	 */
	public boolean isScaled() {
		return this.scaled;
	}
	
	/**
	 * Sets the text in this label.
	 * @param text The new text in this label.
	 */
	public void setText(String text) {
		this.text = text;
	}

}
