package plugin.utils.inventorybuilder;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;
import plugin.utils.itembuilder.InventoryEssentials;

import java.util.Objects;

public class RecipeInventory {

    public static Inventory emptyInventory(Player p, @Nullable InventoryClickEvent e, @Nullable ItemStack a){
        Inventory i;
        if(e != null) {
            i = Bukkit.createInventory(p, 45, Objects.requireNonNull(e.getCurrentItem()).getItemMeta().getDisplayName() + "§f");
        }else{
            assert a != null;
            i = Bukkit.createInventory(p,45, a.getItemMeta().getDisplayName() + "§f");
        }
        for(int i1 = 0; i1 <= 10; i1++){
            i.setItem(i1 , InventoryEssentials.glass());
        }
        for(int i2 = 14; i2 <= 19; i2++){
            i.setItem(i2, InventoryEssentials.glass());
        }
        i.setItem(23, InventoryEssentials.glass());
        for(int i3 = 25; i3 <= 28; i3++){
            i.setItem(i3, InventoryEssentials.glass());
        }
        for(int i4 = 32; i4 <= 43; i4++){
            i.setItem(i4, InventoryEssentials.glass());
        }
        i.setItem(44, InventoryEssentials.back());
        return i;
    }

}
