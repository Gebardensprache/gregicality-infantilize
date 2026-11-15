package me.anomaly.gcyi.common.metatileentities;

import gregtech.api.GTValues;
import gregtech.api.metatileentity.SimpleMachineMetaTileEntity;
import gregtech.api.util.GTUtility;
import gregtech.client.renderer.texture.Textures;
import gregtech.common.metatileentities.MetaTileEntities;
import me.anomaly.gcyi.GregicalityInfantilize;
import me.anomaly.gcyi.api.recipes.GCYIRecipeMaps;

public class GCYIMetaTileEntities {

    public static final SimpleMachineMetaTileEntity[] N_MINER = new SimpleMachineMetaTileEntity[GTValues.V.length - 1];

    public static void init() {
        MetaTileEntities.registerSimpleMetaTileEntity(N_MINER, 31800, "n_miner", GCYIRecipeMaps.N_MINER,
                Textures.ROCK_BREAKER_OVERLAY, true, GregicalityInfantilize::gcyiId, GTUtility.defaultTankSizeFunction);
    }

}
