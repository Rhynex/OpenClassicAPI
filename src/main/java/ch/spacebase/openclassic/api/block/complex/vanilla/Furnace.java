package ch.spacebase.openclassic.api.block.complex.vanilla;

import ch.spacebase.openclassic.api.inventory.FurnaceInventory;

public interface Furnace {

	public FurnaceInventory getInventory();
	
	public boolean hasFuel();
	
	public int getFuelTime();
	
	public int getRemainingFuel(int scale);
	
	public int getTotalFuelTime();
	
	public int getSmeltTime();
	
	public int getRemainingSmeltTime(int scale);
	
}
