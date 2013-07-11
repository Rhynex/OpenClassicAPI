package ch.spacebase.openclassic.api.block.model;

import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.asset.AssetSource;
import ch.spacebase.openclassic.api.asset.texture.Texture;

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
	
	public CubeModel(String texture, AssetSource source) {
		this(OpenClassic.getGame().getAssetManager().load(texture, source, Texture.class), 0);
	}
	
	@Override
	public String getType() {
		return "CubeModel";
	}
	
}
