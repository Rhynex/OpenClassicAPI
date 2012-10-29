package ch.spacebase.openclassic.api.level.generator.normal.decorator;

import java.util.Random;

import ch.spacebase.openclassic.api.block.BlockFace;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.column.Chunk;
import ch.spacebase.openclassic.api.level.generator.biome.Decorator;
import ch.spacebase.openclassic.api.util.Constants;

public class BeachDecorator implements Decorator {

	@Override
	public void populate(Level level, Chunk c, Random r) {
		if(c.getY() != 3) return;
		for(int x = c.getWorldX(); x < c.getWorldX() + Constants.CHUNK_WIDTH; x++) {
			for(int z = c.getWorldZ(); z < c.getWorldZ() + Constants.CHUNK_DEPTH; z++) {
				for(int y = 65; y >= 63; y--) {
					BlockType current = level.getBlockTypeAt(x, y, z);
					if(current != VanillaBlock.GRASS) continue;
					for(BlockFace face : BlockFace.nsew()) {
						int tx = x + face.getModX();
						int tz = z + face.getModZ();
						BlockType type = level.getBlockTypeAt(tx, y, tz);
						if(type == VanillaBlock.STATIONARY_WATER || type == VanillaBlock.WATER) {
							this.placeSandBall(level, x, y, z, 4);
							break;
						}
					}
				}
			}
		}
	}

	public void placeSandBall(Level level, int x, int y, int z, int radius) {
		while(radius > 0) {
			BlockType existing = level.getBlockTypeAt(x, y, z);
			if(existing == VanillaBlock.GRASS) {
				level.setBlockAt(x, y, z, VanillaBlock.SAND);
			} else if((existing == VanillaBlock.WATER || existing == VanillaBlock.STATIONARY_WATER) && level.getBlockTypeAt(x, y - 1, z) == VanillaBlock.DIRT) {
				level.setBlockAt(x, y - 1, z, VanillaBlock.SAND);
			} else {
				radius--;
				if(radius > 0) {
					for(BlockFace face : BlockFace.values()) {
						int tx = x + face.getModX();
						int ty = y + face.getModY();
						int tz = z + face.getModZ();
						this.placeSandBall(level, tx, ty, tz, radius);
					}
				}
			}
		}
	}
}
