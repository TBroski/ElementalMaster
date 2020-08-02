package net.bukkit.elementalmaster.procedures;

import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.ElementalmasterModVariables;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class ManaBonusBar2on10DisplayOverlayIngameProcedure extends ElementalmasterModElements.ModElement {
	public ManaBonusBar2on10DisplayOverlayIngameProcedure(ElementalmasterModElements instance) {
		super(instance, 669);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ManaBonusBar2on10DisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return ((((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ElementalmasterModVariables.PlayerVariables())).ManaBar) == (true))
				|| ((((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ElementalmasterModVariables.PlayerVariables())).PlayerMana) > 110)
						&& (((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new ElementalmasterModVariables.PlayerVariables())).MaxPlayerMana) == 120)));
	}
}
