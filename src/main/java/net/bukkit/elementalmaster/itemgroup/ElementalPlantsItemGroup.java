
package net.bukkit.elementalmaster.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.bukkit.elementalmaster.block.FieryRoseBlock;
import net.bukkit.elementalmaster.ElementalmasterModElements;

@ElementalmasterModElements.ModElement.Tag
public class ElementalPlantsItemGroup extends ElementalmasterModElements.ModElement {
	public ElementalPlantsItemGroup(ElementalmasterModElements instance) {
		super(instance, 381);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabelementalplants") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(FieryRoseBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
