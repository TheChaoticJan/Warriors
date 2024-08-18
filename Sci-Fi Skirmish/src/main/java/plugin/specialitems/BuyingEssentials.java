package plugin.specialitems;

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

public class BuyingEssentials {

    public static final NamespacedKey key = new NamespacedKey(Main.getInstance(), "essential");

    public static ItemStack createPlan(int type){
        String typeS;
        switch (type){
            case 1 -> typeS = "<dark_purple>Bauplan Typ 1";
            case 2 -> typeS = "<blue>Bauplan Typ 2";
            case 3 -> typeS = "<aqua>Bauplan Typ 3";
            default -> typeS = "Fehler";
        }
        ItemStack stack = new ItemStack(Material.BOOK);
        ItemMeta meta = stack.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<i:false>" + typeS));

        ArrayList<Component> lore = new ArrayList<>();
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Du kannst dieses Item benutzen,"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>um Items des Typ " + type));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>im <i><yellow>/shop </i><white>zu kaufen"));
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize("<gray>Das Item muss sich dazu beim"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray>Kauf in deinem Inventar befinden!"));
        meta.lore(lore);

        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, type);

        stack.setItemMeta(meta);
        return stack;
    }

    public static ItemStack createBlessing(){
        ItemStack stack = new ItemStack(Material.PRISMARINE_SHARD);
        ItemMeta meta = stack.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<i:false><yellow><obf>a</obf> Segen <obf>a</obf>"));

        ArrayList<Component> lore = new ArrayList<>();
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Du kannst dieses Item benutzen,"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>um Items des Typ 4" ));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>im <i><yellow>/shop </i><white>zu kaufen"));
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize("<gray>Das Item muss sich dazu beim"));
        lore.add(MiniMessage.miniMessage().deserialize("<gray>Kauf in deinem Inventar befinden!"));
        meta.lore(lore);

        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, 4);

        stack.setItemMeta(meta);
        return stack;
    }

}
