package net.bukkit.elementalmaster.procedures;

import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class InfiniteManaOnPotionActiveTickProcedure extends ElementalmasterModElements.ModElement {
	public InfiniteManaOnPotionActiveTickProcedure(ElementalmasterModElements instance) {
		super(instance, 523);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure InfiniteManaOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putDouble("PlayerMana", 100);
	}
}
