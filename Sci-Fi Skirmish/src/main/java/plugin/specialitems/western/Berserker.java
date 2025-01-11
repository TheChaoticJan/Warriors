package plugin.specialitems.western;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;

import java.util.ArrayList;

public class Berserker {

    public static ItemStack Tracker(){
        ItemStack stack = new ItemStack(Material.COMPASS);
        CompassMeta meta = (CompassMeta) stack.getItemMeta();

        meta.displayName(MiniMessage.miniMessage().deserialize("<i:false><b><gradient:#6a3e0a:#9d2323:#e5e814>Tracker <dark_gray><b>▸ <red>Kein Ziel!"));
        meta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "tracker"), PersistentDataType.BYTE, (byte) 0);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        ArrayList<Component> lore = new ArrayList<>();
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><#9d2323>Berserker"));
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Nutzung: <i><gray>*Rechtsklick*"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Deutet dann auf den <red>nähesten <white>Spieler!"));
        meta.lore(lore);

        stack.setItemMeta(meta);
        return stack;
    }
}
