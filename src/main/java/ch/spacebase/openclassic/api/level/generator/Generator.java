package ch.spacebase.openclassic.api.level.generator;

import java.util.Random;

import ch.spacebase.openclassic.api.Position;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.util.Constants;

/**
 * Represents a chunk generator.
 */
public abstract class Generator {

	protected Random rand = new Random();
	
	/**
	 * Generates a chunk.
	 * @param x X of the chunk.
	 * @param y Y of the chunk.
	 * @param z Z of the chunk.
	 * @param blocks Array to output blocks to.
	 */
	public abstract void generate(long seed, int x, int y, int z, byte blocks[]);
	
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
		this.rand.setSeed(level.getSeed());
		int x = this.rand.nextInt(2000);
		int y = 256 / 2 + 12; // TODO
		int z = this.rand.nextInt(2000);
		
		return new Position(level, x, y + 0.5f, z);	
	}
	
	/**
	 * Converts a set of coordinates to a block array index.
	 * @param x X coordinate.
	 * @param y Y coordinate.
	 * @param z Z coordinate.
	 * @return The block array index of the coordinates.
	 */
	public static int coordsToBlockIndex(int x, int y, int z) {
		x &= 0xf;
		y &= 0xf;
		z &= 0xf;
		return x + (z * Constants.CHUNK_WIDTH) + (y * Constants.CHUNK_WIDTH * Constants.CHUNK_DEPTH);
	}
	
}
