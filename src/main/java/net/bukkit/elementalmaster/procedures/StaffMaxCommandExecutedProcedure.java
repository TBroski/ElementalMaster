package net.bukkit.elementalmaster.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.potion.StaffLevelMaxPotion;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class StaffMaxCommandExecutedProcedure extends ElementalmasterModElements.ModElement {
	public StaffMaxCommandExecutedProcedure(ElementalmasterModElements instance) {
		super(instance, 566);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure StaffMaxCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(StaffLevelMaxPotion.potion, (int) 200, (int) 0, (false), (false)));
	}
}
