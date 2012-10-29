package ch.spacebase.openclassic.api.level.generator.selector;

import ch.spacebase.openclassic.api.level.generator.VanillaBiome;
import ch.spacebase.openclassic.api.level.generator.biome.Biome;
import ch.spacebase.openclassic.api.level.generator.biome.BiomeSelector;
import net.royawesome.jlibnoise.module.combiner.Select;
import net.royawesome.jlibnoise.module.modifier.Clamp;
import net.royawesome.jlibnoise.module.modifier.ScaleBias;
import net.royawesome.jlibnoise.module.modifier.Turbulence;
import net.royawesome.jlibnoise.module.source.Billow;
import net.royawesome.jlibnoise.module.source.Const;
import net.royawesome.jlibnoise.module.source.Perlin;
import net.royawesome.jlibnoise.module.source.RidgedMulti;

public class DefaultSelector extends BiomeSelector {

	private final double scale;
	private final Perlin temperature, rainfall;
	private final RidgedMulti mountain;
	private final Billow continentSelector;
	private final Billow hills;
	private final Clamp finalRainfall;
	private final Clamp finalTemp;
	private final Select oceanBeachDivide, finalElevationNoise;

	public DefaultSelector(double scale, double biomeScale, double oceanBoundary, double beachBoundary, boolean hasMountains) {
		this.scale = scale;
		
		this.rainfall = new Perlin();
		this.rainfall.setFrequency(0.4 / biomeScale);
		this.rainfall.setOctaveCount(4);
		ScaleBias rainfallModifier = new ScaleBias();
		rainfallModifier.SetSourceModule(0, this.rainfall);
		rainfallModifier.setScale(0.5);
		rainfallModifier.setBias(0.5);
		Turbulence rainfallTurbulence = new Turbulence();
		rainfallTurbulence.SetSourceModule(0, rainfallModifier);
		rainfallTurbulence.setFrequency(0.4);
		rainfallTurbulence.setPower(0.6);
		this.finalRainfall = new Clamp();
		this.finalRainfall.SetSourceModule(0, rainfallTurbulence);
		this.finalRainfall.setLowerBound(0);
		this.finalRainfall.setUpperBound(1.0);
		
		this.temperature = new Perlin();
		this.temperature.setFrequency(0.4 / biomeScale);
		this.temperature.setOctaveCount(4);
		ScaleBias tempModifier = new ScaleBias();
		tempModifier.SetSourceModule(0, this.temperature);
		tempModifier.setScale(0.5);
		tempModifier.setBias(0.5);
		Turbulence tempTurbulence = new Turbulence();
		tempTurbulence.SetSourceModule(0, tempModifier);
		tempTurbulence.setFrequency(0.4);
		tempTurbulence.setPower(0.5);
		this.finalTemp = new Clamp();
		this.finalTemp.SetSourceModule(0, tempTurbulence);
		this.finalTemp.setLowerBound(0);
		this.finalTemp.setUpperBound(1.0);

		Const uniformOcean = new Const();
		uniformOcean.setValue(-1);
		Const shoreline = new Const();
		shoreline.setValue(0.1);
		this.mountain = new RidgedMulti();
		this.mountain.setFrequency(0.3);
		this.mountain.setLacunarity(3.5);
		this.mountain.setOctaveCount(4);
		ScaleBias mountainModifier = new ScaleBias();
		mountainModifier.SetSourceModule(0, this.mountain);
		mountainModifier.setBias(0.5);
		mountainModifier.setScale(0.5);
		this.hills = new Billow();
		this.hills.setFrequency(0.45);
		this.hills.setPersistence(0.5);
		this.hills.setLacunarity(2.5);
		this.hills.setOctaveCount(6);
		ScaleBias hillsModifier = new ScaleBias();
		hillsModifier.SetSourceModule(0, this.hills);
		hillsModifier.setBias(0.5);
		hillsModifier.setScale(0.5);
		Clamp hillsClamp = new Clamp();
		hillsClamp.SetSourceModule(0, hillsModifier);
		hillsClamp.setLowerBound(0);
		hillsClamp.setUpperBound(0.65);

		final Clamp elevationClamp = new Clamp();
		if(hasMountains) {
			final Select mountainRangeSelector = new Select();
			mountainRangeSelector.SetSourceModule(1, mountainModifier);
			mountainRangeSelector.SetSourceModule(0, hillsClamp);
			mountainRangeSelector.setControlModule(mountainModifier);
			mountainRangeSelector.setBounds(100, 0.75);
			mountainRangeSelector.setEdgeFalloff(0.4);
			elevationClamp.SetSourceModule(0, mountainRangeSelector);
			elevationClamp.setLowerBound(0.11);
			elevationClamp.setUpperBound(1.0);
		} else {
			elevationClamp.SetSourceModule(0, hillsClamp);
		}

		this.continentSelector = new Billow();
		this.continentSelector.setFrequency(0.2);
		this.continentSelector.setOctaveCount(10);
		ScaleBias continentSelectorModifier = new ScaleBias();
		continentSelectorModifier.SetSourceModule(0, this.continentSelector);
		continentSelectorModifier.setScale(0.5);
		continentSelectorModifier.setBias(0.5);

		this.oceanBeachDivide = new Select();
		this.oceanBeachDivide.SetSourceModule(0, uniformOcean);
		this.oceanBeachDivide.SetSourceModule(1, shoreline);
		this.oceanBeachDivide.setControlModule(continentSelectorModifier);
		this.oceanBeachDivide.setBounds(100, oceanBoundary);

		this.finalElevationNoise = new Select();
		this.finalElevationNoise.SetSourceModule(0, this.oceanBeachDivide);
		this.finalElevationNoise.SetSourceModule(1, elevationClamp);
		this.finalElevationNoise.setControlModule(continentSelectorModifier);
		this.finalElevationNoise.setBounds(100, oceanBoundary + beachBoundary);
	}

	@Override
	public Biome pickBiome(int x, int y, int z, long seed) {
		this.continentSelector.setSeed((int) seed);
		this.rainfall.setSeed((int) seed * 2);
		this.temperature.setSeed((int) seed * 7);
		this.mountain.setSeed((int) seed * 5);
		this.hills.setSeed((int) seed * 13);

		double elevation = this.getElevation(x, z);
		double rain = this.getAvgRainfall(x, z);
		double temp = this.getAvgTemperature(x, z);

		if(elevation > 0.8) {
			return VanillaBiome.MOUNTAINS;
		} else if(elevation > 0.65) {
			return VanillaBiome.SMALL_MOUNTAINS;
		} else if(elevation == 0.1) {
			if (rain > 0.6) {
				return VanillaBiome.SWAMP;
			} else {
				return VanillaBiome.BEACH;
			}
		} else if(elevation == -1) {
			return VanillaBiome.OCEAN;
		} else {
			if(temp < 0.2) {
				if (rain > 0.6) {
					return VanillaBiome.TAIGA;
				}
			} else if(temp < 0.4) {
				if(rain > 0.6) {
					return VanillaBiome.FOREST;
				} else {
					return VanillaBiome.TAIGA;
				}
			} else if(temp < 0.6) {
				if(rain > 0.8) {
					return VanillaBiome.JUNGLE;
				} else if(rain > 0.4) {
					return VanillaBiome.FOREST;
				} else {
					return VanillaBiome.PLAIN;
				}
			} else if(temp < 0.8) {
				if(rain > 0.8) {
					return VanillaBiome.JUNGLE;
				} else if(rain > 0.6) {
					return VanillaBiome.FOREST;
				} else if(rain > 0.2) {
					return VanillaBiome.PLAIN;
				} else {
					return VanillaBiome.DESERT;
				}
			} else {
				if(rain > 0.8) {
					return VanillaBiome.JUNGLE;
				} else if(rain > 0.6) {
					return VanillaBiome.FOREST;
				} else if(rain > 0.4) {
					return VanillaBiome.PLAIN;
				} else {
					return VanillaBiome.DESERT;
				}
			}
		}
		
		return VanillaBiome.PLAIN;
	}

	public double getElevation(int x, int z) {
		return this.finalElevationNoise.GetValue(x / (this.scale * 128.0) + 0.05, 0.05, z / (this.scale * 128.0) + 0.05);
	}

	public double getAvgRainfall(int x, int z) {
		return this.finalRainfall.GetValue(x / (this.scale * 128.0) + 0.05, 0.05, z / (this.scale * 128.0) + 0.05);
	}

	public double getAvgTemperature(int x, int z) {
		return this.finalTemp.GetValue(x / (this.scale * 128.0) + 0.05, 0.05, z / (this.scale * 128.0) + 0.05);
	}

}
