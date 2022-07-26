package UltraCraft.item;


import UltraCraft.TokuCraft_core;
import UltraCraft.item.ultraman.item_form_change;
import UltraCraft.item.ultraman.item_ultra_riser;
import UltraCraft.util.IHasModel;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class item_mantle extends item_form_change 
{
	public Item num;

	public item_mantle(Item NUM,String name,Class<? extends item_ultra_riser> beltClass,Item belt,String formName,String ridername,PotionEffect... effects)
	{
		super(name,beltClass, belt,formName,ridername,effects);
		num = NUM;
	}
	
	/**
     * Called when the equipped item is right clicked.
     */
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) 
    {
    	if (!playerIn.inventory.armorInventory.get(1).isEmpty()) 
    	{
			if (playerIn.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem().getClass()==BELTCLASS) 
			{
				 if(((item_ultra_riser) playerIn.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem()).Rider.equals(RIDER_NAME))
				 {
					if (item_ultra_riser.get_Form_Item_tex(playerIn.getItemStackFromSlot(EntityEquipmentSlot.FEET), 1)==this)
					{
						item_ultra_riser.set_Form_Item(playerIn.getItemStackFromSlot(EntityEquipmentSlot.FEET),num, 1);
					}
					else
					{
						return super.onItemRightClick(worldIn,playerIn,handIn);
					}
				}
			}

    	}
        playerIn.setActiveHand(handIn);

    	return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
    }		
}