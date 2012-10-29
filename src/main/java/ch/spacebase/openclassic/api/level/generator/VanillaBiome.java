package ch.spacebase.openclassic.api.level.generator;

import ch.spacebase.openclassic.api.level.generator.normal.biome.BeachBiome;
import ch.spacebase.openclassic.api.level.generator.normal.biome.DesertBiome;
import ch.spacebase.openclassic.api.level.generator.normal.biome.ForestBiome;
import ch.spacebase.openclassic.api.level.generator.normal.biome.JungleBiome;
import ch.spacebase.openclassic.api.level.generator.normal.biome.MountainsBiome;
import ch.spacebase.openclassic.api.level.generator.normal.biome.OceanBiome;
import ch.spacebase.openclassic.api.level.generator.normal.biome.PlainBiome;
import ch.spacebase.openclassic.api.level.generator.normal.biome.SmallMountainsBiome;
import ch.spacebase.openclassic.api.level.generator.normal.biome.SwampBiome;
import ch.spacebase.openclassic.api.level.generator.normal.biome.TaigaBiome;

import ch.spacebase.openclassic.api.level.generator.biome.Biome;

public class VanillaBiome {

	public static final Biome OCEAN = new OceanBiome();
	public static final Biome PLAIN = new PlainBiome();
	public static final Biome DESERT = new DesertBiome();
	public static final Biome MOUNTAINS = new MountainsBiome();
	public static final Biome FOREST = new ForestBiome();
	public static final Biome TAIGA = new TaigaBiome();
	public static final Biome SWAMP = new SwampBiome();
	public static final Biome BEACH = new BeachBiome();
	public static final Biome SMALL_MOUNTAINS = new SmallMountainsBiome();
	public static final Biome JUNGLE = new JungleBiome();

}
