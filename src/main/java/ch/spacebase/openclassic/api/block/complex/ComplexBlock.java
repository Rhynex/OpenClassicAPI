package ch.spacebase.openclassic.api.block.complex;

import ch.spacebase.openclassic.api.Position;
import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.opennbt.tag.CompoundTag;

public abstract class ComplexBlock {

	private Position pos;
	
	public ComplexBlock(Position pos) {
		this.pos = pos;
	}

	public Position getPosition() {
		return this.pos.clone();
	}

	public Block getBlock() {
		return this.pos.getLevel().getBlockAt(this.pos);
	}

	public BlockType getType() {
		return this.pos.getBlockType();
	}
	
	public abstract String getName();
	
	public abstract void read(CompoundTag tag);
	
	public abstract void write(CompoundTag tag);
	
	public abstract void tick();

}
