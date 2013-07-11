package ch.spacebase.openclassic.api.inventory;

public class PlayerInventory extends Inventory {

	private int selected = 0;
	
	public PlayerInventory() {
		super(36);
	}
	
	public int getSelectedSlot() {
		return this.selected;
	}
	
	public void setSelectedSlot(int slot) {
		this.selected = slot;
	}
	
	public ItemStack getHeldItem() {
		return this.getItem(this.selected);
	}
	
	public void setHeldItem(ItemStack item) {
		this.setItem(this.selected, item);
	}
	
	public void scroll(int mod) {
		this.selected -= mod;
		while(this.selected < 0) {
			this.selected += 9;
		}

		while(this.selected >= 9) {
			this.selected -= 9;
		}
	}

}
