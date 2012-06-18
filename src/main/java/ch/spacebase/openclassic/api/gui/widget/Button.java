package ch.spacebase.openclassic.api.gui.widget;

import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.gui.GuiScreen;
import ch.spacebase.openclassic.api.render.RenderHelper;

/**
 * Represents a button.
 */
public class Button extends Widget {

	private String text;
	private boolean active = true;

	public Button(int id, int x, int y, GuiScreen parent, boolean visible, String text) {
		this(id, x, y, 200, 20, parent, visible, text);
	}
	
	public Button(int id, int x, int y, int width, int height, GuiScreen parent, boolean visible, String text) {
		super(id, x, y, width, height, parent, visible);
		this.text = text;
	}
	
	/**
	 * Gets the button's text.
	 * @return The button's text.
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Sets the button's text.
	 * @param text Text to set.
	 */
	public void setText(String text) {
		this.text = text;
		if(this.text == null) this.text = "";
	}
	
	/**
	 * Returns true if this button is active.
	 * @return True if the button is active.
	 */
	public boolean isActive() {
		return this.active;
	}
	
	/**
	 * Sets whether the button is active.
	 * @param active Whether the button is active.
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public void onMouseClick(int x, int y, int button) {
		if(button != 0 || !this.isActive()) return;
		
		OpenClassic.getClient().getAudioManager().playSound("random.click", 1, 1);
		for(Widget widget : this.parent.getWidgets()) {
			if(widget instanceof ButtonList && ((ButtonList) widget).getButtons().contains(this)) {
				((ButtonList) widget).onButtonClick(this);
				return;
			}
		}
		
		this.parent.onButtonClick(this);
	}

	@Override
	public void render() {
		RenderHelper.getHelper().bindTexture("/gui/gui.png", true);
		RenderHelper.getHelper().glColor(1, 1, 1, 1);
		
		int mouseX = RenderHelper.getHelper().getRenderMouseX();
		int mouseY = RenderHelper.getHelper().getRenderMouseY();
		
		byte state = 1;
		boolean hover = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
		if (!this.active) {
			state = 0;
		} else if (hover) {
			state = 2;
		}

		RenderHelper.getHelper().drawImage(this.x, this.y, 0, 0, 46 + state * 20, this.width / 2, this.height);
		RenderHelper.getHelper().drawImage(this.x + this.width / 2, this.y, 0, 200 - this.width / 2, 46 + state * 20, this.width / 2, this.height);
		
		String message = this.text;
		if(message.length() > 30) {
			message = message.substring(0, 30) + "...";
		}
		
		if (!this.active) {
			RenderHelper.getHelper().renderText(message, this.x + this.width / 2, this.y + (this.height - 8) / 2, -6250336);
		} else if (hover) {
			RenderHelper.getHelper().renderText(message, this.x + this.width / 2, this.y + (this.height - 8) / 2, 16777120);
		} else {
			RenderHelper.getHelper().renderText(message, this.x + this.width / 2, this.y + (this.height - 8) / 2, 14737632);
		}
	}
}
