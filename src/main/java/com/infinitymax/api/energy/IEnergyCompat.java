package com.infinitymax.api.energy;

public interface IEnergyCompat {
    boolean isEnergyItem(Object itemStack);
    int getEnergy(Object itemStack);
    int getMaxEnergy(Object itemStack);
    int receiveEnergy(Object itemStack, int amount, boolean simulate);
    int extractEnergy(Object itemStack, int amount, boolean simulate);
}
