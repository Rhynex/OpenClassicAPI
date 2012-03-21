package com.github.steveice10.openclassic.api.player;

import com.github.steveice10.openclassic.api.Position;
import com.github.steveice10.openclassic.api.command.Sender;
import com.github.steveice10.openclassic.api.level.Level;
import com.github.steveice10.openclassic.api.network.session.Session;
import com.github.steveice10.openclassic.api.permissions.Group;

public interface Player extends Sender {

	public Session getSession();
	
	public byte getPlayerId();
	
	public Position getPosition();
	
	public String getName();
	
	public String getDisplayName();
	
	public void setDisplayName(String name);
	
	public byte getPlaceMode();
	
	public void setPlaceMode(int type);
	
	public void moveTo(Position pos);
	
	public void moveTo(double x, double y, double z);
	
	public void moveTo(double x, double y, double z, byte yaw, byte pitch);
	
	public void moveTo(Level level, double x, double y, double z);
	
	public void moveTo(Level level, double x, double y, double z, byte yaw, byte pitch);
	
	public Group getGroup();
	
	public void setGroup(Group group);
	
	public String getIp();
	
	public void kick(String reason);
	
}
