package ch.spacebase.openclassic.api;

import java.util.logging.Logger;

public class OpenClassic {

	private static final Logger temp = Logger.getLogger("OpenClassic");
	private static Server server;
	
	public static Server getServer() {
		return server;
	}
	
	public static void setServer(Server server) {
		if(OpenClassic.server != null || server == null) return;
		OpenClassic.server = server;
	}
	
	public static Logger getLogger() {
		if(server == null) {
			return temp;
		}
		
		return server.getLogger();
	}
	
	private OpenClassic() {
	}
	
}
