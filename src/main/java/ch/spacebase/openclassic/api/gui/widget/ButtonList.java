package ch.spacebase.openclassic.api.gui.widget;

import java.util.ArrayList;
import java.util.List;

import ch.spacebase.openclassic.api.gui.GuiScreen;

/**
 * Represents a list consisting of buttons.
 */
public class ButtonList extends Widget {

	private List<Button> buttons = new ArrayList<Button>();
	private List<String> contents = new ArrayList<String>();
	
	private int pages = 0;
	private int index = 0;
	
	public ButtonList(int id, int parentWidth, int parentHeight, GuiScreen parent, boolean visible) {
		super(id, 0, 0, parentWidth, parentHeight, parent, visible);
		
		for (int button = 0; button < 5; button++) {
			this.buttons.add(new Button(button, this.width / 2 - 100, this.height / 6 + button * 24, this.parent, false, "---"));
			this.buttons.get(id).setActive(false);
		}
		
		this.buttons.add(new Button(5, this.width / 2 - 200, this.height / 6 + 48, 50, 20, this.parent, true, "Back"));
		this.buttons.add(new Button(6, this.width / 2 + 150, this.height / 6 + 48, 50, 20, this.parent, true, "Next"));
		this.getBackButton().setActive(false);
		this.getNextButton().setActive(false);
	}
	
	/**
	 * Gets the contents of this list.
	 * @return The contents of this list.
	 */
	public List<String> getContents() {
		return this.contents;
	}
	
	/**
	 * Sets the contents of this list.
	 * @param contents The list's new contents.
	 */
	public void setContents(List<String> contents) {
		this.contents = contents;
		this.updateContents();
	}
	
	/**
	 * Gets the current page the list is on.
	 * @return The current page.
	 */
	public int getCurrentPage() {
		return this.index;
	}
	
	/**
	 * Gets the number of pages in this list.
	 * @return The list's page count.
	 */
	public int getPages() {
		return this.pages;
	}
	
	/**
	 * Called when a button on this list is clicked.
	 * @param button Button that was clicked.
	 */
	public void onButtonClick(Button button) {
		if (button.getId() == this.getBackButton().getId()) {
			this.index--;
			button.setActive(this.index > 0);
			this.getNextButton().setActive(this.index < this.pages);
			this.updateContents();
		} else if (button.getId() == this.getNextButton().getId()) {
			this.index++;
			button.setActive(this.index < this.pages);
			this.getBackButton().setActive(this.index > 0);
			this.updateContents();
		} else {
			this.parent.onButtonListClick(this, button);
		}
	}
	
	private void updateContents() {
		this.pages = (int) Math.ceil(this.contents.size() / 5);
		if(this.pages > 0 && this.contents.size() > this.pages * 5) {
			this.getNextButton().setActive(true);
		}
		
		for (int curr = this.index * 5; curr < (this.index + 1) * 5; curr++) {
			boolean content = curr <= this.contents.size() - 1 && curr >= 0 && !this.contents.get(curr).equals("");
			int button = curr - this.index * 5;
			this.getButton(button).setActive(content);
			this.getButton(button).setText(content ? this.contents.get(curr) : "-");
			this.getButton(button).setVisible(true);
		}
	}
	
	/**
	 * Gets the button with the given ID. (0 = top of page, 4 = bottom, 5 = back, 6 = next)
	 * @param button Button to look for.
	 * @return The button with the given ID.
	 */
	public Button getButton(int button) {
		return this.buttons.get(button);
	}
	
	/**
	 * Gets the back button of this list.
	 * @return The list's back button.
	 */
	public Button getBackButton() {
		return this.buttons.get(5);
	}
	
	/**
	 * Gets the next button of this list.
	 * @return The list's next button.
	 */
	public Button getNextButton() {
		return this.buttons.get(6);
	}
	
	/**
	 * Gets all the buttons belonging to this list.
	 * @return The list's buttons.
	 */
	public List<Button> getButtons() {
		return this.buttons;
	}

	@Override
	public void render() {
		for(Button button : this.buttons) {
			button.render();
		}
	}
	
}