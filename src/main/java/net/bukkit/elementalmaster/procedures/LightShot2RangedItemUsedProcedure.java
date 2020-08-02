package net.bukkit.elementalmaster.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.item.LightShotItem;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Random;
import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class LightShot2RangedItemUsedProcedure extends ElementalmasterModElements.ModElement {
	public LightShot2RangedItemUsedProcedure(ElementalmasterModElements instance) {
		super(instance, 608);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure LightShot2RangedItemUsed!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure LightShot2RangedItemUsed!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure LightShot2RangedItemUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		IWorld world = (IWorld) dependencies.get("world");
		if (((entity.getPersistentData().getDouble("PlayerMana")) > 3)) {
			entity.getPersistentData().putDouble("PlayerMana", ((entity.getPersistentData().getDouble("PlayerMana")) - 4));
			if ((((itemstack).getOrCreateTag().getDouble("XPAmount")) > 0)) {
				(itemstack).getOrCreateTag().putDouble("XPAmount", (((itemstack).getOrCreateTag().getDouble("XPAmount")) - 1));
			}
			if ((((itemstack).getOrCreateTag().getBoolean("XPBonus")) == (true))) {
				(itemstack).getOrCreateTag().putDouble("XPAmount", (((itemstack).getOrCreateTag().getDouble("XPAmount")) - 2));
			}
			if ((((itemstack).getOrCreateTag().getBoolean("ManaBonus")) == (true))) {
				entity.getPersistentData().putDouble("PlayerMana", ((entity.getPersistentData().getDouble("PlayerMana")) + 2));
			}
			if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
				LightShotItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 20, (float) 1, (int) 0);
			}
		}
	}
}
