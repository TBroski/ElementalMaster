package net.bukkit.elementalmaster.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class TagvaluesCommandExecutedProcedure extends ElementalmasterModElements.ModElement {
	public TagvaluesCommandExecutedProcedure(ElementalmasterModElements instance) {
		super(instance, 529);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TagvaluesCommandExecuted!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure TagvaluesCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (entity instanceof PlayerEntity && !entity.world.isRemote) {
			((PlayerEntity) entity)
					.sendStatusMessage(new StringTextComponent((("PlayerMana: ") + "" + ((entity.getPersistentData().getDouble("PlayerMana"))) + ""
							+ ("PowerChoice:") + "" + (((itemstack).getOrCreateTag().getDouble("PowerChoice"))) + "" + ("XPAmount: ") + ""
							+ (((itemstack).getOrCreateTag().getDouble("XPAmount"))) + "" + ("ItemLevel: ") + ""
							+ (((itemstack).getOrCreateTag().getDouble("ItemLevel"))))), (true));
		}
	}
}
