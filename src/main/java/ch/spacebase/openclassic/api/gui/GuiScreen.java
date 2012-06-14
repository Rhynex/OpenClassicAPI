package ch.spacebase.openclassic.api.gui;

import java.util.ArrayList;
import java.util.List;

import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.gui.widget.Button;
import ch.spacebase.openclassic.api.gui.widget.ButtonList;
import ch.spacebase.openclassic.api.gui.widget.Widget;
import ch.spacebase.openclassic.api.input.InputHelper;
import ch.spacebase.openclassic.api.input.Keyboard;

/**
 * Represents a GUI screen.
 */
public abstract class GuiScreen implements Screen {
	
	private List<Widget> widgets = new ArrayList<Widget>();
	private int width;
	private int height;
	private boolean grab;
	
	/**
	 * Attaches a widget to this GuiScreen.
	 * @param Widget to attach.
	 */
	public void attachWidget(Widget widget) {
		this.widgets.add(widget);
		widget.setParent(this);
		widget.onAttached(this);
	}
	
	/**
	 * Removes a widget from this GuiScreen.
	 * @param ID of the widget.
	 */
	public void removeWidget(int id) {
		for(Widget widget : this.widgets) {
			if(widget.getId() == id) this.removeWidget(widget);
		}
	}
	
	/**
	 * Removes a widget from this GuiScreen.
	 * @param Widget to remove.
	 */
	public void removeWidget(Widget widget) {
		this.widgets.remove(widget);
		widget.setParent(null);
		widget.onRemoved(this);
	}
	
	/**
	 * Clears the widget list.
	 */
	public void clearWidgets() {
		this.widgets.clear();
	}
	
	/**
	 * Gets the widget with the given ID.
	 * @param ID to look for.
	 * @return The widget.
	 */
	public Widget getWidget(int id) {
		for(Widget widget : this.widgets) {
			if(widget.getId() == id) return widget;
		}
		
		return null;
	}
	
	/**
	 * Gets the widget with the given ID and type.
	 * @param ID to look for.
	 * @param Type of widget to look for.
	 * @return The widget.
	 */
	@SuppressWarnings("unchecked")
	public <T extends Widget> T getWidget(int id, Class<T> type) {
		for(Widget widget : this.widgets) {
			if(widget.getId() == id && type.isInstance(widget)) return (T) widget;
		}
		
		return null;
	}
	
	/**
	 * Gets a list of all widgets attached to this GuiScreen.
	 * @return All the attached widgets.
	 */
	public List<Widget> getWidgets() {
		return new ArrayList<Widget>(this.widgets);
	}
	
	/**
	 * Opens the GUI screen.
	 * @param Width of the screen.
	 * @param Height of the screen.
	 */
	public void open(int width, int height) {
		this.width = width;
		this.height = height;
		this.onOpen();
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * Returns true if this GuiScreen grabs the mouse.
	 * @return True if the screen grabs the mouse.
	 */
	public boolean grabsInput() {
		return this.grab;
	}
	
	/**
	 * Sets whether the screen grabs the mouse.
	 * @param Whether the screen grabs the mouse.
	 */
	public void setGrabsInput(boolean grab) {
		this.grab = grab;
	}
	
	/**
	 * Called when the GuiScreen is opened.
	 */
	public void onOpen() {
	}
	
	/**
	 * Called when the GuiScreen is closed.
	 */
	public void onClose() {
	}
	
	/**
	 * Called when a button widget is clicked.
	 * @param Button that was clicked.
	 */
	public void onButtonClick(Button button) {
	}
	
	/**
	 * Called when a button belonging to a ButtonList widget is clicked.
	 * @param ButtonList the button belongs to.
	 * @param Button that was clicked.
	 */
	public void onButtonListClick(ButtonList list, Button button) {
	}
	
	/**
	 * Called when the mouse is clicked.
	 * @param X of the mouse.
	 * @param Y of the mouse.
	 * @param ID of the clicked button.
	 */
	public void onMouseClick(int x, int y, int button) {
		for (Widget curr : this.widgets) {
			if(curr instanceof ButtonList) {
				for(Button b : ((ButtonList) curr).getButtons()) {
					if (x >= b.getX() && y >= b.getY() && x < b.getX() + b.getWidth() && y < b.getY() + b.getHeight()) {
						b.onMouseClick(x, y, button);
					}
				}
			} else if (x >= curr.getX() && y >= curr.getY() && x < curr.getX() + curr.getWidth() && y < curr.getY() + curr.getHeight()) {
				curr.onMouseClick(x, y, button);
			}
		}
	}
	
	/**
	 * Called when a key is pressed.
	 * @param Character resulting from the key press if applicable.
	 * @param ID of the pressed key.
	 */
	public void onKeyPress(char c, int key) {
		if (key == Keyboard.KEY_ESCAPE && OpenClassic.getClient().isInGame()) {
			OpenClassic.getClient().setCurrentScreen(null);
			InputHelper.getHelper().grabMouse();
		} else {
			for (Widget curr : this.widgets) {
				curr.onKeyPress(c, key);
			}
		}
	}
	
	/**
	 * Called when a tick update occurs.
	 */
	public void update() {
		for(Widget widget : this.widgets) {
			widget.update();
		}
	}
	
	/**
	 * Renders the GuiScreen.
	 */
	public void render() {
		for (Widget widget : this.widgets) {
			if (widget.isVisible()) {
				widget.render();
			}
		}
	}
	
}
