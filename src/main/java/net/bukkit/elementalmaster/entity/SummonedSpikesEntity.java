
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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.bukkit.elementalmaster.ElementalmasterModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@ElementalmasterModElements.ModElement.Tag
public class SummonedSpikesEntity extends ElementalmasterModElements.ModElement {
	public static EntityType entity = null;
	public SummonedSpikesEntity(ElementalmasterModElements instance) {
		super(instance, 204);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(0).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(0.6f, 1.8f))
						.build("summoned_spikes").setRegistryName("summoned_spikes");
		elements.entities.add(() -> entity);
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new Modelspike(), 0.5f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("elementalmaster:textures/shuriken.png");
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
			experienceValue = 0;
			setNoAI(false);
			enablePersistence();
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
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
		public boolean attackEntityFrom(DamageSource source, float amount) {
			if (source.getImmediateSource() instanceof ArrowEntity)
				return false;
			if (source.getImmediateSource() instanceof PlayerEntity)
				return false;
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
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(0);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0);
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class Modelspike extends EntityModel<Entity> {
		private final ModelRenderer bone;
		public Modelspike() {
			textureWidth = 16;
			textureHeight = 16;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			addBoxHelper(bone, 0, 0, -1.0F, -1.0F, 0.0F, 1, 33, 1, 0.0F, false);
			addBoxHelper(bone, 0, 0, -1.0F, 2.0F, -1.0F, 1, 30, 3, 0.0F, false);
			addBoxHelper(bone, 0, 0, -2.0F, 2.0F, 0.0F, 3, 30, 1, 0.0F, false);
			addBoxHelper(bone, 0, 0, -3.0F, 6.0F, 0.0F, 5, 26, 1, 0.0F, false);
			addBoxHelper(bone, 0, 0, -1.0F, 6.0F, -2.0F, 1, 26, 5, 0.0F, false);
			addBoxHelper(bone, 0, 0, -2.0F, 6.0F, -1.0F, 3, 26, 3, 0.0F, false);
			addBoxHelper(bone, 0, 0, -2.0F, 10.0F, -2.0F, 3, 22, 5, 0.0F, false);
			addBoxHelper(bone, 0, 0, -3.0F, 10.0F, -1.0F, 5, 22, 3, 0.0F, false);
			addBoxHelper(bone, 0, 0, -4.0F, 10.0F, 0.0F, 7, 22, 1, 0.0F, false);
			addBoxHelper(bone, 0, 0, -1.0F, 10.0F, -3.0F, 1, 22, 7, 0.0F, false);
			addBoxHelper(bone, 0, 0, -3.0F, 14.0F, -2.0F, 5, 18, 5, 0.0F, false);
			addBoxHelper(bone, 0, 0, -4.0F, 14.0F, -1.0F, 7, 18, 3, 0.0F, false);
			addBoxHelper(bone, 0, 0, -2.0F, 14.0F, -3.0F, 3, 18, 7, 0.0F, false);
			addBoxHelper(bone, 0, 0, -1.0F, 14.0F, -4.0F, 1, 18, 9, 0.0F, false);
			addBoxHelper(bone, 0, 0, -5.0F, 14.0F, 0.0F, 9, 18, 1, 0.0F, false);
			addBoxHelper(bone, 0, 0, -6.0F, 18.0F, 0.0F, 11, 14, 1, 0.0F, false);
			addBoxHelper(bone, 0, 0, -1.0F, 18.0F, -5.0F, 1, 14, 11, 0.0F, false);
			addBoxHelper(bone, 0, 0, -5.0F, 18.0F, -1.0F, 9, 14, 3, 0.0F, false);
			addBoxHelper(bone, 0, 0, -4.0F, 18.0F, -2.0F, 7, 14, 5, 0.0F, false);
			addBoxHelper(bone, 0, 0, -3.0F, 18.0F, -3.0F, 5, 14, 7, 0.0F, false);
			addBoxHelper(bone, 0, 0, -2.0F, 18.0F, -4.0F, 3, 14, 9, 0.0F, false);
			addBoxHelper(bone, 0, 0, -5.0F, 23.0F, -2.0F, 9, 9, 5, 0.0F, false);
			addBoxHelper(bone, 0, 0, -4.0F, 23.0F, -3.0F, 7, 9, 7, 0.0F, false);
			addBoxHelper(bone, 0, 0, -3.0F, 23.0F, -4.0F, 5, 9, 9, 0.0F, false);
			addBoxHelper(bone, 0, 0, -7.0F, 28.0F, 0.0F, 13, 4, 1, 0.0F, false);
			addBoxHelper(bone, 0, 0, -1.0F, 28.0F, -6.0F, 1, 4, 13, 0.0F, false);
			addBoxHelper(bone, 0, 0, -6.0F, 29.0F, -2.0F, 11, 3, 5, 0.0F, false);
			addBoxHelper(bone, 0, 0, -2.0F, 29.0F, -5.0F, 3, 3, 11, 0.0F, false);
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
}
