package net.bukkit.elementalmaster.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class ShowManaTRUEOnKeyPressedProcedure extends ElementalmasterModElements.ModElement {
	public ShowManaTRUEOnKeyPressedProcedure(ElementalmasterModElements instance) {
		super(instance, 457);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ShowManaTRUEOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.getPersistentData().putBoolean("ShowManaCONFIG", (true));
		if (entity instanceof PlayerEntity && !entity.world.isRemote) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + ("Set Mana Show to TRUE"))), (true));
		}
	}
}
