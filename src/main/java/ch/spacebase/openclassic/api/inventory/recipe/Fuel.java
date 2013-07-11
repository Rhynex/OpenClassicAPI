package ch.spacebase.openclassic.api.inventory.recipe;

import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.item.Item;
import ch.spacebase.openclassic.api.item.Items;

public class Fuel {

	private Item fuel;
	private int time;
	
	public Fuel(BlockType fuel, int time) {
		this(Items.get(fuel.getId(), fuel.getData()), time);
	}
	
	public Fuel(Item fuel, int time) {
		this.fuel = fuel;
		this.time = time;
	}
	
	public Item getFuel() {
		return this.fuel;
	}
	
	public int getTime() {
		return this.time;
	}
	
 }
