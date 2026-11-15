package me.anomaly.gcyi;

import zone.rong.mixinbooter.ILateMixinLoader;

import java.util.Collections;
import java.util.List;

// MixinBooter (non-CleanMix) supporting
@SuppressWarnings({"deprecation", "unused"})
public class LegacyLateMixinLoader implements ILateMixinLoader {
    @Override
    public List<String> getMixinConfigs() {
        return Collections.singletonList("mixins.gcyi.json");
    }
}
