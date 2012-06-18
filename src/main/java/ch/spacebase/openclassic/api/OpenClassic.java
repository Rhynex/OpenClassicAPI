package ch.spacebase.openclassic.api;

import java.util.logging.Logger;

/**
 * The central class of OpenClassic.
 */
public class OpenClassic {

	private static final Logger logger = Logger.getLogger("OpenClassic");
	private static Game game;
	
	/**
	 * Gets the current game instance.
	 * @return The game instance.
	 */
	public static Game getGame() {
		return game;
	}
	
	/**
	 * Gets the current server instance.
	 * @return The server instance (null if the game instance isn't a server).
	 */
	public static Server getServer() {
		if(!(game instanceof Server)) return null;
		
		return (Server) game;
	}
	
	/**
	 * Gets the current client instance.
	 * @return The client instance (null if the game instance isn't a client).
	 */
	public static Client getClient() {
		if(!(game instanceof Client)) return null;
		
		return (Client) game;
	}
	
	/**
	 * Sets the current game instance.
	 * @param game The game instance.
	 */
	public static void setGame(Game game) {
		if(OpenClassic.game != null || game == null) return;
		OpenClassic.game = game;
	}
	
	/**
	 * Returns true if the game is running.
	 * @return True if the game is running.
	 */
	public static boolean isRunning() {
		if(game == null) return false;
		return game.isRunning();
	}
	
	/**
	 * Gets the server's logger.
	 * @return The logger.
	 */
	public static Logger getLogger() {
		return logger;
	}
	
	private OpenClassic() {
	}
	
}
