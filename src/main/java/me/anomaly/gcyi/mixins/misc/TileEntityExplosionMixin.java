package me.anomaly.gcyi.mixins.misc;

import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.pipenet.tile.TileEntityPipeBase;
import me.anomaly.gcyi.common.GCYIConfigHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = {MetaTileEntity.class, TileEntityPipeBase.class}, remap = false)
public class TileEntityExplosionMixin {

    @Inject(method = "doExplosion", at = @At("HEAD"), cancellable = true)
    private void modifyTileEntityExplosion(float explosionPower, CallbackInfo ci) {
        if (!GCYIConfigHandler.misc.enableMachinesDestroy) ci.cancel();
    }

}
