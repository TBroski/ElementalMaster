
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
public class LightningPickaxeItem extends ElementalmasterModElements.ModElement {
	@ObjectHolder("elementalmaster:lightningpickaxe")
	public static final Item block = null;
	public LightningPickaxeItem(ElementalmasterModElements instance) {
		super(instance, 146);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 1164;
			}

			public float getEfficiency() {
				return 14f;
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
				return Ingredient.fromStacks(new ItemStack(LightningIngotItem.block, (int) (1)));
			}
		}, 1, -2.7999999999999998f, new Item.Properties().group(ElementalGearsItemGroup.tab)) {
		}.setRegistryName("lightningpickaxe"));
	}
}
