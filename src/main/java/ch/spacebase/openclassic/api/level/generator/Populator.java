package ch.spacebase.openclassic.api.level.generator;

import java.util.Random;

import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.column.Chunk;

public interface Populator {

	/**
	 * Populates the given chunk in the given level.
	 * @param level Level to populate.
	 * @param chunk Chunk to populate.
	 * @param random Random generator used when populating.
	 */
	public void populate(Level level, Chunk chunk, Random random);
	
}
