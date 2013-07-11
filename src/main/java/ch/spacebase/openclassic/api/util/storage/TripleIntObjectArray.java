package ch.spacebase.openclassic.api.util.storage;

import java.util.Arrays;

public class TripleIntObjectArray<T> {

	private Object array[];
	private int size1;
	private int size2;
	private int size3;

	public TripleIntObjectArray(int size1, int size2, int size3) {
		this.array = new Object[size1 * size2 * size3];
		this.size1 = size1;
		this.size2 = size2;
		this.size3 = size3;
	}

	@SuppressWarnings("unchecked")
	public T get(int index1, int index2, int index3) {
		return (T) this.array[this.toIndex(index1 & (this.size1 - 1), index2 & (this.size2 - 1), index3 & (this.size3 - 1))];
	}
	
	public Object[] get() {
		return this.array;
	}

	public void set(int index1, int index2, int index3, T val) {
		this.array[this.toIndex(index1 & (this.size1 - 1), index2 & (this.size2 - 1), index3 & (this.size3 - 1))] = val;
	}
	
	public void set(T array[]) {
		if(array.length != this.array.length) {
			throw new IllegalArgumentException("Incorrect array size!");
		}
		
		this.array = array;
	}
	
	public void fill(int b) {
		Arrays.fill(this.array, (byte) b);
	}
	
	public int toIndex(int index1, int index2, int index3) {
		return (index1 * this.size1 + index2) * this.size3 + index3;
	}

}
