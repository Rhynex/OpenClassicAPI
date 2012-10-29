package ch.spacebase.openclassic.api.util.storage;

import java.util.Arrays;

public class TripleIntIntegerArray {

	private int array[];
	private int size1;
	private int size2;
	private int size3;

	public TripleIntIntegerArray(int size1, int size2, int size3) {
		this.array = new int[size1 * size2 * size3];
		this.size1 = size1;
		this.size2 = size2;
		this.size3 = size3;
	}

	public int get(int index1, int index2, int index3) {
		return this.array[this.toIndex(index1 & (this.size1 - 1), index2 & (this.size2 - 1), index3 & (this.size3 - 1))];
	}
	
	public int[] get() {
		return this.array;
	}

	public void set(int index1, int index2, int index3, int i) {
		this.array[this.toIndex(index1 & (this.size1 - 1), index2 & (this.size2 - 1), index3 & (this.size3 - 1))] = i;
	}
	
	public void set(int array[]) {
		if(array.length != this.array.length) {
			throw new IllegalArgumentException("Incorrect array size!");
		}
		
		this.array = array;
	}
	
	public void fill(int i) {
		Arrays.fill(this.array, i);
	}
	
	public int toIndex(int index1, int index2, int index3) {
		return (index1 * this.size1 + index2) * this.size3 + index3;
	}

}
