package com.infinitymax.impl.fabric;

import com.infinitymax.api.energy.IEnergyCompat;
import net.minecraft.world.item.ItemStack;
import team.reborn.energy.api.EnergyStorage;

/**
 * Fabric向けエネルギー互換実装
 */
public class FabricEnergyCompat implements IEnergyCompat {

    @Override
    public boolean isEnergyItem(Object obj) {
        if(!(obj instanceof ItemStack s)) return false;
        return EnergyStorage.ITEM.find(s,null) != null;
    }

    @Override
    public int getEnergy(Object obj) {
        ItemStack s = (ItemStack)obj;
        EnergyStorage st = EnergyStorage.ITEM.find(s,null);
        return st == null ? 0 : (int)st.getAmount();
    }

    @Override
    public int getMaxEnergy(Object obj) {
        ItemStack s = (ItemStack)obj;
        EnergyStorage st = EnergyStorage.ITEM.find(s,null);
        return st == null ? 0 : (int)st.getCapacity();
    }

    @Override
    public int receiveEnergy(Object obj, int amount, boolean simulate) {
        ItemStack s = (ItemStack)obj;
        EnergyStorage st = EnergyStorage.ITEM.find(s,null);
        if(st==null) return 0;
        return (int) st.insert(amount, simulate?EnergyStorage.Action.SIMULATE:EnergyStorage.Action.EXECUTE);
    }

    @Override
    public int extractEnergy(Object obj, int amount, boolean simulate) {
        ItemStack s = (ItemStack)obj;
        EnergyStorage st = EnergyStorage.ITEM.find(s,null);
        if(st==null) return 0;
        return (int) st.extract(amount, simulate?EnergyStorage.Action.SIMULATE:EnergyStorage.Action.EXECUTE);
    }
}
