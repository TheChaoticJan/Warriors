package plugin.utils.InventoryBuilder.Rezepte;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;
import plugin.utils.InventoryBuilder.RecipeInventory;
import plugin.utils.ItemBuilder.Candles;
import plugin.utils.ItemBuilder.SpecialResources;

public class CandleRecipeInventories {

    public static Inventory specialCandleRecipe(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){

        Inventory inventory = RecipeInventory.emptyInventory(p, e, a);
        inventory.setItem(11, Candles.boostCandle());
        inventory.setItem(12, SpecialResources.ErfahrenBarren(1));
        inventory.setItem(13, Candles.crateCandle());
        inventory.setItem(20, SpecialResources.KlebrigBarren(1));
        inventory.setItem(21, Candles.emptyCandle());
        inventory.setItem(22, SpecialResources.SciFiBarren(1));
        inventory.setItem(29, Candles.teleportCandle());
        inventory.setItem(30, SpecialResources.ExplosivBarren(1));
        inventory.setItem(31, Candles.boostCandle());

        return inventory;
    }
}
