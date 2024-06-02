package plugin.utils.inventorybuilder.Rezepte;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;
import plugin.utils.inventorybuilder.RecipeInventory;
import plugin.utils.itembuilder.Explosiv;
import plugin.utils.itembuilder.SpecialResources;

public class ExplosivRezeptInventare {

    public static Inventory Fragment(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i = RecipeInventory.emptyInventory(p, e, a);
        i.setItem(11, new ItemStack(Material.GUNPOWDER));
        i.setItem(12, new ItemStack(Material.GUNPOWDER));
        i.setItem(13, new ItemStack(Material.GUNPOWDER));
        i.setItem(20, new ItemStack(Material.GUNPOWDER));
        i.setItem(21, new ItemStack(Material.TNT));
        i.setItem(22, new ItemStack(Material.GUNPOWDER));
        i.setItem(29, new ItemStack(Material.GUNPOWDER));
        i.setItem(30, new ItemStack(Material.GUNPOWDER));
        i.setItem(31, new ItemStack(Material.GUNPOWDER));

        i.setItem(24, SpecialResources.ExplosivPuder(1));
        return i;
    }

    public static Inventory Barren(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i = RecipeInventory.emptyInventory(p, e, a);
        i.setItem(11, new ItemStack(SpecialResources.ExplosivPuder(1)));
        i.setItem(12, new ItemStack(SpecialResources.ExplosivPuder(1)));
        i.setItem(13, new ItemStack(SpecialResources.ExplosivPuder(1)));
        i.setItem(20, new ItemStack(SpecialResources.ExplosivPuder(1)));
        i.setItem(21, new ItemStack(Material.TNT));
        i.setItem(22, new ItemStack(SpecialResources.ExplosivPuder(1)));
        i.setItem(29, new ItemStack(SpecialResources.ExplosivPuder(1)));
        i.setItem(30, new ItemStack(SpecialResources.ExplosivPuder(1)));
        i.setItem(31, new ItemStack(SpecialResources.ExplosivPuder(1)));
        i.setItem(24, SpecialResources.ExplosivBarren(1));
        return i;
    }

    public static Inventory Angel(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i = RecipeInventory.emptyInventory(p, e, a);

        i.setItem(11, new ItemStack(Material.AIR));
        i.setItem(12, new ItemStack(Material.AIR));
        i.setItem(13, new ItemStack(Material.STICK));
        i.setItem(20, new ItemStack(Material.AIR));
        i.setItem(21, new ItemStack(Material.STICK));
        i.setItem(22, new ItemStack(SpecialResources.ErfahrenBarren(1)));
        i.setItem(29, new ItemStack(Material.STICK));
        i.setItem(30, new ItemStack(Material.AIR));
        i.setItem(31, new ItemStack(SpecialResources.ErfahrenBarren(11)));
        i.setItem(24, Explosiv.Angel());
        return i;
    }

    public static Inventory Picke(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i = RecipeInventory.emptyInventory(p, e, a);
        i.setItem(11, new ItemStack(SpecialResources.ExplosivBarren(1)));
        i.setItem(12, new ItemStack(SpecialResources.ExplosivBarren(1)));
        i.setItem(13, new ItemStack(SpecialResources.ExplosivBarren(1)));
        i.setItem(20, new ItemStack(Material.AIR));
        i.setItem(21, new ItemStack(Material.STICK));
        i.setItem(22, new ItemStack(Material.AIR));
        i.setItem(29, new ItemStack(Material.AIR));
        i.setItem(30, new ItemStack(Material.STICK));
        i.setItem(31, new ItemStack(Material.AIR));
        i.setItem(24, Explosiv.Spitzhacke());
        return i;
    }
}
