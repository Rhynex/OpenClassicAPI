package ch.spacebase.openclassic.api.item;

import java.util.Arrays;
import java.util.List;

public class Items {

	private static final Item registry[] = new Item[512 * 16];
	
	static {
		// make sure default items are loaded.
		@SuppressWarnings("unused")
		Item v = VanillaItem.WOODEN_PICKAXE;
	}
	
	/**
	 * Gets the item with the given ID.
	 * @param id ID of the item.
	 * @return The item with the given ID.
	 */
	public static Item get(int id) {
		return get(id, 0);
	}
	
	/**
	 * Gets the item with the given ID and data.
	 * @param id ID of the item.
	 * @param data Data of the item.
	 * @return The item with the given ID and data.
	 */
	public static Item get(int id, int data) {
		data &= 0xf;
		Item ret = registry[id * 16 + data];
		if(ret == null && registry[id * 16] != null) return registry[id * 16];
		return ret;
	}
	
	/**
	 * Registers an item.
	 * @param item Item to register.
	 */
	public static void register(Item item) {
		registry[item.getId() * 16 + item.getData()] = item;
	}
	
	/**
	 * Unregisters an item.
	 * @param id ID of the Item to unregister.
	 */
	public static void unregister(int id) {
		for(int data = 0; data < 16; data++) {
			unregister(id, data);
		}
	}
	
	/**
	 * Unregisters an item.
	 * @param id ID of the Item to unregister.
	 * @param data Data of the Item to unregister.
	 */
	public static void unregister(int id, int data) {
		data &= 0xf;
		registry[id * 16 + data] = null;
	}
	
	/**
	 * Gets a list of all the items.
	 * @return A list of items.
	 */
	public static List<Item> getItems() {
		return Arrays.asList(registry);
	}
	
}
