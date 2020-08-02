package net.bukkit.elementalmaster.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.bukkit.elementalmaster.potion.FrozenEffectPotion;
import net.bukkit.elementalmaster.enchantment.MagicProtectionEnchantment;
import net.bukkit.elementalmaster.enchantment.IceAspectEnchantment;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

@ElementalmasterModElements.ModElement.Tag
public class OnEntityAttackedProcedure extends ElementalmasterModElements.ModElement {
	public OnEntityAttackedProcedure(ElementalmasterModElements instance) {
		super(instance, 659);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure OnEntityAttacked!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			System.err.println("Failed to load dependency sourceentity for procedure OnEntityAttacked!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure OnEntityAttacked!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure OnEntityAttacked!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure OnEntityAttacked!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure OnEntityAttacked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world
				.getEntitiesWithinAABB(PlayerEntity.class, new AxisAlignedBB(x - 5 / 2, y - 5 / 2, z - 5 / 2, x + 5 / 2, y + 5 / 2, z + 5 / 2), null)
				.stream().sorted(Comparator.comparing(_entcnd -> _entcnd.getDistanceSq(x, y, z))).findFirst().orElse(null)) != null)) {
			if (((EnchantmentHelper.getEnchantmentLevel(IceAspectEnchantment.enchantment,
					((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) == 1)) {
				if (((((entity.getPersistentData().getString("ElementType"))).equals("Fire"))
						|| (((entity.getPersistentData().getString("ElementType"))).equals("Water")))) {
					if ((Math.random() < 0.2)) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.addPotionEffect(new EffectInstance(FrozenEffectPotion.potion, (int) 80, (int) 0, (false), (false)));
					}
				} else {
					if ((Math.random() < 0.15)) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.addPotionEffect(new EffectInstance(FrozenEffectPotion.potion, (int) 60, (int) 0, (false), (false)));
					}
				}
			} else if (((EnchantmentHelper.getEnchantmentLevel(IceAspectEnchantment.enchantment,
					((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) == 2)) {
				if (((((entity.getPersistentData().getString("ElementType"))).equals("Fire"))
						|| (((entity.getPersistentData().getString("ElementType"))).equals("Water")))) {
					if ((Math.random() < 0.25)) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.addPotionEffect(new EffectInstance(FrozenEffectPotion.potion, (int) 100, (int) 1, (false), (false)));
					}
				} else {
					if ((Math.random() < 0.2)) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.addPotionEffect(new EffectInstance(FrozenEffectPotion.potion, (int) 80, (int) 1, (false), (false)));
					}
				}
			} else if (((EnchantmentHelper.getEnchantmentLevel(IceAspectEnchantment.enchantment,
					((sourceentity instanceof LivingEntity) ? ((LivingEntity) sourceentity).getHeldItemMainhand() : ItemStack.EMPTY))) == 3)) {
				if (((((entity.getPersistentData().getString("ElementType"))).equals("Fire"))
						|| (((entity.getPersistentData().getString("ElementType"))).equals("Water")))) {
					if ((Math.random() < 0.3)) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.addPotionEffect(new EffectInstance(FrozenEffectPotion.potion, (int) 120, (int) 2, (false), (false)));
					}
				} else {
					if ((Math.random() < 0.25)) {
						if (entity instanceof LivingEntity)
							((LivingEntity) entity)
									.addPotionEffect(new EffectInstance(FrozenEffectPotion.potion, (int) 100, (int) 2, (false), (false)));
					}
				}
			}
		}
		if ((!(sourceentity instanceof ZombieEntity))) {
			if (((((EnchantmentHelper.getEnchantmentLevel(MagicProtectionEnchantment.enchantment,
					((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(100) : ItemStack.EMPTY))) == 1)
					|| ((EnchantmentHelper.getEnchantmentLevel(MagicProtectionEnchantment.enchantment,
							((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(101) : ItemStack.EMPTY))) == 1))
					|| (((EnchantmentHelper.getEnchantmentLevel(MagicProtectionEnchantment.enchantment,
							((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(102) : ItemStack.EMPTY))) == 1)
							|| ((EnchantmentHelper.getEnchantmentLevel(MagicProtectionEnchantment.enchantment,
									((entity instanceof PlayerEntity)
											? ((PlayerEntity) entity).inventory.armorInventory.get(103)
											: ItemStack.EMPTY))) == 1)))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 0, (false), (false)));
			} else if (((((EnchantmentHelper.getEnchantmentLevel(MagicProtectionEnchantment.enchantment,
					((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(100) : ItemStack.EMPTY))) == 2)
					|| ((EnchantmentHelper.getEnchantmentLevel(MagicProtectionEnchantment.enchantment,
							((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(101) : ItemStack.EMPTY))) == 2))
					&& (((EnchantmentHelper.getEnchantmentLevel(MagicProtectionEnchantment.enchantment,
							((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(102) : ItemStack.EMPTY))) == 2)
							|| ((EnchantmentHelper.getEnchantmentLevel(MagicProtectionEnchantment.enchantment,
									((entity instanceof PlayerEntity)
											? ((PlayerEntity) entity).inventory.armorInventory.get(103)
											: ItemStack.EMPTY))) == 2)))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 1, (false), (false)));
			} else if (((((EnchantmentHelper.getEnchantmentLevel(MagicProtectionEnchantment.enchantment,
					((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(100) : ItemStack.EMPTY))) == 3)
					|| ((EnchantmentHelper.getEnchantmentLevel(MagicProtectionEnchantment.enchantment,
							((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(101) : ItemStack.EMPTY))) == 3))
					&& (((EnchantmentHelper.getEnchantmentLevel(MagicProtectionEnchantment.enchantment,
							((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(102) : ItemStack.EMPTY))) == 3)
							|| ((EnchantmentHelper.getEnchantmentLevel(MagicProtectionEnchantment.enchantment,
									((entity instanceof PlayerEntity)
											? ((PlayerEntity) entity).inventory.armorInventory.get(103)
											: ItemStack.EMPTY))) == 3)))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 2, (false), (false)));
			} else if (((((EnchantmentHelper.getEnchantmentLevel(MagicProtectionEnchantment.enchantment,
					((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(100) : ItemStack.EMPTY))) == 4)
					&& ((EnchantmentHelper.getEnchantmentLevel(MagicProtectionEnchantment.enchantment,
							((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(101) : ItemStack.EMPTY))) == 4))
					&& (((EnchantmentHelper.getEnchantmentLevel(MagicProtectionEnchantment.enchantment,
							((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(102) : ItemStack.EMPTY))) == 4)
							&& ((EnchantmentHelper.getEnchantmentLevel(MagicProtectionEnchantment.enchantment,
									((entity instanceof PlayerEntity)
											? ((PlayerEntity) entity).inventory.armorInventory.get(103)
											: ItemStack.EMPTY))) == 4)))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 3, (false), (false)));
			} else if (((((EnchantmentHelper.getEnchantmentLevel(MagicProtectionEnchantment.enchantment,
					((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(100) : ItemStack.EMPTY))) == 5)
					|| ((EnchantmentHelper.getEnchantmentLevel(MagicProtectionEnchantment.enchantment,
							((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(101) : ItemStack.EMPTY))) == 5))
					|| (((EnchantmentHelper.getEnchantmentLevel(MagicProtectionEnchantment.enchantment,
							((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).inventory.armorInventory.get(102) : ItemStack.EMPTY))) == 5)
							|| ((EnchantmentHelper.getEnchantmentLevel(MagicProtectionEnchantment.enchantment,
									((entity instanceof PlayerEntity)
											? ((PlayerEntity) entity).inventory.armorInventory.get(103)
											: ItemStack.EMPTY))) == 5)))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 10, (int) 4, (false), (false)));
			}
		}
	}

	@SubscribeEvent
	public void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			double amount = event.getAmount();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("amount", amount);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
