package plugin.utils.itembuilder;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryEssentials {

    public static ItemStack glass() {
        ItemStack glass = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta glassMeta = glass.getItemMeta();
        glassMeta.displayName(Component.empty());
        glass.setItemMeta(glassMeta);
        return glass;
    }

    public static ItemStack bars() {
        ItemStack glass = new ItemStack(Material.IRON_BARS);
        ItemMeta glassMeta = glass.getItemMeta();
        glassMeta.displayName(Component.empty());
        glass.setItemMeta(glassMeta);
        return glass;
    }

    public static ItemStack back() {
        ItemStack i = new ItemStack(Material.REDSTONE);
        ItemMeta d = i.getItemMeta();
        d.setDisplayName("§cZurück");
        i.setItemMeta(d);
        return i;
    }

    public static ItemStack confirm(){
        ItemStack stack = new ItemStack(Material.EMERALD_BLOCK);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName("§aBestätigen");
        stack.setItemMeta(meta);
        return stack;
    }
}
