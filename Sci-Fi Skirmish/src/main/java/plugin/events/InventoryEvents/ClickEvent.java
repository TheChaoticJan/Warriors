package plugin.events.InventoryEvents;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import plugin.Main;
import plugin.utils.InventoryBuilder.SpecialItemInventories;
import plugin.utils.ItemBuilder.InventoryEssentials;
import plugin.utils.ItemBuilder.Western;

import java.util.Objects;

public class ClickEvent implements Listener {

    @EventHandler
    public void clickEvent(InventoryClickEvent e) {
        @NotNull Player p = (Player) e.getWhoClicked();

        if(e.getCurrentItem() == null){
            return;
        }

        if(e.getView().getTitle().endsWith("§f")){
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§cZurück")){
                p.openInventory(SpecialItemInventories.selection(p, "<gradient:#FF59F4:#BD51FF><b>Rezepte"));
            }
            e.setCancelled(true);
        }

        if(e.getView().title().equals(MiniMessage.miniMessage().deserialize("<rainbow><b>Specialitems"))){
            if(e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.WHITE_STAINED_GLASS_PANE)){
                e.setCancelled(true);
                return;
            }
            if(Objects.equals(e.getClickedInventory(), p.getInventory())){
                e.setCancelled(true);
            }else if(e.getCurrentItem().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "special"))){
                p.openInventory(SpecialItemInventories.showOff(p, e.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "special"), PersistentDataType.STRING), "<black><b>Wähle dein Item:"));
            }
        }
        if(e.getView().getTitle().equalsIgnoreCase("§0§lWähle dein Item:")){
            if(e.getCurrentItem() == null || e.getCurrentItem().getType().equals(Material.WHITE_STAINED_GLASS_PANE)){
                e.setCancelled(true);
                return;
            }else if(e.getCurrentItem().equals(InventoryEssentials.back())){
                p.openInventory(SpecialItemInventories.selection(p, "<rainbow><b>Specialitems"));
                e.setCancelled(true);
            }else{
                p.getInventory().addItem(e.getCurrentItem());
                e.setCancelled(true);
            }
        }

        if(e.getView().getTitle().contains("§8Inventar von ") || e.getView().getTitle().contains("§0Stats von")){
                e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase("          §6Westernwars §0Kit")) {
            if(e.getCurrentItem() == null){
                return;
            }
               if(e.getCurrentItem().getItemMeta().hasItemFlag(ItemFlag.HIDE_ENCHANTS)){

                 //WW-Kit1
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

                     i.setItem(8, InventoryEssentials.buildingBlocks());
                     Objects.requireNonNull(i.getItem(8)).setAmount(32);

                     i.setItem(0, Western.Schwert(p));
                     i.setItem(1, Western.Rod(p));
                     i.setItem(2, Western.Bogen(p));
                     i.setItem(7, Western.Picke(p));
                     i.setItem(39, Western.Helmet(p));
                     i.setItem(38, Western.Chestplate(p));
                     i.setItem(37, Western.Leggings(p));
                     i.setItem(36, Western.Boots(p));

                     Objects.requireNonNull(p.getAttribute(Attribute.GENERIC_ATTACK_SPEED)).setBaseValue(24);
                     p.closeInventory();
                     p.sendActionBar("§7Du bist nun ein §6Westernwars§7-Kämpfer!");

                 }

            }
            e.setCancelled(true);
        }

    }

}


