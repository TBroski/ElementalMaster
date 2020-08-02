//Made with Blockbench
//Paste this code into your mod.

public static class shuriken
 extends ModelBase {
	private final ModelRenderer bone;

	public shuriken() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		setRotationAngle(bone, 0.0F, 1.5708F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 28, 49, -1.0F, -1.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 28, 39, -1.0F, -4.0F, 0.0F, 1, 3,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 24, 37, -2.0F, -4.0F, 0.0F, 1, 3,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 32, 45, 0.0F, -2.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 36, 41, 1.0F, -3.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 42, 37, 2.0F, -4.0F, 0.0F, 3, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 52, 33, 5.0F, -5.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 48, 29, 4.0F, -6.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 44, 25, 3.0F, -7.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 40, 19, 2.0F, -10.0F, 0.0F, 1, 3,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 36, 9, 1.0F, -11.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 32, 13, 0.0F, -10.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 28, 17, -1.0F, -9.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 18, 21, -4.0F, -8.0F, 0.0F, 3, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 12, 25, -5.0F, -7.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 16, 29, -4.0F, -6.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 20, 33, -3.0F, -5.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 32, 39, 0.0F, -4.0F, 0.0F, 1, 2,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 36, 37, 1.0F, -4.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 41, 33, 2.0F, -5.0F, 0.0F, 2, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 40, 29, 2.0F, -6.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 21, 29, -3.0F, -6.0F, 0.0F, 2, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 24, 33, -2.0F, -5.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 36, 18, 1.0F, -9.0F, 0.0F, 1, 2,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 32, 21, 0.0F, -8.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 18, 25, -4.0F, -7.0F, 0.0F, 3, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 28, 21, -1.0F, -8.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 36, 13, 1.0F, -10.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 32, 17, 0.0F, -9.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 44, 29, 3.0F, -6.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 40, 25, 2.0F, -7.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 48, 33, 4.0F, -5.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 36, 33, 1.0F, -5.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 36, 25, 1.0F, -7.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 28, 25, -1.0F, -7.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 28, 33, -1.0F, -5.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 28, 29, -1.0F, -6.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 36, 29, 1.0F, -6.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 32, 25, 0.0F, -7.0F, 0.0F, 1, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 32, 33, 0.0F, -5.0F, 0.0F, 1, 1,
				1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		bone.render(f5);
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