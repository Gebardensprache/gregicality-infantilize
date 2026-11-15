package me.anomaly.gcyi.mixins.misc;

import gregtech.api.capability.impl.FluidDrillLogic;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(value = FluidDrillLogic.class, remap = false)
public interface FluidDrillLogicAccessor {

    @Accessor("MAX_PROGRESS")
    static void setMaxProgress(int arg) {
        throw new AssertionError();
    }

}
