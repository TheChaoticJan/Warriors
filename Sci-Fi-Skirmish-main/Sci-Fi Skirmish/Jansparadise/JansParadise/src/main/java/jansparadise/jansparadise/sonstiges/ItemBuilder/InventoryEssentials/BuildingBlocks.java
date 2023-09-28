package jansparadise.jansparadise.sonstiges.ItemBuilder.InventoryEssentials;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BuildingBlocks {

    public static ItemStack Blocks(){
        ItemStack BBlock = new ItemStack(Material.SANDSTONE);

        ItemMeta BlockMeta = BBlock.getItemMeta();
        BlockMeta.setDisplayName("§6§oBaublöcke");
        BBlock.setItemMeta(BlockMeta);

        return BBlock;

    }
}
