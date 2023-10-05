package plugin.events.PlayerOrEntityEvents.PvPEvents;

import plugin.Main;
import plugin.models.PlayerStats;
import plugin.Infobar.Actionbar;
import plugin.sonstiges.InventoryInteracts;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.sql.SQLException;

public class ProjectileHitEvent implements Listener{

    private BossBar bossBar;

    Main plugin;

    public ProjectileHitEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void BowEvent(org.bukkit.event.entity.ProjectileHitEvent e) {

        if (e.getHitEntity() == null) {
            return;
        }

        Player d = (Player) e.getEntity().getShooter();


        if (d != null) {
            if (d.getItemInHand() != null) {
                if (d.getItemInHand().getItemMeta() != null) {
                    if (d.getItemInHand().getItemMeta() != null) {
                        InventoryInteracts.checkSpeicalitemDrops(d);
                    }
                }
            }


            if (e.getHitEntity().getType().equals(EntityType.PLAYER)) {

                Player p = (Player) e.getHitEntity();

                try {

                    PlayerStats stats = null;
                    PlayerStats stats1 = null;

                    if (p != null) {
                        stats = this.plugin.getDatabase().findPlayerStatsByUUID(p.getUniqueId().toString());

                        if (stats == null) {

                            stats = new PlayerStats(p.getUniqueId().toString(), p.getName(), "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", false, false, false, false, false, 1, 2, 3);

                            this.plugin.getDatabase().createPlayerStats(stats);
                        }


                    }
                    if (d != null) {
                        stats1 = this.plugin.getDatabase().findPlayerStatsByUUID(d.getUniqueId().toString());

                        if (stats1 == null) {

                            stats1 = new PlayerStats(p.getUniqueId().toString(), d.getName(), "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", false, false, false, false, false, 1, 2, 3);

                            this.plugin.getDatabase().createPlayerStats(stats1);

                        }
                    }

                    if (stats.getClan() != "" && stats1.getClan() != "") {
                        if (stats.getClan().equals(stats1.getClan())) {
                            e.setCancelled(true);
                            return;
                        }
                    }

                    if ((e.getEntity().getType().equals(EntityType.FISHING_HOOK))) {
                        p.damage(0.1);
                        p.setVelocity(d.getLocation().getDirection().setY(0.2).multiply(1));

                    }

                    if (e.getEntity().getType().equals(EntityType.ARROW)) {
                        if (stats1.getPerk2()) {
                            PotionEffect effect = new PotionEffect(PotionEffectType.SLOW, 200, 0);
                            p.addPotionEffect(effect);
                        }
                    }

                    d.sendActionBar(Actionbar.Actionbar(p, stats, d, stats1.getInfobar1(), stats1.getInfobar2(), stats1.getInfobar3()));

                } catch (SQLException s) {
                    s.printStackTrace();
                }
            }
        }
    }
}
