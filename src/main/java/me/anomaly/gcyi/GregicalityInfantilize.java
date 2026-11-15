package me.anomaly.gcyi;

import gregtech.GTInternalTags;
import me.anomaly.gcyi.common.GCYIConfigHandler;
import me.anomaly.gcyi.common.metatileentities.GCYIMetaTileEntities;
import me.anomaly.gcyi.mixins.misc.FluidDrillLogicAccessor;
import me.anomaly.gcyi.mixins.misc.MultiblockMinerLogicAccessor;
import me.anomaly.gcyi.mixins.tank.GTUtilityAccessor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = GCYITags.MOD_ID,
        name = GCYITags.MOD_NAME,
        version = GCYITags.MOD_VERSION,
        useMetadata = true,
        dependencies = GTInternalTags.DEP_VERSION_STRING,
        guiFactory = "me.anomaly.gcyi.client.gui.GCYIConfigGUIFactory"
)
public final class GregicalityInfantilize {
    public static final Logger LOGGER = LogManager.getLogger(GCYITags.MOD_NAME);

    @Mod.EventHandler
    public void onPreInit(final FMLPreInitializationEvent event) {
        GCYIMetaTileEntities.init();
    }

    public static ResourceLocation gcyiId(String path) {
        return new ResourceLocation(GCYITags.MOD_ID, path);
    }

    static {
        if (GCYIConfigHandler.misc.enableFluidDrillMaxProgressModify) {
            FluidDrillLogicAccessor.setMaxProgress(1);
        }

        if (GCYIConfigHandler.misc.enableMinerModify) {
            MultiblockMinerLogicAccessor.setChunkLength(64);
        }

        if (GCYIConfigHandler.tank.enableTankChanges) {
            final int t1 = GCYIConfigHandler.tank.defaultTier1Capacity;
            final int t2 = GCYIConfigHandler.tank.defaultTier2Capacity;
            final int t3 = GCYIConfigHandler.tank.defaultTier3Capacity;
            final int t4 = GCYIConfigHandler.tank.defaultTier4Capacity;
            final int ht = GCYIConfigHandler.tank.defaultHigherTierCapacity;

            GTUtilityAccessor.setDefaultTankSizeFunction((tier) -> {
                if (tier <= 1) {
                    return t1;
                } else if (tier == 2) {
                    return t2;
                } else if (tier == 3) {
                    return t3;
                } else {
                    return tier == 4 ? t4 : ht;
                }
            });
            GTUtilityAccessor.setHvCappedTankSizeFunction((tier) -> {
                if (tier <= 1) {
                    return t1;
                } else {
                    return tier == 2 ? t2 : t3;
                }
            });
            GTUtilityAccessor.setLargeTankSizeFunction((tier) -> {
                if (tier <= 1) {
                    return t3;
                } else {
                    return tier == 2 ? t4 : ht;
                }
            });
        }
    }

}
