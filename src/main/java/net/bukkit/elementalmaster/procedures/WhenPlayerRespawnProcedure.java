package net.bukkit.elementalmaster.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.potion.NaturalManaRegenerationPotion;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;
import java.util.HashMap;

@ElementalmasterModElements.ModElement.Tag
public class WhenPlayerRespawnProcedure extends ElementalmasterModElements.ModElement {
	public WhenPlayerRespawnProcedure(ElementalmasterModElements instance) {
		super(instance, 431);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WhenPlayerRespawn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity)
					.addPotionEffect(new EffectInstance(NaturalManaRegenerationPotion.potion, (int) 9999999, (int) 0, (false), (false)));
	}

	@SubscribeEvent
	public void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
		Entity entity = event.getPlayer();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", entity.getPosX());
		dependencies.put("y", entity.getPosY());
		dependencies.put("z", entity.getPosZ());
		dependencies.put("world", entity.world);
		dependencies.put("entity", entity);
		dependencies.put("endconquered", event.isEndConquered());
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
