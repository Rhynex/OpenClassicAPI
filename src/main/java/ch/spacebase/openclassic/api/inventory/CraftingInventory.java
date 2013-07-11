package ch.spacebase.openclassic.api.inventory;

public class CraftingInventory extends Inventory {

	private CraftingListener parent;
	private int width;
	private int height;
	
	public CraftingInventory(CraftingListener parent, int width, int height) {
		super(width * height);
		this.parent = parent;
		this.width = width;
		this.height = height;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	@Override
	public void setContents(ItemStack contents[]) {
		super.setContents(contents);
		this.parent.updateCrafting(this);
	}
	
	@Override
	public void setItem(int slot, ItemStack item) {
		super.setItem(slot, item);
		this.parent.updateCrafting(this);
	}

}
