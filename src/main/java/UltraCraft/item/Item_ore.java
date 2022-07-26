package UltraCraft.item;


import UltraCraft.TokuCraft_core;
import UltraCraft.item.ultraman.item_form_change;
import UltraCraft.util.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Item_ore extends Item implements IHasModel
{
    public Item_ore(String name)
    {
        super();
        this.setMaxDamage(0);
        maxStackSize = 64;
        setTranslationKey(name);
        setRegistryName(name);
        TokuCraft_core.ITEMS.add(this);

    }
    
	public  Item_ore keep_item()
	{
		this.setContainerItem(this);
		getContainerItem();
		return this;
	}
	
	public  Item_ore keep_item(Item item)
	{
		this.setContainerItem(item);
		getContainerItem();
		return this;
	}
	
	@Override
	public void registerModels() {
		TokuCraft_core.proxy.registerItemRender(this,0,"inventory");
	}
}
