package net.bukkit.elementalmaster.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class ManaCommandExecutedProcedure extends ElementalmasterModElements.ModElement {
	public ManaCommandExecutedProcedure(ElementalmasterModElements instance) {
		super(instance, 557);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ManaCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote) {
			((PlayerEntity) entity)
					.sendStatusMessage(new StringTextComponent((("Mana =") + "" + ((entity.getPersistentData().getDouble("PlayerMana"))))), (true));
		}
	}
}
