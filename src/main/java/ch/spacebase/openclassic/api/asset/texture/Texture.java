package ch.spacebase.openclassic.api.asset.texture;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GLContext;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL12.GL_TEXTURE_MAX_LEVEL;
import static org.lwjgl.opengl.GL14.GL_GENERATE_MIPMAP;

import ch.spacebase.openclassic.api.OpenClassic;
import ch.spacebase.openclassic.api.asset.Asset;
import ch.spacebase.openclassic.api.asset.AssetSource;

public class Texture extends Asset {

	private static MipmapMode mipmaps;

	public static void pickMipmaps() {
		if(GLContext.getCapabilities().OpenGL30) {
			mipmaps = MipmapMode.GL30;
		} else if(GLContext.getCapabilities().GL_EXT_framebuffer_object) {
			mipmaps = MipmapMode.FRAMEBUFFER;
		} else if(GLContext.getCapabilities().OpenGL14) {
			mipmaps = MipmapMode.GL14;
			glTexParameteri(GL_TEXTURE_2D, GL_GENERATE_MIPMAP, GL_TRUE);
		}
	}
	
	public static MipmapMode getMipmaps() {
		return mipmaps;
	}

	private BufferedImage img;
	private TextureFormat format;
	private int textureId = -1;

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

	public SubTexture getSubTexture(int id, float width, float height) {
		return new SubTexture(this, (id % (this.getWidth() / width)) * width, (id / (int) (this.getWidth() / width)) * height, width, height);
	}

	public SubTexture getSubTexture(float x, float y, float width, float height) {
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
			if(OpenClassic.getGame().getConfig().getBoolean("options.smoothing") && mipmaps != MipmapMode.NONE) {
				glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAX_LEVEL, 2);
				glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
				glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST_MIPMAP_LINEAR);
			} else {
				glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
				glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
			}

			int[] pixels = new int[this.img.getWidth() * this.img.getHeight()];
			this.img.getRGB(0, 0, this.img.getWidth(), this.img.getHeight(), pixels, 0, this.img.getWidth());

			ByteBuffer buffer = BufferUtils.createByteBuffer(this.img.getWidth() * this.img.getHeight() * 4);
			for(int y = 0; y < this.img.getHeight(); y++) {
				for(int x = 0; x < this.img.getWidth(); x++) {
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

		glBindTexture(GL_TEXTURE_2D, this.textureId);
	}

	public int getTextureId() {
		return this.textureId;
	}

	@Override
	public void load(DataInputStream in) throws IOException {
		this.img = ImageIO.read(in);
		if(this.getFile().contains(".")) {
			try {
				this.format = TextureFormat.valueOf(this.getFile().substring(this.getFile().indexOf(".") + 1).toUpperCase());
			} catch (Exception e) {
				OpenClassic.getLogger().warning("Failed to find format of image " + this.getFile() + "!");
				this.format = TextureFormat.UNKNOWN;
			}
		} else {
			this.format = TextureFormat.UNKNOWN;
		}
	}

	@Override
	public void save(DataOutputStream out) throws IOException {
		ImageIO.write(this.img, this.format.name(), out);
	}

}
