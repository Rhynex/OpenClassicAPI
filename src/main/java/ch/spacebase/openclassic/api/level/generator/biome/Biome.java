package ch.spacebase.openclassic.api.level.generator.biome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.column.Chunk;
import ch.spacebase.openclassic.api.util.storage.BlockStore;

public abstract class Biome {

	private int id;
	private List<Decorator> decorators = new ArrayList<Decorator>();

	public Biome(int id, Decorator... decorators) {
		this.id = id;
		this.decorators.addAll(Arrays.asList(decorators));
		Biomes.register(this);
	}

	public void decorate(Level level, Chunk chunk, Random random) {
		for(Decorator decor : this.decorators) {
			decor.populate(level, chunk, random);
		}
	}

	public void generateColumn(Level level, int x, int y, int z, BlockStore blockData, Random random) {
	}

	public int getId() {
		return this.id;
	}

	public abstract String getName();

}
