
package net.bukkit.elementalmaster.enchantment;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.DamageSource;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantment;

import net.bukkit.elementalmaster.ElementalmasterModElements;

@ElementalmasterModElements.ModElement.Tag
public class IceProtectionEnchantment extends ElementalmasterModElements.ModElement {
	@ObjectHolder("elementalmaster:ice_protection")
	public static final Enchantment enchantment = null;
	public IceProtectionEnchantment(ElementalmasterModElements instance) {
		super(instance, 679);
	}

	@Override
	public void initElements() {
		elements.enchantments.add(() -> new CustomEnchantment(EquipmentSlotType.MAINHAND).setRegistryName("ice_protection"));
	}
	public static class CustomEnchantment extends Enchantment {
		public CustomEnchantment(EquipmentSlotType... slots) {
			super(Enchantment.Rarity.UNCOMMON, EnchantmentType.ARMOR, slots);
		}

		@Override
		public int getMinLevel() {
			return 1;
		}

		@Override
		public int getMaxLevel() {
			return 1;
		}

		@Override
		public int calcModifierDamage(int level, DamageSource source) {
			return level * 4;
		}

		@Override
		public boolean isTreasureEnchantment() {
			return false;
		}

		@Override
		public boolean isCurse() {
			return false;
		}

		@Override
		public boolean isAllowedOnBooks() {
			return true;
		}
	}
}
