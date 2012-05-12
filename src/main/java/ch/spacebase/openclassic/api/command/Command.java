package ch.spacebase.openclassic.api.command;

/**
 * Represents a command class.
 */
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
	
	/**
	 * Gets the command's minimum arguments.
	 * @return The minimum arguments.
	 */
	public int getMinArgs() {
		return this.minArgs;
	}
	
	/**
	 * Gets the command's maximum arguments.
	 * @return The maximum arguments.
	 */
	public int getMaxArgs() {
		return this.maxArgs;
	}
	
	/**
	 * Gets the command's permission node.
	 * @return The permission node.
	 */
	public String getPermission() {
		return this.permission;
	}
	
	/**
	 * Gets the senders allowed to use this command.
	 * @return The senders allowed to use this command.
	 */
	public Class<? extends Sender>[] getSenders() {
		return this.senders;
	}
	
	/**
	 * Gets the command's usage.
	 * @return The command's usage.
	 */
	public String getUsage() {
		return "";
	}
	
	/**
	 * Executes the command.
	 * @param The sender using the command.
	 * @param The alias being executed.
	 * @param The arguments of the command.
	 */
	public abstract void execute(Sender sender, String command, String args[]);
	
}
