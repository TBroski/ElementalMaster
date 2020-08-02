package net.bukkit.elementalmaster.procedures;

import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class FireZombiePlayerCollidesWithThisEntityProcedure extends ElementalmasterModElements.ModElement {
	public FireZombiePlayerCollidesWithThisEntityProcedure(ElementalmasterModElements instance) {
		super(instance, 511);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FireZombiePlayerCollidesWithThisEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.setFire((int) 5);
	}
}
