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
import org.checkerframework.checker.units.qual.N;
import org.jetbrains.annotations.NotNull;
import plugin.Main;
import plugin.cratesystem.Loot;
import plugin.models.PlayerStats;
import plugin.utils.Text.Texts;

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

            p.sendActionBar(MiniMessage.miniMessage().deserialize("<dark_gray><<red>Tot<dark_gray>> " + Texts.get("crate") + " <dark_gray>▸ " + Texts.get(crate.getRarity())));

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
                case "rare" -> Objects.requireNonNull(stats).setCrates(new int[]{stats.getCrates()[0], stats.getCrates()[1], stats.getCrates()[2], stats.getCrates()[3] + 1, stats.getCrates()[4]});
                case "mythic" -> Objects.requireNonNull(stats).setCrates(new int[]{stats.getCrates()[0], stats.getCrates()[1], stats.getCrates()[2], stats.getCrates()[3], stats.getCrates()[4] + 1});
            }

            try {
                Main.getInstance().getDatabase().updatePlayerStats(Objects.requireNonNull(stats));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

