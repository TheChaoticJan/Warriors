package plugin.events.InventoryEvents;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import plugin.utils.InventoryBuilder.SpecialItemInventory;
import plugin.utils.ItemBuilder.Inventarteile;
import plugin.utils.ItemBuilder.WesternItems;

public class ClickEvent implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent e) {
        @NotNull Player p = (Player) e.getWhoClicked();

        if(e.getCurrentItem() == null){
            return;
        }

        if(e.getView().getTitle().endsWith("§f")){
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cZurück")){
                p.openInventory(SpecialItemInventory.inventory(p, "§x§F§F§5§9§F§4R§x§F§4§5§8§F§6e§x§E§9§5§6§F§8z§x§D§E§5§5§F§Ae§x§D§3§5§4§F§Bp§x§C§8§5§2§F§Dt§x§B§D§5§1§F§Fe"));
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

                     i.setItem(8, Inventarteile.Baublöcke());
                     i.getItem(8).setAmount(32);

                     i.setItem(0, WesternItems.Schwert(p));
                     i.setItem(1, WesternItems.Rod(p));
                     i.setItem(2, WesternItems.Bogen(p));
                     i.setItem(7, WesternItems.Picke(p));
                     i.setItem(39, WesternItems.Helmet(p));
                     i.setItem(38, WesternItems.Chestplate(p));
                     i.setItem(37, WesternItems.Leggings(p));
                     i.setItem(36, WesternItems.Boots(p));

                     p.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(24);
                     p.closeInventory();
                     p.sendActionBar("§7Du bist nun ein §6Westernwars§7-Kämpfer!");

                 }

            }

            e.setCancelled(true);
        }

        }

    }


