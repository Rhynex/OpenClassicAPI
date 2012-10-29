package ch.spacebase.openclassic.api.pkg;

import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.asset.AssetSource;
import ch.spacebase.openclassic.api.asset.text.YamlFile;
import ch.spacebase.openclassic.api.command.Sender;
import ch.spacebase.openclassic.api.pkg.task.PackageInstallTask;
import ch.spacebase.openclassic.api.pkg.task.PackageRemoveTask;
import ch.spacebase.openclassic.api.pkg.task.PackageUpdateTask;
import ch.spacebase.openclassic.api.pkg.task.SourceAddTask;
import ch.spacebase.openclassic.api.pkg.task.SourceRemoveTask;
import ch.spacebase.openclassic.api.pkg.task.SourceUpdateTask;

/**
 * Manages the installed packages and sources on the server.
 */
public class PackageManager {

	private final YamlFile sources;
	private final YamlFile installed;
	
	public PackageManager() {
		this.sources = OpenClassic.getGame().getAssetManager().load("sources.yml", AssetSource.FILE, YamlFile.class);
		this.installed = OpenClassic.getGame().getAssetManager().load("installed.yml", AssetSource.FILE, YamlFile.class);
	}
	
	/**
	 * Gets the YAML configuration containing all the installed sources.
	 * @return A YAML configuration containing all of the installed sources.
	 */
	public YamlFile getSourcesList() {
		return this.sources;
	}
	
	/**
	 * Gets the YAML configuration containing all the installed packages.
	 * @return A YAML configuration containing all of the installed packages.
	 */
	public YamlFile getInstalled() {
		return this.installed;
	}

	/**
	 * Installs a package.
	 * @param name Package name.
	 */
	public void install(String name) {
		this.install(name, null);
	}

	/**
	 * Installs a package.
	 * @param name Package name.
	 * @param executor Sender executing the install.
	 */
	public void install(String name, Sender executor) {
		OpenClassic.getGame().getScheduler().scheduleAsyncTask(this, new PackageInstallTask(name, executor));
	}

	/**
	 * Removes a package.
	 * @param name Package name.
	 */
	public void remove(String name) {
		this.remove(name, null);
	}

	/**
	 * Removes a package.
	 * @param name Package name.
	 * @param executor Sender executing the removal.
	 */
	public void remove(String name, Sender executor) {
		OpenClassic.getGame().getScheduler().scheduleAsyncTask(this, new PackageRemoveTask(name, executor));
	}
	
	/**
	 * Updates a package.
	 * @param name Package name.
	 */
	public void update(String name) {
		this.update(name, null);
	}

	/**
	 * Updates a package.
	 * @param name Package name.
	 * @param executor Sender executing the update.
	 */
	public void update(String name, Sender executor) {
		OpenClassic.getGame().getScheduler().scheduleAsyncTask(this, new PackageUpdateTask(name, executor));
	}

	/**
	 * Adds a source.
	 * @param id ID for the source.
	 * @param url URL of the source.
	 */
	public void addSource(String id, String url) {
		this.addSource(id, url, null);
	}

	/**
	 * Adds a source.
	 * @param id ID for the source.
	 * @param url URL of the source.
	 * @param executor Sender executing the addition.
	 */
	public void addSource(String id, String url, Sender executor) {
		OpenClassic.getGame().getScheduler().scheduleAsyncTask(this, new SourceAddTask(id, url, executor));
	}

	/**
	 * Removes a source.
	 * @param id ID of the source.
	 */
	public void removeSource(String id) {
		this.removeSource(id, null);
	}

	/**
	 * Removes a source.
	 * @param id ID of the source.
	 * @param sender Sender executing the removal.
	 */
	public void removeSource(String id, Sender executor) {
		OpenClassic.getGame().getScheduler().scheduleAsyncTask(this, new SourceRemoveTask(id, executor));
	}

	/**
	 * Updates the source cache.
	 */
	public void updateSources() {
		this.updateSources(null);
	}

	/**
	 * Updates the source cache.
	 * @param sender Sender executing the update.
	 */
	public void updateSources(Sender executor) {
		OpenClassic.getGame().getScheduler().scheduleAsyncTask(this, new SourceUpdateTask(executor));
	}
	
	@Override
	public String toString() {
		return "ClassicPackageManager";
	}
	
}
