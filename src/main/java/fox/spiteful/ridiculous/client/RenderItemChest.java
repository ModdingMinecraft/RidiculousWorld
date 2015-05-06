package fox.spiteful.ridiculous.client;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.model.ModelChest;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderItemChest implements IItemRenderer {

    private final ModelChest modelChest;
    public RenderItemChest()
    {
        modelChest = new ModelChest();
    }

    @Override
    public boolean handleRenderType(ItemStack itemStack, ItemRenderType itemRenderType)
    {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType itemRenderType, ItemStack itemStack, ItemRendererHelper itemRendererHelper)
    {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType itemRenderType, ItemStack itemStack, Object... data)
    {
        switch (itemRenderType)
        {
            case ENTITY:
            {
                renderChest(0.5F, 0.5F, 0.5F, itemStack.getItemDamage());
                break;
            }
            case EQUIPPED:
            {
                renderChest(1.0F, 1.0F, 1.0F, itemStack.getItemDamage());
                break;
            }
            case EQUIPPED_FIRST_PERSON:
            {
                renderChest(1.0F, 1.0F, 1.0F, itemStack.getItemDamage());
                break;
            }
            case INVENTORY:
            {
                renderChest(0.0F, 0.075F, 0.0F, itemStack.getItemDamage());
                break;
            }
            default:
                break;
        }
    }
    private void renderChest(float x, float y, float z, int metaData)
    {
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(RenderTileEntityChest.botanyChest);
        GL11.glPushMatrix(); //start
        GL11.glTranslatef(x, y, z); //size
        GL11.glRotatef(180, 1, 0, 0);
        GL11.glRotatef(-90, 0, 1, 0);
        modelChest.renderAll();
        GL11.glPopMatrix(); //end
    }
}