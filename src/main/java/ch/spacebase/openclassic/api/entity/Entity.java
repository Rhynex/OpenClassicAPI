package ch.spacebase.openclassic.api.entity;

import ch.spacebase.openclassic.api.Position;
import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.player.Player;

/**
 * Represents an entity made of blocks.
 */
public abstract class Entity {

	private static int nextId = 0;
	
	private int entityId;
	private Position pos;
	
	public Entity() {
		this.entityId = assignId(this);
	}
	
	/**
	 * Gets the entity's ID.
	 * @return The entity's ID.
	 */
	public int getEntityId() {
		return this.entityId;
	}

	/**
	 * Gets the position of the entity.
	 * @return The entity's position.
	 */
	public Position getPosition() {
		return this.pos;
	}
	
	/**
	 * Sets the entity's position.
	 * @param Position to set.
	 */
	public void setPosition(Position pos) {
		if(pos == null) return;
		
		if(!this.onBlockRemoval(BlockRemoveCause.POSITION_CHANGE, this.pos.getLevel().getBlockAt(this.pos)))
			return;
		
		if(!this.onBlockSet(pos.getLevel().getBlockAt(pos)))
			return;
		
		this.pos.getLevel().setBlockAt(this.pos, BlockType.AIR);
		pos.getLevel().setBlockAt(pos, this.getBlock());
		this.pos = pos;
	}
	
	/**
	 * Called when the entity's block is removed.
	 * @param Cause of the block's removal.
	 * @param Block that was removed.
	 * @return Whether to allow the removal.
	 */
	public boolean onBlockRemoval(BlockRemoveCause cause, Block block) {
		if(cause == BlockRemoveCause.PLAYER) {
			return false;
		}
		
		return true;
	}
	
	/**
	 * Called when a block is set in the entity's position.
	 * @param Block being set.
	 * @return Whether to allow the set.
	 */
	public boolean onBlockSet(Block block) {	
		return true;
	}
	
	/**
	 * Called when the entity's block is right clicked.
	 * @param Player that right clicked the block.
	 * @return Whether to continue as normal.
	 */
	public boolean onRightClick(Player player) {
		return true;
	}
	
	// TODO: Call onLeftClick
	/**
	 * Called when the entity's block is left clicked.
	 * @param Player that left clicked the block.
	 * @return Whether to continue as normal.
	 */
	public boolean onLeftClick(Player player) {
		return true;
	}
	
	/**
	 * Called when the server ticks.
	 */
	public abstract void tick();
	
	/**
	 * Gets the entity's BlockType.
	 * @return The entity's BlockType.
	 */
	public abstract BlockType getBlock();
	
	/**
	 * Kills the entity.
	 */
	public void die() {
		this.pos.getLevel().removeEntity(this);
	}
	
	/**
	 * Called when the entity dies.
	 */
	public abstract void onDeath();
	
	private static int assignId(Entity entity) {
		return nextId++;
	}
	
	/**
	 * Represents the cause of the entity's block being removed.
	 */
	public enum BlockRemoveCause {
		/** Removed by a player. */
		PLAYER,
		/** Removed because of a position change. */
		POSITION_CHANGE,
		/** Removed because of another unknown or generic reason. */
		OTHER;
	}
	
}
