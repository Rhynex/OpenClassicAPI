package com.github.steveice10.openclassic.api.command;

import com.github.steveice10.openclassic.api.OpenClassic;

public class ConsoleCommandSender implements Sender {

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
