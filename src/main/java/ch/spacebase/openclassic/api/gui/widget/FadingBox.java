package ch.spacebase.openclassic.api.gui.widget;

import ch.spacebase.openclassic.api.gui.Screen;

/**
 * A box that fades between two colors.
 */
public abstract class FadingBox extends Widget {

	private int color;
	private int fadeTo;
	
	public FadingBox(int id, int x, int y, int width, int height, Screen parent, int color, int fadeTo) {
		super(id, x, y, width, height, parent);
		this.color = color;
		this.fadeTo = fadeTo;
	}
	
	/**
	 * Gets the color of this fading box.
	 * @return The fading box's color.
	 */
	public int getColor() {
		return this.color;
	}
	
	/**
	 * Gets the color that this fading box fades to.
	 * @return The fading box's color to fade to.
	 */
	public int getFadeColor() {
		return this.fadeTo;
	}

}
