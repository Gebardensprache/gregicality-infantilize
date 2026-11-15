package me.anomaly.gcyi.mixins.tank;

import gregtech.api.util.GTUtility;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.function.Function;

@Mixin(value = GTUtility.class, remap = false)
public interface GTUtilityAccessor {
    @Accessor("defaultTankSizeFunction")
    static void setDefaultTankSizeFunction(Function<Integer, Integer> arg) {
        throw new AssertionError();
    }

    @Accessor("hvCappedTankSizeFunction")
    static void setHvCappedTankSizeFunction(Function<Integer, Integer> arg) {
        throw new AssertionError();
    }

    @Accessor("largeTankSizeFunction")
    static void setLargeTankSizeFunction(Function<Integer, Integer> arg) {
        throw new AssertionError();
    }
}
