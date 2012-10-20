package ch.spacebase.openclassic.api.util.storage;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DoubleIntArray<T> {

	private T array[];
	private int size1;

	@SuppressWarnings("unchecked")
	public DoubleIntArray(int size1, int size2, Class<T> type) {
		this.array = (T[]) Array.newInstance(type, size1 * size2);
		this.size1 = size1;
	}

	public T get(int index1, int index2) {
		return this.array[this.toIndex(index1, index2)];
	}
	
	public T[] get() {
		return this.array;
	}

	public void set(int index1, int index2, T b) {
		this.array[this.toIndex(index1, index2)] = b;
	}
	
	public void set(T array[]) {
		if(array.length != this.array.length) {
			throw new IllegalArgumentException("Incorrect array size!");
		}
		
		this.array = array;
	}
	
	public void fill(T b) {
		Arrays.fill(this.array, b);
	}
	
	public int toIndex(int index1, int index2) {
		return (index1 * this.size1) + index2;
	}

}
