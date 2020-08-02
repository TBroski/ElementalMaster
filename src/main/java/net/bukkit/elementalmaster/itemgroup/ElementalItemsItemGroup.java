
package net.bukkit.elementalmaster.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.bukkit.elementalmaster.item.ElementalIngotItem;
import net.bukkit.elementalmaster.ElementalmasterModElements;

@ElementalmasterModElements.ModElement.Tag
public class ElementalItemsItemGroup extends ElementalmasterModElements.ModElement {
	public ElementalItemsItemGroup(ElementalmasterModElements instance) {
		super(instance, 379);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabelementalitems") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ElementalIngotItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
