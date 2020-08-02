package net.bukkit.elementalmaster.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.item.MagicBallShot2Item;
import net.bukkit.elementalmaster.ElementalmasterModVariables;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Random;
import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class MagicBall2RightClickedInAirProcedure extends ElementalmasterModElements.ModElement {
	public MagicBall2RightClickedInAirProcedure(ElementalmasterModElements instance) {
		super(instance, 611);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MagicBall2RightClickedInAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure MagicBall2RightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MagicBall2RightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ElementalmasterModVariables.PlayerVariables())).PlayerMana) > 3)) {
			{
				double _setval = (double) (((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ElementalmasterModVariables.PlayerVariables())).PlayerMana) - 4);
				entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerMana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((((itemstack).getOrCreateTag().getBoolean("ManaBonus")) == (true))) {
				{
					double _setval = (double) (((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ElementalmasterModVariables.PlayerVariables())).PlayerMana) + 2);
					entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerMana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			(itemstack).getOrCreateTag().putDouble("XPAmount", (((itemstack).getOrCreateTag().getDouble("XPAmount")) - 1));
			if ((((itemstack).getOrCreateTag().getBoolean("XPBonus")) == (true))) {
				(itemstack).getOrCreateTag().putDouble("XPAmount", (((itemstack).getOrCreateTag().getDouble("XPAmount")) - 2));
			}
			if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
				MagicBallShot2Item.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 1, (float) 4, (int) 0.75);
			}
		}
	}
}
