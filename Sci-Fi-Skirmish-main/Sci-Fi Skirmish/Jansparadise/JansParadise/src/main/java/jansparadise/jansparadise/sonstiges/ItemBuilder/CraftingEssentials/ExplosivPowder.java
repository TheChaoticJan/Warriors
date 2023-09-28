package jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ExplosivPowder {

    public static ItemStack Powder() {
        ItemStack SuperGold = new ItemStack(Material.GUNPOWDER);
        ItemMeta SuperGoldMeta = SuperGold.getItemMeta();
        SuperGoldMeta.setDisplayName("§x§F§F§0§0§0§0E§x§F§5§0§3§0§1x§x§E§B§0§7§0§3p§x§E§1§0§A§0§4l§x§D§7§0§E§0§6o§x§C§D§1§1§0§7s§x§C§4§1§5§0§9i§x§B§A§1§8§0§Av§x§B§0§1§B§0§Bp§x§A§6§1§F§0§Du§x§9§C§2§2§0§Ed§x§9§2§2§6§1§0e§x§8§8§2§9§1§1r");
        SuperGoldMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        SuperGoldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SuperGold.setItemMeta(SuperGoldMeta);
        return SuperGold;
    }

}
