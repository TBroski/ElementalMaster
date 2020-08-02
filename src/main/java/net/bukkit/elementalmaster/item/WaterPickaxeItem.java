
package net.bukkit.elementalmaster.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.bukkit.elementalmaster.itemgroup.ElementalGearsItemGroup;
import net.bukkit.elementalmaster.ElementalmasterModElements;

@ElementalmasterModElements.ModElement.Tag
public class WaterPickaxeItem extends ElementalmasterModElements.ModElement {
	@ObjectHolder("elementalmaster:waterpickaxe")
	public static final Item block = null;
	public WaterPickaxeItem(ElementalmasterModElements instance) {
		super(instance, 152);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1164;
			}

			public float getEfficiency() {
				return 12f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 42;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(WaterIngotItem.block, (int) (1)));
			}
		}, 1, -3f, new Item.Properties().group(ElementalGearsItemGroup.tab)) {
		}.setRegistryName("waterpickaxe"));
	}
}
