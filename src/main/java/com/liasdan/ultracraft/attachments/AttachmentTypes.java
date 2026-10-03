package com.liasdan.ultracraft.attachments;

import com.mojang.serialization.Codec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

import static com.liasdan.ultracraft.UltraCraftCore.MODID;

public class AttachmentTypes {
    private static final DeferredRegister<AttachmentType<?>> REGISTRY = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, MODID);

    public static final Supplier<AttachmentType<String>> MOB_STATE = REGISTRY.register(
            "mob_state", () -> AttachmentType.builder(() -> "").serialize(Codec.STRING).build()
    );

    public static void register(IEventBus eventBus) {REGISTRY.register(eventBus);}
}