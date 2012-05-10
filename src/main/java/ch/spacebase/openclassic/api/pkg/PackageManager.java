package ch.spacebase.openclassic.api.pkg;

import ch.spacebase.openclassic.api.command.Sender;
import ch.spacebase.openclassic.api.config.Configuration;

public interface PackageManager {

	public Configuration getSourcesList();
	
	public Configuration getInstalled();
	
	public void install(String name);
	
	public void install(String name, Sender executor);
	
	public void remove(String name);
	
	public void remove(String name, Sender executor);
	
	public void addSource(String id, String url);
	
	public void addSource(String id, String url, Sender executor);
	
	public void removeSource(String id);
	
	public void removeSource(String id, Sender executor);
	
	public void updateSources();
	
	public void updateSources(Sender executor);
	
}
