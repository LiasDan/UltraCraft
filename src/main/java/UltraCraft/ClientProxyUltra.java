package UltraCraft;


import com.jcraft.jorbis.Block;

import UltraCraft.mobs.RenderRiderMob;
import UltraCraft.mobs.RenderRiderMob2;
import UltraCraft.model.tokuMobModel;
import UltraCraft.util.Refercence;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxyUltra extends CommonProxyUltra
{
	@Override
	public void registerRenderThings()
	{
		//01 Goranger
		//RenderingRegistry.registerEntityRenderingHandler(entity_zolders.class, new RenderRiderMob2(new tokuMobModel("zolder_2"), 0.5F,"textures/entities/zolder_1.png"));

	}

	public void registerItemRender(Item item, int i, String string) {

		ModelLoader.setCustomModelResourceLocation(item, i,  new ModelResourceLocation(item.getRegistryName(),string));
	}

}
