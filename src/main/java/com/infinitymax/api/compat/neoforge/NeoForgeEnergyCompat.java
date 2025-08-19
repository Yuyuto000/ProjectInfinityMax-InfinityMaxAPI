package com.infinitymax.impl.neoforge;

import com.infinitymax.api.energy.IEnergyCompat;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.energy.CapabilityEnergy;

public class NeoForgeEnergyCompat implements IEnergyCompat {
    @Override public boolean isEnergyItem(Object obj) { return obj instanceof ItemStack s && s.getCapability(CapabilityEnergy.ENERGY).isPresent(); }
    @Override public int getEnergy(Object obj) { ItemStack s = (ItemStack)obj; return s.getCapability(CapabilityEnergy.ENERGY).map(IEnergyStorage::getEnergyStored).orElse(0); }
    @Override public int getMaxEnergy(Object obj) { ItemStack s = (ItemStack)obj; return s.getCapability(CapabilityEnergy.ENERGY).map(IEnergyStorage::getMaxEnergyStored).orElse(0); }
    @Override public int receiveEnergy(Object obj, int amount, boolean simulate) { ItemStack s = (ItemStack)obj; return s.getCapability(CapabilityEnergy.ENERGY).map(cap -> cap.receiveEnergy(amount, simulate)).orElse(0); }
    @Override public int extractEnergy(Object obj, int amount, boolean simulate) { ItemStack s = (ItemStack)obj; return s.getCapability(CapabilityEnergy.ENERGY).map(cap -> cap.extractEnergy(amount, simulate)).orElse(0); }
}
