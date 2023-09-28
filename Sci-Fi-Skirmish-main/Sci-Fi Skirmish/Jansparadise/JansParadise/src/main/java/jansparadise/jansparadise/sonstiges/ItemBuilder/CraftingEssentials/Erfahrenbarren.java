package jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Erfahrenbarren {

    public static ItemStack ErfahrenBarren(){
        ItemStack SuperGoldBlock = new ItemStack(Material.GOLD_INGOT);
        ItemMeta SuperGoldBlockMeta = SuperGoldBlock.getItemMeta();
        SuperGoldBlockMeta.setDisplayName("§x§F§F§E§2§5§9W§x§F§F§D§D§5§8e§x§F§F§D§7§5§8i§x§F§F§D§2§5§7s§x§F§F§C§D§5§6e§x§F§F§C§7§5§5n§x§F§F§C§2§5§5b§x§F§F§B§C§5§4a§x§F§F§B§7§5§3r§x§F§F§B§2§5§2r§x§F§F§A§C§5§2e§x§F§F§A§7§5§1n");
        SuperGoldBlockMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        SuperGoldBlockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SuperGoldBlock.setItemMeta(SuperGoldBlockMeta);
        return SuperGoldBlock;
    }
}
