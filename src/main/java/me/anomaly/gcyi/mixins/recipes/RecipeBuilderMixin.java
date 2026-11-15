package me.anomaly.gcyi.mixins.recipes;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import gregtech.api.recipes.RecipeBuilder;
import me.anomaly.gcyi.common.GCYIConfigHandler;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = RecipeBuilder.class, remap = false)
public class RecipeBuilderMixin<R extends RecipeBuilder<R>> {

    @WrapOperation(
            method = "duration",
            at = @At(value = "FIELD", target = "Lgregtech/api/recipes/RecipeBuilder;duration:I", opcode = Opcodes.PUTFIELD)
    )
    private void modifyDuration(RecipeBuilder<R> instance, int newValue, Operation<Void> original) {
        if (!GCYIConfigHandler.recipe.enableDurationChange) {
            original.call(instance, newValue);
            return;
        }

        final String className = instance.getClass().getName();
        for (String configuration : GCYIConfigHandler.recipe.configurations) {
            String[] parts = configuration.split(";");
            String targetClassName = parts[0];
            String modeString = parts[1];

            if (className.equals(targetClassName)) {
                GCYIConfigHandler.Recipe.Mode mode;
                try {
                    mode = GCYIConfigHandler.Recipe.Mode.valueOf(modeString);
                } catch (IllegalArgumentException e) {continue;}

                if (mode == GCYIConfigHandler.Recipe.Mode.OVERRIDE) {
                    original.call(instance, Integer.parseInt(parts[2]));
                } else if (mode == GCYIConfigHandler.Recipe.Mode.MULTIPLY) {
                    original.call(instance, (int) (newValue * Float.parseFloat(parts[2])));
                } else if (mode == GCYIConfigHandler.Recipe.Mode.IGNORE) {
                    original.call(instance, newValue);
                }
                return;
            }
        }

        if (GCYIConfigHandler.recipe.defaultMode == GCYIConfigHandler.Recipe.Mode.OVERRIDE) {
            original.call(instance, (int) GCYIConfigHandler.recipe.defaultValue);
        } else if (GCYIConfigHandler.recipe.defaultMode == GCYIConfigHandler.Recipe.Mode.MULTIPLY) {
            original.call(instance, (int) (newValue * GCYIConfigHandler.recipe.defaultValue));
        } else {
            original.call(instance, newValue);
        }
    }

}
