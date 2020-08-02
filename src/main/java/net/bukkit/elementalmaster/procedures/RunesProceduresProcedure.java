package net.bukkit.elementalmaster.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.bukkit.elementalmaster.potion.ManaRegenerationPotion;
import net.bukkit.elementalmaster.item.XPRune3Item;
import net.bukkit.elementalmaster.item.XPRune2Item;
import net.bukkit.elementalmaster.item.XPRune1Item;
import net.bukkit.elementalmaster.item.WaterRuneItem;
import net.bukkit.elementalmaster.item.SaturationRuneItem;
import net.bukkit.elementalmaster.item.NightVisionRuneItem;
import net.bukkit.elementalmaster.item.ManaRuneItem;
import net.bukkit.elementalmaster.item.LuckRuneItem;
import net.bukkit.elementalmaster.item.LightningRuneItem;
import net.bukkit.elementalmaster.item.InvisibilityRuneItem;
import net.bukkit.elementalmaster.item.IceRuneItem;
import net.bukkit.elementalmaster.item.HealingRuneItem;
import net.bukkit.elementalmaster.item.FlyingRuneItem;
import net.bukkit.elementalmaster.item.FireRuneItem;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;
import java.util.Collection;

@ElementalmasterModElements.ModElement.Tag
public class RunesProceduresProcedure extends ElementalmasterModElements.ModElement {
	public RunesProceduresProcedure(ElementalmasterModElements instance) {
		super(instance, 384);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure RunesProcedures!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure RunesProcedures!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure RunesProcedures!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure RunesProcedures!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure RunesProcedures!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(XPRune1Item.block, (int) (1)))
				: false)) {
			if ((Math.random() < 0.002)) {
				if (world instanceof World && !world.getWorld().isRemote) {
					world.getWorld().addEntity(new ExperienceOrbEntity(world.getWorld(), x, y, z, (int) 5));
				}
			}
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(XPRune2Item.block, (int) (1)))
				: false)) {
			if ((Math.random() < 0.004)) {
				if (world instanceof World && !world.getWorld().isRemote) {
					world.getWorld().addEntity(new ExperienceOrbEntity(world.getWorld(), x, y, z, (int) 10));
				}
			}
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(XPRune3Item.block, (int) (1)))
				: false)) {
			if ((Math.random() < 0.006)) {
				if (world instanceof World && !world.getWorld().isRemote) {
					world.getWorld().addEntity(new ExperienceOrbEntity(world.getWorld(), x, y, z, (int) 15));
				}
			}
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(FireRuneItem.block, (int) (1)))
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, (int) 600, (int) 0, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 600, (int) 1, (false), (false)));
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(IceRuneItem.block, (int) (1)))
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 600, (int) 1, (false), (false)));
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(LightningRuneItem.block, (int) (1)))
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 600, (int) 0, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 600, (int) 1, (false), (false)));
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(WaterRuneItem.block, (int) (1)))
				: false)) {
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.WATER.getDefaultState().getBlock())) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, (int) 600, (int) 0, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.DOLPHINS_GRACE, (int) 600, (int) 0, (false), (false)));
			}
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(HealingRuneItem.block, (int) (1)))
				: false)) {
			if ((!(new Object() {
				boolean check(LivingEntity _entity) {
					if (_entity instanceof LivingEntity) {
						Collection<EffectInstance> effects = _entity.getActivePotionEffects();
						for (EffectInstance effect : effects) {
							if (effect.getPotion() == Effects.REGENERATION)
								return true;
						}
					}
					return false;
				}
			}.check((LivingEntity) entity)))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 600, (int) 0, (false), (false)));
			}
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(NightVisionRuneItem.block, (int) (1)))
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, (int) 600, (int) 0, (false), (false)));
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(SaturationRuneItem.block, (int) (1)))
				: false)) {
			if ((Math.random() < 0.01)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SATURATION, (int) 1, (int) 0, (false), (false)));
			}
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(LuckRuneItem.block, (int) (1)))
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LUCK, (int) 600, (int) 2, (false), (false)));
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(InvisibilityRuneItem.block, (int) (1)))
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) 600, (int) 0, (false), (false)));
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(ManaRuneItem.block, (int) (1)))
				: false)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(ManaRegenerationPotion.potion, (int) 600, (int) 1, (false), (false)));
		}
		if (((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(FlyingRuneItem.block, (int) (1)))
				: false)) {
			if (entity instanceof PlayerEntity) {
				((PlayerEntity) entity).abilities.allowFlying = (true);
				((PlayerEntity) entity).sendPlayerAbilities();
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, (int) 600, (int) 0, (false), (false)));
		}
	}
}
