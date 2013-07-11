package ch.spacebase.openclassic.api.item.physics;

import ch.spacebase.openclassic.api.Client;
import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockFace;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.block.StepSound;
import ch.spacebase.openclassic.api.block.VanillaBlock;
import ch.spacebase.openclassic.api.block.model.BoundingBox;
import ch.spacebase.openclassic.api.inventory.ItemStack;
import ch.spacebase.openclassic.api.network.msg.PlayerSetBlockMessage;
import ch.spacebase.openclassic.api.player.Player;

public class BlockItemPhysics extends ItemPhysics {

	private BlockType block;
	
	public BlockItemPhysics(BlockType block) {
		this.block = block;
	}
	
	@Override
	public boolean onRightClick(ItemStack item, Player player, Block block) {
		BlockFace face = player.getSelectedFace();
		Block b = block.getRelative(face);
		BlockType type = b.getType();
		BoundingBox collision = this.block.getModel().getCollisionBox(b.getPosition().getBlockX(), b.getPosition().getBlockY(), b.getPosition().getBlockZ());
		if(this.block != VanillaBlock.AIR && (type == VanillaBlock.AIR || type.isLiquid()) && !(this.block.getPhysics() != null && !this.block.getPhysics().canPlace(b))) {
			if(collision != null) {
				if(player.getBoundingBox().intersects(collision)) return false;
				for(Player p : block.getLevel().getPlayers()) {
					if(p.getBoundingBox().intersects(collision)) {
						return false;
					}
				}
			}
			
			b.setType(this.block);
			item.setSize(item.getSize() - 1);
			if(item.getSize() <= 0) player.getInventory().setHeldItem(null);
			if (this.block.getStepSound() != StepSound.NONE) {
				OpenClassic.getClient().getAudioManager().playSound(this.block.getStepSound().getSound(), b.getPosition().getBlockX(), b.getPosition().getBlockY(), b.getPosition().getBlockZ(), (this.block.getStepSound().getVolume() + 1) / 2f, this.block.getStepSound().getPitch() * 0.8f);
			}
			
			if(this.block.getPhysics() != null) this.block.getPhysics().onPlace(b, face);
			if(OpenClassic.getGame() instanceof Client && OpenClassic.getClient().isInMultiplayer()) player.getSession().send(new PlayerSetBlockMessage((short) b.getPosition().getBlockX(), (short) b.getPosition().getBlockY(), (short) b.getPosition().getBlockZ(), true, this.block.getId()));
			return true;
		}
		
		return false;
	}

	@Override
	public void onLeftClick(ItemStack item, Player player, Block block) {
	}

}
