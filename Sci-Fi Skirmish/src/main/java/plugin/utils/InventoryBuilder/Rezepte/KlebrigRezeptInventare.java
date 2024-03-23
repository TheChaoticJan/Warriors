package plugin.utils.InventoryBuilder.Rezepte;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;
import plugin.utils.InventoryBuilder.RecipeInventory;
import plugin.utils.ItemBuilder.Klebrig;
import plugin.utils.ItemBuilder.SpecialResources;

public class KlebrigRezeptInventare {

    public static Inventory Fragment(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){

        Inventory i = RecipeInventory.emptyInventory(p, e, a);
        i.setItem(11, new ItemStack(Material.SCUTE));
        i.setItem(12, new ItemStack(Material.SCUTE));
        i.setItem(13, new ItemStack(Material.SCUTE));
        i.setItem(20, new ItemStack(Material.SCUTE));
        i.setItem(21, new ItemStack(Material.COBWEB));
        i.setItem(22, new ItemStack(Material.SCUTE));
        i.setItem(29, new ItemStack(Material.SCUTE));
        i.setItem(30, new ItemStack(Material.SCUTE));
        i.setItem(31, new ItemStack(Material.SCUTE));
        i.setItem(24, SpecialResources.KlebrigFragment(1));
        return i;
    }

    public static Inventory Barren(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){

        Inventory i = RecipeInventory.emptyInventory(p, e, a);
        i.setItem(11, new ItemStack(SpecialResources.KlebrigFragment(1)));
        i.setItem(12, new ItemStack(SpecialResources.KlebrigFragment(1)));
        i.setItem(13, new ItemStack(SpecialResources.KlebrigFragment(1)));
        i.setItem(20, new ItemStack(SpecialResources.KlebrigFragment(1)));
        i.setItem(21, new ItemStack(Material.COBWEB));
        i.setItem(22, new ItemStack(SpecialResources.KlebrigFragment(1)));
        i.setItem(29, new ItemStack(SpecialResources.KlebrigFragment(1)));
        i.setItem(30, new ItemStack(SpecialResources.KlebrigFragment(1)));
        i.setItem(31, new ItemStack(SpecialResources.KlebrigFragment(1)));
        i.setItem(24, SpecialResources.KlebrigBarren(1));
        return i;
    }

    public static Inventory Angel(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i = RecipeInventory.emptyInventory(p, e, a);
        i.setItem(11, new ItemStack(Material.AIR));
        i.setItem(12, new ItemStack(Material.AIR));
        i.setItem(13, new ItemStack(Material.STICK));
        i.setItem(20, new ItemStack(Material.AIR));
        i.setItem(21, new ItemStack(Material.STICK));
        i.setItem(22, new ItemStack(SpecialResources.KlebrigBarren(1)));
        i.setItem(29, new ItemStack(Material.STICK));
        i.setItem(30, new ItemStack(Material.AIR));
        i.setItem(31, new ItemStack(SpecialResources.KlebrigBarren(1)));
        i.setItem(24, Klebrig.Angel());
        return i;
    }

    public static Inventory Schwert(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i = RecipeInventory.emptyInventory(p, e, a);
        i.setItem(11, new ItemStack(Material.AIR));
        i.setItem(12, new ItemStack(SpecialResources.KlebrigBarren(1)));
        i.setItem(13, new ItemStack(Material.AIR));
        i.setItem(20, new ItemStack(Material.AIR));
        i.setItem(21, new ItemStack(SpecialResources.KlebrigBarren(1)));
        i.setItem(22, new ItemStack(Material.AIR));
        i.setItem(29, new ItemStack(Material.AIR));
        i.setItem(30, new ItemStack(Material.STICK));
        i.setItem(31, new ItemStack(Material.AIR));
        i.setItem(24, Klebrig.Schwert());
        return i;
    }

    public static Inventory Bogen(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i = RecipeInventory.emptyInventory(p, e, a);
        i.setItem(11, new ItemStack(Material.AIR));
        i.setItem(12, new ItemStack(Material.STICK));
        i.setItem(13, new ItemStack(SpecialResources.KlebrigBarren(1)));
        i.setItem(20, new ItemStack(Material.STICK));
        i.setItem(21, new ItemStack(Material.AIR));
        i.setItem(22, new ItemStack(SpecialResources.KlebrigBarren(1)));
        i.setItem(29, new ItemStack(Material.AIR));
        i.setItem(30, new ItemStack(Material.STICK));
        i.setItem(31, new ItemStack(SpecialResources.KlebrigBarren(1)));
        i.setItem(24, Klebrig.Bogen());
        return i;
    }
}
