package ch.spacebase.openclassic.api.util.set;

import java.util.HashMap;

/**
 * A HashMap that uses a key of 3 integers.
 */
public class TripleIntHashMap<T> extends HashMap<Integer, T> {

	private static final long serialVersionUID = 1L;

	public TripleIntHashMap() {
		super(100);
	}

	public TripleIntHashMap(int capacity) {
		super(capacity);
	}

	public T put(int key1, int key2, int key3, T value) {
		int key = key(key1, key2, key3);
		return super.put(key, value);
	}

	public boolean containsKey(int key1, int key2, int key3) {
		int key = key(key1, key2, key3);
		return super.containsKey(key);
	}

	public T remove(int key1, int key2, int key3) {
		int key = key(key1, key2, key3);
		return super.remove(key);
	}
	
	public T get(int key1, int key2, int key3) {
		int key = key(key1, key2, key3);
		return super.get(key);
	}

	protected static final int key(int x, int y, int z) {
		return (x & 0xFF) << 16 | (z & 0xFF) << 8 | y & 0xFF;
	}

	public static final int key1(int key) {
		return key >> 16 & 0xFF;
	}

	public static final int key2(int key) {
		return key & 0xFF;
	}

	public static final int key3(int key) {
		return key >> 8 & 0xFF;
	}
	
}
