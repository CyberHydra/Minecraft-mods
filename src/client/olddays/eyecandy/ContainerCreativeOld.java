package net.minecraft.src;

import java.util.*;

class ContainerCreativeOld extends Container
{
    /** the list of items in this container */
    public List itemList;

    public ContainerCreativeOld(EntityPlayer par1EntityPlayer)
    {
        itemList = new ArrayList();
        Block ablock[] =
        {
            Block.cobblestone,
            Block.stone,
            Block.oreDiamond,
            Block.oreGold,
            Block.oreIron,
            Block.oreCoal,
            Block.oreLapis,
            Block.oreRedstone,
            Block.oreEmerald,
            Block.stoneBrick,
            Block.blockClay,
            Block.blockEmerald,
            Block.blockDiamond,
            Block.blockGold,
            Block.blockSteel,
            Block.bedrock,
            Block.blockLapis,
            Block.brick,
            Block.cobblestoneMossy,
            Block.woodSingleSlab,
            Block.obsidian,
            Block.netherrack,
            Block.slowSand,
            Block.glowStone,
            Block.wood,
            Block.leaves,
            Block.dirt,
            Block.grass,
            Block.sand,
            Block.sandStone,
            Block.gravel,
            Block.web,
            Block.planks,
            Block.sapling,
            Block.deadBush,
            Block.sponge,
            Block.ice,
            Block.blockSnow,
            Block.snow,
            Block.plantYellow,
            Block.plantRed,
            Block.mushroomBrown,
            Block.mushroomRed,
            Block.cactus,
            Block.melon,
            Block.pumpkin,
            Block.pumpkinLantern,
            Block.vine,
            Block.fenceIron,
            Block.thinGlass,
            Block.netherBrick,
            Block.netherFence,
            Block.stairsNetherBrick,
            Block.whiteStone,
            Block.endPortalFrame,
            Block.mycelium,
            Block.waterlily,
            Block.tallGrass,
            Block.chest,
            Block.enderChest,
            Block.workbench,
            Block.glass,
            Block.tnt,
            Block.bookShelf,
            Block.cloth,
            Block.dispenser,
            Block.stoneOvenIdle,
            Block.music,
            Block.jukebox,
            Block.pistonStickyBase,
            Block.pistonBase,
            Block.fence,
            Block.fenceGate,
            Block.ladder,
            Block.rail,
            Block.railPowered,
            Block.railDetector,
            Block.torchWood,
            Block.stairCompactPlanks,
            Block.stairsWoodSpruce,
            Block.stairsWoodBirch,
            Block.stairsWoodJungle,
            Block.stairCompactCobblestone,
            Block.stairsSandStone,
            Block.stairsBrick,
            Block.stairsStoneBrickSmooth,
            Block.field_82515_ce,
            Block.lever,
            Block.pressurePlateStone,
            Block.pressurePlatePlanks,
            Block.torchRedstoneActive,
            Block.field_82511_ci,
            Block.button,
            Block.tripWireSource,
            Block.trapdoor,
            Block.enchantmentTable,
            Block.redstoneLampIdle,
            Block.field_82510_ck,
            Block.field_82518_cd,
            Block.field_82517_cc
        };

        for (int j2 = 0; j2 < ablock.length; j2++)
        {
            if (Item.itemsList[ablock[j2].blockID] == null){
                continue;
            }
            if (ablock[j2].blockID == Block.woodSingleSlab.blockID){
                itemList.add(new ItemStack(Block.stoneSingleSlab.blockID, 1, 0));
                itemList.add(new ItemStack(Block.stoneSingleSlab.blockID, 1, 1));
                Item.itemsList[ablock[j2].blockID].getSubItems(ablock[j2].blockID, null, itemList);
                itemList.add(new ItemStack(Block.stoneSingleSlab.blockID, 1, 2));
                itemList.add(new ItemStack(Block.stoneSingleSlab.blockID, 1, 3));
                itemList.add(new ItemStack(Block.stoneSingleSlab.blockID, 1, 4));
                itemList.add(new ItemStack(Block.stoneSingleSlab.blockID, 1, 5));
            }else{
                Item.itemsList[ablock[j2].blockID].getSubItems(ablock[j2].blockID, null, itemList);
            }
        }

        for (int k2 = 256; k2 < Item.itemsList.length; k2++)
        {
            if (Item.itemsList[k2] == null){
                continue;
            }
            int id = Item.itemsList[k2].shiftedIndex;
            if (id == Item.monsterPlacer.shiftedIndex ||
                id == Item.potion.shiftedIndex ||
                id == Item.writtenBook.shiftedIndex){
                continue;
            }else if (Item.itemsList[k2].shiftedIndex == Item.dyePowder.shiftedIndex){
                itemList.add(new ItemStack(k2, 1, 0));
            }else{
                Item.itemsList[k2].getSubItems(k2, null, itemList);
            }
        }
        for (int l2 = 1; l2 < 16; l2++)
        {
            itemList.add(new ItemStack(Item.dyePowder.shiftedIndex, 1, l2));
        }
        Item.itemsList[Item.monsterPlacer.shiftedIndex].getSubItems(Item.monsterPlacer.shiftedIndex, null, itemList);
        Item.itemsList[Item.potion.shiftedIndex].getSubItems(Item.potion.shiftedIndex, null, itemList);

        InventoryPlayer inventoryplayer = par1EntityPlayer.inventory;

        for (int j3 = 0; j3 < 9; j3++)
        {
            for (int l3 = 0; l3 < 8; l3++)
            {
                addSlotToContainer(new Slot(GuiContainerCreativeOld.getInventory(), l3 + j3 * 8, 8 + l3 * 18, 18 + j3 * 18));
            }
        }

        for (int k3 = 0; k3 < 9; k3++)
        {
            addSlotToContainer(new Slot(inventoryplayer, k3, 8 + k3 * 18, 184));
        }

        scrollTo(0.0F);
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return true;
    }

    /**
     * Updates the gui slots ItemStack's based on scroll position.
     */
    public void scrollTo(float par1)
    {
        int i = (itemList.size() / 8 - 8) + 1;
        int j = (int)((double)(par1 * (float)i) + 0.5D);

        if (j < 0)
        {
            j = 0;
        }

        for (int k = 0; k < 9; k++)
        {
            for (int l = 0; l < 8; l++)
            {
                int i1 = l + (k + j) * 8;

                if (i1 >= 0 && i1 < itemList.size())
                {
                    GuiContainerCreativeOld.getInventory().setInventorySlotContents(l + k * 8, (ItemStack)itemList.get(i1));
                }
                else
                {
                    GuiContainerCreativeOld.getInventory().setInventorySlotContents(l + k * 8, null);
                }
            }
        }
    }

    protected void retrySlotClick(int i, int j, boolean flag, EntityPlayer entityplayer)
    {
    }
}
