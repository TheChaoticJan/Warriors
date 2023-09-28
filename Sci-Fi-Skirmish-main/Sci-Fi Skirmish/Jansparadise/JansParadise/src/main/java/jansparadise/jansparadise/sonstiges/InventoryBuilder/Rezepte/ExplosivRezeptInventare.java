package jansparadise.jansparadise.sonstiges.InventoryBuilder.Rezepte;

import jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials.ExplosivKelp;
import jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials.ExplosivPowder;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Explosiv.ExplosivAngel;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Explosiv.ExplosivPicke;
import jansparadise.jansparadise.sonstiges.ItemBuilder.InventoryEssentials.Füllerglas;
import jansparadise.jansparadise.sonstiges.ItemBuilder.InventoryEssentials.ZurückButton;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class ExplosivRezeptInventare {

    public static Inventory Fragment(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i = null;
        if(e != null) {
            i = Bukkit.createInventory(p, 45, e.getCurrentItem().getItemMeta().getDisplayName() + "§f");
        }else{
            i = Bukkit.createInventory(p,45, a.getItemMeta().getDisplayName() + "§f");
        }
        for(int i1 = 0; i1 <= 10; i1++){
            i.setItem(i1 ,Füllerglas.Glas());
        }

        i.setItem(11, new ItemStack(Material.GUNPOWDER));
        i.setItem(12, new ItemStack(Material.GUNPOWDER));
        i.setItem(13, new ItemStack(Material.GUNPOWDER));
        i.setItem(20, new ItemStack(Material.GUNPOWDER));
        i.setItem(21, new ItemStack(Material.TNT));
        i.setItem(22, new ItemStack(Material.GUNPOWDER));
        i.setItem(29, new ItemStack(Material.GUNPOWDER));
        i.setItem(30, new ItemStack(Material.GUNPOWDER));
        i.setItem(31, new ItemStack(Material.GUNPOWDER));

        i.setItem(24, ExplosivPowder.Powder());

        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Füllerglas.Glas());
        }
        i.setItem(23, Füllerglas.Glas());
        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Füllerglas.Glas());
        }
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, Füllerglas.Glas());
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
            i.setItem(i1 ,Füllerglas.Glas());
        }

        i.setItem(11, new ItemStack(ExplosivPowder.Powder()));
        i.setItem(12, new ItemStack(ExplosivPowder.Powder()));
        i.setItem(13, new ItemStack(ExplosivPowder.Powder()));
        i.setItem(20, new ItemStack(ExplosivPowder.Powder()));
        i.setItem(21, new ItemStack(Material.TNT));
        i.setItem(22, new ItemStack(ExplosivPowder.Powder()));
        i.setItem(29, new ItemStack(ExplosivPowder.Powder()));
        i.setItem(30, new ItemStack(ExplosivPowder.Powder()));
        i.setItem(31, new ItemStack(ExplosivPowder.Powder()));

        i.setItem(24, ExplosivKelp.DriedKelp());

        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Füllerglas.Glas());
        }
        i.setItem(23, Füllerglas.Glas());
        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Füllerglas.Glas());
        }
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, Füllerglas.Glas());
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
            i.setItem(i1 ,Füllerglas.Glas());
        }

        i.setItem(11, new ItemStack(Material.AIR));
        i.setItem(12, new ItemStack(Material.AIR));
        i.setItem(13, new ItemStack(Material.STICK));
        i.setItem(20, new ItemStack(Material.AIR));
        i.setItem(21, new ItemStack(Material.STICK));
        i.setItem(22, new ItemStack(ExplosivKelp.DriedKelp()));
        i.setItem(29, new ItemStack(Material.STICK));
        i.setItem(30, new ItemStack(Material.AIR));
        i.setItem(31, new ItemStack(ExplosivKelp.DriedKelp()));

        i.setItem(24, ExplosivAngel.ExplosivAngel());

        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Füllerglas.Glas());
        }
        i.setItem(23, Füllerglas.Glas());
        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Füllerglas.Glas());
        }
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, Füllerglas.Glas());
        }
        i.setItem(44, ZurückButton.Zurück());
        return i;
    }

    public static Inventory Picke(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i = null;
        if(e != null) {
            i = Bukkit.createInventory(p, 45, e.getCurrentItem().getItemMeta().getDisplayName() + "§f");
        }else{
            i = Bukkit.createInventory(p,45, a.getItemMeta().getDisplayName() + "§f");
        }
        for(int i1 = 0; i1 <= 10; i1++){
            i.setItem(i1 ,Füllerglas.Glas());
        }

        i.setItem(11, new ItemStack(ExplosivKelp.DriedKelp()));
        i.setItem(12, new ItemStack(ExplosivKelp.DriedKelp()));
        i.setItem(13, new ItemStack(ExplosivKelp.DriedKelp()));
        i.setItem(20, new ItemStack(Material.AIR));
        i.setItem(21, new ItemStack(Material.STICK));
        i.setItem(22, new ItemStack(Material.AIR));
        i.setItem(29, new ItemStack(Material.AIR));
        i.setItem(30, new ItemStack(Material.STICK));
        i.setItem(31, new ItemStack(Material.AIR));

        i.setItem(24, ExplosivPicke.ErfahrenBow());

        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, Füllerglas.Glas());
        }
        i.setItem(23, Füllerglas.Glas());
        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, Füllerglas.Glas());
        }
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, Füllerglas.Glas());
        }
        i.setItem(44, ZurückButton.Zurück());
        return i;
    }
}
