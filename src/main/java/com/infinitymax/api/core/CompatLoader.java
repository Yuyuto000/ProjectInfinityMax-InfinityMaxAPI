package com.infinitymax.api.core;

import com.infinitymax.api.energy.IEnergyCompat;
import com.infinitymax.api.platform.PlatformLoader;
import com.infinitymax.impl.fabric.FabricEnergyCompat;
import com.infinitymax.impl.neoforge.NeoForgeEnergyCompat;

public class CompatLoader {

    private static IEnergyCompat energyCompat;

    public static void init() {
        String loader = PlatformLoader.getLoaderName();
        switch(loader) {
            case "NeoForge": energyCompat = new NeoForgeEnergyCompat(); break;
            case "Fabric": energyCompat = new FabricEnergyCompat(); break;
            default: throw new RuntimeException("Unsupported Loader: " + loader);
        }
    }

    public static IEnergyCompat getEnergyCompat() {
        if (energyCompat == null) throw new IllegalStateException("Compat not initialized!");
        return energyCompat;
    }
}
