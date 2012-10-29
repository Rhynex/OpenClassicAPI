package ch.spacebase.openclassic.api.level.generator.selector;

import ch.spacebase.openclassic.api.level.generator.biome.Biome;
import ch.spacebase.openclassic.api.level.generator.biome.BiomeSelector;
import ch.spacebase.openclassic.api.level.generator.biome.Biomes;
import net.royawesome.jlibnoise.module.modifier.Turbulence;
import net.royawesome.jlibnoise.module.source.Voronoi;

public class NoiseSelector extends BiomeSelector {

	private Voronoi base = new Voronoi();
	private Turbulence noise = new Turbulence();

	public NoiseSelector(double vorFreq, double displacement, int roughness, double turFreq, double power) {
		this.base.setFrequency(vorFreq);
		this.base.setDisplacement(displacement);
		this.noise.SetSourceModule(0, this.base);
		this.noise.setFrequency(turFreq);
		this.noise.setRoughness(roughness);
		this.noise.setPower(power);
	}

	@Override
	public Biome pickBiome(int x, int y, int z, long seed) {
		this.base.setSeed((int) seed);
		this.noise.setSeed((int) seed);
		return Biomes.getBiome((int) (this.noise.GetValue(x / 256.0 + 0.05, y + 0.05, z / 256.0 + 0.05) * 64));
	}
}
