package plugin.utils.ItemBuilder;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;

public class LoadableItems {



    public static ItemStack loadableXP(){
        NamespacedKey key = new NamespacedKey(Main.getInstance(), "amount");

        ItemStack stack = new ItemStack(Material.EXPERIENCE_BOTTLE);
        ItemMeta meta = stack.getItemMeta();
        meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, 32);
        meta.displayName(MiniMessage.miniMessage().deserialize("<bold><i:false><#f59542>Aufladbare XP-Flasche</bold> <dark_gray><<yellow>" + meta.getPersistentDataContainer().get(key, PersistentDataType.INTEGER) + "/512<dark_gray>>"));

        stack.setItemMeta(meta);
        return stack;
    }
}
