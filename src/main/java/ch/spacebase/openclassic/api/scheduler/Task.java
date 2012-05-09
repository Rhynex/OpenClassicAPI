package ch.spacebase.openclassic.api.scheduler;

public interface Task {

	public int getTaskId();
	
	public Object getOwner();
	
	public boolean isSync();
	
}
