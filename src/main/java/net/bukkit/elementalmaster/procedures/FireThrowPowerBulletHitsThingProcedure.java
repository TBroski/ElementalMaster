package net.bukkit.elementalmaster.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class FireThrowPowerBulletHitsThingProcedure extends ElementalmasterModElements.ModElement {
	public FireThrowPowerBulletHitsThingProcedure(ElementalmasterModElements instance) {
		super(instance, 410);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure FireThrowPowerBulletHitsThing!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure FireThrowPowerBulletHitsThing!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure FireThrowPowerBulletHitsThing!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure FireThrowPowerBulletHitsThing!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.GRASS.getDefaultState().getBlock()))
				|| (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.VOID_AIR.getDefaultState().getBlock())
						|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())))
				&& (!(((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())
						|| (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.VOID_AIR.getDefaultState()
								.getBlock())
								|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.AIR.getDefaultState()
										.getBlock())))))) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), Blocks.FIRE.getDefaultState(), 3);
			if ((((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())
					|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() == Blocks.GRASS.getDefaultState()
							.getBlock()))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) y, (int) z), Blocks.FIRE.getDefaultState(), 3);
			}
			if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())
					|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() == Blocks.GRASS.getDefaultState()
							.getBlock()))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) y, (int) z), Blocks.FIRE.getDefaultState(), 3);
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() == Blocks.GRASS.getDefaultState()
							.getBlock()))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)), Blocks.FIRE.getDefaultState(), 3);
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())
					|| ((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() == Blocks.GRASS.getDefaultState()
							.getBlock()))) {
				world.setBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)), Blocks.FIRE.getDefaultState(), 3);
			}
		}
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.GRASS.getDefaultState().getBlock()))) {
			world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) z), Blocks.FIRE.getDefaultState(), 3);
			if ((((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
					.getBlock())
					|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z))).getBlock() == Blocks.GRASS.getDefaultState()
							.getBlock()))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) (y - 1), (int) z), Blocks.FIRE.getDefaultState(), 3);
			}
			if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
					.getBlock())
					|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z))).getBlock() == Blocks.GRASS.getDefaultState()
							.getBlock()))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) (y - 1), (int) z), Blocks.FIRE.getDefaultState(), 3);
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
					.getBlock())
					|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)))).getBlock() == Blocks.GRASS.getDefaultState()
							.getBlock()))) {
				world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z - 1)), Blocks.FIRE.getDefaultState(), 3);
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
					.getBlock())
					|| ((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)))).getBlock() == Blocks.GRASS.getDefaultState()
							.getBlock()))) {
				world.setBlockState(new BlockPos((int) x, (int) (y - 1), (int) (z + 1)), Blocks.FIRE.getDefaultState(), 3);
			}
		}
		if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState().getBlock())
				|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() == Blocks.GRASS.getDefaultState().getBlock()))) {
			world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) z), Blocks.FIRE.getDefaultState(), 3);
			if ((((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
					.getBlock())
					|| ((world.getBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z))).getBlock() == Blocks.GRASS.getDefaultState()
							.getBlock()))) {
				world.setBlockState(new BlockPos((int) (x - 1), (int) (y + 1), (int) z), Blocks.FIRE.getDefaultState(), 3);
			}
			if ((((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
					.getBlock())
					|| ((world.getBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z))).getBlock() == Blocks.GRASS.getDefaultState()
							.getBlock()))) {
				world.setBlockState(new BlockPos((int) (x + 1), (int) (y + 1), (int) z), Blocks.FIRE.getDefaultState(), 3);
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
					.getBlock())
					|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)))).getBlock() == Blocks.GRASS.getDefaultState()
							.getBlock()))) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z - 1)), Blocks.FIRE.getDefaultState(), 3);
			}
			if ((((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)))).getBlock() == Blocks.CAVE_AIR.getDefaultState()
					.getBlock())
					|| ((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)))).getBlock() == Blocks.GRASS.getDefaultState()
							.getBlock()))) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 1), (int) (z + 1)), Blocks.FIRE.getDefaultState(), 3);
			}
		}
	}
}
