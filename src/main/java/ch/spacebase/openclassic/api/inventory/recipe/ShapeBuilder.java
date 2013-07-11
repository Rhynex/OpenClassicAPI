package ch.spacebase.openclassic.api.inventory.recipe;

import java.util.HashMap;
import java.util.Map;

import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.inventory.ItemStack;
import ch.spacebase.openclassic.api.item.Item;

public class ShapeBuilder {

	private ItemStack result;
	private Map<Character, Object> ingreds = new HashMap<Character, Object>();
	private String shape[] = new String[0];
	
	public ShapeBuilder(ItemStack result) {
		this.result = result;
	}
	
	public void setShape(String shape[]) {
		this.shape = shape;
	}
	
	public void addIngredient(char c, Item ingred) {
		this.ingreds.put(c, ingred);
	}
	
	public void addIngredient(char c, BlockType ingred) {
		this.ingreds.put(c, ingred);
	}
	
	public ShapedRecipe build() {
		Object params[] = new Object[this.ingreds.size() * 2];
		int index = 0;
		for(char c : this.ingreds.keySet()) {
			params[index++] = c;
			params[index++] = this.ingreds.get(c);
		}
		
		return new ShapedRecipe(this.result, this.shape, params);
	}
	
}
