package plugin.utils.ItemBuilder;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Western {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private static final String date = "§8• §7§oGefunden: §4§o" + simpleDateFormat.format(new Date());

    public static ItemStack Schwert(Player p){
        ItemStack Sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta SwordMeta = Sword.getItemMeta();
        SwordMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        SwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        SwordMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        SwordMeta.addEnchant(Enchantment.MENDING, 1, true);
        ArrayList<String> SwordLore = new ArrayList<>();
        SwordLore.add("");
        SwordLore.add("§8• §7Erhalten vom §6Western§7-§4Gott§7...");
        SwordLore.add("   §7» Dieses Schwert gab dir der §6Western§7-§4Gott§7,");
        SwordLore.add("   §7  um deine Gegner in die §4Hölle §7zu combo`n!");
        SwordLore.add("");
        SwordLore.add(date);
        SwordMeta.setLore(SwordLore);
        if(!(p.getDisplayName().endsWith("s"))) {
            SwordMeta.setDisplayName("§c§kaa §4§l" + p.getDisplayName() + "`s §6§lSäbel §c§kaa");
        }
        else{
            SwordMeta.setDisplayName("§c§kaa §4§l" + p.getDisplayName() + "` §6§lSäbel §c§kaa");
        }
        Sword.setItemMeta(SwordMeta);
        return Sword;
    }

    public static ItemStack Rod(Player p){
        ItemStack Rod = new ItemStack(Material.FISHING_ROD);
        ItemMeta RodMeta = Rod.getItemMeta();
        RodMeta.setUnbreakable(true);
        RodMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        RodMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        RodMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        ArrayList<String> RodLore = new ArrayList<>();
        RodLore.add("");
        RodLore.add("§8• §7Erhalten vom §6Western§7-§4Gott§7...");
        RodLore.add("   §7» Diese Angel ist unzerstörber, so ");
        RodLore.add("   §7  wie es der §6Western§7-§4Gott §7wollte!");
        RodLore.add("");
        RodLore.add(date);
        RodLore.add("");
        RodMeta.setLore(RodLore);
        if(!(p.getDisplayName().endsWith("s"))) {
            RodMeta.setDisplayName("§c§kaa §4§l" + p.getDisplayName() + "`s §6§lRod §c§kaa");
        }
        else{
            RodMeta.setDisplayName("§c§kaa §4§l" + p.getDisplayName() + "` §6§lRod §c§kaa");
        }
        Rod.setItemMeta(RodMeta);
        return Rod;
    }

    public static ItemStack Picke(Player p){
        ItemStack Pick = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemMeta PickMeta = Pick.getItemMeta();
        PickMeta.setUnbreakable(true);
        PickMeta.addEnchant(Enchantment.DIG_SPEED, 100, true);
        PickMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        PickMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        ArrayList<String> PickLore = new ArrayList<>();
        PickLore.add("");
        PickLore.add("§8• §7Erhalten vom §6Western§7-§4Gott§7...");
        PickLore.add("   §7» Diese Spitzhacke ist unzerstörbar und ");
        PickLore.add("   §7  gut geignet §6Sandstein §7abzubauen!");
        PickLore.add("");
        PickLore.add(date);
        PickMeta.setLore(PickLore);
        if(!(p.getDisplayName().endsWith("s"))) {
            PickMeta.setDisplayName("§c§kaa §4§l" + p.getDisplayName() + "`s §6§lSandsteinpicke §c§kaa");
        }
        else{
            PickMeta.setDisplayName("§c§kaa §4§l" + p.getDisplayName() + "` §6§lSandsteinpicke §c§kaa");
        }
        Pick.setItemMeta(PickMeta);
        return Pick;
    }

    public static ItemStack Bogen(Player p){
        ItemStack Bow = new ItemStack(Material.BOW);
        ItemMeta bowmeta = Bow.getItemMeta();
        bowmeta.addEnchant(Enchantment.DURABILITY, 3, true);
        bowmeta.addEnchant(Enchantment.ARROW_DAMAGE, 5, true);
        bowmeta.addEnchant(Enchantment.MENDING, 1, true);
        bowmeta.addEnchant(Enchantment.ARROW_FIRE, 2, true);
        bowmeta.addEnchant(Enchantment.ARROW_KNOCKBACK,2, true);
        ArrayList<String> BowLore = new ArrayList<>();
        BowLore.add("");
        BowLore.add("§8• §7Erhalten vom §6Western§7-§4Gott§7...");
        BowLore.add("    §7» Dieser Bogen wurde vom §6Western§7-§4Gott");
        BowLore.add("   §7   geschaffen, um das §6spammen §7zu meistern!");
        BowLore.add("");
        BowLore.add(date);
        BowLore.add("");
        bowmeta.setLore(BowLore);
        if(!(p.getDisplayName().endsWith("s"))) {
            bowmeta.setDisplayName("§c§kaa §4§l" + p.getDisplayName() + "`s §6§lBospammer §c§kaa");
        }
        else{
            bowmeta.setDisplayName("§c§kaa §4§l" + p.getDisplayName() + "` §6§lBospammer §c§kaa");
        }
        Bow.setItemMeta(bowmeta);
        return Bow;
    }

    public static ItemStack Helmet(Player p){
        ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta1 = Helmet.getItemMeta();
        meta1.addEnchant(Enchantment.MENDING,1 ,true);
        meta1.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
        meta1.addEnchant(Enchantment.DURABILITY, 3, true);
        if(!(p.getDisplayName().endsWith("s"))) {
            meta1.setDisplayName("§c§kaa §4§l" + p.getDisplayName() + "`s §6§lHelm §c§k§oaa");
        }
        else{
            meta1.setDisplayName("§c§kaa §4§l" + p.getDisplayName() + "` §6§lHelm §c§kaa");
        }
        Helmet.setItemMeta(meta1);
        return Helmet;
    }

    public static ItemStack Chestplate(Player p){
        ItemStack Armor = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta2 = Armor.getItemMeta();
        meta2.addEnchant(Enchantment.MENDING,1 ,true);
        meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
        meta2.addEnchant(Enchantment.DURABILITY, 3, true);
        if(!(p.getDisplayName().endsWith("s"))) {
            meta2.setDisplayName("§c§kaa §4§l" + p.getDisplayName() + "`s §6§lBrustplatte §c§kaa");
        }
        else{
            meta2.setDisplayName("§c§kaa §4§l" + p.getDisplayName() + "` §6§lBrustplatte §c§kaa");
        }
        Armor.setItemMeta(meta2);
        return Armor;
    }

    public static ItemStack Leggings(Player p){
        ItemStack Leggins = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta3 = Leggins.getItemMeta();
        meta3.addEnchant(Enchantment.MENDING,1 ,true);
        meta3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
        meta3.addEnchant(Enchantment.DURABILITY, 3, true);
        if(!(p.getDisplayName().endsWith("s"))) {
            meta3.setDisplayName("§c§kaa §4§l" + p.getDisplayName() + "`s §6§lBeinschutz §c§kaa");
        }
        else{
            meta3.setDisplayName("§c§kaa §4§l" + p.getDisplayName() + "` §6§lBeinschutz §c§kaa");
        }
        Leggins.setItemMeta(meta3);
        return Leggins;
    }

    public static ItemStack Boots(Player p){
        ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta4 = Boots.getItemMeta();
        meta4.addEnchant(Enchantment.MENDING,1 ,true);
        meta4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
        meta4.addEnchant(Enchantment.DURABILITY, 3, true);
        meta4.addEnchant(Enchantment.DEPTH_STRIDER, 3, false);
        if(!(p.getDisplayName().endsWith("s"))) {
            meta4.setDisplayName("§c§kaa §4§l" + p.getDisplayName() + "`s §6§lSchuhe §c§kaa");
        }
        else{
            meta4.setDisplayName("§c§kaa §4§l" + p.getDisplayName() + "` §6§lSchuhe §c§kaa");
        }
        Boots.setItemMeta(meta4);
        return Boots;
    }
}
