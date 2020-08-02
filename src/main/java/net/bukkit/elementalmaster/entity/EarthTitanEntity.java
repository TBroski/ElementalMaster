
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

import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.World;
import net.minecraft.world.BossInfo;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.DamageSource;
import net.minecraft.network.IPacket;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.Entity;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.bukkit.elementalmaster.procedures.EarthTitanEntityIsHurtProcedure;
import net.bukkit.elementalmaster.item.EarthIngotItem;
import net.bukkit.elementalmaster.ElementalmasterModElements;

import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@ElementalmasterModElements.ModElement.Tag
public class EarthTitanEntity extends ElementalmasterModElements.ModElement {
	public static EntityType entity = null;
	public EarthTitanEntity(ElementalmasterModElements instance) {
		super(instance, 197);
		FMLJavaModLoadingContext.get().getModEventBus().register(this);
	}

	@Override
	public void initElements() {
		entity = (EntityType.Builder.<CustomEntity>create(CustomEntity::new, EntityClassification.MONSTER).setShouldReceiveVelocityUpdates(true)
				.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CustomEntity::new).immuneToFire().size(0.7999999999999999f, 3.2f))
						.build("earthtitan").setRegistryName("earthtitan");
		elements.entities.add(() -> entity);
		elements.items
				.add(() -> new SpawnEggItem(entity, -13434880, -13434829, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("earthtitan"));
	}

	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(entity, renderManager -> {
			return new MobRenderer(renderManager, new ModelEarthTitan(), 0.6f) {
				@Override
				public ResourceLocation getEntityTexture(Entity entity) {
					return new ResourceLocation("elementalmaster:textures/templatetitan2.png");
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
			experienceValue = 100;
			setNoAI(false);
			setCustomName(new StringTextComponent("Earth Titan"));
			setCustomNameVisible(true);
			enablePersistence();
		}

		@Override
		public IPacket<?> createSpawnPacket() {
			return NetworkHooks.getEntitySpawningPacket(this);
		}

		@Override
		protected void registerGoals() {
			super.registerGoals();
			this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1));
			this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, PlayerEntity.class, false, true));
			this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false));
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
			this.entityDropItem(new ItemStack(EarthIngotItem.block, (int) (1)));
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
			double x = this.getPosX();
			double y = this.getPosY();
			double z = this.getPosZ();
			Entity entity = this;
			Entity sourceentity = source.getTrueSource();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				EarthTitanEntityIsHurtProcedure.executeProcedure($_dependencies);
			}
			if (source.getImmediateSource() instanceof ArrowEntity)
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
				this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2);
			if (this.getAttribute(SharedMonsterAttributes.MAX_HEALTH) != null)
				this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1000);
			if (this.getAttribute(SharedMonsterAttributes.ARMOR) != null)
				this.getAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(20);
			if (this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) == null)
				this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
			this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(10);
		}

		@Override
		public boolean isNonBoss() {
			return false;
		}
		private final ServerBossInfo bossInfo = new ServerBossInfo(this.getDisplayName(), BossInfo.Color.PINK, BossInfo.Overlay.PROGRESS);
		@Override
		public void addTrackingPlayer(ServerPlayerEntity player) {
			super.addTrackingPlayer(player);
			this.bossInfo.addPlayer(player);
		}

		@Override
		public void removeTrackingPlayer(ServerPlayerEntity player) {
			super.removeTrackingPlayer(player);
			this.bossInfo.removePlayer(player);
		}

		@Override
		public void updateAITasks() {
			super.updateAITasks();
			this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
		}
	}

	// Made with Blockbench
	// Paste this code into your mod.
	public static class ModelEarthTitan extends EntityModel<Entity> {
		private final ModelRenderer rightleg;
		private final ModelRenderer bone7;
		private final ModelRenderer bone2;
		private final ModelRenderer bone3;
		private final ModelRenderer leftleg;
		private final ModelRenderer bone4;
		private final ModelRenderer bone6;
		private final ModelRenderer bone5;
		private final ModelRenderer rightarm;
		private final ModelRenderer rightarmbone;
		private final ModelRenderer bone8;
		private final ModelRenderer sword;
		private final ModelRenderer bone9;
		private final ModelRenderer leftarm;
		private final ModelRenderer leftarmbone;
		private final ModelRenderer bone10;
		private final ModelRenderer bone11;
		private final ModelRenderer chest;
		private final ModelRenderer head;
		public ModelEarthTitan() {
			textureWidth = 256;
			textureHeight = 256;
			rightleg = new ModelRenderer(this);
			rightleg.setRotationPoint(-5.5F, -4.0F, 1.0F);
			bone7 = new ModelRenderer(this);
			bone7.setRotationPoint(13.5F, 28.1F, 2.2F);
			rightleg.addChild(bone7);
			addBoxHelper(bone7, 26, 128, -15.99F, -2.0F, -4.6F, 5, 2, 5, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(2.5F, 28.1F, 2.2F);
			setRotationAngle(bone2, 0.2618F, 0.0F, 0.0F);
			rightleg.addChild(bone2);
			addBoxHelper(bone2, 60, 107, -5.0F, -16.0F, -4.0F, 5, 14, 5, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(2.5F, 15.0F, -2.0F);
			setRotationAngle(bone3, -0.2618F, 0.0F, 0.0F);
			rightleg.addChild(bone3);
			addBoxHelper(bone3, 20, 86, -4.99F, -16.0F, -4.0F, 5, 16, 5, 0.0F, false);
			leftleg = new ModelRenderer(this);
			leftleg.setRotationPoint(5.5F, -4.0F, 1.0F);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(2.5F, 28.1F, 2.2F);
			setRotationAngle(bone4, 0.2618F, 0.0F, 0.0F);
			leftleg.addChild(bone4);
			addBoxHelper(bone4, 40, 107, -5.0F, -16.0F, -4.0F, 5, 14, 5, 0.0F, false);
			bone6 = new ModelRenderer(this);
			bone6.setRotationPoint(2.5F, 28.1F, 2.2F);
			leftleg.addChild(bone6);
			addBoxHelper(bone6, 0, 132, -5.01F, -2.0F, -4.6F, 5, 2, 5, 0.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(2.5F, 15.0F, -2.0F);
			setRotationAngle(bone5, -0.2618F, 0.0F, 0.0F);
			leftleg.addChild(bone5);
			addBoxHelper(bone5, 90, 65, -5.01F, -16.0F, -4.0F, 5, 16, 5, 0.0F, false);
			rightarm = new ModelRenderer(this);
			rightarm.setRotationPoint(-7.7F, -18.8F, 1.5F);
			setRotationAngle(rightarm, 0.0F, 0.0F, -0.0873F);
			rightarmbone = new ModelRenderer(this);
			rightarmbone.setRotationPoint(-3.0F, 23.0F, -2.5F);
			setRotationAngle(rightarmbone, 0.0F, 1.5708F, 0.3491F);
			rightarm.addChild(rightarmbone);
			bone8 = new ModelRenderer(this);
			bone8.setRotationPoint(0.0F, 2.1F, -2.8F);
			setRotationAngle(bone8, 0.2618F, 0.0F, 0.0F);
			rightarmbone.addChild(bone8);
			addBoxHelper(bone8, 40, 86, -4.95F, -15.8F, -4.1F, 4, 16, 5, 0.0F, false);
			sword = new ModelRenderer(this);
			sword.setRotationPoint(0.0F, 2.1F, -2.8F);
			setRotationAngle(sword, 0.2618F, 0.0F, 0.0F);
			rightarmbone.addChild(sword);
			addBoxHelper(sword, 0, 128, -8.0F, -2.8F, -3.1F, 11, 2, 2, 0.0F, false);
			addBoxHelper(sword, 56, 128, -11.0F, -3.8F, -4.1F, 3, 4, 3, 0.0F, false);
			addBoxHelper(sword, 0, 140, 29.0F, -3.3F, -3.1F, 3, 4, 2, 0.0F, false);
			addBoxHelper(sword, 0, 65, 4.0F, -4.3F, -3.1F, 25, 6, 2, 0.0F, false);
			addBoxHelper(sword, 10, 140, 32.0F, -2.3F, -3.1F, 3, 2, 2, 0.0F, false);
			addBoxHelper(sword, 46, 128, 2.0F, -6.3F, -3.6F, 2, 9, 3, 0.0F, false);
			bone9 = new ModelRenderer(this);
			bone9.setRotationPoint(0.0F, -11.0F, -7.0F);
			setRotationAngle(bone9, -0.2618F, 0.0F, 0.0F);
			rightarmbone.addChild(bone9);
			addBoxHelper(bone9, 20, 107, -5.0F, -16.0F, -4.0F, 5, 16, 5, 0.0F, false);
			leftarm = new ModelRenderer(this);
			leftarm.setRotationPoint(7.7F, -18.8F, 1.5F);
			setRotationAngle(leftarm, 0.0F, 0.0F, 0.0873F);
			leftarmbone = new ModelRenderer(this);
			leftarmbone.setRotationPoint(3.0F, 23.0F, -2.5F);
			setRotationAngle(leftarmbone, 0.0F, -1.5708F, -0.3491F);
			leftarm.addChild(leftarmbone);
			bone10 = new ModelRenderer(this);
			bone10.setRotationPoint(0.0F, 2.1F, -2.8F);
			setRotationAngle(bone10, 0.2618F, 0.0F, 0.0F);
			leftarmbone.addChild(bone10);
			addBoxHelper(bone10, 0, 86, 0.05F, -15.8F, -4.1F, 4, 16, 5, 0.0F, false);
			bone11 = new ModelRenderer(this);
			bone11.setRotationPoint(0.0F, -11.0F, -7.0F);
			setRotationAngle(bone11, -0.2618F, 0.0F, 0.0F);
			leftarmbone.addChild(bone11);
			addBoxHelper(bone11, 0, 107, 0.0F, -16.0F, -4.0F, 5, 16, 5, 0.0F, false);
			chest = new ModelRenderer(this);
			chest.setRotationPoint(8.0F, -4.0F, 3.0F);
			addBoxHelper(chest, 0, 0, -16.0F, -20.0F, -6.0F, 16, 22, 9, 0.0F, false);
			head = new ModelRenderer(this);
			head.setRotationPoint(0.0F, -22.5F, 0.2F);
			setRotationAngle(head, 0.0873F, 0.0F, 0.0F);
			addBoxHelper(head, 54, 65, -5.0F, -14.1585F, -4.3112F, 10, 13, 8, 0.0F, false);
		}

		@Override
		public void render(MatrixStack ms, IVertexBuilder vb, int i1, int i2, float f1, float f2, float f3, float f4) {
			rightleg.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leftleg.render(ms, vb, i1, i2, f1, f2, f3, f4);
			rightarm.render(ms, vb, i1, i2, f1, f2, f3, f4);
			leftarm.render(ms, vb, i1, i2, f1, f2, f3, f4);
			chest.render(ms, vb, i1, i2, f1, f2, f3, f4);
			head.render(ms, vb, i1, i2, f1, f2, f3, f4);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
			this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
			this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
			this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
			this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * 2.0F * f1 * 0.5F;
			this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
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
