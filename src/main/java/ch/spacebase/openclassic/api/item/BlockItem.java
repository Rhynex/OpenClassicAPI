package ch.spacebase.openclassic.api.item;

import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.item.physics.BlockItemPhysics;
import ch.spacebase.openclassic.api.render.RenderHelper;
import ch.spacebase.openclassic.api.util.Constants;

public class BlockItem extends Item {

	private BlockType block;
	
	public BlockItem(BlockType block) {
		super(block.getId(), block.getData(), block.getModel().getQuads().size() > 0 ? block.getModel().getQuad(0).getTexture() : BlockType.TERRAIN.getSubTexture(0, Constants.TERRAIN_SIZE, Constants.TERRAIN_SIZE));
		this.block = block;
		this.setPhysics(new BlockItemPhysics(this.block));
	}
	
	@Override
	public void renderInventory(int x, int y) {
		RenderHelper.getHelper().drawRotatedBlock(x + 1, y, this.block, 2);
	}
	
	@Override
	public void renderHeld(float brightness) {
		this.block.getModel().renderAll(this.block, -0.5f, -0.5f, -0.5f, brightness);
	}
	
	@Override
	public void renderLevel(float x, float y, float z, float brightness) {
		this.block.getModel().renderScaled(x, y, z, 0.25f, brightness);
	}

}
