package ch.spacebase.openclassic.api.block;

import ch.spacebase.openclassic.api.Position;
import ch.spacebase.openclassic.api.entity.Entity;

/**
 * Represents a block.
 */
public class Block {

	private Position pos;
	
	public Block(Position pos) {
		this.pos = pos;
	}
	
	/**
	 * Gets the block's ID.
	 * @return The block's ID.
	 */
	public byte getTypeId() {
		return this.pos.getLevel().getBlockIdAt(pos);
	}
	
	/**
	 * Sets the block's ID.
	 * @param Block ID to set.
	 */
	public void setTypeId(byte id) {
		this.pos.getLevel().setBlockIdAt(pos, id);
	}
	
	/**
	 * Gets the block's type.
	 * @return The block's type.
	 */
	public BlockType getType() {
		return BlockType.fromId(this.getTypeId());
	}
	
	/**
	 * Sets the block's type.
	 * @param BlockType to set.
	 */
	public void setType(BlockType type) {
		this.setTypeId(type.getId());
	}
	
	/**
	 * Gets the block's position.
	 * @return The block's position.
	 */
	public Position getPosition() {
		return this.pos;
	}
	
	/**
	 * Gets the block relative the given face.
	 * @param Face to get the block relative from.
	 * @return The block relative from the given face.
	 */
	public Block getRelative(BlockFace face) {
		Position pos = this.pos.clone().add(face.getModX(), face.getModY(), face.getModZ());
		if(pos.getBlockX() >= this.pos.getLevel().getWidth() || pos.getBlockX() < 0) return null;
		if(pos.getBlockY() >= this.pos.getLevel().getHeight() || pos.getBlockY() < 0) return null;
		if(pos.getBlockZ() >= this.pos.getLevel().getDepth() || pos.getBlockZ() < 0) return null;
		
		return new Block(pos);
	}
	
	/**
	 * Gets the entity of this block, if there is one.
	 * @return The block's entity.
	 */
	public Entity getEntity() {
		return this.pos.getLevel().getEntity(this.pos);
	}
	
	/**
	 * Returns true if this block is an entity.
	 * @return Whether the block is an entity.
	 */
	public boolean isEntity() {
		return this.getEntity() != null;
	}
	
}
