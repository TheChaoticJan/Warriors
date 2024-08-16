package plugin;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import plugin.models.PlayerStats;
import plugin.shop.ShopCommand;
import plugin.shop.ShopUtils;
import plugin.specialitems.candles.JumpCandle;
import plugin.specialitems.candles.RepairCandle;
import plugin.specialitems.candles.TeleportCandle;
import plugin.specialitems.candles.UltimateCandle;
import plugin.specialitems.holy.HolyArmor;
import plugin.specialitems.holy.HolyBackpack;
import plugin.specialitems.holy.HolyCoin;
import plugin.specialitems.holy.HolyCookieBox;
import plugin.specialitems.vampiric.VampiricBow;
import plugin.specialitems.vampiric.VampiricHelmet;
import plugin.specialitems.vampiric.VampiricHoe;
import plugin.utils.inventorybuilder.SpecialItemInventories;
import plugin.utils.itembuilder.*;
import plugin.utils.itembuilder.HolyFeather;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;

public class InventoryUtils implements Listener {

    public static final String shopName = "<red><b><u>Shop";
    public static final String modInvName = "<rainbow><b>Specialitems";

    private static final String selectionName = "<black>Wähle ein Item";


    @EventHandler
    private void inventoryClick(InventoryClickEvent event) {

        if(event.getCurrentItem() == null){
            return;
        }
        if(event.getCurrentItem().getType().equals(InventoryEssentials.glass().getType())) {
            event.setCancelled(true);
            return;
        }
        if(event.getCurrentItem().getType().equals(InventoryEssentials.bars().getType())){
            event.setCancelled(true);
            return;
        }

        Player player = (Player) event.getWhoClicked();
        ItemStack stack = event.getCurrentItem();

        if (event.getView().title().equals(MiniMessage.miniMessage().deserialize(modInvName))) {
            event.setCancelled(true);
            if (stack == null || stack.getType().equals(Material.WHITE_STAINED_GLASS_PANE) || stack.getType().equals(Material.IRON_BARS) || Objects.equals(event.getClickedInventory(), player.getInventory())) {
                return;
            } else if (stack.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "category"))) {
                player.openInventory(showOff(false, player, event.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "category"), PersistentDataType.INTEGER), selectionName + ":"));
            }
            return;
        }
        if (event.getView().title().equals(MiniMessage.miniMessage().deserialize(shopName))) {
            event.setCancelled(true);
            if (stack == null || stack.getType().equals(Material.WHITE_STAINED_GLASS_PANE) || stack.getType().equals(Material.IRON_BARS) || Objects.equals(event.getClickedInventory(), player.getInventory())) {
                return;
            } else if (stack.getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "category"))) {
                player.openInventory(showOff(true, player, event.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "category"), PersistentDataType.INTEGER), selectionName + ", um es zu kaufen!"));
            }
            return;
        }
        if (event.getCurrentItem().equals(InventoryEssentials.back())) {
            if(!event.getView().getTitle().endsWith("!")) {
                player.openInventory(SpecialItemInventories.selection(player, modInvName));
            }else{
                player.openInventory(SpecialItemInventories.selection(player, shopName));
            }
            event.setCancelled(true);
            return;
        }

        if(event.getView().getTitle().endsWith(":")){
            player.getInventory().addItem(event.getCurrentItem());
            event.setCancelled(true);
        }

        if(event.getView().getTitle().endsWith("!")){
            player.openInventory(confirmBuy(event.getCurrentItem(), player));
            event.setCancelled(true);
        }

    }

    private static Inventory confirmBuy(ItemStack stack, Player player){

        Inventory inventory = Bukkit.createInventory(player, InventoryType.HOPPER, MiniMessage.miniMessage().deserialize("<green><b>Kaufen?"));
        ItemMeta meta = stack.getItemMeta();

        int xp = meta.getPersistentDataContainer().get(ShopUtils.xp_prize, PersistentDataType.INTEGER);
        int specials = meta.getPersistentDataContainer().get(ShopUtils.type_amount, PersistentDataType.INTEGER);
        int specialType = meta.getPersistentDataContainer().get(ShopUtils.type_key, PersistentDataType.INTEGER);
        int amount = meta.getPersistentDataContainer().get(ShopUtils.item_amount, PersistentDataType.INTEGER);

        try {
            PlayerStats stats = Main.getInstance().getDatabase().findPlayerStats(player);

            if(stats.getXp() < xp){
                inventory.setItem(2, new ItemStack(Material.BARRIER));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return inventory;
    }

    private static Inventory showOff(Boolean shop, Player player, int tag, String name){
        Inventory inventory = Bukkit.createInventory(player, 45, MiniMessage.miniMessage().deserialize(name));
        for(int i = 0; i < 44; i++){
            inventory.setItem(i, InventoryEssentials.bars());
            if(i == 8){
                i = 35;
            }
        }
        inventory.setItem(44, InventoryEssentials.back());

        if(!shop){
            switch (tag) {
                case 1 -> {
                    inventory.setItem(9, Western.Schwert(player));
                    inventory.setItem(10, Western.Bogen(player));
                    inventory.setItem(11, Western.Rod(player));
                    inventory.setItem(12, Western.Picke(player));
                    inventory.setItem(14, Western.Helmet(player));
                    inventory.setItem(15, Western.Chestplate(player));
                    inventory.setItem(16, Western.Leggings(player));
                    inventory.setItem(17, Western.Boots(player));
                }
                case 2 -> {
                    inventory.setItem(9, SciFiItems.Schwert());
                    inventory.setItem(10, SciFiItems.Axt());
                    inventory.setItem(11, SciFiItems.Bogen());

                    inventory.setItem(18, ErfahrenItems.sword());
                    inventory.setItem(19, ErfahrenItems.Axt());
                    inventory.setItem(20, ErfahrenItems.bow());

                    inventory.setItem(27, UnsortableItems.loveStick());
                }
                case 3 -> {
                    inventory.setItem(9, VampiricHoe.create(player));
                    inventory.setItem(10, VampiricBow.create(player));
                    inventory.setItem(11, VampiricHelmet.create(player));

                    inventory.setItem(18, Berserker.Axe(player));
                    inventory.setItem(19, Berserker.Tracker());

                    inventory.setItem(27, JumpCandle.create());
                    inventory.setItem(28, RepairCandle.create());
                    inventory.setItem(29, TeleportCandle.create());
                    inventory.setItem(30, UltimateCandle.create());
                }
                case 4 -> {
                    inventory.setItem(9, HolyFeather.create());
                    inventory.setItem(10, HolyCoin.create());
                    inventory.setItem(11, HolyCookieBox.create());
                    inventory.setItem(12, HolyBackpack.create());

                    for (int i = 14; i < 14 + HolyArmor.create().length; i++) {
                        inventory.setItem(i, HolyArmor.create()[i - 14]);
                    }
                }
                default -> {
                    player.sendMessage("DA IST WAS FALSCH");
                }
            }
        }
        else{
            switch (tag) {
                case 1 -> {
                    inventory.setItem(9, ShopUtils.makeShopItem(Western.Schwert(player), 300, tag, 1, 1));
                    inventory.setItem(10, ShopUtils.makeShopItem(Western.Bogen(player), 270, tag, 1, 1));
                    inventory.setItem(11, ShopUtils.makeShopItem(Western.Rod(player), 320, tag, 1, 1));
                    inventory.setItem(12, ShopUtils.makeShopItem(Western.Picke(player), 120, tag, 1, 1));
                    inventory.setItem(14, ShopUtils.makeShopItem(Western.Helmet(player), 340, tag, 2, 1));
                    inventory.setItem(15, ShopUtils.makeShopItem(Western.Chestplate(player), 340, tag, 2, 1));
                    inventory.setItem(16, ShopUtils.makeShopItem(Western.Leggings(player), 340, tag, 2, 1));
                    inventory.setItem(17, ShopUtils.makeShopItem(Western.Boots(player), 340, tag, 2, 1));
                }
                case 2 -> {
                    inventory.setItem(9, ShopUtils.makeShopItem(SciFiItems.Schwert(), 500, tag, 2, 1));
                    inventory.setItem(10, ShopUtils.makeShopItem(SciFiItems.Axt(), 450, tag, 3, 1));
                    inventory.setItem(11, ShopUtils.makeShopItem(SciFiItems.Bogen(), 300, tag, 2, 1));

                    inventory.setItem(18, ShopUtils.makeShopItem(ErfahrenItems.sword(), 500, tag, 2, 1));
                    inventory.setItem(19, ShopUtils.makeShopItem(ErfahrenItems.Axt(), 450, tag, 3, 1));
                    inventory.setItem(20, ShopUtils.makeShopItem(ErfahrenItems.bow(), 300, tag, 2, 1));

                    inventory.setItem(27, ShopUtils.makeShopItem(UnsortableItems.loveStick(), 1, tag, 5, 1));
                }
                case 3 -> {
                    inventory.setItem(9, VampiricHoe.create(player));
                    inventory.setItem(10, VampiricBow.create(player));
                    inventory.setItem(11, VampiricHelmet.create(player));

                    inventory.setItem(18, Berserker.Axe(player));
                    inventory.setItem(19, Berserker.Tracker());

                    inventory.setItem(27, JumpCandle.create());
                    inventory.setItem(28, RepairCandle.create());
                    inventory.setItem(29, TeleportCandle.create());
                    inventory.setItem(30, UltimateCandle.create());
                }
                case 4 -> {
                    inventory.setItem(9, HolyFeather.create());
                    inventory.setItem(10, HolyCoin.create());
                    inventory.setItem(11, HolyCookieBox.create());
                    inventory.setItem(12, HolyBackpack.create());

                    for (int i = 14; i < 14 + HolyArmor.create().length; i++) {
                        inventory.setItem(i, HolyArmor.create()[i - 14]);
                    }
                }
                default -> {
                    player.sendMessage("DA IST WAS FALSCH");
                }
            }
        }
        return inventory;
    }

}
