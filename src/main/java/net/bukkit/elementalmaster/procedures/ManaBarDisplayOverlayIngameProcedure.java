package net.bukkit.elementalmaster.procedures;

import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.ElementalmasterModVariables;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class ManaBarDisplayOverlayIngameProcedure extends ElementalmasterModElements.ModElement {
	public ManaBarDisplayOverlayIngameProcedure(ElementalmasterModElements instance) {
		super(instance, 662);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ManaBarDisplayOverlayIngame!");
			return false;
		}
		Entity entity = (Entity) dependencies.get("entity");
		return (((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ElementalmasterModVariables.PlayerVariables())).ManaBar) == (true));
	}
}
