package com.infinitymax.api.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 簡易ネットワークハンドラー（NeoForge/Fabric共通）
 * パケット登録・送受信の抽象化
 */
public class NetworkHandler {

    private static final Map<String, PacketListener> PACKETS = new HashMap<>();

    /** パケットリスナー登録 */
    public static void registerPacket(String id, PacketListener listener) {
        if (PACKETS.containsKey(id)) {
            LogHelper.warn("[NetworkHandler] パケット " + id + " は既に登録済み");
            return;
        }
        PACKETS.put(id, listener);
        LogHelper.info("[NetworkHandler] パケット登録: " + id);
    }

    /** パケット送信（サーバー/クライアント共通抽象） */
    public static void sendPacket(String id, Object data) {
        PacketListener listener = PACKETS.get(id);
        if (listener != null) listener.onReceive(data);
        else LogHelper.warn("[NetworkHandler] パケット " + id + " のリスナーが未登録");
    }

    /** パケットリスナーインターフェース */
    public interface PacketListener {
        void onReceive(Object data);
    }
}
