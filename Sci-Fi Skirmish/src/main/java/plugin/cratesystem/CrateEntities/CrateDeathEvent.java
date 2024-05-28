package plugin.cratesystem.CrateEntities;

import com.destroystokyo.paper.Title;
import com.destroystokyo.paper.event.entity.EntityRemoveFromWorldEvent;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import plugin.Main;
import plugin.models.PlayerStats;
import plugin.models.TextHandler;

import java.sql.SQLException;
import java.util.Objects;

public class CrateDeathEvent implements Listener {
    public CrateDeathEvent(Main plugin) {
        this.plugin = plugin;
    }

    Main plugin;

    @EventHandler
    public void DeathEvent(EntityRemoveFromWorldEvent event){
        if(event.getEntity() instanceof ArmorStand stand) {

            @NotNull String playerName = Objects.requireNonNull(event.getEntity().getCustomName());
            Player p = Bukkit.getServer().getPlayerExact(playerName);

            if (p == null) {
                return;
            }
            event.getEntity().getPassengers().clear();

            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
                int i = 5;
                while (i > 0) {
                    i--;
                }
                new Crate(event.getEntity(), event.getEntity().getLocation().getBlockX(), event.getEntity().getLocation().getBlockY(), event.getEntity().getLocation().getBlockZ());

            }, 20 * 30);


            Entity e = event.getEntity();

            PlayerStats stats = null;
            try {
                stats = this.plugin.getDatabase().findPlayerStats(p);

                if (stats == null) {

                    stats = new PlayerStats(p);
                    this.plugin.getDatabase().createPlayerStats(stats);

                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }


            int x = e.getLocation().getBlockX();
            double y = e.getLocation().getBlockY() + 1.7;
            int z = e.getLocation().getBlockZ();

            Crate crate = Crate.getCrateByKey(event.getEntity().getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "key"), PersistentDataType.STRING));

            p.sendActionBar(MiniMessage.miniMessage().deserialize("<dark_gray><<red>Tot<dark_gray>> " + TextHandler.get("crate") + " <dark_gray>▸ " + TextHandler.get(crate.getRarity())));

            for(ItemStack stack : crate.getLootTable()) {
                Item item = e.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), stack);
                if (item.getItemStack().getType().equals(Material.ENCHANTED_BOOK)) {
                    item.setCustomName(item.getItemStack().getItemMeta().getDisplayName());
                    item.setCustomNameVisible(true);
                }
            }

            switch (crate.getRarity()){
                case "common" -> Objects.requireNonNull(stats).setCrates(new int[]{stats.getCrates()[0] + 1, stats.getCrates()[1], stats.getCrates()[2], stats.getCrates()[3], stats.getCrates()[4]});
                case "uncommon" -> Objects.requireNonNull(stats).setCrates(new int[]{stats.getCrates()[0], stats.getCrates()[1] + 1, stats.getCrates()[2], stats.getCrates()[3], stats.getCrates()[4]});
                case "epic" -> Objects.requireNonNull(stats).setCrates(new int[]{stats.getCrates()[0], stats.getCrates()[1], stats.getCrates()[2] + 1, stats.getCrates()[3], stats.getCrates()[4]});
                case "rare" -> {
                    Objects.requireNonNull(stats).setCrates(new int[]{stats.getCrates()[0], stats.getCrates()[1], stats.getCrates()[2], stats.getCrates()[3] + 1, stats.getCrates()[4]});
                    p.sendTitle(new Title("§6§kaa §x§D§3§D§F§0§0L§x§D§7§D§2§0§1e§x§D§B§C§4§0§3g§x§D§F§B§7§0§4e§x§E§2§A§9§0§5n§x§E§6§9§C§0§6d§x§E§A§8§E§0§8ä§x§E§E§8§1§0§9r §6§kaa", "§7Nachschub", 3, 35, 3));
                }
                case "mythic" -> {
                    Objects.requireNonNull(stats).setCrates(new int[]{stats.getCrates()[0], stats.getCrates()[1], stats.getCrates()[2], stats.getCrates()[3], stats.getCrates()[4] + 1});
                    p.sendTitle(new Title("§b§kaa §x§0§0§D§F§C§DM§x§0§1§D§1§B§By§x§0§3§C§4§A§9t§x§0§4§B§6§9§7h§x§0§6§A§9§8§6i§x§0§7§9§B§7§4s§x§0§9§8§E§6§2c§x§0§A§8§0§5§0h §b§kaa", "§7Nachschub", 3, 35, 3));
                }
            }

            try {
                Main.getInstance().getDatabase().updatePlayerStats(Objects.requireNonNull(stats));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

