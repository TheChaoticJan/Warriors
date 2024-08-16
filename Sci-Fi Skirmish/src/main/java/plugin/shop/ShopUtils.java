package plugin.shop;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.checkerframework.checker.units.qual.N;
import plugin.Main;

import java.util.ArrayList;
import java.util.List;

public class ShopUtils {
    public static final NamespacedKey xp_prize = new NamespacedKey(Main.getInstance(), "xp_prize");
    public static final NamespacedKey type_key = new NamespacedKey(Main.getInstance(), "type");
    public static final NamespacedKey type_amount = new NamespacedKey(Main.getInstance(), "type_prize");
    public static final NamespacedKey item_amount = new NamespacedKey(Main.getInstance(), "amount");

    public static ItemStack makeShopItem(ItemStack original, int xpPrize, int type, int specialsAmount, int amount){
        ItemMeta meta = original.getItemMeta();

        List<Component> lore = meta.lore();
        if(lore == null){
            lore = new ArrayList<>();
        }
        lore.addAll(List.of(addDescription(xpPrize, type, specialsAmount, amount)));
        meta.lore(lore);

        meta.getPersistentDataContainer().set(xp_prize, PersistentDataType.INTEGER, xpPrize);
        meta.getPersistentDataContainer().set(type_key, PersistentDataType.INTEGER, type);
        meta.getPersistentDataContainer().set(type_amount, PersistentDataType.INTEGER, specialsAmount);
        meta.getPersistentDataContainer().set(item_amount, PersistentDataType.INTEGER, amount);

        original.setItemMeta(meta);
        return original;
    }

    private static Component [] addDescription(int xpPrize, int type, int specialsAmount, int amount){
        Component [] components = new Component[4];

        String typeS;
        switch (type){
            case 1 -> typeS = "<dark_purple>Bauplan Typ 1";
            case 2 -> typeS = "<blue>Bauplan Typ 2";
            case 3 -> typeS = "<aqua>Bauplan Typ 3";
            case 4 -> typeS = "<yellow>Segen";
            default -> typeS = "Fehler";
        }

        components [0] = MiniMessage.miniMessage().deserialize("");
        components [1] = MiniMessage.miniMessage().deserialize("<i:false><dark_gray>--------------");
        components [2] = MiniMessage.miniMessage().deserialize("<i:false><white>Preis: <yellow>" + xpPrize + " ✧ <white>| " + specialsAmount + "<dark_gray>x " + typeS);
        components [3] = MiniMessage.miniMessage().deserialize("<i:false><white>Menge: <red>" + amount + "x");

        return components;
    }





}
