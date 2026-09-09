package com.liasdan.ultracraft.effect;

import com.liasdan.ultracraft.UltraCraftCore;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EffectCore {

	public static final DeferredRegister<MobEffect> EFFECT = DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, UltraCraftCore.MODID);


	public static final Holder<MobEffect> BOOST = EFFECT.register("boost",
			() -> new 	BoostEffect(MobEffectCategory.BENEFICIAL, 0xff0015));

	public static final Holder<MobEffect> ANTIPOISON = EFFECT.register("anti_poison",
			() -> new 	AntiPoisonEffect(MobEffectCategory.BENEFICIAL, 0x8532a8));

	public static final Holder<MobEffect> SLASH= EFFECT.register("slash",
			() -> new 	SlashEffect(MobEffectCategory.BENEFICIAL, 0x21daff));

	public static final Holder<MobEffect> SHOTBOOST= EFFECT.register("shot_boost",
			() -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0x21daff));

	public static final Holder<MobEffect> PUNCH= EFFECT.register("punch",
			() -> new 	PunchEffect(MobEffectCategory.BENEFICIAL, 0x1d8519));

	public static final Holder<MobEffect> FIREPUNCH= EFFECT.register("fire_punch",
			() -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0xf7c208));

	public static final Holder<MobEffect> FLYING= EFFECT.register("flying",
			() -> new 	BasicEffect(MobEffectCategory.BENEFICIAL, 0xffffff)
					.addAttributeModifier(NeoForgeMod.CREATIVE_FLIGHT, ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "effect.flying"), 1, AttributeModifier.Operation.ADD_VALUE) );

	public static final Holder<MobEffect> FIRESLASH= EFFECT.register("fire_slash",
			() -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0xf7c208));

	public static final Holder<MobEffect> SMALL= EFFECT.register("small",
			() -> new BasicEffect(MobEffectCategory.NEUTRAL, 0x1d8519)
					.addAttributeModifier(Attributes.SCALE, ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "effect.small"), -0.1F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

	public static final Holder<MobEffect> BIG= EFFECT.register("big",
			() -> new BasicEffect(MobEffectCategory.NEUTRAL, 0x1d8519)
					.addAttributeModifier(Attributes.SCALE, ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "effect.big"), 1F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

	public static final Holder<MobEffect> SMOKE= EFFECT.register("smoke",
			() -> new 	SmokeEffect(MobEffectCategory.BENEFICIAL, 0xf7fada));

	public static final Holder<MobEffect> FROSTWALKER= EFFECT.register("frost_walker",
			() -> new 	FrostWalkerEffect(MobEffectCategory.BENEFICIAL, 0xf7fada));

	public static final Holder<MobEffect>  EXPLOSIONPUNCH= EFFECT.register("explosion_punch",
			() -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0xf7c208));

	public static final Holder<MobEffect>  REFLECT= EFFECT.register("reflect",
			() -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0xd1d1d1));

	public static final Holder<MobEffect>  EXPLOSIONSHOT= EFFECT.register("explosion_shot",
			() -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0xf7c208));

	public static final Holder<MobEffect>  THUNDERSHOT= EFFECT.register("thunder_shot",
			() -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0x76ecff));

	public static final Holder<MobEffect>  THUNDERPUNCH= EFFECT.register("thunder_punch",
			() -> new BasicEffect(MobEffectCategory.BENEFICIAL, 0x76ecff));

	public static final Holder<MobEffect> FLAT= EFFECT.register("flat",
			() -> new BasicEffect(MobEffectCategory.NEUTRAL, 0xf7fada));

	public static final Holder<MobEffect>  STRETCH= EFFECT.register("stretch",
			() -> new BasicEffect(MobEffectCategory.NEUTRAL, 0xf78d95));

	public static final Holder<MobEffect>  WIDE= EFFECT.register("wide",
			() -> new 	BasicEffect(MobEffectCategory.NEUTRAL, 0x87ce87));

	public static final Holder<MobEffect> STEP= EFFECT.register("step",
			() -> new BasicEffect(MobEffectCategory.NEUTRAL, 0x9d3443)
					.addAttributeModifier(Attributes.STEP_HEIGHT, ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "effect.step"), 1F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

	public static final Holder<MobEffect> LONG_ARM= EFFECT.register("long_arm",
			() -> new LowGravityEffect(MobEffectCategory.NEUTRAL, 0xe60052)
					.addAttributeModifier(Attributes.BLOCK_INTERACTION_RANGE, ResourceLocation.fromNamespaceAndPath(UltraCraftCore.MODID, "effect.long_arm"), 1F, AttributeModifier.Operation.ADD_VALUE));

	public static final Holder<MobEffect> FORM_LOCK = EFFECT.register("form_lock",
			() -> new UncurableEffect(MobEffectCategory.HARMFUL, 0xffffff));

	public static void register(IEventBus eventBus) {
		EFFECT.register(eventBus);
	}

}