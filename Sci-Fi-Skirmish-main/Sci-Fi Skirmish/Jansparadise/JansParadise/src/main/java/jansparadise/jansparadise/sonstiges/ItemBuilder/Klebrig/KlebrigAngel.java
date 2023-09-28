package jansparadise.jansparadise.sonstiges.ItemBuilder.Klebrig;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class KlebrigAngel {



    public static ItemStack KlebrigAngel(){

        ItemStack Drop4 = new ItemStack(Material.FISHING_ROD);
        ItemMeta SwordMeta = Drop4.getItemMeta();
        SwordMeta.setDisplayName("§x§5§A§D§D§2§D§ka§x§4§0§A§A§1§C§ka §8§l[§x§5§A§D§D§2§D§lK§x§5§8§C§5§2§5§ll§x§5§7§A§C§1§E§le§x§5§5§9§4§1§6§lb§x§4§E§9§B§1§8§lr§x§4§7§A§3§1§A§li§x§4§0§A§A§1§C§lg§8§l] §x§5§A§D§D§2§D§lS§x§5§9§C§D§2§8§lu§x§5§8§B§D§2§3§lm§x§5§7§A§C§1§E§lp§x§5§6§9§C§1§9§lf§x§5§3§9§6§1§7§la§x§4§E§9§B§1§8§ln§x§4§9§A§0§1§9§lg§x§4§5§A§5§1§B§le§x§4§0§A§A§1§C§ll §x§4§0§A§A§1§C§ka§x§5§A§D§D§2§D§ka");
        SwordMeta.addEnchant(Enchantment.DURABILITY, 5, true);
        ArrayList lore = new ArrayList();
        lore.add("§eKlebrig");
        lore.add("");
        lore.add("§8• §7Lag lang in §x§5§A§D§D§2§DS§x§5§8§C§5§2§5c§x§5§7§A§C§1§Eh§x§5§5§9§4§1§6l§x§4§E§9§B§1§8e§x§4§7§A§3§1§Ai§x§4§0§A§A§1§Cm§7...");
        lore.add("    §7Diese Angel hat eine kleine");
        lore.add("    §7Chance während der Nutzung §fSpinnweben");
        lore.add("    §7in dein Inventar zu legen!");
        SwordMeta.setLore(lore);

        Drop4.setItemMeta(SwordMeta);

        return Drop4;
    }

}
