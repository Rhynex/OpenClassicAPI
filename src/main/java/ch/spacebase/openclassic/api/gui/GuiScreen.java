package ch.spacebase.openclassic.api.gui;

import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.gui.widget.Widget;
import ch.spacebase.openclassic.api.input.Keyboard;

/**
 * Represents a GUI screen.
 */
public abstract class GuiScreen extends Screen {
	
	private int width;
	private int height;
	
	/**
	 * Gets the screen's width.
	 * @return The screen's width.
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * Gets the screen's height.
	 * @return The screen's height.
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * Sets the size of this screen.
	 * @param width The screen's new width.
	 * @param height The screen's new height.
	 */
	public void setSize(int width, int height) {
		this.width = width * 240 / height;
		this.height = height * 240 / height;
	}
	
	/**
	 * Called when the GuiScreen is opened.
	 */
	public void onOpen() {
	}
	
	/**
	 * Called when the GuiScreen is closed.
	 */
	public void onClose() {
	}
	
	/**
	 * Called when the mouse is clicked.
	 * @param x X of the mouse.
	 * @param y Y of the mouse.
	 * @param button ID of the clicked button.
	 */
	public void onMouseClick(int x, int y, int button) {
		for (Widget curr : this.getWidgets()) {
			if (x >= curr.getX() && y >= curr.getY() && x < curr.getX() + curr.getWidth() && y < curr.getY() + curr.getHeight()) {
				curr.onMouseClick(x, y, button);
			}
		}
	}
	
	/**
	 * Called when a key is pressed.
	 * @param c Character resulting from the key press if applicable.
	 * @param key ID of the pressed key.
	 */
	public void onKeyPress(char c, int key) {
		if (key == Keyboard.KEY_ESCAPE && OpenClassic.getClient().isInGame()) {
			OpenClassic.getClient().setCurrentScreen(null);
		} else {
			for (Widget curr : this.getWidgets()) {
				curr.onKeyPress(c, key);
			}
		}
	}
	
}
