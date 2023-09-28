package jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SciFiBarren {

    public static ItemStack SciFiBarren(){

        ItemStack SuperGoldBlock = new ItemStack(Material.DIAMOND);
        ItemMeta SuperGoldBlockMeta = SuperGoldBlock.getItemMeta();
        SuperGoldBlockMeta.setDisplayName("§x§5§9§F§8§F§FS§x§5§8§F§2§F§Fc§x§5§8§E§C§F§Fi§x§5§7§E§6§F§F-§x§5§7§E§0§F§FF§x§5§6§D§A§F§Fi §x§5§5§D§4§F§FK§x§5§5§C§E§F§Fr§x§5§4§C§8§F§Fi§x§5§3§C§2§F§Fs§x§5§3§B§C§F§Ft§x§5§2§B§6§F§Fa§x§5§2§B§0§F§Fl§x§5§1§A§A§F§Fl");
        SuperGoldBlockMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        SuperGoldBlockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SuperGoldBlock.setItemMeta(SuperGoldBlockMeta);
        return SuperGoldBlock;
    }
}
