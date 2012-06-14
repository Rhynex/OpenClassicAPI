package ch.spacebase.openclassic.api.gui.widget;

import ch.spacebase.openclassic.api.gui.GuiScreen;

/**
 * Represents a GUI widget.
 */
public abstract class Widget {

	private int id;
	protected boolean visible;
	protected GuiScreen parent;
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	
	public Widget(int id, int x, int y, int width, int height, GuiScreen parent, boolean visible) {
		this.id = id;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.parent = parent;
		this.visible = visible;
	}
	
	/**
	 * Gets the ID of this widget.
	 * @return The widget's ID.
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Returns true if this widget is visible.
	 * @return True if this widget is visible.
	 */
	public boolean isVisible() {
		return this.visible;
	}
	
	/**
	 * Sets whether this widget is visible.
	 * @param Whether this widget is visible.
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	/**
	 * Gets the X of this widget.
	 * @return X of this widget.
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Gets the Y of this widget.
	 * @return Y of this widget.
	 */
	public int getY() {
		return this.y;
	}
	
	/**
	 * Gets the width of this widget.
	 * @return Width of this widget.
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * Gets the height of this widget.
	 * @return Height of this widget.
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * Gets this widget's parent.
	 * @return The widget's parent.
	 */
	public GuiScreen getParent() {
		return this.parent;
	}
	
	/**
	 * Sets this widget's parent.
	 * @param This widget's new parent.
	 */
	public void setParent(GuiScreen screen) {
		this.parent = screen;
	}
	
	/**
	 * Renders the widget.
	 */
	public abstract void render();
	
	/**
	 * Called when a key has been pressed.
	 * @param Character resulting from the key press if applicable.
	 * @param Key that was pressed.
	 */
	public void onKeyPress(char c, int key) {
	}
	
	/**
	 * Called when a tick update occurs.
	 */
	public void update() {
	}
	
	/**
	 * Called when the mouse is clicked.
	 * @param X of the mouse.
	 * @param Y of the mouse.
	 * @param ID of the clicked button.
	 */
	public void onMouseClick(int x, int y, int button) {
	}

	/**
	 * Called when this widget is attached to a GuiScreen.
	 * @param GuiScreen the widget is being attached to.
	 */
	public void onAttached(GuiScreen screen) {
	}
	
	/**
	 * Called when this widget is removed from a GuiScreen.
	 * @param GuiScreen the widget is being removed from.
	 */
	public void onRemoved(GuiScreen screen) {
	}
	
}
