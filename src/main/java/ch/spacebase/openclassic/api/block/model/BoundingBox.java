package ch.spacebase.openclassic.api.block.model;

public class BoundingBox {

	private float x1;
	private float y1;
	private float z1;
	private float x2;
	private float y2;
	private float z2;
	
	public BoundingBox(float x1, float y1, float z1, float x2, float y2, float z2) {
		this.x1 = x1;
		this.y1 = y1;
		this.z1 = z1;
		this.x2 = x2;
		this.y2 = y2;
		this.z2 = z2;
	}
	
	public float getX1() {
		return this.x1;
	}
	
	public float getY1() {
		return this.y1;
	}
	
	public float getZ1() {
		return this.z1;
	}
	
	public float getX2() {
		return this.x2;
	}
	
	public float getY2() {
		return this.y2;
	}
	
	public float getZ2() {
		return this.z2;
	}
	
}
