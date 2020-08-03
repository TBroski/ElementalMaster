package net.bukkit.elementalmaster.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.bukkit.elementalmaster.block.FallingStalagtiteBlock;
import net.bukkit.elementalmaster.ElementalmasterModVariables;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;

@ElementalmasterModElements.ModElement.Tag
public class IceStalagtitePower2RightClickedInAirProcedure extends ElementalmasterModElements.ModElement {
	public IceStalagtitePower2RightClickedInAirProcedure(ElementalmasterModElements instance) {
		super(instance, 590);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure IceStalagtitePower2RightClickedInAir!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure IceStalagtitePower2RightClickedInAir!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure IceStalagtitePower2RightClickedInAir!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure IceStalagtitePower2RightClickedInAir!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure IceStalagtitePower2RightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure IceStalagtitePower2RightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ElementalmasterModVariables.PlayerVariables())).PlayerMana) > 13)) {
			{
				double _setval = (double) (((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ElementalmasterModVariables.PlayerVariables())).PlayerMana) - 14);
				entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.PlayerMana = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((((itemstack).getOrCreateTag().getBoolean("ManaBonus")) == (true))) {
				{
					double _setval = (double) (((entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ElementalmasterModVariables.PlayerVariables())).PlayerMana) + 7);
					entity.getCapability(ElementalmasterModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.PlayerMana = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			(itemstack).getOrCreateTag().putDouble("XPAmount", (((itemstack).getOrCreateTag().getDouble("XPAmount")) - 1));
			if ((((itemstack).getOrCreateTag().getBoolean("XPBonus")) == (true))) {
				(itemstack).getOrCreateTag().putDouble("XPAmount", (((itemstack).getOrCreateTag().getDouble("XPAmount")) - 2));
			}
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 50);
			if (((world.getBlockState(new BlockPos((int) (x - 2), (int) (y + 5), (int) (z - 2)))).getBlock() == Blocks.AIR.getDefaultState()
					.getBlock())) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) (y + 5), (int) (z - 2)), FallingStalagtiteBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z - 3)))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z - 3)), FallingStalagtiteBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) (x + 2), (int) (y + 5), (int) (z - 2)))).getBlock() == Blocks.AIR.getDefaultState()
					.getBlock())) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) (y + 5), (int) (z - 2)), FallingStalagtiteBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) (x + 3), (int) (y + 5), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) (x + 3), (int) (y + 5), (int) z), FallingStalagtiteBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) (x + 2), (int) (y + 5), (int) (z + 2)))).getBlock() == Blocks.AIR.getDefaultState()
					.getBlock())) {
				world.setBlockState(new BlockPos((int) (x + 2), (int) (y + 5), (int) (z + 2)), FallingStalagtiteBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z + 3)))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) x, (int) (y + 5), (int) (z + 3)), FallingStalagtiteBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) (x - 2), (int) (y + 5), (int) (z + 2)))).getBlock() == Blocks.AIR.getDefaultState()
					.getBlock())) {
				world.setBlockState(new BlockPos((int) (x - 2), (int) (y + 5), (int) (z + 2)), FallingStalagtiteBlock.block.getDefaultState(), 3);
			}
			if (((world.getBlockState(new BlockPos((int) (x - 3), (int) (y + 5), (int) z))).getBlock() == Blocks.AIR.getDefaultState().getBlock())) {
				world.setBlockState(new BlockPos((int) (x - 3), (int) (y + 5), (int) z), FallingStalagtiteBlock.block.getDefaultState(), 3);
			}
		}
	}
}
