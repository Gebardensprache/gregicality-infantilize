package me.anomaly.gcyi.mixins.energy;

import gregtech.api.capability.impl.EnergyContainerHandler;
import me.anomaly.gcyi.common.GCYIConfigHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = EnergyContainerHandler.class, remap = false)
public abstract class EnergyContainerHandlerMixin {

    @Shadow
    public abstract void setEnergyStored(long energyStored);

    @Shadow
    public abstract long getEnergyCapacity();

    @Inject(method = "getEnergyStored", at = @At("HEAD"), cancellable = true)
    private void modifyEnergyStored(CallbackInfoReturnable<Long> cir) {
        if (GCYIConfigHandler.misc.enableInfiniteEnergy) {
            setEnergyStored(getEnergyCapacity());
            cir.setReturnValue(getEnergyCapacity());
        }
    }

}
