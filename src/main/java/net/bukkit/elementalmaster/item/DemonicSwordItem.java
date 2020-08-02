
package net.bukkit.elementalmaster.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;

import net.bukkit.elementalmaster.procedures.DemonicSwordMobIsHitWithToolProcedure;
import net.bukkit.elementalmaster.itemgroup.ElementalGearsItemGroup;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@ElementalmasterModElements.ModElement.Tag
public class DemonicSwordItem extends ElementalmasterModElements.ModElement {
	@ObjectHolder("elementalmaster:demonicsword")
	public static final Item block = null;
	public DemonicSwordItem(ElementalmasterModElements instance) {
		super(instance, 135);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2000;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 8f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 60;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(FireIngotItem.block, (int) (1)));
			}
		}, 3, -2.4f, new Item.Properties().group(ElementalGearsItemGroup.tab)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("A powerful sword forged by sacred flames directly from hell!"));
				list.add(new StringTextComponent("Is effective against Ice Mobs!"));
			}

			@Override
			public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
				boolean retval = super.hitEntity(itemstack, entity, sourceentity);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				World world = entity.world;
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					DemonicSwordMobIsHitWithToolProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}
		}.setRegistryName("demonicsword"));
	}
}
