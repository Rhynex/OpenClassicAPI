package ch.spacebase.openclassic.api.block.model;

public class EmptyModel extends Model {

	public boolean render(int x, int y, int z, float brightness) {
		return true;
	}

	public void renderFullbright(int x, int y, int z) {
	}
	
	public void renderPreview(float brightness) {
	}
	
	public Class<? extends Model> getNetworkClass() {
		return EmptyModel.class;
	}

	public void renderAll(int x, int y, int z, float brightness) {
	}
	
}
