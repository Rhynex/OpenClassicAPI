package ch.spacebase.openclassic.api.scheduler;

public interface Worker {

	public int getTaskId();
	
	public Object getOwner();
	
	public Thread getThread();
	
}
