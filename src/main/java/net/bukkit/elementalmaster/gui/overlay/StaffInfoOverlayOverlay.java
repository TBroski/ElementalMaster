
package net.bukkit.elementalmaster.gui.overlay;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.bukkit.elementalmaster.procedures.StaffInfoOverlayDisplayOverlayIngameProcedure;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import com.google.common.collect.ImmutableMap;

@ElementalmasterModElements.ModElement.Tag
public class StaffInfoOverlayOverlay extends ElementalmasterModElements.ModElement {
	public StaffInfoOverlayOverlay(ElementalmasterModElements instance) {
		super(instance, 582);
	}

	@Override
	public void initElements() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void eventHandler(RenderGameOverlayEvent event) {
		if (!event.isCancelable() && event.getType() == RenderGameOverlayEvent.ElementType.HELMET) {
			int posX = (event.getWindow().getScaledWidth()) / 2;
			int posY = (event.getWindow().getScaledHeight()) / 2;
			PlayerEntity entity = Minecraft.getInstance().player;
			World world = entity.world;
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			if (StaffInfoOverlayDisplayOverlayIngameProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				Minecraft.getInstance().fontRenderer.drawString("Spell:", posX + -211, posY + 85, -3407668);
				Minecraft.getInstance().fontRenderer.drawString("Level:", posX + -211, posY + 76, -256);
				Minecraft.getInstance().fontRenderer.drawString(" " + (entity.getPersistentData().getInt("ItemLevel")) + "", posX + -181, posY + 76,
						-256);
				Minecraft.getInstance().fontRenderer.drawString("" + (entity.getPersistentData().getString("SelectedPower")) + "", posX + -181,
						posY + 85, -65281);
			}
		}
	}
}
