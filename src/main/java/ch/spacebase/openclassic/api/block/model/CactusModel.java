package ch.spacebase.openclassic.api.block.model;

import ch.spacebase.openclassic.api.block.BlockFace;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.render.RenderHelper;

/**
 * The model used for cacti.
 */
public class CactusModel extends Model {
	
	public CactusModel(Texture texture, int[] textureIds) {
		if(textureIds.length < 6) {
			throw new IllegalArgumentException("Texture ID array must have length of 6!");
		}
		
		this.setCollisionBox(0.065f, 0, 0.065f, 0.935f, 1, 0.935f);
		this.setSelectionBox(0.065f, 0, 0.065f, 0.935f, 1, 0.935f);
		
		Quad bottom = new Quad(0, texture.getSubTexture(textureIds[0]));
		bottom.addVertex(0, 0, 0, 0);
		bottom.addVertex(1, 1, 0, 0);
		bottom.addVertex(2, 1, 0, 1);
		bottom.addVertex(3, 0, 0, 1);
		this.addQuad(bottom);
		
		Quad top = new Quad(1, texture.getSubTexture(textureIds[1]));
		top.addVertex(0, 0, 1, 0);
		top.addVertex(1, 0, 1, 1);
		top.addVertex(2, 1, 1, 1);
		top.addVertex(3, 1, 1, 0);
		this.addQuad(top);

		Quad face1 = new Quad(2, texture.getSubTexture(textureIds[2]));
		face1.addVertex(0, 0, 0, 0.065f);
		face1.addVertex(1, 0, 1, 0.065f);
		face1.addVertex(2, 1, 1, 0.065f);
		face1.addVertex(3, 1, 0, 0.065f);
		this.addQuad(face1);

		Quad face2 = new Quad(3, texture.getSubTexture(textureIds[3]));
		face2.addVertex(0, 1, 0, 0.935f);
		face2.addVertex(1, 1, 1, 0.935f);
		face2.addVertex(2, 0, 1, 0.935f);
		face2.addVertex(3, 0, 0, 0.935f);
		this.addQuad(face2);

		Quad face3 = new Quad(4, texture.getSubTexture(textureIds[4]));
		face3.addVertex(0, 0.065f, 0, 1);
		face3.addVertex(1, 0.065f, 1, 1);
		face3.addVertex(2, 0.065f, 1, 0);
		face3.addVertex(3, 0.065f, 0, 0);
		this.addQuad(face3);
		
		Quad face4 = new Quad(5, texture.getSubTexture(textureIds[5]));
		face4.addVertex(0, 0.935f, 0, 0);
		face4.addVertex(1, 0.935f, 1, 0);
		face4.addVertex(2, 0.935f, 1, 1);
		face4.addVertex(3, 0.935f, 0, 1);
		this.addQuad(face4);
	}
	
	public CactusModel(Texture texture, int textureId) {
		this(texture, new int[] { textureId, textureId, textureId, textureId, textureId, textureId });
	}
	
	public CactusModel(String texture, int textureSize) {
		this(new Texture(texture, false, textureSize, textureSize, textureSize), 0);
	}
	
	@Override
	public boolean render(BlockType block, float x, float y, float z, float brightness) {
		if(block == null) return false;
		boolean result = false;
		
		for(Quad quad : this.getQuads()) {
			BlockFace face = quadToFace(this, quad.getId());
			if(!((face == BlockFace.UP || face == BlockFace.DOWN) && !RenderHelper.getHelper().canRenderSide(block, (int) x, (int) y, (int) z, face))) {
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
				
				quad.render(x, y, z, brightness * mod);
				result = true;
			}
		}
		
		return result;
	}
	
	@Override
	public void renderAll(BlockType type, float x, float y, float z, float brightness) {
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
	public String getType() {
		return "CactusModel";
	}
	
	private static BlockFace quadToFace(CactusModel model, int quad) {
		switch(quad) {
			case 0: return BlockFace.DOWN;
			case 1: return BlockFace.UP;
			case 2: return BlockFace.WEST;
			case 3: return BlockFace.EAST;
			case 4: return BlockFace.SOUTH;
			case 5: return BlockFace.NORTH;
			default: return null;
		}
	}
	
}
