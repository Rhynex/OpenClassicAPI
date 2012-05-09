package ch.spacebase.openclassic.api.block.physics;

import ch.spacebase.openclassic.api.block.Block;

public interface BlockPhysics {

	public boolean tick(Block block);
	
	public void onPlace(Block block);
	
	public void onBreak(Block block);
	
}
