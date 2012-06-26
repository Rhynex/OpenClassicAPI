package ch.spacebase.openclassic.api.network.msg.custom;

import ch.spacebase.openclassic.api.block.model.Quad;
import ch.spacebase.openclassic.api.network.msg.Message;

public class QuadMessage extends Message {

	private byte block;
	private Quad quad;
	
	public QuadMessage(byte block, Quad quad) {
		this.block = block;
		this.quad = quad;
	}
	
	public byte getBlock() {
		return this.block;
	}
	
	public Quad getQuad() {
		return this.quad;
	}
	
	@Override
	public String toString() {
		return "QuadMessage{block=" + block + "}";
	}

	@Override
	public Object[] getParams() {
		return new Object[] { this.block, this.quad.getId(), this.quad.getVertex(0).getX(), this.quad.getVertex(0).getY(), this.quad.getVertex(0).getZ(), this.quad.getVertex(1).getX(), this.quad.getVertex(1).getY(), this.quad.getVertex(1).getZ(), this.quad.getVertex(2).getX(), this.quad.getVertex(2).getY(), this.quad.getVertex(2).getZ(), this.quad.getVertex(3).getX(), this.quad.getVertex(3).getY(), this.quad.getVertex(3).getZ(), this.quad.getTexture().getParent().getTexture(), this.quad.getTexture().getParent().isInJar() ? (byte) 1 : (byte) 0, this.quad.getTexture().getParent().getWidth(), this.quad.getTexture().getParent().getHeight(), this.quad.getTexture().getParent().getSubTextureWidth(), this.quad.getTexture().getParent().getSubTextureHeight(), this.quad.getTexture().getId() };
	}
	
	@Override
	public byte getOpcode() {
		return 19;
	}

}
