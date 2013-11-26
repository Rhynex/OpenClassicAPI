package ch.spacebase.openclassic.api.gui.widget;

import ch.spacebase.openclassic.api.gui.Screen;

/**
 * Represents a text box.
 */
public abstract class PasswordTextBox extends TextBox {
	
	public PasswordTextBox(int id, int x, int y, Screen parent) {
		this(id, x, y, parent, 0);
	}
	
	public PasswordTextBox(int id, int x, int y, Screen parent, int max) {
		this(id, x, y, 200, 20, parent, max);
	}
	
	public PasswordTextBox(int id, int x, int y, int width, int height, Screen parent) {
		this(id, x, y, width, height, parent, false);
	}
	
	public PasswordTextBox(int id, int x, int y, int width, int height, Screen parent, int max) {
		this(id, x, y, width, height, parent, max, false);
	}
	
	public PasswordTextBox(int id, int x, int y, Screen parent, boolean chatbox) {
		this(id, x, y, 200, 20, parent, chatbox);
	}
	
	public PasswordTextBox(int id, int x, int y, Screen parent, int max, boolean chatbox) {
		this(id, x, y, 200, 20, parent, max, chatbox);
	}
	
	public PasswordTextBox(int id, int x, int y, int width, int height, Screen parent, boolean chatbox) {
		this(id, x, y, width, height, parent, 0, chatbox);
	}
	
	public PasswordTextBox(int id, int x, int y, int width, int height, Screen parent, int max, boolean chatbox) {
		super(id, x, y, width, height, parent, max, chatbox);
	}

}
