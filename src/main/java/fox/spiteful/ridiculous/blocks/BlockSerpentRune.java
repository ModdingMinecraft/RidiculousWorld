package fox.spiteful.ridiculous.blocks;

import fox.spiteful.ridiculous.Ridiculous;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockSerpentRune extends Block {

    public BlockSerpentRune(){
        super(Material.ROCK);
        this.setHardness(1.5F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.STONE);
        this.setUnlocalizedName("serpent_rune");
        this.setCreativeTab(Ridiculous.tab);
    }

}