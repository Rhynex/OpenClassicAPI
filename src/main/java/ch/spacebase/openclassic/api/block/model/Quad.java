package ch.spacebase.openclassic.api.block.model;

import java.util.Arrays;
import java.util.List;

import ch.spacebase.openclassic.api.render.RenderHelper;

public class Quad {

	protected int id;
	private Vertex vertices[] = new Vertex[4];
	private SubTexture texture;
	private Model parent;
	
	public Quad(int id, SubTexture texture) {
		this.texture = texture;
		this.id = id;
	}
	
	public Quad(int id, SubTexture texture, Vertex v1, Vertex v2, Vertex v3, Vertex v4) {
		this(id, texture);
		this.addVertex(0, v1);
		this.addVertex(1, v2);
		this.addVertex(2, v3);
		this.addVertex(3, v4);
	}
	
	public int getId() {
		return this.id;
	}
	
	public void addVertex(int id, Vertex vertex) {
		if(id > 3) throw new IllegalArgumentException("Quad can only have 4 vertices!");
		this.vertices[id] = vertex;
	}
	
	public void addVertex(int id, float x, float y, float z) {
		this.addVertex(id, new Vertex(x, y, z));
	}
	
	public void removeVertex(int id) {
		if(id > 3) throw new IllegalArgumentException("Quad can only have 4 vertices!");
		this.vertices[id] = null;
	}
	
	public Vertex getVertex(int id) {
		return this.vertices[id];
	}
	
	public List<Vertex> getVertices() {
		return Arrays.asList(this.vertices);
	}
	
	public SubTexture getTexture() {
		return this.texture;
	}
	
	public void render(int x, int y, int z, float brightness) {	
		RenderHelper.getHelper().drawQuad(this, x, y, z, brightness);
	}

	public Model getParent() {
		return this.parent;
	}
	
	protected void setParent(Model parent) {
		this.parent = parent;
	}
	
}
