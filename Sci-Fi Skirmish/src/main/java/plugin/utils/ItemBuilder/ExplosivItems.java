package plugin.utils.ItemBuilder;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ExplosivItems {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private static final String date = "§8• §7§oGecraftet: §c§o" + simpleDateFormat.format(new Date());

    private static ArrayList<String> lore(){
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§eExplosiv");
        lore.add("");
        lore.add("§8• §x§D§D§2§D§2§DE§x§C§D§3§A§2§8x§x§B§D§4§7§2§3p§x§A§C§5§4§1§El§x§9§C§6§1§1§9o§x§9§6§6§A§1§7d§x§9§B§6§D§1§8i§x§A§0§7§1§1§9e§x§A§5§7§4§1§Br§x§A§A§7§8§1§Ct §7gelegentlich...");
        lore.add("    §7Dieses Item hat eine kleine");
        lore.add("    §7Chance während der Nutzung §cTNT");
        lore.add("    §7in dein Inventar zu legen!");
        lore.add("");
        lore.add(date);
        return lore;
    }

    public static ItemStack Angel(){

        ItemStack Drop4 = new ItemStack(Material.FISHING_ROD);
        ItemMeta SwordMeta = Drop4.getItemMeta();
        SwordMeta.setDisplayName("§x§D§D§2§D§2§D§ka§x§A§A§7§8§1§C§ka §8§l[§x§D§D§2§D§2§D§lE§x§C§8§3§E§2§6§lx§x§B§3§4§F§2§0§lp§x§9§E§6§0§1§9§ll§x§9§7§6§A§1§7§lo§x§9§D§6§F§1§9§ls§x§A§4§7§3§1§A§li§x§A§A§7§8§1§C§lv§8§l] §x§D§D§2§D§2§D§lW§x§C§E§3§9§2§8§li§x§B§1§5§0§1§F§ld§x§A§3§5§C§1§B§le§x§9§4§6§8§1§6§lr§x§9§8§6§B§1§7§lh§x§9§D§6§E§1§8§la§x§A§1§7§2§1§A§lk§x§A§6§7§5§1§B§le§x§A§A§7§8§1§C§ln §x§A§A§7§8§1§C§ka§x§D§D§2§D§2§D§ka");
        SwordMeta.addEnchant(Enchantment.DURABILITY, 5, true);
        SwordMeta.setLore(lore());

        Drop4.setItemMeta(SwordMeta);

        return Drop4;
    }

    public static ItemStack Spitzhacke(){

        ItemStack Drop4 = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta SwordMeta = Drop4.getItemMeta();
        SwordMeta.setDisplayName("§x§D§D§2§D§2§D§ka§x§A§A§7§8§1§C§ka §8§l[§x§D§D§2§D§2§D§lE§x§C§8§3§E§2§6§lx§x§B§3§4§F§2§0§lp§x§9§E§6§0§1§9§ll§x§9§7§6§A§1§7§lo§x§9§D§6§F§1§9§ls§x§A§4§7§3§1§A§li§x§A§A§7§8§1§C§lv§8§l] §x§D§D§2§D§2§D§lB§x§C§0§4§5§2§4§lo§x§A§3§5§C§1§B§lh§x§9§8§6§B§1§7§lr§x§A§1§7§2§1§A§le§x§A§A§7§8§1§C§lr §x§A§A§7§8§1§C§ka§x§D§D§2§D§2§D§ka");
        SwordMeta.addEnchant(Enchantment.DIG_SPEED, 6, true);
        SwordMeta.addEnchant(Enchantment.DURABILITY, 6, true);
        SwordMeta.setLore(lore());

        Drop4.setItemMeta(SwordMeta);

        return Drop4;
    }

    public static ItemStack Zuendkerze(){
        ItemStack Kerze = new ItemStack(Material.ORANGE_CANDLE);
        ItemMeta kerzenMeta = Kerze.getItemMeta();
        kerzenMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        kerzenMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        kerzenMeta.setDisplayName("§x§D§D§2§D§2§D§ka§x§A§A§7§8§1§C§ka §8§l[§x§D§D§2§D§2§D§lE§x§C§8§3§E§2§6§lx§x§B§3§4§F§2§0§lp§x§9§E§6§0§1§9§ll§x§9§7§6§A§1§7§lo§x§9§D§6§F§1§9§ls§x§A§4§7§3§1§A§li§x§A§A§7§8§1§C§lv§8§l] §x§F§F§0§0§4§8§lZ§x§F§3§0§E§4§1§lü§x§E§7§1§C§3§A§ln§x§D§B§2§A§3§3§ld§x§C§F§3§9§2§C§lk§x§C§2§4§7§2§4§le§x§B§6§5§5§1§D§lr§x§A§A§6§3§1§6§lz§x§9§E§7§1§0§F§le §x§A§A§7§8§1§C§ka§x§D§D§2§D§2§D§ka");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§8• §x§D§D§2§D§2§DE§x§C§D§3§A§2§8x§x§B§D§4§7§2§3p§x§A§C§5§4§1§El§x§9§C§6§1§1§9o§x§9§6§6§A§1§7d§x§9§B§6§D§1§8i§x§A§0§7§1§1§9e§x§A§5§7§4§1§Br§x§A§A§7§8§1§Ct §7gelegentlich...");
        lore.add("  §8▸ §7Mit dieser §x§F§F§0§0§4§8Z§x§F§3§0§E§4§1ü§x§E§7§1§C§3§An§x§D§B§2§A§3§3d§x§C§F§3§9§2§Ck§x§C§2§4§7§2§4e§x§B§6§5§5§1§Dr§x§A§A§6§3§1§6z§x§9§E§7§1§0§Fe§7, kannst");
        lore.add("    §7du dich alle §65 Sekunden");
        lore.add("    §7nach vorn katapultieren!");
        lore.add("");
        lore.add(date);
        kerzenMeta.setLore(lore);
        Kerze.setItemMeta(kerzenMeta);
        return Kerze;
    }
}
