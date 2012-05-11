package ch.spacebase.openclassic.api;

import java.util.logging.Logger;

/**
 * The central class of OpenClassic.
 */
public class OpenClassic {

	private static final Logger temp = Logger.getLogger("OpenClassic");
	private static Server server;
	
	/**
	 * Gets the current server instance.
	 * @return The server instance.
	 */
	public static Server getServer() {
		return server;
	}
	
	/**
	 * Sets the current server instance.
	 * @param The server instance.
	 */
	public static void setServer(Server server) {
		if(OpenClassic.server != null || server == null) return;
		OpenClassic.server = server;
	}
	
	/**
	 * Gets the server's logger.
	 * @return The logger.
	 */
	public static Logger getLogger() {
		if(server == null) {
			return temp;
		}
		
		return server.getLogger();
	}
	
	private OpenClassic() {
	}
	
}
