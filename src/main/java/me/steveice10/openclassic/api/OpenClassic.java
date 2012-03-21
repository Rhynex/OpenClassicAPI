package me.steveice10.openclassic.api;

import java.util.logging.Logger;

public class OpenClassic {

	private static Server server;
	
	public static Server getServer() {
		return server;
	}
	
	public static void setServer(Server server) {
		if(server != null) return;
		OpenClassic.server = server;
	}
	
	public static Logger getLogger() {
		return server.getLogger();
	}
	
	private OpenClassic() {
	}
	
}
