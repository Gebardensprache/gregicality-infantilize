package me.anomaly.gcyi.api.recipes;

import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.RecipeMapBuilder;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;

public class GCYIRecipeMaps {

    public static final RecipeMap<SimpleRecipeBuilder> N_MINER = new RecipeMapBuilder<>(
            "n_miner", new SimpleRecipeBuilder()
    ).itemInputs(1).itemOutputs(4).fluidInputs(1).fluidOutputs(1).build();

}
