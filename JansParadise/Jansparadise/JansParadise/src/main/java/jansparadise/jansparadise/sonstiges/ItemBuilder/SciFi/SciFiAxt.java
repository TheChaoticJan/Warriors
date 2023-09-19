package jansparadise.jansparadise.sonstiges.ItemBuilder.SciFi;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class SciFiAxt {

    public static ItemStack SciFiSchwert(){

        ItemStack Drop4 = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta SwordMeta = Drop4.getItemMeta();
        SwordMeta.setDisplayName("§x§C§6§0§B§F§9§ka§x§0§0§8§D§F§F§ka §8§l[§x§0§0§8§D§F§F§lS§x§1§E§5§5§F§F§lc§x§3§D§1§C§F§F§li§x§6§4§0§2§F§E§l-§x§9§5§0§7§F§B§lF§x§C§6§0§B§F§9§li§8§l] §x§2§D§9§6§D§D§lZ§x§3§9§8§8§D§9§le§x§4§4§7§A§D§6§lr§x§5§0§6§C§D§2§lh§x§5§B§5§E§C§E§la§x§7§5§4§7§C§C§lc§x§8§F§2§F§C§A§lk§x§A§9§1§8§C§7§le§x§C§3§0§0§C§5§lr §x§0§0§8§D§F§F§ka§x§C§6§0§B§F§9§ka");
        SwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
        ArrayList lore = new ArrayList();
        lore.add("§eSci-Fi");
        lore.add("");
        lore.add("§8• §7Aus ferner §x§0§0§8§D§F§FZ§x§1§9§5§E§F§Fu§x§3§3§2§F§F§Fk§x§4§C§0§0§F§Fu§x§7§5§0§4§F§Dn§x§9§D§0§7§F§Bf§x§C§6§0§B§F§9t§7...");
        lore.add("    §7Diese Axt hat eine kleine Chance");
        lore.add("    §7während der Nutzung §5Enderperlen");
        lore.add("    §7in dein Inventar zu legen!");
        SwordMeta.setLore(lore);

        Drop4.setItemMeta(SwordMeta);

        return Drop4;
    }
}
