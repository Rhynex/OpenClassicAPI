package ch.spacebase.openclassic.api.level.generator.biome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.column.Chunk;

public abstract class Biome {

	private int id;
	private boolean registered = false;
	private List<Decorator> decorators = new ArrayList<Decorator>();

	public Biome(Decorator... decorators) {
		this.decorators.addAll(Arrays.asList(decorators));
		Biomes.register(this);
	}

	public void decorate(Level level, Chunk chunk, Random random) {
		for(Decorator decor : this.decorators) {
			decor.populate(level, chunk, random);
		}
	}

	protected final void setId(int id) {
		if(!this.registered) {
			this.id = id;
			this.registered = true;
		}
	}

	public int getId() {
		return this.id;
	}

	public abstract String getName();

}
