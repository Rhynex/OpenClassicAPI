package ch.spacebase.openclassic.api.network.msg.custom;

import ch.spacebase.openclassic.api.block.custom.CustomBlock;
import ch.spacebase.openclassic.api.network.msg.Message;

public class CustomBlockMessage extends Message {

	private CustomBlock block;
	
	public CustomBlockMessage(CustomBlock block) {
		this.block = block;
	}
	
	public CustomBlock getBlock() {
		return this.block;
	}
	
	@Override
	public String toString() {
		return "CustomBlockMessage{blockid=" + block.getId() + "}";
	}

	@Override
	public Object[] getParams() {
		return new Object[] { this.block.getId(), this.block.isOpaque() ? (byte) 1 : (byte) 0, this.block.isSelectable() ? (byte) 1 : (byte) 0, this.block.getStepSound().name(), this.block.isLiquid() ? (byte) 1 : (byte) 0, this.block.getTickDelay(), this.block.getFallback().getId(), this.block.isSolid() ? (byte) 1 : (byte) 0 };
	}
	
	@Override
	public byte getOpcode() {
		return 17;
	}

}