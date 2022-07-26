
package UltraCraft.model;

import org.lwjgl.opengl.GL11;

import UltraCraft.potion.PotionCore;
import UltraCraft.UltraItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class model_belt_plus extends ModelBiped
{
	public ItemStack belt;
	public ItemStack belt2=new ItemStack(UltraItems.blanknoitem);
	public ItemStack belt3=new ItemStack(UltraItems.blanknoitem);
	public ItemStack belt4=new ItemStack(UltraItems.blanknoitem);
	public ItemStack belt5=new ItemStack(UltraItems.blanknoitem);
	public ItemStack wings=new ItemStack(UltraItems.blanknoitem);

	public model_belt_plus()
	{
		textureWidth = 64;
		textureHeight = 128;


	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		
		
		float height=-2f;
		float height2=0f;
		float height4=-1.3f;



		
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		if (entity instanceof EntityLivingBase){
			EntityLivingBase living = ((EntityLivingBase)entity);
			ItemStack stack = living.getItemStackFromSlot(EntityEquipmentSlot.FEET);
			
			GL11.glPushMatrix();
			GL11.glPushMatrix();

			if(living.isSneaking()){
				GL11.glRotatef(20, 1, 0, 0);	
			}
			GL11.glRotatef(180, 0, 1, 0);
			GL11.glRotatef(180, 0, 0, 1);
			GL11.glScaled(3,3,1);
			GL11.glTranslatef((float) (0f),-0.05f,-0.2f);
			
			Minecraft.getMinecraft().getItemRenderer().renderItem(living,wings,null);
			GL11.glPopMatrix();
			GL11.glPushMatrix();

			if(living.isSneaking()){
				GL11.glRotatef(20, 1, 0, 0);	
			}

			double dri = 0; 
			GL11.glRotatef(180, 0, 1, 0);

			GL11.glRotatef(180, 0, 0, 1);

			
		

				GL11.glScaled(0.5, 0.5,0.5);
				GL11.glTranslatef((float) (0f+dri),height4,0.4f);
			
			
			

			Minecraft.getMinecraft().getItemRenderer().renderItem(living,belt,null);
			GL11.glPopMatrix();
			GL11.glPushMatrix();

			if(living.isSneaking()){
				GL11.glRotatef(20, 1, 0, 0);	
			}
			GL11.glRotatef(180, 0, 1, 0);
			GL11.glRotatef(180, 0, 0, 1);

	

				GL11.glScaled(0.5001, 0.5001,0.5001);
				GL11.glTranslatef((float) (0f+dri),height4,0.4f);
			
			Minecraft.getMinecraft().getItemRenderer().renderItem(living,belt2,null);
			Minecraft.getMinecraft().getItemRenderer().renderItem(living,belt3,null);
			Minecraft.getMinecraft().getItemRenderer().renderItem(living,belt4,null);
			Minecraft.getMinecraft().getItemRenderer().renderItem(living,belt5,null);
			GL11.glPopMatrix();
			GL11.glPopMatrix();
			
			
			
	}

}




private void setRotation(ModelRenderer model, float x, float y, float z)
{
	model.rotateAngleX = x;
	model.rotateAngleY = y;
	model.rotateAngleZ = z;
}




public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
{
	super.setRotationAngles( par1, par2, par3, par4, par5,par6, par7Entity);

}

}
