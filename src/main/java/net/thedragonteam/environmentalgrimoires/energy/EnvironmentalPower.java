package net.thedragonteam.environmentalgrimoires.energy;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.thedragonteam.environmentalgrimoires.EnvironmentalGrimoires;

import javax.annotation.Nullable;
import java.util.concurrent.Callable;

/**
 * Created by ΑΛΕΧ on 15/4/2017.
 */
public class EnvironmentalPower {

    public static final ResourceLocation ENVIRONMENTAL_POWER = new ResourceLocation(EnvironmentalGrimoires.MODID, "env_power");

    @SubscribeEvent
    public void attachCap(AttachCapabilitiesEvent event) {
        if (event.getObject() instanceof PlayerEvent) {
            event.addCapability(ENVIRONMENTAL_POWER, new EnvironmentalPowerProvider());
        }
    }

    @SubscribeEvent
    public void onPlayerDeath(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            event.getEntityPlayer().getCapability(EnvironmentalPowerProvider.EP, null).setEP(event.getOriginal().getCapability(EnvironmentalPowerProvider.EP, null).getEP());
        }
    }

    public interface IEnvironmentalPower {
        void addEP(int amount);

        void removeEP(int amount);

        int getEP();

        void setEP(int amount);
    }

    public class EnvironmentalPowerStorage implements Capability.IStorage<IEnvironmentalPower> {
        @Nullable
        @Override
        public NBTBase writeNBT(Capability<IEnvironmentalPower> capability, IEnvironmentalPower instance, EnumFacing side) {
            return new NBTTagInt(instance.getEP());
        }

        @Override
        public void readNBT(Capability<IEnvironmentalPower> capability, IEnvironmentalPower instance, EnumFacing side, NBTBase nbt) {
            instance.setEP(((NBTPrimitive) nbt).getInt());
        }
    }

    public class EnvironmentalPowerFactory implements Callable<IEnvironmentalPower> {
        @Override
        public IEnvironmentalPower call() throws Exception {
            return new IEnvironmentalPower() {
                final int maxEP = 1000;
                final int leastEP = 0;
                boolean isFull = false;
                boolean isEmpty = false;
                int ep = 0;

                @Override
                public void addEP(int amount) {
                    if (ep + amount <= maxEP) {
                        ep += amount;
                    } else {
                        isFull = true;
                    }
                }

                @Override
                public void removeEP(int amount) {
                    if (ep - amount >= leastEP) {
                        ep -= amount;
                    } else {
                        isEmpty = true;
                    }
                }

                @Override
                public int getEP() {
                    return ep;
                }

                @Override
                public void setEP(int amount) {
                    ep = amount;
                }
            };
        }
    }
}
