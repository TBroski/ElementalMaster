//Made with Blockbench
//Paste this code into your mod.

public static class ModelEarthTitan extends ModelBase {
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
		bone7.cubeList.add(new ModelBox(bone7, 26, 128, -15.99F, -2.0F, -4.6F,
				5, 2, 5, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(2.5F, 28.1F, 2.2F);
		setRotationAngle(bone2, 0.2618F, 0.0F, 0.0F);
		rightleg.addChild(bone2);
		bone2.cubeList.add(new ModelBox(bone2, 60, 107, -5.0F, -16.0F, -4.0F,
				5, 14, 5, 0.0F, false));

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(2.5F, 15.0F, -2.0F);
		setRotationAngle(bone3, -0.2618F, 0.0F, 0.0F);
		rightleg.addChild(bone3);
		bone3.cubeList.add(new ModelBox(bone3, 20, 86, -4.99F, -16.0F, -4.0F,
				5, 16, 5, 0.0F, false));

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(5.5F, -4.0F, 1.0F);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(2.5F, 28.1F, 2.2F);
		setRotationAngle(bone4, 0.2618F, 0.0F, 0.0F);
		leftleg.addChild(bone4);
		bone4.cubeList.add(new ModelBox(bone4, 40, 107, -5.0F, -16.0F, -4.0F,
				5, 14, 5, 0.0F, false));

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(2.5F, 28.1F, 2.2F);
		leftleg.addChild(bone6);
		bone6.cubeList.add(new ModelBox(bone6, 0, 132, -5.01F, -2.0F, -4.6F, 5,
				2, 5, 0.0F, false));

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(2.5F, 15.0F, -2.0F);
		setRotationAngle(bone5, -0.2618F, 0.0F, 0.0F);
		leftleg.addChild(bone5);
		bone5.cubeList.add(new ModelBox(bone5, 90, 65, -5.01F, -16.0F, -4.0F,
				5, 16, 5, 0.0F, false));

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
		bone8.cubeList.add(new ModelBox(bone8, 40, 86, -4.95F, -15.8F, -4.1F,
				4, 16, 5, 0.0F, false));

		sword = new ModelRenderer(this);
		sword.setRotationPoint(0.0F, 2.1F, -2.8F);
		setRotationAngle(sword, 0.2618F, 0.0F, 0.0F);
		rightarmbone.addChild(sword);
		sword.cubeList.add(new ModelBox(sword, 0, 128, -8.0F, -2.8F, -3.1F, 11,
				2, 2, 0.0F, false));
		sword.cubeList.add(new ModelBox(sword, 56, 128, -11.0F, -3.8F, -4.1F,
				3, 4, 3, 0.0F, false));
		sword.cubeList.add(new ModelBox(sword, 0, 140, 29.0F, -3.3F, -3.1F, 3,
				4, 2, 0.0F, false));
		sword.cubeList.add(new ModelBox(sword, 0, 65, 4.0F, -4.3F, -3.1F, 25,
				6, 2, 0.0F, false));
		sword.cubeList.add(new ModelBox(sword, 10, 140, 32.0F, -2.3F, -3.1F, 3,
				2, 2, 0.0F, false));
		sword.cubeList.add(new ModelBox(sword, 46, 128, 2.0F, -6.3F, -3.6F, 2,
				9, 3, 0.0F, false));

		bone9 = new ModelRenderer(this);
		bone9.setRotationPoint(0.0F, -11.0F, -7.0F);
		setRotationAngle(bone9, -0.2618F, 0.0F, 0.0F);
		rightarmbone.addChild(bone9);
		bone9.cubeList.add(new ModelBox(bone9, 20, 107, -5.0F, -16.0F, -4.0F,
				5, 16, 5, 0.0F, false));

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
		bone10.cubeList.add(new ModelBox(bone10, 0, 86, 0.05F, -15.8F, -4.1F,
				4, 16, 5, 0.0F, false));

		bone11 = new ModelRenderer(this);
		bone11.setRotationPoint(0.0F, -11.0F, -7.0F);
		setRotationAngle(bone11, -0.2618F, 0.0F, 0.0F);
		leftarmbone.addChild(bone11);
		bone11.cubeList.add(new ModelBox(bone11, 0, 107, 0.0F, -16.0F, -4.0F,
				5, 16, 5, 0.0F, false));

		chest = new ModelRenderer(this);
		chest.setRotationPoint(8.0F, -4.0F, 3.0F);
		chest.cubeList.add(new ModelBox(chest, 0, 0, -16.0F, -20.0F, -6.0F, 16,
				22, 9, 0.0F, false));

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -22.5F, 0.2F);
		setRotationAngle(head, 0.0873F, 0.0F, 0.0F);
		head.cubeList.add(new ModelBox(head, 54, 65, -5.0F, -14.1585F,
				-4.3112F, 10, 13, 8, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		rightleg.render(f5);
		leftleg.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
		chest.render(f5);
		head.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y,
			float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F
				+ (float) Math.PI)
				* 2.0F * f1 * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1
				* 0.5F;
	}
}