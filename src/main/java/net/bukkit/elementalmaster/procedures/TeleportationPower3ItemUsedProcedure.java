package net.bukkit.elementalmaster.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.item.TeleportationStaffItem;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Random;
import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class TeleportationPower3ItemUsedProcedure extends ElementalmasterModElements.ModElement {
	public TeleportationPower3ItemUsedProcedure(ElementalmasterModElements instance) {
		super(instance, 600);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TeleportationPower3ItemUsed!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure TeleportationPower3ItemUsed!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TeleportationPower3ItemUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		IWorld world = (IWorld) dependencies.get("world");
		if (((entity.getPersistentData().getDouble("PlayerMana")) > 11)) {
			entity.getPersistentData().putDouble("PlayerMana", ((entity.getPersistentData().getDouble("PlayerMana")) - 12));
			(itemstack).getOrCreateTag().putDouble("XPAmount", (((itemstack).getOrCreateTag().getDouble("XPAmount")) - 1));
			if ((((itemstack).getOrCreateTag().getBoolean("XPBonus")) == (true))) {
				(itemstack).getOrCreateTag().putDouble("XPAmount", (((itemstack).getOrCreateTag().getDouble("XPAmount")) - 2));
			}
			if ((((itemstack).getOrCreateTag().getBoolean("ManaBonus")) == (true))) {
				entity.getPersistentData().putDouble("PlayerMana", ((entity.getPersistentData().getDouble("PlayerMana")) + 6));
			}
			if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
				TeleportationStaffItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 12, (float) 0, (int) 0);
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 30);
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
		}
	}
}
