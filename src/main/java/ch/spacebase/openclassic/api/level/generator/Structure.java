package ch.spacebase.openclassic.api.level.generator;

import ch.spacebase.openclassic.api.level.Level;

public interface Structure {

	public boolean canPlace(Level level, int x, int y, int z);
	
	public void place(Level level, int x, int y, int z);
	
}
