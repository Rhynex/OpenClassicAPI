package ch.spacebase.openclassic.api.block.model;

import java.util.ArrayList;
import java.util.List;

public class Texture {

	private String texture;
	private boolean jar;
	
	private int width;
	private int height;
	private int subWidth;
	private int subHeight;
	private List<SubTexture> subTextures;
	
	public Texture(String texture, boolean jar, int width, int height) {
		this(texture, jar, width, height, width, height);
	}
	
	public Texture(String texture, boolean jar, int width, int height, int subSize) {
		this(texture, jar, width, height, subSize, subSize);
	}
	
	public Texture(String texture, boolean jar, int width, int height, int subWidth, int subHeight) {
		this.texture = texture;
		this.jar = jar;
		this.width = width;
		this.height = height;
		this.subWidth = subWidth;
		this.subHeight = subHeight;
		this.subTextures = new ArrayList<SubTexture>((width / subWidth) * (height / subHeight));
		
		int count = 0;
		for (int y = 0; y < height / subHeight; y++) {
			for (int x = 0; x < width / subHeight; x++) {
				this.subTextures.add(count, new SubTexture(this, count, x * subWidth, y * subHeight, subWidth, subHeight));
				count++;
			}
		}
	}
	
	public SubTexture getSubTexture(int id) {
		return this.subTextures.get(id);
	}
	
	public String getTexture() {
		return this.texture;
	}
	
	public boolean isInJar() {
		return this.jar;
	}

	public int getSubTextureWidth() {
		return this.subWidth;
	}
	
	public int getSubTextureHeight() {
		return this.subHeight;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}
	
}
