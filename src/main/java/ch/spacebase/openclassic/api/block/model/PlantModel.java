package ch.spacebase.openclassic.api.block.model;

/**
 * A model used in plant blocks.
 */
public class PlantModel extends Model {
	
	public PlantModel(Texture texture, int textureId) {
		this.setSelectionBox(0.2F, 0, 0.2F, 0.8F, 0.6F, 0.8F);
		
		Quad face1 = QuadFactory.getFactory().newQuad(0, texture.getSubTexture(textureId, 16, 16));
		face1.addVertex(0, 0.85F, 0, 0.85F);
		face1.addVertex(1, 0.85F, 1, 0.85F);
		face1.addVertex(2, 0.15F, 1, 0.15F);
		face1.addVertex(3, 0.15F, 0, 0.15F);
		this.addQuad(face1);
		this.addQuad(face1.reverseVertices(1));
		
		Quad face2 = QuadFactory.getFactory().newQuad(2, texture.getSubTexture(textureId, 16, 16));
		face2.addVertex(0, 0.85F, 0, 0.15F);
		face2.addVertex(1, 0.85F, 1, 0.15F);
		face2.addVertex(2, 0.15F, 1, 0.85F);
		face2.addVertex(3, 0.15F, 0, 0.85F);
		this.addQuad(face2);
		this.addQuad(face2.reverseVertices(3));
	}
	
}
