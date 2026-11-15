package me.anomaly.gcyi.loader.recipes;

import me.anomaly.gcyi.common.metatileentities.GCYIMetaTileEntities;

import static gregtech.loaders.recipe.CraftingComponent.CABLE;
import static gregtech.loaders.recipe.CraftingComponent.HULL;
import static gregtech.loaders.recipe.CraftingComponent.MOTOR;
import static gregtech.loaders.recipe.CraftingComponent.PISTON;
import static gregtech.loaders.recipe.MetaTileEntityLoader.registerMachineRecipe;

public class MachineRecipes {

    public static void init() {
        registerMachineRecipe(GCYIMetaTileEntities.N_MINER, "PPP", "CHC", "MMM", 'P', PISTON, 'M', MOTOR,
                'C', CABLE, 'H', HULL);
    }

}
