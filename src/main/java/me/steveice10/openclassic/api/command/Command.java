package me.steveice10.openclassic.api.command;

public abstract class Command {

	private String permission;
	private int minArgs;
	private int maxArgs;
	private Class<? extends Sender> senders[];
	
	public Command(String permission) {
		this(permission, null);
	}
	
	public Command(String permission, Class<? extends Sender> senders[]) {
		this(permission, 0, senders);
	}
	
	public Command(String permission, int minArgs) {
		this(permission, minArgs, null);
	}
	
	public Command(String permission, int minArgs, Class<? extends Sender> senders[]) {
		this(permission, 0, 64, senders);
	}
	
	public Command(String permission, int minArgs, int maxArgs) {
		this(permission, minArgs, maxArgs, null);
	}
	
	public Command(String permission, int minArgs, int maxArgs, Class<? extends Sender> senders[]) {
		this.permission = permission;
		this.minArgs = minArgs;
		this.maxArgs = maxArgs;
		this.senders = senders;
	}
	
	public int getMinArgs() {
		return this.minArgs;
	}
	
	public int getMaxArgs() {
		return this.maxArgs;
	}
	
	public String getPermission() {
		return this.permission;
	}
	
	public Class<? extends Sender>[] getSenders() {
		return this.senders;
	}
	
	public String getUsage() {
		return "";
	}
	
	public abstract void execute(Sender sender, String command, String args[]);
	
}
