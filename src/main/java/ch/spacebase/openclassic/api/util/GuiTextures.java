package ch.spacebase.openclassic.api.util;

import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.asset.AssetSource;
import ch.spacebase.openclassic.api.asset.texture.SubTexture;
import ch.spacebase.openclassic.api.asset.texture.Texture;


public class GuiTextures {

	public static final Texture LOGO = OpenClassic.getGame().getAssetManager().load("/gui/logo.png", AssetSource.JAR, Texture.class);
	public static final Texture INVENTORY = OpenClassic.getGame().getAssetManager().load("/gui/inventory.png", AssetSource.JAR, Texture.class);
	public static final Texture CRAFTING = OpenClassic.getGame().getAssetManager().load("/gui/crafting.png", AssetSource.JAR, Texture.class);
	public static final Texture CHEST = OpenClassic.getGame().getAssetManager().load("/gui/chest.png", AssetSource.JAR, Texture.class);
	public static final Texture FURNACE_TEXTURES = OpenClassic.getGame().getAssetManager().load("/gui/furnace.png", AssetSource.JAR, Texture.class);
	public static final Texture GUI = OpenClassic.getGame().getAssetManager().load("/gui/gui.png", AssetSource.JAR, Texture.class);
	public static final Texture ICONS = OpenClassic.getGame().getAssetManager().load("/gui/icons.png", AssetSource.JAR, Texture.class);
	public static final SubTexture FURNACE = FURNACE_TEXTURES.getSubTexture(0, 0, 352, 334);
	public static final SubTexture FURNACE_ARROW = FURNACE_TEXTURES.getSubTexture(354, 28, 46, 30);
	public static final SubTexture FURNACE_FLAME = FURNACE_TEXTURES.getSubTexture(2, 352, 0, 28);
	public static final SubTexture CROSSHAIR = ICONS.getSubTexture(0, 0, 32, 32);
	public static final SubTexture EMPTY_HEART = ICONS.getSubTexture(32, 0, 18, 18);
	public static final SubTexture EMPTY_HEART_FLASH =ICONS.getSubTexture(50, 0, 18, 18);
	public static final SubTexture FULL_HEART = ICONS.getSubTexture(104, 0, 18, 18);
	public static final SubTexture FULL_HEART_FLASH = ICONS.getSubTexture(140, 0, 18, 18);
	public static final SubTexture HALF_HEART = ICONS.getSubTexture(122, 0, 18, 18);
	public static final SubTexture HALF_HEART_FLASH = ICONS.getSubTexture(158, 0, 18, 18);
	public static final SubTexture BUBBLE = ICONS.getSubTexture(32, 36, 18, 18);
	public static final SubTexture POPPING_BUBBLE = ICONS.getSubTexture(50, 36, 18, 18);
	public static final SubTexture QUICK_BAR = GUI.getSubTexture(0, 0, 364, 44);
	public static final SubTexture SELECTION = GUI.getSubTexture(0, 44, 48, 44);
	public static final SubTexture BUTTON = GUI.getSubTexture(0, 132, 400, 40);
	public static final SubTexture BUTTON_HOVER = GUI.getSubTexture(0, 172, 400, 40);
	public static final SubTexture BUTTON_INACTIVE = GUI.getSubTexture(0, 92, 400, 40);
	
}
