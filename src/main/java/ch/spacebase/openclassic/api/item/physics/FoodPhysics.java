package ch.spacebase.openclassic.api.item.physics;

import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.inventory.ItemStack;
import ch.spacebase.openclassic.api.player.Player;

public class FoodPhysics extends ItemPhysics {
	
	private int health;
	
	public FoodPhysics(int health) {
		this.health = health;
	}
	
	@Override
	public boolean onRightClick(ItemStack item, Player player) {
		player.heal(this.health);
		item.setSize(item.getSize() - 1);
		if(item.getSize() <= 0) player.getInventory().setHeldItem(null);
		return true;
	}
	
	@Override
	public boolean onRightClick(ItemStack item, Player player, Block block) {
		return false;
	}

	@Override
	public void onLeftClick(ItemStack item, Player player, Block block) {
	}

}
