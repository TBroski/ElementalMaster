package net.bukkit.elementalmaster.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class StaffLevelMaxOnPotionActiveTickProcedure extends ElementalmasterModElements.ModElement {
	public StaffLevelMaxOnPotionActiveTickProcedure(ElementalmasterModElements instance) {
		super(instance, 564);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure StaffLevelMaxOnPotionActiveTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag().putDouble("ItemLevel",
				10);
		((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag().putDouble("XPAmount",
				0);
		((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
				.putString("StaffUpgradeSlot1", "No Upgrade 1");
		((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
				.putString("StaffUpgradeSlot2", "No Upgrade 2");
		((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
				.putString("StaffUpgradeSlot3", "No Upgrade 3");
		((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
				.putString("StaffSlot1Power", "Empty Slot 1");
		((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
				.putString("StaffSlot2Power", "Empty Slot 2");
		((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
				.putString("StaffSlot3Power", "Empty Slot 3");
		((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
				.putString("StaffSlot4Power", "Empty Slot 4");
		((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY).getOrCreateTag()
				.putString("StaffSlot5Power", "Empty Slot 5");
	}
}
