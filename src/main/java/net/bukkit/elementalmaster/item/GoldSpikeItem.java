
package net.bukkit.elementalmaster.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.bukkit.elementalmaster.itemgroup.ElementalItemsItemGroup;
import net.bukkit.elementalmaster.ElementalmasterModElements;

@ElementalmasterModElements.ModElement.Tag
public class GoldSpikeItem extends ElementalmasterModElements.ModElement {
	@ObjectHolder("elementalmaster:goldspike")
	public static final Item block = null;
	public GoldSpikeItem(ElementalmasterModElements instance) {
		super(instance, 102);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ElementalItemsItemGroup.tab).maxStackSize(64));
			setRegistryName("goldspike");
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
