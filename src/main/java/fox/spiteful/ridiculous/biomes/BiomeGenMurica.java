package fox.spiteful.ridiculous.biomes;

import cpw.mods.fml.common.Optional;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.ridiculous.Config;
import fox.spiteful.ridiculous.blocks.RidiculousBlocks;
import fox.spiteful.ridiculous.compat.Compat;
import fox.spiteful.ridiculous.entities.EntityCalavera;
import fox.spiteful.ridiculous.entities.EntityGingerbread;
import fox.spiteful.ridiculous.entities.EntityPeep;
import fox.spiteful.ridiculous.entities.EntityUnicorn;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.util.ForgeDirection;
import vazkii.botania.api.item.IFlowerlessBiome;

import java.util.Random;

public class BiomeGenMurica extends BiomeGenBase {

    public BiomeGenMurica(int id){
        super(id);
        this.theBiomeDecorator.treesPerChunk = 6;
        this.theBiomeDecorator.grassPerChunk = 2;
        this.theBiomeDecorator.mushroomsPerChunk = 0;
        setHeight(height_MidPlains);
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(this, Config.muricaWeight));
        BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.PLAINS);
        setBiomeName("Murica");
        setColor(0x0000FF);
        waterColorMultiplier = 0x0000FF;
    }

    @Override
    public int getBiomeGrassColor(int x, int y, int z)
    {
        if((x / 5) % 2 == 0)
            return 0xFF0000;
        else
            return 0xFFFFFF;
    }

    @Override
    public int getBiomeFoliageColor(int x, int y, int z)
    {
        return 0x0000FF;
    }

    /**
     * takes temperature, returns color
     */
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float wat)
    {
        return 0x0000FF;
    }

    @Override
    /**
     * Adds the default flowers, as of 1.7, it is 2 yellow, and 1 red. I chose 10 to allow some wiggle room in the numbers.
     */
    public void addDefaultFlowers()
    {
        this.flowers.add(new FlowerEntry(Blocks.red_flower,    0, 20));
    }

    public void decorate(World world, Random rand, int chunkX, int chunkZ)
    {
        this.theBiomeDecorator.decorateChunk(world, rand, this, chunkX, chunkZ);

    }

}
