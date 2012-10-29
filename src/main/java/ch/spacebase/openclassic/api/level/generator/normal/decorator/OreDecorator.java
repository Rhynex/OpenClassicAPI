package ch.spacebase.openclassic.api.level.generator.normal.decorator;

import java.util.Random;

import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.column.Chunk;
import ch.spacebase.openclassic.api.level.generator.biome.Decorator;

public class OreDecorator implements Decorator {

	private static final int[] iterations = new int[]{ 10, 20, 20, 2 };
	private static final int[] amount = new int[]{ 32, 16, 8, 8 };
	private static final BlockType[] type = new BlockType[] { VanillaBlock.GRAVEL, VanillaBlock.COAL_ORE, VanillaBlock.IRON_ORE, VanillaBlock.GOLD_ORE };
	private static final int[] maxHeight = new int[]{ 128, 128, 128, 128 };

	@Override
	public void populate(Level level, Chunk chunk, Random random) {
		for(int id = 0; id < type.length; id++) {
			for(int count = 0; count < iterations[id]; count++) {
				this.generateOre(level, random, chunk.getWorldX() + random.nextInt(16), random.nextInt(maxHeight[id]), chunk.getWorldZ() + random.nextInt(16), amount[id], type[id]);
			}
		}
	}

	private void generateOre(Level level, Random random, int originX, int originY, int originZ, int amount, BlockType type) {
		double angle = random.nextDouble() * Math.PI;
		double x1 = ((originX + 8) + Math.sin(angle) * amount / 8);
		double x2 = ((originX + 8) - Math.sin(angle) * amount / 8);
		double z1 = ((originZ + 8) + Math.cos(angle) * amount / 8);
		double z2 = ((originZ + 8) - Math.cos(angle) * amount / 8);
		double y1 = (originY + random.nextInt(3) + 2);
		double y2 = (originY + random.nextInt(3) + 2);

		for(int count = 0; count <= amount; count++) {
			double seedX = x1 + (x2 - x1) * count / amount;
			double seedY = y1 + (y2 - y1) * count / amount;
			double seedZ = z1 + (z2 - z1) * count / amount;
			double size = ((Math.sin(count * Math.PI / amount) + 1) * random.nextDouble() * amount / 16 + 1) / 2;

			int startX = (int) (seedX - size);
			int startY = (int) (seedY - size);
			int startZ = (int) (seedZ - size);
			int endX = (int) (seedX + size);
			int endY = (int) (seedY + size);
			int endZ = (int) (seedZ + size);

			for (int x = startX; x <= endX; x++) {
				double sizeX = (x + 0.5 - seedX) / size;
				sizeX *= sizeX;
				if(sizeX < 1) {
					for(int y = startY; y <= endY; y++) {
						double sizeY = (y + 0.5 - seedY) / size;
						sizeY *= sizeY;
						if(sizeX + sizeY < 1) {
							for(int z = startZ; z <= endZ; z++) {
								double sizeZ = (z + 0.5 - seedZ) / size;
								sizeZ *= sizeZ;
								if(sizeX + sizeY + sizeZ < 1 && level.getBlockTypeAt(x, y, z) == VanillaBlock.STONE) {
									level.setBlockAt(x, y, z, type);
								}
							}
						}
					}
				}
			}
		}
	}
}
