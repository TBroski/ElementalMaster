package net.bukkit.elementalmaster.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.monster.ZombiePigmanEntity;
import net.minecraft.entity.monster.MagmaCubeEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.entity.TheDemonLordEntity;
import net.bukkit.elementalmaster.entity.FireZombieEntity;
import net.bukkit.elementalmaster.entity.FireWarriorEntity;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class WaterThrowPowerBulletHitsLivingEntityProcedure extends ElementalmasterModElements.ModElement {
	public WaterThrowPowerBulletHitsLivingEntityProcedure(ElementalmasterModElements instance) {
		super(instance, 543);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WaterThrowPowerBulletHitsLivingEntity!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (((((entity instanceof FireWarriorEntity.CustomEntity) || (entity instanceof FireZombieEntity.CustomEntity))
				|| ((entity instanceof TheDemonLordEntity.CustomEntity) || (entity instanceof BlazeEntity)))
				|| ((entity instanceof MagmaCubeEntity) || (entity instanceof ZombiePigmanEntity)))) {
			entity.attackEntityFrom(DamageSource.GENERIC, (float) 10);
		}
	}
}
