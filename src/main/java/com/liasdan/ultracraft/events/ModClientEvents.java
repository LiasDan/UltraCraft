package com.liasdan.ultracraft.events;

import com.liasdan.supersentaicraft.effect.EffectCore;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RenderLivingEvent;

public class ModClientEvents {

	public static class ClientEvents {
		@SubscribeEvent
		public void addRenderLivingEvent(RenderLivingEvent.Pre event) {

			float size = 1;
			boolean Tall = event.getEntity().hasEffect(EffectCore.STRETCH);

			if (event.getEntity().hasEffect(EffectCore.STRETCH)) {
				size = size + ((event.getEntity().getEffect(EffectCore.STRETCH).getAmplifier()) + 1);
			}

			float size2 = event.getEntity().hasEffect(EffectCore.STRETCH) ? 1 : size;

			if (event.getEntity().hasEffect(EffectCore.FLAT)) {
				size2 = 0.1f;
			}
			float size3 = event.getEntity().hasEffect(EffectCore.STRETCH) ? 1 : size;
			if (event.getEntity().hasEffect(EffectCore.WIDE)) {
				size2 = (float) (size2 * 3);
				size3 = (float) (size3 * 3);
			}
			event.getPoseStack().scale(size3, size, size2);
		}
	}
}