package ch.spacebase.openclassic.api.block.physics;

import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockFace;
import ch.spacebase.openclassic.api.block.Blocks;
import ch.spacebase.openclassic.api.block.physics.BlockPhysics;
import ch.spacebase.openclassic.api.inventory.ItemStack;
import ch.spacebase.openclassic.api.item.Item;
import ch.spacebase.openclassic.api.item.physics.ItemPhysics;

/**
 * Physics used for stone blocks.
 */
public class HarvestPhysics implements BlockPhysics {

	private byte id;
	private byte data;
	private Class<? extends ItemPhysics> phys;
	private float mindmg;
	private boolean alwaysHarvest;
	
	public HarvestPhysics(int id, Class<? extends ItemPhysics> phys) {
		this(id, phys, 2);
	}
	
	public HarvestPhysics(int id, int data, Class<? extends ItemPhysics> phys) {
		this(id, data, phys, 2);
	}
	
	public HarvestPhysics(int id, Class<? extends ItemPhysics> phys, float mindmg) {
		this(id, 0, phys, mindmg);
	}
	
	public HarvestPhysics(int id, int data, Class<? extends ItemPhysics> phys, float mindmg) {
		this.id = (byte) id;
		this.data = (byte) data;
		this.phys = phys;
		this.mindmg = mindmg;
	}
	
	public HarvestPhysics alwaysHarvest() {
		this.alwaysHarvest = true;
		return this;
	}
	
	public Class<? extends ItemPhysics> getTool() {
		return this.phys;
	}
	
	@Override
	public void update(Block block) {
	}

	@Override
	public void onPlace(Block block, BlockFace against) {
	}
	
	@Override
	public boolean canPlace(Block block) {
		return true;
	}

	@Override
	public void onBreak(Block block) {
	}

	@Override
	public void onNeighborChange(Block block, Block neighbor) {
	}

	@Override
	public boolean canHarvest(Item item) {
		if(this.alwaysHarvest) return true;
		return item != null && item.getPhysics() != null && this.phys.isAssignableFrom(item.getPhysics().getClass()) && item.getPhysics().getBreakSpeed(Blocks.get(this.id, this.data)) >= this.mindmg;
	}
	
	@Override
	public boolean onInteracted(ItemStack item, Block block) {
		return false;
	}

}
