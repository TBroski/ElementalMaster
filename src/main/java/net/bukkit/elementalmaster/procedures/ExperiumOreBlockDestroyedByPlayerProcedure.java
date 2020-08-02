package net.bukkit.elementalmaster.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.item.ExperienceOrbEntity;

import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class ExperiumOreBlockDestroyedByPlayerProcedure extends ElementalmasterModElements.ModElement {
	public ExperiumOreBlockDestroyedByPlayerProcedure(ElementalmasterModElements instance) {
		super(instance, 376);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ExperiumOreBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ExperiumOreBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ExperiumOreBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ExperiumOreBlockDestroyedByPlayer!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !world.getWorld().isRemote) {
			world.getWorld().addEntity(new ExperienceOrbEntity(world.getWorld(), x, y, z, (int) 10));
		}
		if (world instanceof World && !world.getWorld().isRemote) {
			world.getWorld().addEntity(new ExperienceOrbEntity(world.getWorld(), x, y, z, (int) 6));
		}
		if (world instanceof World && !world.getWorld().isRemote) {
			world.getWorld().addEntity(new ExperienceOrbEntity(world.getWorld(), x, y, z, (int) 8));
		}
		if (world instanceof World && !world.getWorld().isRemote) {
			world.getWorld().addEntity(new ExperienceOrbEntity(world.getWorld(), x, y, z, (int) 4));
		}
		if (world instanceof World && !world.getWorld().isRemote) {
			world.getWorld().addEntity(new ExperienceOrbEntity(world.getWorld(), x, y, z, (int) 5));
		}
	}
}
