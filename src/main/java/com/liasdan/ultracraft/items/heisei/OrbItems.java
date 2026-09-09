package com.liasdan.ultracraft.items.heisei;

import com.liasdan.ultracraft.UltraCraftCore;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class OrbItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UltraCraftCore.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
