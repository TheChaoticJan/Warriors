package plugin.utils.ItemBuilder;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ErfahrenItems{
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private static final String date = "§8• §7§oGecraftet: §e§o" + simpleDateFormat.format(new Date());

    private static final NamespacedKey key = new NamespacedKey(Main.getInstance(), "Erfahren");
    private static ArrayList<String> lore(){
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§eErfahren");
        lore.add("");
        lore.add("§8• §7Hatte langes §x§E§B§D§7§7§BT§x§E§5§D§7§7§6r§x§D§E§D§6§7§0a§x§D§8§D§6§6§Bi§x§D§1§D§6§6§6n§x§C§B§D§6§6§1i§x§C§4§D§5§5§Bn§x§B§E§D§5§5§6g§7...");
        lore.add("    §7Dieses Item hat eine kleine");
        lore.add("    §7Chance während der Nutzung ");
        lore.add("    §aErfahrungsfläschchen");
        lore.add("    §7in dein Inventar zu legen!");
        lore.add("");
        lore.add(date);
        return lore;
    }

    public static ItemStack Axt(){

        ItemStack Drop4 = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta SwordMeta = Drop4.getItemMeta();
        SwordMeta.setDisplayName("§x§E§B§D§7§7§B§ka§x§B§E§D§5§5§6§ka §8§l[§x§E§B§D§7§7§B§lE§x§E§5§D§7§7§6§lr§x§D§E§D§6§7§0§lf§x§D§8§D§6§6§B§la§x§D§1§D§6§6§6§lh§x§C§B§D§6§6§1§lr§x§C§4§D§5§5§B§le§x§B§E§D§5§5§6§ln§8§l] §x§E§B§D§7§7§B§lB§x§D§C§D§6§6§F§le§x§C§D§D§6§6§2§li§x§B§E§D§5§5§6§ll §x§B§E§D§5§5§6§ka§x§E§B§D§7§7§B§ka");
        SwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
        SwordMeta.setLore(lore());
        SwordMeta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, 1);

        Drop4.setItemMeta(SwordMeta);

        return Drop4;
    }

    public static ItemStack Bogen(){

        ItemStack Drop4 = new ItemStack(Material.BOW);
        ItemMeta SwordMeta = Drop4.getItemMeta();
        SwordMeta.setDisplayName("§x§E§B§D§7§7§B§ka§x§B§E§D§5§5§6§ka §8§l[§x§E§B§D§7§7§B§lE§x§E§5§D§7§7§6§lr§x§D§E§D§6§7§0§lf§x§D§8§D§6§6§B§la§x§D§1§D§6§6§6§lh§x§C§B§D§6§6§1§lr§x§C§4§D§5§5§B§le§x§B§E§D§5§5§6§ln§8§l] §x§E§B§D§7§7§B§lZ§x§E§7§D§7§7§8§lu§x§E§4§D§7§7§5§lr§x§E§0§D§7§7§2§le§x§D§C§D§6§6§F§lc§x§D§8§D§6§6§C§lh§x§D§5§D§6§6§9§lt§x§D§1§D§6§6§5§lw§x§C§D§D§6§6§2§le§x§C§9§D§6§5§F§li§x§C§6§D§5§5§C§ls§x§C§2§D§5§5§9§le§x§B§E§D§5§5§6§lr §x§B§E§D§5§5§6§ka§x§E§B§D§7§7§B§ka");
        SwordMeta.addEnchant(Enchantment.ARROW_DAMAGE, 6, true);
        SwordMeta.setLore(lore());
        SwordMeta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, 1);
        Drop4.setItemMeta(SwordMeta);

        return Drop4;
    }

    public static ItemStack Schwert(){

        ItemStack Drop4 = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta SwordMeta = Drop4.getItemMeta();
        SwordMeta.setDisplayName("§x§E§B§D§7§7§B§ka§x§B§E§D§5§5§6§ka §8§l[§x§E§B§D§7§7§B§lE§x§E§5§D§7§7§6§lr§x§D§E§D§6§7§0§lf§x§D§8§D§6§6§B§la§x§D§1§D§6§6§6§lh§x§C§B§D§6§6§1§lr§x§C§4§D§5§5§B§le§x§B§E§D§5§5§6§ln§8§l] §x§E§B§D§7§7§B§lK§x§E§2§D§7§7§4§la§x§D§9§D§6§6§C§lt§x§D§0§D§6§6§5§la§x§C§7§D§5§5§D§ln§x§B§E§D§5§5§6§la §x§B§E§D§5§5§6§ka§x§E§B§D§7§7§B§ka");
        SwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
        SwordMeta.setLore(lore());
        SwordMeta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, 1);
        Drop4.setItemMeta(SwordMeta);

        return Drop4;
    }

    public static ItemStack Zauberstab(){

        ItemStack Zauberstab = new ItemStack(Material.YELLOW_CANDLE);
        ItemMeta ZauberMeta = Zauberstab.getItemMeta();
        ZauberMeta.setDisplayName("§x§E§B§D§7§7§B§ka§x§B§E§D§5§5§6§ka §8§l[§x§E§B§D§7§7§B§lE§x§E§5§D§7§7§6§lr§x§D§E§D§6§7§0§lf§x§D§8§D§6§6§B§la§x§D§1§D§6§6§6§lh§x§C§B§D§6§6§1§lr§x§C§4§D§5§5§B§le§x§B§E§D§5§5§6§ln§8§l] §x§E§4§E§1§7§0§lW§x§D§D§D§F§6§D§lu§x§D§6§D§D§6§9§ln§x§C§F§D§B§6§6§ld§x§C§8§D§9§6§2§le§x§C§1§D§8§5§F§lr§x§B§9§D§6§5§C§lk§x§B§2§D§4§5§8§le§x§A§B§D§2§5§5§lr§x§A§4§D§0§5§1§lz§x§9§D§C§E§4§E§le §x§B§E§D§5§5§6§ka§x§E§B§D§7§7§B§ka");
        ZauberMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        ZauberMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§8• §7Hatte langes §x§E§B§D§7§7§BT§x§E§5§D§7§7§6r§x§D§E§D§6§7§0a§x§D§8§D§6§6§Bi§x§D§1§D§6§6§6n§x§C§B§D§6§6§1i§x§C§4§D§5§5§Bn§x§B§E§D§5§5§6g§7...");
        lore.add("  §8▸ §7Diese §x§E§4§E§1§7§0W§x§D§D§D§F§6§Du§x§D§6§D§D§6§9n§x§C§F§D§B§6§6d§x§C§8§D§9§6§2e§x§C§1§D§8§5§Fr§x§B§9§D§6§5§Ck§x§B§2§D§4§5§8e§x§A§B§D§2§5§5r§x§A§4§D§0§5§1z§x§9§D§C§E§4§Ee §7kann");
        lore.add("    §7alle §e60 Sekunden§7, dein");
        lore.add("    §7lowstes Piece um §b15 Dura");
        lore.add("    §7heilen");
        lore.add("");
        lore.add(date);
        ZauberMeta.setLore(lore);
        Zauberstab.setItemMeta(ZauberMeta);

        return Zauberstab;
    }
}
