package jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SciFiFragment {

    public static ItemStack SciFiFragment(){

        ItemStack SuperGoldBlock = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta SuperGoldBlockMeta = SuperGoldBlock.getItemMeta();
        SuperGoldBlockMeta.setDisplayName("§x§5§9§F§8§F§FS§x§5§8§F§2§F§Fc§x§5§8§E§C§F§Fi§x§5§7§E§6§F§F-§x§5§7§E§0§F§FF§x§5§6§D§A§F§Fi §x§5§5§D§4§F§FF§x§5§5§C§E§F§Fr§x§5§4§C§8§F§Fa§x§5§3§C§2§F§Fg§x§5§3§B§C§F§Fm§x§5§2§B§6§F§Fe§x§5§2§B§0§F§Fn§x§5§1§A§A§F§Ft");
        SuperGoldBlockMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        SuperGoldBlockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SuperGoldBlock.setItemMeta(SuperGoldBlockMeta);
        return SuperGoldBlock;
    }

}
