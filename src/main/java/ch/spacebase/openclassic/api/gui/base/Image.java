package ch.spacebase.openclassic.api.gui.base;

import ch.spacebase.openclassic.api.block.model.SubTexture;
import ch.spacebase.openclassic.api.gui.GuiComponent;

/**
 * A widget that displays a texture.
 */
public class Image extends GuiComponent {

	private SubTexture tex;
	
	public Image(String name, int x, int y, SubTexture tex) {
		this(name, x, y, (int) Math.abs(tex.getX2() - tex.getX1()), (int) Math.abs(tex.getY2() - tex.getY1()), tex);
	}
	
	public Image(String name, int x, int y, int width, int height, SubTexture tex) {
		super(name, x, y, width, height);
		this.tex = tex;
	}
	
	/**
	 * Gets the texture being displayed.
	 * @return The texture being displayed.
	 */
	public SubTexture getTexture() {
		return this.tex;
	}
	
	/**
	 * Sets the texture being displayed.
	 * @param tex The new texture being displayed.
	 */
	public void setTexture(SubTexture tex, boolean resizeToImage) {
		this.tex = tex;
		if(resizeToImage) {
			this.setSize((int) Math.abs(tex.getX2() - tex.getX1()), (int) Math.abs(tex.getY2() - tex.getY1()));
		}
	}
	
	@Override
	public void render(int mouseX, int mouseY) {
		ComponentHelper.getHelper().renderImage(this);
	}

}
