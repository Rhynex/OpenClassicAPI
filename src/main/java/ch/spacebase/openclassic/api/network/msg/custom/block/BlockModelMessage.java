package ch.spacebase.openclassic.api.network.msg.custom.block;

import ch.spacebase.openclassic.api.block.model.Model;
import ch.spacebase.openclassic.api.network.msg.Message;

/**
 * Contains a block's model.
 */
public class BlockModelMessage extends Message {

	private byte block;
	private Model model;
	
	public BlockModelMessage(byte block, Model model) {
		this.block = block;
		this.model = model;
	}
	
	/**
	 * Gets the block the model belongs to.
	 * @return The block the model belongs to.
	 */
	public byte getBlock() {
		return this.block;
	}
	
	/**
	 * Gets the model contained in the message.
	 * @return The contained model.
	 */
	public Model getModel() {
		return this.model;
	}
	
	@Override
	public String toString() {
		return "BlockModelMessage{block=" + block + ",quads=" + model.getQuads().size() + "}";
	}
	
	@Override
	public byte getOpcode() {
		return 18;
	}

}
