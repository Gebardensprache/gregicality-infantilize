package me.anomaly.gcyi.mixins.misc;

import gregtech.api.unification.material.properties.WireProperties;
import me.anomaly.gcyi.common.GCYIConfigHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = WireProperties.class, remap = false)
public class WirePropertiesMixin {

    @ModifyVariable(
            method = "<init>(IIIZI)V",
            at = @At("HEAD"),
            ordinal = 2,
            argsOnly = true)
    private static int modifyWireProperties(int value) {
        if (!GCYIConfigHandler.misc.enableAllSuperconductors) return value;
        return 0;
    }

}
