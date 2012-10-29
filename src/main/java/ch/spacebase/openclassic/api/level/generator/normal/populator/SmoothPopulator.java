package ch.spacebase.openclassic.api.level.generator.normal.populator;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.column.Chunk;
import ch.spacebase.openclassic.api.level.generator.Populator;
import ch.spacebase.openclassic.api.level.generator.biome.Biome;
import ch.spacebase.openclassic.api.util.Constants;

public class SmoothPopulator implements Populator {

	private static final byte SMOOTH_SIZE = 20;
	private static final byte OFFSET = (SMOOTH_SIZE - 16) / 2;
	private static final byte SAMPLE_SIZE = 2;
	private static final float SMOOTHING_POWER = 0.8f;

	private static final Set<BlockType> IGNORED = new HashSet<BlockType>();

	static {
		IGNORED.add(VanillaBlock.AIR);
		IGNORED.add(VanillaBlock.WATER);
		IGNORED.add(VanillaBlock.STATIONARY_WATER);
		IGNORED.add(VanillaBlock.LAVA);
		IGNORED.add(VanillaBlock.STATIONARY_LAVA);
	}

	@Override
	public void populate(Level level, Chunk chunk, Random random) {
		if(chunk.getY() != 4) return;
		int worldX = chunk.getWorldX() - OFFSET;
		int worldZ = chunk.getWorldZ() - OFFSET;
		byte[] heightMap = new byte[SMOOTH_SIZE * SMOOTH_SIZE];
		Biome lastBiome = null;
		boolean variations = false;
		for(byte x = 0; x < SMOOTH_SIZE; x++) {
			for(byte z = 0; z < SMOOTH_SIZE; z++) {
				if(!level.isColumnLoaded(x >> 4, z >> 4)) continue;
				byte y = this.getHighestNonFluidBlock(level, worldX + x, worldZ + z);
				if(!variations) {
					Biome current = level.getBiome(x, y, z);
					if(lastBiome != null) variations = current != lastBiome;
					lastBiome = current;
				}

				heightMap[x + z * SMOOTH_SIZE] = y;
			}
		}

		if(!variations) return;
		byte[] smoothed = this.smooth(heightMap, SMOOTH_SIZE, SMOOTH_SIZE);
		for(byte x = 0; x < SMOOTH_SIZE; x++) {
			for(byte z = 0; z < SMOOTH_SIZE; z++) {
				short index = (short) (x + z * SMOOTH_SIZE);
				this.shiftBlockColumnOnY(level, worldX + x, worldZ + z, (byte) (smoothed[index] - heightMap[index]));
			}
		}
	}

	private byte getHighestNonFluidBlock(Level level, int x, int z) {
		byte y = 127;
		while(IGNORED.contains(level.getBlockTypeAt(x, y, z))) {
			y--;
			if(y == 0) {
				return -1;
			}
		}

		return y;
	}

	private byte getLowestNonBedrockBlock(Level level, int x, int z) {
		byte y = 0;
		while(level.getBlockTypeAt(x, y, z) == VanillaBlock.BEDROCK) {
			y++;
			if(y == 127) {
				return -1;
			}
		}

		return y;
	}

	private void shiftBlockColumnOnY(Level level, int x, int z, byte shift) {
		if(shift == 0) return;
		if(shift >> 31 != 0) {
			byte lowestBedrock = this.getLowestNonBedrockBlock(level, x, z);
			if(lowestBedrock == -1) return;
			for(byte y = (byte) (lowestBedrock - shift); y < 127; y++) {
				Block block = level.getBlockAt(x, y, z);
				BlockType material = block.getType();
				Block destination = block.getRelative(0, shift, 0);
				if(IGNORED.contains(material) || destination.getType() == VanillaBlock.BEDROCK) return;
				destination.setType(material);
				block.setType(y <= Constants.SEA_LEVEL ? VanillaBlock.STATIONARY_WATER : VanillaBlock.AIR);
			}
		} else {
			byte lowest = this.getLowestNonBedrockBlock(level, x, z);
			if(lowest == -1) return;
			for(byte y = 127; y >= lowest + shift; y--) {
				Block block = level.getBlockAt(x, y, z);
				BlockType current = block.getType();
				if(IGNORED.contains(current)) return;
				block.getRelative(0, shift, 0).setType(current);
			}

			BlockType last = level.getBlockTypeAt(x, lowest + shift, z);
			for(byte y = (byte) (lowest + shift - 1); y <= lowest; y--) {
				level.setBlockAt(x, y, z, last);
			}

			byte highest = this.getHighestNonFluidBlock(level, x, z);
			if(highest != -1) {
				this.fixSurface(level, x, highest, z);
			}
		}
	}

	private void fixSurface(Level level, int x, int y, int z) {
		BlockType type = level.getBlockTypeAt(x, y, z);
		if(type == VanillaBlock.DIRT && level.getBlockTypeAt(x, y + 1, z) == VanillaBlock.AIR) {
			level.setBlockAt(x, y, z, VanillaBlock.GRASS);
		} else if(type == VanillaBlock.GRASS && level.getBlockTypeAt(x, y + 1, z) == VanillaBlock.WATER) {
			level.setBlockAt(x, y, z, VanillaBlock.DIRT);
		}
	}

	private byte[] smooth(byte[] heightMap, byte width, byte height) {
		byte[] smooth = new byte[width * height];
		for(byte x = 0; x < width; x++) {
			for(byte y = 0; y < height; y++) {
				short total = 0;
				byte count = 0;
				for(byte xx = (byte) (x - SAMPLE_SIZE); xx < x + SAMPLE_SIZE; xx++) {
					for(byte yy = (byte) (y - SAMPLE_SIZE); yy < y + SAMPLE_SIZE; yy++) {
						if(xx < 0 || yy < 0 || xx >= width || yy >= height) continue;
						total += heightMap[xx + yy * width];
						count++;
					}
				}

				byte old = heightMap[x + y * width];
				byte difference = (byte) ((total / count - old) * SMOOTHING_POWER);
				smooth[x + y * width] = (byte) (old + difference);
			}
		}

		return smooth;
	}

}
