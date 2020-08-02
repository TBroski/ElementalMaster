
package net.bukkit.elementalmaster.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.bukkit.elementalmaster.procedures.RunesProceduresProcedure;
import net.bukkit.elementalmaster.itemgroup.ElementalItemsItemGroup;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@ElementalmasterModElements.ModElement.Tag
public class IceRuneItem extends ElementalmasterModElements.ModElement {
	@ObjectHolder("elementalmaster:icerune")
	public static final Item block = null;
	public IceRuneItem(ElementalmasterModElements instance) {
		super(instance, 106);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ElementalItemsItemGroup.tab).maxStackSize(1));
			setRegistryName("icerune");
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
			list.add(new StringTextComponent("Grants you \u00A79Resistance II \u00A7fwhen in Inventory!"));
			list.add(new StringTextComponent("Can be found in Dungeons!"));
			list.add(new StringTextComponent("Can be crafted!"));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				RunesProceduresProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
