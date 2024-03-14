package plugin.events.InventoryEvents;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;

import java.util.List;
import java.util.Objects;

public class CandleClickEvent implements Listener{

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){

        Player player = (Player) event.getWhoClicked();
        NamespacedKey key = new NamespacedKey(Main.getInstance(), "candle");

        if(event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR){
            return;
        }

        if(event.getCurrentItem().getItemMeta().getPersistentDataContainer().has(key) && event.getView().title().equals(MiniMessage.miniMessage().deserialize("<rainbow>Wähle den Kerzentyp aus!"))){

            List<String> list = player.getItemInHand().getItemMeta().getLore();

            switch (Objects.requireNonNull(event.getCurrentItem().getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.STRING))) {
                case "heal" -> {
                    player.getItemInHand().getItemMeta().getPersistentDataContainer().set(key, PersistentDataType.STRING, "heal");
                    list.set(6, "   §7Aktueller Modus: §eErfahren");
                    player.getItemInHand().setType(Material.YELLOW_CANDLE);
                    player.closeInventory();
                    player.sendActionBar("§fModus §7▸ §eErfahren");
                }
                case "boost" -> {
                    player.getItemInHand().getItemMeta().getPersistentDataContainer().set(key, PersistentDataType.STRING, "boost");
                    list.set(6, "   §7Aktueller Modus: §6Explosiv");
                    player.getItemInHand().setType(Material.ORANGE_CANDLE);
                    player.closeInventory();
                    player.sendActionBar("§fModus §7▸ §6Explosiv");
                }
                case "teleport" -> {
                    player.getItemInHand().getItemMeta().getPersistentDataContainer().set(key, PersistentDataType.STRING, "teleport");
                    list.set(6, "   §7Aktueller Modus: §2Klebrig");
                    player.getItemInHand().setType(Material.GREEN_CANDLE);
                    player.closeInventory();
                    player.sendActionBar("§fModus §7▸ §2Klebrig");
                }
                case "crate" -> {
                    player.getItemInHand().getItemMeta().getPersistentDataContainer().set(key, PersistentDataType.STRING, "crate");
                    list.set(6, "   §7Aktueller Modus: §5Sci-Fi");
                    player.getItemInHand().setType(Material.BLUE_CANDLE);
                    player.closeInventory();
                    player.sendActionBar("§fModus §7▸ §5Sci-Fi");
                }
                default -> {
                }
            }
            ItemMeta meta = player.getItemInHand().getItemMeta();
            meta.setLore(list);
            player.getItemInHand().setItemMeta(meta);
            event.setCancelled(true);
        }
    }
}
