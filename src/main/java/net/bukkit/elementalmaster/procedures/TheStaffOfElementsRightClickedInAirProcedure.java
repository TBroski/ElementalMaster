package net.bukkit.elementalmaster.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.item.TheStaffOfElementsItem;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;
import java.util.HashMap;

@ElementalmasterModElements.ModElement.Tag
public class TheStaffOfElementsRightClickedInAirProcedure extends ElementalmasterModElements.ModElement {
	public TheStaffOfElementsRightClickedInAirProcedure(ElementalmasterModElements instance) {
		super(instance, 616);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TheStaffOfElementsRightClickedInAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure TheStaffOfElementsRightClickedInAir!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure TheStaffOfElementsRightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure TheStaffOfElementsRightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure TheStaffOfElementsRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure TheStaffOfElementsRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(TheStaffOfElementsItem.block, (int) (1)).getItem())) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
			}
		} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(TheStaffOfElementsItem.block, (int) (1)).getItem())) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).swing(Hand.OFF_HAND, true);
			}
		}
		if ((entity.isSneaking())) {
			if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) < 7)) {
				(itemstack).getOrCreateTag().putDouble("PowerChoice", (((itemstack).getOrCreateTag().getDouble("PowerChoice")) + 1));
				if (((((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 1) || (((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 2))
						|| (((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 3))
						&& (((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 3))) {
					if ((((itemstack).getOrCreateTag().getBoolean("BonusSlot")) == (true))) {
						(itemstack).getOrCreateTag().putDouble("PowerChoice", 1);
					} else if ((((itemstack).getOrCreateTag().getBoolean("BonusSlot")) == (false))) {
						(itemstack).getOrCreateTag().putDouble("PowerChoice", 2);
					}
				} else if ((((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 4)
						|| (((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 5))
						&& (((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 4))) {
					if ((((itemstack).getOrCreateTag().getBoolean("BonusSlot")) == (true))) {
						(itemstack).getOrCreateTag().putDouble("PowerChoice", 1);
					} else if ((((itemstack).getOrCreateTag().getBoolean("BonusSlot")) == (false))) {
						(itemstack).getOrCreateTag().putDouble("PowerChoice", 2);
					}
				} else if ((((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 6)
						|| (((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 7))
						&& (((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 5))) {
					if ((((itemstack).getOrCreateTag().getBoolean("BonusSlot")) == (true))) {
						(itemstack).getOrCreateTag().putDouble("PowerChoice", 1);
					} else if ((((itemstack).getOrCreateTag().getBoolean("BonusSlot")) == (false))) {
						(itemstack).getOrCreateTag().putDouble("PowerChoice", 2);
					}
				} else if ((((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 8)
						|| (((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 9))
						&& (((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 6))) {
					if ((((itemstack).getOrCreateTag().getBoolean("BonusSlot")) == (true))) {
						(itemstack).getOrCreateTag().putDouble("PowerChoice", 1);
					} else if ((((itemstack).getOrCreateTag().getBoolean("BonusSlot")) == (false))) {
						(itemstack).getOrCreateTag().putDouble("PowerChoice", 2);
					}
				} else if (((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 10)
						&& (((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 7))) {
					if ((((itemstack).getOrCreateTag().getBoolean("BonusSlot")) == (true))) {
						(itemstack).getOrCreateTag().putDouble("PowerChoice", 1);
					} else if ((((itemstack).getOrCreateTag().getBoolean("BonusSlot")) == (false))) {
						(itemstack).getOrCreateTag().putDouble("PowerChoice", 2);
					}
				} else if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 7)) {
					(itemstack).getOrCreateTag().putDouble("PowerChoice", 2);
				}
				if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 2)) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + ("Switched Power to ONE"))), (true));
					}
				}
				if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 3)) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + ("Switched Power to TWO"))), (true));
					}
				}
				if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 4)) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + ("Switched Power to THREE"))), (true));
					}
				}
				if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 5)) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + ("Switched Power to FOUR"))), (true));
					}
				}
				if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 6)) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + ("Switched Power to FIVE"))), (true));
					}
				}
				if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 1)) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote) {
						((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + ("Switched Power to BONUS SLOT"))), (true));
					}
				}
			}
		}
		if ((!(entity.isSneaking()))) {
			if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 1)) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("itemstack", itemstack);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					BonusSlot1ElementalStaffProcedure.executeProcedure($_dependencies);
				}
			}
			if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 2)) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("itemstack", itemstack);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					Slot1ElementalStaffProcedure.executeProcedure($_dependencies);
				}
			}
			if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 3)) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("itemstack", itemstack);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					Slot2ElementalStaffProcedure.executeProcedure($_dependencies);
				}
			}
			if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 4)) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("itemstack", itemstack);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					Slot3ElementalStaffProcedure.executeProcedure($_dependencies);
				}
			}
			if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 5)) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("itemstack", itemstack);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					Slot4ElementalStaffProcedure.executeProcedure($_dependencies);
				}
			}
			if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 6)) {
				{
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("itemstack", itemstack);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("world", world);
					Slot5ElementalStaffProcedure.executeProcedure($_dependencies);
				}
			}
		}
	}
}
