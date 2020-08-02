package net.bukkit.elementalmaster.procedures;

import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class SummonedSpikesOnEntityTickUpdateProcedure extends ElementalmasterModElements.ModElement {
	public SummonedSpikesOnEntityTickUpdateProcedure(ElementalmasterModElements instance) {
		super(instance, 439);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SummonedSpikesOnEntityTickUpdate!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((Math.random() < 0.05)) {
			if (!entity.world.isRemote)
				entity.remove();
		}
	}
}
