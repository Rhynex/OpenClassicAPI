package ch.spacebase.openclassic.api.inventory.recipe;

import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.inventory.ItemStack;
import ch.spacebase.openclassic.api.item.Item;
import ch.spacebase.openclassic.api.item.Items;

public class SmeltingRecipe implements Recipe {

	private Item in;
	private ItemStack result;
	
	public SmeltingRecipe(BlockType in, ItemStack result) {
		this(Items.get(in.getId(), in.getData()), result);
	}
	
	public SmeltingRecipe(Item in, ItemStack result) {
		this.in = in;
		this.result = result;
	}
	
	public Item getInput() {
		return this.in;
	}
	
	@Override
	public ItemStack getResult() {
		return this.result;
	}
	
}
