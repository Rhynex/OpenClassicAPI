package ch.spacebase.openclassic.api.player;

import java.net.SocketAddress;

import ch.spacebase.openclassic.api.Position;
import ch.spacebase.openclassic.api.command.Sender;
import ch.spacebase.openclassic.api.data.NBTData;
import ch.spacebase.openclassic.api.level.Level;
import ch.spacebase.openclassic.api.permissions.Group;

/**
 * Represents a player.
 */
public interface Player extends Sender {

	/**
	 * Gets the player's network session.
	 * @return The player's session.
	 */
	public Session getSession();
	
	/**
	 * Gets the player's ID.
	 * @return The player's ID.
	 */
	public byte getPlayerId();
	
	/**
	 * Gets the player's current position.
	 * @return The player's position.
	 */
	public Position getPosition();
	
	/**
	 * Gets the player's name.
	 * @return The player's name.
	 */
	public String getName();
	
	/**
	 * Gets the player's display name.
	 * @return The player's display name.
	 */
	public String getDisplayName();
	
	/**
	 * Sets the player's display name.
	 * @param Display name to set.
	 */
	public void setDisplayName(String name);
	
	/**
	 * Gets the current ID of the block placement mode the player has.
	 * @return The block ID of the current block mode.
	 */
	public byte getPlaceMode();
	
	/**
	 * Sets the block ID of the current block placement mode the player has.
	 * @param Block ID to set it to.
	 */
	public void setPlaceMode(int type);
	
	/**
	 * Moves the player to the given position.
	 * @param Position to move to.
	 */
	public void moveTo(Position pos);
	
	/**
	 * Moves the player to the given coordinates.
	 * @param X to move to.
	 * @param Y to move to.
	 * @param Z to move to.
	 */
	public void moveTo(double x, double y, double z);
	
	/**
	 * Moves the player to the given coordinates and rotation.
	 * @param X to move to.
	 * @param Y to move to.
	 * @param Z to move to.
	 * @param Yaw to move to.
	 * @param Pitch to move to.
	 */
	public void moveTo(double x, double y, double z, byte yaw, byte pitch);
	
	/**
	 * Moves the player to the given level and coordinates.
	 * @param Level to move to.
	 * @param X to move to.
	 * @param Y to move to.
	 * @param Z to move to.
	 */
	public void moveTo(Level level, double x, double y, double z);
	
	/**
	 * Moves the player to the given level, coordinates, and rotation.
	 * @param Level to move to.
	 * @param X to move to.
	 * @param Y to move to.
	 * @param Z to move to.
	 * @param Yaw to move to.
	 * @param Pitch to move to.
	 */
	public void moveTo(Level level, double x, double y, double z, byte yaw, byte pitch);
	
	/**
	 * Gets the player's group.
	 * @return The player's group.
	 */
	public Group getGroup();

	/**
	 * Sets the player's group.
	 * @param The group to set the player to.
	 */
	public void setGroup(Group group);
	
	/**
	 * Gets the player's IP.
	 * @return The players IP.
	 */
	public String getIp();
	
	/**
	 * Gets the player's SocketAddress.
	 * @return The player's SocketAddress.
	 */
	public SocketAddress getAddress();
	
	/**
	 * Kicks the player.
	 * @param The reason the player is being kicked.
	 */
	public void disconnect(String reason);
	
	/**
	 * Returns true if the player is using the OpenClassic client.
	 * @return True if the player has the custom client.
	 */
	public boolean hasCustomClient();
	
	/**
	 * Gets the version of the player's OpenClassic client. ("unknown" if not using the custom client)
	 * @return The player's client version.
	 */
	public String getClientVersion();
	
	/**
	 * Gets the player's NBTData.
	 * @return The player's NBTData.
	 */
	public NBTData getData();
	
}
