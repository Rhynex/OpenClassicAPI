package ch.spacebase.openclassic.api.block;

import ch.spacebase.openclassic.api.Position;
import ch.spacebase.openclassic.api.entity.BlockEntity;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.generator.biome.Biome;

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
		return this.pos.getLevel().getBlockIdAt(this.pos);
	}
	
	/**
	 * Gets the block's data.
	 * @return The block's data.
	 */
	public byte getData() {
		return this.pos.getLevel().getData(this.pos);
	}
	
	/**
	 * Gets the block's type.
	 * @return The block's type.
	 */
	public BlockType getType() {
		return Blocks.get(this.getTypeId(), this.getData());
	}
	
	/**
	 * Sets the block's type.
	 * @param type VanillaBlock to set.
	 */
	public boolean setType(BlockType type) {
		return this.pos.getLevel().setBlockAt(this.pos, type);
	}
	
	/**
	 * Sets the block's type.
	 * @param type VanillaBlock to set.
	 * @param physics Whether or not to apply physics.
	 */
	public boolean setType(BlockType type, boolean physics) {
		return this.pos.getLevel().setBlockAt(this.pos, type, physics);
	}
	
	/**
	 * Gets the block's position.
	 * @return The block's position.
	 */
	public Position getPosition() {
		return this.pos;
	}
	
	/**
	 * Gets the block's level.
	 * @return The block's level.
	 */
	public Level getLevel() {
		return this.pos.getLevel();
	}
	
	/**
	 * Gets the block relative to the given face.
	 * @param face Face to get the block relative to.
	 * @return The block relative.
	 */
	public Block getRelative(BlockFace face) {
		return this.getRelative(face, 1);
	}
	
	/**
	 * Gets the block relative to the given face at the given distance.
	 * @param face Face to get the block relative to.
	 * @param dist Distance from the block to get the relative at.
	 * @return The block relative.
	 */
	public Block getRelative(BlockFace face, int dist) {
		return this.getRelative(face.getModX() * dist, face.getModY() * dist, face.getModZ() * dist);
	}
	
	/**
	 * Gets the block relative to the given coordinates.
	 * @param x X to get the block relative to.
	 * @param y Y to get the block relative to.
	 * @param z Z to get the block relative to.
	 * @return The block relative.
	 */
	public Block getRelative(int x, int y, int z) {
		return new Block(this.pos.clone().add(x, y, z));
	}
	
	/**
	 * Gets the entity of this block, if there is one.
	 * @return The block's entity.
	 */
	public BlockEntity getBlockEntity() {
		return this.pos.getLevel().getBlockEntity(this.pos);
	}
	
	/**
	 * Returns true if this block is an entity.
	 * @return Whether the block is an entity.
	 */
	public boolean isEntity() {
		return this.getBlockEntity() != null;
	}

	/**
	 * Gets the biome at this block.
	 * @return The biome at this block.
	 */
	public Biome getBiome() {
		return this.getPosition().getLevel().getBiome(this.getPosition().getBlockX(), this.getPosition().getBlockY(), this.getPosition().getBlockZ());
	}
	
}
