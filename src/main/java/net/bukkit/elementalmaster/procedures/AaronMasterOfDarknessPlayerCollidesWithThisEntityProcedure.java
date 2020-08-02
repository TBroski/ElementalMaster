package net.bukkit.elementalmaster.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class AaronMasterOfDarknessPlayerCollidesWithThisEntityProcedure extends ElementalmasterModElements.ModElement {
	public AaronMasterOfDarknessPlayerCollidesWithThisEntityProcedure(ElementalmasterModElements instance) {
		super(instance, 504);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure AaronMasterOfDarknessPlayerCollidesWithThisEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((Math.random() < 0.03)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 60, (int) 0, (false), (false)));
		}
	}
}
