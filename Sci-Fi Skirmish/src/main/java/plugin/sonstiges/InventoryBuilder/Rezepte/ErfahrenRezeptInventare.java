package plugin.sonstiges.InventoryBuilder.Rezepte;

import plugin.sonstiges.ItemBuilder.ErfahrenItems;
import plugin.sonstiges.ItemBuilder.Inventarteile;
import plugin.sonstiges.ItemBuilder.SpecialResources;
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
            i.setItem(i1 , Inventarteile.Glass());
        }
        i.setItem(12, SpecialResources.ErfahrenBarren());
        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Inventarteile.Glass());
        }
        i.setItem(21, SpecialResources.ErfahrenBarren());
        i.setItem(23, Inventarteile.Glass());
        i.setItem(24, ErfahrenItems.Schwert());

        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Inventarteile.Glass());
        }
        i.setItem(30, new ItemStack(Material.STICK));
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
        i.setItem(12, new ItemStack(Material.STICK));
        i.setItem(13, SpecialResources.ErfahrenBarren());

        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Inventarteile.Glass());
        }
        i.setItem(20, new ItemStack(Material.STICK));
        i.setItem(22, SpecialResources.ErfahrenBarren());

        i.setItem(23, Inventarteile.Glass());

        i.setItem(24, ErfahrenItems.Bogen());

        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Inventarteile.Glass());
        }
        i.setItem(30, new ItemStack(Material.STICK));
        i.setItem(31, SpecialResources.ErfahrenBarren());
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, Inventarteile.Glass());
        }
        i.setItem(44, Inventarteile.Zurück());
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
            i.setItem(i1 , Inventarteile.Glass());
        }
        i.setItem(12, SpecialResources.ErfahrenBarren());
        i.setItem(13, SpecialResources.ErfahrenBarren());

        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Inventarteile.Glass());
        }
        i.setItem(21, new ItemStack(Material.STICK));
        i.setItem(22, SpecialResources.ErfahrenBarren());
        i.setItem(23, Inventarteile.Glass());
        i.setItem(24, ErfahrenItems.Axt());

        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Inventarteile.Glass());
        }
        i.setItem(30, new ItemStack(Material.STICK));
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, Inventarteile.Glass());
        }
        i.setItem(44, Inventarteile.Zurück());
        return i;
    }

    public static Inventory Zauberstab(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){

        Inventory i = null;
        if(e != null) {
            i = Bukkit.createInventory(p, 45, e.getCurrentItem().getItemMeta().getDisplayName() + "§f");
        }else{
            i = Bukkit.createInventory(p,45, a.getItemMeta().getDisplayName() + "§f");
        }
        for(int i1 = 0; i1 <= 10; i1++){
            i.setItem(i1 , Inventarteile.Glass());
        }
        i.setItem(12, SpecialResources.ErfahrenBarren());
        i.setItem(21, SpecialResources.ErfahrenBarren());
        i.setItem(30, SpecialResources.ErfahrenBarren());

        i.setItem(24, ErfahrenItems.Zauberstab());

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
        i.setItem(11, SpecialResources.ErfahrenFragment());
        i.setItem(12, SpecialResources.ErfahrenFragment());
        i.setItem(13, SpecialResources.ErfahrenFragment());
        i.setItem(20, SpecialResources.ErfahrenFragment());
        i.setItem(21, new ItemStack(Material.EXPERIENCE_BOTTLE));
        i.setItem(22, SpecialResources.ErfahrenFragment());
        i.setItem(29, SpecialResources.ErfahrenFragment());
        i.setItem(30, SpecialResources.ErfahrenFragment());
        i.setItem(31, SpecialResources.ErfahrenFragment());

        i.setItem(24, SpecialResources.ErfahrenBarren());

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

    public static Inventory Fragment(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i = null;
        if(e != null) {
             i = Bukkit.createInventory(p, 45, e.getCurrentItem().getItemMeta().getDisplayName() + "§f");
        }else{
             i = Bukkit.createInventory(p,45, a.getItemMeta().getDisplayName() + "§f");
        }
        for( int i1 = 0; i1 <= 10; i1++){
            i.setItem(i1, Inventarteile.Glass());
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

        i.setItem(24, SpecialResources.ErfahrenFragment());

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
