package ch.spacebase.openclassic.api.item.physics;

import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.block.physics.HarvestPhysics;
import ch.spacebase.openclassic.api.inventory.ItemStack;
import ch.spacebase.openclassic.api.player.Player;

public class PickaxePhysics extends ItemPhysics {
	
	private float breakSpeed;
	
	public PickaxePhysics(float breakSpeed) {
		this.breakSpeed = breakSpeed;
	}
	
	@Override
	public boolean onRightClick(ItemStack item, Player player, Block block) {
		return false;
	}

	@Override
	public void onLeftClick(ItemStack item, Player player, Block block) {
	}
	
	@Override
	public float getBreakSpeed(BlockType block) {
		return block.getPhysics() != null && block.getPhysics() instanceof HarvestPhysics ? this.breakSpeed : 1;
	}

}
