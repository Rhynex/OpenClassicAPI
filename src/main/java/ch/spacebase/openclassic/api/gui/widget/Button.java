package ch.spacebase.openclassic.api.gui.widget;

import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.gui.GuiScreen;
import ch.spacebase.openclassic.api.gui.Screen;

/**
 * Represents a button.
 */
public abstract class Button extends Widget {
	
	private String text;
	private boolean active = true;

	public Button(int id, int x, int y, Screen parent, String text) {
		this(id, x, y, 200, 20, parent, text);
	}
	
	public Button(int id, int x, int y, int width, int height, Screen parent, String text) {
		super(id, x, y, width, height, parent);
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
		
		if(this.parent instanceof GuiScreen) {
			((GuiScreen) this.parent).onButtonClick(this);
		}
	}

}
