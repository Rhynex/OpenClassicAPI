package ch.spacebase.openclassic.api.inventory.recipe;

import java.util.ArrayList;
import java.util.List;

import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.inventory.ItemStack;
import ch.spacebase.openclassic.api.item.Item;
import ch.spacebase.openclassic.api.item.Items;

public class RecipeManager {

	private List<CraftingRecipe> crafting = new ArrayList<CraftingRecipe>();
	private List<SmeltingRecipe> smelting = new ArrayList<SmeltingRecipe>();
	private List<Fuel> fuels = new ArrayList<Fuel>();
	
	public List<CraftingRecipe> getCraftingRecipes() {
		return new ArrayList<CraftingRecipe>(this.crafting);
	}
	
	public List<SmeltingRecipe> getSmeltingRecipes() {
		return new ArrayList<SmeltingRecipe>(this.smelting);
	}
	
	public List<Fuel> getFuels() {
		return new ArrayList<Fuel>(this.fuels);
	}
	
	public CraftingRecipe getCraftingRecipe(ItemStack items[]) {
		for(CraftingRecipe recipe : this.crafting) {
			if(recipe.matches(items)) return recipe;
		}
		
		return null;
	}
	
	public SmeltingRecipe getSmeltingRecipe(BlockType in) {
		return this.getSmeltingRecipe(Items.get(in.getId(), in.getData()));
	}
	
	public Fuel getFuel(Item item) {
		for(Fuel fuel : this.fuels) {
			if(fuel.getFuel() == item) return fuel;
		}
		
		return null;
	}
	
	public SmeltingRecipe getSmeltingRecipe(Item in) {
		for(SmeltingRecipe recipe : this.smelting) {
			if(in == recipe.getInput()) return recipe;
		}
		
		return null;
	}
	
	public void registerCrafting(CraftingRecipe recipe) {
		this.crafting.add(recipe);
	}
	
	public void registerSmelting(SmeltingRecipe recipe) {
		this.smelting.add(recipe);
	}
	
	public void registerFuel(Fuel fuel) {
		this.fuels.add(fuel);
	}
	
	public void clear() {
		this.crafting.clear();
		this.smelting.clear();
		this.fuels.clear();
	}

}
