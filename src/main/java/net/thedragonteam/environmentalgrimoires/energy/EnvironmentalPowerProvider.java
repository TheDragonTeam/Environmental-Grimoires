package net.thedragonteam.environmentalgrimoires.energy;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by ΑΛΕΧ on 15/4/2017.
 */
public class EnvironmentalPowerProvider implements ICapabilitySerializable<NBTBase> {

    @CapabilityInject(EnvironmentalPower.IEnvironmentalPower.class)
    public static final Capability<EnvironmentalPower.IEnvironmentalPower> EP = null;

    private EnvironmentalPower.IEnvironmentalPower instance = EP.getDefaultInstance();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == EP;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return capability == EP ? (T) instance : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return EP.writeNBT(instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        EP.readNBT(instance, null, nbt);
    }
}
