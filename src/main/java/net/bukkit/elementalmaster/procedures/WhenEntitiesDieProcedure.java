package net.bukkit.elementalmaster.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Entity;

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
import net.bukkit.elementalmaster.entity.FireWarriorEntity;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;
import java.util.HashMap;

@ElementalmasterModElements.ModElement.Tag
public class WhenEntitiesDieProcedure extends ElementalmasterModElements.ModElement {
	public WhenEntitiesDieProcedure(ElementalmasterModElements instance) {
		super(instance, 386);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WhenEntitiesDie!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure WhenEntitiesDie!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure WhenEntitiesDie!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure WhenEntitiesDie!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WhenEntitiesDie!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((Math.random() < 0.04)) {
			if (!world.getWorld().isRemote) {
				ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(HealUPItem.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.addEntity(entityToSpawn);
			}
		} else if ((Math.random() < 0.03)) {
			if (!world.getWorld().isRemote) {
				ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(SpeedUPItem.block, (int) (1)));
				entityToSpawn.setPickupDelay(10);
				world.addEntity(entityToSpawn);
			}
		} else if ((Math.random() < 0.02)) {
			if ((entity instanceof MobEntity)) {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(HealthBoostUPItem.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
			}
		} else if ((Math.random() < 0.005)) {
			if ((entity instanceof MobEntity)) {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(ALLUPItem.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
			}
		} else if ((Math.random() < 0.03)) {
			if ((((entity instanceof BlazeEntity) || (entity instanceof FireWarriorEntity.CustomEntity))
					|| ((entity instanceof BlazeEntity) || (entity instanceof FireWarriorEntity.CustomEntity)))) {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(FireResistanceUPItem.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
			}
		} else if ((Math.random() < 0.03)) {
			if ((entity instanceof MobEntity)) {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(AbsorptionUPItem.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
			}
		} else if ((Math.random() < 0.03)) {
			if ((entity instanceof MobEntity)) {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(ResistanceUPItem.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
			}
		} else if ((Math.random() < 0.03)) {
			if ((entity instanceof WaterMobEntity)) {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(RespirationUPItem.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
			}
		} else if ((Math.random() < 0.03)) {
			if ((entity instanceof MobEntity)) {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(StrengthUPItem.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
			}
		} else if ((Math.random() < 0.005)) {
			if ((entity instanceof MobEntity)) {
				if (!world.getWorld().isRemote) {
					ItemEntity entityToSpawn = new ItemEntity(world.getWorld(), x, y, z, new ItemStack(ManaUPItem.block, (int) (1)));
					entityToSpawn.setPickupDelay(10);
					world.addEntity(entityToSpawn);
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
