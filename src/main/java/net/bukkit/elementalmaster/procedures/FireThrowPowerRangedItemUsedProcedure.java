package net.bukkit.elementalmaster.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class FireThrowPowerRangedItemUsedProcedure extends ElementalmasterModElements.ModElement {
	public FireThrowPowerRangedItemUsedProcedure(ElementalmasterModElements instance) {
		super(instance, 434);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FireThrowPowerRangedItemUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((entity.getPersistentData().getDouble("PlayerMana")) >= 3)) {
			entity.getPersistentData().putDouble("PlayerMana", ((entity.getPersistentData().getDouble("PlayerMana")) - 3));
		}
		if (((entity.getPersistentData().getDouble("PlayerMana")) <= 3)) {
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, (int) 60, (int) 100, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 60, (int) 100, (false), (false)));
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 8);
		}
	}
}
