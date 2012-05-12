package ch.spacebase.openclassic.api;

import java.util.Hashtable;
import java.util.List;
import java.util.logging.Logger;

import ch.spacebase.openclassic.api.command.Command;
import ch.spacebase.openclassic.api.command.CommandExecutor;
import ch.spacebase.openclassic.api.command.Sender;
import ch.spacebase.openclassic.api.config.Configuration;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.LevelInfo;
import ch.spacebase.openclassic.api.level.generator.Generator;
import ch.spacebase.openclassic.api.network.msg.Message;
import ch.spacebase.openclassic.api.permissions.PermissionManager;
import ch.spacebase.openclassic.api.pkg.PackageManager;
import ch.spacebase.openclassic.api.player.Player;
import ch.spacebase.openclassic.api.plugin.PluginManager;
import ch.spacebase.openclassic.api.scheduler.Scheduler;


/**
 * Represents the server.
 */
public interface Server {

	// TODO: More docs
	
	/**
	 * Gets the server's package manager.
	 * @return The server's package manager.
	 */
	public PackageManager getPackageManager();
	
	/**
	 * Gets the server's scheduler.
	 * @return The server's scheduler.
	 */
	public Scheduler getScheduler();
	
	/**
	 * Broadcasts a message via chat.
	 * @param The message to broadcast.
	 */
	public void broadcastMessage(String message);
	
	/**
	 * Gets a list of online players.
	 * @return Online players.
	 */
	public List<Player> getPlayers();
	
	/**
	 * Returns the player with the given name.
	 * @param The name of the player.
	 * @return The player.
	 */
	public Player getPlayer(String name);
	
	/**
	 * Returns a list of players that have a name with the given string in it.
	 * @param Name to look for.
	 * @return Players with the string in their name.
	 */
	public List<Player> matchPlayer(String name);
	
	/**
	 * Gets the server's plugin manager.
	 * @return The server's plugin manager.
	 */
	public PluginManager getPluginManager();
	
	/**
	 * Registers a command.
	 * @param Alias of the command.
	 * @param Command to register.
	 */
	public void registerCommand(String alias, Command command);
	
	/**
	 * Registers a command with multiple aliases.
	 * @param Aliases of the command.
	 * @param Command to register.
	 */
	public void registerCommand(String aliases[], Command command);
	
	/**
	 * Registers a command executor.
	 * @param Executor to register.
	 */
	public void registerExecutor(CommandExecutor executor);
	
	/**
	 * Processes a sent command.
	 * @param Sender that is calling the command.
	 * @param Command to send.
	 */
	public void processCommand(Sender sender, String command);
	
	/**
	 * Gets a list of all non-executor commands registered.
	 * @return All non-executor commands.
	 */
	public Hashtable<String, Command> getCommands();
	
	/**
	 * Gets the server's MOTD.
	 * @return The server's MOTD.
	 */
	public String getMotd();
	
	/**
	 * Sets the server's MOTD.
	 * @param The server's new MOTD.
	 */
	public void setMotd(String motd);
	
	/**
	 * Gets the server's name.
	 * @return The server's name.
	 */
	public String getServerName();
	
	/**
	 * Sets the server's name.
	 * @param The server's new name.
	 */
	public void setServerName(String name);
	
	/**
	 * Gets the maximum amount of players allowed to be on at once.
	 * @return The maximum amount of players.
	 */
	public int getMaxPlayers();
	
	/**
	 * Sets the maximum amount of players allowed to be on at once.
	 * @param The new maximum.
	 */
	public void setMaxPlayers(int max);
	
	/**
	 * Gets the server's network port.
	 * @return The server's network port.
	 */
	public int getPort();
	
	/**
	 * Sets the server's network port.
	 * @param The server's new network port.
	 */
	public void setPort(int port);
	
	/**
	 * Gets whether the server will display on the minecraft.net server list.
	 * @return Whether the server will display.
	 */
	public boolean isPublic();
	
	/**
	 * Sets whether the server will display on the minecraft.net server list.
	 * @return Whether the server will display.
	 */
	public void setPublic(boolean serverPublic);
	
	/**
	 * Returns true if the server is set to verify names on minecraft.net
	 * @return Whether the server verifies names.
	 */
	public boolean isOnlineMode();
	
	/**
	 * Sets whether the server verifies names on minecraft.net
	 * @param Whether the server verifies names.
	 */
	public void setOnlineMode(boolean online);
	
	/**
	 * Returns true if the server uses a whitelist.
	 * @return True if the server uses a whitelist.
	 */
	public boolean doesUseWhitelist();
	
	/**
	 * Sets whether the server uses a whitelist.
	 * @param Whether the server uses a whitelist.
	 */
	public void setUseWhitelist(boolean whitelist);
	
	/**
	 * Returns true if the given player is whitelisted.
	 * @param Player to check.
	 * @return Whether the player is whitelisted.
	 */
	public boolean isWhitelisted(String player);
	
	/**
	 * Returns true if the given player is banned.
	 * @param Player to check.
	 * @return Whether the player is banned.
	 */
	public boolean isBanned(String player);
	
	/**
	 * Returns true if the given IP address is banned.
	 * @param IP address to check.
	 * @return Whether the IP address is banned.
	 */
	public boolean isIpBanned(String address);
	
	/**
	 * Bans the given player.
	 * @param Player to ban.
	 */
	public void banPlayer(String player);
	
	/**
	 * Bans the given player using the given reason.
	 * @param Player to ban.
	 * @param Reason for the ban.
	 */
	public void banPlayer(String player, String reason);
	
	/**
	 * Unbans the given player.
	 * @param Player to unban.
	 */
	public void unbanPlayer(String player);
	
	/**
	 * Bans the given IP address.
	 * @param Address to ban.
	 */
	public void banIp(String address);
	
	/**
	 * Bans the given IP address with the given reason.
	 * @param Address to ban.
	 * @param Reason for the ban.
	 */
	public void banIp(String address, String reason);
	
	/**
	 * Unbans the given IP address.
	 * @param Address to unban.
	 */
	public void unbanIp(String address);
	
	/**
	 * Allows the given player to logging in to this server if whitelisting is enabled.
	 * @param Player to allow.
	 */
	public void whitelist(String player);
	
	/**
	 * Denies the given player from logging in to this server if whitelisting is enabled.
	 * @param Player to deny.
	 */
	public void unwhitelist(String player);
	
	/**
	 * Gets the reason for the given player's ban.
	 * @param Player to get the ban reason for.
	 * @return The player's ban reason.
	 */
	public String getBanReason(String player);
	
	/**
	 * Gets the reason for the given IP address's IP ban.
	 * @param IP address to get the ban reason for.
	 * @return The IP's ban reason.
	 */
	public String getIpBanReason(String address);

	/**
	 * Gets all the playerss banned on this server.
	 * @return All the banned players.
	 */
	public List<String> getBannedPlayers();
	
	/**
	 * Gets all the IPs banned on this server.
	 * @return All the banned IPs.
	 */
	public List<String> getBannedIps();
	
	/**
	 * Gets the server's permission manager.
	 * @return The server's permission manager.
	 */
	public PermissionManager getPermissionManager();
	
	/**
	 * Shuts down the server.
	 */
	public void shutdown();
	
	/**
	 * Creates a level with the given info.
	 * @param Info to use.
	 * @param Generator to generate with.
	 * @return The created level.
	 */
	public Level createLevel(LevelInfo info, Generator generator);
	
	/**
	 * Loads the level with the given name.
	 * @param Name of the level.
	 * @return The loaded level.
	 */
	public Level loadLevel(String name);
	
	/**
	 * Loads the level with the given name.
	 * @param Name of the level.
	 * @param Whether to create the level if it isn't found.
	 * @return The loaded level.
	 */
	public Level loadLevel(String name, boolean create);
	
	/**
	 * Unloads the level with the given name.
	 * @param Level to unload.
	 */
	public void unloadLevel(String name);
	
	/**
	 * Gets the default level.
	 * @return The default level.
	 */
	public Level getDefaultLevel();
	
	/**
	 * Saves all the loaded levels.
	 */
	public void saveLevels();
	
	/**
	 * Saves the given level.
	 * @param Level to save.
	 */
	public void saveLevel(Level level);
	
	/**
	 * Saves the level with the given name.
	 * @param Level to save.
	 */
	public void saveLevel(String name);
	
	/**
	 * Gets the level with the given name.
	 * @param Name of the level.
	 * @return The level.
	 */
	public Level getLevel(String name);
	
	/**
	 * Gets all the levels loaded onto the server.
	 * @return All the levels loaded.
	 */
	public List<Level> getLevels();
	
	/**
	 * Sends a network message to all players on the server.
	 * @param Message to send.
	 */
	public void sendToAll(Message msg);
	
	/**
	 * Sends a network message to all players on the server except the given player.
	 * @param Player to skip.
	 * @param Message to send.
	 */
	public void sendToAllExcept(Player player, Message msg);
	
	/**
	 * Returns true if the server is running.
	 * @return True if the server is running.
	 */
	public boolean isRunning();
	
	/**
	 * Gets the server's configuration.
	 * @return The servers' configuration.
	 */
	public Configuration getConfig();
	
	/**
	 * Gets the server's logger.
	 * @return The server's logger.
	 */
	public Logger getLogger();
	
	/**
	 * Returns true if the server was started with the "debug" flag.
	 * @return True if the server is in debug mode.
	 */
	public boolean isInDebugMode();
	
	/**
	 * Registers a generator to the given name.
	 * @param Name to register to.
	 * @param Generator to register.
	 */
	public void registerGenerator(String name, Generator generator);
	
	/**
	 * Gets the generator registered to the given name,
	 * @param Name to look for.
	 * @return The generator.
	 */
	public Generator getGenerator(String name);
	
	/**
	 * Returns true if a generator by this name exists.
	 * @param Name to look for.
	 * @return True if the generator exists.
	 */
	public boolean isGenerator(String name);
	
}
