package jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KlebrigSuperSlime {

    public static ItemStack Emerald() {
        ItemStack SuperGold = new ItemStack(Material.EMERALD);
        ItemMeta SuperGoldMeta = SuperGold.getItemMeta();
        SuperGoldMeta.setDisplayName("§x§0§0§F§F§1§1K§x§0§2§F§6§1§2l§x§0§5§E§D§1§2e§x§0§7§E§3§1§3b§x§0§A§D§A§1§4r§x§0§C§D§1§1§4i§x§0§E§C§8§1§5g§x§1§1§B§E§1§5e§x§1§3§B§5§1§6r §x§1§5§A§C§1§7K§x§1§8§A§3§1§7r§x§1§A§9§9§1§8i§x§1§D§9§0§1§9s§x§1§F§8§7§1§9t§x§2§1§7§E§1§Aa§x§2§4§7§4§1§Al§x§2§6§6§B§1§Bl");
        SuperGoldMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        SuperGoldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SuperGold.setItemMeta(SuperGoldMeta);
        return SuperGold;

    }
}
