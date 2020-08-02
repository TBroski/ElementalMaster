
package net.bukkit.elementalmaster.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.bukkit.elementalmaster.procedures.TheStaffOfElementsToolInHandTickProcedure;
import net.bukkit.elementalmaster.procedures.TheStaffOfElementsRightClickedInAirProcedure;
import net.bukkit.elementalmaster.itemgroup.SpecialElementalItemsItemGroup;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.List;

import com.google.common.collect.Multimap;

@ElementalmasterModElements.ModElement.Tag
public class TheStaffOfElementsItem extends ElementalmasterModElements.ModElement {
	@ObjectHolder("elementalmaster:the_staff_of_elements")
	public static final Item block = null;
	public TheStaffOfElementsItem(ElementalmasterModElements instance) {
		super(instance, 211);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemToolCustom() {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("Right-Click to cast a selected Spell!"));
				list.add(new StringTextComponent("Shift + Right-Click to change spell!"));
				if (itemstack.hasTag()) {
					list.add(new StringTextComponent("\u00A7eLevel " + (itemstack.getTag().getInt("ItemLevel") + "")));
					list.add(new StringTextComponent("\u00A7aXP: " + (itemstack.getTag().getInt("XPAmount") + " \u00A7fleft...")));
					list.add(new StringTextComponent("1 - " + (itemstack.getTag().getString("StaffSlot1Power") + "")));
				}
				if (itemstack.hasTag()) {
					list.add(new StringTextComponent("2 - " + (itemstack.getTag().getString("StaffSlot2Power") + "")));
				}
				if (itemstack.hasTag()) {
					list.add(new StringTextComponent("3 - " + (itemstack.getTag().getString("StaffSlot3Power") + "")));
				}
				if (itemstack.hasTag()) {
					list.add(new StringTextComponent("4 - " + (itemstack.getTag().getString("StaffSlot4Power") + "")));
				}
				if (itemstack.hasTag()) {
					list.add(new StringTextComponent("5 - " + (itemstack.getTag().getString("StaffSlot5Power") + "")));
				}
				list.add(new StringTextComponent("Add different upgrades to your staff!"));
				if (itemstack.hasTag()) {
					list.add(new StringTextComponent("Upgrade 1 - " + (itemstack.getTag().getString("StaffUpgradeSlot1") + "")));
				}
				if (itemstack.hasTag()) {
					list.add(new StringTextComponent("Upgrade 2 - " + (itemstack.getTag().getString("StaffUpgradeSlot2") + "")));
				}
				if (itemstack.hasTag()) {
					list.add(new StringTextComponent("Upgrade 3 - " + (itemstack.getTag().getString("StaffUpgradeSlot3") + "")));
				}
			}

			@Override
			public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
				ActionResult<ItemStack> retval = super.onItemRightClick(world, entity, hand);
				ItemStack itemstack = retval.getResult();
				int x = (int) entity.getPosX();
				int y = (int) entity.getPosY();
				int z = (int) entity.getPosZ();
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("x", x);
					$_dependencies.put("y", y);
					$_dependencies.put("z", z);
					$_dependencies.put("itemstack", itemstack);
					$_dependencies.put("world", world);
					TheStaffOfElementsRightClickedInAirProcedure.executeProcedure($_dependencies);
				}
				return retval;
			}

			@Override
			public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
				super.inventoryTick(itemstack, world, entity, slot, selected);
				int x = (int) entity.getPosX();
				int y = (int) entity.getPosY();
				int z = (int) entity.getPosZ();
				if (selected) {
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					$_dependencies.put("itemstack", itemstack);
					$_dependencies.put("world", world);
					TheStaffOfElementsToolInHandTickProcedure.executeProcedure($_dependencies);
				}
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}
		}.setRegistryName("the_staff_of_elements"));
	}
	private static class ItemToolCustom extends Item {
		protected ItemToolCustom() {
			super(new Item.Properties().group(SpecialElementalItemsItemGroup.tab).maxDamage(0));
		}

		@Override
		public float getDestroySpeed(ItemStack itemstack, BlockState blockstate) {
			return 0;
		}

		@Override
		public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
			stack.damageItem(1, entityLiving, i -> i.sendBreakAnimation(EquipmentSlotType.MAINHAND));
			return true;
		}

		@Override
		public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
			stack.damageItem(2, attacker, i -> i.sendBreakAnimation(EquipmentSlotType.MAINHAND));
			return true;
		}

		@Override
		public int getItemEnchantability() {
			return 2;
		}

		@Override
		public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
			Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(equipmentSlot);
			if (equipmentSlot == EquipmentSlotType.MAINHAND) {
				multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
						new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", -1f, AttributeModifier.Operation.ADDITION));
				multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(),
						new AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", -2.7999999999999998, AttributeModifier.Operation.ADDITION));
			}
			return multimap;
		}
	}
}
