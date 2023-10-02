package jansparadise.jansparadise.sonstiges.InventoryBuilder.Rezepte;

import jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials.Erfahrenbarren;
import jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials.Erfahrenfragment;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Erfahren.ErfahrenAxt;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Erfahren.ErfahrenBogen;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Erfahren.ErfahrenSchwert;
import jansparadise.jansparadise.sonstiges.ItemBuilder.InventoryEssentials.Fuellerglas;
import jansparadise.jansparadise.sonstiges.ItemBuilder.InventoryEssentials.ZurückButton;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class ErfahrenRezeptInventare {

    public static Inventory Schwert(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i = null;
        if(e != null) {
            i = Bukkit.createInventory(p, 45, e.getCurrentItem().getItemMeta().getDisplayName() + "§f");
        }else{
            i = Bukkit.createInventory(p,45, a.getItemMeta().getDisplayName() + "§f");
        }
        for(int i1 = 0; i1 <= 10; i1++){
            i.setItem(i1 , Fuellerglas.Glas());
        }
        i.setItem(12, Erfahrenbarren.ErfahrenBarren());
        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Fuellerglas.Glas());
        }
        i.setItem(21, Erfahrenbarren.ErfahrenBarren());
        i.setItem(23, Fuellerglas.Glas());
        i.setItem(24, ErfahrenSchwert.ErfahrenKatana());

        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Fuellerglas.Glas());
        }
        i.setItem(30, new ItemStack(Material.STICK));
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, Fuellerglas.Glas());
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
            i.setItem(i1 , Fuellerglas.Glas());
        }
        i.setItem(12, new ItemStack(Material.STICK));
        i.setItem(13, Erfahrenbarren.ErfahrenBarren());

        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Fuellerglas.Glas());
        }
        i.setItem(20, new ItemStack(Material.STICK));
        i.setItem(22, Erfahrenbarren.ErfahrenBarren());

        i.setItem(23, Fuellerglas.Glas());

        i.setItem(24, ErfahrenBogen.ErfahrenBow());

        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Fuellerglas.Glas());
        }
        i.setItem(30, new ItemStack(Material.STICK));
        i.setItem(31, Erfahrenbarren.ErfahrenBarren());
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, Fuellerglas.Glas());
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
            i.setItem(i1 , Fuellerglas.Glas());
        }
        i.setItem(12, Erfahrenbarren.ErfahrenBarren());
        i.setItem(13, Erfahrenbarren.ErfahrenBarren());

        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Fuellerglas.Glas());
        }
        i.setItem(21, new ItemStack(Material.STICK));
        i.setItem(22, Erfahrenbarren.ErfahrenBarren());
        i.setItem(23, Fuellerglas.Glas());
        i.setItem(24, ErfahrenAxt.ErfahrenBeil());

        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Fuellerglas.Glas());
        }
        i.setItem(30, new ItemStack(Material.STICK));
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, Fuellerglas.Glas());
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
            i.setItem(i1 , Fuellerglas.Glas());
        }
        i.setItem(11, Erfahrenfragment.SuperGold());
        i.setItem(12, Erfahrenfragment.SuperGold());
        i.setItem(13, Erfahrenfragment.SuperGold());
        i.setItem(20, Erfahrenfragment.SuperGold());
        i.setItem(21, new ItemStack(Material.EXPERIENCE_BOTTLE));
        i.setItem(22, Erfahrenfragment.SuperGold());
        i.setItem(29, Erfahrenfragment.SuperGold());
        i.setItem(30, Erfahrenfragment.SuperGold());
        i.setItem(31, Erfahrenfragment.SuperGold());

        i.setItem(24, Erfahrenbarren.ErfahrenBarren());

        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Fuellerglas.Glas());
        }
        i.setItem(23, Fuellerglas.Glas());
        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Fuellerglas.Glas());
        }
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, Fuellerglas.Glas());
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
        for( int i1 = 0; i1 <= 10; i1++){
            i.setItem(i1, Fuellerglas.Glas());
        }
        i.setItem(11, new ItemStack(Material.GOLD_NUGGET));
        i.setItem(12, new ItemStack(Material.GOLD_NUGGET));
        i.setItem(13, new ItemStack(Material.GOLD_NUGGET));
        i.setItem(20, new ItemStack(Material.GOLD_NUGGET));
        i.setItem(21, new ItemStack(Material.EXPERIENCE_BOTTLE));
        i.setItem(22, new ItemStack(Material.GOLD_NUGGET));
        i.setItem(29, new ItemStack(Material.GOLD_NUGGET));
        i.setItem(30, new ItemStack(Material.GOLD_NUGGET));
        i.setItem(31, new ItemStack(Material.GOLD_NUGGET));

        i.setItem(24, Erfahrenfragment.SuperGold());

        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Fuellerglas.Glas());
        }
        i.setItem(23, Fuellerglas.Glas());
        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Fuellerglas.Glas());
        }
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, Fuellerglas.Glas());
        }
        i.setItem(44, ZurückButton.Zurück());
        return i;
    }
}
