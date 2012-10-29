package ch.spacebase.openclassic.api.util;

import ch.spacebase.openclassic.api.block.model.SubTexture;
import ch.spacebase.openclassic.api.block.model.Texture;

public class GuiTextures {

	public static final Texture GUI = new Texture("/gui/gui.png", true, 512, 512, 16);
	public static final Texture ICONS = new Texture("/gui/icons.png", true, 256, 256, 16);
	public static final SubTexture CROSSHAIR = new SubTexture(ICONS, 0, 0, 0, 16, 16);
	public static final SubTexture QUICK_BAR = new SubTexture(GUI, 0, 0, 0, 364, 44);
	public static final SubTexture SELECTION = new SubTexture(GUI, 0, 0, 44, 48, 44);
	public static final SubTexture BUTTON = new SubTexture(GUI, 0, 0, 132, 400, 40);
	public static final SubTexture BUTTON_HOVER = new SubTexture(GUI, 0, 0, 172, 400, 40);
	public static final SubTexture BUTTON_INACTIVE = new SubTexture(GUI, 0, 0, 92, 400, 40);
	
}
