
package net.bukkit.elementalmaster.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.bukkit.elementalmaster.procedures.ManaFruitFoodEatenProcedure;
import net.bukkit.elementalmaster.itemgroup.ElementalItemsItemGroup;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@ElementalmasterModElements.ModElement.Tag
public class ManaFruitItem extends ElementalmasterModElements.ModElement {
	@ObjectHolder("elementalmaster:mana_fruit")
	public static final Item block = null;
	public ManaFruitItem(ElementalmasterModElements instance) {
		super(instance, 129);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ElementalItemsItemGroup.tab).maxStackSize(64)
					.food((new Food.Builder()).hunger(0).saturation(0f).setAlwaysEdible().build()));
			setRegistryName("mana_fruit");
		}

		@Override
		public UseAction getUseAction(ItemStack par1ItemStack) {
			return UseAction.EAT;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Increase the player's total Mana limit by +10 when you eat it!"));
			list.add(new StringTextComponent("You can still increase your mana until 150 Mana!"));
			list.add(new StringTextComponent("Obtained by killing bosses or rarely found in Dungeon chests!"));
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
				ManaFruitFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
