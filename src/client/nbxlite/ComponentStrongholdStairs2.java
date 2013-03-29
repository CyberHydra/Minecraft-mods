package net.minecraft.src;

import java.util.ArrayList;
import java.util.Random;

public class ComponentStrongholdStairs2 extends ComponentStrongholdStairs
{
    public StructureStrongholdPieceWeight strongholdPieceWeight;
    public ComponentStrongholdPortalRoom strongholdPortalRoom;
    public ArrayList field_75026_c;

    public ComponentStrongholdStairs2(int par1, Random par2Random, int par3, int par4)
    {
        super(0, par2Random, par3, par4);
        field_75026_c = new ArrayList();
    }

    /**
     * Initiates construction of the Structure Component picked, at the current Location of StructGen
     */
    @Override
    public void buildComponent(StructureComponent par1StructureComponent, java.util.List par2List, Random par3Random)
    {
        if (ODNBXlite.oldStrongholds()){
            getNextComponentNormal((ComponentStrongholdStairs2)par1StructureComponent, par2List, par3Random, 1, 1);
            return;
        }
        super.buildComponent(par1StructureComponent, par2List, par3Random);
    }

    public ChunkPosition getCenter()
    {
        if (strongholdPortalRoom != null && !ODNBXlite.oldStrongholds())
        {
            return strongholdPortalRoom.getCenter();
        }
        else
        {
            return super.getCenter();
        }
    }
}
