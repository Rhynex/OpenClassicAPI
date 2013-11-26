package ch.spacebase.openclassic.api.gui.widget;

import ch.spacebase.openclassic.api.gui.Screen;

/**
 * A translucent background, as seen in the Ingame Menu Screen.
 */
public abstract class TranslucentBackground extends Widget {

	public TranslucentBackground(int id, Screen parent) {
		super(id, 0, 0, 0, 0, parent);
	}

}
