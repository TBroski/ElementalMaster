package net.bukkit.elementalmaster.procedures;

import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class ElementalPickaxeBlockDestroyedWithToolProcedure extends ElementalmasterModElements.ModElement {
	public ElementalPickaxeBlockDestroyedWithToolProcedure(ElementalmasterModElements instance) {
		super(instance, 437);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ElementalPickaxeBlockDestroyedWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getPersistentData().getDouble("PlayerMana")) >= 1)) {
			if ((Math.random() < 0.5)) {
				entity.getPersistentData().putDouble("PlayerMana", ((entity.getPersistentData().getDouble("PlayerMana")) - 1));
			}
		}
	}
}
