package ch.spacebase.openclassic.api.block;

import ch.spacebase.openclassic.api.block.physics.BlockPhysics;

/**
 * Represents a block type.
 */
public enum BlockType {

	AIR((byte) 0),
	STONE((byte) 1),
	GRASS((byte) 2),
	DIRT((byte) 3),
	COBBLESTONE((byte) 4),
	WOOD((byte) 5),
	SAPLING((byte) 6),
	BEDROCK((byte) 7),
	WATER((byte) 8, true),
	STATIONARY_WATER((byte) 9, true),
	LAVA((byte) 10, true),
	STATIONARY_LAVA((byte) 11, true),
	SAND((byte) 12),
	GRAVEL((byte) 13),
	GOLD_ORE((byte) 14),
	IRON_ORE((byte) 15),
	COAL_ORE((byte) 16),
	LOG((byte) 17),
	LEAVES((byte) 18),
	SPONGE((byte) 19),
	GLASS((byte) 20),
	RED_CLOTH((byte) 21),
	ORANGE_CLOTH((byte) 22),
	YELLOW_CLOTCH((byte) 23),
	LIME_CLOTH((byte) 24),
	GREEN_CLOTH((byte) 25),
	AQUA_GREEN_CLOTH((byte) 26),
	CYAN_CLOTH((byte) 27),
	BLUE_CLOTH((byte) 28),
	PURPLE_CLOTH((byte) 29),
	INDIGO_CLOTH((byte) 30),
	VIOLET_CLOTH((byte) 31),
	MAGENTA_CLOTH((byte) 32),
	PINK_CLOTH((byte) 33),
	BLACK_CLOTH((byte) 34),
	GRAY_CLOTH((byte) 35),
	WHITE_CLOTH((byte) 36),
	DANDELION((byte) 37),
	ROSE((byte) 38),
	BROWN_MUSHROOM((byte) 39),
	RED_MUSHROOM((byte) 40),
	GOLD_BLOCK((byte) 41),
	IRON_BLOCK((byte) 42),
	DOUBLE_SLAB((byte) 43),
	SLAB((byte) 44),
	BRICK_BLOCK((byte) 45),
	TNT((byte) 46),
	BOOKSHELF((byte) 47),
	MOSSY_COBBLESTONE((byte) 48),
	OBSIDIAN((byte) 49);
	
	private byte id;
	private BlockPhysics phys;
	private boolean liquid;
	
	private BlockType(byte id) {
		this(id, false);
	}
	
	private BlockType(byte id, boolean liquid) {
		this.id = id;
		this.liquid = liquid;
	}
	
	/**
	 * Gets the block's id.
	 * @return The block's id.
	 */
	public byte getId() {
		return this.id;
	}
	
	/**
	 * Gets the block's physics if applicable.
	 * @return The block's physics.
	 */
	public BlockPhysics getPhysics() {
		return this.phys;
	}
	
	/**
	 * Sets the block's physics.
	 * @param The physics to set.
	 */
	public void setPhysics(BlockPhysics phys) {
		this.phys = phys;
	}
	
	/**
	 * Gets whether the block is a liquid.
	 * @return True if the block is a liquid.
	 */
	public boolean isLiquid() {
		return this.liquid;
	}
	
	/**
	 * Gets a BlockType from the given block ID.
	 * @param ID to get a type for.
	 * @return The BlockType with the given ID.
	 */
	public static BlockType fromId(int id) {
		for(BlockType block : values()) {
			if(block.getId() == id) return block;
		}
		
		return null;
	}
	
}
