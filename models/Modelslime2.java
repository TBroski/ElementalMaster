//Made with Blockbench
//Paste this code into your mod.

public static class Modelslime2 extends ModelBase {
	private final ModelRenderer cube;
	private final ModelRenderer eye0;
	private final ModelRenderer eye1;
	private final ModelRenderer mouth;
	private final ModelRenderer armor;

	public Modelslime2() {
		textureWidth = 128;
		textureHeight = 64;

		cube = new ModelRenderer(this);
		cube.setRotationPoint(0.0F, 0.0F, 0.0F);
		cube.cubeList.add(new ModelBox(cube, 0, 32, -6.0F, 10.0F, -6.0F, 12,
				12, 12, 0.0F, false));

		eye0 = new ModelRenderer(this);
		eye0.setRotationPoint(0.0F, 0.0F, 0.0F);
		eye0.cubeList.add(new ModelBox(eye0, 64, 0, -6.3F, 12.0F, -7.5F, 4, 4,
				4, 0.0F, false));

		eye1 = new ModelRenderer(this);
		eye1.setRotationPoint(0.0F, 0.0F, 0.0F);
		eye1.cubeList.add(new ModelBox(eye1, 64, 8, 2.3F, 12.0F, -7.5F, 4, 4,
				4, 0.0F, false));

		mouth = new ModelRenderer(this);
		mouth.setRotationPoint(0.0F, 0.0F, 0.0F);
		mouth.cubeList.add(new ModelBox(mouth, 64, 16, 0.0F, 19.0F, -6.5F, 2,
				2, 2, 0.0F, false));

		armor = new ModelRenderer(this);
		armor.setRotationPoint(0.0F, 0.0F, 0.0F);
		armor.cubeList.add(new ModelBox(armor, 0, 0, -8.0F, 8.0F, -8.0F, 16,
				16, 16, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		cube.render(f5);
		eye0.render(f5);
		eye1.render(f5);
		mouth.render(f5);
		armor.render(f5);
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
	}
}