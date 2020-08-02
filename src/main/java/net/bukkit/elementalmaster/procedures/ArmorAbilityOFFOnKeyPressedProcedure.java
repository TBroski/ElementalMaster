package net.bukkit.elementalmaster.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.ElementalmasterModVariables;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class ArmorAbilityOFFOnKeyPressedProcedure extends ElementalmasterModElements.ModElement {
	public ArmorAbilityOFFOnKeyPressedProcedure(ElementalmasterModElements instance) {
		super(instance, 455);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ArmorAbilityOFFOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			boolean _setval = (boolean) (false);
			entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ArmorPower = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + ("Set Armor Abilities to FALSE"))), (true));
		}
	}
}
