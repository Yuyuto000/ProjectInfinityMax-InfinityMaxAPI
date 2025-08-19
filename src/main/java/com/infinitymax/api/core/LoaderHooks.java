package com.infinitymax.api.core;

import java.util.ArrayList;
import java.util.List;

/**
 * ロードフック管理
 * 初期化時やリロード時に呼ばれる処理を登録
 */
public class LoaderHooks {

    private static final List<Runnable> INIT_HOOKS = new ArrayList<>();
    private static final List<Runnable> RELOAD_HOOKS = new ArrayList<>();

    /** 初期化時フック追加 */
    public static void addInitHook(Runnable hook) { INIT_HOOKS.add(hook); }

    /** リロード時フック追加 */
    public static void addReloadHook(Runnable hook) { RELOAD_HOOKS.add(hook); }

    /** 初期化フック呼び出し */
    public static void callInitHooks() {
        for (Runnable r : INIT_HOOKS) r.run();
        LogHelper.info("[LoaderHooks] 初期化フック呼び出し完了");
    }

    /** リロードフック呼び出し */
    public static void callReloadHooks() {
        for (Runnable r : RELOAD_HOOKS) r.run();
        LogHelper.info("[LoaderHooks] リロードフック呼び出し完了");
    }
}
