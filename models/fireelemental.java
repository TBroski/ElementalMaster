//Made with Blockbench
//Paste this code into your mod.

public static class fireelemental extends ModelBase {
	private final ModelRenderer Body;
	private final ModelRenderer Particle;
	private final ModelRenderer Eyes;

	public fireelemental() {
		textureWidth = 16;
		textureHeight = 16;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 24.0F, 0.0F);
		Body.cubeList.add(new ModelBox(Body, 0, 2, -7.0F, -21.0F, 2.0F, 6, 1,
				1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 2, -2.0F, -20.0F, 2.0F, 1, 1,
				1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 2, -7.0F, -20.0F, 2.0F, 1, 1,
				1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 2, -5.0F, -20.0F, 2.0F, 2, 1,
				1, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 2, -7.0F, -21.0F, 3.0F, 6, 5,
				4, 0.0F, false));
		Body.cubeList.add(new ModelBox(Body, 0, 2, -7.0F, -19.0F, 2.0F, 6, 3,
				1, 0.0F, false));

		Particle = new ModelRenderer(this);
		Particle.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Particle);
		Particle.cubeList.add(new ModelBox(Particle, 4, 0, -7.0F, -18.0F,
				-1.0F, 1, 1, 1, 0.0F, false));
		Particle.cubeList.add(new ModelBox(Particle, 4, 0, -9.0F, -18.0F, 0.0F,
				1, 1, 1, 0.0F, false));
		Particle.cubeList.add(new ModelBox(Particle, 4, 0, -9.0F, -18.0F, 2.0F,
				1, 1, 1, 0.0F, false));
		Particle.cubeList.add(new ModelBox(Particle, 4, 0, -10.0F, -19.0F,
				4.0F, 1, 1, 1, 0.0F, false));
		Particle.cubeList.add(new ModelBox(Particle, 4, 0, -5.0F, -19.0F,
				-1.0F, 1, 1, 1, 0.0F, false));
		Particle.cubeList.add(new ModelBox(Particle, 4, 0, -3.0F, -18.0F,
				-1.0F, 1, 1, 1, 0.0F, false));
		Particle.cubeList.add(new ModelBox(Particle, 4, 0, -1.0F, -19.0F,
				-1.0F, 1, 1, 1, 0.0F, false));
		Particle.cubeList.add(new ModelBox(Particle, 4, 0, 0.0F, -20.0F, 1.0F,
				1, 1, 1, 0.0F, false));
		Particle.cubeList.add(new ModelBox(Particle, 4, 0, 1.0F, -19.0F, 3.0F,
				1, 1, 1, 0.0F, false));
		Particle.cubeList.add(new ModelBox(Particle, 4, 0, 0.0F, -18.0F, 5.0F,
				1, 1, 1, 0.0F, false));
		Particle.cubeList.add(new ModelBox(Particle, 4, 0, 0.0F, -19.0F, 7.0F,
				1, 1, 1, 0.0F, false));
		Particle.cubeList.add(new ModelBox(Particle, 4, 0, -1.0F, -18.0F, 9.0F,
				1, 1, 1, 0.0F, false));
		Particle.cubeList.add(new ModelBox(Particle, 4, 0, -3.0F, -19.0F, 8.0F,
				1, 1, 1, 0.0F, false));
		Particle.cubeList.add(new ModelBox(Particle, 4, 0, -5.0F, -18.0F, 9.0F,
				1, 1, 1, 0.0F, false));
		Particle.cubeList.add(new ModelBox(Particle, 4, 0, -7.0F, -18.0F, 8.0F,
				1, 1, 1, 0.0F, false));
		Particle.cubeList.add(new ModelBox(Particle, 4, 0, -9.0F, -18.0F, 8.0F,
				1, 1, 1, 0.0F, false));
		Particle.cubeList.add(new ModelBox(Particle, 4, 0, -10.0F, -18.0F,
				6.0F, 1, 1, 1, 0.0F, false));

		Eyes = new ModelRenderer(this);
		Eyes.setRotationPoint(0.0F, 0.0F, 0.0F);
		Body.addChild(Eyes);
		Eyes.cubeList.add(new ModelBox(Eyes, 0, 0, -6.0F, -20.0F, 2.0F, 1, 1,
				1, 0.0F, false));
		Eyes.cubeList.add(new ModelBox(Eyes, 0, 0, -3.0F, -20.0F, 2.0F, 1, 1,
				1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
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
		this.Body.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Body.rotateAngleX = f4 / (180F / (float) Math.PI);
	}
}