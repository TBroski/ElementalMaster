package net.bukkit.elementalmaster.procedures;

import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.function.Supplier;
import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class RecuperateUpgradedHandProcedure extends ElementalmasterModElements.ModElement {
	public RecuperateUpgradedHandProcedure(ElementalmasterModElements instance) {
		super(instance, 528);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure RecuperateUpgradedHand!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (_ent instanceof ServerPlayerEntity) {
				Container _current = ((ServerPlayerEntity) _ent).openContainer;
				if (_current instanceof Supplier) {
					Object invobj = ((Supplier) _current).get();
					if (invobj instanceof Map) {
						((Slot) ((Map) invobj).get((int) (1))).decrStackSize((int) (1));
						_current.detectAndSendChanges();
					}
				}
			}
		}
	}
}
