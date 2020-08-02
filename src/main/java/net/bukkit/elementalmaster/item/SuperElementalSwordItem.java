
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
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;

import net.bukkit.elementalmaster.procedures.SuperElementalSwordToolInHandTickProcedure;
import net.bukkit.elementalmaster.procedures.SuperElementalSwordLivingEntityIsHitWithToolProcedure;
import net.bukkit.elementalmaster.itemgroup.ElementalGearsItemGroup;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

@ElementalmasterModElements.ModElement.Tag
public class SuperElementalSwordItem extends ElementalmasterModElements.ModElement {
	@ObjectHolder("elementalmaster:super_elemental_sword")
	public static final Item block = null;
	public SuperElementalSwordItem(ElementalmasterModElements instance) {
		super(instance, 179);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 4000;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 16f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 40;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(ElementalIngotItem.block, (int) (1)));
			}
		}, 3, -2.2f, new Item.Properties().group(ElementalGearsItemGroup.tab)) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("An even more powerful sword that any monsters can't resist to it's blade!"));
				list.add(new StringTextComponent("\u00A73Mana Cost: \u00A752 (Per hit)"));
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
					SuperElementalSwordLivingEntityIsHitWithToolProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}

			@Override
			public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
				super.inventoryTick(itemstack, world, entity, slot, selected);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				if (selected) {
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					SuperElementalSwordToolInHandTickProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("super_elemental_sword"));
	}
}
