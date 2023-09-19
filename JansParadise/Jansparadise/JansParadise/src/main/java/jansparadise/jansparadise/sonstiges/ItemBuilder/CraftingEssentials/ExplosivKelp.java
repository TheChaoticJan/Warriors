package jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ExplosivKelp {

    public static ItemStack DriedKelp() {
        ItemStack SuperGold = new ItemStack(Material.DRIED_KELP);
        ItemMeta SuperGoldMeta = SuperGold.getItemMeta();
        SuperGoldMeta.setDisplayName("§x§F§F§0§0§0§0E§x§F§6§0§3§0§1x§x§E§D§0§6§0§3p§x§E§4§0§9§0§4l§x§D§A§0§D§0§5o§x§D§1§1§0§0§7s§x§C§8§1§3§0§8i§x§B§F§1§6§0§9v§x§B§6§1§9§0§Ab§x§A§D§1§C§0§Ca§x§A§3§2§0§0§Dr§x§9§A§2§3§0§Er§x§9§1§2§6§1§0e§x§8§8§2§9§1§1n");
        SuperGoldMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        SuperGoldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SuperGold.setItemMeta(SuperGoldMeta);
        return SuperGold;
    }

}
