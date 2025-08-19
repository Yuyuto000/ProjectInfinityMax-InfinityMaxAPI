package com.infinitymax.api.energy;

import java.util.HashMap;
import java.util.Map;

/**
 * エネルギーネットワーク管理
 * マシンやケーブル間のエネルギー流通を制御
 */
public class EnergyNetwork {

    private static final Map<String, IEnergyStorage> NETWORK_NODES = new HashMap<>();

    /** ネットワークにノードを追加 */
    public static void addNode(String id, IEnergyStorage node) {
        NETWORK_NODES.put(id, node);
    }

    /** ノード削除 */
    public static void removeNode(String id) {
        NETWORK_NODES.remove(id);
    }

    /** エネルギー伝達（簡易版） */
    public static void transfer(String fromId, String toId, int amount) {
        IEnergyStorage from = NETWORK_NODES.get(fromId);
        IEnergyStorage to = NETWORK_NODES.get(toId);
        if(from == null || to == null) return;

        int extracted = from.extractEnergy(amount, false);
        to.receiveEnergy(extracted, false);
    }
}
