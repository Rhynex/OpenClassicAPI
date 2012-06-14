package ch.spacebase.openclassic.api.gui.widget;

import ch.spacebase.openclassic.api.gui.GuiScreen;
import ch.spacebase.openclassic.api.gui.widget.Button;

/**
 * Represents a button that can be toggled.
 */
public final class ToggleButton extends Button {

	public ToggleButton(int id, int x, int y, GuiScreen parent, boolean visible, String text) {
		this(id, x, y, 200, 20, parent, visible, text);
	}
	
	public ToggleButton(int id, int x, int y, int width, int height, GuiScreen parent, boolean visible, String text) {
		super(id, x, y, width, height, parent, visible, text);
	}
	
}
