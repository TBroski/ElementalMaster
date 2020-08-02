package net.bukkit.elementalmaster.procedures;

import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.potion.ManaRegenerationPotion;
import net.bukkit.elementalmaster.ElementalmasterModVariables;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;
import java.util.Collection;

@ElementalmasterModElements.ModElement.Tag
public class ManaRegenerationOnPotionActiveTickProcedure extends ElementalmasterModElements.ModElement {
	public ManaRegenerationOnPotionActiveTickProcedure(ElementalmasterModElements instance) {
		super(instance, 423);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ManaRegenerationOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((new Object() {
			int check(LivingEntity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = _entity.getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == ManaRegenerationPotion.potion)
							return effect.getAmplifier();
					}
				}
				return 0;
			}
		}.check((LivingEntity) entity)) == 1)) {
			if ((Math.random() < 0.01)) {
				if ((((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ElementalmasterModVariables.PlayerVariables())).PlayerMana) < ((entity
								.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ElementalmasterModVariables.PlayerVariables())).MaxPlayerMana))) {
					{
						double _setval = (double) (((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ElementalmasterModVariables.PlayerVariables())).PlayerMana) + 1);
						entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.PlayerMana = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (((new Object() {
			int check(LivingEntity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = _entity.getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == ManaRegenerationPotion.potion)
							return effect.getAmplifier();
					}
				}
				return 0;
			}
		}.check((LivingEntity) entity)) == 2)) {
			if ((Math.random() < 0.02)) {
				if ((((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ElementalmasterModVariables.PlayerVariables())).PlayerMana) < ((entity
								.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ElementalmasterModVariables.PlayerVariables())).MaxPlayerMana))) {
					{
						double _setval = (double) (((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ElementalmasterModVariables.PlayerVariables())).PlayerMana) + 1);
						entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.PlayerMana = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (((new Object() {
			int check(LivingEntity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = _entity.getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == ManaRegenerationPotion.potion)
							return effect.getAmplifier();
					}
				}
				return 0;
			}
		}.check((LivingEntity) entity)) == 3)) {
			if ((Math.random() < 0.03)) {
				if ((((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ElementalmasterModVariables.PlayerVariables())).PlayerMana) < ((entity
								.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ElementalmasterModVariables.PlayerVariables())).MaxPlayerMana))) {
					{
						double _setval = (double) (((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ElementalmasterModVariables.PlayerVariables())).PlayerMana) + 1);
						entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.PlayerMana = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		} else if (((new Object() {
			int check(LivingEntity _entity) {
				if (_entity instanceof LivingEntity) {
					Collection<EffectInstance> effects = _entity.getActivePotionEffects();
					for (EffectInstance effect : effects) {
						if (effect.getPotion() == ManaRegenerationPotion.potion)
							return effect.getAmplifier();
					}
				}
				return 0;
			}
		}.check((LivingEntity) entity)) > 3)) {
			if ((Math.random() < 0.05)) {
				if ((((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ElementalmasterModVariables.PlayerVariables())).PlayerMana) < ((entity
								.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ElementalmasterModVariables.PlayerVariables())).MaxPlayerMana))) {
					{
						double _setval = (double) (((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ElementalmasterModVariables.PlayerVariables())).PlayerMana) + 1);
						entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.PlayerMana = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}
}
