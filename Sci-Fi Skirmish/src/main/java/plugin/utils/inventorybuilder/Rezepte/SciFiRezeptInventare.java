package plugin.utils.inventorybuilder.Rezepte;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;
import plugin.utils.inventorybuilder.RecipeInventory;
import plugin.utils.itembuilder.Candles;
import plugin.utils.itembuilder.SciFiItems;
import plugin.utils.itembuilder.SpecialResources;

public class SciFiRezeptInventare {

    public static Inventory Zauberstab(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i = RecipeInventory.emptyInventory(p, e, a);
        i.setItem(12, SpecialResources.SciFiBarren(1));
        i.setItem(21, SpecialResources.SciFiBarren(1));
        i.setItem(24, Candles.crateCandle());
        i.setItem(30, SpecialResources.SciFiBarren(1));
        return i;
    }

    public static Inventory Schwert(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){

        Inventory i = RecipeInventory.emptyInventory(p, e, a);
        i.setItem(12, SpecialResources.SciFiBarren(1));
        i.setItem(21, SpecialResources.SciFiBarren(1));
        i.setItem(24, SciFiItems.Schwert());
        i.setItem(30, new ItemStack(Material.STICK));
        return i;
    }

    public static Inventory Bogen(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){

        Inventory i = RecipeInventory.emptyInventory(p, e, a);
        i.setItem(12, new ItemStack(Material.STICK));
        i.setItem(13, SpecialResources.SciFiBarren(1));
        i.setItem(20, new ItemStack(Material.STICK));
        i.setItem(22, SpecialResources.SciFiBarren(1));
        i.setItem(24, SciFiItems.Bogen());
        i.setItem(30, new ItemStack(Material.STICK));
        i.setItem(31, SpecialResources.SciFiBarren(1));
        return i;
    }

    public static Inventory Axt(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i = RecipeInventory.emptyInventory(p, e, a);
        i.setItem(12, SpecialResources.SciFiBarren(1));
        i.setItem(13, SpecialResources.SciFiBarren(1));
        i.setItem(21, new ItemStack(Material.STICK));
        i.setItem(22, SpecialResources.SciFiBarren(1));
        i.setItem(24, SciFiItems.Axt());
        i.setItem(30, new ItemStack(Material.STICK));
        return i;
    }

    public static Inventory Barren(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i = RecipeInventory.emptyInventory(p, e, a);

        i.setItem(11, SpecialResources.SciFiFragment(1));
        i.setItem(12, SpecialResources.SciFiFragment(1));
        i.setItem(13, SpecialResources.SciFiFragment(1));
        i.setItem(20, SpecialResources.SciFiFragment(1));
        i.setItem(21, new ItemStack(Material.ENDER_PEARL));
        i.setItem(22, SpecialResources.SciFiFragment(1));
        i.setItem(29, SpecialResources.SciFiFragment(1));
        i.setItem(30, SpecialResources.SciFiFragment(1));
        i.setItem(31, SpecialResources.SciFiFragment(1));
        i.setItem(24, SpecialResources.SciFiBarren(1));
        return i;
    }

    public static Inventory Fragment(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){

        Inventory i = RecipeInventory.emptyInventory(p, e, a);
        i.setItem(11, new ItemStack(Material.AMETHYST_SHARD));
        i.setItem(12, new ItemStack(Material.AMETHYST_SHARD));
        i.setItem(13, new ItemStack(Material.AMETHYST_SHARD));
        i.setItem(20, new ItemStack(Material.AMETHYST_SHARD));
        i.setItem(21, new ItemStack(Material.ENDER_PEARL));
        i.setItem(22, new ItemStack(Material.AMETHYST_SHARD));
        i.setItem(29, new ItemStack(Material.AMETHYST_SHARD));
        i.setItem(30, new ItemStack(Material.AMETHYST_SHARD));
        i.setItem(31, new ItemStack(Material.AMETHYST_SHARD));
        i.setItem(24, SpecialResources.SciFiFragment(1));
        return i;
    }
}
