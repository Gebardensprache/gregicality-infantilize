package me.anomaly.gcyi.mixins.tool;

import gregtech.api.unification.material.properties.ToolProperty;
import me.anomaly.gcyi.common.GCYIConfigHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ToolProperty.class, remap = false)
public abstract class ToolPropertyMixin {

    @Shadow
    private float harvestSpeed;

    @Shadow
    private float attackDamage;

    @Shadow
    private int durability;

    @Shadow
    private int enchantability;

    @Shadow
    private float attackSpeed;

    @Shadow
    public abstract ToolProperty setUnbreakable(boolean isUnbreakable);

    @Inject(
            method = "<init>(FFII)V",
            at = @At("TAIL")
    )
    private void modifyToolArgs(float harvestSpeed, float attackDamage, int durability, int harvestLevel, CallbackInfo ci) {
        if (GCYIConfigHandler.tool.enableToolChanges) {
            this.harvestSpeed = GCYIConfigHandler.tool.applyHarvestSpeed(harvestSpeed);
            this.attackDamage = GCYIConfigHandler.tool.applyAttackDamage(attackDamage);
            this.durability = GCYIConfigHandler.tool.applyDurability(durability);
            this.enchantability = GCYIConfigHandler.tool.applyEnchantAbility(enchantability);
            this.attackSpeed = GCYIConfigHandler.tool.applyAttackSpeed(attackSpeed);
            if (GCYIConfigHandler.tool.enableAllToolsUnbreakable) setUnbreakable(true);
        }
    }



}
