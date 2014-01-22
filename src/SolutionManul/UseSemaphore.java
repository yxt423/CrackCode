package SolutionManul;

import java.util.concurrent.Semaphore;

public class UseSemaphore {
	private static final int NUM_RESOURCES = 100;
	private final Semaphore semaphore = new Semaphore(NUM_RESOURCES, true);
	
	public void useSemaphore() throws InterruptedException { 
		semaphore.acquire();
		// Do something that requires one of the resources 
		semaphore.release();
	} 
}