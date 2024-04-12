package plugin.events.PlayerOrEntityEvents.interactions;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;
import plugin.utils.ItemBuilder.Candles;

import java.util.Objects;

public class AnvilEvent implements Listener{

    @EventHandler
    public void onAnvilUse(PrepareSmithingEvent event) {

        Inventory anvil = event.getInventory();

        if (anvil.getItem(0).getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "candle"))) {

            if (anvil.getItem(1) == null || anvil.getItem(1).getItemMeta().getPersistentDataContainer().isEmpty()) {
                return;
            }

            switch (Objects.requireNonNull(anvil.getItem(1).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "material"), PersistentDataType.STRING))) {
                case "gold" -> event.setResult(Candles.healCandle());
                case "diamond" -> event.setResult(Candles.crateCandle());
                case "kelp" -> event.setResult(Candles.boostCandle());
                case "emerald" -> event.setResult(Candles.teleportCandle());
                default -> event.setResult(new ItemStack(Material.AIR));
            }

        }
    }
}
