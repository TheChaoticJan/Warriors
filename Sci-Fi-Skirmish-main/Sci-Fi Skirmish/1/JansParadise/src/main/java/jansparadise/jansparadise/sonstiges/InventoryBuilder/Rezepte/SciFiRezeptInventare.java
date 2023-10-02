package jansparadise.jansparadise.sonstiges.InventoryBuilder.Rezepte;

import jansparadise.jansparadise.sonstiges.ItemBuilder.InventoryEssentials.Inventarteile;
import jansparadise.jansparadise.sonstiges.ItemBuilder.InventoryEssentials.ZurückButton;
import jansparadise.jansparadise.sonstiges.ItemBuilder.SciFiItems;
import jansparadise.jansparadise.sonstiges.ItemBuilder.SpecialResources;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class SciFiRezeptInventare {

    public static Inventory Zauberstab(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i = null;
        if(e != null) {
            i = Bukkit.createInventory(p, 45, e.getCurrentItem().getItemMeta().getDisplayName() + "§f");
        }else{
            i = Bukkit.createInventory(p,45, a.getItemMeta().getDisplayName() + "§f");
        }
        for(int i1 = 0; i1 <= 10; i1++){
            i.setItem(i1 , Inventarteile.Glas());
        }

        i.setItem(12, SpecialResources.SciFiBarren());
        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Inventarteile.Glas());
        }
        i.setItem(21, SpecialResources.SciFiBarren());
        i.setItem(23, Inventarteile.Glas());
        i.setItem(24, SciFiItems.Zauberstab());
        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Inventarteile.Glas());
        }
        i.setItem(30, SpecialResources.SciFiBarren());
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, Inventarteile.Glas());
        }
        i.setItem(44, ZurückButton.Zurück());
        return i;
    }

    public static Inventory Schwert(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i = null;
        if(e != null) {
            i = Bukkit.createInventory(p, 45, e.getCurrentItem().getItemMeta().getDisplayName() + "§f");
        }else{
            i = Bukkit.createInventory(p,45, a.getItemMeta().getDisplayName() + "§f");
        }
        for(int i1 = 0; i1 <= 10; i1++){
            i.setItem(i1 , Inventarteile.Glas());
        }
        i.setItem(12, SpecialResources.SciFiBarren());
        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Inventarteile.Glas());
        }
        i.setItem(21, SpecialResources.SciFiBarren());
        i.setItem(23, Inventarteile.Glas());
        i.setItem(24, SciFiItems.Schwert());
        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Inventarteile.Glas());
        }
        i.setItem(30, new ItemStack(Material.STICK));
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, Inventarteile.Glas());
        }
        i.setItem(44, ZurückButton.Zurück());
        return i;
    }

    public static Inventory Bogen(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i = null;
        if(e != null) {
            i = Bukkit.createInventory(p, 45, e.getCurrentItem().getItemMeta().getDisplayName() + "§f");
        }else{
            i = Bukkit.createInventory(p,45, a.getItemMeta().getDisplayName() + "§f");
        }
        for(int i1 = 0; i1 <= 10; i1++){
            i.setItem(i1 , Inventarteile.Glas());
        }
        i.setItem(12, new ItemStack(Material.STICK));
        i.setItem(13, SpecialResources.SciFiBarren());
        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Inventarteile.Glas());
        }
        i.setItem(20, new ItemStack(Material.STICK));
        i.setItem(22, SpecialResources.SciFiBarren());

        i.setItem(23, Inventarteile.Glas());
        i.setItem(24, SciFiItems.Bogen());

        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Inventarteile.Glas());
        }
        i.setItem(30, new ItemStack(Material.STICK));
        i.setItem(31, SpecialResources.SciFiBarren());
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, Inventarteile.Glas());
        }
        i.setItem(44, ZurückButton.Zurück());
        return i;
    }

    public static Inventory Axt(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i = null;
        if(e != null) {
            i = Bukkit.createInventory(p, 45, e.getCurrentItem().getItemMeta().getDisplayName() + "§f");
        }else{
            i = Bukkit.createInventory(p,45, a.getItemMeta().getDisplayName() + "§f");
        }
        for(int i1 = 0; i1 <= 10; i1++){
            i.setItem(i1 , Inventarteile.Glas());
        }
        i.setItem(12, SpecialResources.SciFiBarren());
        i.setItem(13, SpecialResources.SciFiBarren());
        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Inventarteile.Glas());
        }
        i.setItem(21, new ItemStack(Material.STICK));
        i.setItem(22, SpecialResources.SciFiBarren());
        i.setItem(23, Inventarteile.Glas());
        i.setItem(24, SciFiItems.Axt());
        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Inventarteile.Glas());
        }
        i.setItem(30, new ItemStack(Material.STICK));
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, Inventarteile.Glas());
        }
        i.setItem(44, ZurückButton.Zurück());
        return i;
    }

    public static Inventory Barren(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i = null;
        if(e != null) {
            i = Bukkit.createInventory(p, 45, e.getCurrentItem().getItemMeta().getDisplayName() + "§f");
        }else{
            i = Bukkit.createInventory(p,45, a.getItemMeta().getDisplayName() + "§f");
        }
        for(int i1 = 0; i1 <= 10; i1++){
            i.setItem(i1 , Inventarteile.Glas());
        }
        i.setItem(11, SpecialResources.SciFiFragment());
        i.setItem(12, SpecialResources.SciFiFragment());
        i.setItem(13, SpecialResources.SciFiFragment());
        i.setItem(20, SpecialResources.SciFiFragment());
        i.setItem(21, new ItemStack(Material.ENDER_PEARL));
        i.setItem(22, SpecialResources.SciFiFragment());
        i.setItem(29, SpecialResources.SciFiFragment());
        i.setItem(30, SpecialResources.SciFiFragment());
        i.setItem(31, SpecialResources.SciFiFragment());

        i.setItem(24, SpecialResources.SciFiBarren());

        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Inventarteile.Glas());
        }
        i.setItem(23, Inventarteile.Glas());
        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Inventarteile.Glas());
        }
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, Inventarteile.Glas());
        }
        i.setItem(44, ZurückButton.Zurück());
        return i;
    }

    public static Inventory Fragment(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i = null;
        if(e != null) {
            i = Bukkit.createInventory(p, 45, e.getCurrentItem().getItemMeta().getDisplayName() + "§f");
        }else{
            i = Bukkit.createInventory(p,45, a.getItemMeta().getDisplayName() + "§f");
        }
        for(int i1 = 0; i1 <= 10; i1++){
            i.setItem(i1 , Inventarteile.Glas());
        }
        i.setItem(11, new ItemStack(Material.AMETHYST_SHARD));
        i.setItem(12, new ItemStack(Material.AMETHYST_SHARD));
        i.setItem(13, new ItemStack(Material.AMETHYST_SHARD));
        i.setItem(20, new ItemStack(Material.AMETHYST_SHARD));
        i.setItem(21, new ItemStack(Material.ENDER_PEARL));
        i.setItem(22, new ItemStack(Material.AMETHYST_SHARD));
        i.setItem(29, new ItemStack(Material.AMETHYST_SHARD));
        i.setItem(30, new ItemStack(Material.AMETHYST_SHARD));
        i.setItem(31, new ItemStack(Material.AMETHYST_SHARD));

        i.setItem(24, SpecialResources.SciFiFragment());

        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Inventarteile.Glas());
        }
        i.setItem(23, Inventarteile.Glas());
        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Inventarteile.Glas());
        }
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, Inventarteile.Glas());
        }
        i.setItem(44, ZurückButton.Zurück());
        return i;
    }
}
