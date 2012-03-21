package me.steveice10.openclassic.api;

import java.util.Hashtable;
import java.util.List;
import java.util.logging.Logger;

import me.steveice10.openclassic.api.command.Command;
import me.steveice10.openclassic.api.command.CommandExecutor;
import me.steveice10.openclassic.api.command.Sender;
import me.steveice10.openclassic.api.config.Configuration;
import me.steveice10.openclassic.api.event.EventManager;
import me.steveice10.openclassic.api.level.Level;
import me.steveice10.openclassic.api.level.LevelInfo;
import me.steveice10.openclassic.api.level.generator.Generator;
import me.steveice10.openclassic.api.network.msg.Message;
import me.steveice10.openclassic.api.permissions.PermissionManager;
import me.steveice10.openclassic.api.player.Player;
import me.steveice10.openclassic.api.plugin.PluginManager;

public interface Server {

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
	
	public boolean doOpsIgnoreMaxPlayers();
	
	public void setOpsIgnoreMaxPlayers(boolean ignore);
	
	public PermissionManager getPermissionManager();
	
	public void stop();
	
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
	
	public boolean isStopping();
	
	public Configuration getConfig();
	
	public Logger getLogger();
	
	public boolean isInDebugMode();
	
	public void registerGenerator(String name, Generator generator);
	
	public Generator getGenerator(String name);
	
	public boolean isGenerator(String name);
	
}
