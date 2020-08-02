
package net.bukkit.elementalmaster.gui.overlay;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.Minecraft;

import net.bukkit.elementalmaster.item.TheStaffOfElementsItem;
import net.bukkit.elementalmaster.ElementalmasterModElements;

@ElementalmasterModElements.ModElement.Tag
public class StaffXPInfoOverlayOverlay extends ElementalmasterModElements.ModElement {
	public StaffXPInfoOverlayOverlay(ElementalmasterModElements instance) {
		super(instance, 552);
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
			int x = (int) entity.getPosX();
			int y = (int) entity.getPosY();
			int z = (int) entity.getPosZ();
			if ((((((entity.getPersistentData().getDouble("ItemLevel")) < 10) && ((entity.getPersistentData().getDouble("ItemLevel")) >= 1))
					&& (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
							.getItem() == new ItemStack(TheStaffOfElementsItem.block, (int) (1)).getItem()))
					&& ((entity.getPersistentData().getBoolean("ShowMana")) == (true)))) {
				Minecraft.getInstance().fontRenderer.drawString("XP Left: ", posX + -211, posY + 67, -16711936);
				Minecraft.getInstance().fontRenderer.drawString("" + (entity.getPersistentData().getInt("XPAmount")) + "", posX + -171, posY + 67,
						-16711936);
			}
		}
	}
}
