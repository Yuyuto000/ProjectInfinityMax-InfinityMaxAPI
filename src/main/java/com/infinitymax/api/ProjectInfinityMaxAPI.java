package com.infinitymax.api;

import java.util.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import com.infinitymax.api.core.CompatLoader;

/**
 * =====================================================
 * Project Infinity Max API
 * NeoForge/Fabric 両対応
 * =====================================================
 */
public class ProjectInfinityMaxAPI {

    private static final Map<String, Item> ITEM_REGISTRY = new HashMap<>();
    private static final Map<String, Block> BLOCK_REGISTRY = new HashMap<>();
    private static final Map<String, List<Runnable>> EVENT_BUS = new HashMap<>();
    private static final Map<String, Object> SHARED_DATA = new HashMap<>();

    // -------------------
    // アイテム・ブロック管理
    // -------------------
    public static void registerItem(String name, Item item) {
        if (ITEM_REGISTRY.containsKey(name)) return;
        ITEM_REGISTRY.put(name, item);
    }

    public static Item getItem(String name) { return ITEM_REGISTRY.get(name); }

    public static void registerBlock(String name, Block block) {
        if (BLOCK_REGISTRY.containsKey(name)) return;
        BLOCK_REGISTRY.put(name, block);
    }

    public static Block getBlock(String name) { return BLOCK_REGISTRY.get(name); }

    // -------------------
    // イベントシステム
    // -------------------
    public static void registerEvent(String eventName, Runnable listener) {
        EVENT_BUS.computeIfAbsent(eventName, k -> new ArrayList<>()).add(listener);
    }

    public static void fireEvent(String eventName) {
        List<Runnable> listeners = EVENT_BUS.get(eventName);
        if (listeners != null) listeners.forEach(Runnable::run);
    }

    // -------------------
    // データ同期
    // -------------------
    public static void setSharedData(String key, Object value) { SHARED_DATA.put(key, value); }
    public static Object getSharedData(String key) { return SHARED_DATA.get(key); }

    // -------------------
    // API初期化
    // -------------------
    public static void init() {
        System.out.println("[InfinityMaxAPI] 初期化開始");
        CompatLoader.init(); // NeoForge/Fabric Compat自動ロード
        System.out.println("[InfinityMaxAPI] 初期化完了");
    }
}
