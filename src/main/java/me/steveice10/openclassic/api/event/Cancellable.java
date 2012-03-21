package me.steveice10.openclassic.api.event;

public interface Cancellable {

	public boolean isCancelled();
	
	public void setCancelled(boolean cancel);
	
}
