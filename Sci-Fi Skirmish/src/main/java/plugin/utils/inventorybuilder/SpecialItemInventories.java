package plugin.utils.inventorybuilder;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;
import plugin.shop.ShopUtils;
import plugin.specialitems.holy.*;
import plugin.utils.itembuilder.*;
import plugin.utils.itembuilder.HolyFeather;
import plugin.specialitems.candles.*;
import plugin.specialitems.vampiric.VampiricBow;
import plugin.specialitems.vampiric.VampiricHelmet;
import plugin.specialitems.vampiric.VampiricHoe;

import java.util.ArrayList;
import java.util.UUID;

public class SpecialItemInventories {

    private static final NamespacedKey key = new NamespacedKey(Main.getInstance(), "category");

    public static Inventory selection(Player p, String name){
        Inventory inventory = Bukkit.createInventory(p, InventoryType.HOPPER , MiniMessage.miniMessage().deserialize(name));

        for(int i = 0; i < 5; i++){
            inventory.setItem(i, InventoryEssentials.bars());
        }

        ItemStack [] heads = heads();

        for(int i = 1; i <= heads.length; i++){
            ItemStack stack = heads[i-1];
            ItemMeta meta = stack.getItemMeta();
            meta.lore(lore(i));
            meta.displayName(MiniMessage.miniMessage().deserialize(mainColor(i) + "<b><i:false><obf>a</obf> Kategorie " + i + " <obf>a</obf>"));
            meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, i);
            stack.setItemMeta(meta);
            if(i != 4) {
                inventory.setItem(i - 1, stack);
            }else{
                inventory.setItem(i, stack);
            }
        }
        return inventory;
    }

    private static ItemStack [] heads() {
        ItemStack category1 = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta category1ItemMeta = (SkullMeta) category1.getItemMeta();
        PlayerProfile playerProfile = Bukkit.createProfile(UUID.fromString("a75e3f60-2242-4429-8ece-bcde77"), "Player");
        playerProfile.setProperty(new ProfileProperty("textures", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTY1ZjRlZWVkMGQ3YmE1ZDI3NjM5ODE5YWJhMWRlY2IxZTUwZjU3YTI5Y2E4M2Y0N2QyMTExZWRjOTY0NjExNiJ9fX0="));
        category1ItemMeta.setPlayerProfile(playerProfile);
        category1.setItemMeta(category1ItemMeta);

        ItemStack category2 = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta category2ItemMeta = (SkullMeta) category2.getItemMeta();
        PlayerProfile playerProfile2 = Bukkit.createProfile(UUID.fromString("a75e3f60-2242-4429-8ece-bcde77"), "Player");
        playerProfile2.setProperty(new ProfileProperty("textures", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGM3Yjk1MDQ4MjhmYmE5YWRjMTljOGZkNzViNzFlYWJlYzUzMzVkZGM1MWFjZGExNGU1OWEyZWQyZjcwZTRmMSJ9fX0="));
        category2ItemMeta.setPlayerProfile(playerProfile2);
        category2.setItemMeta(category2ItemMeta);

        ItemStack category3 = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta category3ItemMeta = (SkullMeta) category3.getItemMeta();
        PlayerProfile playerProfile3 = Bukkit.createProfile(UUID.fromString("a75e3f60-2242-4429-8ece-bcde77"), "Player");
        playerProfile3.setProperty(new ProfileProperty("textures", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzYyNjc5ZjdkYzQzZmUzM2Y3MGM4NDhkZWZiNDJlY2Y2ZDI0OTUwMDY3MGQ3ZWRkYTJlOGJlOTg2YWM1ZjEwMSJ9fX0="));
        category3ItemMeta.setPlayerProfile(playerProfile3);
        category3.setItemMeta(category3ItemMeta);

        ItemStack category4 = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta category4ItemMeta = (SkullMeta) category4.getItemMeta();
        PlayerProfile playerProfile4 = Bukkit.createProfile(UUID.fromString("a75e3f60-2242-4429-8ece-bcde77"), "Player");
        playerProfile4.setProperty(new ProfileProperty("textures", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWNhYWY2OTUzZTc5Y2UxYTE5MGQ5YjUzZDFlYWQ4OGExMTBmMjQxMTY5YmI1OThhMTdhMzhjNmQ5NzJlZmEyOSJ9fX0="));
        category4ItemMeta.setPlayerProfile(playerProfile4);
        category4.setItemMeta(category4ItemMeta);

        return new ItemStack[]{category1, category2, category3, category4};
        }

    private static String mainColor(int type){
        String mainColor;
        switch (type){
            case 1 -> mainColor = "<dark_purple>";
            case 2 -> mainColor = "<blue>";
            case 3 -> mainColor = "<aqua>";
            case 4 -> mainColor = "<yellow>";
            default -> mainColor = "<black>";
        }
        return mainColor;
    }

    private static ArrayList<Component> lore(int type){

        String mainColor = mainColor(type);

        ArrayList<Component> lore = new ArrayList<>();
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Items der <b>" + mainColor + "Kategorie " + type));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>benötigen folgendes Extraitem, "));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>um gekauft zu werden:"));
        if(type < 4) {
            lore.add(MiniMessage.miniMessage().deserialize("  <i:false><dark_gray>▸ " + mainColor + "Bauplan Typ " + type));
        }else{
            lore.add(MiniMessage.miniMessage().deserialize("  <i:false><dark_gray>▸ <yellow>Segen" ));
        }

        return lore;
    }

}
