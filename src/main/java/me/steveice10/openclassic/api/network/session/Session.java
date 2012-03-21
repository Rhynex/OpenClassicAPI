package me.steveice10.openclassic.api.network.session;

import java.net.SocketAddress;

import me.steveice10.openclassic.api.network.msg.Message;
import me.steveice10.openclassic.api.player.Player;

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
