package plugin.utils.ItemBuilder;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
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

public class Candles {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private static final String date = "§8• §7Gecraftet: §a" + simpleDateFormat.format(new Date());
    private static final NamespacedKey key = new NamespacedKey(Main.getInstance(), "candle");
    public static ItemStack emptyCandle(){
        ItemStack candle = new ItemStack(Material.GRAY_CANDLE);
        ItemMeta CandleMeta = candle.getItemMeta();
        Component component = MiniMessage.miniMessage().deserialize("<i:false><gray><obf>a</obf><dark_gray><obf>a</obf><bold> [<gray>Elementlos<dark_gray>] <gradient:dark_gray:gray>Wunderkerze</gradient></bold> <dark_gray><obf>a</obf></dark_gray><reset><gray><obf>a</obf></gray>").asComponent();
        CandleMeta.displayName(component);
        CandleMeta.addEnchant(Enchantment.MENDING, 1, false);
        CandleMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        CandleMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "none");
        candle.setItemMeta(CandleMeta);
        return candle;
    }

    public static ItemStack teleportCandle(){
        ItemStack wand = new ItemStack(Material.GREEN_CANDLE);
        ItemMeta wandMeta = wand.getItemMeta();
        wandMeta.displayName(MiniMessage.miniMessage().deserialize("<i:false><obf><#5add2d>a<#40aa1c>a</obf> <dark_gray><bold>[<gradient:#5add2d:#40aa1c>Klebrig</gradient><dark_gray>] <gradient:#5add2d:#40aa1c>Wunderkerze</gradient></bold> <obf><#40aa1c>a<#5add2d>a"));
        wandMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
        wandMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        wandMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "teleport");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§8• §7Lag lange in §x§5§A§D§D§2§DS§x§5§8§C§5§2§5c§x§5§7§A§C§1§Eh§x§5§5§9§4§1§6l§x§4§E§9§B§1§8e§x§4§7§A§3§1§Ai§x§4§0§A§A§1§Cm§7...");
        lore.add("   §8▸ §7Mit dem §x§5§A§D§D§2§DP§x§5§9§C§D§2§8e§x§5§8§B§D§2§3i§x§5§7§A§C§1§El§x§5§6§9§C§1§9s§x§5§3§9§6§1§7e§x§4§E§9§B§1§8n§x§4§9§A§0§1§9d§x§4§5§A§5§1§Be§x§4§0§A§A§1§Cr");
        lore.add("     §7kannst du dich alle §a1:30 Minuten");
        lore.add("     §7in den §cGegner §7teleportieren");
        lore.add("     §7mit dem du gerade kämpfst!");
        lore.add("");
        lore.add(date);
        wandMeta.setLore(lore);
        wand.setItemMeta(wandMeta);

        return wand;
    }

    public static ItemStack crateCandle(){
        ItemStack wand = new ItemStack(Material.BLUE_CANDLE);
        ItemMeta wandMeta = wand.getItemMeta();
        wandMeta.displayName(MiniMessage.miniMessage().deserialize("<i:false><obf><#C60BF9>a<#008DFF>a</obf> <dark_gray><bold>[<gradient:#008DFF:#C60BF9>Sci-Fi<dark_gray>] <gradient:#0044FC:#B300FF>Wunderkerze</bold> <obf><#008DFF>a<#C60BF9>a"));
        wandMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
        wandMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        wandMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "crate");
        ArrayList<String> lore = new ArrayList<>();
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

    public static ItemStack healCandle(){

        ItemStack Zauberstab = new ItemStack(Material.YELLOW_CANDLE);
        ItemMeta ZauberMeta = Zauberstab.getItemMeta();
        ZauberMeta.displayName(MiniMessage.miniMessage().deserialize("<i:false><obf><#EBD77B>a<#BED556>a</obf> <dark_gray><bold>[<gradient:#EBD77B:#BED556>Erfahren<dark_gray>] <gradient:#E4E170:#9DCE4E>Wunderkerze</bold> <obf><#BED556>a<#EBD77B>a"));
        ZauberMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        ZauberMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ZauberMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "heal");
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

    public static ItemStack boostCandle(){
        ItemStack Kerze = new ItemStack(Material.ORANGE_CANDLE);
        ItemMeta kerzenMeta = Kerze.getItemMeta();
        kerzenMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        kerzenMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        kerzenMeta.setDisplayName("§x§D§D§2§D§2§D§ka§x§A§A§7§8§1§C§ka §8§l[§x§D§D§2§D§2§D§lE§x§C§8§3§E§2§6§lx§x§B§3§4§F§2§0§lp§x§9§E§6§0§1§9§ll§x§9§7§6§A§1§7§lo§x§9§D§6§F§1§9§ls§x§A§4§7§3§1§A§li§x§A§A§7§8§1§C§lv§8§l] §x§F§F§0§0§4§8§lZ§x§F§3§0§E§4§1§lü§x§E§7§1§C§3§A§ln§x§D§B§2§A§3§3§ld§x§C§F§3§9§2§C§lk§x§C§2§4§7§2§4§le§x§B§6§5§5§1§D§lr§x§A§A§6§3§1§6§lz§x§9§E§7§1§0§F§le §x§A§A§7§8§1§C§ka§x§D§D§2§D§2§D§ka");
        kerzenMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "boost");
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

    public static ItemStack superCandle(){
        ItemStack Kerze = new ItemStack(Material.PURPLE_CANDLE);
        ItemMeta kerzenMeta = Kerze.getItemMeta();
        kerzenMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        kerzenMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        kerzenMeta.displayName(MiniMessage.miniMessage().deserialize("<i:false><rainbow><obf>aa</obf><bold> [OP] Wunderkerze</bold> <obf>aa</rainbow>"));
        kerzenMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "none");
        kerzenMeta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "special"), PersistentDataType.INTEGER, 1);
        ArrayList<Component> lore = new ArrayList<>();
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize("<rainbow> Diese Kerze ist extrem op...</rainbow>"));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray> ▸ <gray>Diese <rainbow>Wunderkerze</rainbow><gray> kann"));
        lore.add(Component.text("   §7zwischen allen Formen der Kerzen"));
        lore.add(Component.text("   §7durchwechseln! (§eSneak + Rechtsklick§7)"));
        lore.add(Component.text(""));
        lore.add(Component.text("   §7Aktueller Modus: §bUndefiniert"));
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize((date.replace("§a", "<rainbow>").replace("§7", "<gray>").replace("§8", "<dark_gray>"))));
        kerzenMeta.lore(lore);
        Kerze.setItemMeta(kerzenMeta);
        return Kerze;
    }



}
