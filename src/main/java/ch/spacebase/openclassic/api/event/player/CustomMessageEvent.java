package ch.spacebase.openclassic.api.event.player;

import com.zachsthings.onevent.HandlerList;

import ch.spacebase.openclassic.api.network.msg.custom.CustomMessage;
import ch.spacebase.openclassic.api.player.Player;

/**
 * Called when a custom message is recieved.
 */
public class CustomMessageEvent extends PlayerEvent {

	private static final HandlerList handlers = new HandlerList();
	
	private CustomMessage message;
	
	public CustomMessageEvent(Player player, CustomMessage message) {
		super(player);
		this.message = message;
	}
	
	/**
	 * Gets the message involved in this event.
	 * @return The message involved in this event.
	 */
	public CustomMessage getMessage() {
		return this.message;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

}
