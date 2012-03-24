package com.github.steveice10.openclassic.api.permissions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.github.steveice10.openclassic.api.OpenClassic;
import com.github.steveice10.openclassic.api.config.Configuration;
import com.github.steveice10.openclassic.api.config.ConfigurationNode;
import com.github.steveice10.openclassic.api.network.msg.PlayerOpMessage;

public class PermissionManager {
	
	private Configuration perms = new Configuration(new File("permissions.yml"));
	private List<Group> groups = new ArrayList<Group>();
	
	public void load() {
		this.perms.load();
		this.loadGroups();
	}
	
	public void save() {
		for(Group group : this.groups) {
			this.perms.setValue(group.getName() + ".inherits", group.getInheritedGroup());
			this.perms.setValue(group.getName() + ".default", group.isDefault());
			this.perms.setValue(group.getName() + ".permissions", group.getPermissions());
			this.perms.setValue(group.getName() + ".players", group.getPlayers());
		}
		
		if(this.perms.getData().size() > this.groups.size()) {
			for(String name : this.perms.getData().keySet()) {
				boolean match = false;
				for(Group group : this.groups) {
					if(group.getName().equalsIgnoreCase(name)) match = true;
				}
				
				if(!match) {
					this.perms.remove(name);
				}
			}
		}
		
		this.perms.save();
	}
	
	public void reload() {
		this.save();
		this.perms.load();
		this.loadGroups();
	}
	
	public void loadGroups() {
		for(String key : this.perms.getKeys("")) {
			String name = key;
			
			try {
				String inherits = this.perms.getString(key + ".inherits");
				boolean def = this.perms.getBoolean(key + ".default");
				List<String> permissions = this.perms.getStringList(key + ".permissions");
				List<String> players = this.perms.getStringList(key + ".players");
				
				this.groups.add(new Group(name, inherits, def, permissions, players));
			} catch(Exception e) {
				OpenClassic.getLogger().severe("Exception while loading a permissions entry! It's probably invalid!");
				e.printStackTrace();
			}
		}
		
		if(groups.size() <= 0) {
			OpenClassic.getLogger().info("No groups found! Creating default group...");
			
			Group group = new Group("default", "", true, new ArrayList<String>(), new ArrayList<String>());
			this.addGroup(group);
			this.save();
		}
	}
	
	public void addGroup(Group group) {
		this.groups.add(group);
	}
	
	public void removeGroup(Group group) {
		this.groups.remove(group);
	}
	
	public Group getGroup(String name) {
		for(Group group : this.groups) {
			if(group.getName().equalsIgnoreCase(name)) return group;
		}
		
		return null;
	}
	
	public Group getDefaultGroup() {
		for(Group group : this.groups) {
			if(group.isDefault()) return group;
		}
		
		OpenClassic.getLogger().severe("No default group found! Expect errors!");
		return null;
	}
	
	public Group getPlayerGroup(String player) {
		for(Group group : this.groups) {
			if(group.getPlayers().contains(player.toLowerCase())) return group;
		}
		
		Group group = this.getDefaultGroup();
		group.addPlayer(player);
		return group;
	}
	
	public void setPlayerGroup(String player, Group group) {
		Group old = this.getPlayerGroup(player);
		
		if(old != null) old.removePlayer(player);
		group.addPlayer(player);
		
		if(OpenClassic.getServer().getPlayer(player) != null) {
			if(old != null) {
				if(!old.hasPermission("openclassic.ops.placebedrock") && group.hasPermission("openclassic.ops.placebedrock")) {
					OpenClassic.getServer().getPlayer(player).getSession().send(new PlayerOpMessage(PlayerOpMessage.OP));
				} else if(old.hasPermission("openclassic.ops.placebedrock") && !group.hasPermission("openclassic.ops.placebedrock")) {
					OpenClassic.getServer().getPlayer(player).getSession().send(new PlayerOpMessage(PlayerOpMessage.DEOP));
				}
			} else if(group.hasPermission("openclassic.ops.placebedrock")) {
				OpenClassic.getServer().getPlayer(player).getSession().send(new PlayerOpMessage(PlayerOpMessage.OP));
			}
		}
	}
	
	public boolean hasPermission(String player, String permission) {
		if(this.getPlayerGroup(player) != null) {
			return this.getPlayerGroup(player).hasPermission(permission);
		}
		
		return false;
	}
	
	public boolean hasPermission(Group group, String permission) {
		if(group != null) return group.hasPermission(permission);
		
		return false;
	}
	
}
