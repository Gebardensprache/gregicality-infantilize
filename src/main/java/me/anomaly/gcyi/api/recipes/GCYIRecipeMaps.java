package me.anomaly.gcyi.api.recipes;

import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;

public class GCYIRecipeMaps {

    public static final RecipeMap<SimpleRecipeBuilder> N_MINER = new RecipeMap<>(
            "n_miner", 1, 4, 1, 1, new SimpleRecipeBuilder(), false
    );

}
