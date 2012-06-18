package ch.spacebase.openclassic.api.gui;

import java.util.List;

/**
 * Represents the main game screen.
 */
public interface MainScreen extends Screen {

	/**
	 * Gets the last player clicked on the playerlist screen.
	 * @return The last clicked player.
	 */
	public String getClickedPlayer();
	
	/**
	 * Adds a chat message to the chat history.
	 * @param message Message to add.
	 */
	public void addChat(String message);
	
	/**
	 * Gets all displayed chat history.
	 * @return All displayed chat history.
	 */
	public List<String> getChat();

	/**
	 * Gets the chat message at the given index. (0 = bottom, 50 = max)
	 * @param index Index to look in
	 * @return Message at the given index.
	 */
	public String getChatMessage(int index);
	
	/**
	 * Gets the most recently displayed chat message.
	 * @return The most recent chat message.
	 */
	public String getLastChat();
	
}
