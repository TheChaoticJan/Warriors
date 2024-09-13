package plugin;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import plugin.models.PlayerStats;
import plugin.shop.ShopUtils;
import plugin.specialitems.BuyingEssentials;
import plugin.specialitems.candles.JumpCandle;
import plugin.specialitems.candles.RepairCandle;
import plugin.specialitems.candles.TeleportCandle;
import plugin.specialitems.candles.UltimateCandle;
import plugin.specialitems.holy.HolyArmor;
import plugin.specialitems.holy.HolyBackpack;
import plugin.specialitems.holy.HolyCoin;
import plugin.specialitems.holy.HolyCookieBox;
import plugin.specialitems.royal.ChesterItem;
import plugin.specialitems.royal.MagicStone;
import plugin.specialitems.royal.Scepter;
import plugin.specialitems.vampiric.VampiricBow;
import plugin.specialitems.vampiric.VampiricHelmet;
import plugin.specialitems.vampiric.VampiricHoe;
import plugin.utils.inventorybuilder.SpecialItemInventories;
import plugin.utils.itembuilder.*;
import plugin.utils.itembuilder.HolyFeather;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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

        if(event.getView().getTitle().endsWith("1") || event.getView().getTitle().endsWith("2") || event.getView().getTitle().endsWith("3")){
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
            if(!event.getView().getTitle().endsWith("!") && !event.getView().getTitle().endsWith("?")) {
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

        if(event.getView().getTitle().endsWith("kaufen!")){
            player.openInventory(confirmBuy(event.getCurrentItem(), player));
            event.setCancelled(true);
        }

        if(event.getView().title().equals(MiniMessage.miniMessage().deserialize("<green><b>Kaufen?"))){
            event.setCancelled(true);
            if(event.getCurrentItem().equals(InventoryEssentials.confirm())){

                for(int i = 0; i < 36; i++){
                    if(player.getInventory().getItem(i) == null){
                        break;
                    }else if(i == 35){
                        player.closeInventory();
                        player.sendMessage("§cDer Kauf wurde abgebrochen, da dein Inventar zu voll ist!");
                        return;
                    }
                }


                try{

                    ItemStack stack1 = Objects.requireNonNull(event.getClickedInventory()).getItem(1);
                    ItemMeta meta = Objects.requireNonNull(stack1).getItemMeta();

                    int prize = meta.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "xp"), PersistentDataType.INTEGER);
                    int type = meta.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "type"), PersistentDataType.INTEGER);
                    int specials = meta.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "specials"), PersistentDataType.INTEGER);
                    int amount = meta.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "amount"), PersistentDataType.INTEGER);

                    PlayerStats stats = Main.getInstance().getDatabase().findPlayerStats(player);
                    stats.setXp(stats.getXp() - prize);
                    Main.getInstance().getDatabase().updatePlayerStats(stats);

                    for(int i = 0; i < 35; i++){
                        ItemStack stack2 = player.getInventory().getItem(i);
                        if(stack2 == null){
                            continue;
                        }
                        if(stack2.getItemMeta() == null){
                            continue;
                        }
                        if(!stack2.getItemMeta().getPersistentDataContainer().has(BuyingEssentials.key)){
                            continue;
                        }
                        if(stack2.getItemMeta().getPersistentDataContainer().get(BuyingEssentials.key, PersistentDataType.INTEGER) == type){
                            if(stack2.getAmount() >= specials){
                                stack2.setAmount(stack2.getAmount() - specials);
                                break;
                            }else{
                                specials -= stack2.getAmount();
                                stack2.setAmount(0);
                            }
                        }
                        if(specials == 0){
                            break;
                        }
                    }

                    for(int i = 1; i <= amount; i++) {
                        player.getInventory().addItem(Objects.requireNonNull(event.getInventory().getItem(0)));
                    }
                    player.closeInventory();
                    player.sendMessage("§aKauf erfolgreich abgeschlossen!");

                }catch (SQLException e){e.printStackTrace();}
            }
        }
    }

    private static Inventory confirmBuy(ItemStack stack, Player player){

        Inventory inventory = Bukkit.createInventory(player, InventoryType.HOPPER, MiniMessage.miniMessage().deserialize("<green><b>Kaufen?"));
        ItemMeta meta = stack.getItemMeta();

        int xp = meta.getPersistentDataContainer().get(ShopUtils.xp_prize, PersistentDataType.INTEGER);
        int specials = meta.getPersistentDataContainer().get(ShopUtils.type_amount, PersistentDataType.INTEGER);
        int specialType = meta.getPersistentDataContainer().get(ShopUtils.type_key, PersistentDataType.INTEGER);
        int amount = meta.getPersistentDataContainer().get(ShopUtils.item_amount, PersistentDataType.INTEGER);

        int specialsR = 0;
        for(int i = 0; i < 36; i++){
            ItemStack stack1 = player.getInventory().getItem(i);
            if(stack1 == null){
                continue;
            }
            if(stack1.getItemMeta() == null){
                continue;
            }
            ItemMeta meta1 = stack1.getItemMeta();
            if(!meta1.getPersistentDataContainer().has(BuyingEssentials.key)){
                continue;
            }else{
                int temp = meta1.getPersistentDataContainer().get(BuyingEssentials.key, PersistentDataType.INTEGER);
                if(temp == specialType){
                    specialsR += stack1.getAmount();
                }
            }
        }
        if(specialsR < specials){

            ItemStack notEnough = new ItemStack(Material.BARRIER);
            ItemMeta meta1 = notEnough.getItemMeta();
            meta1.displayName(MiniMessage.miniMessage().deserialize("<b><red>Nicht kaufbar!"));
            ArrayList<Component> lore = new ArrayList<>();
            lore.add(MiniMessage.miniMessage().deserialize("<i:false><red>Du hast nicht genügend Baupläne im"));
            lore.add(MiniMessage.miniMessage().deserialize("<i:false><red>Inventar um dieses Item zu kaufen!"));
            meta1.lore(lore);
            notEnough.setItemMeta(meta1);

            inventory.setItem(1, notEnough);
            inventory.setItem(3, InventoryEssentials.back());
            return inventory;
        }

        try {
            PlayerStats stats = Main.getInstance().getDatabase().findPlayerStats(player);

            if(stats.getXp() < xp){

                ItemStack notEnough = new ItemStack(Material.BARRIER);
                ItemMeta meta1 = notEnough.getItemMeta();
                meta1.displayName(MiniMessage.miniMessage().deserialize("<b><red>Nicht kaufbar!"));
                ArrayList<Component> lore = new ArrayList<>();
                lore.add(MiniMessage.miniMessage().deserialize("<i:false><red>Du hast nicht genügend XP"));
                lore.add(MiniMessage.miniMessage().deserialize("<i:false><red>um dieses Item zu kaufen!"));
                meta1.lore(lore);
                notEnough.setItemMeta(meta1);

                inventory.setItem(1, notEnough);
                inventory.setItem(3, InventoryEssentials.back());
                return inventory;
            }

            ItemStack toBuy = Utils.itemStackFromBase64(meta.getPersistentDataContainer().get(ShopUtils.orginal, PersistentDataType.STRING));
            inventory.setItem(0, toBuy);

            ItemStack info = new ItemStack(Material.PAINTING);
            ItemMeta infoMeta = info.getItemMeta();

            infoMeta.displayName(MiniMessage.miniMessage().deserialize("<i:false><aqua>Kaufinformationen"));

            infoMeta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "xp"), PersistentDataType.INTEGER, xp);
            infoMeta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "type"), PersistentDataType.INTEGER, specialType);
            infoMeta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "specials"), PersistentDataType.INTEGER, specials);
            infoMeta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "amount"), PersistentDataType.INTEGER, amount);

            ArrayList<Component> lore = new ArrayList<>();
            lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Preis (XP): <yellow>" + xp + " <gold>✧"));
            lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Items des Typ " + specialType + ": <red>" + specials));
            lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Kaufmenge: <green>" + amount));
            lore.add(Component.text(""));
            lore.add(MiniMessage.miniMessage().deserialize("<gray>Die Items werden dir bei Kauf aus dem"));
            lore.add(MiniMessage.miniMessage().deserialize("<gray>Inventar entnommen."));
            lore.add(MiniMessage.miniMessage().deserialize("<gray>Außerdem werden die Xp vom Konto abgezogen"));
            infoMeta.lore(lore);

            info.setItemMeta(infoMeta);
            inventory.setItem(1, info);

            inventory.setItem(3, InventoryEssentials.back());
            inventory.setItem(4, InventoryEssentials.confirm());

        }catch (SQLException | IOException e){
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

                    inventory.setItem(27, BuyingEssentials.createPlan(1));
                    inventory.setItem(28, BuyingEssentials.createPlan(2));
                    inventory.setItem(29, BuyingEssentials.createPlan(3));
                    inventory.setItem(30, BuyingEssentials.createBlessing());
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

                }
                case 4 -> {
                    inventory.setItem(9, HolyFeather.create());
                    inventory.setItem(10, HolyCoin.create());
                    inventory.setItem(11, HolyCookieBox.create());
                    inventory.setItem(12, HolyBackpack.create());

                    for (int i = 18; i < 18 + HolyArmor.create().length; i++) {
                        inventory.setItem(i, HolyArmor.create()[i - 18]);
                    }

                    inventory.setItem(17, UltimateCandle.create());
                    inventory.setItem(24, Scepter.create());
                    inventory.setItem(25, ChesterItem.create());
                    inventory.setItem(26, MagicStone.create());

                }
                default -> {
                    player.sendMessage("DA IST WAS FALSCH");
                }
            }
        }
        else{
            switch (tag) {
                case 1 -> {
                    inventory.setItem(9, ShopUtils.makeShopItem(Western.Schwert(player), 600, tag, 1, 1));
                    inventory.setItem(10, ShopUtils.makeShopItem(Western.Bogen(player), 300, tag, 1, 1));
                    inventory.setItem(11, ShopUtils.makeShopItem(Western.Rod(player), 400, tag, 1, 1));
                    inventory.setItem(12, ShopUtils.makeShopItem(Western.Picke(player), 300, tag, 1, 1));
                    inventory.setItem(14, ShopUtils.makeShopItem(Western.Helmet(player), 600, tag, 2, 1));
                    inventory.setItem(15, ShopUtils.makeShopItem(Western.Chestplate(player), 630, tag, 2, 1));
                    inventory.setItem(16, ShopUtils.makeShopItem(Western.Leggings(player), 620, tag, 2, 1));
                    inventory.setItem(17, ShopUtils.makeShopItem(Western.Boots(player), 600, tag, 2, 1));
                }
                case 2 -> {
                    inventory.setItem(9, ShopUtils.makeShopItem(SciFiItems.Schwert(), 800, tag, 2, 1));
                    inventory.setItem(10, ShopUtils.makeShopItem(SciFiItems.Axt(), 900, tag, 3, 1));
                    inventory.setItem(11, ShopUtils.makeShopItem(SciFiItems.Bogen(), 850, tag, 2, 1));

                    inventory.setItem(18, ShopUtils.makeShopItem(ErfahrenItems.sword(), 800, tag, 2, 1));
                    inventory.setItem(19, ShopUtils.makeShopItem(ErfahrenItems.Axt(), 900, tag, 3, 1));
                    inventory.setItem(20, ShopUtils.makeShopItem(ErfahrenItems.bow(), 850, tag, 2, 1));

                    inventory.setItem(27, ShopUtils.makeShopItem(UnsortableItems.loveStick(), 42, tag, 5, 1));
                }
                case 3 -> {
                    inventory.setItem(9, ShopUtils.makeShopItem(VampiricHoe.create(player), 1500, tag, 4, 1));
                    inventory.setItem(10, ShopUtils.makeShopItem(VampiricBow.create(player), 1200, tag, 4, 1));
                    inventory.setItem(11, ShopUtils.makeShopItem(VampiricHelmet.create(player), 1690, tag, 5, 1));

                    inventory.setItem(18, ShopUtils.makeShopItem(Berserker.Axe(player), 2000, tag, 5, 1));
                    inventory.setItem(19, ShopUtils.makeShopItem(Berserker.Tracker(), 150, tag, 1, 1));

                    inventory.setItem(27, ShopUtils.makeShopItem(JumpCandle.create(), 1000, tag, 3, 1));
                    inventory.setItem(28, ShopUtils.makeShopItem(RepairCandle.create(), 1000, tag, 3, 1));
                    inventory.setItem(29, ShopUtils.makeShopItem(TeleportCandle.create(), 1000, tag, 3, 1));
                }
                case 4 -> {
                    inventory.setItem(9, ShopUtils.makeShopItem(HolyFeather.create(), 300, tag, 2, 3));
                    inventory.setItem(10, ShopUtils.makeShopItem(HolyCoin.create(), 500, tag, 3, 1));
                    inventory.setItem(11, ShopUtils.makeShopItem(HolyCookieBox.create(), 300, tag, 3, 1));
                    inventory.setItem(12, ShopUtils.makeShopItem(HolyBackpack.create(), 1000, tag, 3, 1));
                    for (int i = 18; i < 18 + HolyArmor.create().length; i++) {
                        inventory.setItem(i, ShopUtils.makeShopItem(HolyArmor.create()[i - 18], 1150, tag,5, 1));
                    }

                    inventory.setItem(17, ShopUtils.makeShopItem(UltimateCandle.create(), 2000, tag, 3, 1));
                    inventory.setItem(24, ShopUtils.makeShopItem(Scepter.create(), 3000, tag, 5, 1));
                    inventory.setItem(25, ShopUtils.makeShopItem(ChesterItem.create(), 3000, tag, 5, 1));
                    inventory.setItem(26, ShopUtils.makeShopItem(MagicStone.create(), 4000, tag, 5, 1));
                }
                default -> {
                    player.sendMessage("DA IST WAS FALSCH");
                }
            }
        }
        return inventory;
    }

}
