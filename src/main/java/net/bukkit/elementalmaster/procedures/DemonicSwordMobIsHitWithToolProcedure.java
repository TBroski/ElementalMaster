package net.bukkit.elementalmaster.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.monster.StrayEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.entity.IceQueenEntity;
import net.bukkit.elementalmaster.entity.IceBlazeEntity;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class DemonicSwordMobIsHitWithToolProcedure extends ElementalmasterModElements.ModElement {
	public DemonicSwordMobIsHitWithToolProcedure(ElementalmasterModElements instance) {
		super(instance, 382);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure DemonicSwordMobIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity instanceof StrayEntity) || (entity instanceof IceBlazeEntity.CustomEntity))
				|| (entity instanceof IceQueenEntity.CustomEntity))) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 20);
		}
	}
}
