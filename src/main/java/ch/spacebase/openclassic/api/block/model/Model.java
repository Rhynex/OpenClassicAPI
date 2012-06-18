package ch.spacebase.openclassic.api.block.model;

import java.util.ArrayList;
import java.util.List;

import ch.spacebase.openclassic.api.render.RenderHelper;

/**
 * Represents a block's model.
 */
public class Model {

	private List<Quad> quads = new ArrayList<Quad>();
	private BoundingBox collision;
	private BoundingBox selection;
	
	/**
	 * Adds a quad to this model.
	 * @param quad Quad to add.
	 */
	public void addQuad(Quad quad) {
		this.quads.add(quad.getId(), quad);
		quad.setParent(this);
	}
	
	/**
	 * Removes a quad from this model.
	 * @param id ID of the quad to remove.
	 */
	public void removeQuad(int id) {
		Quad quad = this.quads.remove(id);
		quad.setParent(null);
	}
	
	/**
	 * Gets the quad with the given ID.
	 * @param id ID of the quad.
	 * @return The quad with the given ID.
	 */
	public Quad getQuad(int id) {
		return this.quads.get(id);
	}
	
	/**
	 * Gets all quads that belong to this model.
	 * @return The quads belonging to this model.
	 */
	public List<Quad> getQuads() {
		return new ArrayList<Quad>(this.quads);
	}
	
	/**
	 * Gets this model's collision box.
	 * @return This model's collision box.
	 */
	public BoundingBox getCollisionBox() {
		return this.collision;
	}
	
	/**
	 * Sets this model's collision box.
	 * @param box The new collision box.
	 */
	public void setCollisionBox(BoundingBox box) {
		this.collision = box;
	}
	
	/**
	 * Sets this model's collision box.
	 * @param x1 X of the first point.
	 * @param y1 Y of the first point.
	 * @param z1 Z of the first point.
	 * @param x2 X of the second point.
	 * @param y2 Y of the second point.
	 * @param z2 Z of the second point.
	 */
	public void setCollisionBox(float x1, float y1, float z1, float x2, float y2, float z2) {
		this.setCollisionBox(new BoundingBox(x1, y1, z1, x2, y2, z2));
	}
	
	/**
	 * Gets this model's selection box.
	 * @return This model's selection box.
	 */
	public BoundingBox getSelectionBox() {
		return this.selection;
	}
	
	/**
	 * Sets this model's selection box.
	 * @param box The new selection box.
	 */
	public void setSelectionBox(BoundingBox box) {
		this.selection = box;
	}
	
	/**
	 * Sets this model's selection box.
	 * @param x1 X of the first point.
	 * @param y1 Y of the first point.
	 * @param z1 Z of the first point.
	 * @param x2 X of the second point.
	 * @param y2 Y of the second point.
	 * @param z2 Z of the second point.
	 */
	public void setSelectionBox(float x1, float y1, float z1, float x2, float y2, float z2) {
		this.setSelectionBox(new BoundingBox(x1, y1, z1, x2, y2, z2));
	}
	
	/**
	 * Renders the model.
	 * @param x X to render at.
	 * @param y Y to render at.
	 * @param z Z to render at.
	 * @param brightness Brightness to render at.
	 * @return Whether anything was rendered.
	 */
	public boolean render(int x, int y, int z, float brightness) {
		for(Quad quad : this.quads) {
			quad.render(x, y, z, brightness);
		}
		
		return true;
	}

	/**
	 * Renders the model with full brightness.
	 * @param x X to render at.
	 * @param y Y to render at.
	 * @param z Z to render at.
	 */
	public void renderFullbright(int x, int y, int z) {
		this.render(x, y, z, 1);
	}
	
	/**
	 * Renders a "preview" of the model.
	 */
	public void renderPreview() {
		RenderHelper.getHelper().renderPreview(this);
	}
	
	/**
	 * Gets the type of model this is for use in client to server communications.
	 * @return The type of model.
	 */
	public String getType() {
		return "Model";
	}

	/**
	 * Clears the quads in a model.
	 */
	public void clearQuads() {
		this.quads.clear();
	}

	/**
	 * Renders all sides, ignoring the model's rendering conditions.
	 * @param x X to render at.
	 * @param y Y to render at.
	 * @param z Z to render at.
	 * @param brightness Brightness to render at.
	 */
	public void renderAll(int x, int y, int z, float brightness) {
		this.render(x, y, z, brightness);
	}
	
}