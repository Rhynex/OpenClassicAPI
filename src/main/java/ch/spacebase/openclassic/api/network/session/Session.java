package ch.spacebase.openclassic.api.network.session;

import java.net.SocketAddress;

import ch.spacebase.openclassic.api.network.msg.Message;
import ch.spacebase.openclassic.api.player.Player;

/**
 * Represents a network session.
 */
public interface Session {

	/**
	 * Gets the session's state.
	 * @return The session's state.
	 */
	public State getState();
	
	/**
	 * Gets the player this session belongs to.
	 * @return The session's player.
	 */
	public Player getPlayer();
	
	/**
	 * Sends a network message to the session's client.
	 * @param The message to send.
	 */
	public void send(Message message);
	
	/**
	 * Disconnects the session.
	 * @param The reason to disconnect the session.
	 */
	public void disconnect(String reason);
	
	/**
	 * Gets the session's SocketAddress.
	 * @return The session's SocketAddress.
	 */
	public SocketAddress getAddress();
	
	/**
	 * Represents the session's network state.
	 */
	public enum State {
		/** The client is being identified. */
		IDENTIFYING,
		/** The server is preparing the client. */
		PREPARING,
		/** The client is now in the game. */
		GAME;
	}
	
}
