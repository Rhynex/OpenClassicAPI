package ch.spacebase.openclassic.api.block.model;

/**
 * A model that is transparent and has all sides showing while looking inside it.
 * @author steven
 *
 */
public class TransparentModel extends CubeModel {

	private int quadCount = 0;
	
	public TransparentModel(Texture texture, int textureIds[]) {
		super(texture, textureIds);
	}
	
	public TransparentModel(Texture texture, int textureId) {
		super(texture, textureId);
	}
	
	public TransparentModel(String texture, int textureSize) {
		super(texture, textureSize);
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
