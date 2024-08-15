package plugin.specialitems.holy;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.event.Listener;
import plugin.Main;
import plugin.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class HolyBackpack implements Listener{

    private final static NamespacedKey key = new NamespacedKey(Main.getInstance(), "backpack");
    private static final Component name = MiniMessage.miniMessage().deserialize(HolyUtil.holyGradient + "<b>Linas Handtasche");
    private static HashMap<Player, ItemStack> usedBackpack = new HashMap<>();
    public static ItemStack create(){
        ItemStack stack = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta = stack.getItemMeta();

        meta.displayName(HolyUtil.createName("Linas Handtasche"));
        meta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 0);
        for(int i = 0; i < 5; i++){
            try {
                meta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "S"+i ), PersistentDataType.STRING, Utils.itemStackToBase64(new ItemStack(Material.AIR)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ArrayList<Component> lore = new ArrayList<>();
        lore.add(MiniMessage.miniMessage().deserialize(HolyUtil.holyGradient + "Heilig"));
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray>▸ <yellow>Geld, Schlüssel, Handy... Alles dabei!"));
        lore.add(MiniMessage.miniMessage().deserialize(" <i:false><white>In diese Handtasche kannst du bis zu"));
        lore.add(MiniMessage.miniMessage().deserialize(" <i:false><red>5 verschiedene <white>Itemstacks packen!"));
        meta.lore(lore);

        stack.setItemMeta(meta);
        return stack;
    }

    @EventHandler
    private static void rightClick(PlayerInteractEvent event) throws IOException {
        Player player = event.getPlayer();

        if(event.getAction().isRightClick() && player.getItemInHand().getItemMeta() != null){
            if(player.getItemInHand().getItemMeta().getPersistentDataContainer().has(key)){
                Inventory inventory = Bukkit.createInventory(player, InventoryType.HOPPER, name);
                for(int i = 0; i < 5; i++){
                    ItemStack stack = Utils.itemStackFromBase64(player.getItemInHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "S"+i), PersistentDataType.STRING));
                    inventory.setItem(i, stack);
                }
                usedBackpack.put(player, player.getItemInHand());
                player.openInventory(inventory);
            }
        }
    }

    @EventHandler
    private static void inventoryClick(InventoryClickEvent event){
        if(event.getView().title().equals(name)){
            if(event.getCurrentItem().getItemMeta() != null){
                if(event.getCurrentItem().getItemMeta().getPersistentDataContainer().has(key)){
                    event.setCancelled(true);
                }
            }
        }
    }


    @EventHandler
    private static void inventoryClose(InventoryCloseEvent event) throws IOException {
        Player player = (Player) event.getPlayer();
        if(event.getView().title().equals(name)){
            ItemStack stack = usedBackpack.get(player);
            for(int i = 0; i < 5; i++){
                ItemMeta meta = stack.getItemMeta();
                meta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "S"+i), PersistentDataType.STRING, Utils.itemStackToBase64(event.getInventory().getItem(i)));
                stack.setItemMeta(meta);
            }
                player.setItemInHand(stack);
        }

    }

}
