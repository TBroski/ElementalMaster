
package net.bukkit.elementalmaster.world.biome;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.block.Blocks;

import net.bukkit.elementalmaster.ElementalmasterModElements;

import com.google.common.collect.Lists;

@ElementalmasterModElements.ModElement.Tag
public class IcyPineWoodsBiome extends ElementalmasterModElements.ModElement {
	@ObjectHolder("elementalmaster:icypinewoods")
	public static final CustomBiome biome = null;
	public IcyPineWoodsBiome(ElementalmasterModElements instance) {
		super(instance, 374);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new CustomBiome());
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.COLD);
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.ICY, new BiomeManager.BiomeEntry(biome, 6));
	}
	static class CustomBiome extends Biome {
		public CustomBiome() {
			super(new Biome.Builder().downfall(0.5f).depth(0.2f).scale(0.2f).temperature(-0.1f).precipitation(Biome.RainType.SNOW)
					.category(Biome.Category.ICY).waterColor(-16711681).waterFogColor(-16711681).parent("snowy_taiga")
					.surfaceBuilder(SurfaceBuilder.DEFAULT, new SurfaceBuilderConfig(Blocks.GRASS_BLOCK.getDefaultState(),
							Blocks.DIRT.getDefaultState(), Blocks.DIRT.getDefaultState())));
			setRegistryName("icypinewoods");
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addOres(this);
			DefaultBiomeFeatures.addLakes(this);
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(DefaultBiomeFeatures.DEFAULT_FLOWER_CONFIG)
					.withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(3))));
			addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG)
					.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(3))));
			addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.DISK
							.withConfiguration(new SphereReplaceConfig(Blocks.SAND.getDefaultState(), 7, 2,
									Lists.newArrayList(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState())))
							.withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(1))));
			addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
					Feature.DISK
							.withConfiguration(new SphereReplaceConfig(Blocks.GRAVEL.getDefaultState(), 6, 2,
									Lists.newArrayList(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState())))
							.withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(1))));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.POLAR_BEAR, 15, 1, 15));
			this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.SHEEP, 15, 1, 15));
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getGrassColor(double posX, double posZ) {
			return -1;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getFoliageColor() {
			return -1;
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public int getSkyColor() {
			return -6684673;
		}
	}
}
