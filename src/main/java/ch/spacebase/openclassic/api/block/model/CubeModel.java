package ch.spacebase.openclassic.api.block.model;

/**
 * A model shaped like a cube.
 */
public class CubeModel extends CuboidModel {

	public CubeModel(Texture texture, int textureIds[]) {
		super(texture, textureIds, 0, 0, 0, 1, 1, 1);
	}
	
	public CubeModel(Texture texture, int textureId) {
		this(texture, new int[] { textureId, textureId, textureId, textureId, textureId, textureId });
	}
	
}
