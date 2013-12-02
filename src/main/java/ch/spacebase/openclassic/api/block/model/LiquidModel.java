package ch.spacebase.openclassic.api.block.model;

/**
 * A model used in liquids.
 */
public class LiquidModel extends CubeModel {
	
	public LiquidModel(Texture texture, int textureIds[], boolean top, int subWidth, int subHeight) {
		super(texture, textureIds, subWidth, subHeight);
		this.setUseCulling(false);
		this.setCollisionBox(null);
		this.setSelectionBox(null);
		if(top) {
			for(Quad quad : this.getQuads()) {
				for(int vert = 0; vert < quad.getVertices().size(); vert++) {
					Vertex v = quad.getVertices().get(vert);
					if(v.getY() == 1) {
						quad.setVertex(vert, new Vertex(v.getX(), 0.95f, v.getZ()));
					}
				}
			}
		}
	}

	public LiquidModel(Texture texture, int textureId, boolean top, int subWidth, int subHeight) {
		this(texture, new int[] { textureId, textureId, textureId, textureId, textureId, textureId }, top, subWidth, subHeight);
	}

}
