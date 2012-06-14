package ch.spacebase.openclassic.api.gui.widget;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import ch.spacebase.openclassic.api.gui.GuiScreen;
import ch.spacebase.openclassic.api.input.InputHelper;
import ch.spacebase.openclassic.api.input.Keyboard;
import ch.spacebase.openclassic.api.render.RenderHelper;

/**
 * Represents a text box.
 */
public class TextBox extends Widget {

	private static final String ALLOWED = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ,.:;-_\'*!\"#@%$/()=+?[]{}<>^";
	
	private String text = "";
	private boolean focus;
	private int cursor = 0;
	private boolean blink = true;
	private int blinkDelay = 6;
	private int max;
	
	private boolean chatbox;
	
	public TextBox(int id, int x, int y, GuiScreen parent, boolean visible, boolean focus) {
		this(id, x, y, parent, visible, focus, 0);
	}
	
	public TextBox(int id, int x, int y, GuiScreen parent, boolean visible, boolean focus, int max) {
		this(id, x, y, 200, 20, parent, visible, focus, max);
	}
	
	public TextBox(int id, int x, int y, int width, int height, GuiScreen parent, boolean visible, boolean focus) {
		this(id, x, y, width, height, parent, visible, focus, false);
	}
	
	public TextBox(int id, int x, int y, int width, int height, GuiScreen parent, boolean visible, boolean focus, int max) {
		this(id, x, y, width, height, parent, visible, focus, max, false);
	}
	
	public TextBox(int id, int x, int y, GuiScreen parent, boolean visible, boolean focus, boolean chatbox) {
		this(id, x, y, 200, 20, parent, visible, focus, chatbox);
	}
	
	public TextBox(int id, int x, int y, GuiScreen parent, boolean visible, boolean focus, int max, boolean chatbox) {
		this(id, x, y, 200, 20, parent, visible, focus, chatbox);
	}
	
	public TextBox(int id, int x, int y, int width, int height, GuiScreen parent, boolean visible, boolean focus, boolean chatbox) {
		this(id, x, y, width, height, parent, visible, focus, 0, chatbox);
	}
	
	public TextBox(int id, int x, int y, int width, int height, GuiScreen parent, boolean visible, boolean focus, int max, boolean chatbox) {
		super(id, x, y, width, height, parent, visible);
		this.focus = focus;
		this.chatbox = chatbox;
		this.max = max;
	}
	
	/**
	 * Returns true if the text box has the keyboard's focus.
	 * @return True if the text box has focus.
	 */
	public boolean hasFocus() {
		return this.focus;
	}
	
	/**
	 * Sets whether the text box has the keyboard's focus.
	 * @param Whether the text box has focus.
	 */
	public void setFocus(boolean focus) {
		this.focus = focus;
	}
	
	/**
	 * Gets the text in this text box.
	 * @return The text box's text.
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Sets the text in this text box.
	 * @param The text to set.
	 */
	public void setText(String text) {
		this.text = text;
		if(this.text == null) this.text = "";
		
		this.cursor = text.length();
	}
	
	@Override
	public void update() {
		if(!this.focus) {
			if(this.blinkDelay != 10 && !this.blink) {
				this.blink = true;
			}
		} else {
			this.blinkDelay--;
			if(this.blinkDelay <= 0) {
				this.blink = !this.blink;
				this.blinkDelay = 6;
			}
		}
	}
	
	@Override
	public void onKeyPress(char c, int key) {
		if(!this.focus) return;
		
		if (key == Keyboard.KEY_BACK && this.text.length() > 0 && this.cursor > 0) {
			this.text = this.text.substring(0, this.cursor - 1) + this.text.substring(this.cursor);
			this.cursor--;
		}
		
		if(key == Keyboard.KEY_V && InputHelper.getHelper().isKeyDown(Keyboard.KEY_LCONTROL)) {
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			Transferable transfer = clipboard.getContents(null);
			if(transfer != null) {
				try {
					for(char ch : ((String) transfer.getTransferData(DataFlavor.stringFlavor)).toCharArray()) {
						if (ALLOWED.indexOf(ch) >= 0) {
							this.text = this.text.substring(0, this.cursor) + ch + this.text.substring(this.cursor, this.text.length());
							this.cursor++;
						}
					}
				} catch (UnsupportedFlavorException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		if(key == Keyboard.KEY_LEFT && this.cursor > 0) {
			this.cursor--;
		}
		
		if(key == Keyboard.KEY_RIGHT && this.cursor < this.text.length()) {
			this.cursor++;
		}

		if (ALLOWED.indexOf(c) >= 0 && !((this.chatbox && this.text.length() >= 64) || (this.max > 0 && this.text.length() >= this.max))) {
			this.text = this.text.substring(0, this.cursor) + c + this.text.substring(this.cursor, this.text.length());
			this.cursor++;
		}
	}
	
	@Override
	public void onMouseClick(int x, int y, int button) {
		if(button != 0) return;
		
		if(!this.focus) {
			this.focus = true;
			for(Widget widget : this.parent.getWidgets()) {
				if(widget instanceof TextBox && ((TextBox) widget).hasFocus() && widget.getId() != this.getId()) {
					((TextBox) widget).setFocus(false);
				}
			}
		}
	}
	
	@Override
	public void render() {
		if(!this.chatbox) RenderHelper.getHelper().drawBox(this.x - 1, this.y - 1, this.x + this.width + 1, this.y + this.height + 1, -6250336);
		RenderHelper.getHelper().drawBox(this.x, this.y, this.x + this.width, this.y + this.height, (!this.chatbox ? -16777216 : Integer.MIN_VALUE));
		
		RenderHelper.getHelper().renderText(this.text.substring(0, this.cursor) + (this.blink && this.focus ? "|" : "") + this.text.substring(this.cursor, this.text.length()), this.x + 4, (this.chatbox ? this.y + 2 : this.y + 6), 14737632, false);
	}

}
