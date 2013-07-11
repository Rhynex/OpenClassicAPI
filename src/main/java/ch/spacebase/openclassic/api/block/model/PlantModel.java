package ch.spacebase.openclassic.api.block.model;

import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.asset.AssetSource;
import ch.spacebase.openclassic.api.asset.texture.Texture;
import ch.spacebase.openclassic.api.util.Constants;

/**
 * A model used in plant blocks.
 */
public class PlantModel extends Model {
	
	private int quadCount = 0;
	public PlantModel(Texture texture, int textureId) {
		this(texture, textureId, 0.25f, 0.75f, 0.6f);
	}
	
	public PlantModel(Texture texture, int textureId, float c1, float c2, float height) {
		this.setSelectionBox(c1, 0, c1, c2, height, c2);
		Quad face1 = new Quad(0, texture.getSubTexture(textureId, Constants.TERRAIN_SIZE, Constants.TERRAIN_SIZE));
		face1.addVertex(0, c2, 0, c2);
		face1.addVertex(1, c2, 1, c2);
		face1.addVertex(2, c1, 1, c1);
		face1.addVertex(3, c1, 0, c1);
		this.addQuad(face1);
		
		Quad face2 = new Quad(1, texture.getSubTexture(textureId, Constants.TERRAIN_SIZE, Constants.TERRAIN_SIZE));
		face2.addVertex(0, c2, 0, c1);
		face2.addVertex(1, c2, 1, c1);
		face2.addVertex(2, c1, 1, c2);
		face2.addVertex(3, c1, 0, c2);
		this.addQuad(face2);
	}
	
	public PlantModel(String texture, AssetSource source) {
		this(OpenClassic.getGame().getAssetManager().load(texture, source, Texture.class), 0);
	}
	
	public PlantModel(String texture, AssetSource source, float c1, float c2, float height) {
		this(OpenClassic.getGame().getAssetManager().load(texture, source, Texture.class), 0, c1, c2, height);
	}
	
	@Override
	public void addQuad(Quad quad) {
		quad.id = this.quadCount;
		super.addQuad(quad);
		this.quadCount++;
		
		Quad q = new Quad(this.quadCount, quad.getTexture());
		q.addVertex(0, quad.getVertex(3));
		q.addVertex(1, quad.getVertex(2));
		q.addVertex(2, quad.getVertex(1));
		q.addVertex(3, quad.getVertex(0));
		super.addQuad(q);
		this.quadCount++;
	}
	
}
