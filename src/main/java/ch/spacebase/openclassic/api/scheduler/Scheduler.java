package ch.spacebase.openclassic.api.scheduler;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public interface Scheduler {

	public int scheduleDelayedTask(Object obj, Runnable task);
	
	public int scheduleDelayedTask(Object obj, Runnable task, long delay);
	
	public int scheduleRepeatingTask(Object obj, Runnable task, long delay, long period);
	
	public int scheduleAsyncDelayedTask(Object obj, Runnable task);
	
	public int scheduleAsyncDelayedTask(Object obj, Runnable task, long delay);
	
	public int scheduleAsyncRepeatingTask(Object obj, Runnable task, long delay, long period);
	
	public <T> Future<T> callSyncMethod(Object obj, Callable<T> task);
	
	public void cancelTask(int id);
	
	public void cancelTasks(Object obj);
	
	public void cancelAllTasks();
	
	public List<Worker> getActiveWorkers();
	
	public List<Task> getPendingTasks();
	
}
