package ch.spacebase.openclassic.api.block.model;

import org.apache.commons.lang3.Validate;

import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.block.BlockFace;
import ch.spacebase.openclassic.api.block.BlockType;

/**
 * A cuboid-shaped model.
 */
public class CuboidModel extends Model {

	private boolean cube = false;
	private float x1;
	private float y1;
	private float z1;
	private float x2;
	private float y2;
	private float z2;

	public CuboidModel(Texture texture, int[] textureIds, float x1, float y1, float z1, float x2, float y2, float z2) {
		Validate.isTrue(textureIds.length == 6, "Texture ID array must have length of 6!");
		this.x1 = x1;
		this.y1 = y1;
		this.z1 = z1;
		this.x2 = x2;
		this.y2 = y2;
		this.z2 = z2;
		if(x1 == 0 && y1 == 0 && z1 == 0 && x2 == 1 && y2 == 1 && z2 == 1) {
			this.cube = true;
		}

		this.setCollisionBox(x1, y1, z1, x2, y2, z2);
		this.setSelectionBox(x1, y1, z1, x2, y2, z2);

		Quad bottom = QuadFactory.getFactory().newQuad(0, texture.getSubTexture(textureIds[0]));
		bottom.addVertex(0, x1, y1, z1);
		bottom.addVertex(1, x2, y1, z1);
		bottom.addVertex(2, x2, y1, z2);
		bottom.addVertex(3, x1, y1, z2);
		this.addQuad(bottom);

		Quad top = QuadFactory.getFactory().newQuad(1, texture.getSubTexture(textureIds[1]));
		top.addVertex(0, x1, y2, z1);
		top.addVertex(1, x1, y2, z2);
		top.addVertex(2, x2, y2, z2);
		top.addVertex(3, x2, y2, z1);
		this.addQuad(top);

		Quad face1 = QuadFactory.getFactory().newQuad(2, texture.getSubTexture(textureIds[2]));
		face1.addVertex(0, x1, y1, z1);
		face1.addVertex(1, x1, y2, z1);
		face1.addVertex(2, x2, y2, z1);
		face1.addVertex(3, x2, y1, z1);
		this.addQuad(face1);

		Quad face2 = QuadFactory.getFactory().newQuad(3, texture.getSubTexture(textureIds[3]));
		face2.addVertex(0, x2, y1, z2);
		face2.addVertex(1, x2, y2, z2);
		face2.addVertex(2, x1, y2, z2);
		face2.addVertex(3, x1, y1, z2);
		this.addQuad(face2);

		Quad face3 = QuadFactory.getFactory().newQuad(4, texture.getSubTexture(textureIds[4]));
		face3.addVertex(0, x1, y1, z2);
		face3.addVertex(1, x1, y2, z2);
		face3.addVertex(2, x1, y2, z1);
		face3.addVertex(3, x1, y1, z1);
		this.addQuad(face3);

		Quad face4 = QuadFactory.getFactory().newQuad(5, texture.getSubTexture(textureIds[5]));
		face4.addVertex(0, x2, y1, z1);
		face4.addVertex(1, x2, y2, z1);
		face4.addVertex(2, x2, y2, z2);
		face4.addVertex(3, x2, y1, z2);
		this.addQuad(face4);
	}

	public CuboidModel(Texture texture, int textureId, float x1, float y1, float z1, float x2, float y2, float z2) {
		this(texture, new int[] { textureId, textureId, textureId, textureId, textureId, textureId }, x1, y1, z1, x2, y2, z2);
	}

	public CuboidModel(String texture, int textureSize, float x1, float y1, float z1, float x2, float y2, float z2) {
		this(new Texture(texture, false, textureSize, textureSize, textureSize), 0, x1, y1, z1, x2, y2, z2);
	}

	@Override
	public boolean render(float x, float y, float z, float brightness, boolean batch) {
		BlockType block = OpenClassic.getClient().getLevel().getBlockTypeAt((int) x, (int) y, (int) z);
		if(block == null) return false;
		boolean result = false;

		for(Quad quad : this.getQuads()) {
			BlockFace face = quadToFace(quad.getId());
			float mod = 0;
			switch(face) {
				case DOWN:
					mod = 0.5F;
					break;
				case UP:
					mod = 1;
					break;
				case WEST:
				case EAST:
					mod = 0.8F;
					break;
				case SOUTH:
				case NORTH:
					mod = 0.6F;
					break;
			}

			quad.render(x, y, z, OpenClassic.getClient().getLevel().getBrightness((int) x + face.getModX(), (int) y + face.getModY(), (int) z + face.getModZ()) * mod, batch);
			result = true;
		}

		return result;
	}

	@Override
	public void renderAll(float x, float y, float z, float brightness) {
		this.getQuad(0).render(x, y, z, brightness * 0.5F);
		this.getQuad(1).render(x, y, z, brightness * 1);
		this.getQuad(2).render(x, y, z, brightness * 0.8F);
		this.getQuad(3).render(x, y, z, brightness * 0.8F);
		this.getQuad(4).render(x, y, z, brightness * 0.6F);
		this.getQuad(5).render(x, y, z, brightness * 0.6F);
	}

	@Override
	public void renderScaled(float x, float y, float z, float scale, float brightness) {
		this.getQuad(0).renderScaled(x, y, z, scale, brightness * 0.5F);
		this.getQuad(1).renderScaled(x, y, z, scale, brightness * 1);
		this.getQuad(2).renderScaled(x, y, z, scale, brightness * 0.8F);
		this.getQuad(3).renderScaled(x, y, z, scale, brightness * 0.8F);
		this.getQuad(4).renderScaled(x, y, z, scale, brightness * 0.6F);
		this.getQuad(5).renderScaled(x, y, z, scale, brightness * 0.6F);
	}

	@Override
	public Class<? extends Model> getNetworkClass() {
		return CuboidModel.class;
	}

	/**
	 * Gets whether the model is a full cube.
	 * @return Whether the model is a full cube.
	 */
	public boolean isFullCube() {
		return this.cube;
	}

	/**
	 * Gets the model's first x coordinate.
	 * @return The model's first x.
	 */
	public float getX1() {
		return this.x1;
	}

	/**
	 * Gets the model's first y coordinate.
	 * @return The model's first y.
	 */
	public float getY1() {
		return this.y1;
	}

	/**
	 * Gets the model's first z coordinate.
	 * @return The model's first z.
	 */
	public float getZ1() {
		return this.z1;
	}

	/**
	 * Gets the model's second x coordinate.
	 * @return The model's second x.
	 */
	public float getX2() {
		return this.x2;
	}

	/**
	 * Gets the model's second y coordinate.
	 * @return The model's second y.
	 */
	public float getY2() {
		return this.y2;
	}

	/**
	 * Gets the model's second z coordinate.
	 * @return The model's second z.
	 */
	public float getZ2() {
		return this.z2;
	}

	/**
	 * Converts a quad ID to a BlockFace.
	 * @param quad Quad ID to convert.
	 * @return The BlockFace the quad ID converts to.
	 */
	public static BlockFace quadToFace(int quad) {
		switch(quad) {
			case 0:
				return BlockFace.DOWN;
			case 1:
				return BlockFace.UP;
			case 2:
				return BlockFace.WEST;
			case 3:
				return BlockFace.EAST;
			case 4:
				return BlockFace.SOUTH;
			case 5:
				return BlockFace.NORTH;
			default:
				return null;
		}
	}

}
