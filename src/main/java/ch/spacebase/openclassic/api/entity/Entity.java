package ch.spacebase.openclassic.api.entity;

import ch.spacebase.openclassic.api.Position;
import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.player.Player;

public abstract class Entity {

	private static int nextId = 0;
	
	private int entityId;
	private Position pos;
	
	public Entity() {
		this.entityId = assignId(this);
	}
	
	public int getEntityId() {
		return this.entityId;
	}
	
	public Level getLevel() {
		return this.pos.getLevel();
	}
	
	public Position getPosition() {
		return this.pos;
	}
	
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
	
	public boolean onBlockRemoval(BlockRemoveCause cause, Block block) {
		if(cause == BlockRemoveCause.PLAYER) {
			return false;
		}
		
		return true;
	}
	
	public boolean onBlockSet(Block block) {	
		return true;
	}
	
	public boolean onRightClick(Player player) {
		return true;
	}
	
	// TODO: Call onLeftClick
	public boolean onLeftClick(Player player) {
		return true;
	}
	
	public abstract void tick();
	
	public abstract BlockType getBlock();
	
	public void die() {
		this.pos.getLevel().removeEntity(this);
	}
	
	public abstract void onDeath();
	
	private static int assignId(Entity entity) {
		return nextId++;
	}
	
	public enum BlockRemoveCause {
		PLAYER,
		POSITION_CHANGE,
		OTHER;
	}
	
}
