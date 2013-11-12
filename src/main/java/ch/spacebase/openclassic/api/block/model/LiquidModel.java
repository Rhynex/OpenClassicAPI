package ch.spacebase.openclassic.api.block.model;

import java.util.List;

import ch.spacebase.openclassic.api.Client;
import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.block.BlockFace;
import ch.spacebase.openclassic.api.block.BlockType;
import ch.spacebase.openclassic.api.math.BoundingBox;
import ch.spacebase.openclassic.api.render.RenderHelper;

/**
 * A model used in liquids.
 */
public class LiquidModel extends CubeModel {

	private BoundingBox top = new BoundingBox(0, 0, 0, 1, 0.95f, 1);
	
	public LiquidModel(Texture texture, int textureIds[]) {
		super(texture, textureIds);
		this.setCollisionBox(null);
		this.setSelectionBox(null);
	}
	
	public LiquidModel(Texture texture, int textureId) {
		this(texture, new int[] { textureId, textureId, textureId, textureId, textureId, textureId });
	}
	
	public LiquidModel(String texture, int textureSize) {
		this(new Texture(texture, false, textureSize, textureSize, textureSize), 0);
	}
	
	@Override
	public BoundingBox getSelectionBox(int x, int y, int z) {
		if(OpenClassic.getGame() instanceof Client && OpenClassic.getClient().getLevel() != null && OpenClassic.getClient().getLevel().getBlockTypeAt(x, y + 1, z) != null && !OpenClassic.getClient().getLevel().getBlockTypeAt(x, y + 1, z).isLiquid()) {
			return this.top;
		}
		
		return super.getSelectionBox(x, y, z);
	}
	
	@Override
	public boolean render(float x, float y, float z, float brightness, boolean batch) {
		BlockType block = OpenClassic.getClient().getLevel().getBlockTypeAt((int) x, (int) y, (int) z);
		if(block == null) return false;
		boolean result = false;
		
		boolean top = false;
		List<Quad> quads = this.getQuads();
		if(OpenClassic.getClient().getLevel().getBlockTypeAt((int) x, (int) y + 1, (int) z) != null && !OpenClassic.getClient().getLevel().getBlockTypeAt((int) x, (int) y + 1, (int) z).isLiquid()) {
			top = true;
		}
		
		RenderHelper.getHelper().setCulling(false);
		int count = 0;
		for(Quad quad : quads) {
			BlockFace face = quadToFace(this, count);
			if (RenderHelper.getHelper().canRenderSide(block, (int) x, (int) y, (int) z, face)) {
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
				
				if(top) {
					for(int vert = 0; vert < quad.getVertices().size(); vert++) {
						Vertex v = quad.getVertices().get(vert);
						if(v.getY() == 1) {
							quad.addVertex(vert, new Vertex(v.getX(), 0.95f, v.getZ()));
						}
					}
				}
				
				quad.render(x, y, z, RenderHelper.getHelper().getBrightness(block, (int) x + face.getModX(), (int) y + face.getModY(), (int) z + face.getModZ()) * mod, batch);
				if(top) {
					for(int vert = 0; vert < quad.getVertices().size(); vert++) {
						Vertex v = quad.getVertices().get(vert);
						if(v.getY() == 0.95f) {
							quad.addVertex(vert, new Vertex(v.getX(), 1, v.getZ()));
						}
					}
				}
				
				result = true;
			}
			
			count++;
		}
		
		RenderHelper.getHelper().setCulling(true);
		return result;
	}
	
	@Override
	public Class<? extends Model> getNetworkClass() {
		return LiquidModel.class;
	}

}
