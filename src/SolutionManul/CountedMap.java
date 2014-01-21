package SolutionManul;

import java.util.HashMap;

public class CountedMap<K, V> extends HashMap<K, V> {
	private static int numGets = 0;
	private static int numPuts = 0;

	@Override
	public V put(K key, V value){
		numGets++;
		return super.put(key, value);
	}
	
	@Override
	public V get(Object key){  // "Object key", not "K key"
		numPuts++;
		return super.get(key);
	}
	
	public int getNumGets(){
		return numGets;
	}
	
	public int getNumPuts(){
		return numPuts;
	}

}
