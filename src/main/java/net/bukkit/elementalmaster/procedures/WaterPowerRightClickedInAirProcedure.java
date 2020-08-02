package net.bukkit.elementalmaster.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.item.WaterThrowPowerItem;
import net.bukkit.elementalmaster.ElementalmasterModVariables;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Random;
import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class WaterPowerRightClickedInAirProcedure extends ElementalmasterModElements.ModElement {
	public WaterPowerRightClickedInAirProcedure(ElementalmasterModElements instance) {
		super(instance, 536);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WaterPowerRightClickedInAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure WaterPowerRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure WaterPowerRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ElementalmasterModVariables.PlayerVariables())).PlayerMana) > 7)) {
			{
				double _setval = (double) (((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ElementalmasterModVariables.PlayerVariables())).PlayerMana) - 8);
				entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerMana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((((itemstack).getOrCreateTag().getBoolean("ManaBonus")) == (true))) {
				{
					double _setval = (double) (((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ElementalmasterModVariables.PlayerVariables())).PlayerMana) + 4);
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
				WaterThrowPowerItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 1, (float) 4, (int) 1);
			}
		}
	}
}
