package com.jerry.mekanismcraftitem.client.render.item.block;

import com.jerry.mekanism_extras.client.render.tileentity.ExtraRenderEnergyCube;
import com.jerry.mekanism_extras.common.block.storage.energycube.ECTier;
import com.jerry.mekanism_extras.common.block.storage.energycube.ExtraTileEntityEnergyCube;
import com.jerry.mekanismcraftitem.common.item.block.CraftExtraItemBlockEnergyCube;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import mekanism.api.RelativeSide;
import mekanism.client.render.MekanismRenderer;
import mekanism.client.render.item.MekanismISTER;
import mekanism.common.lib.transmitter.TransmissionType;
import mekanism.common.tile.component.config.DataType;
import mekanism.common.util.EnumUtils;
import mekanism.common.util.ItemDataUtils;
import mekanism.common.util.StorageUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.model.data.ModelData;
import org.jetbrains.annotations.NotNull;

public class CraftExtraRenderEnergyCubeItem extends MekanismISTER {
    public static final CraftExtraRenderEnergyCubeItem CRAFT_EXTRA_RENDERER = new CraftExtraRenderEnergyCubeItem();
//    private ExtraModelEnergyCore core;

    public CraftExtraRenderEnergyCubeItem() {
    }

    public void onResourceManagerReload(@NotNull ResourceManager resourceManager) {
//        core = new ExtraModelEnergyCore(this.getEntityModels());
    }

    public void renderByItem(@NotNull ItemStack stack, @NotNull ItemDisplayContext displayContext, @NotNull PoseStack matrix, @NotNull MultiBufferSource renderer, int light, int overlayLight) {
        ECTier tier = ((CraftExtraItemBlockEnergyCube)stack.getItem()).getAdvanceTier();
        ExtraTileEntityEnergyCube.CubeSideState[] sideStates = new ExtraTileEntityEnergyCube.CubeSideState[EnumUtils.SIDES.length];
        CompoundTag configData = ItemDataUtils.getDataMapIfPresent(stack);
        int var12;
        if (configData != null && configData.contains("componentConfig", 10)) {
            CompoundTag sideConfig = configData.getCompound("componentConfig").getCompound("config" + TransmissionType.ENERGY.ordinal());
            RelativeSide[] var19 = EnumUtils.SIDES;
            var12 = var19.length;

            for(int var21 = 0; var21 < var12; ++var21) {
                RelativeSide side = var19[var21];
                DataType dataType = DataType.byIndexStatic(sideConfig.getInt("side" + side.ordinal()));
                ExtraTileEntityEnergyCube.CubeSideState state = ExtraTileEntityEnergyCube.CubeSideState.INACTIVE;
                if (dataType != DataType.NONE) {
                    state = dataType.canOutput() ? ExtraTileEntityEnergyCube.CubeSideState.ACTIVE_LIT : ExtraTileEntityEnergyCube.CubeSideState.ACTIVE_UNLIT;
                }

                sideStates[side.ordinal()] = state;
            }
        } else {
            RelativeSide[] var10 = EnumUtils.SIDES;
            int var11 = var10.length;

            for(var12 = 0; var12 < var11; ++var12) {
                RelativeSide side = var10[var12];
                sideStates[side.ordinal()] = side == RelativeSide.FRONT ? ExtraTileEntityEnergyCube.CubeSideState.ACTIVE_LIT : ExtraTileEntityEnergyCube.CubeSideState.ACTIVE_UNLIT;
            }
        }

        ModelData modelData = ModelData.builder().with(ExtraTileEntityEnergyCube.SIDE_STATE_PROPERTY, sideStates).build();
        this.renderBlockItem(stack, displayContext, matrix, renderer, light, overlayLight, modelData);
        double energyPercentage = StorageUtils.getStoredEnergyFromNBT(stack).divideToLevel(tier.getMaxEnergy());
        if (energyPercentage > 0.0) {
            float ticks = (float) Minecraft.getInstance().levelRenderer.getTicks() + MekanismRenderer.getPartialTick();
            float scaledTicks = 4.0F * ticks;
            matrix.pushPose();
            matrix.translate(0.5, 0.5, 0.5);
            matrix.scale(0.4F, 0.4F, 0.4F);
            matrix.translate(0.0, Math.sin(Math.toRadians(3.0F * ticks)) / 7.0, 0.0);
            matrix.mulPose(Axis.YP.rotationDegrees(scaledTicks));
            matrix.mulPose(ExtraRenderEnergyCube.coreVec.rotationDegrees(36.0F + scaledTicks));
            //用扳手将带有电的能量立方敲下会导致core为null
//            core.render(matrix, renderer, 15728880, overlayLight, EnergyCubeColor.getColor(tier), (float)energyPercentage);
            matrix.popPose();
        }

    }
}
