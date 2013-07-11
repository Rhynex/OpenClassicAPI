package ch.spacebase.openclassic.api.block;

import java.util.ArrayList;
import java.util.List;

import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.Position;
import ch.spacebase.openclassic.api.asset.AssetSource;
import ch.spacebase.openclassic.api.block.complex.ComplexBlock;
import ch.spacebase.openclassic.api.block.model.CubeModel;
import ch.spacebase.openclassic.api.block.model.Model;
import ch.spacebase.openclassic.api.asset.texture.Texture;
import ch.spacebase.openclassic.api.block.physics.BlockPhysics;
import ch.spacebase.openclassic.api.inventory.ItemStack;

/**
 * Represents a custom block.
 */
public class BlockType {
	
	public static final Texture TERRAIN = OpenClassic.getGame().getAssetManager().load("/level/terrain.png", AssetSource.JAR, Texture.class);
	
	private byte id;
	private byte data;
	private Model model;
	private StepSound sound;
	
	private boolean opaque = true;
	private boolean liquid = false;
	private float brightness = 0;
	private int delay = 0;
	private float hardness = 0;
	private BlockPhysics physics;
	private List<ItemStack> drops = new ArrayList<ItemStack>();
	private int dropChance = 0;
	private Class<? extends ComplexBlock> complex;
	
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
		this.drops.add(new ItemStack(this));
	}
	
	protected void fixDrops() {
		this.drops.clear();
		this.drops.add(new ItemStack(this));
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
	 * Gets the block's hardness.
	 * @return The block's hardness.
	 */
	public float getHardness() {
		return this.hardness;
	}
	
	/**
	 * Sets the block's hardness.
	 * @param hardness The block's new hardness.
	 */
	public BlockType setHardness(float hardness) {
		this.hardness = hardness;
		return this;
	}
	
	/**
	 * Gets the block's drop chance.
	 * @return The block's drop chance (0 for always).
	 */
	public int getDropChance() {
		return this.dropChance;
	}
	
	/**
	 * Sets the block's drop chance.
	 * @param chance The block's new drop chance (0 for always).
	 */
	public BlockType setDropChance(int chance) {
		this.dropChance = chance;
		return this;
	}
	
	/**
	 * Gets this block's drops.
	 * @return This block's drops.
	 */
	public List<ItemStack> getDrops() {
		return new ArrayList<ItemStack>(this.drops);
	}
	
	/**
	 * Returns true if the block is a complex block.
	 * @return True if the block is complex.
	 */
	public boolean isComplex() {
		return this.complex != null;
	}
	
	/**
	 * Gets the complex block class for this block.
	 * @return The block's complex block class.
	 */
	public Class<? extends ComplexBlock> getComplexBlock() {
		return this.complex;
	}
	
	/**
	 * Creates a new complex block instance for this block.
	 * @param pos Position of the complex block.
	 * @return The newly created complex block.
	 */
	public ComplexBlock createComplexBlock(Position pos) {
		try {
			return this.complex.getConstructor(Position.class).newInstance(pos);
		} catch (Exception e) {
			OpenClassic.getLogger().severe("Failed to create complex block instance: " + e);
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Sets the complex block class for this block.
	 * @param This block's new complex block class.
	 */
	public BlockType setComplexBlock(Class<? extends ComplexBlock> clazz) {
		this.complex = clazz;
		return this;
	}
	
	/**
	 * Sets this block's drops.
	 * @param drops The new drops for this block.
	 */
	public BlockType setDrops(ItemStack... drops) {
		this.drops.clear();
		for(ItemStack drop : drops) {
			this.drops.add(drop);
		}
		
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
