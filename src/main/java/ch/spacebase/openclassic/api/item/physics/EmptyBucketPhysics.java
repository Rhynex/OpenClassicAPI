package ch.spacebase.openclassic.api.item.physics;

import ch.spacebase.openclassic.api.Position;
import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.inventory.ItemStack;
import ch.spacebase.openclassic.api.item.VanillaItem;
import ch.spacebase.openclassic.api.player.Player;

public class EmptyBucketPhysics extends ItemPhysics {
	
	@Override
	public boolean onRightClick(ItemStack item, Player player) {
		Position pos = player.getSelectedLiquid();
		if(pos != null) {
			BlockType type = pos.getBlockType();
			if(type == VanillaBlock.WATER || type == VanillaBlock.STATIONARY_WATER) {
				item.setItem(VanillaItem.WATER_BUCKET);
				item.setSize(1);
				pos.getLevel().setBlockAt(pos, VanillaBlock.AIR);
				return true;
			} else if(type == VanillaBlock.LAVA || type == VanillaBlock.STATIONARY_LAVA) {
				item.setItem(VanillaItem.LAVA_BUCKET);
				item.setSize(1);
				pos.getLevel().setBlockAt(pos, VanillaBlock.AIR);
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public boolean onRightClick(ItemStack item, Player player, Block block) {
		return false;
	}

	@Override
	public void onLeftClick(ItemStack item, Player player, Block block) {
	}

}
