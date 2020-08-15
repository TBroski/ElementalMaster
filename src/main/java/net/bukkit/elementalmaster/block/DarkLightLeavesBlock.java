
package net.bukkit.elementalmaster.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.bukkit.elementalmaster.itemgroup.ElementalBlocksItemGroup;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.List;
import java.util.Collections;

@ElementalmasterModElements.ModElement.Tag
public class DarkLightLeavesBlock extends ElementalmasterModElements.ModElement {
	@ObjectHolder("elementalmaster:dark_light_leaves")
	public static final Block block = null;
	public DarkLightLeavesBlock(ElementalmasterModElements instance) {
		super(instance, 691);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ElementalBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends LeavesBlock {
		public CustomBlock() {
			super(Block.Properties.create(Material.LEAVES).sound(SoundType.PLANT).hardnessAndResistance(0.7999999999999999f, 10f).lightValue(8)
					.notSolid());
			setRegistryName("dark_light_leaves");
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public boolean isEmissiveRendering(BlockState blockState) {
			return true;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
