package ch.spacebase.openclassic.api.command;

public interface Sender {

	public void sendMessage(String message);
	
	public String getName();
	
	public String getDisplayName();
	
	public boolean hasPermission(String command);
	
	public String getDelimiter();
	
}
