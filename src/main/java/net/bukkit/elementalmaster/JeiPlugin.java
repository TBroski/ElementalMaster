package net.bukkit.elementalmaster;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;

import net.bukkit.elementalmaster.item.FireballShot1Item;
import net.bukkit.elementalmaster.item.FireballShot2Item;
import net.bukkit.elementalmaster.item.FireballShot3Item;
import net.bukkit.elementalmaster.item.WaterPowerItem;
import net.bukkit.elementalmaster.item.WaterPower2Item;
import net.bukkit.elementalmaster.item.WaterPower3Item;
import net.bukkit.elementalmaster.item.IceStalagtitePowerItem;
import net.bukkit.elementalmaster.item.IceStalagtite2Item;
import net.bukkit.elementalmaster.item.IceStalagtite3Item;
import net.bukkit.elementalmaster.item.LightningStrikePowerItem;
import net.bukkit.elementalmaster.item.LightningStrikePower2Item;
import net.bukkit.elementalmaster.item.OmegaLightningStrikePowerItem;
import net.bukkit.elementalmaster.item.TeleportationPowerItem;
import net.bukkit.elementalmaster.item.TeleportationPower2Item;
import net.bukkit.elementalmaster.item.TeleportationPower3Item;
import net.bukkit.elementalmaster.item.NaturePowerItem;
import net.bukkit.elementalmaster.item.NaturePower2Item;
import net.bukkit.elementalmaster.item.NaturePower3Item;
import net.bukkit.elementalmaster.item.EarthPowerItem;
import net.bukkit.elementalmaster.item.EarthPower2Item;
import net.bukkit.elementalmaster.item.EarthPower3Item;
import net.bukkit.elementalmaster.item.MagicBallPowerItem;
import net.bukkit.elementalmaster.item.MagicBallPower2Item;
import net.bukkit.elementalmaster.item.MagicBallPower3Item;
import net.bukkit.elementalmaster.item.MagicLaserPowerItem;
import net.bukkit.elementalmaster.item.MagicLaserPower2Item;
import net.bukkit.elementalmaster.item.MagicLaserPower3Item;
import net.bukkit.elementalmaster.item.WarpPowerItem;
import net.bukkit.elementalmaster.item.WarpPower2Item;
import net.bukkit.elementalmaster.item.WarpPower3Item;
import net.bukkit.elementalmaster.item.LightShotPower1Item;
import net.bukkit.elementalmaster.item.LightShotPower2Item;
import net.bukkit.elementalmaster.item.LightShotPower3Item;
import net.bukkit.elementalmaster.item.HealingPowerItem;
import net.bukkit.elementalmaster.item.HealingPower2Item;
import net.bukkit.elementalmaster.item.HealingPower3Item;

import net.bukkit.elementalmaster.block.PowerFusionnerBlock;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.helpers.IJeiHelpers;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.ingredient.IGuiItemStackGroup;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.IModPlugin;

import java.util.List;
import java.util.ArrayList;

@mezz.jei.api.JeiPlugin
public class JeiPlugin implements IModPlugin {
	public static IJeiHelpers jeiHelper;
	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("elementalmaster", "default");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		jeiHelper = registration.getJeiHelpers();
		registration.addRecipeCategories(new PowerFusionnerJeiCategory(jeiHelper.getGuiHelper()));
	}

// ---------------------------------------------------------------------------------------------------------------
//
//
// HERE STARTS ALL RECIPES
//
//
// ---------------------------------------------------------------------------------------------------------------
	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addRecipes(generatePowerFusionnerRecipesFireThrowLv2(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesFireThrowLv3(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesWaterThrowLv2(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesWaterThrowLv3(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesLightningStrikeLv2(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesLightningStrikeLv3(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesIcePowerLv2(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesIcePowerLv3(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesTeleportationPowerLv2(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesTeleportationPowerLv3(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesMagicBallPowerLv2(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesMagicBallPowerLv3(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesMagicLaserPowerLv2(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesMagicLaserPowerLv3(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesNaturePowerLv2(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesNaturePowerLv3(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesEarthPowerLv2(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesEarthPowerLv3(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesWarpPowerLv2(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesWarpPowerLv3(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesHealingPowerLv2(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesHealingPowerLv3(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesLightShotPowerLv2(), PowerFusionnerJeiCategory.Uid);
		registration.addRecipes(generatePowerFusionnerRecipesLightShotPowerLv3(), PowerFusionnerJeiCategory.Uid);
	    

	}

//
// FIRE POWER LEVEL 2 AND 3
//

	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesFireThrowLv2() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(FireballShot1Item.block));
		inputs.add(new ItemStack(FireballShot1Item.block));
		outputs.add(new ItemStack(FireballShot2Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}
	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesFireThrowLv3() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(FireballShot2Item.block));
		inputs.add(new ItemStack(FireballShot2Item.block));
		outputs.add(new ItemStack(FireballShot3Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}

// ---------------------------------------------------------------------------------------------------------------
// WATER POWER LEVEL 2 AND 3
//

	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesWaterThrowLv2() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(WaterPowerItem.block));
		inputs.add(new ItemStack(WaterPowerItem.block));
		outputs.add(new ItemStack(WaterPower2Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}
	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesWaterThrowLv3() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(WaterPower2Item.block));
		inputs.add(new ItemStack(WaterPower2Item.block));
		outputs.add(new ItemStack(WaterPower3Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}

// ---------------------------------------------------------------------------------------------------------------
// LIGHTNING POWER LEVEL 2 AND 3
//
	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesLightningStrikeLv2() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(LightningStrikePowerItem.block));
		inputs.add(new ItemStack(LightningStrikePowerItem.block));
		outputs.add(new ItemStack(LightningStrikePower2Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}
	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesLightningStrikeLv3() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(LightningStrikePower2Item.block));
		inputs.add(new ItemStack(LightningStrikePower2Item.block));
		outputs.add(new ItemStack(OmegaLightningStrikePowerItem.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}

// ---------------------------------------------------------------------------------------------------------------
// ICE POWER LEVEL 2 AND 3
//
	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesIcePowerLv2() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(IceStalagtitePowerItem.block));
		inputs.add(new ItemStack(IceStalagtitePowerItem.block));
		outputs.add(new ItemStack(IceStalagtite2Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}
	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesIcePowerLv3() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(IceStalagtite2Item.block));
		inputs.add(new ItemStack(IceStalagtite2Item.block));
		outputs.add(new ItemStack(IceStalagtite3Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}

// ---------------------------------------------------------------------------------------------------------------
// TELEPORTATION POWER LEVEL 2 AND 3
//
	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesTeleportationPowerLv2() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(TeleportationPowerItem.block));
		inputs.add(new ItemStack(TeleportationPowerItem.block));
		outputs.add(new ItemStack(TeleportationPower2Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}
	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesTeleportationPowerLv3() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(TeleportationPower2Item.block));
		inputs.add(new ItemStack(TeleportationPower2Item.block));
		outputs.add(new ItemStack(TeleportationPower3Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}

// ---------------------------------------------------------------------------------------------------------------
// MAGIC BALL POWER LEVEL 2 AND 3
//
	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesMagicBallPowerLv2() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(MagicBallPowerItem.block));
		inputs.add(new ItemStack(MagicBallPowerItem.block));
		outputs.add(new ItemStack(MagicBallPower2Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}
	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesMagicBallPowerLv3() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(MagicBallPower2Item.block));
		inputs.add(new ItemStack(MagicBallPower2Item.block));
		outputs.add(new ItemStack(MagicBallPower3Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}

// ---------------------------------------------------------------------------------------------------------------
// MAGIC LASER POWER LEVEL 2 AND 3
//
	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesMagicLaserPowerLv2() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(MagicLaserPowerItem.block));
		inputs.add(new ItemStack(MagicLaserPowerItem.block));
		outputs.add(new ItemStack(MagicLaserPower2Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}
	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesMagicLaserPowerLv3() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(MagicLaserPower2Item.block));
		inputs.add(new ItemStack(MagicLaserPower2Item.block));
		outputs.add(new ItemStack(MagicLaserPower3Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}

// ---------------------------------------------------------------------------------------------------------------
// HEALING POWER LEVEL 2 AND 3
//
	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesHealingPowerLv2() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(HealingPowerItem.block));
		inputs.add(new ItemStack(HealingPowerItem.block));
		outputs.add(new ItemStack(HealingPower2Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}
	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesHealingPowerLv3() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(HealingPower2Item.block));
		inputs.add(new ItemStack(HealingPower2Item.block));
		outputs.add(new ItemStack(HealingPower3Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}

// ---------------------------------------------------------------------------------------------------------------
// EARTH POWER LEVEL 2 AND 3
//

	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesEarthPowerLv2() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(EarthPowerItem.block));
		inputs.add(new ItemStack(EarthPowerItem.block));
		outputs.add(new ItemStack(EarthPower2Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}
	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesEarthPowerLv3() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(EarthPower2Item.block));
		inputs.add(new ItemStack(EarthPower2Item.block));
		outputs.add(new ItemStack(EarthPower3Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}

// ---------------------------------------------------------------------------------------------------------------
// NATURE POWER LEVEL 2 AND 3
//
	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesNaturePowerLv2() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(NaturePowerItem.block));
		inputs.add(new ItemStack(NaturePowerItem.block));
		outputs.add(new ItemStack(NaturePower2Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}
	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesNaturePowerLv3() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(NaturePower2Item.block));
		inputs.add(new ItemStack(NaturePower2Item.block));
		outputs.add(new ItemStack(NaturePower3Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}

// ---------------------------------------------------------------------------------------------------------------
// WARP POWER LEVEL 2 AND 3
//
	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesWarpPowerLv2() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(WarpPowerItem.block));
		inputs.add(new ItemStack(WarpPowerItem.block));
		outputs.add(new ItemStack(WarpPower2Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}
	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesWarpPowerLv3() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(WarpPower2Item.block));
		inputs.add(new ItemStack(WarpPower2Item.block));
		outputs.add(new ItemStack(WarpPower3Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}
	
// ---------------------------------------------------------------------------------------------------------------
// LIGHT SHOT POWER LEVEL 2 AND 3
//
	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesLightShotPowerLv2() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(LightShotPower1Item.block));
		inputs.add(new ItemStack(LightShotPower1Item.block));
		outputs.add(new ItemStack(LightShotPower2Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}
	private List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> generatePowerFusionnerRecipesLightShotPowerLv3() {
		List<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> recipes = new ArrayList<>();
		ArrayList<ItemStack> inputs = new ArrayList<>();
		ArrayList<ItemStack> outputs = new ArrayList<>();
		inputs.add(new ItemStack(LightShotPower2Item.block));
		inputs.add(new ItemStack(LightShotPower2Item.block));
		outputs.add(new ItemStack(LightShotPower3Item.block));
		// ...
		recipes.add(new PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper(inputs, outputs));
		return recipes;
	}

// ---------------------------------------------------------------------------------------------------------------
//
//
// HERE FINISHES ALL RECIPES
//
//
// ---------------------------------------------------------------------------------------------------------------
	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(PowerFusionnerBlock.block), PowerFusionnerJeiCategory.Uid);
	}
	public static class PowerFusionnerJeiCategory implements IRecipeCategory<PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper> {
		private static ResourceLocation Uid = new ResourceLocation("elementalmaster", "powerfusionnercategory");
		private static final int input1 = 0; // THE NUMBER = SLOTID
		private static final int input2 = 1; // THE NUMBER = SLOTID
		private static final int output1 = 2; // THE NUMBER = SLOTID
		// ...
		private final String title;
		private final IDrawable background;
		public PowerFusionnerJeiCategory(IGuiHelper guiHelper) {
			this.title = "Power Fusionner";
			this.background = guiHelper.createDrawable(new ResourceLocation("elementalmaster", "textures/jei-powerfusioner.png"), 0, 0, 175, 80);
		}

		@Override
		public ResourceLocation getUid() {
			return Uid;
		}

		@Override
		public Class<? extends PowerFusionnerRecipeWrapper> getRecipeClass() {
			return PowerFusionnerJeiCategory.PowerFusionnerRecipeWrapper.class;
		}

		@Override
		public String getTitle() {
			return title;
		}

		@Override
		public IDrawable getBackground() {
			return background;
		}

		@Override
		public IDrawable getIcon() {
			return null;
		}

		@Override
		public void setIngredients(PowerFusionnerRecipeWrapper recipeWrapper, IIngredients iIngredients) {
			iIngredients.setInputs(VanillaTypes.ITEM, recipeWrapper.getInput());
			iIngredients.setOutputs(VanillaTypes.ITEM, recipeWrapper.getOutput());
		}

		@Override
		public void setRecipe(IRecipeLayout iRecipeLayout, PowerFusionnerRecipeWrapper recipeWrapper, IIngredients iIngredients) {
			IGuiItemStackGroup stacks = iRecipeLayout.getItemStacks();
			stacks.init(input1, true, 25, 35);
			stacks.init(input2, true, 70, 35);
			stacks.init(output1, false, 142, 35);
			// ...
			stacks.set(input1, iIngredients.getInputs(VanillaTypes.ITEM).get(0));
			stacks.set(input2, iIngredients.getInputs(VanillaTypes.ITEM).get(1));
			stacks.set(output1, iIngredients.getOutputs(VanillaTypes.ITEM).get(0));
			// ...
		}
		public static class PowerFusionnerRecipeWrapper {
			private ArrayList input;
			private ArrayList output;
			public PowerFusionnerRecipeWrapper(ArrayList input, ArrayList output) {
				this.input = input;
				this.output = output;
			}

			public ArrayList getInput() {
				return input;
			}

			public ArrayList getOutput() {
				return output;
			}
		}
	}
}
