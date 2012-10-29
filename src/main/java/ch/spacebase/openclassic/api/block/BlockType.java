package ch.spacebase.openclassic.api.block;

import ch.spacebase.openclassic.api.block.model.CubeModel;
import ch.spacebase.openclassic.api.block.model.Model;
import ch.spacebase.openclassic.api.block.model.Texture;
import ch.spacebase.openclassic.api.block.physics.BlockPhysics;

/**
 * Represents a custom block.
 */
public class BlockType {
	
	public static final Texture TERRAIN = new Texture("/level/terrain.png", true, 256, 256, 16);
	
	private byte id;
	private byte data;
	private Model model;
	private StepSound sound;
	
	private boolean opaque = true;
	private boolean selectable = true;
	private boolean liquid = false;
	private float brightness = 0;
	private int delay = 0;
	private BlockPhysics physics;
	
	public BlockType(int id, StepSound sound, int texture) {
		this(id, sound, new CubeModel(TERRAIN, texture));
	}
	
	public BlockType(int id, StepSound sound, Model model) {
		this(id, 0, sound, model);
	}
	
	public BlockType(int id, int data, StepSound sound, int texture) {
		this(id, data, sound, new CubeModel(TERRAIN, texture));
	}
	
	public BlockType(int id, int data, StepSound sound, Model model) {
		this.id = (byte) id;
		this.data = (byte) (data & 0xf);
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
	 * Gets the block's data.
	 * @return The block's data.
	 */
	public byte getData() {
		return this.data;
	}
	
	/**
	 * Gets the block's step sound.
	 * @return The block's step sound.
	 */
	public StepSound getStepSound() {
		return this.sound;
	}
	
	/**
	 * Gets the model of this block.
	 * @return The block's model.
	 */
	public Model getModel() {
		return this.model;
	}
	
	public BlockType setModel(Model model) {
		this.model = model;
		return this;
	}
	
	/**
	 * Returns true if the block is opaque.
	 * @return True if the block is opaque.
	 */
	public boolean isOpaque() {
		return this.opaque;
	}
	
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
	
	public BlockType setSelectable(boolean selectable) {
		this.selectable = selectable;
		return this;
	}
	
	/**
	 * Gets whether the block is a liquid.
	 * @return True if the block is a liquid.
	 */
	public boolean isLiquid() {
		return this.liquid;
	}
	
	public BlockType setLiquid(boolean liquid) {
		this.liquid = liquid;
		return this;
	}
	
	/**
	 * Gets the block's physics if applicable.
	 * @return The block's physics.
	 */
	public BlockPhysics getPhysics() {
		return this.physics;
	}
	
	/**
	 * Sets the block's physics.
	 * @param phys The physics to set.
	 */
	public BlockType setPhysics(BlockPhysics physics) {
		this.physics = physics;
		return this;
	}
	
	/**
	 * Gets the tick delay of this block.
	 * @return The block's tick delay.
	 */
	public int getTickDelay() {
		return this.delay;
	}
	
	/**
	 * Sets the tick delay of this block.
	 * @param tickDelay The block's new tick delay.
	 */
	public BlockType setTickDelay(int delay) {
		this.delay = delay;
		return this;
	}

	/**
	 * Returns true if the block is fully solid.
	 * @return True if the block is solid.
	 */
	public boolean isCube() {
		return this.model.isCube();
	}

	/**
	 * Gets the brightness that the block gives off.
	 * @return The brightness that the block gives off.
	 */
	public float getBrightness() {
		return this.brightness;
	}
	
	public BlockType setBrightness(float brightness) {
		this.brightness = brightness;
		return this;
	}
	
}
