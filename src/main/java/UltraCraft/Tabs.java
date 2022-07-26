package UltraCraft;

import UltraCraft.util.Refercence;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Tabs
{
	public static ToolMaterial sword = new EnumHelper().addToolMaterial("sword", 10, 4000, 12.0F, 5.0F, 22);
	public static ToolMaterial super_sword = new EnumHelper().addToolMaterial("super_sword", 10, 8000, 12.0F, 12.0F, 22);
	public static ToolMaterial rod = new EnumHelper().addToolMaterial("rod", 10, 4000, 12.0F, 4.0F, 22);
	public static ToolMaterial axe = new EnumHelper().addToolMaterial("axe", 10, 4000, 12.0F, 6.0F, 22);
	public static ToolMaterial gun = new EnumHelper().addToolMaterial("gun", 10, 2000, 12.0F, 0.0F, 22);
	public static ToolMaterial super_gun = new EnumHelper().addToolMaterial("super_gun", 10, 3000, 12.0F, 3.0F, 22);
	public static ToolMaterial hyper_gun = new EnumHelper().addToolMaterial("hyper_gun", 10, 4000, 12.0F, 5.0F, 22);
	public static ToolMaterial bow = new EnumHelper().addToolMaterial("bow", 10, 5000, 12.0F, 2.0F, 22);
	public static ToolMaterial stronger_bow = new EnumHelper().addToolMaterial("stronger_bow", 10, 10000, 12.0F, 4.0F, 22);
	public static ToolMaterial bomb = new EnumHelper().addToolMaterial("bomb", 10, 2500, 12.0F, 7.0F, 22);
	public static ToolMaterial boomerang = new EnumHelper().addToolMaterial("boomerang", 10, 4000, 12.0F, 3.0F, 22);
	public static ToolMaterial tonfa = new EnumHelper().addToolMaterial("tonfa", 10, 4000, 12.0F, 6.0F, 22);
	public static ToolMaterial throwable = new EnumHelper().addToolMaterial("throwable", 10, 2500, 12.0F, 5.0F, 22);
	public static ToolMaterial whip = new EnumHelper().addToolMaterial("whip", 10, 4000, 12.0F, 6.0F, 22);
	public static ToolMaterial megaton = new EnumHelper().addToolMaterial("megaton", 10, 4000, 12.0F, 8.0F, 22);
	public static ToolMaterial bazooka = new EnumHelper().addToolMaterial("bazooka", 10, 5000, 12.0F, 10.0F, 22);
	public static ToolMaterial hammer = new EnumHelper().addToolMaterial("hammer", 10, 4000, 12.0F, 4.0F, 22);
	public static ToolMaterial sword_gun = new EnumHelper().addToolMaterial("sword_gun", 10, 3500, 12.0F, 5.0F, 22);
	
	public static ArmorMaterial mecha = new EnumHelper().addArmorMaterial("mecha", "blank", 99, new int[]{9, 18, 24, 9}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 8.0F);
	public static ToolMaterial mecha_sword = new EnumHelper().addToolMaterial("mecha_sword", 10, 30000, 30.0F, 30.0F, 22);
	
	public static CreativeTabs tabUltraman= new CreativeTabs("tabUltraman")
	{
		@SideOnly(Side.CLIENT)
	    public net.minecraft.util.ResourceLocation getBackgroundImage()
	    {
	        return new net.minecraft.util.ResourceLocation(Refercence.MODID,"textures/gui/tab_ultra_items.png");
	    }
		@Override
		public ItemStack createIcon() {
			return new ItemStack(UltraItems.ultraman_head);
		}
	};
}
