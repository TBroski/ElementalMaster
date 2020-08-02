package net.bukkit.elementalmaster.procedures;

import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class PlayerLightRightClickedInAirProcedure extends ElementalmasterModElements.ModElement {
	public PlayerLightRightClickedInAirProcedure(ElementalmasterModElements instance) {
		super(instance, 552);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PlayerLightRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putBoolean("PlayerLight", (true));
	}
}
