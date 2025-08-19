package com.infinitymax.api.energy;

/**
 * エネルギーCompatインターフェース
 * 他MODのエネルギーを統一的に扱うための抽象
 */
public interface IEnergyCompat {
    boolean isEnergyItem(Object itemStack);
    int getEnergy(Object itemStack);
    int getMaxEnergy(Object itemStack);
    int receiveEnergy(Object itemStack, int amount, boolean simulate);
    int extractEnergy(Object itemStack, int amount, boolean simulate);
}
