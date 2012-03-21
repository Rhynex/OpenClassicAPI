package com.github.steveice10.openclassic.api.level.generator;

import com.github.steveice10.openclassic.api.block.BlockType;
import com.github.steveice10.openclassic.api.level.Level;

public class FlatLandGenerator extends Generator {

	@Override
	public void generate(Level level) {
		level.setGenerating(true);
		
		for(int x = 0; x <= level.getWidth(); x++) {
			for(int y = 0; y <= level.getHeight(); y++) {
				for(int z = 0; z <= level.getDepth(); z++) {
					if(y == 0) level.setBlockAt(x, y, z, BlockType.BEDROCK);
					
					if(y <= level.getWaterLevel() - 4) level.setBlockAt(x, y, z, BlockType.STONE);
					
					if(y <= level.getWaterLevel() - 1) level.setBlockAt(x, y, z, BlockType.DIRT);
					
					if(y == level.getWaterLevel()) level.setBlockAt(x, y, z, BlockType.GRASS);
				}
			}
		}
		
		level.setGenerating(false);
	}

}
