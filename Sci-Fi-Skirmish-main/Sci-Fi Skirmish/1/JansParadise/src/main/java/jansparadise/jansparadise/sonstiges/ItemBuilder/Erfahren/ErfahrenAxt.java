package jansparadise.jansparadise.sonstiges.ItemBuilder.Erfahren;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ErfahrenAxt {

    public static ItemStack ErfahrenBeil(){

        ItemStack Drop4 = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta SwordMeta = Drop4.getItemMeta();
        SwordMeta.setDisplayName("§x§E§B§D§7§7§B§ka§x§B§E§D§5§5§6§ka §8§l[§x§E§B§D§7§7§B§lE§x§E§5§D§7§7§6§lr§x§D§E§D§6§7§0§lf§x§D§8§D§6§6§B§la§x§D§1§D§6§6§6§lh§x§C§B§D§6§6§1§lr§x§C§4§D§5§5§B§le§x§B§E§D§5§5§6§ln§8§l] §x§E§B§D§7§7§B§lB§x§D§C§D§6§6§F§le§x§C§D§D§6§6§2§li§x§B§E§D§5§5§6§ll §x§B§E§D§5§5§6§ka§x§E§B§D§7§7§B§ka");
        SwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 6, true);

        ArrayList lore = new ArrayList();
        lore.add("§eErfahren");
        lore.add("");
        lore.add("§8• §7Hatte langes §x§E§B§D§7§7§BT§x§E§5§D§7§7§6r§x§D§E§D§6§7§0a§x§D§8§D§6§6§Bi§x§D§1§D§6§6§6n§x§C§B§D§6§6§1i§x§C§4§D§5§5§Bn§x§B§E§D§5§5§6g§7...");
        lore.add("    §7Diese Axt hat eine kleine");
        lore.add("    §7Chance während der Nutzung ");
        lore.add("    §aErfahrungsfläschchen");
        lore.add("    §7in dein Inventar zu legen!");
        SwordMeta.setLore(lore);

        Drop4.setItemMeta(SwordMeta);

        return Drop4;
    }
}
