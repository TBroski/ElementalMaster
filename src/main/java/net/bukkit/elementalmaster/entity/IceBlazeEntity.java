
package net.bukkit.elementalmaster.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.block.BlockState;

import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Random;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@ElementalmasterModElements.ModElement.Tag
public class IceBlazeEntity extends ElementalmasterModElements.ModElement {
	public static EntityType entity = null;
	public IceBlazeEntity(ElementalmasterModElements instance) {
		super(instance, 199);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(0.6f, 1.8f))
						.build("iceblaze").setRegistryName("iceblaze");
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -16711681, -16737895, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("iceblaze"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelblazemodel(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("elementalmaster:textures/iceblaze.png");
				}
			};
		});
	}
	public static class CustomEntity extends MonsterEntity {
		public CustomEntity(FMLPlayMessages.SpawnEntity packet, World world) {
			this(entity, world);
		}

		public CustomEntity(EntityType<CustomEntity> type, World world) {
			super(type, world);
			experienceValue = 2;
			setNoAI(false);
			enablePersistence();
			this.moveController = new FlyingMovementController(this, 10, true);
			this.navigator = new FlyingPathNavigator(this, this.world);
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 0.8, 20) {
				@Override
				protected Vec3d getPosition() {
					Random random = CustomEntity.this.getRNG();
					double dir_x = CustomEntity.this.getPosX() + ((random.nextFloat() * 2 - 1) * 16);
					double dir_y = CustomEntity.this.getPosY() + ((random.nextFloat() * 2 - 1) * 16);
					double dir_z = CustomEntity.this.getPosZ() + ((random.nextFloat() * 2 - 1) * 16);
					return new Vec3d(dir_x, dir_y, dir_z);
				}
			});
			this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, PlayerEntity.class, true, true));
			this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
			this.goalSelector.addGoal(4, new LookRandomlyGoal(this));
		}

		@Override
		public CreatureAttribute getCreatureAttribute() {
			return CreatureAttribute.UNDEFINED;
		}

		@Override
		public boolean canDespawn(double distanceToClosestPlayer) {
			return false;
		}

		protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
			super.dropSpecialItems(source, looting, recentlyHitIn);
			this.entityDropItem(new ItemStack(Items.BLAZE_POWDER, (int) (1)));
		}

		@Override
		public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.hurt"));
		}

		@Override
		public net.minecraft.util.SoundEvent getDeathSound() {
			return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.death"));
		}

		@Override
		public boolean onLivingFall(float l, float d) {
			return false;
		}

		@Override
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof PotionEntity)
				return false;
			if (source == DamageSource.FALL)
				return false;
			if (source == DamageSource.CACTUS)
				return false;
			if (source == DamageSource.DROWN)
				return false;
			if (source == DamageSource.LIGHTNING_BOLT)
				return false;
			return super.attackEntityFrom(source, amount);
		}

		@Override
		protected void registerAttributes() {
			super.registerAttributes();
			if (this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED) != null)
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4);
			if (this.getAttribute(SharedMonsterAttributes.FLYING_SPEED) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
			this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.3);
		}

		@Override
		protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		}

		@Override
		public void setNoGravity(boolean ignored) {
			super.setNoGravity(true);
		}

		public void livingTick() {
			super.livingTick();
			this.setNoGravity(true);
		}
	}

	// Made with Blockbench 3.5.2
	// Exported for Minecraft version 1.15
	// Paste this class into your mod and generate all required imports
	public static class Modelblazemodel extends EntityModel<Entity> {
		private final ModelRenderer upperBodyParts0;
		private final ModelRenderer upperBodyParts1;
		private final ModelRenderer upperBodyParts2;
		private final ModelRenderer upperBodyParts3;
		private final ModelRenderer upperBodyParts4;
		private final ModelRenderer upperBodyParts5;
		private final ModelRenderer upperBodyParts6;
		private final ModelRenderer upperBodyParts7;
		private final ModelRenderer upperBodyParts8;
		private final ModelRenderer upperBodyParts9;
		private final ModelRenderer upperBodyParts10;
		private final ModelRenderer upperBodyParts11;
		private final ModelRenderer head;
		public Modelblazemodel() {
			textureWidth = 64;
			textureHeight = 32;
			upperBodyParts0 = new ModelRenderer(this);
			upperBodyParts0.setRotationPoint(0.0F, 0.0F, 0.0F);
			upperBodyParts0.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
			upperBodyParts1 = new ModelRenderer(this);
			upperBodyParts1.setRotationPoint(0.0F, 0.0F, 0.0F);
			upperBodyParts1.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
			upperBodyParts2 = new ModelRenderer(this);
			upperBodyParts2.setRotationPoint(0.0F, 0.0F, 0.0F);
			upperBodyParts2.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
			upperBodyParts3 = new ModelRenderer(this);
			upperBodyParts3.setRotationPoint(0.0F, 0.0F, 0.0F);
			upperBodyParts3.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
			upperBodyParts4 = new ModelRenderer(this);
			upperBodyParts4.setRotationPoint(0.0F, 0.0F, 0.0F);
			upperBodyParts4.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
			upperBodyParts5 = new ModelRenderer(this);
			upperBodyParts5.setRotationPoint(0.0F, 0.0F, 0.0F);
			upperBodyParts5.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
			upperBodyParts6 = new ModelRenderer(this);
			upperBodyParts6.setRotationPoint(0.0F, 0.0F, 0.0F);
			upperBodyParts6.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
			upperBodyParts7 = new ModelRenderer(this);
			upperBodyParts7.setRotationPoint(0.0F, 0.0F, 0.0F);
			upperBodyParts7.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
			upperBodyParts8 = new ModelRenderer(this);
			upperBodyParts8.setRotationPoint(0.0F, 0.0F, 0.0F);
			upperBodyParts8.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
			upperBodyParts9 = new ModelRenderer(this);
			upperBodyParts9.setRotationPoint(0.0F, 0.0F, 0.0F);
			upperBodyParts9.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
			upperBodyParts10 = new ModelRenderer(this);
			upperBodyParts10.setRotationPoint(0.0F, 0.0F, 0.0F);
			upperBodyParts10.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
			upperBodyParts11 = new ModelRenderer(this);
			upperBodyParts11.setRotationPoint(0.0F, 0.0F, 0.0F);
			upperBodyParts11.setTextureOffset(0, 16).addBox(-2.0F, 0.0F, 0.0F, 2.0F, 8.0F, 2.0F, 0.0F, true);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, 0.0F, 0.0F);
			head.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, true);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			upperBodyParts0.render(matrixStack, buffer, packedLight, packedOverlay);
			upperBodyParts1.render(matrixStack, buffer, packedLight, packedOverlay);
			upperBodyParts2.render(matrixStack, buffer, packedLight, packedOverlay);
			upperBodyParts3.render(matrixStack, buffer, packedLight, packedOverlay);
			upperBodyParts4.render(matrixStack, buffer, packedLight, packedOverlay);
			upperBodyParts5.render(matrixStack, buffer, packedLight, packedOverlay);
			upperBodyParts6.render(matrixStack, buffer, packedLight, packedOverlay);
			upperBodyParts7.render(matrixStack, buffer, packedLight, packedOverlay);
			upperBodyParts8.render(matrixStack, buffer, packedLight, packedOverlay);
			upperBodyParts9.render(matrixStack, buffer, packedLight, packedOverlay);
			upperBodyParts10.render(matrixStack, buffer, packedLight, packedOverlay);
			upperBodyParts11.render(matrixStack, buffer, packedLight, packedOverlay);
			head.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.upperBodyParts10.rotateAngleX = f2;
			this.upperBodyParts3.rotateAngleX = f2;
			this.upperBodyParts2.rotateAngleX = f2;
			this.upperBodyParts1.rotateAngleX = f2;
			this.upperBodyParts0.rotateAngleX = f2;
			this.upperBodyParts11.rotateAngleX = f2;
			this.upperBodyParts7.rotateAngleX = f2;
			this.upperBodyParts6.rotateAngleX = f2;
			this.upperBodyParts5.rotateAngleX = f2;
			this.upperBodyParts4.rotateAngleX = f2;
			this.upperBodyParts9.rotateAngleX = f2;
			this.upperBodyParts8.rotateAngleX = f2;
		}
	}
}
