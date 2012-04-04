package ch.spacebase.openclassic.api.level;

import java.util.List;

import ch.spacebase.openclassic.api.Position;
import ch.spacebase.openclassic.api.block.Block;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.entity.Entity;
import ch.spacebase.openclassic.api.network.msg.Message;
import ch.spacebase.openclassic.api.player.Player;


public interface Level {
	
	public void addPlayer(Player player);
	
	public void removePlayer(String player);
	
	public List<Player> getPlayers();
	
	public String getName();
	
	public String getAuthor();
	
	public long getCreationTime();
	
	public Position getSpawn();
	
	public void setSpawn(Position position);
	
	public short getWidth();
	
	public short getHeight();
	
	public short getDepth();
	
	public short getWaterLevel();
	
	public byte[] getBlocks();
	
	public byte getBlockIdAt(Position pos);
	
	public byte getBlockIdAt(int x, int y, int z);
	
	public BlockType getBlockTypeAt(Position pos);
	
	public BlockType getBlockTypeAt(int x, int y, int z);
	
	public Block getBlockAt(Position pos);
	
	public Block getBlockAt(int x, int y, int z);
	
	public void setBlockIdAt(Position pos, byte type);
	
	public void setBlockIdAt(Position pos, byte type, boolean physics);
	
	public void setBlockIdAt(int x, int y, int z, byte type);
	
	public void setBlockIdAt(int x, int y, int z, byte type, boolean physics);
	
	public void setBlockAt(Position pos, BlockType type);
	
	public void setBlockAt(Position pos, BlockType type, boolean physics);
	
	public void setBlockAt(int x, int y, int z, BlockType type);
	
	public void setBlockAt(int x, int y, int z, BlockType type, boolean physics);
	
	public boolean isGenerating();
	
	public void setGenerating(boolean generating);
	
	public void sendToAll(Message message);
	
	public void sendToAllExcept(Player skip, Message message);
	
	public List<Entity> getEntities();
	
	public Entity getEntityFromId(int id);
	
	public Entity getEntity(Position pos);
	
	public Entity spawnEntity(Entity entity, Position pos);
	
	public void removeEntity(Entity entity);
	
	public void removeEntity(int id);
	
}
