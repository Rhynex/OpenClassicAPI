package ch.spacebase.openclassic.api.gui.widget;

import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.block.model.SubTexture;
import ch.spacebase.openclassic.api.gui.Screen;

/**
 * A factory for creating widgets.
 */
public abstract class WidgetFactory {

	private static WidgetFactory factory;
	
	/**
	 * Gets the widget factory instance.
	 * @return The widget factory instance.
	 */
	public static WidgetFactory getFactory() {
		return WidgetFactory.factory;
	}
	
	/**
	 * Sets the widget factory instance if it is not already set.
	 * @param factory Widget factory to use.
	 */
	public static void setFactory(WidgetFactory factory) {
		if(WidgetFactory.factory != null) {
			return;
		}
		
		WidgetFactory.factory = factory;
	}
	
	/**
	 * Creates a new block preview widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param parent Parent screen of the widget.
	 * @param type BlockType to show.
	 * @return The created widget.
	 */
	public abstract BlockPreview newBlockPreview(int id, int x, int y, Screen parent, BlockType type);
	
	/**
	 * Creates a new block preview widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param parent Parent screen of the widget.
	 * @param type BlockType to show.
	 * @param scale Scale to use when showing the block.
	 * @return The created widget.
	 */
	public abstract BlockPreview newBlockPreview(int id, int x, int y, Screen parent, BlockType type, float scale);
	
	/**
	 * Creates a new button widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param parent Parent screen of the widget.
	 * @param text Text to show in the button.
	 * @return The created widget.
	 */
	public abstract Button newButton(int id, int x, int y, Screen parent, String text);
	
	/**
	 * Creates a new button widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param width Width of the widget.
	 * @param height Height of the widget.
	 * @param parent Parent screen of the widget.
	 * @param text Text to show in the button.
	 * @return The created widget.
	 */
	public abstract Button newButton(int id, int x, int y, int width, int height, Screen parent, String text);
	
	/**
	 * Creates a new default background widget.
	 * @param id Id of the widget.
	 * @param parent Parent screen of the widget.
	 * @return The created widget.
	 */
	public abstract DefaultBackground newDefaultBackground(int id, Screen parent);
	
	/**
	 * Creates a new fading box widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param width Width of the widget.
	 * @param height Height of the widget.
	 * @param parent Parent screen of the widget.
	 * @param color Color to use in the fading box.
	 * @param fadeTo Color to fade to in the fading box.
	 * @return The created widget.
	 */
	public abstract FadingBox newFadingBox(int id, int x, int y, int width, int height, Screen parent, int color, int fadeTo);
	
	/**
	 * Creates a new image widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param parent Parent screen of the widget.
	 * @param tex SubTexture to use in the widget.
	 * @return The created widget.
	 */
	public abstract Image newImage(int id, int x, int y, Screen parent, SubTexture tex);
	
	/**
	 * Creates a new label widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param parent Parent screen of the widget.
	 * @param text Text to display in the label.
	 * @return The created widget.
	 */
	public abstract Label newLabel(int id, int x, int y, Screen parent, String text);
	
	/**
	 * Creates a new label widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param parent Parent screen of the widget.
	 * @param text Text to display in the label.
	 * @param xCenter Whether to center the text on the given X value.
	 * @return The created widget.
	 */
	public abstract Label newLabel(int id, int x, int y, Screen parent, String text, boolean xCenter);
	
	/**
	 * Creates a new label widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param parent Parent screen of the widget.
	 * @param text Text to display in the label.
	 * @param xCenter Whether to center the text on the given X value.
	 * @param scaled Whether to scale the text up 2x.
	 * @return The created widget.
	 */
	public abstract Label newLabel(int id, int x, int y, Screen parent, String text, boolean xCenter, boolean scaled);
	
	/**
	 * Creates a new password text box widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param parent Parent screen of the widget.
	 * @return The created widget.
	 */
	public abstract PasswordTextBox newPasswordTextBox(int id, int x, int y, Screen parent);
	
	/**
	 * Creates a new password text box widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param parent Parent screen of the widget.
	 * @param max The maximum number of characters that can be entered into this text box.
	 * @return The created widget.
	 */
	public abstract PasswordTextBox newPasswordTextBox(int id, int x, int y, Screen parent, int max);
	
	/**
	 * Creates a new password text box widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param width Width of the widget.
	 * @param height Height of the widget.
	 * @param parent Parent screen of the widget.
	 * @return The created widget.
	 */
	public abstract PasswordTextBox newPasswordTextBox(int id, int x, int y, int width, int height, Screen parent);
	
	/**
	 * Creates a new password text box widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param width Width of the widget.
	 * @param height Height of the widget.
	 * @param parent Parent screen of the widget.
	 * @param max The maximum number of characters that can be entered into this text box.
	 * @return The created widget.
	 */
	public abstract PasswordTextBox newPasswordTextBox(int id, int x, int y, int width, int height, Screen parent, int max);
	
	/**
	 * Creates a new password text box widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param parent Parent screen of the widget.
	 * @param chatbox Whether this text box should be displayed as a chat box.
	 * @return The created widget.
	 */
	public abstract PasswordTextBox newPasswordTextBox(int id, int x, int y, Screen parent, boolean chatbox);
	
	/**
	 * Creates a new password text box widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param parent Parent screen of the widget.
	 * @param max The maximum number of characters that can be entered into this text box.
	 * @param chatbox Whether this text box should be displayed as a chat box.
	 * @return The created widget.
	 */
	public abstract PasswordTextBox newPasswordTextBox(int id, int x, int y, Screen parent, int max, boolean chatbox);
	
	/**
	 * Creates a new password text box widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param width Width of the widget.
	 * @param height Height of the widget.
	 * @param parent Parent screen of the widget.
	 * @param chatbox Whether this text box should be displayed as a chat box.
	 * @return The created widget.
	 */
	public abstract PasswordTextBox newPasswordTextBox(int id, int x, int y, int width, int height, Screen parent, boolean chatbox);
	
	/**
	 * Creates a new password text box widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param width Width of the widget.
	 * @param height Height of the widget.
	 * @param parent Parent screen of the widget.
	 * @param max The maximum number of characters that can be entered into this text box.
	 * @param chatbox Whether this text box should be displayed as a chat box.
	 * @return The created widget.
	 */
	public abstract PasswordTextBox newPasswordTextBox(int id, int x, int y, int width, int height, Screen parent, int max, boolean chatbox);
	
	/**
	 * Creates a new state button widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param parent Parent screen of the widget.
	 * @param text Text to show in the button.
	 * @return The created widget.
	 */
	public abstract StateButton newStateButton(int id, int x, int y, Screen parent, String text);
	
	/**
	 * Creates a new state button widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param width Width of the widget.
	 * @param height Height of the widget.
	 * @param parent Parent screen of the widget.
	 * @param text Text to show in the button.
	 * @return The created widget.
	 */
	public abstract StateButton newStateButton(int id, int x, int y, int width, int height, Screen parent, String text);
	
	/**
	 * Creates a new text box widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param parent Parent screen of the widget.
	 * @return The created widget.
	 */
	public abstract TextBox newTextBox(int id, int x, int y, Screen parent);
	
	/**
	 * Creates a new text box widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param parent Parent screen of the widget.
	 * @param max The maximum number of characters that can be entered into this text box.
	 * @return The created widget.
	 */
	public abstract TextBox newTextBox(int id, int x, int y, Screen parent, int max);
	
	/**
	 * Creates a new text box widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param width Width of the widget.
	 * @param height Height of the widget.
	 * @param parent Parent screen of the widget.
	 * @return The created widget.
	 */
	public abstract TextBox newTextBox(int id, int x, int y, int width, int height, Screen parent);
	
	/**
	 * Creates a new text box widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param width Width of the widget.
	 * @param height Height of the widget.
	 * @param parent Parent screen of the widget.
	 * @param max The maximum number of characters that can be entered into this text box.
	 * @return The created widget.
	 */
	public abstract TextBox newTextBox(int id, int x, int y, int width, int height, Screen parent, int max);
	
	/**
	 * Creates a new text box widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param parent Parent screen of the widget.
	 * @param chatbox Whether this text box should be displayed as a chat box.
	 * @return The created widget.
	 */
	public abstract TextBox newTextBox(int id, int x, int y, Screen parent, boolean chatbox);
	
	/**
	 * Creates a new text box widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param parent Parent screen of the widget.
	 * @param max The maximum number of characters that can be entered into this text box.
	 * @param chatbox Whether this text box should be displayed as a chat box.
	 * @return The created widget.
	 */
	public abstract TextBox newTextBox(int id, int x, int y, Screen parent, int max, boolean chatbox);
	
	/**
	 * Creates a new text box widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param width Width of the widget.
	 * @param height Height of the widget.
	 * @param parent Parent screen of the widget.
	 * @param chatbox Whether this text box should be displayed as a chat box.
	 * @return The created widget.
	 */
	public abstract TextBox newTextBox(int id, int x, int y, int width, int height, Screen parent, boolean chatbox);
	
	/**
	 * Creates a new text box widget.
	 * @param id Id of the widget.
	 * @param x X of the widget.
	 * @param y Y of the widget.
	 * @param width Width of the widget.
	 * @param height Height of the widget.
	 * @param parent Parent screen of the widget.
	 * @param max The maximum number of characters that can be entered into this text box.
	 * @param chatbox Whether this text box should be displayed as a chat box.
	 * @return The created widget.
	 */
	public abstract TextBox newTextBox(int id, int x, int y, int width, int height, Screen parent, int max, boolean chatbox);
	
	/**
	 * Creates a new translucent background widget.
	 * @param id Id of the widget.
	 * @param parent Parent screen of the widget.
	 * @return The created widget.
	 */
	public abstract TranslucentBackground newTranslucentBackground(int id, Screen parent);
	
}
