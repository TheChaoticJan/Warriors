package jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Erfahrenfragment {

    public static ItemStack SuperGold() {
        ItemStack SuperGold = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta SuperGoldMeta = SuperGold.getItemMeta();
        SuperGoldMeta.setDisplayName("§x§F§F§E§2§5§9W§x§F§F§D§D§5§8e§x§F§F§D§9§5§8i§x§F§F§D§4§5§7s§x§F§F§D§0§5§7e§x§F§F§C§B§5§6n§x§F§F§C§7§5§5f§x§F§F§C§2§5§5r§x§F§F§B§E§5§4a§x§F§F§B§9§5§3g§x§F§F§B§5§5§3m§x§F§F§B§0§5§2e§x§F§F§A§C§5§2n§x§F§F§A§7§5§1t");
        SuperGoldMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        SuperGoldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SuperGold.setItemMeta(SuperGoldMeta);
        return SuperGold;
    }
}
