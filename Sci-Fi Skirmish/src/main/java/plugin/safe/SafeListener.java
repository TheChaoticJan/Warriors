package plugin.safe;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;
import plugin.Utils;

import java.io.IOException;

public class SafeListener implements Listener {

    @EventHandler
    private static void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        if(!(player.getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "Slot0")))){
            for(int i = 0; i < 54; i++){
                try {
                    player.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "Slot" + i), PersistentDataType.STRING, Utils.itemStackToBase64(new ItemStack(Material.AIR)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @EventHandler
    private static void inventoryClose(InventoryCloseEvent event){
        Player player = (Player) event.getPlayer();
        if(event.getView().title().equals(MiniMessage.miniMessage().deserialize("<b><red><u>TRESOR")))
        for(int i = 0; i < 54; i++){
            try {
                player.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "Slot" + i), PersistentDataType.STRING, Utils.itemStackToBase64(event.getInventory().getItem(i)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
