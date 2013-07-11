package ch.spacebase.openclassic.api.inventory.recipe;

import java.util.ArrayList;
import java.util.List;

import ch.spacebase.openclassic.api.inventory.ItemStack;
import ch.spacebase.openclassic.api.item.Item;

public class ShapelessRecipe implements CraftingRecipe {

	private ItemStack result;
	private List<ItemStack> items = new ArrayList<ItemStack>();
	
	public ShapelessRecipe(ItemStack result) {
		this.result = result.clone();
	}
	
	public List<ItemStack> getItems() {
		return new ArrayList<ItemStack>(this.items);
	}
	
	public void addItem(ItemStack item) {
		this.items.add(item.clone());
	}
	
	@Override
	public ItemStack getResult() {
		return this.result.clone();
	}

	@Override
	public void craft(ItemStack[] items) {
		for(int slot = 0; slot < items.length; slot++) {
			if(items[slot] != null) {
				items[slot].setSize(items[slot].getSize() - 1);
				if(items[slot].getSize() <= 0) items[slot] = null;
			}
		}
	}
	
	@Override
	public boolean matches(ItemStack[] items) {
		List<Item> tmp = new ArrayList<Item>();
		for(ItemStack item : this.items) {
			tmp.add(item.getItem());
		}
		
		for(ItemStack item : items) {
			if(item == null) continue;
			if(tmp.contains(item.getItem())) {
				tmp.remove(item.getItem());
			} else {
				return false;
			}
		}
		
		if(tmp.size() > 0) return false;
		return true;
	}

}
