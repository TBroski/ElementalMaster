
package net.bukkit.elementalmaster.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.bukkit.elementalmaster.procedures.SuperManaFruitFoodEatenProcedure;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@ElementalmasterModElements.ModElement.Tag
public class SuperManaFruitItem extends ElementalmasterModElements.ModElement {
	@ObjectHolder("elementalmaster:super_mana_fruit")
	public static final Item block = null;
	public SuperManaFruitItem(ElementalmasterModElements instance) {
		super(instance, 272);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64)
					.food((new Food.Builder()).hunger(0).saturation(0f).setAlwaysEdible().build()));
			setRegistryName("super_mana_fruit");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Increase the player's total Mana limit by +10 from 150 to 200!"));
			list.add(new StringTextComponent("Max Mana when you eat it!"));
			list.add(new StringTextComponent("Obtained by killing bosses or can be very rarely found in Dungeon chests!"));
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemStack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemStack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				SuperManaFruitFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
