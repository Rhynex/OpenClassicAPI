package ch.spacebase.openclassic.api.network.msg.custom;

import ch.spacebase.openclassic.api.block.model.Model;
import ch.spacebase.openclassic.api.network.msg.Message;

public class BlockModelMessage extends Message {

	private byte block;
	private Model model;
	
	public BlockModelMessage(byte block, Model model) {
		this.block = block;
		this.model = model;
	}
	
	public byte getBlock() {
		return this.block;
	}
	
	public Model getModel() {
		return this.model;
	}
	
	@Override
	public String toString() {
		return "BlockModelMessage{block=" + block + ",quads=" + model.getQuads().size() + "}";
	}

	@Override
	public Object[] getParams() {
		return new Object[] { this.block, this.model.getClass().getSimpleName(), this.model.getCollisionBox().getX1(), this.model.getCollisionBox().getX2(), this.model.getCollisionBox().getY1(), this.model.getCollisionBox().getY2(), this.model.getCollisionBox().getZ1(), this.model.getCollisionBox().getZ2(), this.model.getSelectionBox().getX1(), this.model.getSelectionBox().getX2(), this.model.getSelectionBox().getY1(), this.model.getSelectionBox().getY2(), this.model.getSelectionBox().getZ1(), this.model.getSelectionBox().getZ2() };
	}
	
	@Override
	public byte getOpcode() {
		return 18;
	}

}
