
package net.bukkit.elementalmaster.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.bukkit.elementalmaster.itemgroup.SpecialElementalItemsItemGroup;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.List;

@ElementalmasterModElements.ModElement.Tag
public class LessManaGemItem extends ElementalmasterModElements.ModElement {
	@ObjectHolder("elementalmaster:less_mana_gem")
	public static final Item block = null;
	public LessManaGemItem(ElementalmasterModElements instance) {
		super(instance, 250);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SpecialElementalItemsItemGroup.tab).maxStackSize(64));
			setRegistryName("less_mana_gem");
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

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent(
					"Staff Upgrade: Reduces the amount of Mana you use when you use a spell using the \u00A7dStaff of Elements!"));
			list.add(new StringTextComponent("Less -50% Mana per use!"));
		}
	}
}
