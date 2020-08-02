package net.bukkit.elementalmaster.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.Entity;

import net.bukkit.elementalmaster.ElementalmasterModElements;

@ElementalmasterModElements.ModElement.Tag
public class PlayerTick3Procedure extends ElementalmasterModElements.ModElement {
	public PlayerTick3Procedure(ElementalmasterModElements instance) {
		super(instance, 656);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure PlayerTick3!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure PlayerTick3!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure PlayerTick3!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure PlayerTick3!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if ((ForgeRegistries.BIOMES.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
				.equals(new ResourceLocation("elementalmaster:firiumforest")))) {
			if ((Math.random() < 0.25)) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, x, y, z, (int) 30, 20, 20, 20, 1);
				}
			}
			if ((Math.random() < 0.25)) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, x, y, z, (int) 30, 20, 20, 20, 1);
				}
			}
			if ((Math.random() < 0.25)) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.FLAME, x, y, z, (int) 30, 20, 20, 20, 1);
				}
			}
		}
		if ((ForgeRegistries.BIOMES.getKey(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
				.equals(new ResourceLocation("elementalmaster:darkforest")))) {
			if ((Math.random() < 0.25)) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.PORTAL, x, y, z, (int) 35, 25, 25, 25, 1);
				}
			}
			if ((Math.random() < 0.25)) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.PORTAL, x, y, z, (int) 35, 25, 25, 25, 1);
				}
			}
			if ((Math.random() < 0.25)) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.PORTAL, x, y, z, (int) 35, 25, 25, 25, 1);
				}
			}
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
    private boolean serverMana = false;
    @SubscribeEvent
    public void playerTick(TickEvent.PlayerTickEvent event) {
        if (!event.player.world.isRemote) {
            serverMana = event.player.getPersistentData().getBoolean("ShowMana");
        } else {
            event.player.getPersistentData().putBoolean("ShowMana", serverMana);
        }
    }
}
