package me.anomaly.gcyi.mixins.recipes;

import gregtech.api.capability.impl.AbstractRecipeLogic;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.machines.RecipeMapFurnace;
import me.anomaly.gcyi.common.GCYIConfigHandler;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = AbstractRecipeLogic.class, remap = false)
public abstract class RecipeLogicMixin {

    @Shadow
    @Final
    private RecipeMap<?> recipeMap;

    @Shadow
    public abstract void setParallelLimit(int amount);

    @Inject(method = "getParallelLimit", at = {@At("HEAD")})
    private void modifyDefaultParallelLimit(CallbackInfoReturnable<Integer> cir) {
        if (!(this.recipeMap instanceof RecipeMapFurnace) && GCYIConfigHandler.recipe.enableParallelChange) {
            this.setParallelLimit(GCYIConfigHandler.recipe.defaultParallel);
        }
    }

}
