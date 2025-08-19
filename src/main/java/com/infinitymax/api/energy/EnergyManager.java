package com.infinitymax.api.energy;

/**
 * エネルギー管理統合マネージャ
 */
public class EnergyManager {

    /**
     * NeoForge/Fabric両対応で登録済みのCompatを取得
     */
    public static IEnergyCompat getCompat() {
        return com.infinitymax.api.core.CompatLoader.getEnergyCompat();
    }
}
