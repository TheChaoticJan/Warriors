package plugin.specialitems.royal;

import net.kyori.adventure.text.BuildableComponent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.event.Listener;
import plugin.Main;
import plugin.infobar.InfobarEssentials;
import plugin.utils.itembuilder.InventoryEssentials;

import java.util.ArrayList;
import java.util.HashMap;

public class MagicStone implements Listener{

    private final static NamespacedKey key = new NamespacedKey(Main.getInstance(), "teleportstone");
    private HashMap<Player, Boolean> cooldownMap = new HashMap<>();
    private static final int startAmount = 3;
    private static final int loadAmount = 2;
    private static final int range = 9;
    private static final String name = "Zauberstein";

    public static final ItemStack create(){
        ItemStack stack = new ItemStack(Material.FLINT);
        ItemMeta meta = stack.getItemMeta();

        meta.displayName(RoyalUtil.createName(name));
        correctName(meta, startAmount);

        meta.addEnchant(Enchantment.MENDING, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, startAmount);

        ArrayList<Component> lore = new ArrayList<>();
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><gradient:yellow:gold>Royal"));
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray>▸ <yellow>Die Zauberer sind auf deiner Seite!"));
        lore.add(MiniMessage.miniMessage().deserialize("  <i:false><white>Rechtsklickst du dieses Item"));
        lore.add(MiniMessage.miniMessage().deserialize("  <i:false><white>in die Luft, so teleportierst du"));
        lore.add(MiniMessage.miniMessage().deserialize("  <i:false><white>dich <green>" + range + " <white>Blöcke in die Richtung,"));
        lore.add(MiniMessage.miniMessage().deserialize("  <i:false><white>in die du schaust!"));
        lore.add(MiniMessage.miniMessage().deserialize("  <i:false><white>Wird mit <dark_purple>Enderperlen <white>aufgeladen."));
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize("<i><gray>Sneak + Rechtsklick zum aufladen"));
        meta.lore(lore);

        stack.setItemMeta(meta);
        return stack;
    }

    private static ItemMeta correctName(ItemMeta meta, int amount){
        meta.displayName(RoyalUtil.createName("Zauberstein").append(Component.text(" §8[§5" + amount + "§8]")));
        return meta;
    }

    @EventHandler
    private void playerInterActEvent(PlayerInteractEvent event){
        if(!event.hasItem()){
            return;
        }else if(event.getItem().hasItemMeta()) {
            if (event.getItem().getItemMeta().getPersistentDataContainer().has(key)){
                if(event.getItem().getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.INTEGER) > 0 && !event.getPlayer().isSneaking()) {
                    Location location = event.getPlayer().getLocation();
                    Location newL = location.add(location.getDirection().multiply(range)).add(0, 0.1, 0);

                    if (newL.getBlock().getType().isAir()) {
                        event.getPlayer().teleport(newL);
                        ItemStack stack = event.getItem();
                        ItemMeta meta = stack.getItemMeta();
                        meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, stack.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.INTEGER) - 1);
                        correctName(meta, meta.getPersistentDataContainer().get(key, PersistentDataType.INTEGER));
                        stack.setItemMeta(meta);
                    } else {
                        event.getPlayer().sendActionBar("§cDu kannst dich nicht in die Wand teleportieren!");
                    }
                }
                if(event.getAction().isRightClick() && event.getPlayer().isSneaking()){
                    Player player = event.getPlayer();

                    Inventory inventory = Bukkit.createInventory(player, InventoryType.HOPPER, "§0Klicke §5Enderperlen §0an!");
                    inventory.setItem(0, InventoryEssentials.glass());
                    inventory.setItem(1, InventoryEssentials.glass());
                    inventory.setItem(3, InventoryEssentials.glass());
                    inventory.setItem(4, InventoryEssentials.glass());

                    ItemStack stack = new ItemStack(Material.PAPER);
                    ItemMeta meta = stack.getItemMeta();
                    meta.displayName(Component.text("§fUmwandlungsrate:"));
                    ArrayList<Component> lore = new ArrayList<>();
                    lore.add(Component.text(""));
                    lore.add(Component.text("§51 Enderperle §7= §f" + loadAmount + " Ladungen"));
                    lore.add(Component.text(""));
                    lore.add(Component.text("§7Angeklickte Enderperlen werden"));
                    lore.add(Component.text("§7automatisch umgewandelt!"));
                    lore.add(Component.text("§7Rechtsklick: ein Item | Linksklick: ganzer Stack"));
                    meta.lore(lore);
                    stack.setItemMeta(meta);
                    inventory.setItem(2, stack);

                    player.openInventory(inventory);
                }
            }
        }
    }

    @EventHandler
    private void inventoryClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();

        if(event.getView().getTitle().equalsIgnoreCase("§0Klicke §5Enderperlen §0an!")){
            event.setCancelled(true);

            if(event.getCurrentItem() == null){
                event.setCancelled(true);
                return;
            }

            if(player.getItemInHand().hasItemMeta()){
                if(player.getItemInHand().getItemMeta().getPersistentDataContainer().has(key)){
                    if(event.getCurrentItem().getType().equals(Material.ENDER_PEARL)){
                        if(event.getClick().isLeftClick()) {
                            ItemStack stack = player.getItemInHand();
                            ItemMeta meta = stack.getItemMeta();
                            meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, (meta.getPersistentDataContainer().get(key, PersistentDataType.INTEGER) + (event.getCurrentItem().getAmount() * loadAmount)) - loadAmount);
                            correctName(meta, meta.getPersistentDataContainer().get(key, PersistentDataType.INTEGER));
                            stack.setItemMeta(meta);
                            event.getCurrentItem().setAmount(0);
                        }
                        if(event.getClick().isRightClick()) {
                            ItemStack stack = player.getItemInHand();
                            ItemMeta meta = stack.getItemMeta();
                            meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, meta.getPersistentDataContainer().get(key, PersistentDataType.INTEGER) + loadAmount);
                            correctName(meta, meta.getPersistentDataContainer().get(key, PersistentDataType.INTEGER));
                            stack.setItemMeta(meta);
                            event.getCurrentItem().setAmount(event.getCurrentItem().getAmount() - 1);
                        }
                    }
                    else{
                        event.setCancelled(true);
                    }
                }else{
                    player.closeInventory();
                }
            }

        }
    }

}
