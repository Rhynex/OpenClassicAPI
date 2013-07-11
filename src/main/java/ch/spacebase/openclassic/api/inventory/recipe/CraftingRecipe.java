package ch.spacebase.openclassic.api.inventory.recipe;

import ch.spacebase.openclassic.api.inventory.ItemStack;

public interface CraftingRecipe extends Recipe {
	
	public void craft(ItemStack items[]);
	
	public boolean matches(ItemStack items[]);
	
}
