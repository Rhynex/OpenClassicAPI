package ch.spacebase.openclassic.api.level.generator.noise;

import ch.spacebase.openclassic.api.level.generator.noise.Noise;
import ch.spacebase.openclassic.api.level.generator.noise.PerlinNoise;

import java.util.Random;

/**
 * Octave noise used in generating a normal level.
 */
public class OctaveNoise extends Noise {

	private PerlinNoise[] algs;
	private int count;

	public OctaveNoise(Random rand, int algs) {
		this.count = algs;
		this.algs = new PerlinNoise[algs];
		for(int count = 0; count < algs; ++count) {
			this.algs[count] = new PerlinNoise(rand);
		}
	}

	public final double compute(double x, double z) {
		double result = 0;
		double amp = 1;
		for(int count = 0; count < this.count; count++) {
			result += this.algs[count].compute(x / amp, z / amp) * amp;
			amp *= 2;
		}

		return result;
	}

}
