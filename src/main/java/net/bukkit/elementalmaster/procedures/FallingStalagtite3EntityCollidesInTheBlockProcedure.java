package net.bukkit.elementalmaster.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.item.TheStaffOfElementsItem;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class FallingStalagtite3EntityCollidesInTheBlockProcedure extends ElementalmasterModElements.ModElement {
	public FallingStalagtite3EntityCollidesInTheBlockProcedure(ElementalmasterModElements instance) {
		super(instance, 655);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure FallingStalagtite3EntityCollidesInTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((((entity.getPersistentData().getString("SelectedPower"))).equals("\u00A7bIce Stalagtite \u00A7fLvl 1"))
				|| ((((entity.getPersistentData().getString("SelectedPower"))).equals("\u00A7bIce Stalagtite \u00A7dLvl 2"))
						|| (((entity.getPersistentData().getString("SelectedPower"))).equals("\u00A7bIce Stalagtite \u00A75Lvl 3"))))
				&& (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(TheStaffOfElementsItem.block, (int) (1)).getItem()))) {
			entity.attackEntityFrom(DamageSource.FALLING_BLOCK, (float) 20);
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 20, (int) 5, (false), (false)));
		}
	}
}
