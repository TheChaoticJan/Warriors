package jansparadise.jansparadise.events.PlayerOrEntityEvents.PvPEvents;


import jansparadise.jansparadise.JansParadise;
import jansparadise.jansparadise.models.PlayerStats;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import java.sql.SQLException;

public class RodEvent implements Listener{

    JansParadise plugin;

    public RodEvent(JansParadise plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void rodEvent(ProjectileHitEvent i) {

        if (i.getHitEntity() != null) {
            if (i.getHitEntity().getType() == EntityType.PLAYER) {
                Player p = (Player) i.getHitEntity();
                Player r = (Player) i.getEntity().getShooter();


                try {
                    PlayerStats stats = this.plugin.getDatabase().findPlayerStatsByUUID(p.getUniqueId().toString());

                    if (stats == null) {

                        stats = new PlayerStats(p.getUniqueId().toString(), p.getName(), "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", false, false, false, false, false, 1,2, 3);

                        this.plugin.getDatabase().createPlayerStats(stats);

                    }
                    PlayerStats stats1 = this.plugin.getDatabase().findPlayerStatsByUUID(r.getUniqueId().toString());

                    if (stats1 == null) {

                        stats1 = new PlayerStats(p.getUniqueId().toString(), r.getName(), "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", false, false, false, false, false,1, 2, 3);

                        this.plugin.getDatabase().createPlayerStats(stats1);

                    }

                    if (stats.getClan() != "" && stats1.getClan() != "") {
                        if (stats.getClan().equals(stats1.getClan())) {
                            i.setCancelled(true);
                            return;
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if (i.getHitEntity() == null) {
                    return;
                }

                if ((i.getEntity().getType().equals(EntityType.FISHING_HOOK))) {

                    if (i.getHitEntity().getType().equals(EntityType.PLAYER)) {
                        p.damage(0.1);
                        p.setVelocity(r.getLocation().getDirection().setY(0.2).multiply(1));
                    }


                }
            }


        }
    }


}



