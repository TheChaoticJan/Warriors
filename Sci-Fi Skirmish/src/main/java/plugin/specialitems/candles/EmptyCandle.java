package plugin.specialitems.candles;

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

public class EmptyCandle {
    private static final NamespacedKey key = new NamespacedKey(Main.getInstance(), "candle");
    public static ItemStack create(){
        ItemStack candle = new ItemStack(Material.GRAY_CANDLE);
        ItemMeta CandleMeta = candle.getItemMeta();
        Component component = MiniMessage.miniMessage().deserialize("<i:false><gray><obf>a</obf><dark_gray><obf>a</obf><bold> [<gray>Elementlos<dark_gray>] <gradient:dark_gray:gray>Wunderkerze</gradient></bold> <dark_gray><obf>a</obf></dark_gray><reset><gray><obf>a</obf></gray>").asComponent();
        CandleMeta.displayName(component);
        CandleMeta.addEnchant(Enchantment.MENDING, 1, false);
        CandleMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        CandleMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "none");
        candle.setItemMeta(CandleMeta);
        return candle;
    }

}
