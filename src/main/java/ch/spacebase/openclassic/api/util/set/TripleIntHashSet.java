package ch.spacebase.openclassic.api.util.set;

import java.util.HashSet;

/**
 * A HashSet that stores 3 integers.
 */
public class TripleIntHashSet extends HashSet<Integer> {

	private static final long serialVersionUID = 1L;

	public TripleIntHashSet() {
		super(100);
	}

	public TripleIntHashSet(int capacity) {
		super(capacity);
	}

	public boolean add(int key1, int key2, int key3) {
		int key = key(key1, key2, key3);
		return super.add(key);
	}

	public boolean contains(int key1, int key2, int key3) {
		int key = key(key1, key2, key3);
		return super.contains(key);
	}

	public boolean remove(int key1, int key2, int key3) {
		int key = key(key1, key2, key3);
		return super.remove(key);
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
