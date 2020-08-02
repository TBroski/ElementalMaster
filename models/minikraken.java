//Made with Blockbench
//Paste this code into your mod.

public static class minikraken extends ModelBase {
	private final ModelRenderer Tentacle1;
	private final ModelRenderer Body;

	public minikraken() {
		textureWidth = 64;
		textureHeight = 64;

		Tentacle1 = new ModelRenderer(this);
		Tentacle1.setRotationPoint(0.0F, 24.0F, 0.0F);
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -13.0F, -30.0F,
				-8.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -15.0F, -26.0F,
				-9.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -17.0F, -22.0F,
				-11.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -19.0F, -17.0F,
				-12.0F, 3, 9, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -21.0F, -11.0F,
				-13.0F, 3, 9, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 8.0F, -34.0F,
				4.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 10.0F, -30.0F,
				5.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 12.0F, -26.0F,
				6.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 14.0F, -22.0F,
				7.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -12.0F, -17.0F,
				-19.0F, 3, 9, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 18.0F, -11.0F,
				9.0F, 3, 9, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -11.0F, -34.0F,
				-7.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -11.0F, -34.0F,
				4.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -13.0F, -30.0F,
				5.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -15.0F, -26.0F,
				6.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -17.0F, -22.0F,
				8.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -19.0F, -17.0F,
				9.0F, 3, 9, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -21.0F, -11.0F,
				10.0F, 3, 9, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 8.0F, -34.0F,
				-7.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 10.0F, -30.0F,
				-8.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 12.0F, -26.0F,
				-9.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 14.0F, -22.0F,
				-11.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 16.0F, -17.0F,
				-12.0F, 3, 9, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 18.0F, -11.0F,
				-13.0F, 3, 9, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -7.0F, -34.0F,
				-11.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -8.0F, -30.0F,
				-13.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -9.0F, -26.0F,
				-15.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -11.0F, -22.0F,
				-17.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 16.0F, -17.0F,
				8.0F, 3, 9, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -13.0F, -11.0F,
				-21.0F, 3, 9, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 4.0F, -34.0F,
				-11.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 5.0F, -30.0F,
				10.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 6.0F, -26.0F,
				-15.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 8.0F, -22.0F,
				-17.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 9.0F, -17.0F,
				-19.0F, 3, 9, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 10.0F, -11.0F,
				-21.0F, 3, 9, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -7.0F, -34.0F,
				8.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -8.0F, -30.0F,
				10.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -9.0F, -26.0F,
				12.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -11.0F, -22.0F,
				14.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -12.0F, -17.0F,
				16.0F, 3, 9, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, -13.0F, -11.0F,
				18.0F, 3, 9, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 4.0F, -34.0F,
				8.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 5.0F, -30.0F,
				-13.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 6.0F, -26.0F,
				12.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 7.0F, -22.0F,
				14.0F, 3, 7, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 8.0F, -17.0F,
				16.0F, 3, 9, 3, 0.0F, false));
		Tentacle1.cubeList.add(new ModelBox(Tentacle1, 52, 54, 9.0F, -11.0F,
				18.0F, 3, 9, 3, 0.0F, false));

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 0, -8.0F, -44.0F, -8.0F, 16,
				22, 16, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		Tentacle1.render(f5);
		Body.render(f5);
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