package ch.spacebase.openclassic.api.sound;

import java.net.URL;

public interface AudioManager {

	/**
	 * Registers a file to a sound identifier.
	 * @param sound Identifier to register to.
	 * @param file File to register.
	 */
	public void registerSound(String sound, URL file);
	
	/**
	 * Registers a file to a music identifier.
	 * @param music Identifier to register to.
	 * @param file File to register.
	 */
	public void registerMusic(String music, URL file);
	
	/**
	 * Plays the given sound.
	 * @param sound Sound to play.
	 * @param volume Volume to play at.
	 * @param pitch Pitch to play at. (0 for default)
	 * @return True if the sound was found in the registry.
	 */
	public boolean playSound(String sound, float volume, float pitch);
	
	/**
	 * Plays the given sound.
	 * @param sound Sound to play.
	 * @param x X to play at.
	 * @param y Y to play at.
	 * @param z Z to play at.
	 * @param volume Volume to play at.
	 * @param pitch Pitch to play at. (0 for default)
	 * @return True if the sound was found in the registry.
	 */
	public boolean playSound(String sound, float x, float y, float z, float volume, float pitch);
	
	/**
	 * Plays the given music.
	 * @param music Music to play.
	 * @return True if the music was found in the registry.
	 */
	public boolean playMusic(String music);
	
	/**
	 * Plays the given music.
	 * @param music Music to play.
	 * @param loop Whether to loop the music.
	 * @return True if the music was found in the registry.
	 */
	public boolean playMusic(String music, boolean loop);
	
	/**
	 * Checks if any music is playing.
	 * @return True if music is playing.
	 */
	public boolean isPlayingMusic();
	
	/**
	 * Stops any playing music.
	 */
	public void stopMusic();
	
	/**
	 * Checks if the given music is playing.
	 * @param music Music to check for.
	 * @return True if the music is playing.
	 */
	public boolean isPlaying(String music);
	
	/**
	 * Stops the given music.
	 * @param music Music to stop.
	 */
	public void stop(String music);
	
}
