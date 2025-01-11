package plugin.specialitems.western;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.checkerframework.framework.qual.DefaultQualifier;
import plugin.Main;
import plugin.utils.essentials.Bossbars;

import java.awt.*;
import java.lang.reflect.Array;
import java.nio.charset.MalformedInputException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class WesternItems implements Listener {

    private static final NamespacedKey key = new NamespacedKey(Main.getInstance(), "western");

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");

    private static BossBar bossBar;

    private static ArrayList<Component> lore(){
        ArrayList<Component> list = new ArrayList<>();
        list.add(MiniMessage.miniMessage().deserialize("<i:false><gold>Western"));
        list.add(Component.empty());
        list.add(Component.text(""));

        return list;
    }

    private static void sendBossBar(Player player) {

        if(bossBar != null){
            bossBar.removeAll();
        }

        bossBar = Bukkit.createBossBar("§6§lWestern §c§lDrop", BarColor.PURPLE, BarStyle.SOLID);
        bossBar.addPlayer(player);

        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
            bossBar.removeAll();
            bossBar = null;
        }, 60); // 40 ticks = 2 seconds
    }

    public static ItemStack Schwert(Player p){
        ItemStack Sword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta SwordMeta = Sword.getItemMeta();
        SwordMeta.addEnchant(Enchantment.KNOCKBACK, 1, true);
        SwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        SwordMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        SwordMeta.addEnchant(Enchantment.MENDING, 1, true);

        SwordMeta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 0);

        if(!(p.getName().endsWith("s"))) {
            SwordMeta.setDisplayName("§c§kaa §4§l" + p.getName() + "`s §6§lSäbel §c§kaa");
        }
        else{
            SwordMeta.setDisplayName("§c§kaa §4§l" + p.getName() + "` §6§lSäbel §c§kaa");
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

        if(!(p.getName().endsWith("s"))) {
            RodMeta.setDisplayName("§c§kaa §4§l" + p.getName() + "`s §6§lRod §c§kaa");
        }
        else{
            RodMeta.setDisplayName("§c§kaa §4§l" + p.getName() + "` §6§lRod §c§kaa");
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

        if(!(p.getName().endsWith("s"))) {
            PickMeta.setDisplayName("§c§kaa §4§l" + p.getName() + "`s §6§lSandsteinpicke §c§kaa");
        }
        else{
            PickMeta.setDisplayName("§c§kaa §4§l" + p.getName() + "` §6§lSandsteinpicke §c§kaa");
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

        if(!(p.getName().endsWith("s"))) {
            bowmeta.setDisplayName("§c§kaa §4§l" + p.getName() + "`s §6§lBowspammer §c§kaa");
        }
        else{
            bowmeta.setDisplayName("§c§kaa §4§l" + p.getName() + "` §6§lBowspammer §c§kaa");
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
        if(!(p.getName().endsWith("s"))) {
            meta1.setDisplayName("§c§kaa §4§l" + p.getName() + "`s §6§lHelm §c§k§oaa");
        }
        else{
            meta1.setDisplayName("§c§kaa §4§l" + p.getName() + "` §6§lHelm §c§kaa");
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
        if(!(p.getName().endsWith("s"))) {
            meta2.setDisplayName("§c§kaa §4§l" + p.getName() + "`s §6§lBrustplatte §c§kaa");
        }
        else{
            meta2.setDisplayName("§c§kaa §4§l" + p.getName() + "` §6§lBrustplatte §c§kaa");
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
        if(!(p.getName().endsWith("s"))) {
            meta3.setDisplayName("§c§kaa §4§l" + p.getName() + "`s §6§lBeinschutz §c§kaa");
        }
        else{
            meta3.setDisplayName("§c§kaa §4§l" + p.getName() + "` §6§lBeinschutz §c§kaa");
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
        if(!(p.getName().endsWith("s"))) {
            meta4.setDisplayName("§c§kaa §4§l" + p.getName() + "`s §6§lSchuhe §c§kaa");
        }
        else{
            meta4.setDisplayName("§c§kaa §4§l" + p.getName() + "` §6§lSchuhe §c§kaa");
        }
        Boots.setItemMeta(meta4);
        return Boots;
    }

    @EventHandler
    private void bowHitEvent(ProjectileHitEvent event) {

        if(event.getEntity().getShooter() instanceof Player player){

            if(player.getInventory().getItemInMainHand().getType() == Material.AIR){return;}
            if(!player.getInventory().getItemInMainHand().hasItemMeta()){return;}
            if(player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(key)){
                checkItemDrops(player);
            }
        }

    }

    @EventHandler
    private void playerApplyDamageEvent(EntityDamageByEntityEvent event) {

        if(event.getDamager() instanceof Player player){

            if(player.getInventory().getItemInMainHand().getType() == Material.AIR){return;}
            if(!player.getInventory().getItemInMainHand().hasItemMeta()){return;}
            if(player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(key)){
                checkItemDrops(player);
            }

        }

    }
    private static void checkItemDrops(Player player) {

        boolean bl = false;
        final Material [] items = {Material.ENDER_PEARL, Material.EXPERIENCE_BOTTLE, Material.TNT, Material.COBWEB};
        final int [] amounts = {1, 4, 3, 2};

        int random = (int) (Math.random() * 300) + 1;
        if (random == 1) {

            //Selecting which random ItemStack to drop
            int randomDrop = new Random().nextInt(0, 3);
            Material material = items[randomDrop];
            int amount = amounts[randomDrop];


            for (int l = 0; l < 36; l++) {
                if (player.getInventory().getItem(l) == null || Objects.requireNonNull(player.getInventory().getItem(l)).getType() == material && Objects.requireNonNull(player.getInventory().getItem(l)).getAmount() <= 15) {
                    bl = true;
                }
            }
            if (bl) {
                player.getInventory().addItem(new ItemStack(material, amount));
            } else {
                int x = player.getLocation().getBlockX();
                int y = player.getLocation().getBlockY();
                int z = player.getLocation().getBlockZ();
                player.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), new ItemStack(material, amount));
            }

            sendBossBar(player);
        }
    }
}

