package plugin.utils.inventorybuilder.Rezepte;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;
import plugin.utils.inventorybuilder.RecipeInventory;
import plugin.utils.itembuilder.SpecialResources;
import plugin.utils.itembuilder.candles.*;

public class CandleRecipeInventories {

    public static Inventory specialCandleRecipe(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){

        Inventory inventory = RecipeInventory.emptyInventory(p, e, a);
        inventory.setItem(11, SpecialResources.ErfahrenBarren(1));
        inventory.setItem(12, RepairCandle.create());
        inventory.setItem(13, SpecialResources.ErfahrenBarren(1));
        inventory.setItem(20, SpecialResources.KlebrigBarren(1));
        inventory.setItem(21, TeleportCandle.create());
        inventory.setItem(22, SpecialResources.KlebrigBarren(1));
        inventory.setItem(29, SpecialResources.ExplosivBarren(1));
        inventory.setItem(30, JumpCandle.create());
        inventory.setItem(31, SpecialResources.ExplosivBarren(1));

        inventory.setItem(24, UltimateCandle.create());

        return inventory;
    }
}
