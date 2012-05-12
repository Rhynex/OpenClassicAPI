package ch.spacebase.openclassic.api.level;

import java.util.List;

import ch.spacebase.openclassic.api.Position;
import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.entity.Entity;
import ch.spacebase.openclassic.api.network.msg.Message;
import ch.spacebase.openclassic.api.player.Player;

/**
 * Represents a level.
 */
public interface Level {
	
	/**
	 * Adds a player to the level.
	 * @param Player to add.
	 */
	public void addPlayer(Player player);
	
	/**
	 * Removes a player from this level.
	 * @param Player to remove.
	 */
	public void removePlayer(String player);
	
	/**
	 * Gets whether physics are enabled on this world.
	 * @return True if physics are enabled.
	 */
	public boolean getPhysicsEnabled();
	
	/**
	 * Sets whether physics are enabled on this world.
	 * @param Whether physics are enabled.
	 */
	public void setPhysicsEnabled(boolean enabled);
	
	/**
	 * Gets all players in this world.
	 * @return All players in the world.
	 */
	public List<Player> getPlayers();
	
	/**
	 * Gets this level's name.
	 * @return The level's name.
	 */
	public String getName();
	
	/**
	 * Gets this level's author.
	 * @return This level's author.
	 */
	public String getAuthor();
	
	/**
	 * Gets this level's creation time.
	 * @return This level's creation time.
	 */
	public long getCreationTime();
	
	/**
	 * Gets the spawn of this level.
	 * @return The level's spawn.
	 */
	public Position getSpawn();
	
	/**
	 * Sets the spawn of this level.
	 * @param New spawn.
	 */
	public void setSpawn(Position position);

	/**
	 * Gets the width of the level. Width is the length along the X axis.
	 * @return The level's width.
	 */
	public short getWidth();
	
	/**
	 * Gets the height of the level. Height is the length along the Y axis.
	 * @return The level's height.
	 */
	public short getHeight();
	
	/**
	 * Gets the depth of this level. Depth is the length along the Z axis.
	 * @return The level's depth.
	 */
	public short getDepth();
	
	/**
	 * Gets the water level of the level.
	 * @return The level's water level.
	 */
	public short getWaterLevel();
	
	/**
	 * Gets an array of all the block IDs in the level.
	 * @return All the block IDs.
	 */
	public byte[] getBlocks();
	
	/**
	 * Gets the ID of the block at the given position.
	 * @param Position of the block.
	 * @return The block ID.
	 */
	public byte getBlockIdAt(Position pos);
	
	/**
	 * Gets the ID of the block at the given coordinates.
	 * @param X of the block.
	 * @param Y of the block.
	 * @param Z of the block.
	 * @return The block ID.
	 */
	public byte getBlockIdAt(int x, int y, int z);
	
	/**
	 * Gets the BlockType of the block at the given position.
	 * @param Position of the block.
	 * @return The BlockType.
	 */
	public BlockType getBlockTypeAt(Position pos);
	
	/**
	 * Gets the BlockType of the block at the given coordinates.
	 * @param X of the block.
	 * @param Y of the block.
	 * @param Z of the block.
	 * @return The BlockType.
	 */
	public BlockType getBlockTypeAt(int x, int y, int z);
	
	/**
	 * Gets the block at the given position.
	 * @param Position of the block.
	 * @return The block.
	 */
	public Block getBlockAt(Position pos);
	
	/**
	 * Gets the block at the given coordinates.
	 * @param X of the block.
	 * @param Y of the block.
	 * @param Z of the block.
	 * @return The block.
	 */
	public Block getBlockAt(int x, int y, int z);
	
	/**
	 * Sets the block ID at the given position to the given byte.
	 * @param Position of the block.
	 * @param Type ID to set.
	 */
	public void setBlockIdAt(Position pos, byte type);
	
	/**
	 * Sets the block ID at the given position to the given byte.
	 * @param Position of the block.
	 * @param Type ID to set.
	 * @param Whether to apply physics.
	 */
	public void setBlockIdAt(Position pos, byte type, boolean physics);
	
	/**
	 * Sets the block ID at the given coordinates to the given byte.
	 * @param X of the block.
	 * @param Y of the block.
	 * @param Z of the block.
	 * @param Type ID to set.
	 */
	public void setBlockIdAt(int x, int y, int z, byte type);
	
	/**
	 * Sets the block ID at the given coordinates to the given byte.
	 * @param X of the block.
	 * @param Y of the block.
	 * @param Z of the block.
	 * @param Type ID to set.
	 * @param Whether to apply physics.
	 */
	public void setBlockIdAt(int x, int y, int z, byte type, boolean physics);
	
	/**
	 * Sets the BlockType at the given position to the given BlockType.
	 * @param Position of the block.
	 * @param BlockType to set.
	 */
	public void setBlockAt(Position pos, BlockType type);
	
	/**
	 * Sets the BlockType at the given position to the given BlockType.
	 * @param Position of the block.
	 * @param BlockType to set.
	 * @param Whether to use physics.
	 */
	public void setBlockAt(Position pos, BlockType type, boolean physics);
	
	/**
	 * Sets the BlockType at the given coordinates to the given BlockType.
	 * @param X of the block.
	 * @param Y of the block.
	 * @param Z of the block.
	 * @param BlockType to set.
	 */
	public void setBlockAt(int x, int y, int z, BlockType type);
	
	/**
	 * Sets the BlockType at the given coordinates to the given BlockType.
	 * @param X of the block.
	 * @param Y of the block.
	 * @param Z of the block.
	 * @param BlockType to set.
	 * @param Whether to use physics.
	 */
	public void setBlockAt(int x, int y, int z, BlockType type, boolean physics);
	
	/**
	 * Returns true if the level is generating.
	 * @return True if the level is generating.
	 */
	public boolean isGenerating();
	
	/**
	 * Sets whether the level is generating.
	 * @param Whether the level is generating.
	 */
	public void setGenerating(boolean generating);
	
	/**
	 * Sends a network message to all players in the level.
	 * @param Message to send.
	 */
	public void sendToAll(Message message);
	
	/**
	 * Sends a network message to all players in the level except the given player.
	 * @param Player to skip.
	 * @param Message to send.
	 */
	public void sendToAllExcept(Player skip, Message message);
	
	/**
	 * Gets all the entities in the level.
	 * @return All the entities.
	 */
	public List<Entity> getEntities();
	
	/**
	 * Gets the entity with the given ID.
	 * @param ID to look for.
	 * @return The entity.
	 */
	public Entity getEntityFromId(int id);
	
	/**
	 * Gets the entity at the given position.
	 * @param Position of the entity.
	 * @return The entity.
	 */
	public Entity getEntity(Position pos);
	
	/**
	 * Spawns an entity.
	 * @param Entity to spawn.
	 * @param Position to spawn the entity in.
	 * @return The spawned entity.
	 */
	public Entity spawnEntity(Entity entity, Position pos);
	
	/**
	 * Removes the entity from the level.
	 * @param Entity to remove.
	 */
	public void removeEntity(Entity entity);
	
	/**
	 * Removes the entity with the given ID from the level.
	 * @param ID to remove.
	 */
	public void removeEntity(int id);
	
}
