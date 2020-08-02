//Made with Blockbench
//Paste this code into your mod.

public static class Modelspike extends ModelBase {
	private final ModelRenderer bone;

	public Modelspike() {
		textureWidth = 16;
		textureHeight = 16;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.0F, -1.0F, 0.0F, 1, 33,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.0F, 2.0F, -1.0F, 1, 30,
				3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -2.0F, 2.0F, 0.0F, 3, 30, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -3.0F, 6.0F, 0.0F, 5, 26, 1,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.0F, 6.0F, -2.0F, 1, 26,
				5, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -2.0F, 6.0F, -1.0F, 3, 26,
				3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -2.0F, 10.0F, -2.0F, 3, 22,
				5, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -3.0F, 10.0F, -1.0F, 5, 22,
				3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -4.0F, 10.0F, 0.0F, 7, 22,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.0F, 10.0F, -3.0F, 1, 22,
				7, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -3.0F, 14.0F, -2.0F, 5, 18,
				5, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -4.0F, 14.0F, -1.0F, 7, 18,
				3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -2.0F, 14.0F, -3.0F, 3, 18,
				7, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.0F, 14.0F, -4.0F, 1, 18,
				9, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -5.0F, 14.0F, 0.0F, 9, 18,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -6.0F, 18.0F, 0.0F, 11, 14,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.0F, 18.0F, -5.0F, 1, 14,
				11, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -5.0F, 18.0F, -1.0F, 9, 14,
				3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -4.0F, 18.0F, -2.0F, 7, 14,
				5, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -3.0F, 18.0F, -3.0F, 5, 14,
				7, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -2.0F, 18.0F, -4.0F, 3, 14,
				9, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -5.0F, 23.0F, -2.0F, 9, 9,
				5, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -4.0F, 23.0F, -3.0F, 7, 9,
				7, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -3.0F, 23.0F, -4.0F, 5, 9,
				9, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -7.0F, 28.0F, 0.0F, 13, 4,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -1.0F, 28.0F, -6.0F, 1, 4,
				13, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -6.0F, 29.0F, -2.0F, 11, 3,
				5, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -2.0F, 29.0F, -5.0F, 3, 3,
				11, 0.0F, false));
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