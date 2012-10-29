package ch.spacebase.openclassic.api.block;

import java.util.Arrays;
import java.util.List;

import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.event.block.BlockRegisterEvent;
import ch.spacebase.openclassic.api.event.block.BlockUnregisterEvent;

/**
 * The block registry.
 */
public class Blocks {
	
	private static final BlockType registry[] = new BlockType[256 * 16];
	
	static {
		// make sure default blocks are loaded.
		@SuppressWarnings("unused")
		BlockType v = VanillaBlock.STONE;
	}
	
	/**
	 * Gets the block with the given ID.
	 * @param id ID of the block.
	 * @return The block with the given ID.
	 */
	public static BlockType get(int id) {
		return get(id, 0);
	}
	
	/**
	 * Gets the block with the given ID and data.
	 * @param id ID of the block.
	 * @param data Data of the block.
	 * @return The block with the given ID and data.
	 */
	public static BlockType get(int id, int data) {
		data &= 0xf;
		return registry[id * 16 + data];
	}
	
	/**
	 * Registers a block.
	 * @param block Block to register.
	 */
	public static void register(BlockType block) {
		OpenClassic.getGame().getEventManager().dispatch(new BlockRegisterEvent(block));
		registry[block.getId() * 16 + block.getData()] = block;
	}
	
	/**
	 * Unregisters a block.
	 * @param id ID of the Block to unregister.
	 */
	public static void unregister(int id) {
		for(int data = 0; data < 16; data++) {
			unregister(id, data);
		}
	}
	
	/**
	 * Unregisters a block.
	 * @param id ID of the Block to unregister.
	 * @param data Data of the Block to unregister.
	 */
	public static void unregister(int id, int data) {
		data &= 0xf;
		if(get(id, data) != null) {
			OpenClassic.getGame().getEventManager().dispatch(new BlockUnregisterEvent(get(id, data)));
			registry[id * 16 + data] = null;
		}
	}
	
	/**
	 * Gets a list of all the blocks.
	 * @return A list of blocks.
	 */
	public static List<BlockType> getBlocks() {
		return Arrays.asList(registry);
	}
	
}
