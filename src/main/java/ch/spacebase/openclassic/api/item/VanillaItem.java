package ch.spacebase.openclassic.api.item;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.item.physics.AxePhysics;
import ch.spacebase.openclassic.api.item.physics.BoneMealPhysics;
import ch.spacebase.openclassic.api.item.physics.EmptyBucketPhysics;
import ch.spacebase.openclassic.api.item.physics.FoodPhysics;
import ch.spacebase.openclassic.api.item.physics.FullBucketPhysics;
import ch.spacebase.openclassic.api.item.physics.PickaxePhysics;
import ch.spacebase.openclassic.api.item.physics.ReedPhysics;
import ch.spacebase.openclassic.api.item.physics.ShovelPhysics;
import ch.spacebase.openclassic.api.util.LeastToGreatestSorter;

/**
 * A class containing the basic vanilla items.
 */
public final class VanillaItem {

	public static final Item WOODEN_PICKAXE = new Item(256, 96).setMaxStackSize(1).setMaxDamage(59).setPhysics(new PickaxePhysics(2));
	public static final Item STONE_PICKAXE = new Item(257, 97).setMaxStackSize(1).setMaxDamage(131).setPhysics(new PickaxePhysics(4));
	public static final Item IRON_PICKAXE = new Item(258, 98).setMaxStackSize(1).setMaxDamage(250).setPhysics(new PickaxePhysics(6));
	public static final Item GOLD_PICKAXE = new Item(259, 100).setMaxStackSize(1).setMaxDamage(32).setPhysics(new PickaxePhysics(12));
	public static final Item DIAMOND_PICKAXE = new Item(260, 99).setMaxStackSize(1).setMaxDamage(1561).setPhysics(new PickaxePhysics(8));
	public static final Item WOODEN_AXE = new Item(261, 112).setMaxStackSize(1).setMaxDamage(59).setPhysics(new AxePhysics(2));
	public static final Item STONE_AXE = new Item(262, 113).setMaxStackSize(1).setMaxDamage(131).setPhysics(new AxePhysics(4));
	public static final Item IRON_AXE = new Item(263, 114).setMaxStackSize(1).setMaxDamage(250).setPhysics(new AxePhysics(6));
	public static final Item GOLD_AXE = new Item(264, 116).setMaxStackSize(1).setMaxDamage(32).setPhysics(new AxePhysics(12));
	public static final Item DIAMOND_AXE = new Item(265, 115).setMaxStackSize(1).setMaxDamage(1561).setPhysics(new AxePhysics(8));
	public static final Item WOODEN_SHOVEL = new Item(266, 80).setMaxStackSize(1).setMaxDamage(59).setPhysics(new ShovelPhysics(2));
	public static final Item STONE_SHOVEL = new Item(267, 81).setMaxStackSize(1).setMaxDamage(131).setPhysics(new ShovelPhysics(4));
	public static final Item IRON_SHOVEL = new Item(268, 82).setMaxStackSize(1).setMaxDamage(250).setPhysics(new ShovelPhysics(6));
	public static final Item GOLD_SHOVEL = new Item(269, 84).setMaxStackSize(1).setMaxDamage(32).setPhysics(new ShovelPhysics(12));
	public static final Item DIAMOND_SHOVEL = new Item(270, 83).setMaxStackSize(1).setMaxDamage(1561).setPhysics(new ShovelPhysics(8));
	public static final Item COAL = new Item(271, 7);
	public static final Item BOOK = new Item(272, 59);
	public static final Item DIAMOND = new Item(273, 55);
	public static final Item BUCKET = new Item(274, 74).setMaxStackSize(1).setPhysics(new EmptyBucketPhysics());
	public static final Item WATER_BUCKET = new Item(275, 75).setMaxStackSize(1).setPhysics(new FullBucketPhysics(8));
	public static final Item LAVA_BUCKET = new Item(276, 76).setMaxStackSize(1).setPhysics(new FullBucketPhysics(10));
	public static final Item CLAY = new Item(277, 57);
	public static final Item BRICK = new Item(278, 22);
	public static final Item STRING = new Item(279, 8);
	public static final Item GUNPOWDER = new Item(280, 40);
	public static final Item IRON_INGOT = new Item(281, 23);
	public static final Item GOLD_INGOT = new Item(282, 39);
	public static final Item REEDS = new Item(283, 27).setPhysics(new ReedPhysics());
	public static final Item PAPER = new Item(284, 58);
	public static final Item STICK = new Item(285, 53);
	public static final Item RED_DYE = new Item(286, 94);
	public static final Item ORANGE_DYE = new Item(286, 1, 175);
	public static final Item YELLOW_DYE = new Item(286, 2, 127);
	public static final Item LIME_DYE = new Item(286, 3, 111);
	public static final Item GREEN_DYE = new Item(286, 4, 110);
	public static final Item AQUA_GREEN_DYE = new Item(286, 5, 174);
	public static final Item LIGHT_BLUE_DYE = new Item(286, 6, 143);
	public static final Item LAPIS_LAZULI = new Item(286, 7, 142);
	public static final Item PURPLE_DYE = new Item(286, 8, 158);
	public static final Item MAGENTA_DYE = new Item(286, 9, 159);
	public static final Item PINK_DYE = new Item(286, 10, 95);
	public static final Item COCOA_BEANS = new Item(286, 11, 126);
	public static final Item BLACK_DYE = new Item(286, 12, 78);
	public static final Item DARK_GRAY_DYE = new Item(286, 13, 79);
	public static final Item GRAY_DYE = new Item(286, 14, 190);
	public static final Item BONE_MEAL = new Item(286, 15, 191).setPhysics(new BoneMealPhysics());
	public static final Item BONE = new Item(287, 28);
	public static final Item RAW_PORK = new Item(288, 87).setPhysics(new FoodPhysics(3));
	public static final Item COOKED_PORK = new Item(289, 88).setPhysics(new FoodPhysics(8));
	
	private static final Map<Integer, Item> items = new TreeMap<Integer, Item>(new LeastToGreatestSorter());
	
	static {
		try {
			for(Field field : VanillaItem.class.getDeclaredFields()) {
				if(field.getType() == Item.class) {
					Item type = (Item) field.get(null);
					Items.register(type);
					items.put(type.getId() * 16 + type.getData(), type);
				}
			}
		} catch(Exception e) {
			OpenClassic.getLogger().severe("Failed to reflect over VanillaItem! Expect errors!");
			e.printStackTrace();
		}
	}
	
	public static boolean is(Item item) {
		return items.containsKey(item.getId() * 16 + item.getData());
	}
	
	public static List<Item> getItems() {
		return new ArrayList<Item>(items.values());
	}
	
}
