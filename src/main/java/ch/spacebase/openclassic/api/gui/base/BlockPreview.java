package ch.spacebase.openclassic.api.gui.base;

import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.gui.GuiComponent;

/**
 * A preview of a block, like in the inventory quickbar.
 */
public class BlockPreview extends GuiComponent {

	private BlockType type;
	private float scale;
	
	public BlockPreview(String name, int x, int y, BlockType type) {
		this(name, x, y, type, 0);
	}
	
	public BlockPreview(String name, int x, int y, BlockType type, float scale) {
		super(name, x, y, 0, 0);
		this.type = type;
		this.scale = scale;
	}
	
	/**
	 * Gets the block being previewed.
	 * @return The block being previewed.
	 */
	public BlockType getBlock() {
		return this.type;
	}
	
	/**
	 * Sets the block being previewed.
	 * @param block The new block being previewed.
	 */
	public void setBlock(BlockType block) {
		this.type = block;
	}
	
	/**
	 * Gets the scale of this block preview widget.
	 * @return The preview's scale.
	 */
	public float getScale() {
		return this.scale;
	}
	
	@Override
	public void render(int mouseX, int mouseY) {
		ComponentHelper.getHelper().renderBlockPreview(this);
	}

}
