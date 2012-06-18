package ch.spacebase.openclassic.api.block;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import ch.spacebase.openclassic.api.event.EventFactory;
import ch.spacebase.openclassic.api.event.block.BlockRegisterEvent;
import ch.spacebase.openclassic.api.event.block.BlockUnregisterEvent;

/**
 * The block registry.
 */
public class Blocks {
	
	private static final SortedMap<Byte, BlockType> registry = new TreeMap<Byte, BlockType>();
	
	/**
	 * Gets the block with the given ID.
	 * @param id ID of the block.
	 * @return The block with the given ID.
	 */
	public static BlockType fromId(int id) {
		return registry.get((byte) id);
	}
	
	/**
	 * Registers a block.
	 * @param block Block to register.
	 */
	public static void register(BlockType block) {
		EventFactory.callEvent(new BlockRegisterEvent(block));
		registry.put(block.getId(), block);
	}
	
	/**
	 * Unregisters a block.
	 * @param id ID of the Block to unregister.
	 */
	public static void unregister(int id) {
		EventFactory.callEvent(new BlockUnregisterEvent(fromId(id)));
		registry.remove((byte) id);
	}
	
	/**
	 * Gets a list of all the blocks.
	 * @return A list of blocks.
	 */
	public static List<BlockType> getBlocks() {
		return new ArrayList<BlockType>(registry.values());
	}
	
}
