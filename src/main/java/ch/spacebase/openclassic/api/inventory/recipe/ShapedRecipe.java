package ch.spacebase.openclassic.api.inventory.recipe;

import java.util.HashMap;
import java.util.Map;

import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.inventory.ItemStack;
import ch.spacebase.openclassic.api.item.Item;

public class ShapedRecipe implements CraftingRecipe {

	private int width;
	private int height;
	private ItemStack ingredients[];
	private ItemStack result;

	public ShapedRecipe(ItemStack result, String shape[], Object... params) {
		String rows = "";
		int width = 0;
		int height = 0;
		for(int index = 0; index < shape.length; index++) {
			String row = shape[index];
			height++;
			width = row.length();
			rows += row;
		}

		Map<Character, ItemStack> charmap = new HashMap<Character, ItemStack>();
		for(int param = 0; param < params.length; param += 2) {
			char c = (Character) params[param];
			ItemStack it = null;
			if(params[param + 1] instanceof Item) {
				it = new ItemStack((Item) params[param + 1]);
			} else if(params[param + 1] instanceof BlockType) {
				it = new ItemStack((BlockType) params[param + 1]);
			}

			charmap.put(c, it);
		}

		ItemStack items[] = new ItemStack[width * height];
		for(int count = 0; count < width * height; count++) {
			char c = rows.charAt(count);
			if(charmap.containsKey(c)) {
				items[count] = charmap.get(c);
			}
		}

		this.width = width;
		this.height = height;
		this.ingredients = items;
		this.result = result;
	}
	
	public ShapedRecipe(int width, int height, ItemStack ingreds[], ItemStack result) {
		this.width = width;
		this.height = height;
		this.ingredients = ingreds;
		this.result = result;
	}

	@Override
	public boolean matches(ItemStack items[]) {
		for(int row = 0; row <= 3 - this.width; row++) {
			for(int col = 0; col <= 3 - this.height; col++) {
				if(this.match(items, row, col, true) || this.match(items, row, col, false)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean match(ItemStack items[], int row, int col, boolean reverse) {
		for(int x = 0; x < 3; x++) {
			for(int y = 0; y < 3; y++) {
				int px = x - row;
				int py = y - col;
				ItemStack ingred = null;
				if(px >= 0 && py >= 0 && px < this.width && py < this.height) {
					if(reverse) {
						ingred = this.ingredients[(this.width - px - 1) + py * this.width];
					} else {
						ingred = this.ingredients[px + py * this.width];
					}
				}

				if(ingred == null && items[x + y * 3] == null) continue;
				if(ingred == null || items[x + y * 3] == null || items[x + y * 3].getItem() != ingred.getItem()) {
					return false;
				}
			}
		}

		return true;
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
	public ItemStack getResult() {
		return this.result.clone();
	}

	public int getSize() {
		return this.width * this.height;
	}

}
