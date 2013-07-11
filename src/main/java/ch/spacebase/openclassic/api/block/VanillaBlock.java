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
import ch.spacebase.openclassic.api.block.physics.CactusPhysics;
import ch.spacebase.openclassic.api.block.physics.ReedPhysics;
import ch.spacebase.openclassic.api.block.physics.HarvestPhysics;
import ch.spacebase.openclassic.api.block.physics.LiquidPhysics;
import ch.spacebase.openclassic.api.inventory.ItemStack;
import ch.spacebase.openclassic.api.item.VanillaItem;
import ch.spacebase.openclassic.api.item.physics.AxePhysics;
import ch.spacebase.openclassic.api.item.physics.PickaxePhysics;
import ch.spacebase.openclassic.api.item.physics.ShovelPhysics;
import ch.spacebase.openclassic.api.util.LeastToGreatestSorter;

/**
 * A class containing the basic vanilla block types.
 */
public final class VanillaBlock {

	public static final BlockType AIR = new BlockType(0, StepSound.NONE, new EmptyModel()).setOpaque(false);
	public static final BlockType STONE = new BlockType(1, StepSound.STONE, 1).setHardness(1.5f).setPhysics(new HarvestPhysics(1, PickaxePhysics.class));
	public static final BlockType GRASS = new BlockType(2, StepSound.GRASS, new CubeModel(BlockType.TERRAIN, new int[] { 2, 0, 3, 3, 3, 3 })).setHardness(0.6f);
	public static final BlockType DIRT = new BlockType(3, StepSound.DIRT, 2).setHardness(0.5f);
	public static final BlockType COBBLESTONE = new BlockType(4, StepSound.STONE, 16).setHardness(2).setPhysics(new HarvestPhysics(4, PickaxePhysics.class));
	public static final BlockType WOOD = new BlockType(5, StepSound.WOOD, 4).setHardness(2);
	public static final BlockType SAPLING = new BlockType(6, StepSound.GRASS, new PlantModel(BlockType.TERRAIN, 15, 0.25f, 0.75f, 0.85f)).setOpaque(false);
	public static final BlockType BEDROCK = new BlockType(7, StepSound.STONE, 17).setHardness(-1);
	public static final BlockType WATER = new BlockType(8, StepSound.NONE, new LiquidModel(BlockType.TERRAIN, 14, 0.95f)).setLiquid(true).setOpaque(false).setTickDelay(5).setPhysics(new LiquidPhysics(8, 7));
	public static final BlockType WATER_1 = new BlockType(8, 1, StepSound.NONE, new LiquidModel(BlockType.TERRAIN, 14, (7 / 8f) - 0.05f)).setLiquid(true).setOpaque(false).setTickDelay(5).setPhysics(new LiquidPhysics(8, 7));
	public static final BlockType WATER_2 = new BlockType(8, 2, StepSound.NONE, new LiquidModel(BlockType.TERRAIN, 14, (6 / 8f) - 0.05f)).setLiquid(true).setOpaque(false).setTickDelay(5).setPhysics(new LiquidPhysics(8, 7));
	public static final BlockType WATER_3 = new BlockType(8, 3, StepSound.NONE, new LiquidModel(BlockType.TERRAIN, 14, (5 / 8f) - 0.05f)).setLiquid(true).setOpaque(false).setTickDelay(5).setPhysics(new LiquidPhysics(8, 7));
	public static final BlockType WATER_4 = new BlockType(8, 4, StepSound.NONE, new LiquidModel(BlockType.TERRAIN, 14, (4 / 8f) - 0.05f)).setLiquid(true).setOpaque(false).setTickDelay(5).setPhysics(new LiquidPhysics(8, 7));
	public static final BlockType WATER_5 = new BlockType(8, 5, StepSound.NONE, new LiquidModel(BlockType.TERRAIN, 14, (3 / 8f) - 0.05f)).setLiquid(true).setOpaque(false).setTickDelay(5).setPhysics(new LiquidPhysics(8, 7));
	public static final BlockType WATER_6 = new BlockType(8, 6, StepSound.NONE, new LiquidModel(BlockType.TERRAIN, 14, (2 / 8f) - 0.05f)).setLiquid(true).setOpaque(false).setTickDelay(5).setPhysics(new LiquidPhysics(8, 7));
	public static final BlockType WATER_7 = new BlockType(8, 7, StepSound.NONE, new LiquidModel(BlockType.TERRAIN, 14, (1 / 8f) - 0.05f)).setLiquid(true).setOpaque(false).setTickDelay(5).setPhysics(new LiquidPhysics(8, 7));
	public static final BlockType STATIONARY_WATER = new BlockType(9, StepSound.NONE, new LiquidModel(BlockType.TERRAIN, 14, 0.95f)).setLiquid(true).setOpaque(false);
	public static final BlockType LAVA = new BlockType(10, StepSound.NONE, new LiquidModel(BlockType.TERRAIN, 30, 0.95f)).setLiquid(true).setOpaque(false).setTickDelay(20).setBrightness(100).setPhysics(new LiquidPhysics(10, 4));
	public static final BlockType LAVA_1 = new BlockType(10, 1, StepSound.NONE, new LiquidModel(BlockType.TERRAIN, 30, (4 / 5f) - 0.05f)).setLiquid(true).setOpaque(false).setTickDelay(20).setBrightness(100).setPhysics(new LiquidPhysics(10, 4));
	public static final BlockType LAVA_2 = new BlockType(10, 2, StepSound.NONE, new LiquidModel(BlockType.TERRAIN, 30, (3 / 5f) - 0.05f)).setLiquid(true).setOpaque(false).setTickDelay(20).setBrightness(100).setPhysics(new LiquidPhysics(10, 4));
	public static final BlockType LAVA_3 = new BlockType(10, 3, StepSound.NONE, new LiquidModel(BlockType.TERRAIN, 30, (2 / 5f) - 0.05f)).setLiquid(true).setOpaque(false).setTickDelay(20).setBrightness(100).setPhysics(new LiquidPhysics(10, 4));
	public static final BlockType LAVA_4 = new BlockType(10, 4, StepSound.NONE, new LiquidModel(BlockType.TERRAIN, 30, (1 / 5f) - 0.05f)).setLiquid(true).setOpaque(false).setTickDelay(20).setBrightness(100).setPhysics(new LiquidPhysics(10, 4));
	public static final BlockType STATIONARY_LAVA = new BlockType(11, StepSound.NONE, new LiquidModel(BlockType.TERRAIN, 30, 0.95f)).setLiquid(true).setOpaque(false).setBrightness(100);
	public static final BlockType SAND = new BlockType(12, StepSound.SAND, 18).setHardness(0.5f);
	public static final BlockType GRAVEL = new BlockType(13, StepSound.GRAVEL, 19).setHardness(0.6f);
	public static final BlockType GOLD_ORE = new BlockType(14, StepSound.STONE, 32).setHardness(3).setPhysics(new HarvestPhysics(14, PickaxePhysics.class, 6));
	public static final BlockType IRON_ORE = new BlockType(15, StepSound.STONE, 33).setHardness(3).setPhysics(new HarvestPhysics(15, PickaxePhysics.class, 4));
	public static final BlockType COAL_ORE = new BlockType(16, StepSound.STONE, 34).setHardness(3).setPhysics(new HarvestPhysics(16, PickaxePhysics.class));
	public static final BlockType LOG = new BlockType(17, StepSound.WOOD, new CubeModel(BlockType.TERRAIN, new int[] { 21, 21, 20, 20, 20, 20 })).setHardness(2);
	public static final BlockType LEAVES = new BlockType(18, StepSound.GRASS, 22).setOpaque(false).setHardness(0.2f);
	public static final BlockType SPONGE = new BlockType(19, StepSound.GRASS, 48).setHardness(0.6f);
	public static final BlockType GLASS = new BlockType(20, StepSound.METAL, 49).setOpaque(false).setHardness(0.3f);
	public static final BlockType RED_CLOTH = new BlockType(21, StepSound.CLOTH, 64).setHardness(0.8f);
	public static final BlockType ORANGE_CLOTH = new BlockType(21, 1, StepSound.CLOTH, 65).setHardness(0.8f);
	public static final BlockType YELLOW_CLOTH = new BlockType(21, 2, StepSound.CLOTH, 66).setHardness(0.8f);
	public static final BlockType LIME_CLOTH = new BlockType(21, 3, StepSound.CLOTH, 67).setHardness(0.8f);
	public static final BlockType GREEN_CLOTH = new BlockType(21, 4, StepSound.CLOTH, 68).setHardness(0.8f);
	public static final BlockType AQUA_GREEN_CLOTH = new BlockType(21, 5, StepSound.CLOTH, 69).setHardness(0.8f);
	public static final BlockType LIGHT_BLUE_CLOTH = new BlockType(21, 6, StepSound.CLOTH, 70).setHardness(0.8f);
	public static final BlockType BLUE_CLOTH = new BlockType(21, 7, StepSound.CLOTH, 71).setHardness(0.8f);
	public static final BlockType PURPLE_CLOTH = new BlockType(21, 8, StepSound.CLOTH, 72).setHardness(0.8f);
	public static final BlockType MAGENTA_CLOTH = new BlockType(21, 9, StepSound.CLOTH, 73).setHardness(0.8f);
	public static final BlockType PINK_CLOTH = new BlockType(21, 10, StepSound.CLOTH, 74).setHardness(0.8f);
	public static final BlockType BROWN_CLOTH = new BlockType(21, 11, StepSound.CLOTH, 75).setHardness(0.8f);
	public static final BlockType BLACK_CLOTH = new BlockType(21, 12, StepSound.CLOTH, 76).setHardness(0.8f);
	public static final BlockType DARK_GRAY_CLOTH = new BlockType(21, 13, StepSound.CLOTH, 77).setHardness(0.8f);
	public static final BlockType GRAY_CLOTH = new BlockType(21, 14, StepSound.CLOTH, 78).setHardness(0.8f);
	public static final BlockType WHITE_CLOTH = new BlockType(21, 15, StepSound.CLOTH, 79).setHardness(0.8f);
	public static final BlockType SANDSTONE = new BlockType(22, StepSound.STONE, new CubeModel(BlockType.TERRAIN, new int[] { 58, 26, 42, 42, 42, 42 })).setHardness(0.8f).setPhysics(new HarvestPhysics(22, PickaxePhysics.class));
	public static final BlockType CACTUS = new BlockType(23, StepSound.CLOTH, new CactusModel(BlockType.TERRAIN, new int[] { 47, 45, 46, 46, 46, 46 })).setHardness(0.4f).setPhysics(new CactusPhysics());
	public static final BlockType MUD = new BlockType(24, StepSound.GRAVEL, 2).setHardness(0.5f); // TODO: texture
	public static final BlockType DIAMOND_ORE = new BlockType(25, StepSound.STONE, 50).setHardness(3).setPhysics(new HarvestPhysics(25, PickaxePhysics.class, 6));
	public static final BlockType DIAMOND_BLOCK = new BlockType(26, StepSound.METAL, new CubeModel(BlockType.TERRAIN, new int[] { 57, 25, 41, 41, 41, 41 })).setHardness(5).setPhysics(new HarvestPhysics(26, PickaxePhysics.class, 6));
	public static final BlockType WORKBENCH = new BlockType(26, StepSound.WOOD, new CubeModel(BlockType.TERRAIN, new int[] { 4, 43, 44, 59, 44, 59 })).setHardness(2.5f);
	public static final BlockType CLAY_BLOCK = new BlockType(27, StepSound.GRAVEL, 51).setHardness(0.6f);
	public static final BlockType REEDS = new BlockType(28, StepSound.GRASS, new PlantModel(BlockType.TERRAIN, 52, 0, 1, 1)).setOpaque(false).setPhysics(new ReedPhysics());
	public static final BlockType LAPIS_LAZULI_ORE = new BlockType(29, StepSound.STONE, 38).setHardness(3).setPhysics(new HarvestPhysics(25, PickaxePhysics.class, 4));
	public static final BlockType LAPIS_LAZULI_BLOCK = new BlockType(30, StepSound.STONE, 54).setHardness(3).setPhysics(new HarvestPhysics(25, PickaxePhysics.class, 4));
	public static final BlockType FURNACE_EAST = new BlockType(31, StepSound.STONE, new CubeModel(BlockType.TERRAIN, new int[] { 60, 60, 61, 62, 62, 62 })).setHardness(3.5f);
	public static final BlockType FURNACE_WEST = new BlockType(31, 1, StepSound.STONE, new CubeModel(BlockType.TERRAIN, new int[] { 60, 60, 62, 61, 62, 62 })).setHardness(3.5f);
	public static final BlockType FURNACE_NORTH = new BlockType(31, 2, StepSound.STONE, new CubeModel(BlockType.TERRAIN, new int[] { 60, 60, 62, 62, 61, 62 })).setHardness(3.5f);
	public static final BlockType FURNACE_SOUTH = new BlockType(31, 3, StepSound.STONE, new CubeModel(BlockType.TERRAIN, new int[] { 60, 60, 62, 62, 62, 61 })).setHardness(3.5f);
	public static final BlockType BURNING_FURNACE_EAST = new BlockType(31, 4, StepSound.STONE, new CubeModel(BlockType.TERRAIN, new int[] { 60, 60, 63, 62, 62, 62 })).setHardness(3.5f);
	public static final BlockType BURNING_FURNACE_WEST = new BlockType(31, 5, StepSound.STONE, new CubeModel(BlockType.TERRAIN, new int[] { 60, 60, 62, 63, 62, 62 })).setHardness(3.5f);
	public static final BlockType BURNING_FURNACE_NORTH = new BlockType(31, 6, StepSound.STONE, new CubeModel(BlockType.TERRAIN, new int[] { 60, 60, 62, 62, 63, 62 })).setHardness(3.5f);
	public static final BlockType BURNING_FURNACE_SOUTH = new BlockType(31, 7, StepSound.STONE, new CubeModel(BlockType.TERRAIN, new int[] { 60, 60, 62, 62, 62, 63 })).setHardness(3.5f);
	public static final BlockType CHEST_EAST = new BlockType(32, StepSound.WOOD, new CubeModel(BlockType.TERRAIN, new int[] { 80, 80, 81, 82, 82, 82 })).setHardness(2.5f);
	public static final BlockType CHEST_WEST = new BlockType(32, 1, StepSound.WOOD, new CubeModel(BlockType.TERRAIN, new int[] { 80, 80, 82, 81, 82, 82 })).setHardness(2.5f);
	public static final BlockType CHEST_NORTH = new BlockType(32, 2, StepSound.WOOD, new CubeModel(BlockType.TERRAIN, new int[] { 80, 80, 82, 82, 81, 82 })).setHardness(2.5f);
	public static final BlockType CHEST_SOUTH = new BlockType(32, 3, StepSound.WOOD, new CubeModel(BlockType.TERRAIN, new int[] { 80, 80, 82, 82, 82, 81 })).setHardness(2.5f);
	public static final BlockType DANDELION = new BlockType(37, StepSound.GRASS, new PlantModel(BlockType.TERRAIN, 13)).setOpaque(false);
	public static final BlockType ROSE = new BlockType(38, StepSound.GRASS, new PlantModel(BlockType.TERRAIN, 12)).setOpaque(false);
	public static final BlockType BROWN_MUSHROOM = new BlockType(39, StepSound.GRASS, new PlantModel(BlockType.TERRAIN, 29)).setOpaque(false);
	public static final BlockType RED_MUSHROOM = new BlockType(40, StepSound.GRASS, new PlantModel(BlockType.TERRAIN, 28)).setOpaque(false);
	public static final BlockType GOLD_BLOCK = new BlockType(41, StepSound.METAL, new CubeModel(BlockType.TERRAIN, new int[] { 56, 24, 40, 40, 40, 40 })).setHardness(3).setPhysics(new HarvestPhysics(41, PickaxePhysics.class, 6));
	public static final BlockType IRON_BLOCK = new BlockType(42, StepSound.METAL, new CubeModel(BlockType.TERRAIN, new int[] { 55, 23, 39, 39, 39, 39 })).setHardness(5).setPhysics(new HarvestPhysics(42, PickaxePhysics.class, 6));
	public static final BlockType DOUBLE_SLAB = new BlockType(43, StepSound.STONE, new CubeModel(BlockType.TERRAIN, new int[] { 6, 6, 5, 5, 5, 5 })).setHardness(2);
	public static final BlockType SLAB = new BlockType(44, StepSound.STONE, new CuboidModel(BlockType.TERRAIN, new int[] { 6, 6, 5, 5, 5, 5 }, 0, 0, 0, 1, 0.5F, 1)).setHardness(2);
	public static final BlockType BRICK_BLOCK = new BlockType(45, StepSound.STONE, 7).setHardness(2).setPhysics(new HarvestPhysics(45, PickaxePhysics.class));
	public static final BlockType TNT = new BlockType(46, StepSound.GRASS, new CubeModel(BlockType.TERRAIN, new int[] { 10, 9, 8, 8, 8, 8 }));
	public static final BlockType BOOKSHELF = new BlockType(47, StepSound.WOOD, new CubeModel(BlockType.TERRAIN, new int[] { 4, 4, 35, 35, 35, 35 })).setHardness(1.5f);
	public static final BlockType MOSSY_COBBLESTONE = new BlockType(48, StepSound.STONE, 36).setHardness(2).setPhysics(new HarvestPhysics(48, PickaxePhysics.class));
	public static final BlockType OBSIDIAN = new BlockType(49, StepSound.STONE, 37).setHardness(50).setPhysics(new HarvestPhysics(49, PickaxePhysics.class, 8));
	
	private static final Map<Integer, BlockType> blocks = new TreeMap<Integer, BlockType>(new LeastToGreatestSorter());
	
	static {
		try {
			for(Field field : VanillaBlock.class.getDeclaredFields()) {
				if(field.getType() == BlockType.class) {
					BlockType type = (BlockType) field.get(null);
					Blocks.register(type);
					type.fixDrops();
					blocks.put(type.getId() * 16 + type.getData(), type);
				}
			}
		} catch(Exception e) {
			OpenClassic.getLogger().severe("Failed to reflect over VanillaBlock! Expect errors!");
			e.printStackTrace();
		}
		
		STONE.setDrops(new ItemStack(COBBLESTONE));
		GRASS.setDrops(new ItemStack(DIRT));
		BEDROCK.setDrops();
		COAL_ORE.setDrops(new ItemStack(VanillaItem.COAL));
		LEAVES.setDrops(new ItemStack(SAPLING)).setDropChance(20);
		GLASS.setDrops();
		DIAMOND_ORE.setDrops(new ItemStack(VanillaItem.DIAMOND));
		CLAY_BLOCK.setDrops(new ItemStack(VanillaItem.CLAY, 4));
		REEDS.setDrops(new ItemStack(VanillaItem.REEDS));
		LAPIS_LAZULI_ORE.setDrops(new ItemStack(VanillaItem.LAPIS_LAZULI, 4));
		FURNACE_WEST.setDrops(new ItemStack(FURNACE_EAST));
		FURNACE_NORTH.setDrops(new ItemStack(FURNACE_EAST));
		FURNACE_SOUTH.setDrops(new ItemStack(FURNACE_EAST));
		BURNING_FURNACE_EAST.setDrops(new ItemStack(FURNACE_EAST));
		BURNING_FURNACE_WEST.setDrops(new ItemStack(FURNACE_EAST));
		BURNING_FURNACE_NORTH.setDrops(new ItemStack(FURNACE_EAST));
		BURNING_FURNACE_SOUTH.setDrops(new ItemStack(FURNACE_EAST));
		CHEST_WEST.setDrops(new ItemStack(CHEST_EAST));
		CHEST_NORTH.setDrops(new ItemStack(CHEST_EAST));
		CHEST_SOUTH.setDrops(new ItemStack(CHEST_EAST));
		DOUBLE_SLAB.setDrops(new ItemStack(SLAB, 2));
		BOOKSHELF.setDrops(new ItemStack(VanillaItem.BOOK, 3));
		ShovelPhysics.addBlock(GRASS);
		ShovelPhysics.addBlock(DIRT);
		ShovelPhysics.addBlock(SAND);
		ShovelPhysics.addBlock(GRAVEL);
		ShovelPhysics.addBlock(MUD);
		ShovelPhysics.addBlock(CLAY_BLOCK);
		AxePhysics.addBlock(WOOD);
		AxePhysics.addBlock(LOG);
		AxePhysics.addBlock(WORKBENCH);
		AxePhysics.addBlock(CHEST_EAST);
		AxePhysics.addBlock(CHEST_WEST);
		AxePhysics.addBlock(CHEST_NORTH);
		AxePhysics.addBlock(CHEST_SOUTH);
		AxePhysics.addBlock(BOOKSHELF);
	}
	
	public static boolean is(BlockType block) {
		return blocks.containsKey(block.getId() * 16 + block.getData());
	}
	
	public static List<BlockType> getBlocks() {
		return new ArrayList<BlockType>(blocks.values());
	}
	
}
