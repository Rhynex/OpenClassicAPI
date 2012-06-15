package ch.spacebase.openclassic.api.level.generator;

import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.level.Level;

/**
 * Generates a flat map.
 */
public class FlatLandGenerator extends Generator {

	@Override
	public void generate(Level level) {
		level.setGenerating(true);
		int count = 0;
		for(int x = 0; x <= level.getWidth(); x++) {
			for(int y = 0; y <= level.getWaterLevel(); y++) {
				for(int z = 0; z <= level.getDepth(); z++) {
					if(y == 0) {
						level.setBlockAt(x, y, z, VanillaBlock.BEDROCK);
					} else if(y <= level.getWaterLevel() - 4) {
						level.setBlockAt(x, y, z, VanillaBlock.STONE);
					} else if(y <= level.getWaterLevel() - 1) {
						level.setBlockAt(x, y, z, VanillaBlock.DIRT);
					} else if(y == level.getWaterLevel()) {
						level.setBlockAt(x, y, z, VanillaBlock.GRASS);
					}
					
					count++;
					if(OpenClassic.getClient() != null) {
						OpenClassic.getClient().getProgressBar().setProgress((int) (((double) count / (double) level.getBlocks().length) * 100) * 2);
					}
				}
			}
		}
		
		level.setGenerating(false);
	}

}
