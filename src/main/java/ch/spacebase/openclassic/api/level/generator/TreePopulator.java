package ch.spacebase.openclassic.api.level.generator;

import java.util.Random;

import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockFace;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.column.Chunk;
import ch.spacebase.openclassic.api.util.Constants;

public class TreePopulator implements Populator {

	@Override
	public void populate(Level level, Chunk chunk, Random random) {
		for(int x = chunk.getWorldX(); x < chunk.getWorldX() + Constants.CHUNK_WIDTH; x++){
			for(int z = chunk.getWorldZ(); z < chunk.getWorldZ() + Constants.CHUNK_DEPTH; z++){
				for(int y = chunk.getWorldY(); y < chunk.getWorldY() + Constants.CHUNK_HEIGHT; y++){
					if(y > 4){
						Block block = level.getBlockAt(x, y, z);
						Block ground = block.getRelative(BlockFace.DOWN);
						if(ground.getType() == VanillaBlock.GRASS){
							if(random.nextInt(100) < 7) {
								level.growTree(x, y, z);
							}
						}
					}
				}
			}
		}
	}

}
