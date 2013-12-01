package ch.spacebase.openclassic.api.block.model;

/**
 * A model used in liquids.
 */
public class LiquidModel extends CubeModel {
	
	public LiquidModel(Texture texture, int textureIds[], boolean top) {
		super(texture, textureIds);
		this.setCollisionBox(null);
		this.setSelectionBox(null);
		if(top) {
			for(Quad quad : this.getQuads()) {
				for(int vert = 0; vert < quad.getVertices().size(); vert++) {
					Vertex v = quad.getVertices().get(vert);
					if(v.getY() == 1) {
						quad.addVertex(vert, new Vertex(v.getX(), 0.95f, v.getZ()));
					}
				}
			}
		}
	}

	public LiquidModel(Texture texture, int textureId, boolean top) {
		this(texture, new int[] { textureId, textureId, textureId, textureId, textureId, textureId }, top);
	}

}
