
/**
 * ModelBlaze - Either Mojang or a mod author Created using Tabula 7.0.1
 */
public static class ModelFreezeBlaze extends ModelBase {
	public ModelRenderer field_78106_a11;
	public ModelRenderer field_78106_a10;
	public ModelRenderer field_78106_a1;
	public ModelRenderer field_78106_a2;
	public ModelRenderer field_78106_a12;
	public ModelRenderer field_78105_b;
	public ModelRenderer field_78106_a7;
	public ModelRenderer field_78106_a8;
	public ModelRenderer field_78106_a9;
	public ModelRenderer field_78106_a3;
	public ModelRenderer field_78106_a4;
	public ModelRenderer field_78106_a5;
	public ModelRenderer field_78106_a6;

	public ModelFreezeBlaze() {
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.field_78106_a9 = new ModelRenderer(this, 0, 16);
		this.field_78106_a9.setRotationPoint(4.455076217651367F, 11.960163116455078F, 2.269866943359375F);
		this.field_78106_a9.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.field_78106_a4 = new ModelRenderer(this, 0, 16);
		this.field_78106_a4.setRotationPoint(0.0F, -1.929208517074585F, -9.0F);
		this.field_78106_a4.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.field_78106_a2 = new ModelRenderer(this, 0, 16);
		this.field_78106_a2.setRotationPoint(1.1021821408568715E-15F, -1.1224087476730347F, 9.0F);
		this.field_78106_a2.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.field_78106_a3 = new ModelRenderer(this, 0, 16);
		this.field_78106_a3.setRotationPoint(-9.0F, -1.4596672058105469F, 1.1021821408568715E-15F);
		this.field_78106_a3.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.field_78106_a8 = new ModelRenderer(this, 0, 16);
		this.field_78106_a8.setRotationPoint(4.949747562408447F, 1.0635323524475098F, -4.949747562408447F);
		this.field_78106_a8.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.field_78106_a12 = new ModelRenderer(this, 0, 16);
		this.field_78106_a12.setRotationPoint(2.269866943359375F, 10.614307403564453F, -4.455076217651367F);
		this.field_78106_a12.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.field_78106_a11 = new ModelRenderer(this, 0, 16);
		this.field_78106_a11.setRotationPoint(-4.455076217651367F, 11.346710205078125F, -2.269866943359375F);
		this.field_78106_a11.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.field_78106_a5 = new ModelRenderer(this, 0, 16);
		this.field_78106_a5.setRotationPoint(4.949747562408447F, 1.5839191675186157F, 4.949747562408447F);
		this.field_78106_a5.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.field_78106_a10 = new ModelRenderer(this, 0, 16);
		this.field_78106_a10.setRotationPoint(-2.269866943359375F, 11.8930082321167F, 4.455076217651367F);
		this.field_78106_a10.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.field_78105_b = new ModelRenderer(this, 0, 0);
		this.field_78105_b.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.field_78105_b.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
		this.field_78106_a6 = new ModelRenderer(this, 0, 16);
		this.field_78106_a6.setRotationPoint(-4.949747562408447F, 1.1989107131958008F, 4.949747562408447F);
		this.field_78106_a6.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.field_78106_a1 = new ModelRenderer(this, 0, 16);
		this.field_78106_a1.setRotationPoint(9.0F, -1.0F, 0.0F);
		this.field_78106_a1.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.field_78106_a7 = new ModelRenderer(this, 0, 16);
		this.field_78106_a7.setRotationPoint(-4.949747562408447F, 1.0100092887878418F, -4.949747562408447F);
		this.field_78106_a7.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.field_78106_a9.render(f5);
		this.field_78106_a4.render(f5);
		this.field_78106_a2.render(f5);
		this.field_78106_a3.render(f5);
		this.field_78106_a8.render(f5);
		this.field_78106_a12.render(f5);
		this.field_78106_a11.render(f5);
		this.field_78106_a5.render(f5);
		this.field_78106_a10.render(f5);
		this.field_78105_b.render(f5);
		this.field_78106_a6.render(f5);
		this.field_78106_a1.render(f5);
		this.field_78106_a7.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.field_78106_a1.rotateAngleX = f2;
		this.field_78106_a2.rotateAngleY = f2;
		this.field_78106_a12.rotateAngleZ = f2;
	}
}
