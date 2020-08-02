
package net.bukkit.elementalmaster.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

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
public class EarthPower3Item extends ElementalmasterModElements.ModElement {
	@ObjectHolder("elementalmaster:earth_power_3")
	public static final Item block = null;
	public EarthPower3Item(ElementalmasterModElements instance) {
		super(instance, 229);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(SpecialElementalItemsItemGroup.tab).maxStackSize(1));
			setRegistryName("earth_power_3");
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
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Doesn't Work yet... Coming Soon!"));
			list.add(new StringTextComponent("Put it in one of the 5 slots in a Master Station!"));
		}
	}
}
