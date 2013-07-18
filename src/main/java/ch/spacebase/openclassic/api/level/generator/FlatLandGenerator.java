package ch.spacebase.openclassic.api.level.generator;

import ch.spacebase.openclassic.api.Client;
import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.util.CoordUtil;

/**
 * Generates a flat map.
 */
public class FlatLandGenerator extends Generator {

	@Override
	public void generate(Level level, byte blocks[]) {
		level.setGenerating(true);
		if(OpenClassic.getGame() instanceof Client) {
			OpenClassic.getClient().getProgressBar().setVisible(true);
			OpenClassic.getClient().getProgressBar().render();
		}
		
		int count = 0;
		for(int x = 0; x < level.getWidth(); x++) {
			for(int y = 0; y <= level.getWaterLevel(); y++) {
				for(int z = 0; z < level.getDepth(); z++) {
					if(y == 0) {
						blocks[CoordUtil.coordsToBlockIndex(level, x, y, z)] = VanillaBlock.BEDROCK.getId();
					} else if(y <= level.getWaterLevel() - 4) {
						blocks[CoordUtil.coordsToBlockIndex(level, x, y, z)] = VanillaBlock.STONE.getId();
					} else if(y <= level.getWaterLevel() - 1) {
						blocks[CoordUtil.coordsToBlockIndex(level, x, y, z)] = VanillaBlock.DIRT.getId();
					} else if(y == level.getWaterLevel()) {
						blocks[CoordUtil.coordsToBlockIndex(level, x, y, z)] = VanillaBlock.GRASS.getId();
					}
					
					count++;
					if(OpenClassic.getGame() instanceof Client) {
						OpenClassic.getClient().getProgressBar().setProgress((int) (((double) count / (double) blocks.length) * 100) * 2);
					}
				}
			}
		}
		
		if(OpenClassic.getGame() instanceof Client) {
			OpenClassic.getClient().getProgressBar().setVisible(false);
		}
		
		level.setGenerating(false);
	}

}
