package ch.spacebase.openclassic.api.block.model;

/**
 * A model used in plant blocks.
 */
public class PlantModel extends Model {
	
	private int quadCount = 0;
	
	public PlantModel(Texture texture, int textureId) {
		this.setSelectionBox(0.2F, 0, 0.2F, 0.8F, 0.6F, 0.8F);
		
		Quad face1 = new Quad(0, texture.getSubTexture(textureId));
		face1.addVertex(0, 0.85F, 0, 0.85F);
		face1.addVertex(1, 0.85F, 1, 0.85F);
		face1.addVertex(2, 0.15F, 1, 0.15F);
		face1.addVertex(3, 0.15F, 0, 0.15F);
		this.addQuad(face1);
		
		Quad face2 = new Quad(1, texture.getSubTexture(textureId));
		face2.addVertex(0, 0.85F, 0, 0.15F);
		face2.addVertex(1, 0.85F, 1, 0.15F);
		face2.addVertex(2, 0.15F, 1, 0.85F);
		face2.addVertex(3, 0.15F, 0, 0.85F);
		this.addQuad(face2);
	}
	
	public PlantModel(String texture, int textureSize) {
		this(new Texture(texture, false, textureSize, textureSize, textureSize), 0);
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
	
	@Override
	public Class<? extends Model> getNetworkClass() {
		return PlantModel.class;
	}
	
}
