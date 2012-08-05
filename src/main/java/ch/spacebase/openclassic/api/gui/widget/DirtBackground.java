package ch.spacebase.openclassic.api.gui.widget;

import ch.spacebase.openclassic.api.gui.GuiScreen;
import ch.spacebase.openclassic.api.render.RenderHelper;

/**
 * A background made up of repeating dirt blocks, as seen in the main menu.
 */
public class DirtBackground extends Widget {

	public DirtBackground(int id, GuiScreen parent) {
		super(id, 0, 0, 0, 0, parent);
	}

	@Override
	public void render() {
		RenderHelper.getHelper().drawDirtBG();
	}

}
