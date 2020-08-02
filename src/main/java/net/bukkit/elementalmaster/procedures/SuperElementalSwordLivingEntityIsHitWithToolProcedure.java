package net.bukkit.elementalmaster.procedures;

import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class SuperElementalSwordLivingEntityIsHitWithToolProcedure extends ElementalmasterModElements.ModElement {
	public SuperElementalSwordLivingEntityIsHitWithToolProcedure(ElementalmasterModElements instance) {
		super(instance, 451);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SuperElementalSwordLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getPersistentData().getDouble("PlayerMana")) >= 2)) {
			entity.getPersistentData().putDouble("PlayerMana", ((entity.getPersistentData().getDouble("PlayerMana")) - 2));
		}
	}
}
