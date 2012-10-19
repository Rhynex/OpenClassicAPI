package ch.spacebase.openclassic.api.util.storage;

import java.util.concurrent.ConcurrentHashMap;

public class DoubleIntHashMap<T> extends ConcurrentHashMap<Long, T> {

	private static final long serialVersionUID = 1L;

    public DoubleIntHashMap() {
        this(100);
    }

    public DoubleIntHashMap(int capacity) {
        super(capacity);
    }

	public T put(int key1, int key2, T value) {
		return super.put(LongHash.toLong(key1, key2), value);
	}

	public boolean containsKey(int key1, int key2) {
		return super.containsKey(LongHash.toLong(key1, key2));
	}

	public T remove(int key1, int key2) {
		return super.remove(LongHash.toLong(key1, key2));
	}
	
	public T get(int key1, int key2) {
		return super.get(LongHash.toLong(key1, key2));
	}
	
}
