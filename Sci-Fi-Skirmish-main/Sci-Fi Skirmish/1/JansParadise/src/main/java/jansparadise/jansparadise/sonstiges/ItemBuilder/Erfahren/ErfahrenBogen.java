package jansparadise.jansparadise.sonstiges.ItemBuilder.Erfahren;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ErfahrenBogen {

    public static ItemStack ErfahrenBow(){

        ItemStack Drop4 = new ItemStack(Material.BOW);
        ItemMeta SwordMeta = Drop4.getItemMeta();
        SwordMeta.setDisplayName("§x§E§B§D§7§7§B§ka§x§B§E§D§5§5§6§ka §8§l[§x§E§B§D§7§7§B§lE§x§E§5§D§7§7§6§lr§x§D§E§D§6§7§0§lf§x§D§8§D§6§6§B§la§x§D§1§D§6§6§6§lh§x§C§B§D§6§6§1§lr§x§C§4§D§5§5§B§le§x§B§E§D§5§5§6§ln§8§l] §x§E§B§D§7§7§B§lZ§x§E§7§D§7§7§8§lu§x§E§4§D§7§7§5§lr§x§E§0§D§7§7§2§le§x§D§C§D§6§6§F§lc§x§D§8§D§6§6§C§lh§x§D§5§D§6§6§9§lt§x§D§1§D§6§6§5§lw§x§C§D§D§6§6§2§le§x§C§9§D§6§5§F§li§x§C§6§D§5§5§C§ls§x§C§2§D§5§5§9§le§x§B§E§D§5§5§6§lr §x§B§E§D§5§5§6§ka§x§E§B§D§7§7§B§ka");
        SwordMeta.addEnchant(Enchantment.ARROW_DAMAGE, 6, true);
        
        ArrayList lore = new ArrayList();
        lore.add("§eErfahren");
        lore.add("");
        lore.add("§8• §7Hatte langes §x§E§B§D§7§7§BT§x§E§5§D§7§7§6r§x§D§E§D§6§7§0a§x§D§8§D§6§6§Bi§x§D§1§D§6§6§6n§x§C§B§D§6§6§1i§x§C§4§D§5§5§Bn§x§B§E§D§5§5§6g§7...");
        lore.add("    §7Dieser Bogen hat eine kleine");
        lore.add("    §7Chance während der Nutzung ");
        lore.add("    §aErfahrungsfläschchen");
        lore.add("    §7in dein Inventar zu legen!");
        SwordMeta.setLore(lore);

        Drop4.setItemMeta(SwordMeta);

        return Drop4;
    }
}
