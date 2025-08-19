package com.infinitymax.api.energy;

/**
 * エネルギー貯蔵インターフェース
 */
public interface IEnergyStorage {
    int receiveEnergy(int maxReceive, boolean simulate);
    int extractEnergy(int maxExtract, boolean simulate);
    int getEnergyStored();
    int getMaxEnergyStored();
    boolean canExtract();
    boolean canReceive();
}
