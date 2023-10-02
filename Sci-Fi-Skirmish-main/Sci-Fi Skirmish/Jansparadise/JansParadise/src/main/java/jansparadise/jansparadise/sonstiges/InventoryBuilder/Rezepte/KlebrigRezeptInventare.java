package jansparadise.jansparadise.sonstiges.InventoryBuilder.Rezepte;

import jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials.KlebrigSlime;
import jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials.KlebrigSuperSlime;
import jansparadise.jansparadise.sonstiges.ItemBuilder.InventoryEssentials.Fuellerglas;
import jansparadise.jansparadise.sonstiges.ItemBuilder.InventoryEssentials.ZurückButton;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Klebrig.KlebrigAngel;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Klebrig.KlebrigBogen;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Klebrig.KlebrigSchwert;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class KlebrigRezeptInventare {

    public static Inventory Fragment(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i = null;
        if(e != null) {
            i = Bukkit.createInventory(p, 45, e.getCurrentItem().getItemMeta().getDisplayName() + "§f");
        }else{
            i = Bukkit.createInventory(p,45, a.getItemMeta().getDisplayName() + "§f");
        }
        for(int i1 = 0; i1 <= 10; i1++){
            i.setItem(i1 , Fuellerglas.Glas());
        }

        i.setItem(11, new ItemStack(Material.SCUTE));
        i.setItem(12, new ItemStack(Material.SCUTE));
        i.setItem(13, new ItemStack(Material.SCUTE));
        i.setItem(20, new ItemStack(Material.SCUTE));
        i.setItem(21, new ItemStack(Material.COBWEB));
        i.setItem(22, new ItemStack(Material.SCUTE));
        i.setItem(29, new ItemStack(Material.SCUTE));
        i.setItem(30, new ItemStack(Material.SCUTE));
        i.setItem(31, new ItemStack(Material.SCUTE));

        i.setItem(24, KlebrigSlime.Slime());

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

        i.setItem(11, new ItemStack(KlebrigSlime.Slime()));
        i.setItem(12, new ItemStack(KlebrigSlime.Slime()));
        i.setItem(13, new ItemStack(KlebrigSlime.Slime()));
        i.setItem(20, new ItemStack(KlebrigSlime.Slime()));
        i.setItem(21, new ItemStack(Material.COBWEB));
        i.setItem(22, new ItemStack(KlebrigSlime.Slime()));
        i.setItem(29, new ItemStack(KlebrigSlime.Slime()));
        i.setItem(30, new ItemStack(KlebrigSlime.Slime()));
        i.setItem(31, new ItemStack(KlebrigSlime.Slime()));

        i.setItem(24, KlebrigSuperSlime.Emerald());

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

    public static Inventory Angel(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i = null;
        if(e != null) {
            i = Bukkit.createInventory(p, 45, e.getCurrentItem().getItemMeta().getDisplayName() + "§f");
        }else{
            i = Bukkit.createInventory(p,45, a.getItemMeta().getDisplayName() + "§f");
        }
        for(int i1 = 0; i1 <= 10; i1++){
            i.setItem(i1 , Fuellerglas.Glas());
        }

        i.setItem(11, new ItemStack(Material.AIR));
        i.setItem(12, new ItemStack(Material.AIR));
        i.setItem(13, new ItemStack(Material.STICK));
        i.setItem(20, new ItemStack(Material.AIR));
        i.setItem(21, new ItemStack(Material.STICK));
        i.setItem(22, new ItemStack(KlebrigSuperSlime.Emerald()));
        i.setItem(29, new ItemStack(Material.STICK));
        i.setItem(30, new ItemStack(Material.AIR));
        i.setItem(31, new ItemStack(KlebrigSuperSlime.Emerald()));

        i.setItem(24, KlebrigAngel.KlebrigAngel());

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
        i.setItem(11, new ItemStack(Material.AIR));
        i.setItem(12, new ItemStack(KlebrigSuperSlime.Emerald()));
        i.setItem(13, new ItemStack(Material.AIR));
        i.setItem(20, new ItemStack(Material.AIR));
        i.setItem(21, new ItemStack(KlebrigSuperSlime.Emerald()));
        i.setItem(22, new ItemStack(Material.AIR));
        i.setItem(29, new ItemStack(Material.AIR));
        i.setItem(30, new ItemStack(Material.STICK));
        i.setItem(31, new ItemStack(Material.AIR));

        i.setItem(24, KlebrigSchwert.KlebrigBogen());

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

        i.setItem(11, new ItemStack(Material.AIR));
        i.setItem(12, new ItemStack(Material.STICK));
        i.setItem(13, new ItemStack(KlebrigSuperSlime.Emerald()));
        i.setItem(20, new ItemStack(Material.STICK));
        i.setItem(21, new ItemStack(Material.AIR));
        i.setItem(22, new ItemStack(KlebrigSuperSlime.Emerald()));
        i.setItem(29, new ItemStack(Material.AIR));
        i.setItem(30, new ItemStack(Material.STICK));
        i.setItem(31, new ItemStack(KlebrigSuperSlime.Emerald()));

        i.setItem(24, KlebrigBogen.KlebrigBogen());

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
