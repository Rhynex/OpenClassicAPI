package ch.spacebase.openclassic.api.network.session;

import java.net.SocketAddress;

import ch.spacebase.openclassic.api.network.msg.Message;
import ch.spacebase.openclassic.api.player.Player;


public interface Session {

	public State getState();
	
	public Player getPlayer();
	
	public void send(Message message);
	
	public void disconnect(String reason);
	
	public SocketAddress getAddress();
	
	public enum State {
		IDENTIFYING,
		PREPARING,
		GAME;
	}
	
}
