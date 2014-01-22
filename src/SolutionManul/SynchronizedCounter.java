package SolutionManul;

public class SynchronizedCounter {
	private int count = 0;
	
	public synchronized void increment(){
		count++;
	}
	
	public synchronized void decrement(){
		count--;
	}
	
	public synchronized int getCounter(){
		return count;
	}

}
