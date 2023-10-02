package jansparadise.jansparadise.sonstiges.ItemBuilder.Klebrig;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class KlebrigBogen {

    public static ItemStack KlebrigBogen(){

        ItemStack Drop4 = new ItemStack(Material.BOW);
        ItemMeta SwordMeta = Drop4.getItemMeta();
        SwordMeta.setDisplayName("§x§5§A§D§D§2§D§ka§x§4§0§A§A§1§C§ka §8§l[§x§5§A§D§D§2§D§lK§x§5§8§C§5§2§5§ll§x§5§7§A§C§1§E§le§x§5§5§9§4§1§6§lb§x§4§E§9§B§1§8§lr§x§4§7§A§3§1§A§li§x§4§0§A§A§1§C§lg§8§l] §x§5§A§D§D§2§D§lS§x§5§9§D§1§2§9§lc§x§5§8§C§5§2§5§lh§x§5§8§B§9§2§2§ll§x§5§7§A§C§1§E§la§x§5§6§A§0§1§A§lm§x§5§5§9§4§1§6§lm§x§5§2§9§8§1§7§lw§x§4§E§9§B§1§8§le§x§4§B§9§F§1§9§lr§x§4§7§A§3§1§A§lf§x§4§4§A§6§1§B§le§x§4§0§A§A§1§C§lr §x§4§0§A§A§1§C§ka§x§5§A§D§D§2§D§ka");
        SwordMeta.addEnchant(Enchantment.ARROW_DAMAGE, 6, true);
        ArrayList lore = new ArrayList();
        lore.add("§eKlebrig");
        lore.add("");
        lore.add("§8• §7Lag lang in §x§5§A§D§D§2§DS§x§5§8§C§5§2§5c§x§5§7§A§C§1§Eh§x§5§5§9§4§1§6l§x§4§E§9§B§1§8e§x§4§7§A§3§1§Ai§x§4§0§A§A§1§Cm§7...");
        lore.add("    §7Dieser Bogen hat eine kleine");
        lore.add("    §7Chance während der Nutzung §fSpinnweben");
        lore.add("    §7in dein Inventar zu legen!");
        SwordMeta.setLore(lore);

        Drop4.setItemMeta(SwordMeta);

        return Drop4;
    }
}
