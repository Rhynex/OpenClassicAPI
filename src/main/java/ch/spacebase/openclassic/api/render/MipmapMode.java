package ch.spacebase.openclassic.api.render;

/**
 * Represents the level of mipmap support the client has.
 */
public enum MipmapMode {

	/** Mipmapping is not supported **/
	NONE,
	/** OpenGL 3.0 Mipmapping is supported. **/
	GL30,
	/** Mipmapping with the framebuffer extension is supported. **/
	FRAMEBUFFER_EXT,
	/** OpenGL 1.4 Mipmapping is supported. **/
	GL14;
	
}
