package ch.spacebase.openclassic.api.item.physics;

import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockFace;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.inventory.ItemStack;
import ch.spacebase.openclassic.api.player.Player;

public class ReedPhysics extends ItemPhysics {
	
	@Override
	public boolean onRightClick(ItemStack item, Player player, Block block) {
		BlockFace face = player.getSelectedFace();
		Block b = block.getRelative(face);
		BlockType type = b.getType();
		if((type == VanillaBlock.AIR || type.isLiquid()) && VanillaBlock.REEDS.getPhysics().canPlace(b)) {
			b.setType(VanillaBlock.REEDS);
			item.setSize(item.getSize() - 1);
			if(item.getSize() <= 0) player.getInventory().setHeldItem(null);
			VanillaBlock.REEDS.getPhysics().onPlace(b, face);
			return true;
		}
		
		return false;
	}

	@Override
	public void onLeftClick(ItemStack item, Player player, Block block) {
	}

}
