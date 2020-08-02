
package net.bukkit.elementalmaster.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.bukkit.elementalmaster.itemgroup.ElementalItemsItemGroup;
import net.bukkit.elementalmaster.ElementalmasterModElements;

@ElementalmasterModElements.ModElement.Tag
public class CactusSpikeItem extends ElementalmasterModElements.ModElement {
	@ObjectHolder("elementalmaster:cactusspike")
	public static final Item block = null;
	public CactusSpikeItem(ElementalmasterModElements instance) {
		super(instance, 101);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ElementalItemsItemGroup.tab).maxStackSize(64));
			setRegistryName("cactusspike");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
