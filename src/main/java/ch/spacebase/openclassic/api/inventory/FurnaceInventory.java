package ch.spacebase.openclassic.api.inventory;


public class FurnaceInventory extends Inventory {
	
	public FurnaceInventory() {
		super(3);
	}
	
	public ItemStack getSmelting() {
		return this.getItem(0);
	}
	
	public void setSmelting(ItemStack item) {
		this.setItem(0, item);
	}
	
	public ItemStack getFuel() {
		return this.getItem(1);
	}
	
	public void setFuel(ItemStack item) {
		this.setItem(1, item);
	}
	
	public ItemStack getResult() {
		return this.getItem(2);
	}
	
	public void setResult(ItemStack item) {
		this.setItem(2, item);
	}

}
