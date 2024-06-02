package plugin.utils.itembuilder;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;

import java.util.ArrayList;

public class UnsortableItems {



    public static ItemStack loadableXP(){
        NamespacedKey key = new NamespacedKey(Main.getInstance(), "amount");

        ItemStack stack = new ItemStack(Material.EXPERIENCE_BOTTLE);
        ItemMeta meta = stack.getItemMeta();
        meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, 32);
        meta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "loadable"), PersistentDataType.BOOLEAN, true);
        meta.displayName(MiniMessage.miniMessage().deserialize("<bold><i:false><#f59542>Aufladbare XP-Flasche</bold> <dark_gray><<yellow>" + meta.getPersistentDataContainer().get(key, PersistentDataType.INTEGER) + "/512<dark_gray>>"));

        stack.setItemMeta(meta);
        return stack;
    }

    public static ItemStack loveStick(){
        NamespacedKey key = new NamespacedKey(Main.getInstance(), "love");

        ItemStack stack = new ItemStack(Material.BLUE_ORCHID, 1);
        ItemMeta meta = stack.getItemMeta();

        meta.displayName(MiniMessage.miniMessage().deserialize("<i:false><gradient:#EA21ED:#DA1B54>Liebesblume ❤"));
        meta.addEnchant(Enchantment.KNOCKBACK, 5 , true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<Component> lore = new ArrayList<>();
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Signiert von: "));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><gradient:#EA21ED:#DA1B54>ItsNetflix_</gradient> <white>& <gradient:#EA21ED:#DA1B54>?</gradient>"));
        lore.add(Component.text(""));
        lore.add(Component.text("§r§fNachricht an euch: §o§b§kaa §o§c❤ §b§kaa"));
        lore.add(Component.text("§7§o(2.5 Sekunden Cooldown)"));
        meta.lore(lore);
        meta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 0);
        stack.setItemMeta(meta);

        return stack;
    }
}
