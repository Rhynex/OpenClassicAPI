package ch.spacebase.openclassic.api.level.generator;

import java.util.Random;

import ch.spacebase.openclassic.api.Position;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.level.Level;

/**
 * Represents a map generator.
 */
public abstract class Generator {

	protected static Random rand = new Random();
	
	/**
	 * Generates the level.
	 * @param Level to generate.
	 */
	public abstract void generate(Level level);
	
	/**
	 * Finds a spawn for the level.
	 * @param The level to find a spawn for.
	 * @return The spawn found for the level.
	 */
	public Position findSpawn(Level level) {
		int x = level.getWidth() / 2;
		int y = level.getWaterLevel() + 2;
		int z = level.getDepth() / 2;
		
		while(level.getBlockTypeAt(x, y, z) != VanillaBlock.AIR || level.getBlockTypeAt(x, y - 1, z) != VanillaBlock.AIR || level.getBlockTypeAt(x, y - 2, z) == VanillaBlock.AIR) {
			if(y >= level.getHeight() - 1) {
				x = rand.nextInt(level.getWidth());
				y = level.getWaterLevel() + 2;
				z = rand.nextInt(level.getDepth());
				
				continue;
			}
			
			y++;
		}
		
		return new Position(level, x, y + 0.5, z);	
	}
	
}
