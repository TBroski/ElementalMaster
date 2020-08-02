package net.bukkit.elementalmaster.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class TheStaffOfElementsToolInHandTickProcedure extends ElementalmasterModElements.ModElement {
	public TheStaffOfElementsToolInHandTickProcedure(ElementalmasterModElements instance) {
		super(instance, 584);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TheStaffOfElementsToolInHandTick!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure TheStaffOfElementsToolInHandTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if ((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 0)) {
			(itemstack).getOrCreateTag().putDouble("XPAmount", 100);
			(itemstack).getOrCreateTag().putDouble("ItemLevel", 1);
			(itemstack).getOrCreateTag().putString("StaffSlot1Power", "Empty Slot 1");
			(itemstack).getOrCreateTag().putString("StaffSlot2Power", "\u00A7cLocked Slot");
			(itemstack).getOrCreateTag().putString("StaffSlot3Power", "\u00A7cLocked Slot");
			(itemstack).getOrCreateTag().putString("StaffSlot4Power", "\u00A7cLocked Slot");
			(itemstack).getOrCreateTag().putString("StaffSlot5Power", "\u00A7cLocked Slot");
			(itemstack).getOrCreateTag().putString("StaffUpgradeSlot1", "\u00A7cLocked Upgrade Slot");
			(itemstack).getOrCreateTag().putString("StaffUpgradeSlot2", "\u00A7cLocked Upgrade Slot");
			(itemstack).getOrCreateTag().putString("StaffUpgradeSlot3", "\u00A7cLocked Upgrade Slot");
		}
		if ((((itemstack).getOrCreateTag().getDouble("XPAmount")) <= 0)) {
			if ((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 1)) {
				(itemstack).getOrCreateTag().putDouble("ItemLevel", 2);
				(itemstack).getOrCreateTag().putDouble("XPAmount", 150);
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Staff has level up to Level 2!"), (true));
				}
			} else if ((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 2)) {
				(itemstack).getOrCreateTag().putDouble("ItemLevel", 3);
				(itemstack).getOrCreateTag().putString("StaffUpgradeSlot1", "No Upgrade 1");
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Staff has level up to Level 3!"), (true));
				}
				(itemstack).getOrCreateTag().putDouble("XPAmount", 200);
			} else if ((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 3)) {
				(itemstack).getOrCreateTag().putDouble("ItemLevel", 4);
				(itemstack).getOrCreateTag().putDouble("XPAmount", 250);
				(itemstack).getOrCreateTag().putString("StaffSlot2Power", "Empty Slot 2");
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Staff has level up to Level 4!"), (true));
				}
			} else if ((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 4)) {
				(itemstack).getOrCreateTag().putDouble("ItemLevel", 5);
				(itemstack).getOrCreateTag().putDouble("XPAmount", 300);
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Staff has level up to Level 5!"), (true));
				}
			} else if ((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 5)) {
				(itemstack).getOrCreateTag().putDouble("ItemLevel", 6);
				(itemstack).getOrCreateTag().putDouble("XPAmount", 350);
				(itemstack).getOrCreateTag().putString("StaffUpgradeSlot2", "No Upgrade 2");
				(itemstack).getOrCreateTag().putString("StaffSlot3Power", "Empty Slot 3");
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Staff has level up to Level 6!"), (true));
				}
			} else if ((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 6)) {
				(itemstack).getOrCreateTag().putDouble("ItemLevel", 7);
				(itemstack).getOrCreateTag().putDouble("XPAmount", 400);
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Staff has level up to Level 7!"), (true));
				}
			} else if ((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 7)) {
				(itemstack).getOrCreateTag().putDouble("ItemLevel", 8);
				(itemstack).getOrCreateTag().putDouble("XPAmount", 450);
				(itemstack).getOrCreateTag().putString("StaffSlot4Power", "Empty Slot 4");
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Staff has level up to Level 8!"), (true));
				}
			} else if ((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 8)) {
				(itemstack).getOrCreateTag().putDouble("ItemLevel", 9);
				(itemstack).getOrCreateTag().putDouble("XPAmount", 500);
				(itemstack).getOrCreateTag().putString("StaffUpgradeSlot3", "No Upgrade 3");
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Staff has level up to Level 9!"), (true));
				}
			} else if ((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 9)) {
				(itemstack).getOrCreateTag().putDouble("ItemLevel", 10);
				(itemstack).getOrCreateTag().putString("StaffSlot5Power", "Empty Slot 5");
				if (entity instanceof PlayerEntity && !entity.world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Your Staff has level up to Level 10!"), (true));
				}
			}
		}
		if ((((itemstack).getOrCreateTag().getDouble("XPAmount")) <= 0)) {
			if ((((itemstack).getOrCreateTag().getDouble("ItemLevel")) == 10)) {
				(itemstack).getOrCreateTag().putDouble("XPAmount", 0);
			}
		}
		if ((((itemstack).getOrCreateTag().getDouble("PowerChoice")) == 0)) {
			(itemstack).getOrCreateTag().putDouble("PowerChoice", 2);
		}
		if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot1"))).equals("\u00A7eBonus Empty Slot"))) {
			(itemstack).getOrCreateTag().putBoolean("BonusSlot", (true));
		} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot2"))).equals("\u00A7eBonus Empty Slot"))) {
			(itemstack).getOrCreateTag().putBoolean("BonusSlot", (true));
		} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot3"))).equals("\u00A7eBonus Empty Slot"))) {
			(itemstack).getOrCreateTag().putBoolean("BonusSlot", (true));
		}
		if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot1"))).equals("\u00A7aXP Boost Upgrade"))) {
			(itemstack).getOrCreateTag().putBoolean("XPBonus", (true));
		} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot2"))).equals("\u00A7aXP Boost Upgrade"))) {
			(itemstack).getOrCreateTag().putBoolean("XPBonus", (true));
		} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot3"))).equals("\u00A7aXP Boost Upgrade"))) {
			(itemstack).getOrCreateTag().putBoolean("XPBonus", (true));
		}
		if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot1"))).equals("\u00A7d-50% Mana Upgrade"))) {
			(itemstack).getOrCreateTag().putBoolean("ManaBonus", (true));
		} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot2"))).equals("\u00A7d-50% Mana Upgrade"))) {
			(itemstack).getOrCreateTag().putBoolean("ManaBonus", (true));
		} else if (((((itemstack).getOrCreateTag().getString("StaffUpgradeSlot3"))).equals("\u00A7d-50% Mana Upgrade"))) {
			(itemstack).getOrCreateTag().putBoolean("ManaBonus", (true));
		}
	}
}
