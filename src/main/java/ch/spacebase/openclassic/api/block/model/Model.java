package ch.spacebase.openclassic.api.block.model;

import java.util.ArrayList;
import java.util.List;

import ch.spacebase.openclassic.api.render.RenderHelper;

public class Model {

	private List<Quad> quads = new ArrayList<Quad>();
	private BoundingBox collision;
	private BoundingBox selection;
	
	public void addQuad(Quad quad) {
		this.quads.add(quad.getId(), quad);
		quad.setParent(this);
	}
	
	public void removeQuad(int id) {
		Quad quad = this.quads.remove(id);
		quad.setParent(null);
	}
	
	public Quad getQuad(int id) {
		return this.quads.get(id);
	}
	
	public List<Quad> getQuads() {
		return new ArrayList<Quad>(this.quads);
	}
	
	public BoundingBox getCollisionBox() {
		return this.collision;
	}
	
	public void setCollisionBox(BoundingBox box) {
		this.collision = box;
	}
	
	protected void setCollisionBox(float x1, float y1, float z1, float x2, float y2, float z2) {
		this.setCollisionBox(new BoundingBox(x1, y1, z1, x2, y2, z2));
	}
	
	public BoundingBox getSelectionBox() {
		return this.selection;
	}
	
	public void setSelectionBox(BoundingBox box) {
		this.selection = box;
	}
	
	protected void setSelectionBox(float x1, float y1, float z1, float x2, float y2, float z2) {
		this.setSelectionBox(new BoundingBox(x1, y1, z1, x2, y2, z2));
	}
	
	public boolean render(int x, int y, int z, float brightness) {
		for(Quad quad : this.quads) {
			quad.render(x, y, z, brightness);
		}
		
		return true;
	}

	public void renderFullbright(int x, int y, int z) {
		this.render(x, y, z, 1);
	}
	
	public void renderPreview() {
		RenderHelper.getHelper().renderPreview(this);
	}
	
	public String getType() {
		return "Model";
	}

	public void clearQuads() {
		this.quads.clear();
	}

	public boolean renderAll(int x, int y, int z, float brightness) {
		return this.render(x, y, z, brightness);
	}
	
}
