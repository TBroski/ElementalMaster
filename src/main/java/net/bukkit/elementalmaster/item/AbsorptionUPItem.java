
package net.bukkit.elementalmaster.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.bukkit.elementalmaster.procedures.UpsProcedureProcedure;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;
import java.util.HashMap;

@ElementalmasterModElements.ModElement.Tag
public class AbsorptionUPItem extends ElementalmasterModElements.ModElement {
	@ObjectHolder("elementalmaster:absorptionup")
	public static final Item block = null;
	public AbsorptionUPItem(ElementalmasterModElements instance) {
		super(instance, 194);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.MISC).maxStackSize(64));
			setRegistryName("absorptionup");
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
		public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				UpsProcedureProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
