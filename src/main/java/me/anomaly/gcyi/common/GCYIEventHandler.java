package me.anomaly.gcyi.common;

import me.anomaly.gcyi.GCYITags;
import me.anomaly.gcyi.loader.recipes.GCYIRecipeManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = GCYITags.MOD_ID)
public class GCYIEventHandler {

    @SubscribeEvent
    public static void syncConfigValues(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(GCYITags.MOD_ID)) {
            ConfigManager.sync(GCYITags.MOD_ID, Config.Type.INSTANCE);
        }
    }

    @SubscribeEvent
    public static void recipeRegistry(RegistryEvent.Register<IRecipe> event) {
        GCYIRecipeManager.init();
    }

}
