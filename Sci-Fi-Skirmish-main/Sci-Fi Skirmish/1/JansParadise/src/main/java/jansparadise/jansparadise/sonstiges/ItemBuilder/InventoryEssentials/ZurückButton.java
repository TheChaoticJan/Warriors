package jansparadise.jansparadise.sonstiges.ItemBuilder.InventoryEssentials;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ZurückButton {

    public static ItemStack Zurück(){
        ItemStack i = new ItemStack(Material.RED_DYE);
        ItemMeta d = i.getItemMeta();
        d.setDisplayName("§cZurück");
        d.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        d.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        i.setItemMeta(d);
        return i;
    }
}
