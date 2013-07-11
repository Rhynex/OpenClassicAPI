package ch.spacebase.openclassic.api.item;

import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.asset.AssetSource;
import ch.spacebase.openclassic.api.asset.texture.SubTexture;
import ch.spacebase.openclassic.api.asset.texture.Texture;
import ch.spacebase.openclassic.api.item.physics.ItemPhysics;
import ch.spacebase.openclassic.api.render.RenderHelper;
import ch.spacebase.openclassic.api.util.Constants;

public class Item {

	public static final Texture ITEM_TEXTURE = OpenClassic.getGame().getAssetManager().load("/items.png", AssetSource.JAR, Texture.class);
	
	private short id;
	private byte data;
	private SubTexture texture;
	private int maxSize = 64;
	private int maxDamage = 0;
	private ItemPhysics physics;
	
	public Item(int id, int texture) {
		this(id, 0, texture);
	}
	
	public Item(int id, SubTexture texture) {
		this(id, 0, texture);
	}
	
	public Item(int id, int data, int texture) {
		this(id, data, ITEM_TEXTURE.getSubTexture(texture, Constants.TERRAIN_SIZE, Constants.TERRAIN_SIZE));
	}
	
	public Item(int id, int data, SubTexture texture) {
		this.id = (short) id;
		this.data = (byte) data;
		this.texture = texture;
	}
	
	/**
	 * Gets the item's id.
	 * @return The item's id.
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Gets the item's data.
	 * @return The item's data.
	 */
	public byte getData() {
		return this.data;
	}
	
	/**
	 * Gets the item's texture.
	 * @return The item's texture.
	 */
	public SubTexture getTexture() {
		return this.texture;
	}
	
	/**
	 * Gets the physics for this item.
	 * @return The physics for this item.
	 */
	public ItemPhysics getPhysics() {
		return this.physics;
	}
	
	/**
	 * Sets the physics for this item.
	 * @param physics The new physics for the item.
	 */
	public Item setPhysics(ItemPhysics physics) {
		this.physics = physics;
		return this;
	}
	
	/**
	 * Gets the maximum stack size for this item.
	 * @return The maximum stack size for this item.
	 */
	public int getMaxStackSize() {
		return this.maxSize;
	}
	
	/**
	 * Sets the maximum stack size for this item.
	 * @param max The item's new maximum stack size.
	 */
	public Item setMaxStackSize(int max) {
		this.maxSize = max;
		return this;
	}
	
	/**
	 * Gets the max damage for this item.
	 * @return The max damage for this item.
	 */
	public int getMaxDamage() {
		return this.maxDamage;
	}
	
	/**
	 * Sets the max damage for this item.
	 * @param dmg The item's new max damage.
	 */
	public Item setMaxDamage(int dmg) {
		this.maxDamage = dmg;
		return this;
	}
	
	/**
	 * Renders the item's inventory preview.
	 * @param x X to render at.
	 * @param y Y to render at.
	 */
	public void renderInventory(int x, int y) {
		RenderHelper.getHelper().drawSubTex(this.texture, x - 5, y - 16, 0, 2, 1);
	}
	
	/**
	 * Renders the item as the player's held item.
	 * @param brightness Brightness to render at.
	 */
	public void renderHeld(float brightness) {
		RenderHelper.getHelper().drawHeldItem(this, brightness);
	}
	
	/**
	 * Renders the item in the level.
	 * @param x X to render at.
	 * @param y Y to render at.
	 * @param z Z to render at.
	 * @param brightness Brightness to render with.
	 */
	public void renderLevel(float x, float y, float z, float brightness) {
		// TODO
	}
	
}
