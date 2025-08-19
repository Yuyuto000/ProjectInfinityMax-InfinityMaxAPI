package com.infinitymax.api.core;

import java.util.*;

/**
 * シンプル共通イベントバス（NeoForge/Fabric 両対応）
 */
public class EventBus {

    private static final Map<String, List<Runnable>> EVENT_MAP = new HashMap<>();

    /**
     * イベント登録
     */
    public static void register(String eventName, Runnable listener) {
        EVENT_MAP.computeIfAbsent(eventName, k -> new ArrayList<>()).add(listener);
        LogHelper.info("[EventBus] イベント登録: " + eventName);
    }

    /**
     * イベント呼び出し
     */
    public static void fire(String eventName) {
        List<Runnable> listeners = EVENT_MAP.get(eventName);
        if (listeners != null) {
            for (Runnable r : listeners) {
                r.run();
            }
        }
    }

    /**
     * 全イベント削除
     */
    public static void clear() {
        EVENT_MAP.clear();
        LogHelper.info("[EventBus] 全イベントクリア");
    }
}
