package plugin.listeners.entitylisteners.interactions;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import plugin.Main;
import plugin.models.PlayerStats;
import plugin.models.PlayerCombatHandler;
import plugin.specialitems.uniques.SwiftSword;

import java.sql.SQLException;
import java.util.*;

public class RightClickEvent implements Listener{

    public RightClickEvent(Main plugin) {
        this.plugin = plugin;
    }

    Main plugin;

    @EventHandler
    private void clickEvent(PlayerInteractEvent event){

        Player p = event.getPlayer();

        if (p.getItemInHand().getType().equals(Material.COMPASS) && p.getItemInHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "tracker"))) {
            Player nearest = getNearestPlayer(p);
            p.setCompassTarget(nearest.getLocation());

            ItemMeta meta = p.getItemInHand().getItemMeta();
            meta.displayName(MiniMessage.miniMessage().deserialize("<i:false><b><gradient:#6a3e0a:#9d2323:#e5e814>Tracker <dark_gray><b>▸ <red>" + getNearestPlayer(p).getName()));
            p.getItemInHand().setItemMeta(meta);

            p.sendActionBar("§f" + nearest.getName() + " §7| §b" + Math.round(p.getLocation().distance(nearest.getLocation())) + " Blöcke");
        }

        try {
            PlayerStats stats = this.plugin.getDatabase().findPlayerStats(p);

            if (stats == null) {

                stats = new PlayerStats(p);

                this.plugin.getDatabase().createPlayerStats(stats);

            }

            float x = p.getLocation().getBlockX();
            float y = p.getLocation().getBlockY();
            float z = p.getLocation().getBlockZ();

        }catch (SQLException exception){
            exception.printStackTrace();
        }

    }
    private Player getNearestPlayer(Player player){
        double distance = Double.POSITIVE_INFINITY;

        Player target = null;

        for(Player guy : Bukkit.getOnlinePlayers()) {
            double dist = Double.POSITIVE_INFINITY;
            if (guy != player && !(Main.getInstance().VanishList.contains(guy.getUniqueId()))){
                dist = player.getLocation().distance(guy.getLocation());
            }
            if(distance >= dist){
                distance = dist;
                target = guy;
            }
        }

        return target;
    }

    }
