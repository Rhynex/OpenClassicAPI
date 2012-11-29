package ch.spacebase.openclassic.api.block;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.block.model.CactusModel;
import ch.spacebase.openclassic.api.block.model.CubeModel;
import ch.spacebase.openclassic.api.block.model.CuboidModel;
import ch.spacebase.openclassic.api.block.model.EmptyModel;
import ch.spacebase.openclassic.api.block.model.PlantModel;
import ch.spacebase.openclassic.api.block.model.LiquidModel;
import ch.spacebase.openclassic.api.util.LeastToGreatestSorter;

/**
 * A class containing the basic vanilla block types.
 */
public final class VanillaBlock {

	public static final BlockType AIR = new BlockType(0, StepSound.NONE, new EmptyModel()).setOpaque(false).setSelectable(false);
	public static final BlockType STONE = new BlockType(1, StepSound.STONE, 1).setBreakTicks(20);
	public static final BlockType GRASS = new BlockType(2, StepSound.GRASS, new CubeModel(BlockType.TERRAIN, new int[] { 2, 0, 3, 3, 3, 3 })).setSelectable(false).setBreakTicks(12);
	public static final BlockType DIRT = new BlockType(3, StepSound.DIRT, 2).setBreakTicks(12);
	public static final BlockType COBBLESTONE = new BlockType(4, StepSound.STONE, 16).setBreakTicks(30);
	public static final BlockType WOOD = new BlockType(5, StepSound.WOOD, 4).setBreakTicks(30);
	public static final BlockType SAPLING = new BlockType(6, StepSound.GRASS, new PlantModel(BlockType.TERRAIN, 15)).setOpaque(false);
	public static final BlockType BEDROCK = new BlockType(7, StepSound.STONE, 17).setSelectable(false);
	public static final BlockType WATER = new BlockType(8, StepSound.NONE, new LiquidModel(BlockType.TERRAIN, 14)).setLiquid(true).setOpaque(false).setTickDelay(5).setSelectable(false);
	public static final BlockType STATIONARY_WATER = new BlockType(9, StepSound.NONE, new LiquidModel(BlockType.TERRAIN, 14)).setLiquid(true).setOpaque(false).setSelectable(false);
	public static final BlockType LAVA = new BlockType(10, StepSound.NONE, new LiquidModel(BlockType.TERRAIN, 30)).setLiquid(true).setOpaque(false).setTickDelay(20).setSelectable(false).setBrightness(100);
	public static final BlockType STATIONARY_LAVA = new BlockType(11, StepSound.NONE, new LiquidModel(BlockType.TERRAIN, 30)).setLiquid(true).setOpaque(false).setSelectable(false).setBrightness(100);
	public static final BlockType SAND = new BlockType(12, StepSound.SAND, 18).setBreakTicks(12);
	public static final BlockType GRAVEL = new BlockType(13, StepSound.GRAVEL, 19).setBreakTicks(12);
	public static final BlockType GOLD_ORE = new BlockType(14, StepSound.STONE, 32).setBreakTicks(60);
	public static final BlockType IRON_ORE = new BlockType(15, StepSound.STONE, 33).setBreakTicks(60);
	public static final BlockType COAL_ORE = new BlockType(16, StepSound.STONE, 34).setBreakTicks(60);
	public static final BlockType LOG = new BlockType(17, StepSound.WOOD, new CubeModel(BlockType.TERRAIN, new int[] { 21, 21, 20, 20, 20, 20 })).setBreakTicks(50);
	public static final BlockType LEAVES = new BlockType(18, StepSound.GRASS, 22).setOpaque(false).setBreakTicks(4);
	public static final BlockType SPONGE = new BlockType(19, StepSound.GRASS, 48).setBreakTicks(12);
	public static final BlockType GLASS = new BlockType(20, StepSound.METAL, 49).setOpaque(false).setBreakTicks(6);
	public static final BlockType RED_CLOTH = new BlockType(21, StepSound.CLOTH, 64).setBreakTicks(16);
	public static final BlockType ORANGE_CLOTH = new BlockType(21, 1, StepSound.CLOTH, 65).setBreakTicks(16);
	public static final BlockType YELLOW_CLOTH = new BlockType(21, 2, StepSound.CLOTH, 66).setBreakTicks(16);
	public static final BlockType LIME_CLOTH = new BlockType(21, 3, StepSound.CLOTH, 67).setBreakTicks(16);
	public static final BlockType GREEN_CLOTH = new BlockType(21, 4, StepSound.CLOTH, 68).setBreakTicks(16);
	public static final BlockType AQUA_GREEN_CLOTH = new BlockType(21, 5, StepSound.CLOTH, 69).setBreakTicks(16);
	public static final BlockType CYAN_CLOTH = new BlockType(21, 6, StepSound.CLOTH, 70).setBreakTicks(16);
	public static final BlockType BLUE_CLOTH = new BlockType(21, 7, StepSound.CLOTH, 71).setBreakTicks(16);
	public static final BlockType PURPLE_CLOTH = new BlockType(21, 8, StepSound.CLOTH, 72).setBreakTicks(16);
	public static final BlockType INDIGO_CLOTH = new BlockType(21, 9, StepSound.CLOTH, 73).setBreakTicks(16);
	public static final BlockType VIOLET_CLOTH = new BlockType(21, 10, StepSound.CLOTH, 74).setBreakTicks(16);
	public static final BlockType MAGENTA_CLOTH = new BlockType(21, 11, StepSound.CLOTH, 75).setBreakTicks(16);
	public static final BlockType PINK_CLOTH = new BlockType(21, 12, StepSound.CLOTH, 76).setBreakTicks(16);
	public static final BlockType BLACK_CLOTH = new BlockType(21, 13, StepSound.CLOTH, 77).setBreakTicks(16);
	public static final BlockType GRAY_CLOTH = new BlockType(21, 14, StepSound.CLOTH, 78).setBreakTicks(16);
	public static final BlockType WHITE_CLOTH = new BlockType(21, 15, StepSound.CLOTH, 79).setBreakTicks(16);
	public static final BlockType SANDSTONE = new BlockType(22, StepSound.STONE, new CubeModel(BlockType.TERRAIN, new int[] { 57, 25, 41, 41, 41, 41 })).setBreakTicks(20);
	public static final BlockType CACTUS = new BlockType(23, StepSound.CLOTH, new CactusModel(BlockType.TERRAIN, new int[] { 47, 45, 46, 46, 46, 46 })).setBreakTicks(16);
	public static final BlockType MUD = new BlockType(24, StepSound.GRAVEL, 2); // TODO: texture
	public static final BlockType DANDELION = new BlockType(37, StepSound.GRASS, new PlantModel(BlockType.TERRAIN, 13)).setOpaque(false);
	public static final BlockType ROSE = new BlockType(38, StepSound.GRASS, new PlantModel(BlockType.TERRAIN, 12)).setOpaque(false);
	public static final BlockType BROWN_MUSHROOM = new BlockType(39, StepSound.GRASS, new PlantModel(BlockType.TERRAIN, 29)).setOpaque(false);
	public static final BlockType RED_MUSHROOM = new BlockType(40, StepSound.GRASS, new PlantModel(BlockType.TERRAIN, 28)).setOpaque(false);
	public static final BlockType GOLD_BLOCK = new BlockType(41, StepSound.METAL, new CubeModel(BlockType.TERRAIN, new int[] { 56, 24, 40, 40, 40, 40 })).setBreakTicks(60);
	public static final BlockType IRON_BLOCK = new BlockType(42, StepSound.METAL, new CubeModel(BlockType.TERRAIN, new int[] { 55, 23, 39, 39, 39, 39 })).setBreakTicks(100);
	public static final BlockType DOUBLE_SLAB = new BlockType(43, StepSound.STONE, new CubeModel(BlockType.TERRAIN, new int[] { 6, 6, 5, 5, 5, 5 })).setSelectable(false).setBreakTicks(20);
	public static final BlockType SLAB = new BlockType(44, StepSound.STONE, new CuboidModel(BlockType.TERRAIN, new int[] { 6, 6, 5, 5, 5, 5 }, 0, 0, 0, 1, 0.5F, 1)).setBreakTicks(20);
	public static final BlockType BRICK_BLOCK = new BlockType(45, StepSound.STONE, 7);
	public static final BlockType TNT = new BlockType(46, StepSound.GRASS, new CubeModel(BlockType.TERRAIN, new int[] { 10, 9, 8, 8, 8, 8 }));
	public static final BlockType BOOKSHELF = new BlockType(47, StepSound.WOOD, new CubeModel(BlockType.TERRAIN, new int[] { 4, 4, 35, 35, 35, 35 })).setBreakTicks(30);
	public static final BlockType MOSSY_COBBLESTONE = new BlockType(48, StepSound.STONE, 36).setBreakTicks(20);
	public static final BlockType OBSIDIAN = new BlockType(49, StepSound.STONE, 37).setBreakTicks(200);
	
	private static final Map<Integer, BlockType> blocks = new TreeMap<Integer, BlockType>(new LeastToGreatestSorter());
	
	static {
		try {
			for(Field field : VanillaBlock.class.getDeclaredFields()) {
				if(field.getType() == BlockType.class) {
					BlockType type = (BlockType) field.get(null);
					Blocks.register(type);
					blocks.put(type.getId() * 16 + type.getData(), type);
				}
			}
		} catch(Exception e) {
			OpenClassic.getLogger().severe("Failed to reflect over VanillaBlock! Expect errors!");
			e.printStackTrace();
		}
	}
	
	public static boolean is(BlockType block) {
		return blocks.containsKey(block.getId() * 16 + block.getData());
	}
	
	public static List<BlockType> getBlocks() {
		return new ArrayList<BlockType>(blocks.values());
	}
	
}
