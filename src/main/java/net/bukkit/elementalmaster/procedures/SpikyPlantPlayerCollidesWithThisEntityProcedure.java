package net.bukkit.elementalmaster.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class SpikyPlantPlayerCollidesWithThisEntityProcedure extends ElementalmasterModElements.ModElement {
	public SpikyPlantPlayerCollidesWithThisEntityProcedure(ElementalmasterModElements instance) {
		super(instance, 541);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SpikyPlantPlayerCollidesWithThisEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 20, (int) 8, (false), (false)));
		entity.attackEntityFrom(DamageSource.CACTUS, (float) 1);
	}
}
