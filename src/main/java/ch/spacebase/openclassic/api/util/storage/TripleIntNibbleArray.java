package ch.spacebase.openclassic.api.util.storage;

import java.util.Arrays;

public class TripleIntNibbleArray {

	private byte array[];
	private int size1;
	private int size3;

	public TripleIntNibbleArray(int size1, int size2, int size3) {
		this.array = new byte[size1 * size2 * size3];
		this.size1 = size1;
		this.size3 = size3;
	}

	public byte get(int index1, int index2, int index3) {
		return (byte) (this.array[this.toIndex(index1, index2, index3)] & 0xf);
	}
	
	public byte[] get() {
		return this.array;
	}

	public void set(int index1, int index2, int index3, int b) {
		this.array[this.toIndex(index1, index2, index3)] = (byte) (b & 0xf);
	}
	
	public void set(byte array[]) {
		if(array.length != this.array.length) {
			throw new IllegalArgumentException("Incorrect array size!");
		}
		
		this.array = array;
	}
	
	public void fill(int nibble) {
		Arrays.fill(this.array, (byte) (nibble & 0xf));
	}

	public int toIndex(int index1, int index2, int index3) {
		return (index1 * this.size1 + index2) * this.size3 + index3;
	}

}
