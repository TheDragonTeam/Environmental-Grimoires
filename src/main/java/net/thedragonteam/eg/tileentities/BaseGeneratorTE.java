package net.thedragonteam.eg.tileentities;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;

/**
 * Created by KewaiiGamer on 17/04/2017.
 */
public class BaseGeneratorTE extends TileEntity implements ITickable {

    public final int capacity = 5000;
    public boolean isExtracting = false;
    public boolean isReceiving = false;
    public int energy;
    public int flow;
    public int maxReceive;
    public int maxExtract;

    private EnergyStorage energyStorage = new EnergyStorage(capacity);

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {

        // This method is where other things will try to access your TileEntity's Tesla
        // capability. In the case of the analyzer, is a consumer, producer and holder so we
        // can allow requests that are looking for any of those things. This example also does
        // not care about which side is being accessed, however if you wanted to restrict which
        // side can be used, for example only allow power input through the back, that could be
        // done here.
        return capability == CapabilityEnergy.ENERGY ? (T) energyStorage : super.getCapability(capability, facing);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {

        // This method replaces the instanceof checks that would be used in an interface based
        // system. It can be used by other things to see if the TileEntity uses a capability or
        // not. This example is a Consumer, Producer and Holder, so we return true for all
        // three. This can also be used to restrict access on certain sides, for example if you
        // only accept power input from the bottom of the block, you would only return true for
        // Consumer if the facing parameter was down.
        return capability == CapabilityEnergy.ENERGY || super.hasCapability(capability, facing);
    }

    @Override
    public void update() {
        if (isExtracting) {
            flow = 0 - energyStorage.extractEnergy(maxExtract, false);
            markDirty();
        } else if (isReceiving) {
            flow = energyStorage.receiveEnergy(maxReceive, false);
            markDirty();
        }
        energy = energyStorage.getEnergyStored();

        isExtracting = false;
        isReceiving = false;
    }
}