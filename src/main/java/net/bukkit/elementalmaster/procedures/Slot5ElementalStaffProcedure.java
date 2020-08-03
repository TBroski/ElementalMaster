package net.bukkit.elementalmaster.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;
import java.util.HashMap;

@ElementalmasterModElements.ModElement.Tag
public class Slot5ElementalStaffProcedure extends ElementalmasterModElements.ModElement {
	public Slot5ElementalStaffProcedure(ElementalmasterModElements instance) {
		super(instance, 624);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure Slot5ElementalStaff!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure Slot5ElementalStaff!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure Slot5ElementalStaff!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure Slot5ElementalStaff!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure Slot5ElementalStaff!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure Slot5ElementalStaff!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A76Fireball Shot \u00A7fLvl 1"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("world", world);
				FireThrowPowerItemRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A76Fireball Shot \u00A7dLvl 2"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("world", world);
				FireThrowPower2ItemRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A76Fireball Shot \u00A75Lvl 3"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("world", world);
				FireThrowPower3ItemRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A7bIce Stalagtite \u00A7fLvl 1"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				IceStalagtitePowerRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A7bIce Stalagtite \u00A7dLvl 2"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				IceStalagtitePower2RightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A7bIce Stalagtite \u00A75Lvl 3"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				IceStalagtitePower3RightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A7eLightning Strike \u00A7fLvl 1"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				LightningStrikePowerRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A7eLightning Strike \u00A7dLvl 2"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				LightningStrikePower2RightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A7eLightning Strike \u00A75Lvl 3"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				OmegaLightningStrikePowerRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A79Waterball Shot \u00A7fLvl 1"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("world", world);
				WaterPowerRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A79Waterball Shot \u00A7dLvl 2"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("world", world);
				WaterPower2RightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A79Waterball Shot \u00A75Lvl 3"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("world", world);
				WaterPower3RightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A76Earthquake \u00A7fLvl 1"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				EarthPowerRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A76Earthquake \u00A7dLvl 2"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				EarthPower2RightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A76Earthquake \u00A75Lvl 3"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				EarthPower3RightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A72Spiky Plant \u00A7fLvl 1"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				NaturePowerRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A72Spiky Plant \u00A7dLvl 2"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				NaturePower2RightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A72Spiky Plant \u00A75Lvl 3"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				NaturePower3RightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A75Teleportation \u00A7fLvl 1"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("world", world);
				TeleportationPower1ItemUsedProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A75Teleportation \u00A7dLvl 2"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("world", world);
				TeleportationPower2ItemUsedProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A75Teleportation \u00A75Lvl 3"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("world", world);
				TeleportationPower3ItemUsedProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A7eLight Shot \u00A7dLvl 2"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("world", world);
				LightShot2RangedItemUsedProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A7eLight Shot \u00A75Lvl 3"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("world", world);
				LightShot3RangedItemUsedProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A75Magic Ball \u00A7fLvl 1"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("world", world);
				MagicBallRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A75Magic Ball \u00A7dLvl 2"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("world", world);
				MagicBall2RightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A75Magic Ball \u00A75Lvl 3"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("world", world);
				MagicBall3RightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A75Magic Laser \u00A75Lvl 3"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				MagicLaserRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A75Magic Laser \u00A75Lvl 3"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				MagicLaser2RightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A75Magic Laser \u00A75Lvl 3"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				MagicLaser3RightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A7dHealing \u00A7fLvl 1"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				HealingPowerRightClickedInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A7dHealing \u00A7dLvl 2"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				HealingPower2RightClickInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A7dHealing \u00A75Lvl 3"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				HealingPower3RightClickInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A73Warp \u00A7fLvl 1"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				HealingPower3RightClickInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A73Warp \u00A7dLvl 2"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				HealingPower3RightClickInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A73Warp \u00A75Lvl 3"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				HealingPower3RightClickInAirProcedure.executeProcedure($_dependencies);
			}
		} else if (((((itemstack).getOrCreateTag().getString("StaffSlot5Power"))).equals("\u00A7eLight Shot \u00A7fLvl 1"))) {
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				$_dependencies.put("world", world);
				LightShotRangedItemUsedProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
