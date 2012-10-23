package ch.spacebase.openclassic.api.level;

import java.util.List;

import ch.spacebase.openclassic.api.Position;
import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.data.NBTData;
import ch.spacebase.openclassic.api.entity.BlockEntity;
import ch.spacebase.openclassic.api.level.column.Column;
import ch.spacebase.openclassic.api.level.generator.Generator;
import ch.spacebase.openclassic.api.level.generator.biome.Biome;
import ch.spacebase.openclassic.api.level.generator.biome.BiomeManager;
import ch.spacebase.openclassic.api.network.msg.Message;
import ch.spacebase.openclassic.api.player.Player;

/**
 * Represents a level.
 */
public interface Level {
	
	/**
	 * Adds a player to the level.
	 * @param player Player to add.
	 */
	public void addPlayer(Player player);
	
	/**
	 * Removes a player from this level.
	 * @param player Player to remove.
	 */
	public void removePlayer(String player);
	
	/**
	 * Removes a player from this level.
	 * @param id ID of the player to remove.
	 */
	public void removePlayer(byte id);
	
	/**
	 * Gets whether physics are enabled on this world.
	 * @return True if physics are enabled.
	 */
	public boolean getPhysicsEnabled();
	
	/**
	 * Sets whether physics are enabled on this world.
	 * @param enabled Whether physics are enabled.
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
	 * @param pos New spawn.
	 */
	public void setSpawn(Position pos);
	
	/**
	 * Gets the ID of the block at the given position.
	 * @param pos Position of the block.
	 * @return The block ID.
	 */
	public byte getBlockIdAt(Position pos);
	
	/**
	 * Gets the ID of the block at the given coordinates.
	 * @param x X of the block.
	 * @param y Y of the block.
	 * @param z Z of the block.
	 * @return The block ID.
	 */
	public byte getBlockIdAt(int x, int y, int z);
	
	/**
	 * Gets the BlockType of the block at the given position.
	 * @param pos Position of the block.
	 * @return The BlockType.
	 */
	public BlockType getBlockTypeAt(Position pos);
	
	/**
	 * Gets the BlockType of the block at the given coordinates.
	 * @param x X of the block.
	 * @param y Y of the block.
	 * @param z Z of the block.
	 * @return The BlockType.
	 */
	public BlockType getBlockTypeAt(int x, int y, int z);
	
	/**
	 * Gets the block at the given position.
	 * @param pos Position of the block.
	 * @return The block.
	 */
	public Block getBlockAt(Position pos);
	
	/**
	 * Gets the block at the given coordinates.
	 * @param x X of the block.
	 * @param y Y of the block.
	 * @param z Z of the block.
	 * @return The block.
	 */
	public Block getBlockAt(int x, int y, int z);
	
	/**
	 * Gets the highest block Y at the given X and Z.
	 * @param x X to check.
	 * @param z Z to check.
	 * @return The Y of the highest non-air block.
	 */
	public int getHighestBlockY(int x, int z);
	
	/**
	 * Gets the highest block Y below the given Y at the given X and Z.
	 * @param x X to check.
	 * @param z Z to check.
	 * @param max Maximum Y of the block.
	 * @return The Y of the highest non-air block below the given Y.
	 */
	public int getHighestBlockY(int x, int z, int max);
	
	/**
	 * Returns true if there are no higher blocks at the given X and Z than the one at the given Y.
	 * @param x X of the block.
	 * @param y Y of the block.
	 * @param z Z of the block.
	 * @return True if it is the highest.
	 */
	public boolean isHighest(int x, int y, int z);
	
	/**
	 * Returns true if the given block would be lit.
	 * @param x X of the block.
	 * @param y Y of the block.
	 * @param z Z of the block.
	 * @return Whether the block would be lit.
	 */
	public boolean isLit(int x, int y, int z);
	
	/**
	 * Gets the brightness level of the block.
	 * @param x X of the block.
	 * @param y Y of the block.
	 * @param z Z of the block.
	 * @return The brightness level of the block.
	 */
	public float getBrightness(int x, int y, int z);
	
	/**
	 * Sets the block ID at the given position to the given byte.
	 * @param pos Position of the block.
	 * @param type Type ID to set.
	 */
	public boolean setBlockIdAt(Position pos, byte type);
	
	/**
	 * Sets the block ID at the given position to the given byte.
	 * @param pos Position of the block.
	 * @param type Type ID to set.
	 * @param physics Whether to apply physics.
	 */
	public boolean setBlockIdAt(Position pos, byte type, boolean physics);
	
	/**
	 * Sets the block ID at the given coordinates to the given byte.
	 * @param x X of the block.
	 * @param y Y of the block.
	 * @param z Z of the block.
	 * @param type Type ID to set.
	 */
	public boolean setBlockIdAt(int x, int y, int z, byte type);
	
	/**
	 * Sets the block ID at the given coordinates to the given byte.
	 * @param x X of the block.
	 * @param y Y of the block.
	 * @param z Z of the block.
	 * @param type Type ID to set.
	 * @param physics Whether to apply physics.
	 */
	public boolean setBlockIdAt(int x, int y, int z, byte type, boolean physics);
	
	/**
	 * Sets the BlockType at the given position to the given BlockType.
	 * @param pos Position of the block.
	 * @param type BlockType to set.
	 */
	public boolean setBlockAt(Position pos, BlockType type);
	
	/**
	 * Sets the BlockType at the given position to the given BlockType.
	 * @param pos Position of the block.
	 * @param type BlockType to set.
	 * @param physics Whether to use physics.
	 */
	public boolean setBlockAt(Position pos, BlockType type, boolean physics);
	
	/**
	 * Sets the BlockType at the given coordinates to the given BlockType.
	 * @param x X of the block.
	 * @param y Y of the block.
	 * @param z Z of the block.
	 * @param type BlockType to set.
	 */
	public boolean setBlockAt(int x, int y, int z, BlockType type);
	
	/**
	 * Sets the BlockType at the given coordinates to the given BlockType.
	 * @param x X of the block.
	 * @param y Y of the block.
	 * @param z Z of the block.
	 * @param type BlockType to set.
	 * @param physics Whether to use physics.
	 */
	public boolean setBlockAt(int x, int y, int z, BlockType type, boolean physics);
	
	/**
	 * Sends a network message to all players in the level.
	 * @param message Message to send.
	 */
	public void sendToAll(Message message);
	
	/**
	 * Sends a network message to all players in the level except the given player.
	 * @param skip Player to skip.
	 * @param message Message to send.
	 */
	public void sendToAllExcept(Player skip, Message message);
	
	/**
	 * Gets all the entities in the level.
	 * @return All the entities.
	 */
	public List<BlockEntity> getBlockEntities();
	
	/**
	 * Gets the entity with the given ID.
	 * @param id ID to look for.
	 * @return The entity.
	 */
	public BlockEntity getBlockEntityFromId(int id);
	
	/**
	 * Gets the entity at the given position.
	 * @param pos Position of the entity.
	 * @return The entity.
	 */
	public BlockEntity getBlockEntity(Position pos);
	
	/**
	 * Spawns an entity.
	 * @param entity BlockEntity to spawn.
	 * @param pos Position to spawn the entity in.
	 * @return The spawned entity.
	 */
	public BlockEntity spawnBlockEntity(BlockEntity entity, Position pos);
	
	/**
	 * Removes the entity from the level.
	 * @param entity BlockEntity to remove.
	 */
	public void removeBlockEntity(BlockEntity entity);
	
	/**
	 * Removes the entity with the given ID from the level.
	 * @param id ID of the BlockEntity to remove.
	 */
	public void removeBlockEntity(int id);

	/**
	 * Schedules a block to be ticked next time the server ticks.
	 * @param pos Position to schedule.
	 * @param id ID of the block to tick.
	 */
	public void delayTick(Position pos, byte id);

	/**
	 * Attempts to grow a tree at the given coordinates.
	 * @param x X of the tree.
	 * @param y Y of the tree.
	 * @param z Z of the tree.
	 * @return Whether the attempt was successful.
	 */
	public boolean growTree(int x, int y, int z);
	
	/**
	 * Gets this level's NBTData.
	 * @return This level's NBTData.
	 */
	public NBTData getData();
	
	/**
	 * Gets the sky color of the level.
	 * @return The level's sky color.
	 */
	public int getSkyColor();
	
	/**
	 * Sets the sky color of the level.
	 * @param color Sky color to set.
	 */
	public void setSkyColor(int color);
	
	/**
	 * Gets the fog color of the level.
	 * @return The level's fog color.
	 */
	public int getFogColor();
	
	/**
	 * Sets the fog color of the level.
	 * @param color Fog color to set.
	 */
	public void setFogColor(int color);
	
	/**
	 * Gets the cloud color of the level.
	 * @return The level's cloud color.
	 */
	public int getCloudColor();
	
	/**
	 * Sets the cloud color of the level.
	 * @param color Cloud color to set.
	 */
	public void setCloudColor(int color);
	
	/**
	 * Gets the level's generation seed.
	 * @return The level's seed.
	 */
	public long getSeed();
	
	/**
	 * Sets the level's generation seed.
	 * @param The new seed.
	 * @param seed
	 */
	public void setSeed(long seed);

	/**
	 * Saves the level.
	 */
	public void save();
	
	/**
	 * Gets the column at the given coordinates.
	 * @param x The x of the column.
	 * @param z The z of the column.
	 * @return The column at the given coordinates.
	 */
	public Column getColumn(int x, int z);
	
	/**
	 * Gets the column at the given coordinates.
	 * @param x The x of the column.
	 * @param z The z of the column.
	 * @param load Whether or not to load the column if it isn't already loaded.
	 * @return The column at the given coordinates.
	 */
	public Column getColumn(int x, int z, boolean load);
	
	/**
	 * Gets the column at the given block coordinates.
	 * @param x The x of the column.
	 * @param z The z of the column.
	 * @return The column at the given block coordinates.
	 */
	public Column getColumnFromBlock(int x, int z);
	
	/**
	 * Returns true if the given column is loaded.
	 * @param x The x of the column.
	 * @param z The z of the column.
	 * @return Whether the column is loaded.
	 */
	public boolean isColumnLoaded(int x, int z);
	
	/**
	 * Gets all the loaded columns.
	 * @return All loaded columns.
	 */
	public List<? extends Column> getColumns();
	
	/**
	 * Gets the level's chunk generator.
	 * @return The level's generator.
	 */
	public Generator getGenerator();
	
	/**
	 * Gets the biome at the given coordinates.
	 * @param x X to get the biome at.
	 * @param y Y to get the biome at.
	 * @param z Z to get the biome at.
	 * @return The biome at the given coordinates.
	 */
	public Biome getBiome(int x, int y, int z);

	/**
	 * Gets the BiomeManager for the given column.
	 * @param x X of the column.
	 * @param z Z of the column.
	 * @return The column's biome manager.
	 */
	public BiomeManager getBiomeManager(int x, int z);

	/**
	 * Gets the BiomeManager for the given column.
	 * @param x X of the column.
	 * @param z Z of the column.
	 * @param load Whether to load the column if it is unloaded.
	 * @return The column's biome manager.
	 */
	public BiomeManager getBiomeManager(int x, int z, boolean load);
	
}
