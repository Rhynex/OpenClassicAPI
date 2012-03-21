package com.github.steveice10.openclassic.api.block.physics;

import com.github.steveice10.openclassic.api.block.Block;

public interface BlockPhysics {

	public boolean tick(Block block);
	
	public void onPlace(Block block);
	
}
