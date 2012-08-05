package ch.spacebase.openclassic.api.gui.widget;

import ch.spacebase.openclassic.api.gui.GuiScreen;
import ch.spacebase.openclassic.api.render.RenderHelper;

/**
 * A translucent background, as seen in the Ingame Menu Screen.
 */
public class TranslucentBackground extends Widget {

	public TranslucentBackground(int id, GuiScreen parent) {
		super(id, 0, 0, 0, 0, parent);
	}

	@Override
	public void render() {
		RenderHelper.getHelper().color(0, 0, this.parent.getWidth(), this.parent.getHeight(), 1610941696, -1607454624);
	}

}
