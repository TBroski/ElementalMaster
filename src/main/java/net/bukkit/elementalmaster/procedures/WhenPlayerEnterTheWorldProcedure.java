package net.bukkit.elementalmaster.procedures;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.potion.NaturalManaRegenerationPotion;
import net.bukkit.elementalmaster.item.ElementalGuideItem;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;
import java.util.HashMap;

@ElementalmasterModElements.ModElement.Tag
public class WhenPlayerEnterTheWorldProcedure extends ElementalmasterModElements.ModElement {
	public WhenPlayerEnterTheWorldProcedure(ElementalmasterModElements instance) {
		super(instance, 349);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WhenPlayerEnterTheWorld!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity)
					.addPotionEffect(new EffectInstance(NaturalManaRegenerationPotion.potion, (int) 999999, (int) 0, (false), (false)));
		if ((!((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(ElementalGuideItem.block, (int) (1)))
				: false))) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(ElementalGuideItem.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		}
		entity.getPersistentData().putBoolean("ShowMana", (true));
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		Entity entity = event.getPlayer();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", entity.getPosX());
		dependencies.put("y", entity.getPosY());
		dependencies.put("z", entity.getPosZ());
		dependencies.put("world", entity.world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
