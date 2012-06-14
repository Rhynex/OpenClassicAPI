package ch.spacebase.openclassic.api.level.generator;

import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.level.Level;

/**
 * Generates a flat map.
 */
public class FlatLandGenerator extends Generator {

	@Override
	public void generate(Level level) {
		level.setGenerating(true);
		
		for(int x = 0; x <= level.getWidth(); x++) {
			for(int y = 0; y <= level.getHeight(); y++) {
				for(int z = 0; z <= level.getDepth(); z++) {
					if(y == 0) level.setBlockAt(x, y, z, VanillaBlock.BEDROCK);
					
					if(y <= level.getWaterLevel() - 4) level.setBlockAt(x, y, z, VanillaBlock.STONE);
					
					if(y <= level.getWaterLevel() - 1) level.setBlockAt(x, y, z, VanillaBlock.DIRT);
					
					if(y == level.getWaterLevel()) level.setBlockAt(x, y, z, VanillaBlock.GRASS);
				}
			}
		}
		
		level.setGenerating(false);
	}

}
