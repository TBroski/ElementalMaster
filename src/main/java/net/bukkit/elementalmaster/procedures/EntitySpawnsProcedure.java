package net.bukkit.elementalmaster.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.monster.ZombiePigmanEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.monster.MagmaCubeEntity;
import net.minecraft.entity.monster.HuskEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.entity.TheDemonLordEntity;
import net.bukkit.elementalmaster.entity.MummyEntity;
import net.bukkit.elementalmaster.entity.FireZombieEntity;
import net.bukkit.elementalmaster.entity.FireWarriorEntity;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;
import java.util.HashMap;

@ElementalmasterModElements.ModElement.Tag
public class EntitySpawnsProcedure extends ElementalmasterModElements.ModElement {
	public EntitySpawnsProcedure(ElementalmasterModElements instance) {
		super(instance, 684);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure EntitySpawns!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof WaterMobEntity)) {
			entity.getPersistentData().putString("ElementType", "Water");
		}
		if (((((entity instanceof FireWarriorEntity.CustomEntity) || (entity instanceof FireZombieEntity.CustomEntity))
				|| ((entity instanceof TheDemonLordEntity.CustomEntity) || (entity instanceof ZombiePigmanEntity)))
				|| (((entity instanceof WitherSkeletonEntity) || (entity instanceof MagmaCubeEntity))
						|| ((entity instanceof BlazeEntity) || (entity instanceof GhastEntity))))) {
			entity.getPersistentData().putString("ElementType", "Fire");
		}
		if (((entity instanceof MummyEntity.CustomEntity) || (entity instanceof HuskEntity))) {
			entity.getPersistentData().putString("ElementType", "Lightning");
		}
	}

	@SubscribeEvent
	public void onEntitySpawned(EntityJoinWorldEvent event) {
		Entity entity = event.getEntity();
		double i = entity.getPosX();
		double j = entity.getPosY();
		double k = entity.getPosZ();
		World world = event.getWorld().getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
