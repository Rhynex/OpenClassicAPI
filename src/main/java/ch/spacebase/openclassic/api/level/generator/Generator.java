package ch.spacebase.openclassic.api.level.generator;

import java.util.List;
import java.util.Random;

import ch.spacebase.openclassic.api.Position;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.util.storage.TripleIntByteArray;

/**
 * Represents a chunk generator.
 */
public abstract class Generator {
	
	/**
	 * Generates a chunk.
	 * @param level Level to generate for.
	 * @param x X of the chunk.
	 * @param y Y of the chunk.
	 * @param z Z of the chunk.
	 * @param blocks Array to output blocks to.
	 * @param random Random to use when generating.
	 */
	public abstract void generate(Level level, int x, int y, int z, TripleIntByteArray blocks, Random random);
	
	/**
	 * Gets a list of populators for the given level.
	 * @param level The level to get populators for.
	 * @return The populators for the given level.
	 */
	public abstract List<Populator> getPopulators(Level level);
	
	/**
	 * Gets the name of this generator.
	 * @return The name of this generator.
	 */
	public abstract String getName();
	
	/**
	 * Finds the initial spawn for the level.
	 * @param level The level to find the initial spawn for.
	 * @return The initial spawn found for the level.
	 */
	public Position findInitialSpawn(Level level) {
		Random rand = new Random(level.getSeed());
		return new Position(level, rand.nextInt(2000), 256, rand.nextInt(256));
	}
	
	/**
	 * Adjusts the level's spawn after the level has generated a chunk.
	 * @param level The level to adjust the spawn for.
	 * @return The adjusted spawn for the level.
	 */
	public Position adjustSpawn(Level level) {
		int y = 256;
		while(level.getBlockTypeAt(level.getSpawn().getBlockX(), y, level.getSpawn().getBlockZ()) == VanillaBlock.AIR) {
			y--;
			if(y <= 0) {
				y = 256;
				break;
			}
		}
		
		Position newspawn = level.getSpawn().clone();
		newspawn.setY(y + 1);
		return newspawn;
	}
	
}
