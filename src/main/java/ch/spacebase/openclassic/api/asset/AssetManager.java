package ch.spacebase.openclassic.api.asset;

import java.io.File;

import ch.spacebase.openclassic.api.OpenClassic;

public class AssetManager {

	private final File dir;
	
	public AssetManager(File dir) {
		this.dir = dir;
	}
	
	public <T extends Asset> T load(String file, AssetSource source, Class<T> clazz) {
		return this.load(file, source, clazz, true);
	}
	
	public <T extends Asset> T load(String file, AssetSource source, Class<T> clazz, boolean usedir) {
		try {
			T asset = clazz.getDeclaredConstructor(String.class, AssetSource.class).newInstance(usedir ? source.getPath(this.dir, file) : file, source);
			asset.load();
			return asset;
		} catch (Exception e) {
			OpenClassic.getLogger().severe("Failed to load asset " + file);
			e.printStackTrace();
			return null;
		}
	}
	
	public File getDirectory() {
		return this.dir;
	}
	
}
