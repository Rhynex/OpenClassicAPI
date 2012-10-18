package ch.spacebase.openclassic.api.level;

import ch.spacebase.openclassic.api.Position;
import ch.spacebase.openclassic.api.level.generator.Generator;

/**
 * The basic info for creating a level.
 */
public class LevelInfo {

	private String name;
	private Position spawn;
	private Generator generator;
	
	public LevelInfo(String name, Position spawn, Generator generator) {
		this.name = name;
		this.spawn = spawn;
		this.generator = generator;
	}
	
	/**
	 * Gets the name of the level.
	 * @return The level's name.
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the level's spawn.
	 * @return The level's spawn.
	 */
	public Position getSpawn() {
		return this.spawn;
	}
	
	/**
	 * Gets the generator of the level.
	 * @return The level's generator.
	 */
	public Generator getGenerator() {
		return this.generator;
	}
	
}
