package me.steveice10.openclassic.api.level.generator;

import java.util.Random;

import me.steveice10.openclassic.api.Position;
import me.steveice10.openclassic.api.block.BlockType;
import me.steveice10.openclassic.api.level.Level;

public abstract class Generator {

	protected static Random rand = new Random();
	
	public abstract void generate(Level level);
	
	public Position findSpawn(Level level) {
		int x = level.getWidth() / 2;
		int y = level.getWaterLevel() + 2;
		int z = level.getDepth() / 2;
		
		while(level.getBlockTypeAt(x, y, z) != BlockType.AIR || level.getBlockTypeAt(x, y - 1, z) != BlockType.AIR || level.getBlockTypeAt(x, y - 2, z) == BlockType.AIR) {
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
