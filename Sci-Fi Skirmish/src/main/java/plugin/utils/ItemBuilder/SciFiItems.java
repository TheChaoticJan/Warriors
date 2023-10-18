package plugin.utils.ItemBuilder;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SciFiItems {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private static String date = "§8• §7§oGecraftet: §9§o" + simpleDateFormat.format(new Date());
    private static ArrayList<String> lore(){
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("§eSci-Fi");
        lore.add("");
        lore.add("§8• §7Aus ferner §x§0§0§8§D§F§FZ§x§1§9§5§E§F§Fu§x§3§3§2§F§F§Fk§x§4§C§0§0§F§Fu§x§7§5§0§4§F§Dn§x§9§D§0§7§F§Bf§x§C§6§0§B§F§9t§7...");
        lore.add("    §7Dieses Item hat eine kleine Chance");
        lore.add("    §7während der Nutzung §5Enderperlen");
        lore.add("    §7in dein Inventar zu legen!");
        lore.add("");
        lore.add(date);
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

    public static ItemStack Zahlungsvorschuss(){
        ItemStack wand = new ItemStack(Material.BLUE_CANDLE);
        ItemMeta wandMeta = wand.getItemMeta();
        wandMeta.setDisplayName("§x§C§6§0§B§F§9§ka§x§0§0§8§D§F§F§ka §8§l[§x§0§0§8§D§F§F§lS§x§1§E§5§5§F§F§lc§x§3§D§1§C§F§F§li§x§6§4§0§2§F§E§l-§x§9§5§0§7§F§B§lF§x§C§6§0§B§F§9§li§8§l] §x§0§0§4§4§F§C§lZ§x§0§E§3§C§F§9§la§x§1§B§3§5§F§6§lh§x§2§9§2§D§F§3§ll§x§3§6§2§5§F§0§lu§x§4§4§1§D§E§D§ln§x§5§1§1§6§E§A§lg§x§5§F§0§E§E§7§ls§x§6§C§0§6§E§4§lv§x§7§5§0§5§E§7§lo§x§7§E§0§5§E§B§lr§x§8§7§0§4§E§E§ls§x§9§0§0§3§F§2§lc§x§9§8§0§2§F§5§lh§x§A§1§0§2§F§8§lu§x§A§A§0§1§F§C§ls§x§B§3§0§0§F§F§ls §x§0§0§8§D§F§F§ka§x§C§6§0§B§F§9§ka");
        wandMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
        wandMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("");
        lore.add("§8• §7Aus ferner §x§0§0§8§D§F§FZ§x§1§9§5§E§F§Fu§x§3§3§2§F§F§Fk§x§4§C§0§0§F§Fu§x§7§5§0§4§F§Dn§x§9§D§0§7§F§Bf§x§C§6§0§B§F§9t§7...");
        lore.add("   §8▸ §7Mit dem §x§0§0§4§4§F§CZ§x§0§E§3§C§F§9a§x§1§B§3§5§F§6h§x§2§9§2§D§F§3l§x§3§6§2§5§F§0u§x§4§4§1§D§E§Dn§x§5§1§1§6§E§Ag§x§5§F§0§E§E§7s§x§6§C§0§6§E§4v§x§7§5§0§5§E§7o§x§7§E§0§5§E§Br§x§8§7§0§4§E§Es§x§9§0§0§3§F§2c§x§9§8§0§2§F§5h§x§A§1§0§2§F§8u§x§A§A§0§1§F§Cs§x§B§3§0§0§F§Fs");
        lore.add("     §7kannst du alle §55 Minuten");
        lore.add("     §7einen §x§F§F§E§2§5§9N§x§F§F§D§E§5§8a§x§F§F§D§A§5§8c§x§F§F§D§5§5§7h§x§F§F§D§1§5§7s§x§F§F§C§D§5§6c§x§F§F§C§9§5§6h§x§F§F§C§5§5§5u§x§F§F§C§0§5§4b§x§F§F§B§C§5§4s§x§F§F§B§8§5§3k§x§F§F§B§4§5§3i§x§F§F§A§F§5§2s§x§F§F§A§B§5§2t§x§F§F§A§7§5§1e§x§F§F§A§7§5§1n §7Drop, der");
        lore.add("     §7mindestens §x§7§8§0§0§D§FE§x§7§3§0§1§C§7p§x§6§E§0§2§B§0i§x§6§A§0§4§9§8s§x§6§5§0§5§8§1c§x§6§0§0§6§6§9h §7ist, erhalten.");
        lore.add("");
        lore.add(date);
        wandMeta.setLore(lore);
        wand.setItemMeta(wandMeta);

        return wand;
    }
}
