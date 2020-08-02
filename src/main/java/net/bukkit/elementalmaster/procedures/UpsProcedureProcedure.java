package net.bukkit.elementalmaster.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.potion.ManaRegenerationPotion;
import net.bukkit.elementalmaster.item.StrengthUPItem;
import net.bukkit.elementalmaster.item.SpeedUPItem;
import net.bukkit.elementalmaster.item.RespirationUPItem;
import net.bukkit.elementalmaster.item.ResistanceUPItem;
import net.bukkit.elementalmaster.item.ManaUPItem;
import net.bukkit.elementalmaster.item.HealthBoostUPItem;
import net.bukkit.elementalmaster.item.HealUPItem;
import net.bukkit.elementalmaster.item.FireResistanceUPItem;
import net.bukkit.elementalmaster.item.AbsorptionUPItem;
import net.bukkit.elementalmaster.item.ALLUPItem;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class UpsProcedureProcedure extends ElementalmasterModElements.ModElement {
	public UpsProcedureProcedure(ElementalmasterModElements instance) {
		super(instance, 421);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure UpsProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(HealUPItem.block, (int) (1))) : false)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(HealUPItem.block, (int) (1)).getItem() == p.getItem(),
						(int) 1);
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, (int) 1, (int) 0, (false), (false)));
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(StrengthUPItem.block, (int) (1)))
				: false)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(StrengthUPItem.block, (int) (1)).getItem() == p.getItem(),
						(int) 1);
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 600, (int) 0, (false), (false)));
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(HealthBoostUPItem.block, (int) (1)))
				: false)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(HealthBoostUPItem.block, (int) (1)).getItem() == p.getItem(),
						(int) 1);
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HEALTH_BOOST, (int) 1200, (int) 0, (false), (false)));
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(ResistanceUPItem.block, (int) (1)))
				: false)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(ResistanceUPItem.block, (int) (1)).getItem() == p.getItem(),
						(int) 1);
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 600, (int) 0, (false), (false)));
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(RespirationUPItem.block, (int) (1)))
				: false)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(RespirationUPItem.block, (int) (1)).getItem() == p.getItem(),
						(int) 1);
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, (int) 600, (int) 0, (false), (false)));
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(FireResistanceUPItem.block, (int) (1)))
				: false)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory
						.clearMatchingItems(p -> new ItemStack(FireResistanceUPItem.block, (int) (1)).getItem() == p.getItem(), (int) 1);
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, (int) 600, (int) 0, (false), (false)));
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(SpeedUPItem.block, (int) (1)))
				: false)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(SpeedUPItem.block, (int) (1)).getItem() == p.getItem(),
						(int) 1);
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 600, (int) 0, (false), (false)));
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(AbsorptionUPItem.block, (int) (1)))
				: false)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(AbsorptionUPItem.block, (int) (1)).getItem() == p.getItem(),
						(int) 1);
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 600, (int) 0, (false), (false)));
		}
		if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(ALLUPItem.block, (int) (1))) : false)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(ALLUPItem.block, (int) (1)).getItem() == p.getItem(),
						(int) 1);
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, (int) 1, (int) 0, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, (int) 600, (int) 0, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 600, (int) 0, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, (int) 600, (int) 0, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 600, (int) 0, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 600, (int) 0, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 600, (int) 0, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 600, (int) 0, (false), (false)));
		}
		if (((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(ManaUPItem.block, (int) (1))) : false)) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).inventory.clearMatchingItems(p -> new ItemStack(ManaUPItem.block, (int) (1)).getItem() == p.getItem(),
						(int) 1);
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(ManaRegenerationPotion.potion, (int) 600, (int) 3, (false), (false)));
		}
	}
}
