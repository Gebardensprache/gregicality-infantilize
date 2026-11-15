package me.anomaly.gcyi.mixins.misc;

import gregtech.api.capability.impl.miner.MultiblockMinerLogic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = MultiblockMinerLogic.class, remap = false)
public interface MultiblockMinerLogicAccessor {

    @Accessor("CHUNK_LENGTH")
    static void setChunkLength(int arg) {
        throw new AssertionError();
    }

}
