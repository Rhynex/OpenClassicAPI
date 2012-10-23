package ch.spacebase.openclassic.api.level.generator;

import java.util.List;
import java.util.Random;

import ch.spacebase.openclassic.api.Position;
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
	 * Finds a spawn for the level.
	 * @param level The level to find a spawn for.
	 * @return The spawn found for the level.
	 */
	public Position findSpawn(Level level) {
		Random rand = new Random(level.getSeed());
		int x = rand.nextInt(2000);
		int y = 256;// / 2 + 12; // TODO
		int z = rand.nextInt(2000);
		
		return new Position(level, x, y + 0.5f, z);	
	}
	
}
