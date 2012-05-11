package ch.spacebase.openclassic.api;

import java.util.Hashtable;
import java.util.List;
import java.util.logging.Logger;

import ch.spacebase.openclassic.api.command.Command;
import ch.spacebase.openclassic.api.command.CommandExecutor;
import ch.spacebase.openclassic.api.command.Sender;
import ch.spacebase.openclassic.api.config.Configuration;
import ch.spacebase.openclassic.api.event.EventManager;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.LevelInfo;
import ch.spacebase.openclassic.api.level.generator.Generator;
import ch.spacebase.openclassic.api.network.msg.Message;
import ch.spacebase.openclassic.api.permissions.PermissionManager;
import ch.spacebase.openclassic.api.pkg.PackageManager;
import ch.spacebase.openclassic.api.player.Player;
import ch.spacebase.openclassic.api.plugin.PluginManager;
import ch.spacebase.openclassic.api.scheduler.Scheduler;


public interface Server {

	// TODO: More docs
	
	/**
	 * Gets the server's package manager.
	 * @return The server's package manager.
	 */
	public PackageManager getPackageManager();
	
	public Scheduler getScheduler();
	
	public void broadcastMessage(String message);
	
	public List<Player> getPlayers();
	
	public Player getPlayer(String name);
	
	public List<Player> matchPlayer(String name);
	
	public PluginManager getPluginManager();
	
	public EventManager getEventManager();
	
	public void registerCommand(String alias, Command command);
	
	public void registerCommand(String aliases[], Command command);
	
	public void registerExecutor(CommandExecutor executor);
	
	public void processCommand(Sender sender, String command);
	
	public Hashtable<String, Command> getCommands();
	
	public String getMotd();
	
	public void setMotd(String motd);
	
	public String getServerName();
	
	public void setServerName(String name);
	
	public int getMaxPlayers();
	
	public void setMaxPlayers(int max);
	
	public int getPort();
	
	public void setPort(int port);
	
	public boolean isPublic();
	
	public void setPublic(boolean serverPublic);
	
	public boolean isOnlineMode();
	
	public void setOnlineMode(boolean online);
	
	public boolean doesUseWhitelist();
	
	public void setUseWhitelist(boolean whitelist);
	
	public boolean isWhitelisted(String player);
	
	public boolean isBanned(String player);
	
	public boolean isIpBanned(String address);
	
	public void banPlayer(String player);
	
	public void banPlayer(String player, String reason);
	
	public void unbanPlayer(String player);
	
	public void banIp(String address);
	
	public void banIp(String address, String reason);
	
	public void unbanIp(String address);
	
	public void whitelist(String player);
	
	public void unwhitelist(String player);
	
	public String getBanReason(String player);
	
	public String getIpBanReason(String address);
	
	public List<String> getBannedPlayers();
	
	public List<String> getBannedIps();
	
	public PermissionManager getPermissionManager();
	
	public void shutdown();
	
	public Level createLevel(LevelInfo info, Generator generator);
	
	public Level loadLevel(String name);
	
	public Level loadLevel(String name, boolean create);
	
	public void unloadLevel(String name);
	
	public Level getDefaultLevel();
	
	public void saveLevels();
	
	public void saveLevel(Level level);
	
	public void saveLevel(String name);
	
	public Level getLevel(String name);
	
	public List<Level> getLevels();
	
	public void sendToAll(Message msg);
	
	public void sendToAllExcept(Player player, Message msg);
	
	public boolean isRunning();
	
	public Configuration getConfig();
	
	public Logger getLogger();
	
	public boolean isInDebugMode();
	
	public void registerGenerator(String name, Generator generator);
	
	public Generator getGenerator(String name);
	
	public boolean isGenerator(String name);
	
}
