package ch.spacebase.openclassic.api.event.player;

import com.zachsthings.onevent.HandlerList;

import ch.spacebase.openclassic.api.Position;
import ch.spacebase.openclassic.api.player.Player;

/**
 * Called when a player teleports.
 */
public class PlayerTeleportEvent extends PlayerMoveEvent {
    
	private static final HandlerList handlers = new HandlerList();
	
    public PlayerTeleportEvent(Player player, Position from, Position to) {
    	super(player, from, to);
    }
    
    @Override
    public HandlerList getHandlers() {
    	return handlers;
    }
    
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
}
