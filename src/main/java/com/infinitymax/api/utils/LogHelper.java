package com.infinitymax.api.util;

/**
 * 共通ログ出力
 */
public class LogHelper {

    public static void info(String msg) { System.out.println("[INFO] " + msg); }
    public static void warn(String msg) { System.out.println("[WARN] " + msg); }
    public static void error(String msg) { System.err.println("[ERROR] " + msg); }
}
