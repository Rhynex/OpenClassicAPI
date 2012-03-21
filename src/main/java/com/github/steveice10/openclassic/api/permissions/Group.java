package com.github.steveice10.openclassic.api.permissions;

import java.util.ArrayList;
import java.util.List;

public class Group {

	private String name;
	private String inherits;
	private List<String> perms;
	private List<String> players = new ArrayList<String>();
	
	public Group(String name, String inherits, List<String> perms, List<String> players) {
		this.name = name;
		this.inherits = inherits;
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
	
	public List<String> getPermissions() {
		return this.perms;
	}
	
	public List<String> getPlayers() {
		return this.players;
	}
	
	public boolean hasPermission(String permission) {
		return this.perms.contains(permission.toLowerCase());
	}
	
}
