
package net.bukkit.elementalmaster.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.bukkit.elementalmaster.item.DemonicSwordItem;
import net.bukkit.elementalmaster.ElementalmasterModElements;

@ElementalmasterModElements.ModElement.Tag
public class ElementalGearsItemGroup extends ElementalmasterModElements.ModElement {
	public ElementalGearsItemGroup(ElementalmasterModElements instance) {
		super(instance, 380);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabelementalgears") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(DemonicSwordItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
