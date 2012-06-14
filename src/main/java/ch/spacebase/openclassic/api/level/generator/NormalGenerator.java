package ch.spacebase.openclassic.api.level.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.Position;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.block.Blocks;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.util.math.MathHelper;
import ch.spacebase.openclassic.api.util.math.PerlinNoise;

// TODO: Needs improvement
/**
 * Generates a normal map.
 * @author steven
 *
 */
public class NormalGenerator extends Generator {

	private static final int CHUNK_SIZE = 16;
	private static final int PERCENT_MILLIS = 1000;
	
	@Override
	public Position findSpawn(Level level) { // TODO: This is a temp fix since it gets stuck on normal findSpawn
		return new Position(level, 0, 65, 0);
	}
	
	@Override
	public void generate(Level level) {
		int chunkX = level.getWidth() - CHUNK_SIZE;
		int chunkZ = level.getDepth() - CHUNK_SIZE;
		int sizeX = CHUNK_SIZE;
		int sizeZ = CHUNK_SIZE;
		
		long lastShown = System.currentTimeMillis();
		
		final int numChunks = (level.getWidth() / 16) * (level.getDepth() / 16);
		int generated = 0;
		
		while(chunkZ >= 0) {
			if((chunkX % 16) != 0) {
				sizeX = chunkX;
			}
			
			chunkX -= sizeX;
			if(chunkX < 0 && chunkZ > 0) {
				chunkX = level.getWidth() - CHUNK_SIZE;
				
				chunkZ -= sizeZ;
				if(chunkZ < 0) {
					chunkZ = 0;
				}
			}
			
			if(chunkZ < 0 || chunkX < 0) break;
			
			this.generateChunk(level, chunkX, chunkZ, sizeX, sizeZ);
			generated++;
			
			if(System.currentTimeMillis() - lastShown >= PERCENT_MILLIS) {
				OpenClassic.getLogger().info(((double) generated / numChunks) * 100 + "% generated.");
				lastShown = System.currentTimeMillis();
			}
		}
	}
	
	private void generateChunk(Level level, int chX, int chZ, int sizeX, int sizeZ) {
		List<Position> treePositions = new ArrayList<Position>();
		List<Integer> treeHeights = new ArrayList<Integer>();
		Random rand = new Random(chX * 10000 + chZ);

		for (int x = chX; x < chX + sizeX; x++) {
			for (int z = chZ; z < chZ + sizeZ; z++) {
				this.generateColumn(level, x, z, level.getHeight(), treePositions, treeHeights, rand);
			}
		}

		int index = 0;
		for (Position pos : treePositions) {
			int treeHeight = treeHeights.get(index++);
			addTree(level, pos, treeHeight, rand);
		}
	}

	private static void addTree(Level level, Position pos, int treeHeight, Random rand) {
		for (int y = 0; y < treeHeight; y++) {
			level.setBlockAt((int) Math.floor(pos.getX()), (int) Math.floor(pos.getY() + y), (int) Math.floor(pos.getZ()), VanillaBlock.LOG);
		}

		for (int x = 0; x < treeHeight; x++) {
			for (int z = 0; z < treeHeight; z++) {
				for (int y = 0; y < treeHeight; y++) {
					int xx = x - (treeHeight - 1) / 2;
					int yy = y - (treeHeight - 1) / 2;
					int zz = z - (treeHeight - 1) / 2;
					if (xx == 0 && zz == 0 && yy <= 0) {
						continue;
					}
					double test = Math.sqrt((double) xx * xx + yy * yy + zz * zz);
					if (test < (treeHeight - 1.0) / 2.0) {
						if (rand.nextDouble() < 0.8) {
							level.setBlockAt((int) Math.floor(pos.getX()), (int) Math.floor(pos.getY() + y), (int) Math.floor(pos.getZ()), VanillaBlock.LEAVES);
						}
					}
				}
			}
		}
	}

	private void generateColumn(Level level, int x, int z, short height, List<Position> treePositions, List<Integer> treeHeights, Random rand) {
		double gen = 5;

		int localHeight = 0;

		localHeight = generateLayer(x, z, gen, 0.1, 0, 1, VanillaBlock.BEDROCK, 0.2f, height, level, rand);
		localHeight = generateLayer(x, z, gen + 0.2, 1.5, localHeight, 0.08f * height + 1.5f * (localHeight - 10), VanillaBlock.STONE, 0.8f, height, level, rand);
		localHeight = generateLayer(x, z, gen + 0.5, 2.0, localHeight, 0.06f * height + 0.3f * (localHeight - 5), VanillaBlock.DIRT, 0.6f, height, level, rand);

		double noise1 = PerlinNoise.noise(x * 0.01, 20, z * 0.01) + 0.5;
		double noise3 = PerlinNoise.noise(x * 0.01, 20, z * 0.01) + 0.5;
		double noise2 = PerlinNoise.noise(x * 0.01, 100, z * 0.01);
		double mul = (localHeight + height / 2.0) / height;
		mul = 10.0 * MathHelper.clamp(mul, 0.0, 1.0);
		int val = (int) (mul * noise1 * noise3 * (noise2 > 0.2 ? 1.0 : 0.0));
		val = Math.max(0, val);
		VanillaBlock type = VanillaBlock.STONE;
		for (int y = localHeight; y < localHeight + val; y++) {
			if (y <= level.getWaterLevel() + 1) {
				type = VanillaBlock.SAND;
			}
			double scaleY = (Math.abs(y - height / 5) + 10.0) / height * 3.5;
			double scale = 0.05;
			double noise4 = PerlinNoise.noise(x * scale, y * scale * 2.5, z * scale);
			if (noise4 < scaleY) {
				if (rand.nextDouble() < 0.1) {
					level.setBlockAt(x, y, z, VanillaBlock.GRAVEL);
				} else {
					level.setBlockAt(x, y, z, type);
				}
			} else {
				level.setBlockAt(x, y, z, VanillaBlock.AIR);
			}
		}
		localHeight += val;

		int block = level.getBlockIdAt(x, localHeight - 1, z);
		if (block == 3) {
			if (localHeight - 1 <= level.getWaterLevel() + 1) {
				level.setBlockAt(x, localHeight - 1, z, VanillaBlock.SAND);
			} else {
				level.setBlockAt(x, localHeight - 1, z, VanillaBlock.GRASS);
			}

			if (noise2 < -0.4) {
				double noiseTree = PerlinNoise.noise(x * 0.2, localHeight * 0.2, z * 0.2);
				if (noiseTree > 0.4) {
					int mountainHeight = (int) ((noiseTree - 0.4) * 10);
					for (int y = localHeight; y < localHeight + mountainHeight; y++) {
						level.setBlockAt(x, y, z, VanillaBlock.STONE);
					}
					localHeight += mountainHeight;
				}
			}
		}

		if (localHeight < level.getWaterLevel()) {
			for (; localHeight < level.getWaterLevel(); localHeight++) {
				level.setBlockAt(x, localHeight, z, VanillaBlock.WATER);
			}
		}

		for (int y = localHeight; y < height; y++) {
			level.setBlockAt(x, y, z, VanillaBlock.AIR);
		}
	}

	private int generateLayer(int x, int z, double noiseVal, double noiseScale, int startheight, float layerheight, VanillaBlock type, float adder, int height, Level level, Random rand) {
		layerheight = Math.max(0.0f, layerheight);

		double noise = PerlinNoise.noise(x * 0.01 * noiseScale, noiseVal, z * 0.01 * noiseScale) + adder;
		double noise2 = PerlinNoise.noise(x * 0.05 * noiseScale, noiseVal, z * 0.05 * noiseScale) + adder;

		double phatnoise = PerlinNoise.noise(x * 0.004, noiseVal, z * 0.004);
		phatnoise = MathHelper.clamp(Math.abs(phatnoise) + 0.6, 0.0, 1.0);
		noise2 *= phatnoise;
		noise *= phatnoise;

		int localHeight = (int) (noise * layerheight + noise2 * layerheight * 0.35);
		localHeight = Math.max(0, localHeight);

		for (int y = startheight; y < startheight + localHeight; y++) {
			if (y <= 1) {
				level.setBlockAt(x, y, z, VanillaBlock.SAND);
			}
			double scaleY = (Math.abs(y - height / 3) + 15.0) / height * 1.5;
			double scale = 0.05;
			double noise3 = PerlinNoise.noise(x * scale, y * scale * 2.0, z * scale);
			if (noise3 < scaleY) {
				if (type == VanillaBlock.STONE) {
					int r = rand.nextInt(100);
					if (r < 3) {
						level.setBlockAt(x, y, z, Blocks.fromId(VanillaBlock.GOLD_ORE.getId() + r));
					} else {
						level.setBlockAt(x, y, z, type);
					}
				} else {
					level.setBlockAt(x, y, z, type);
				}
			} else if (noise3 - scaleY < 0.02) {
				level.setBlockAt(x, y, z, VanillaBlock.STONE);
			} else {
				if (y < level.getWaterLevel()) {
					level.setBlockAt(x, y, z, VanillaBlock.WATER);
				} else {
					level.setBlockAt(x, y, z, VanillaBlock.AIR);
				}
			}
		}

		return startheight + localHeight;
	}

}
