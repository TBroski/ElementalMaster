
package net.bukkit.elementalmaster.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.ActionResult;
import net.minecraft.network.IPacket;
import net.minecraft.item.UseAction;
import net.minecraft.item.ShootableItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.IRenderTypeBuffer;

import net.bukkit.elementalmaster.itemgroup.ElementalGearsItemGroup;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Random;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@ElementalmasterModElements.ModElement.Tag
public class ShurikenItem extends ElementalmasterModElements.ModElement {
	@ObjectHolder("elementalmaster:shuriken")
	public static final Item block = null;
	@ObjectHolder("elementalmaster:entitybulletshuriken")
	public static final EntityType arrow = null;
	public ShurikenItem(ElementalmasterModElements instance) {
		super(instance, 170);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemRanged());
		elements.entities.add(() -> (EntityType.Builder.<ArrowCustomEntity>create(ArrowCustomEntity::new, EntityClassification.MISC)
				.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).setCustomClientFactory(ArrowCustomEntity::new)
				.size(0.5f, 0.5f)).build("entitybulletshuriken").setRegistryName("entitybulletshuriken"));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void init(FMLCommonSetupEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(arrow, renderManager -> new CustomRender(renderManager));
	}
	public static class ItemRanged extends Item {
		public ItemRanged() {
			super(new Item.Properties().group(ElementalGearsItemGroup.tab).maxStackSize(4));
			setRegistryName("shuriken");
		}

		@Override
		public UseAction getUseAction(ItemStack stack) {
			return UseAction.BOW;
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			entity.setActiveHand(hand);
			return new ActionResult(ActionResultType.SUCCESS, entity.getHeldItem(hand));
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 72000;
		}

		@Override
		public void onPlayerStoppedUsing(ItemStack itemstack, World world, LivingEntity entityLiving, int timeLeft) {
			if (!world.isRemote && entityLiving instanceof ServerPlayerEntity) {
				ServerPlayerEntity entity = (ServerPlayerEntity) entityLiving;
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				if (true) {
					ItemStack stack = ShootableItem.getHeldAmmo(entity, e -> e.getItem() == new ItemStack(ShurikenItem.block, (int) (1)).getItem());
					if (stack == ItemStack.EMPTY) {
						for (int i = 0; i < entity.inventory.mainInventory.size(); i++) {
							ItemStack teststack = entity.inventory.mainInventory.get(i);
							if (teststack != null && teststack.getItem() == new ItemStack(ShurikenItem.block, (int) (1)).getItem()) {
								stack = teststack;
								break;
							}
						}
					}
					if (entity.abilities.isCreativeMode || stack != ItemStack.EMPTY) {
						ArrowCustomEntity entityarrow = shoot(world, entity, random, 1f, 3, 1);
						itemstack.damageItem(1, entity, e -> e.sendBreakAnimation(entity.getActiveHand()));
						if (entity.abilities.isCreativeMode) {
							entityarrow.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
						} else {
							if (new ItemStack(ShurikenItem.block, (int) (1)).isDamageable()) {
								if (stack.attemptDamageItem(1, random, entity)) {
									stack.shrink(1);
									stack.setDamage(0);
									if (stack.isEmpty())
										entity.inventory.deleteStack(stack);
								}
							} else {
								stack.shrink(1);
								if (stack.isEmpty())
									entity.inventory.deleteStack(stack);
							}
						}
					}
				}
			}
		}
	}

	@OnlyIn(value = Dist.CLIENT, _interface = IRendersAsItem.class)
	public static class ArrowCustomEntity extends AbstractArrowEntity implements IRendersAsItem {
		public ArrowCustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			super(arrow, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, World world) {
			super(type, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, double x, double y, double z, World world) {
			super(type, x, y, z, world);
		}

		public ArrowCustomEntity(EntityType<? extends ArrowCustomEntity> type, LivingEntity entity, World world) {
			super(type, entity, world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack getItem() {
			return new ItemStack(ElementalIngotItem.block, (int) (1));
		}

		@Override
		protected ItemStack getArrowStack() {
			return new ItemStack(ShurikenItem.block, (int) (1));
		}

		@Override
		protected void arrowHit(LivingEntity entity) {
			super.arrowHit(entity);
			entity.setArrowCountInEntity(entity.getArrowCountInEntity() - 1);
		}

		@Override
		public void tick() {
			super.tick();
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			World world = this.world;
			Entity entity = this.getShooter();
			if (this.inGround) {
				this.remove();
			}
		}
	}

	public static class CustomRender extends EntityRenderer<ArrowCustomEntity> {
		private static final ResourceLocation texture = new ResourceLocation("elementalmaster:textures/shuriken.png");
		public CustomRender(EntityRendererManager renderManager) {
			super(renderManager);
		}

		@Override
		public void render(ArrowCustomEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn,
				int packedLightIn) {
			IVertexBuilder vb = bufferIn.getBuffer(RenderType.getEntityCutout(this.getEntityTexture(entityIn)));
			matrixStackIn.push();
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(MathHelper.lerp(partialTicks, entityIn.prevRotationYaw, entityIn.rotationYaw) - 90));
			matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90 + MathHelper.lerp(partialTicks, entityIn.prevRotationPitch, entityIn.rotationPitch)));
			EntityModel model = new shuriken();
			model.render(matrixStackIn, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
			matrixStackIn.pop();
			super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
		}

		@Override
		public ResourceLocation getEntityTexture(ArrowCustomEntity entity) {
			return texture;
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class shuriken extends EntityModel<Entity> {
		private final ModelRenderer bone;
		public shuriken() {
			textureWidth = 64;
			textureHeight = 64;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			setRotationAngle(bone, 0.0F, 1.5708F, 0.0F);
			addBoxHelper(bone, 28, 49, -1.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 28, 39, -1.0F, -4.0F, 0.0F, 1, 3, 1, 0.0F, false);
			addBoxHelper(bone, 24, 37, -2.0F, -4.0F, 0.0F, 1, 3, 1, 0.0F, false);
			addBoxHelper(bone, 32, 45, 0.0F, -2.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 36, 41, 1.0F, -3.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 42, 37, 2.0F, -4.0F, 0.0F, 3, 1, 1, 0.0F, false);
			addBoxHelper(bone, 52, 33, 5.0F, -5.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 48, 29, 4.0F, -6.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 44, 25, 3.0F, -7.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 40, 19, 2.0F, -10.0F, 0.0F, 1, 3, 1, 0.0F, false);
			addBoxHelper(bone, 36, 9, 1.0F, -11.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 32, 13, 0.0F, -10.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 28, 17, -1.0F, -9.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 18, 21, -4.0F, -8.0F, 0.0F, 3, 1, 1, 0.0F, false);
			addBoxHelper(bone, 12, 25, -5.0F, -7.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 16, 29, -4.0F, -6.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 20, 33, -3.0F, -5.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 32, 39, 0.0F, -4.0F, 0.0F, 1, 2, 1, 0.0F, false);
			addBoxHelper(bone, 36, 37, 1.0F, -4.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 41, 33, 2.0F, -5.0F, 0.0F, 2, 1, 1, 0.0F, false);
			addBoxHelper(bone, 40, 29, 2.0F, -6.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 21, 29, -3.0F, -6.0F, 0.0F, 2, 1, 1, 0.0F, false);
			addBoxHelper(bone, 24, 33, -2.0F, -5.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 36, 18, 1.0F, -9.0F, 0.0F, 1, 2, 1, 0.0F, false);
			addBoxHelper(bone, 32, 21, 0.0F, -8.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 18, 25, -4.0F, -7.0F, 0.0F, 3, 1, 1, 0.0F, false);
			addBoxHelper(bone, 28, 21, -1.0F, -8.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 36, 13, 1.0F, -10.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 32, 17, 0.0F, -9.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 44, 29, 3.0F, -6.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 40, 25, 2.0F, -7.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 48, 33, 4.0F, -5.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 36, 33, 1.0F, -5.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 36, 25, 1.0F, -7.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 28, 25, -1.0F, -7.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 28, 33, -1.0F, -5.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 28, 29, -1.0F, -6.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 36, 29, 1.0F, -6.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 32, 25, 0.0F, -7.0F, 0.0F, 1, 1, 1, 0.0F, false);
			addBoxHelper(bone, 32, 33, 0.0F, -5.0F, 0.0F, 1, 1, 1, 0.0F, false);
		}

		@Override
		public void render(MatrixStack ms, IVertexBuilder vb, int i1, int i2, float f1, float f2, float f3, float f4) {
			bone.render(ms, vb, i1, i2, f1, f2, f3, f4);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}
	@OnlyIn(Dist.CLIENT)
	public static void addBoxHelper(ModelRenderer renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta) {
		addBoxHelper(renderer, texU, texV, x, y, z, dx, dy, dz, delta, renderer.mirror);
	}

	@OnlyIn(Dist.CLIENT)
	public static void addBoxHelper(ModelRenderer renderer, int texU, int texV, float x, float y, float z, int dx, int dy, int dz, float delta,
			boolean mirror) {
		renderer.mirror = mirror;
		renderer.addBox("", x, y, z, dx, dy, dz, delta, texU, texV);
	}

	public static ArrowCustomEntity shoot(World world, LivingEntity entity, Random random, float power, double damage, int knockback) {
		ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, world);
		entityarrow.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setIsCritical(false);
		entityarrow.setDamage(damage);
		entityarrow.setKnockbackStrength(knockback);
		world.addEntity(entityarrow);
		double x = entity.getPosX();
		double y = entity.getPosY();
		double z = entity.getPosZ();
		world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
				(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")),
				SoundCategory.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static ArrowCustomEntity shoot(LivingEntity entity, LivingEntity target) {
		ArrowCustomEntity entityarrow = new ArrowCustomEntity(arrow, entity, entity.world);
		double d0 = target.getPosY() + (double) target.getEyeHeight() - 1.1;
		double d1 = target.getPosX() - entity.getPosX();
		double d3 = target.getPosZ() - entity.getPosZ();
		entityarrow.shoot(d1, d0 - entityarrow.getPosY() + (double) MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F, d3, 1f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setDamage(3);
		entityarrow.setKnockbackStrength(1);
		entityarrow.setIsCritical(false);
		entity.world.addEntity(entityarrow);
		double x = entity.getPosX();
		double y = entity.getPosY();
		double z = entity.getPosZ();
		entity.world.playSound((PlayerEntity) null, (double) x, (double) y, (double) z,
				(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")),
				SoundCategory.PLAYERS, 1, 1f / (new Random().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
