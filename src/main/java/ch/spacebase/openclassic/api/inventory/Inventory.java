package ch.spacebase.openclassic.api.inventory;

import java.util.Arrays;

import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.item.Item;
import ch.spacebase.openclassic.api.item.Items;

public class Inventory {

	private ItemStack contents[];
	
	public Inventory(int size) {
		this.contents = new ItemStack[size];
	}
	
	public ItemStack[] getContents() {
		return Arrays.copyOf(this.contents, this.contents.length);
	}
	
	public void setContents(ItemStack items[]) {
		this.contents = Arrays.copyOf(items, this.contents.length);
	}
	
	public ItemStack getItem(int slot) {
		return this.contents[slot];
	}
	
	public void setItem(int slot, ItemStack item) {
		this.contents[slot] = item == null || item.getSize() <= 0 ? null : item;
	}
	
	public boolean contains(BlockType block) {
		return this.contains(Items.get(block.getId(), block.getData()));
	}
	
	public boolean contains(Item item) {
		for(ItemStack i : this.contents) {
			if(i != null && i.getItem() == item) return true;
		}
		
		return false;
	}
	
	public boolean contains(BlockType block, int size) {
		return this.contains(Items.get(block.getId(), block.getData()), size);
	}
	
	public boolean contains(Item item, int size) {
		for(ItemStack i : this.contents) {
			if(i != null && i.getItem() == item && i.getSize() == size) return true;
		}
		
		return false;
	}
	
	public int first(BlockType block) {
		return this.first(Items.get(block.getId(), block.getData()));
	}
	
	public int first(Item item) {
		int slot = 0;
		for(ItemStack i : this.contents) {
			if(i != null && i.getItem() == item) return slot;
			slot++;
		}
		
		return -1;
	}
	
	public int firstNotFull(BlockType block) {
		return this.firstNotFull(Items.get(block.getId(), block.getData()));
	}
	
	public int firstNotFull(Item item) {
		int slot = 0;
		for(ItemStack i : this.contents) {
			if(i != null && i.getItem() == item && i.getSize() < item.getMaxStackSize()) return slot;
			slot++;
		}
		
		return -1;
	}
	
	public int firstEmpty() {
		int slot = 0;
		for(ItemStack i : this.contents) {
			if(i == null) return slot;
			slot++;
		}
		
		return -1;
	}
	
	public ItemStack add(ItemStack item) {
		int slot = this.firstNotFull(item.getItem());
		if(slot == -1) slot = this.firstEmpty();
		if(slot == -1) return item;
		ItemStack it = this.getItem(slot);
		int curr = it != null ? it.getSize() : 0;
		if(item.getSize() > item.getItem().getMaxStackSize() - curr) {
			item.setSize(item.getSize() - (item.getItem().getMaxStackSize() - curr));
			if(it != null) {
				it.setSize(item.getItem().getMaxStackSize());
			} else {
				this.setItem(slot, new ItemStack(item.getItem(), item.getItem().getMaxStackSize()));
			}
			
			System.out.println(item.getSize() + ", " + (item.getItem().getMaxStackSize() - curr));
			ItemStack result = this.add(item);
			return result;
		}
		
		if(it != null) {
			it.setSize(it.getSize() + item.getSize());
		} else {
			this.setItem(slot, new ItemStack(item.getItem(), item.getSize()));
		}
		
		return null;
	}
	
	public int getSize() {
		return this.contents.length;
	}

	public void clear() {
		for(int slot = 0; slot < this.contents.length; slot++) {
			this.contents[slot] = null;
		}
	}
	
}
