package jansparadise.jansparadise.events.InventoryEvents;

import jansparadise.jansparadise.sonstiges.InventoryBuilder.RezeptInventory;
import jansparadise.jansparadise.sonstiges.ItemBuilder.InventoryEssentials.BuildingBlocks;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ClickEvent implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if(e.getCurrentItem() == null){
            return;
        }

        if(e.getView().getTitle().endsWith("§f")){
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cZurück")){
                p.openInventory(RezeptInventory.inventory(p));
            }
            e.setCancelled(true);
        }

        if(e.getView().getTitle().contains("§x§0§0§F§F§E§0§l§nS§x§0§8§7§4§F§1§l§np§x§1§6§0§1§F§2§l§ne§x§4§9§0§6§A§1§l§nc§x§7§9§0§C§7§7§l§ni§x§A§7§1§5§9§B§l§na§x§B§E§1§6§8§1§l§nl§x§B§E§0§F§2§A§l§ni§x§D§6§5§4§0§8§l§nt§x§F§9§B§D§0§1§l§ne§x§9§4§B§D§0§B§l§nm§x§1§4§A§8§1§8§l§ns")){
            if(e.getCurrentItem() == null){
                return;
            }
            if(e.getCurrentItem().getType().isTransparent()){
                e.setCancelled(true);
            }else{
                ItemStack i = new ItemStack(e.getCurrentItem());
               p.getInventory().addItem(i);
               e.setCancelled(true);
            }
        }
        if(e.getView().getTitle().contains("§8Inventar von ")){
                e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase("§6WW§7-§eReloaded §7Kit")) {
            if(e.getCurrentItem() == null){
                return;
            }
               if(e.getCurrentItem().getItemMeta().hasItemFlag(ItemFlag.HIDE_ENCHANTS)){


                 //WW-Kit
                 if(e.getCurrentItem().getItemMeta().hasEnchant(Enchantment.ARROW_INFINITE)) {
                     Inventory i = p.getInventory();

                     ItemStack XP = new ItemStack(Material.EXPERIENCE_BOTTLE, 64);
                     i.setItem(3, XP);
                     i.setItem(9, XP);
                     i.setItem(10, XP);
                     i.setItem(11, XP);
                     i.setItem(12, XP);
                     i.setItem(18, XP);
                     i.setItem(19, XP);
                     i.setItem(20, XP);
                     i.setItem(21, XP);
                     i.setItem(27, XP);
                     i.setItem(28, XP);
                     i.setItem(29, XP);
                     i.setItem(30, XP);

                     ItemStack Webs = new ItemStack(Material.COBWEB, 64);
                     i.setItem(6, Webs);
                     i.setItem(15, Webs);
                     i.setItem(24, Webs);
                     i.setItem(33, Webs);

                     ItemStack Pearls = new ItemStack(Material.ENDER_PEARL, 16);
                     i.setItem(4, Pearls);
                     i.setItem(13, Pearls);
                     i.setItem(22, Pearls);
                     i.setItem(31, Pearls);

                     ItemStack TNT = new ItemStack(Material.TNT, 64);
                     i.setItem(5, TNT);
                     i.setItem(14, TNT);
                     i.setItem(23, TNT);
                     i.setItem(32, TNT);

                     ItemStack Arrows = new ItemStack(Material.ARROW, 64);
                     i.setItem(16, Arrows);
                     i.setItem(17, Arrows);
                     i.setItem(25, Arrows);
                     i.setItem(26, Arrows);
                     i.setItem(34, Arrows);
                     i.setItem(35, Arrows);

                     i.setItem(8, BuildingBlocks.Blocks());
                     i.getItem(8).setAmount(32);


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
                     SwordMeta.setLore(SwordLore);
                     if(!(p.getDisplayName().endsWith("s"))) {
                         SwordMeta.setDisplayName("§c§k§oaa §4§l" + p.getDisplayName() + "`s §7§lheiliges §6§lSäbel §c§k§oaa");
                     }
                     else{
                         SwordMeta.setDisplayName("§c§k§oaa §4§l" + p.getDisplayName() + "` §7§lheiliges §6§lSäbel §c§k§oaa");
                     }
                     Sword.setItemMeta(SwordMeta);
                     i.setItem(0, Sword);

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
                     RodMeta.setLore(RodLore);
                     if(!(p.getDisplayName().endsWith("s"))) {
                         RodMeta.setDisplayName("§c§k§oaa §4§l" + p.getDisplayName() + "`s §7§lheilige §6§lRod §c§k§oaa");
                     }
                     else{
                         RodMeta.setDisplayName("§c§k§oaa §4§l" + p.getDisplayName() + "` §7§lheilige §6§lRod §c§k§oaa");
                     }
                     Rod.setItemMeta(RodMeta);
                     i.setItem(1, Rod);

                     ItemStack Pick = new ItemStack(Material.WOODEN_PICKAXE);
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
                     RodLore.add("");
                     PickMeta.setLore(PickLore);
                     if(!(p.getDisplayName().endsWith("s"))) {
                         PickMeta.setDisplayName("§c§k§oaa §4§l" + p.getDisplayName() + "`s §7§lheilige §6§lSandsteinpicke §c§k§oaa");
                     }
                     else{
                         PickMeta.setDisplayName("§c§k§oaa §4§l" + p.getDisplayName() + "` §7§lheilige §6§lSandsteinpicke §c§k§oaa");
                     }
                     Pick.setItemMeta(PickMeta);
                     i.setItem(7, Pick);

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
                     bowmeta.setLore(BowLore);
                     if(!(p.getDisplayName().endsWith("s"))) {
                         bowmeta.setDisplayName("§c§k§oaa §4§l" + p.getDisplayName() + "`s §7§lheiliger §6§lBospammer §c§k§oaa");
                     }
                     else{
                         bowmeta.setDisplayName("§c§k§oaa §4§l" + p.getDisplayName() + "` §7§lheiliger §6§lBospammer §c§k§oaa");
                     }
                     Bow.setItemMeta(bowmeta);
                     i.setItem(2, Bow);

                     p.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(24);
                     p.closeInventory();
                     p.sendActionBar("§7Du bist nun ein §6Westernwars§7-Kämpfer!");

                     ItemStack Helmet = new ItemStack(Material.DIAMOND_HELMET);
                     ItemMeta meta1 = Helmet.getItemMeta();
                     meta1.addEnchant(Enchantment.MENDING,1 ,true);
                     meta1.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                     meta1.addEnchant(Enchantment.DURABILITY, 3, true);
                     if(!(p.getDisplayName().endsWith("s"))) {
                         meta1.setDisplayName("§c§k§oaa §4§l" + p.getDisplayName() + "`s §7§lheiliger §6§lHelm §c§k§oaa");
                     }
                     else{
                         meta1.setDisplayName("§c§k§oaa §4§l" + p.getDisplayName() + "` §7§lheiliger §6§lHelm §c§k§oaa");
                     }
                     Helmet.setItemMeta(meta1);

                     ItemStack Armor = new ItemStack(Material.DIAMOND_CHESTPLATE);
                     ItemMeta meta2 = Armor.getItemMeta();
                     meta2.addEnchant(Enchantment.MENDING,1 ,true);
                     meta2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                     meta2.addEnchant(Enchantment.DURABILITY, 3, true);
                     if(!(p.getDisplayName().endsWith("s"))) {
                         meta2.setDisplayName("§c§k§oaa §4§l" + p.getDisplayName() + "`s §7§lheilige §6§lBrustplatte §c§k§oaa");
                     }
                     else{
                         meta2.setDisplayName("§c§k§oaa §4§l" + p.getDisplayName() + "` §7§lheilige §6§lBrustplatte §c§k§oaa");
                     }
                     Armor.setItemMeta(meta2);

                     ItemStack Leggins = new ItemStack(Material.DIAMOND_LEGGINGS);
                     ItemMeta meta3 = Leggins.getItemMeta();
                     meta3.addEnchant(Enchantment.MENDING,1 ,true);
                     meta3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                     meta3.addEnchant(Enchantment.DURABILITY, 3, true);
                     if(!(p.getDisplayName().endsWith("s"))) {
                         meta3.setDisplayName("§c§k§oaa §4§l" + p.getDisplayName() + "`s §7§lheiliger §6§lBeinschutz §c§k§oaa");
                     }
                     else{
                         meta3.setDisplayName("§c§k§oaa §4§l" + p.getDisplayName() + "` §7§lheiliger §6§lBeinschutz §c§k§oaa");
                     }
                     Leggins.setItemMeta(meta3);

                     ItemStack Boots = new ItemStack(Material.DIAMOND_BOOTS);
                     ItemMeta meta4 = Boots.getItemMeta();
                     meta4.addEnchant(Enchantment.MENDING,1 ,true);
                     meta4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                     meta4.addEnchant(Enchantment.DURABILITY, 3, true);
                     meta4.addEnchant(Enchantment.DEPTH_STRIDER, 3, false);
                     if(!(p.getDisplayName().endsWith("s"))) {
                         meta4.setDisplayName("§c§k§oaa §4§l" + p.getDisplayName() + "`s §7§lheilige §6§lSchuhe §c§k§oaa");
                     }
                     else{
                         meta4.setDisplayName("§c§k§oaa §4§l" + p.getDisplayName() + "` §7§lheilige §6§lSchuhe §c§k§oaa");
                     }
                     Boots.setItemMeta(meta4);

                     i.setItem(39, Helmet);
                     i.setItem(38, Armor);
                     i.setItem(37, Leggins);
                     i.setItem(36, Boots);


                 }




            }

            e.setCancelled(true);
        }

        }

    }


