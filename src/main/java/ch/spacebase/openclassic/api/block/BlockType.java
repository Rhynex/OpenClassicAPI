package ch.spacebase.openclassic.api.block;

import ch.spacebase.openclassic.api.block.model.CubeModel;
import ch.spacebase.openclassic.api.block.model.Model;
import ch.spacebase.openclassic.api.block.model.Texture;
import ch.spacebase.openclassic.api.block.physics.BlockPhysics;

/**
 * Represents a block type.
 */
public class BlockType {
	
	public static final Texture TERRAIN_TEXTURE = new Texture("/terrain.png", true, 256, 256, 16);
	
	private byte id;
	private Model model;
	private StepSound sound;
	private boolean preventsRendering = true;
	private boolean opaque = true;
	private boolean selectable = true;
	private BlockPhysics phys = null;
	private boolean liquid = false;
	private int tickDelay = 0;
	private boolean placeIn;
	private boolean gas;
	
	public BlockType(int id, StepSound sound, int texture) {
		this(id, sound, TERRAIN_TEXTURE, texture);
	}
	
	public BlockType(int id, StepSound sound, int[] textures) {
		this(id, sound, TERRAIN_TEXTURE, textures);
	}
	
	public BlockType(int id, StepSound sound, Texture tex, int texture) {
		this(id, sound, tex, new int[] { texture, texture, texture, texture, texture, texture });
	}
	
	public BlockType(int id, StepSound sound, Texture tex, int[] textures) {
		this(id, sound, new CubeModel(tex, textures));
	}
	
	public BlockType(int id, StepSound sound, Model model) {
		this.id = (byte) id;
		this.sound = sound;
		this.model = model;
	}
	
	/**
	 * Gets the block's id.
	 * @return The block's id.
	 */
	public byte getId() {
		return this.id;
	}
	
	/**
	 * Gets the model of this block.
	 * @return The block's model.
	 */
	public Model getModel() {
		return this.model;
	}
	
	/**
	 * Sets the block's model.
	 * @param model The block's new model.
	 * @return This block type.
	 */
	public BlockType setModel(Model model) {
		this.model = model;
		return this;
	}
	
	/**
	 * Gets the block's step sound.
	 * @return The block's step sound.
	 */
	public StepSound getStepSound() {
		return this.sound;
	}
	
	/**
	 * Sets the block's step sound.
	 * @param sound The block's new step sound.
	 * @return This block type.
	 */
	public BlockType setStepSound(StepSound sound) {
		this.sound = sound;
		return this;
	}
	
	/**
	 * Returns true if the block prevents adjacent blocks from rendering.
	 * @return True if the block prevents adjacent blocks from rendering.
	 */
	public boolean getPreventsRendering() {
		return this.preventsRendering;
	}
	
	/**
	 * Sets whether the block is prevents adjacent blocks from rendering.
	 * @param prevents Whether the block prevents adjacent blocks from rendering.
	 * @return This block type.
	 */
	public BlockType setPreventsRendering(boolean prevents) {
		this.preventsRendering = prevents;
		return this;
	}
	
	/**
	 * Returns true if the block is opaque.
	 * @return True if the block is opaque.
	 */
	public boolean isOpaque() {
		return this.opaque;
	}
	
	/**
	 * Sets whether the block is opaque.
	 * @param opaque Whether the block is opaque.
	 * @return This block type.
	 */
	public BlockType setOpaque(boolean opaque) {
		this.opaque = opaque;
		return this;
	}
	
	/**
	 * Returns true if the block is selectable in the block menu.
	 * @return True if the block is selectable.
	 */
	public boolean isSelectable() {
		return this.selectable;
	}
	
	/**
	 * Sets whether the block is selectable in the block menu.
	 * @param selectable Whether the block is selectable.
	 * @return This block type.
	 */
	public BlockType setSelectable(boolean selectable) {
		this.selectable = selectable;
		return this;
	}
	
	/**
	 * Gets the block's physics if applicable.
	 * @return The block's physics.
	 */
	public BlockPhysics getPhysics() {
		return this.phys;
	}
	
	/**
	 * Sets the block's physics.
	 * @param phys The physics to set.
	 * @return This block type.
	 */
	public BlockType setPhysics(BlockPhysics phys) {
		this.phys = phys;
		return this;
	}
	
	/**
	 * Gets whether the block is a liquid.
	 * @return True if the block is a liquid.
	 */
	public boolean isLiquid() {
		return this.liquid;
	}
	
	/**
	 * Sets whether the block is a liquid.
	 * @param liquid Whether the block is a liquid.
	 * @return This block type.
	 */
	public BlockType setLiquid(boolean liquid) {
		this.liquid = liquid;
		return this;
	}
	
	/**
	 * Gets the tick delay of this block.
	 * @return The block's tick delay.
	 */
	public int getTickDelay() {
		return this.tickDelay;
	}
	
	/**
	 * Sets the tick delay of this block.
	 * @param tickDelay The block's new tick delay.
	 * @return This block type.
	 */
	public BlockType setTickDelay(int tickDelay) {
		this.tickDelay = tickDelay;
		return this;
	}
	
	/**
	 * Gets whether a block can be placed in this block.
	 * @return Whether a block can be placed in this block.
	 */
	public boolean canPlaceIn() {
		return this.placeIn;
	}
	
	/**
	 * Sets whether a block can be placed in this block.
	 * @param placeIn Whether a block can be placed in this block.
	 * @return This block type.
	 */
	public BlockType setPlaceIn(boolean placeIn) {
		this.placeIn = placeIn;
		return this;
	}
	
	/**
	 * Gets whether a block is a gas, such as air.
	 * @return Whether this block is a gas.
	 */
	public boolean isGas() {
		return this.gas;
	}
	
	/**
	 * Sets whether a block is a gas, such as air.
	 * @param placeIn Whether this block is a gas.
	 * @return This block type.
	 */
	public BlockType setGas(boolean gas) {
		this.gas = gas;
		return this;
	}
	
}
