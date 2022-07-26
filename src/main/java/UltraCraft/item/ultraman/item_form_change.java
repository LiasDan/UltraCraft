package UltraCraft.item.ultraman;


import UltraCraft.TokuCraft_core;
import UltraCraft.UltraItems;
import UltraCraft.util.IHasModel;
import com.google.common.collect.Lists;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;


public class item_form_change extends Item implements IHasModel
{

	private String FORM_NAME;
	private List<PotionEffect> potionEffectList;
	private Item BELT;
	private List<Item> NEEDSITEM = new ArrayList<Item>();
	protected  Class<? extends item_ultra_riser> BELTCLASS;
	protected String RIDER_NAME;
	private Item WINGS = UltraItems.blanknoitem;
	private Item STIFT_ITEM = UltraItems.blanknoitem;
	private String REND2;
	private List<item_form_change> alternative = new ArrayList<item_form_change>();

	public item_form_change(String name,Class<? extends item_ultra_riser> beltClass,Item belt,String formName,String ridername,PotionEffect... effects)
	{
		super();
		this.setMaxDamage(0);
		setTranslationKey(name);
		setRegistryName(name);
		TokuCraft_core.ITEMS.add(this);
		potionEffectList = Lists.newArrayList(effects);
		FORM_NAME = formName;
		BELT = belt;
		BELTCLASS = beltClass;
		RIDER_NAME = ridername;
	}

	@Override
	public void registerModels() {
		TokuCraft_core.proxy.registerItemRender(this,0,"inventory");
	}

	public List<PotionEffect> getPotionEffectList() {
		return potionEffectList;
	}

	public Item getBelt() {
		return BELT;
	}

	public Item getWing() {
		return WINGS;
	}
	public boolean getNeedItem(EntityPlayer playerIn) {
		boolean NEED = true;
		if (NEEDSITEM.isEmpty()){
			NEED=true;
		}
		else {
			for (int i = 0; i < NEEDSITEM.size(); i++)
			{
				if (!playerIn.inventory.hasItemStack(new ItemStack(NEEDSITEM.get(i)))){
					NEED=false;
				}
			}
		}
		return NEED;
	}
	public item_form_change addWing(Item wings) {
		WINGS = wings;
		return this;
	}
	public item_form_change ShiftForm(Item ShiftItem) {
		STIFT_ITEM = ShiftItem;
		return this;
	}
	public item_form_change addAlternative(item_form_change alternativeItem) {
		alternative.add(alternativeItem);
		return this;
	}
	public item_form_change addNeedItem(Item needitem) {
		NEEDSITEM.add(needitem);
		return this;
	}
	public item_form_change Rend2ndLyer(String lyer) {
		REND2 = lyer;
		return this;
	}
	public String get2ndLyer() {

		return REND2!= null? REND2:"blank";
	}

	public String getFormName() {
		return FORM_NAME;
	}


	public  item_form_change keep_item()
	{
		this.setContainerItem(this);
		getContainerItem();
		return this;
	}





	/**
	 * Called when the equipped item is right clicked.
	 */
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
		if (!playerIn.inventory.armorInventory.get(1).isEmpty()) {
			if (playerIn.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem().getClass()==BELTCLASS) {

				if (STIFT_ITEM != UltraItems.blanknoitem&playerIn.isSneaking()) {
					STIFT_ITEM.onItemRightClick(worldIn, playerIn, handIn);
				} else if(((item_ultra_riser) playerIn.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem()).Rider.equals(RIDER_NAME)){
					if(getNeedItem(playerIn))
						item_ultra_riser.set_Form_Item(playerIn.getItemStackFromSlot(EntityEquipmentSlot.FEET),this, 1);

				} else if(!alternative.isEmpty()){

					for (int i = 0; i < alternative.size(); i++)
					{
						item_form_change alternativeItem_form_change = alternative.get(i);
						alternativeItem_form_change.onItemRightClick(worldIn, playerIn, handIn);
					}
				}
			}

		}
		playerIn.setActiveHand(handIn);

		return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}
}