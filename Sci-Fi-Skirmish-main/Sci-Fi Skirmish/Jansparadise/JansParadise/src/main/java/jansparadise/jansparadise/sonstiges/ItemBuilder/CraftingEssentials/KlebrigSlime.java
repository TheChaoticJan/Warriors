package jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KlebrigSlime {

    public static ItemStack Slime() {
        ItemStack SuperGold = new ItemStack(Material.SCUTE);
        ItemMeta SuperGoldMeta = SuperGold.getItemMeta();
        SuperGoldMeta.setDisplayName("§x§0§0§F§F§1§1K§x§0§3§F§5§1§2l§x§0§5§E§B§1§2e§x§0§8§E§1§1§3b§x§0§A§D§8§1§4r§x§0§D§C§E§1§4i§x§0§F§C§4§1§5g§x§1§2§B§A§1§6e§x§1§4§B§0§1§6r §x§1§7§A§6§1§7S§x§1§9§9§C§1§8c§x§1§C§9§2§1§8h§x§1§E§8§9§1§9l§x§2§1§7§F§1§Ae§x§2§3§7§5§1§Ai§x§2§6§6§B§1§Bm");
        SuperGoldMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        SuperGoldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SuperGold.setItemMeta(SuperGoldMeta);
        return SuperGold;
    }

}
