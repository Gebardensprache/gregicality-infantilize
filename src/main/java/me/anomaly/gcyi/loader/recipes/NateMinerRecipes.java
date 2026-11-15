package me.anomaly.gcyi.loader.recipes;

import gregtech.api.unification.material.Material;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.material.properties.PropertyKey;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.core.unification.material.internal.MaterialRegistryManager;
import me.anomaly.gcyi.api.recipes.GCYIRecipeMaps;

public class NateMinerRecipes {

    public static void init() {
        for (Material registerMaterial : MaterialRegistryManager.getInstance().getRegisteredMaterials()) {
            if (registerMaterial.hasProperty(PropertyKey.ORE)) {
                addOreMinerRecipe(registerMaterial, OrePrefix.ore);
                addOreMinerRecipe(registerMaterial, OrePrefix.oreNetherrack);
                addOreMinerRecipe(registerMaterial, OrePrefix.oreEndstone);
            }
        }

        addFluidMinerRecipe(Materials.Water);
        addFluidMinerRecipe(Materials.SaltWater);
        addFluidMinerRecipe(Materials.Lava);
        addFluidMinerRecipe(Materials.Oil);
        addFluidMinerRecipe(Materials.NaturalGas);
        addFluidMinerRecipe(Materials.OilHeavy);
        addFluidMinerRecipe(Materials.OilLight);
        addFluidMinerRecipe(Materials.RawOil);
    }

    private static void addOreMinerRecipe(Material material, OrePrefix prefix) {
        GCYIRecipeMaps.N_MINER.recipeBuilder()
                .input(prefix, material)
                .output(prefix, material, 64)
                .duration(100)
                .EUt(1)
                .buildAndRegister();
    }

    private static void addFluidMinerRecipe(Material material) {
        GCYIRecipeMaps.N_MINER.recipeBuilder()
                .fluidInputs(material.getFluid(1))
                .fluidOutputs(material.getFluid(1000))
                .duration(100)
                .EUt(1)
                .buildAndRegister();
    }

}
