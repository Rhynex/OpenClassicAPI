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
	private boolean preventsOwnRendering = false;
	private boolean opaque = true;
	private boolean selectable = true;
	private BlockPhysics phys = null;
	private boolean liquid = false;
	private int tickDelay = 0;
	private boolean placeIn = false;
	private boolean gas = false;
	private float brightness = 0;
	private float speedModifier = 1;
	private int fogRed = -1;
	private int fogGreen = -1;
	private int fogBlue = -1;
	private float fogDensity = -1;
	private int liquidId = -1;
	
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
	 * Returns true if the block prevents adjacent blocks of its type from rendering.
	 * @return True if the block prevents adjacent blocks of its type from rendering.
	 */
	public boolean getPreventsOwnRendering() {
		return this.getPreventsRendering() || this.getPreventsOwnRenderingRaw();
	}
	
	/**
	 * Returns true if the block prevents adjacent blocks of its type from rendering.
	 * @return True if the block prevents adjacent blocks of its type from rendering.
	 */
	public boolean getPreventsOwnRenderingRaw() {
		return this.preventsOwnRendering;
	}
	
	/**
	 * Sets whether the block is prevents adjacent blocks of its type from rendering.
	 * @param prevents Whether the block prevents adjacent blocks of its type from rendering.
	 * @return This block type.
	 */
	public BlockType setPreventsOwnRendering(boolean prevents) {
		this.preventsOwnRendering = prevents;
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
	
	/**
	 * Gets the block's permanent brightness level.
	 * @return The block's brightness, or 0 for default level brightness.
	 */
	public float getBrightness() {
		return this.brightness;
	}
	
	/**
	 * Sets the block's permanent brightness level.
	 * @param brightness The block's new brightness (0 = default level brightness).
	 * @return This block type.
	 */
	public BlockType setBrightness(float brightness) {
		this.brightness = brightness;
		return this;
	}
	
	/**
	 * Gets the block's speed modifier for when an entity is in the block, where 0 is no movement and 1 is normal speed.
	 * @return The block's speed modifier.
	 */
	public float getSpeedModifier() {
		return this.speedModifier;
	}
	
	/**
	 * Sets the block's speed modifier for when an entity is in the block, where 0 is no movement and 1 is normal speed.
	 * @param mod The block's speed modifier.
	 * @return This block type.
	 */
	public BlockType setSpeedModifier(float mod) {
		this.speedModifier = mod;
		return this;
	}
	
	/**
	 * Gets the block's fog color red value for when an entity is in the block.
	 * @return The block's fog color red value, or -1 for default.
	 */
	public int getFogRed() {
		return this.fogRed;
	}
	
	/**
	 * Sets the block's fog color red value for when an entity is in the block.
	 * @param red The block's fog color red value.
	 * @return This block type.
	 */
	public BlockType setFogRed(int red) {
		this.fogRed = red;
		return this;
	}
	
	/**
	 * Gets the block's fog color green value for when an entity is in the block.
	 * @return The block's fog color green value, or -1 for default.
	 */
	public int getFogGreen() {
		return this.fogGreen;
	}
	
	/**
	 * Sets the block's fog color green value for when an entity is in the block.
	 * @param green The block's fog color green value.
	 * @return This block type.
	 */
	public BlockType setFogGreen(int green) {
		this.fogGreen = green;
		return this;
	}
	
	/**
	 * Gets the block's fog color blue value for when an entity is in the block.
	 * @return The block's fog color blue value, or -1 for default.
	 */
	public int getFogBlue() {
		return this.fogBlue;
	}
	
	/**
	 * Sets the block's fog color blue value for when an entity is in the block.
	 * @param blue The block's fog color blue value.
	 * @return This block type.
	 */
	public BlockType setFogBlue(int blue) {
		this.fogBlue = blue;
		return this;
	}
	
	/**
	 * Sets the block's fog color for when an entity is in the block.
	 * @param green The block's fog color red value.
	 * @param green The block's fog color green value.
	 * @param blue The block's fog color blue value.
	 * @return This block type.
	 */
	public BlockType setFogColor(int red, int green, int blue) {
		this.fogRed = red;
		this.fogGreen = green;
		this.fogBlue = blue;
		return this;
	}
	
	/**
	 * Gets the block's fog density for when an entity is in the block.
	 * @return The block's fog density, or -1 for default.
	 */
	public float getFogDensity() {
		return this.fogDensity;
	}
	
	/**
	 * Sets the block's fog density for when an entity is in the block.
	 * @param density The block's fog density.
	 * @return This block type.
	 */
	public BlockType setFogDensity(float density) {
		this.fogDensity = density;
		return this;
	}
	
	/**
	 * Gets the block's liquid id for matching liquids of different block ids.
	 * @return The block's liquid id. (-1 for unique liquid)
	 */
	public int getLiquidId() {
		return this.liquidId;
	}
	
	/**
	 * Sets the block's liquid id for matching liquids of different block ids.
	 * @param id The block's liquid id. (-1 for unique liquid)
	 * @return This block type.
	 */
	public BlockType setLiquidId(int id) {
		this.liquidId = id;
		return this;
	}
	
}
