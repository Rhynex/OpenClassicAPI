package ch.spacebase.openclassic.api.command;

import ch.spacebase.openclassic.api.OpenClassic;

public class Console implements Sender {

	@Override
	public void sendMessage(String message) {
		OpenClassic.getLogger().info(message);
	}

	@Override
	public String getName() {
		return "Server";
	}
	
	@Override
	public String getDisplayName() {
		return "Server";
	}
	
	@Override
	public boolean hasPermission(String command) {
		return true;
	}
	
	@Override
	public String getDelimiter() {
		return "";
	}
	
}
