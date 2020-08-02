
package net.bukkit.elementalmaster.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.bukkit.elementalmaster.item.ElementalGuideItem;
import net.bukkit.elementalmaster.ElementalmasterModElements;

@ElementalmasterModElements.ModElement.Tag
public class SpecialElementalItemsItemGroup extends ElementalmasterModElements.ModElement {
	public SpecialElementalItemsItemGroup(ElementalmasterModElements instance) {
		super(instance, 383);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabspecialelementalitems") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ElementalGuideItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
