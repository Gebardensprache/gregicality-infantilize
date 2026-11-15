package me.anomaly.gcyi.loader.recipes;

import me.anomaly.gcyi.common.GCYIConfigHandler;

public class GCYIRecipeManager {

    public static void init() {
        MachineRecipes.init();

        if (GCYIConfigHandler.machines.enableNateMiner) {
            NateMinerRecipes.init();
        }
    }

}
