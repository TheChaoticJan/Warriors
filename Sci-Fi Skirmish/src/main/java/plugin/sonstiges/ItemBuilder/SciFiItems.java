package plugin.sonstiges.ItemBuilder;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class SciFiItems {

    private static ArrayList<String> lore(){
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("§eSci-Fi");
        lore.add("");
        lore.add("§8• §7Aus ferner §x§0§0§8§D§F§FZ§x§1§9§5§E§F§Fu§x§3§3§2§F§F§Fk§x§4§C§0§0§F§Fu§x§7§5§0§4§F§Dn§x§9§D§0§7§F§Bf§x§C§6§0§B§F§9t§7...");
        lore.add("    §7Dieses Item hat eine kleine Chance");
        lore.add("    §7während der Nutzung §5Enderperlen");
        lore.add("    §7in dein Inventar zu legen!");
        lore.add("");
        return lore;
    }

    public static ItemStack Axt(){

        ItemStack Drop4 = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta SwordMeta = Drop4.getItemMeta();
        SwordMeta.setDisplayName("§x§C§6§0§B§F§9§ka§x§0§0§8§D§F§F§ka §8§l[§x§0§0§8§D§F§F§lS§x§1§E§5§5§F§F§lc§x§3§D§1§C§F§F§li§x§6§4§0§2§F§E§l-§x§9§5§0§7§F§B§lF§x§C§6§0§B§F§9§li§8§l] §x§2§D§9§6§D§D§lZ§x§3§9§8§8§D§9§le§x§4§4§7§A§D§6§lr§x§5§0§6§C§D§2§lh§x§5§B§5§E§C§E§la§x§7§5§4§7§C§C§lc§x§8§F§2§F§C§A§lk§x§A§9§1§8§C§7§le§x§C§3§0§0§C§5§lr §x§0§0§8§D§F§F§ka§x§C§6§0§B§F§9§ka");
        SwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
        SwordMeta.setLore(lore());

        Drop4.setItemMeta(SwordMeta);

        return Drop4;
    }

    public static ItemStack Bogen(){

        ItemStack Drop4 = new ItemStack(Material.BOW);
        ItemMeta SwordMeta = Drop4.getItemMeta();
        SwordMeta.setDisplayName("§x§C§6§0§B§F§9§ka§x§0§0§8§D§F§F§ka §8§l[§x§0§0§8§D§F§F§lS§x§1§E§5§5§F§F§lc§x§3§D§1§C§F§F§li§x§6§4§0§2§F§E§l-§x§9§5§0§7§F§B§lF§x§C§6§0§B§F§9§li§8§l] §x§2§D§9§6§D§D§lG§x§3§F§8§0§D§7§le§x§5§2§6§9§D§1§lw§x§7§0§4§B§C§C§le§x§9§9§2§6§C§9§lh§x§C§3§0§0§C§5§lr §x§0§0§8§D§F§F§ka§x§C§6§0§B§F§9§ka");
        SwordMeta.addEnchant(Enchantment.ARROW_DAMAGE, 6, true);
        SwordMeta.setLore(lore());

        Drop4.setItemMeta(SwordMeta);

        return Drop4;
    }

    public static ItemStack Schwert(){

        ItemStack Drop4 = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta SwordMeta = Drop4.getItemMeta();
        SwordMeta.setDisplayName("§x§C§6§0§B§F§9§ka§x§0§0§8§D§F§F§ka §8§l[§x§0§0§8§D§F§F§lS§x§1§E§5§5§F§F§lc§x§3§D§1§C§F§F§li§x§6§4§0§2§F§E§l-§x§9§5§0§7§F§B§lF§x§C§6§0§B§F§9§li§8§l] §x§0§0§8§D§F§F§lS§x§1§6§6§5§F§F§li§x§2§B§3§C§F§F§ll§x§4§1§1§4§F§F§le§x§5§D§0§2§F§E§ln§x§8§0§0§5§F§C§lc§x§A§3§0§8§F§B§le§x§C§6§0§B§F§9§lr §x§0§0§8§D§F§F§ka§x§C§6§0§B§F§9§ka");
        SwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
        SwordMeta.setLore(lore());

        Drop4.setItemMeta(SwordMeta);

        return Drop4;
    }

    public static ItemStack Zauberstab(){
        ItemStack wand = new ItemStack(Material.STICK);
        ItemMeta wandMeta = wand.getItemMeta();
        wandMeta.setDisplayName("§x§C§6§0§B§F§9§ka§x§0§0§8§D§F§F§ka §8§l[§x§0§0§8§D§F§F§lS§x§1§E§5§5§F§F§lc§x§3§D§1§C§F§F§li§x§6§4§0§2§F§E§l-§x§9§5§0§7§F§B§lF§x§C§6§0§B§F§9§li§8§l] §x§0§0§8§D§F§F§lZ§x§2§6§6§E§F§F§la§x§4§B§4§E§F§F§lu§x§7§1§2§F§F§F§lb§x§9§6§1§0§F§F§le§x§A§C§0§1§F§E§lr§x§B§3§0§4§F§D§ls§x§B§9§0§6§F§C§lt§x§C§0§0§9§F§A§la§x§C§6§0§B§F§9§lb §x§0§0§8§D§F§F§ka§x§C§6§0§B§F§9§ka");
        wandMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
        wandMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("§eSci-Fi");
        lore.add("");
        lore.add("§8• §7Aus ferner §x§0§0§8§D§F§FZ§x§1§9§5§E§F§Fu§x§3§3§2§F§F§Fk§x§4§C§0§0§F§Fu§x§7§5§0§4§F§Dn§x§9§D§0§7§F§Bf§x§C§6§0§B§F§9t§7...");
        lore.add("    §7Dieser Stab besitzt die Fähigkeit, durch");
        lore.add("    §7klicken §x§0§0§7§B§D§FD§x§0§2§7§E§D§Ae§x§0§4§8§1§D§6f§x§0§6§8§4§D§1e§x§0§8§8§6§C§Ck§x§0§A§8§9§C§8t§x§0§C§8§C§C§3e §x§1§1§9§2§B§AR§x§1§3§9§5§B§5o§x§1§5§9§8§B§1b§x§1§7§9§A§A§Co§x§1§9§9§D§A§7t§x§1§B§A§0§A§3e§x§1§D§A§3§9§Er §7zu spawnen.");
        wandMeta.setLore(lore);
        wand.setItemMeta(wandMeta);

        return wand;
    }
}
