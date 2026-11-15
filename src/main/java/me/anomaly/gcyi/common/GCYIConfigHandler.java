package me.anomaly.gcyi.common;

import me.anomaly.gcyi.GCYITags;
import net.minecraftforge.common.config.Config;

@Config(modid = GCYITags.MOD_ID, name = "gregicality_infantilize")
public class GCYIConfigHandler {

    public static Recipe recipe = new Recipe();

    public static class Recipe {
        public boolean enableDurationChange = true;

        public enum Mode {
            MULTIPLY,
            OVERRIDE,
            IGNORE
        }

        public Mode defaultMode = Mode.OVERRIDE;
        public float defaultValue = 5.0f;

        @Config.Comment("The mode for changing special recipe durations.")
        public String[] configurations = new String[]{
                "gregtech.api.recipes.builders.FuelRecipeBuilder;MULTIPLY;10.0",
        };

        public boolean enableParallelChange = false;

        @Config.Comment("Unsupported with Electric Furnace")
        public int defaultParallel = 10;
    }

    public static Misc misc = new Misc();

    public static class Misc {
        public boolean enableAllSuperconductors = true;

        public boolean enableMachinesDestroy = false;

        public boolean enableFluidDrillMaxProgressModify = true;

        public boolean enableMinerModify = true;

        public boolean enableInfiniteEnergy = false;
    }

    public static Machines machines = new Machines();

    public static class Machines {
        public boolean enableNateMiner = true;
    }

    public static Tool tool = new Tool();

    public static class Tool {
        public boolean enableToolChanges = true;
        public boolean enableAllToolsUnbreakable = false;

        public enum Mode {
            MULTIPLY,
            APPEND,
            IGNORE
        }

        public Mode harvestSpeedModifyMode = Mode.MULTIPLY;
        public float harvestSpeedModifyValue = 3.0f;

        public float applyHarvestSpeed(float original) {
            return switch (harvestSpeedModifyMode) {
                case MULTIPLY -> original * harvestSpeedModifyValue;
                case APPEND -> original + harvestSpeedModifyValue;
                default -> original;
            };
        }

        public Mode attackDamageModifyMode = Mode.APPEND;
        public float attackDamageModifyValue = 5.5f;

        public float applyAttackDamage(float original) {
            return switch (attackDamageModifyMode) {
                case MULTIPLY -> original * attackDamageModifyValue;
                case APPEND -> original + attackDamageModifyValue;
                default -> original;
            };
        }

        public Mode durabilityModifyMode = Mode.MULTIPLY;
        public int durabilityModifyValue = 10;

        public int applyDurability(int original) {
            return switch (durabilityModifyMode) {
                case MULTIPLY -> original * durabilityModifyValue;
                case APPEND -> original + durabilityModifyValue;
                default -> original;
            };
        }

        public Mode enchantAbilityModifyMode = Mode.APPEND;
        public int enchantAbilityModifyValue = 2;

        public int applyEnchantAbility(int original) {
            return switch (enchantAbilityModifyMode) {
                case MULTIPLY -> original * enchantAbilityModifyValue;
                case APPEND -> original + enchantAbilityModifyValue;
                default -> original;
            };
        }

        public Mode attackSpeedModifyMode = Mode.APPEND;
        public float attackSpeedModifyValue = 3.0f;

        public float applyAttackSpeed(float original) {
            return switch (attackSpeedModifyMode) {
                case MULTIPLY -> original * attackSpeedModifyValue;
                case APPEND -> original + attackSpeedModifyValue;
                default -> original;
            };
        }
    }

    public static Tank tank = new Tank();

    public static class Tank {
        public boolean enableTankChanges = true;

        public int defaultTier1Capacity = 8000000;
        public int defaultTier2Capacity = 16000000;
        public int defaultTier3Capacity = 32000000;
        public int defaultTier4Capacity = 64000000;
        public int defaultHigherTierCapacity = 128000000;
    }
}
