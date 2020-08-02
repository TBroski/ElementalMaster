
package net.bukkit.elementalmaster.gui.overlay;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;

import net.bukkit.elementalmaster.procedures.ManaBonusBar2on10DisplayOverlayIngameProcedure;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

import com.google.common.collect.ImmutableMap;

@ElementalmasterModElements.ModElement.Tag
public class ManaBonusBar2on10Overlay extends ElementalmasterModElements.ModElement {
	public ManaBonusBar2on10Overlay(ElementalmasterModElements instance) {
		super(instance, 572);
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
			if (ManaBonusBar2on10DisplayOverlayIngameProcedure.executeProcedure(ImmutableMap.of("entity", entity))) {
				RenderSystem.disableDepthTest();
				RenderSystem.depthMask(false);
				RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
						GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
				RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
				RenderSystem.disableAlphaTest();
				Minecraft.getInstance().getTextureManager().bindTexture(new ResourceLocation("elementalmaster:textures/bonusmanabar2on10.png"));
				Minecraft.getInstance().ingameGUI.blit(posX + -209, posY + 111, 0, 0, 256, 256);
				RenderSystem.depthMask(true);
				RenderSystem.enableDepthTest();
				RenderSystem.enableAlphaTest();
				RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
			}
		}
	}
}
