package fox.spiteful.ridiculous.biomes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fox.spiteful.ridiculous.Config;
import fox.spiteful.ridiculous.Lumberjack;
import fox.spiteful.ridiculous.blocks.RidiculousBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import org.apache.logging.log4j.Level;

import java.util.Random;

public class BiomeGenShadow extends BiomeGenBase {

    BiomeGenShadow(int id){
        super(id);
        this.theBiomeDecorator.treesPerChunk = 2;
        this.theBiomeDecorator.flowersPerChunk = 0;
        this.theBiomeDecorator.deadBushPerChunk = 4;
        this.theBiomeDecorator.mushroomsPerChunk = 8;
        this.theBiomeDecorator.reedsPerChunk = 0;
        this.theBiomeDecorator.clayPerChunk = 1;
        this.theBiomeDecorator.waterlilyPerChunk = 0;
        this.theBiomeDecorator.sandPerChunk2 = 0;
        this.theBiomeDecorator.sandPerChunk = 0;
        this.theBiomeDecorator.grassPerChunk = 8;
        this.waterColorMultiplier = 0x00002F;
        this.flowers.clear();
        BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(this, Config.shadowWeight));
        BiomeManager.addStrongholdBiome(this);
        BiomeManager.addSpawnBiome(this);
        BiomeDictionary.registerBiomeType(this, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.WET, BiomeDictionary.Type.SWAMP,
                BiomeDictionary.Type.COLD, BiomeDictionary.Type.MAGICAL);
        setBiomeName("Shadow Fen");
        setColor(0xF4F5E6);
        setHeight(height_PartiallySubmerged);
        setTemperatureRainfall(0.4F, 0.9F);
    }

    @Override
    public int getBiomeGrassColor(int x, int y, int z)
    {
        return 0x200061;
    }

    @Override
    public int getBiomeFoliageColor(int x, int y, int z)
    {
        return 0x200061;
    }

    /**
     * takes temperature, returns color
     */
    @SideOnly(Side.CLIENT)
    public int getSkyColorByTemp(float wat){
        return 0x000064;
    }

    /*public void decorate(World world, Random rand, int chunkX, int chunkZ)
    {
        //int y = world.getHeight() - 1;
        int y = 90;
        //Lumberjack.log(Level.INFO, chunkX + ", " + chunkZ);
        //world.setBlock(chunkX, y, chunkZ, Blocks.bedrock, 0, 2);
        int maxX = chunkX + 24;
        for(int x = chunkX + 8;x < maxX;x++){
            int maxZ = chunkZ + 24;
            for(int z = chunkZ + 8;z < maxZ;z++){
                //world.setBlock(x, y, z, RidiculousBlocks.gloom, 0, 2);
                world.setBlock(x, y, z, Blocks.bedrock, 0, 0);
            }
        }

        this.theBiomeDecorator.decorateChunk(world, rand, this, chunkX, chunkZ);
    }*/

    public void genTerrainBlocks(World world, Random rand, Block[] chunk, byte[] metadatamaybe, int xMaybe, int zMaybe, double wat)
    {
        this.genBiomeTerrain(world, rand, chunk, metadatamaybe, xMaybe, zMaybe, wat);

        for (int wut = 90; wut < chunk.length; wut+=256) {
            chunk[wut] = RidiculousBlocks.gloom;
            metadatamaybe[wut] = 0;
        }
    }
}