package ch.spacebase.openclassic.api.network.msg.custom.block;

import ch.spacebase.openclassic.api.block.model.Quad;
import ch.spacebase.openclassic.api.network.msg.Message;

/**
 * Contains a model's quad.
 */
public class QuadMessage extends Message {

	private byte block;
	private Quad quad;
	
	public QuadMessage(byte block, Quad quad) {
		this.block = block;
		this.quad = quad;
	}
	
	/**
	 * Gets the block the quad belongs to.
	 * @return The block the quad belongs to.
	 */
	public byte getBlock() {
		return this.block;
	}
	
	/**
	 * Gets the quad contained in this message.
	 * @return The contained quad.
	 */
	public Quad getQuad() {
		return this.quad;
	}
	
	@Override
	public String toString() {
		return "QuadMessage{block=" + block + "}";
	}
	
	@Override
	public byte getOpcode() {
		return 19;
	}

}
