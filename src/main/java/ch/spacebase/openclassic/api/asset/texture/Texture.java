package ch.spacebase.openclassic.api.asset.texture;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;

import static org.lwjgl.opengl.GL11.*;

import ch.spacebase.openclassic.api.asset.Asset;
import ch.spacebase.openclassic.api.asset.AssetSource;

public class Texture extends Asset {

	private BufferedImage img;
	private TextureFormat format;
	private int textureId = -1;;
	
	public Texture(String file, AssetSource source) {
		super(file, source);
	}
	
	public BufferedImage getImage() {
		return this.img;
	}
	
	public int getWidth() {
		return this.img.getWidth();
	}
	
	public int getHeight() {
		return this.img.getHeight();
	}
	
	public SubTexture getSubTexture(int id, int width, int height) {
		return new SubTexture(this, (id % 16) / 16f, (id / 16f) / 16f, width, height);
	}
	
	public SubTexture getSubTexture(int x, int y, int width, int height) {
		return new SubTexture(this, x, y, width, height);
	}
	
	public int[] getRGB(int x, int y, int width, int height) {
		return this.img.getRGB(x, y, width, height, null, 0, width);
	}
	
	public int getRGB(int x, int y) {
		return this.img.getRGB(x, y);
	}
	
	public void setRGB(int x, int y, int rgb) {
		this.img.setRGB(x, y, rgb);
	}
	
	public TextureFormat getFormat() {
		return this.format;
	}
	
	public void bind() {
		if(this.textureId == -1) {
			IntBuffer id = BufferUtils.createIntBuffer(1);
			glGenTextures(id);
			this.textureId = id.get();
			
			glBindTexture(GL_TEXTURE_2D, this.textureId);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
			
			int[] pixels = new int[this.img.getWidth() * this.img.getHeight()];
			this.img.getRGB(0, 0, this.img.getWidth(), this.img.getHeight(), pixels, 0, this.img.getWidth());

			ByteBuffer buffer = BufferUtils.createByteBuffer(this.img.getWidth() * this.img.getHeight() * 4);
			for(int y = 0; y < this.img.getHeight(); y++){
				for(int x = 0; x < this.img.getWidth(); x++){
					int pixel = pixels[y * this.img.getWidth() + x];
					int red = (pixel >> 16) & 0xFF;
					int blue = pixel & 0xFF;
					int green = (pixel >> 8) & 0xFF;
					int alpha = (pixel >> 24) & 0xFF;

					buffer.put((byte) red);
					buffer.put((byte) green);
					buffer.put((byte) blue);
					buffer.put((byte) alpha);
				}
			}

			buffer.flip();
			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, this.img.getWidth(), this.img.getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);
		}
		
		glBindTexture(this.textureId, GL_TEXTURE_2D);
	}
	
	@Override
	public void load(DataInputStream in) throws IOException {
		this.img = ImageIO.read(in);
		//this.format = TextureFormat.valueOf(ImageIO.getImageReaders(ImageIO.createImageInputStream(in)).next().getFormatName().toUpperCase());
	}

	@Override
	public void save(DataOutputStream out) throws IOException {
		ImageIO.write(this.img, this.format.name(), out);
	}

}
