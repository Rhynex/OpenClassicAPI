package ch.spacebase.openclassic.api.pkg;

import ch.spacebase.openclassic.api.command.Sender;
import ch.spacebase.openclassic.api.config.Configuration;

/**
 * Manages the installed packages and sources on the server.
 */
public interface PackageManager {

	/**
	 * Gets the YAML configuration containing all the installed sources.
	 * @return A YAML configuration containing all of the installed sources.
	 */
	public Configuration getSourcesList();
	
	/**
	 * Gets the YAML configuration containing all the installed packages.
	 * @return A YAML configuration containing all of the installed packages.
	 */
	public Configuration getInstalled();
	
	/**
	 * Installs a package.
	 * @param Package name.
	 */
	public void install(String name);
	
	/**
	 * Installs a package.
	 * @param Package name.
	 * @param Sender executing the install.
	 */
	public void install(String name, Sender executor);
	
	/**
	 * Removes a package.
	 * @param Package name.
	 */
	public void remove(String name);
	
	/**
	 * Removes a package.
	 * @param Package name.
	 * @param Sender executing the removal.
	 */
	public void remove(String name, Sender executor);
	
	/**
	 * Updates a package.
	 * @param Package name.
	 */
	public void update(String name);
	
	/**
	 * Updates a package.
	 * @param Package name.
	 * @param Sender executing the update.
	 */
	public void update(String name, Sender executor);
	
	/**
	 * Adds a source.
	 * @param ID for the source.
	 * @param URL of the source.
	 */
	public void addSource(String id, String url);
	
	/**
	 * Adds a source.
	 * @param ID for the source.
	 * @param URL of the source.
	 * @param Sender executing the addition.
	 */
	public void addSource(String id, String url, Sender executor);
	
	/**
	 * Removes a source.
	 * @param ID of the source.
	 */
	public void removeSource(String id);
	
	/**
	 * Removes a source.
	 * @param ID of the source.
	 * @param Sender executing the removal.
	 */
	public void removeSource(String id, Sender executor);
	
	/**
	 * Updates the source cache.
	 */
	public void updateSources();
	
	/**
	 * Updates the source cache.
	 * @param Sender executing the update.
	 */
	public void updateSources(Sender executor);
	
}
