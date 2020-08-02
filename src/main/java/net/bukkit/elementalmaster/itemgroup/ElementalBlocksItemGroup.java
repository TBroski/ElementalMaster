
package net.bukkit.elementalmaster.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.bukkit.elementalmaster.block.FiriumLogBlock;
import net.bukkit.elementalmaster.ElementalmasterModElements;

@ElementalmasterModElements.ModElement.Tag
public class ElementalBlocksItemGroup extends ElementalmasterModElements.ModElement {
	public ElementalBlocksItemGroup(ElementalmasterModElements instance) {
		super(instance, 378);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabelementalblocks") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(FiriumLogBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
