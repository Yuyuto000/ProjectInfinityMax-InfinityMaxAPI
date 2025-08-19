package com.infinitymax.api.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 共通レジストリ管理
 * NeoForge/Fabric 両対応、API内 HashMap で管理
 */
public class RegistryHandler {

    private static final Map<String, Object> ITEM_REGISTRY = new HashMap<>();
    private static final Map<String, Object> BLOCK_REGISTRY = new HashMap<>();

    // -------------------
    // アイテム
    // -------------------
    public static void registerItem(String name, Object item) {
        if (ITEM_REGISTRY.containsKey(name)) {
            LogHelper.warn("[RegistryHandler] アイテム " + name + " は既に登録済み");
            return;
        }
        ITEM_REGISTRY.put(name, item);
    }

    public static Object getItem(String name) { return ITEM_REGISTRY.get(name); }

    // -------------------
    // ブロック
    // -------------------
    public static void registerBlock(String name, Object block) {
        if (BLOCK_REGISTRY.containsKey(name)) {
            LogHelper.warn("[RegistryHandler] ブロック " + name + " は既に登録済み");
            return;
        }
        BLOCK_REGISTRY.put(name, block);
    }

    public static Object getBlock(String name) { return BLOCK_REGISTRY.get(name); }
}
