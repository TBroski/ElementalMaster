/**
 * This mod element is always locked. Enter your code in the methods below.
 * If you don't need some of these methods, you can remove them as they
 * are overrides of the base class ElementalmasterModElements.ModElement.
 *
 * You can register new events in this class too.
 *
 * As this class is loaded into mod element list, it NEEDS to extend
 * ModElement class. If you remove this extend statement or remove the
 * constructor, the compilation will fail.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser - New... and make sure to make the class
 * outside net.bukkit.elementalmaster as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
*/
package net.bukkit.elementalmaster;

import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import java.util.Map;
import net.minecraft.client.Minecraft;
import java.util.List;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.entity.EntityType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.ItemRenderer;


import net.bukkit.elementalmaster.potion.FrozenEffectPotion;

@ElementalmasterModElements.ModElement.Tag
public class FrozenMobLayer extends ElementalmasterModElements.ModElement {
	/**
	 * Do not remove this constructor
	 */
	public FrozenMobLayer(ElementalmasterModElements instance) {
		super(instance, 693);
	}

	/**
	 * Author: TBroski
	 */
	@OnlyIn(Dist.CLIENT)
    @Override
    public void clientLoad(FMLClientSetupEvent event)
    {
        Map<EntityType<?>, EntityRenderer<?>> entityMap = Minecraft.getInstance().getRenderManager().renderers;
        for (Map.Entry<EntityType<?>, EntityRenderer<?>> renderer : entityMap.entrySet())
        {
            if (renderer.getValue() instanceof LivingRenderer) {
                addEntityLayers((LivingRenderer) renderer.getValue());
            }
        }
    }

	@Override
	public void initElements() {
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}

	@Override
	public void serverLoad(FMLServerStartingEvent event) {
	}

	/**
	 * Author: TBroski
	 */
    public static void addEntityLayers(LivingRenderer renderer)
    {
        List<LayerRenderer<LivingEntity, SegmentedModel<LivingEntity>>> layers = ObfuscationReflectionHelper.getPrivateValue(LivingRenderer.class, renderer, "field_177097_h");
        if(layers != null)
        {
            layers.add(new FrozenMobLayers<>(renderer));
        }
    }

	/**
	 * Author: TBroski
	 */
	public static class FrozenMobLayers<T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
	
	    private static final ResourceLocation resourcelocation = new ResourceLocation("elementalmaster", "textures/entity/layer/frozen.png");
	    private EntityModel model;
	    
	    public FrozenMobLayers(IEntityRenderer<T, M> entityRendererIn) {
	        super(entityRendererIn);
	        this.model = entityRendererIn.getEntityModel();
	    }
	
	    @Override
	    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
	
	        if (entitylivingbaseIn.isPotionActive(FrozenEffectPotion.potion)) //entitylivingbaseIn.getEntity().getPersistentData().getInt("affiliatedplayer") != 0
	        {
	            matrixStackIn.push();
	            this.getEntityModel().copyModelAttributesTo(this.model);
	            this.model.setRotationAngles(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
	            IVertexBuilder ivertexbuilder = ItemRenderer.getBuffer(bufferIn, this.model.getRenderType(resourcelocation), false, false);
	            this.model.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	            matrixStackIn.pop();
	        }
	    }
	}
    
}
