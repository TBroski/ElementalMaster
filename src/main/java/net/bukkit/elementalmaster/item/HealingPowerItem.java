
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
public class HealingPowerItem extends ElementalmasterModElements.ModElement {
	@ObjectHolder("elementalmaster:healing_power")
	public static final Item block = null;
	public HealingPowerItem(ElementalmasterModElements instance) {
		super(instance, 239);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SpecialElementalItemsItemGroup.tab).maxStackSize(1));
			setRegistryName("healing_power");
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
			list.add(new StringTextComponent("Equip it to your Staff Of Elements to heal yourself!"));
			list.add(new StringTextComponent("\u00A7eLevel 1 :-"));
			list.add(new StringTextComponent("\u00A74Heal Amount: \u00A761 heart"));
			list.add(new StringTextComponent("\u00A73Cooldown: \u00A763s"));
			list.add(new StringTextComponent("\u00A73Mana Cost: \u00A754"));
		}
	}
}
