package com.liasdan.ultracraft.blocks.entity;

import com.liasdan.ultracraft.UltraCraftCore;
import com.liasdan.ultracraft.blocks.UltraBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, UltraCraftCore.MODID);

    public static void register(IEventBus eventBus) {BLOCK_ENTITIES.register(eventBus);}
}
