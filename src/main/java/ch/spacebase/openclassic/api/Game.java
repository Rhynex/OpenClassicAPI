package ch.spacebase.openclassic.api;

import java.io.File;
import java.util.Collection;

import ch.spacebase.openclassic.api.command.Command;
import ch.spacebase.openclassic.api.command.CommandExecutor;
import ch.spacebase.openclassic.api.command.Sender;
import ch.spacebase.openclassic.api.config.Configuration;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.level.LevelInfo;
import ch.spacebase.openclassic.api.level.generator.Generator;
import ch.spacebase.openclassic.api.pkg.PackageManager;
import ch.spacebase.openclassic.api.plugin.Plugin;
import ch.spacebase.openclassic.api.plugin.PluginManager;
import ch.spacebase.openclassic.api.scheduler.Scheduler;

public interface Game {

	/**
	 * Gets the game's package manager.
	 * @return The game's package manager.
	 */
	public PackageManager getPackageManager();
	
	/**
	 * Gets the game's scheduler.
	 * @return The game's scheduler.
	 */
	public Scheduler getScheduler();
	
	/**
	 * Gets the game's plugin manager.
	 * @return The game's plugin manager.
	 */
	public PluginManager getPluginManager();
	
	/**
	 * Registers a command.
	 * @param Plugin the command belongs to.
	 * @param Command to register.
	 */
	public void registerCommand(Plugin plugin, Command command);
	
	/**
	 * Registers a command executor.
	 * @param Plugin the executor belongs to.
	 * @param Executor to register.
	 */
	public void registerExecutor(Plugin plugin, CommandExecutor executor);
	
	/**
	 * Unregisters a plugins commands.
	 * @param Plugin the commands belongs to.
	 */
	public void unregisterCommands(Plugin plugin);
	
	/**
	 * Unregisters a plugins executors.
	 * @param Plugin the executors belongs to.
	 */
	public void unregisterExecutors(Plugin plugin);
	
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
	public Collection<Command> getCommands();
	
	/**
	 * Shuts down the game.
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
	 * Returns true if the game is running.
	 * @return True if the game is running.
	 */
	public boolean isRunning();
	
	/**
	 * Gets the game's configuration.
	 * @return The game's configuration.
	 */
	public Configuration getConfig();
	
	/**
	 * Returns true if the game was started with the "debug" flag.
	 * @return True if the game is in debug mode.
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

	/**
	 * Gets the working directory of the game.
	 * @return The game's working directory.
	 */
	public File getDirectory();
	
}
