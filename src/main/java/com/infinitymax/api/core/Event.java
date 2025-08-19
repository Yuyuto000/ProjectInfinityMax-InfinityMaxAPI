package com.infinitymax.api.core;

/**
 * 共通イベント基底クラス
 * イベント名・発生タイミングなどを持たせることが可能
 */
public class Event {
    private final String name;

    public Event(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
