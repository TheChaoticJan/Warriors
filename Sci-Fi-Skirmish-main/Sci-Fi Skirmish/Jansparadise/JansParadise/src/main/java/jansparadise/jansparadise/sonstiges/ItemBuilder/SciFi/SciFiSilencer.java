package jansparadise.jansparadise.sonstiges.ItemBuilder.SciFi;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class SciFiSilencer {

    public static ItemStack SciFiSchwert(){

        ItemStack Drop4 = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta SwordMeta = Drop4.getItemMeta();
        SwordMeta.setDisplayName("§x§C§6§0§B§F§9§ka§x§0§0§8§D§F§F§ka §8§l[§x§0§0§8§D§F§F§lS§x§1§E§5§5§F§F§lc§x§3§D§1§C§F§F§li§x§6§4§0§2§F§E§l-§x§9§5§0§7§F§B§lF§x§C§6§0§B§F§9§li§8§l] §x§0§0§8§D§F§F§lS§x§1§6§6§5§F§F§li§x§2§B§3§C§F§F§ll§x§4§1§1§4§F§F§le§x§5§D§0§2§F§E§ln§x§8§0§0§5§F§C§lc§x§A§3§0§8§F§B§le§x§C§6§0§B§F§9§lr §x§0§0§8§D§F§F§ka§x§C§6§0§B§F§9§ka");
        SwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
        ArrayList lore = new ArrayList();
        lore.add("§eSci-Fi");
        lore.add("");
        lore.add("§8• §7Aus ferner §x§0§0§8§D§F§FZ§x§1§9§5§E§F§Fu§x§3§3§2§F§F§Fk§x§4§C§0§0§F§Fu§x§7§5§0§4§F§Dn§x§9§D§0§7§F§Bf§x§C§6§0§B§F§9t§7...");
        lore.add("    §7Dieses Schwert hat eine kleine Chance");
        lore.add("    §7während der Nutzung §5Enderperlen");
        lore.add("    §7in dein Inventar zu legen!");
        SwordMeta.setLore(lore);

        Drop4.setItemMeta(SwordMeta);

        return Drop4;
    }
}
