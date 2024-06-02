package plugin.listeners.entitylisteners.pvp;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;

import java.util.Objects;

public class PlayerRepairEvent implements Listener {

    @EventHandler
    public void onXPThrow(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        if (event.hasItem() && player.getItemInHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "amount")) && Objects.requireNonNull(event.getItem()).getType().equals(Material.EXPERIENCE_BOTTLE) && event.getAction().isRightClick() && !player.isSneaking()) {

            event.setCancelled(true);

            if (event.getItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "amount"), PersistentDataType.INTEGER).intValue() > 0) {
                player.getLocation().getWorld().spawnEntity(player.getLocation().add(0, 1.7, 0), EntityType.THROWN_EXP_BOTTLE).setVelocity(player.getLocation().getDirection());
                ItemMeta meta = player.getItemInHand().getItemMeta();
                meta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "amount"), PersistentDataType.INTEGER, meta.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "amount"), PersistentDataType.INTEGER) - 1);
                meta.displayName(MiniMessage.miniMessage().deserialize("<bold><i:false><#f59542>Aufladbare XP-Flasche</bold> <dark_gray><<yellow>" + meta.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "amount"), PersistentDataType.INTEGER) + "/512<dark_gray>>"));
                player.getItemInHand().setItemMeta(meta);
            }
        }
    }
}