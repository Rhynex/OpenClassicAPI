package ch.spacebase.openclassic.api.item.physics;

import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockFace;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.block.Blocks;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.inventory.ItemStack;
import ch.spacebase.openclassic.api.item.VanillaItem;
import ch.spacebase.openclassic.api.player.Player;

public class FullBucketPhysics extends ItemPhysics {
	
	private int id;
	
	public FullBucketPhysics(int id) {
		this.id = id;
	}
	
	@Override
	public boolean onRightClick(ItemStack item, Player player, Block block) {
		BlockFace face = player.getSelectedFace();
		Block b = block.getRelative(face);
		BlockType type = b.getType();
		if(type == VanillaBlock.AIR || type.isLiquid()) {
			b.setType(Blocks.get(this.id));
			item.setItem(VanillaItem.BUCKET);
			if(Blocks.get(this.id).getPhysics() != null) Blocks.get(this.id).getPhysics().onPlace(b, face);
			return true;
		}
		
		return false;
	}

	@Override
	public void onLeftClick(ItemStack item, Player player, Block block) {
	}

}
