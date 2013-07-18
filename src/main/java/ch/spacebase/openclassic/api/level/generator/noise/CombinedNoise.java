package ch.spacebase.openclassic.api.level.generator.noise;

import ch.spacebase.openclassic.api.level.generator.noise.Noise;

/**
 * Combined noise used in generating a normal level.
 */
public final class CombinedNoise extends Noise {

	private Noise noise1;
	private Noise noise2;

	public CombinedNoise(Noise noise1, Noise noise2) {
		this.noise1 = noise1;
		this.noise2 = noise2;
	}

	public final double compute(double x, double z) {
		return this.noise1.compute(x + this.noise2.compute(x, z), z);
	}

}
