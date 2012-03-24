package com.github.steveice10.openclassic.api.level.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.github.steveice10.openclassic.api.Position;
import com.github.steveice10.openclassic.api.block.BlockType;
import com.github.steveice10.openclassic.api.level.Level;
import com.github.steveice10.openclassic.api.util.MathHelper;
import com.github.steveice10.openclassic.api.util.PerlinNoise;

// TODO: Freeze fix
public class NormalGenerator extends Generator {

	@Override
	public void generate(Level level) {
		List<Position> treePositions = new ArrayList<Position>();
		List<Integer> treeHeights = new ArrayList<Integer>();
		Random rand = new Random((level.getWidth() / 2) * 10000 + (level.getDepth() / 2)); // TODO

		for (int x = 0; x < level.getWidth(); x++) {
			for (int z = 0; z < level.getDepth(); z++) {
				this.generateColumn(level, x, z, level.getHeight(), treePositions, treeHeights, rand);
			}
		}

		int index = 0;
		for (Position pos : treePositions) {
			int treeHeight = treeHeights.get(index++);
			this.addTree(level, pos, treeHeight, rand);
		}
	}

	private void addTree(Level level, Position pos, int treeHeight, Random rand) {
		for (int y = 0; y < treeHeight; y++) {
			level.setBlockAt((int) Math.floor(pos.getX()), (int) Math.floor(pos.getY() + y), (int) Math.floor(pos.getZ()), BlockType.LOG);
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
							level.setBlockAt((int) Math.floor(pos.getX()), (int) Math.floor(pos.getY() + y), (int) Math.floor(pos.getZ()), BlockType.LEAVES);
						}
					}
				}
			}
		}
	}

	private void generateColumn(Level level, int x, int z, short height, List<Position> treePositions, List<Integer> treeHeights, Random rand) {
		double gen = 5;

		int localHeight = 0;

		localHeight = generateLayer(x, z, gen + 0, 0.1, 0, 0.4f * height, BlockType.BEDROCK, 0.2f, height, level, rand);
		localHeight = generateLayer(x, z, gen + 0.2, 1.5, localHeight, 0.08f * height + 1.5f * (localHeight - 10), BlockType.STONE, 0.8f, height, level, rand);
		localHeight = generateLayer(x, z, gen + 0.5, 2.0, localHeight, 0.06f * height + 0.3f * (localHeight - 5), BlockType.DIRT, 0.6f, height, level, rand);

		double noise1 = PerlinNoise.noise(x * 0.01, 20, z * 0.01) + 0.5;
		double noise3 = PerlinNoise.noise(x * 0.01, 20, z * 0.01) + 0.5;
		double noise2 = PerlinNoise.noise(x * 0.01, 100, z * 0.01);
		double mul = (localHeight + height / 2.0) / height;
		mul = 10.0 * MathHelper.clamp(mul, 0.0, 1.0);
		int val = (int) (mul * noise1 * noise3 * (noise2 > 0.2 ? 1.0 : 0.0));
		val = Math.max(0, val);
		BlockType type = BlockType.STONE;
		for (int y = localHeight; y < localHeight + val; y++) {
			if (y <= level.getWaterLevel() + 1) {
				type = BlockType.SAND;
			}
			double scaleY = (Math.abs(y - height / 5) + 10.0) / height * 3.5;
			double scale = 0.05;
			double noise4 = PerlinNoise.noise(x * scale, y * scale * 2.5, z * scale);
			if (noise4 < scaleY) {
				if (rand.nextDouble() < 0.1) {
					level.setBlockAt(x, y, z, BlockType.GRAVEL);
				} else {
					level.setBlockAt(x, y, z, type);
				}
			} else {
				level.setBlockAt(x, y, z, BlockType.AIR);
			}
		}
		localHeight += val;

		int block = level.getBlockIdAt(x, localHeight - 1, z);
		if (block == 3) {
			if (localHeight - 1 <= level.getWaterLevel() + 1) {
				level.setBlockAt(x, localHeight - 1, z, BlockType.SAND);
			} else {
				level.setBlockAt(x, localHeight - 1, z, BlockType.GRASS);
			}

			if (noise2 < -0.4) {
				double noiseTree = PerlinNoise.noise(x * 0.2, localHeight * 0.2, z * 0.2);
				if (noiseTree > 0.4) {
					int mountainHeight = (int) ((noiseTree - 0.4) * 10);
					for (int y = localHeight; y < localHeight + mountainHeight; y++) {
						level.setBlockAt(x, y, z, BlockType.STONE);
					}
					localHeight += mountainHeight;
				}
			}
		}

		if (localHeight < level.getWaterLevel()) {
			for (; localHeight < level.getWaterLevel(); localHeight++) {
				level.setBlockAt(x, localHeight, z, BlockType.WATER);
			}
		}

		for (int y = localHeight; y < height; y++) {
			level.setBlockAt(x, y, z, BlockType.AIR);
		}
	}

	private int generateLayer(int x, int z, double noiseVal, double noiseScale, int startheight, float layerheight, BlockType type, float adder, int height, Level level, Random rand) {
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
				level.setBlockAt(x, y, z, BlockType.SAND);
			}
			double scaleY = (Math.abs(y - height / 3) + 15.0) / height * 1.5;
			double scale = 0.05;
			double noise3 = PerlinNoise.noise(x * scale, y * scale * 2.0, z * scale);
			if (noise3 < scaleY) {
				if (type == BlockType.STONE) {
					int r = rand.nextInt(100);
					if (r < 3) {
						level.setBlockAt(x, y, z, BlockType.fromId((BlockType.GOLD_ORE.getId() + r)));
					} else {
						level.setBlockAt(x, y, z, type);
					}
				} else {
					level.setBlockAt(x, y, z, type);
				}
			} else if (noise3 - scaleY < 0.02) {
				level.setBlockAt(x, y, z, BlockType.STONE);
			} else {
				if (y < level.getWaterLevel()) {
					level.setBlockAt(x, y, z, BlockType.WATER);
				} else {
					level.setBlockAt(x, y, z, BlockType.AIR);
				}
			}
		}

		return startheight + localHeight;
	}

}
