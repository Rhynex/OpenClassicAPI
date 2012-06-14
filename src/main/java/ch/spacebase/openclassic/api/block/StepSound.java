package ch.spacebase.openclassic.api.block;

import java.util.Random;

public enum StepSound {

	NONE("", 0, 0),
	GRASS("step.grass", 0.6F, 1),
	CLOTH("step.cloth", 0.7F, 1.2F),
	SAND("step.sand", 0.6F, 1),
	GRAVEL("step.gravel", 1, 1),
	STONE("step.stone", 1, 1),
	METAL("step.stone", 1, 2),
	WOOD("step.wood", 1, 1);
	
	private static final Random rand = new Random();
	
	private String sound;
	private float volume;
	private float pitch;
	
	private StepSound(String sound, float volume, float pitch) {
		this.sound = sound;
		this.volume = volume;
		this.pitch = pitch;
	}
	
	public String getSound() {
		return this.sound;
	}
	
	public float getVolume() {
		return this.volume / (rand.nextFloat() * 0.4F + 1) * 0.5F;
	}
	
	public float getPitch() {
		return this.pitch / (rand.nextFloat() * 0.2F + 0.9F);
	}
	
}
