package jansparadise.jansparadise.sonstiges.ItemBuilder.InventoryEssentials;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Fuellerglas {

    public static ItemStack Glas(){
        ItemStack Glas = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta GlasMeta = Glas.getItemMeta();
        GlasMeta.setDisplayName("_");
        Glas.setItemMeta(GlasMeta);
        return Glas;
    }
}
