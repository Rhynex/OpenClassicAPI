package com.github.steveice10.openclassic.api.permissions;

import java.util.ArrayList;
import java.util.List;

public class Group {

	private String name;
	private String inherits;
	private boolean def;
	private List<String> perms;
	private List<String> players = new ArrayList<String>();
	
	public Group(String name, String inherits, boolean def, List<String> perms, List<String> players) {
		this.name = name;
		this.inherits = inherits;
		this.def = def;
		this.perms = perms;
		this.players = players;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getInheritedGroup() {
		return this.inherits;
	}
	
	public void setInheritedGroup(String group) {
		this.inherits = group;
	}
	
	public boolean isDefault() {
		return this.def;
	}
	
	public void setDefault(boolean def) {
		this.def = def;
	}
	
	public List<String> getPermissions() {
		return new ArrayList<String>(this.perms);
	}
	
	public void addPermission(String permission) {
		this.perms.add(permission);
	}
	
	public void removePermission(String permission) {
		this.perms.remove(permission);
	}
	
	public List<String> getPlayers() {
		return new ArrayList<String>(this.players);
	}
	
	public void addPlayer(String name) {
		this.players.add(name);
	}
	
	public void removePlayer(String name) {
		this.players.remove(name);
	}
	
	public boolean hasPermission(String permission) {
		return this.perms.contains(permission.toLowerCase());
	}
	
}
