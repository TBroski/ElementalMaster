package net.bukkit.elementalmaster.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.bukkit.elementalmaster.potion.NaturalManaRegenerationPotion;
import net.bukkit.elementalmaster.potion.AntiDarknessPotion;
import net.bukkit.elementalmaster.item.DarknessRepellerItem;
import net.bukkit.elementalmaster.block.TemporatyLightBlockBlock;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Collection;

@ElementalmasterModElements.ModElement.Tag
public class PlayerTickProcedure extends ElementalmasterModElements.ModElement {
	public PlayerTickProcedure(ElementalmasterModElements instance) {
		super(instance, 386);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure PlayerTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure PlayerTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure PlayerTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure PlayerTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure PlayerTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(NaturalManaRegenerationPotion.potion, (int) 300, (int) 0, (false), (false)));
		if ((!(((entity instanceof PlayerEntity)
				? ((PlayerEntity) entity).inventory.hasItemStack(new ItemStack(DarknessRepellerItem.block, (int) (1)))
				: false) || (new Object() {
					boolean check() {
						if (entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == AntiDarknessPotion.potion)
									return true;
							}
						}
						return false;
					}
				}.check())))) {
			if ((ForgeRegistries.BIOMES.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
					.equals(new ResourceLocation("elementalmaster:darkforest")))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 60, (int) 0, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WEAKNESS, (int) 60, (int) 0, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.WITHER, (int) 60, (int) 1, (false), (false)));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.MINING_FATIGUE, (int) 60, (int) 2, (false), (false)));
				if (entity instanceof PlayerEntity && !world.isRemote) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent(("" + ("You need a Darkness Repeller to access this biome!"))),
							(true));
				}
			}
		}
		if (((entity.getPersistentData().getBoolean("ShowManaCONFIG")) == (true))) {
			entity.getPersistentData().putBoolean("ShowMana", (true));
		}
		if (((entity.getPersistentData().getBoolean("PlayerLight")) == (true))) {
			if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), TemporatyLightBlockBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) z), TemporatyLightBlockBlock.block.getDefaultState(), 3);
			}
		}
		if ((Math.random() < 0.0018)) {
			entity.getPersistentData().putBoolean("PlayerLight", (false));
		}
		if ((!((entity.getPersistentData().getDouble("TotalMana")) > 100))) {
			entity.getPersistentData().putDouble("TotalMana", 100);
		}
		if (((entity.getPersistentData().getDouble("PlayerMana")) > (entity.getPersistentData().getDouble("TotalMana")))) {
			entity.getPersistentData().putDouble("PlayerMana", (entity.getPersistentData().getDouble("TotalMana")));
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			int i = (int) entity.getPosX();
			int j = (int) entity.getPosY();
			int k = (int) entity.getPosZ();
			java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
	private int serverMana = 0;
	@SubscribeEvent
	public void playerTick(TickEvent.PlayerTickEvent event) {
		if (!event.player.world.isRemote) {
			serverMana = event.player.getPersistentData().getInt("PlayerMana");
		} else {
			if (serverMana != 0) {
				event.player.getPersistentData().putInt("PlayerMana", serverMana);
			}
		}
	}
}
