package ch.spacebase.openclassic.api.item.physics;

import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.inventory.ItemStack;
import ch.spacebase.openclassic.api.player.Player;

public class BoneMealPhysics extends ItemPhysics {
	
	@Override
	public boolean onRightClick(ItemStack item, Player player, Block block) {
		if(block.getType() == VanillaBlock.SAPLING) {
			block.setType(VanillaBlock.AIR, false);
			if (block.getLevel().growTree(block.getPosition().getBlockX(), block.getPosition().getBlockY(), block.getPosition().getBlockZ())) {
				item.setSize(item.getSize() - 1);
				if(item.getSize() <= 0) player.getInventory().setHeldItem(null);
				return true;
			} else {
				block.setType(VanillaBlock.SAPLING, false);
			}
		}
		
		return false;
	}

	@Override
	public void onLeftClick(ItemStack item, Player player, Block block) {
	}

}
