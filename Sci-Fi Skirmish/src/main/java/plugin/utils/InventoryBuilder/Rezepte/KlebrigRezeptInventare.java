package plugin.utils.InventoryBuilder.Rezepte;

import plugin.utils.ItemBuilder.Inventarteile;
import plugin.utils.ItemBuilder.KlebrigItems;
import plugin.utils.ItemBuilder.SpecialResources;
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
            i.setItem(i1 , Inventarteile.Glass());
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

        i.setItem(24, SpecialResources.KlebrigFragment());

        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Inventarteile.Glass());
        }
        i.setItem(23, Inventarteile.Glass());
        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Inventarteile.Glass());
        }
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, Inventarteile.Glass());
        }
        i.setItem(44, Inventarteile.Zurück());
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
            i.setItem(i1 , Inventarteile.Glass());
        }

        i.setItem(11, new ItemStack(SpecialResources.KlebrigFragment()));
        i.setItem(12, new ItemStack(SpecialResources.KlebrigFragment()));
        i.setItem(13, new ItemStack(SpecialResources.KlebrigFragment()));
        i.setItem(20, new ItemStack(SpecialResources.KlebrigFragment()));
        i.setItem(21, new ItemStack(Material.COBWEB));
        i.setItem(22, new ItemStack(SpecialResources.KlebrigFragment()));
        i.setItem(29, new ItemStack(SpecialResources.KlebrigFragment()));
        i.setItem(30, new ItemStack(SpecialResources.KlebrigFragment()));
        i.setItem(31, new ItemStack(SpecialResources.KlebrigFragment()));

        i.setItem(24, SpecialResources.KlebrigBarren());

        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Inventarteile.Glass());
        }
        i.setItem(23, Inventarteile.Glass());
        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Inventarteile.Glass());
        }
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, Inventarteile.Glass());
        }
        i.setItem(44, Inventarteile.Zurück());
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
            i.setItem(i1 , Inventarteile.Glass());
        }

        i.setItem(11, new ItemStack(Material.AIR));
        i.setItem(12, new ItemStack(Material.AIR));
        i.setItem(13, new ItemStack(Material.STICK));
        i.setItem(20, new ItemStack(Material.AIR));
        i.setItem(21, new ItemStack(Material.STICK));
        i.setItem(22, new ItemStack(SpecialResources.KlebrigBarren()));
        i.setItem(29, new ItemStack(Material.STICK));
        i.setItem(30, new ItemStack(Material.AIR));
        i.setItem(31, new ItemStack(SpecialResources.KlebrigBarren()));

        i.setItem(24, KlebrigItems.Angel());

        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Inventarteile.Glass());
        }
        i.setItem(23, Inventarteile.Glass());
        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Inventarteile.Glass());
        }
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, Inventarteile.Glass());
        }
        i.setItem(44, Inventarteile.Zurück());
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
            i.setItem(i1 , Inventarteile.Glass());
        }
        i.setItem(11, new ItemStack(Material.AIR));
        i.setItem(12, new ItemStack(SpecialResources.KlebrigBarren()));
        i.setItem(13, new ItemStack(Material.AIR));
        i.setItem(20, new ItemStack(Material.AIR));
        i.setItem(21, new ItemStack(SpecialResources.KlebrigBarren()));
        i.setItem(22, new ItemStack(Material.AIR));
        i.setItem(29, new ItemStack(Material.AIR));
        i.setItem(30, new ItemStack(Material.STICK));
        i.setItem(31, new ItemStack(Material.AIR));

        i.setItem(24, KlebrigItems.Schwert());

        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Inventarteile.Glass());
        }
        i.setItem(23, Inventarteile.Glass());
        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Inventarteile.Glass());
        }
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, Inventarteile.Glass());
        }
        i.setItem(44, Inventarteile.Zurück());
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
            i.setItem(i1 , Inventarteile.Glass());
        }

        i.setItem(11, new ItemStack(Material.AIR));
        i.setItem(12, new ItemStack(Material.STICK));
        i.setItem(13, new ItemStack(SpecialResources.KlebrigBarren()));
        i.setItem(20, new ItemStack(Material.STICK));
        i.setItem(21, new ItemStack(Material.AIR));
        i.setItem(22, new ItemStack(SpecialResources.KlebrigBarren()));
        i.setItem(29, new ItemStack(Material.AIR));
        i.setItem(30, new ItemStack(Material.STICK));
        i.setItem(31, new ItemStack(SpecialResources.KlebrigBarren()));

        i.setItem(24, KlebrigItems.Bogen());

        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Inventarteile.Glass());
        }
        i.setItem(23, Inventarteile.Glass());
        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Inventarteile.Glass());
        }
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, Inventarteile.Glass());
        }
        i.setItem(44, Inventarteile.Zurück());
        return i;
    }
}
