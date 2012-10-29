package ch.spacebase.openclassic.api.level.generator.normal.decorator;

import java.util.Random;

import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.column.Chunk;
import ch.spacebase.openclassic.api.level.generator.biome.Decorator;
import ch.spacebase.openclassic.api.util.Constants;

public class PondDecorator implements Decorator {

	private static final byte ODD = 24;
	private static final byte LAVA_POND_ODD = 11;
	
	@Override
	public void populate(Level level, Chunk chunk, Random random) {
		if(chunk.getY() != 4) return;
		if(random.nextInt(ODD) != 0) return;
		for (byte i = 0; i < 1; i++) {
			int xx = chunk.getWorldX() + random.nextInt(16);
			int zz = chunk.getWorldZ() + random.nextInt(16);
			int yy = this.getHighestWorkableBlock(level, xx, zz) - random.nextInt(4) - 1;
			BlockType pondtype = this.getPondType(random);
			if(pondtype == VanillaBlock.WATER) {
				this.generateWaterPond(level, xx, yy, zz, random);
			} else {
				this.generateLavaPond(level, xx, yy, zz, random);
			}
		}
	}

	private BlockType getPondType(Random random) {
		if (random.nextInt(LAVA_POND_ODD) == 0) {
			return VanillaBlock.LAVA;
		} else {
			return VanillaBlock.WATER;
		}
	}
	
	private void generateWaterPond(Level level, int x, int y, int z, Random random) {
		x -= 8;
		z -= 8;
		PondHole hole = new PondHole(random);
		byte[] water = this.getNoiseMap(hole);
		byte[] air = this.getNoiseMap(hole);
		if (!this.canBuildPondHole(level, x, y, z, water, VanillaBlock.STATIONARY_WATER) || !this.canBuildPondTop(level, x, y, z, air)) {
			return;
		}

		for(byte px = 0; px < 16; px++) {
			for(byte pz = 0; pz < 16; pz++) {
				for(byte py = (byte) -water[16 * px + pz]; py < 0; py++) {
					level.setBlockAt(px + x, py + y, pz + z, VanillaBlock.STATIONARY_WATER);
				}

				for(byte py = 0; py < air[16 * px + pz]; py++) {
					level.setBlockAt(px + x, py + y, pz + z, VanillaBlock.AIR);
				}
			}
		}

		System.out.println("Placed water pond: " + x + ", " + y + ", " + z);
		this.finalizeSurface(level, x, y, z);
	}

	private void generateLavaPond(Level level, int x, int y, int z, Random random) {
		x -= 8;
		z -= 8;
		PondHole hole = new PondHole(random);
		byte[] lava = this.getNoiseMap(hole);
		byte[] air = this.getNoiseMap(hole);
		if(!this.canBuildPondHole(level, x, y, z, lava, VanillaBlock.STATIONARY_LAVA) || !this.canBuildPondTop(level, x, y, z, air)) {
			return;
		}
		for(byte px = 0; px < 16; px++) {
			for(byte pz = 0; pz < 16; pz++) {
				for(byte py = (byte) -lava[16 * px + pz]; py < 0; py++) {
					level.setBlockAt(px + x, py + y, pz + z, VanillaBlock.STATIONARY_LAVA);
				}

				for(byte py = 1; py < 5; py++) {
					if(this.isWallBlock(px, py, pz, lava)) {
						level.setBlockAt(x + px, y - py, z + pz, VanillaBlock.STONE);
					}
				}

				for(byte py = 0; py < air[16 * px + pz]; py++) {
					level.setBlockAt(px + x, py + y, pz + z, VanillaBlock.AIR);
				}

				for(byte py = 1; py < 5; py++) {
					if(this.isWallBlock(px, py, pz, air)) {
						Block block = level.getBlockAt(px + x, py + y - 1, pz + z);
						if(block.getType().isOpaque() && random.nextBoolean()) {
							block.setType(VanillaBlock.STONE);
						}
					}
				}
			}
		}

		this.finalizeSurface(level, x, y, z);
	}

	private void finalizeSurface(Level level, int x, int y, int z) {
		for(byte px = 0; px < 16; px++) {
			for(byte pz = 0; pz < 16; pz++) {
				for(byte py = -1; py < 4; py++) {
					BlockType block = level.getBlockTypeAt(x + px, y + py, z + pz);
					if(block == VanillaBlock.DIRT && level.isLit(x + px, y + py + 1, z + pz)) {
						level.setBlockAt(x + px, y + py, z + pz, VanillaBlock.GRASS);
					}
				}
			}
		}
	}

	private byte[] getNoiseMap(PondHole hole) {
		final byte[] map = new byte[256];
		for(byte px = 0; px < 16; px++) {
			for(byte pz = 0; pz < 16; pz++) {
				map[16 * px + pz] = hole.getDepth(px, pz);
			}
		}

		return map;
	}

	private boolean canBuildPondHole(Level level, int x, int y, int z, byte[] liquidBlocks, BlockType liquid) {
		for(byte px = 0; px < 16; px++) {
			for(byte pz = 0; pz < 16; pz++) {
				for(byte py = 1; py < 5; py++) {
					if(this.isWallBlock(px, py, pz, liquidBlocks)) {
						BlockType type = level.getBlockTypeAt(x + px, y - py, z + pz);
						if(!type.isOpaque() && type != liquid) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	private boolean canBuildPondTop(Level level, int x, int y, int z, byte[] airBlocks) {
		for(byte px = 0; px < 16; px++) {
			for(byte pz = 0; pz < 16; pz++) {
				for(byte py = 1; py < 5; py++) {
					if(this.isWallBlock(px, py, pz, airBlocks)) {
						BlockType type = level.getBlockTypeAt(x + px, y + py, z + pz);
						if(type.isLiquid()) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	private boolean isWallBlock(int x, int y, int z, byte[] blocks) {
		if(y <= blocks[16 * x + z]) return false;
		if(x < 15 && y <= blocks[16 * (x + 1) + z]) {
			return true;
		} else if(x > 0 && y <= blocks[16 * (x - 1) + z]) {
			return true;
		} else if(z < 15 && y <= blocks[16 * x + z + 1]) {
			return true;
		} else if(z > 0 && y <= blocks[16 * x + z - 1]) {
			return true;
		} else if(y > 1 && y <= blocks[16 * x + z] + 1) {
			return true;
		} else {
			return false;
		}
	}

	private int getHighestWorkableBlock(Level level, int x, int z) {
		int y = Constants.COLUMN_HEIGHT - 1;
		while(level.getBlockTypeAt(x, y, z) == VanillaBlock.AIR) {
			y--;
			if(y == 0 || level.getBlockTypeAt(x, y, z) == VanillaBlock.WATER) {
				return -1;
			}
		}

		y++;
		return y;
	}

	private static class PondHole {
		private final SphericalNoise[] noise;

		private PondHole(Random random) {
			this.noise = new SphericalNoise[random.nextInt(4) + 4];
			for (byte i = 0; i < this.noise.length; i++) {
				this.noise[i] = new SphericalNoise(random);
			}
		}

		private byte getDepth(int x, int z) {
			byte depth = Byte.MIN_VALUE;
			for(final SphericalNoise n : this.noise) {
				byte d = n.getValue(x, z);
				depth = d > depth ? d : depth;
			}

			return depth;
		}

		private static class SphericalNoise {
			private final Random random;
			private final float radius;
			private final int xOffset;
			private final int yOffset;
			private final int zOffset;
			private final float xMultiplier;
			private final float yMultiplier;
			private final float zMultiplier;

			private SphericalNoise(Random random) {
				this.random = random;
				int yOff = random.nextInt(2);
				if (random.nextBoolean()) {
					yOff = -yOff;
				}

				this.yOffset = yOff;
				this.xOffset = random.nextInt(7) + 4;
				this.zOffset = random.nextInt(7) + 4;
				this.radius = random.nextInt(2) + 2;
				this.xMultiplier = random.nextFloat() * 0.2f + 0.95f;
				this.yMultiplier = random.nextFloat() + 0.9f;
				this.zMultiplier = random.nextFloat() * 0.2f + 0.95f;
			}

			private byte getValue(int x, int z) {
				final float xOffNoise = this.random.nextFloat() * 0.2f;
				final float zOffNoise = this.random.nextFloat() * 0.2f;
				final float radiusNoise = this.random.nextFloat() * 0.8f;
				final float multiXNoise = 1f - this.random.nextFloat() * 0.1f;
				final float multiZNoise = 1f - this.random.nextFloat() * 0.1f;
				final float value = (float) Math.sqrt(Math.pow(this.radius + radiusNoise, 2) - Math.pow((this.xMultiplier * multiXNoise) * x - this.xOffset - xOffNoise, 2) - Math.pow((this.zMultiplier * multiZNoise) * z - this.zOffset - zOffNoise, 2));
				return (byte) ((value + this.yOffset) / this.yMultiplier);
			}
		}
	}

}
