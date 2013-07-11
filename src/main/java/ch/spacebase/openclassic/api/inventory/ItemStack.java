package ch.spacebase.openclassic.api.inventory;

import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.item.Item;
import ch.spacebase.openclassic.api.item.Items;

public class ItemStack implements Cloneable {

	private Item item;
	private int size;
	private int damage = 0;
	
	public ItemStack(BlockType block) {
		this(block, 1);
	}
	
	public ItemStack(BlockType block, int size) {
		this(Items.get(block.getId(), block.getData()), size);
	}
	
	public ItemStack(Item item) {
		this(item, 1);
	}
	
	public ItemStack(Item item, int size) {
		this.item = item;
		this.size = size;
	}
	
	public Item getItem() {
		return this.item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public void damage() {
		if(this.damage > this.item.getMaxDamage()) return;
		this.damage++;
	}
	
	public ItemStack clone() {
		return new ItemStack(this.item, this.size);
	}
	
	public boolean equals(Object o) {
		if(!(o instanceof ItemStack)) return false;
		ItemStack item = (ItemStack) o;
		return this.item == item.item && this.size == item.size;
	}
	
	public String toString() {
		return "ItemStack{id=" + this.item.getId() + ",data=" + this.item.getData() + ",size=" + this.size + "}";
	}
	
}
