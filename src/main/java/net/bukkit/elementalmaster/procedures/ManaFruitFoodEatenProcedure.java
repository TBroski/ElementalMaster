package net.bukkit.elementalmaster.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.ElementalmasterModVariables;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class ManaFruitFoodEatenProcedure extends ElementalmasterModElements.ModElement {
	public ManaFruitFoodEatenProcedure(ElementalmasterModElements instance) {
		super(instance, 569);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ManaFruitFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ElementalmasterModVariables.PlayerVariables())).MaxPlayerMana) < 150)) {
			{
				double _setval = (double) (((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ElementalmasterModVariables.PlayerVariables())).MaxPlayerMana) + 10);
				entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.MaxPlayerMana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = (double) ((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ElementalmasterModVariables.PlayerVariables())).MaxPlayerMana);
				entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerMana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your total mana has increased by 10!"), (true));
			}
		}
		if ((((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ElementalmasterModVariables.PlayerVariables())).MaxPlayerMana) >= 150)) {
			if (entity instanceof PlayerEntity && !entity.world.isRemote) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("You can't increase your Mana anymore with this fruit!"), (true));
			}
		}
	}
}
