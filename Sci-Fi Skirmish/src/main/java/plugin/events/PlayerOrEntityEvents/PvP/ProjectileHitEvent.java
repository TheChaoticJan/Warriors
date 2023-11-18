package plugin.events.PlayerOrEntityEvents.PvP;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import plugin.Main;
import plugin.models.PlayerStats;
import plugin.utils.CombatLogger;
import plugin.utils.Infobar.Actionbar;
import plugin.utils.essentials.InventoryInteracts;

import java.sql.SQLException;
import java.util.Objects;

public class ProjectileHitEvent implements Listener{
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
            if (!d.getItemInHand().getType().equals(Material.AIR)) {
                if (d.getItemInHand().getItemMeta() != null) {
                    if (d.getItemInHand().getItemMeta() != null) {
                        InventoryInteracts.checkSpecialitemDrops(d);
                    }
                }
            }


            if (e.getHitEntity().getType().equals(EntityType.PLAYER)) {

                Player p = (Player) e.getHitEntity();

                try {

                    PlayerStats stats = null;

                    if (p != null) {
                        stats = this.plugin.getDatabase().findPlayerStatsByUUID(p.getUniqueId().toString());

                        if (stats == null) {

                            stats = new PlayerStats(p.getUniqueId().toString(), p.getName(), "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", false, false, false, false, false, 1, 2, 3);

                            this.plugin.getDatabase().createPlayerStats(stats);
                        }


                    }
                      PlayerStats  stats1 = this.plugin.getDatabase().findPlayerStatsByUUID(d.getUniqueId().toString());

                        if (stats1 == null) {

                            stats1 = new PlayerStats(d.getUniqueId().toString(), d.getName(), "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", false, false, false, false, false, 1, 2, 3);

                            this.plugin.getDatabase().createPlayerStats(stats1);

                        }

                    CombatLogger.setInCombat(p, d);

                    assert stats != null;
                    if (!Objects.equals(stats.getClan(), "") && !Objects.equals(stats1.getClan(), "")) {
                        if (stats.getClan().equals(stats1.getClan())) {
                            e.setCancelled(true);
                            return;
                        }
                    }

                    if (e.getEntity().getType().equals(EntityType.FISHING_HOOK) || e.getEntity().getType().equals(EntityType.SNOWBALL)) {
                        p.damage(0.1);
                        p.setVelocity(d.getLocation().getDirection().setY(0.2).multiply(1));
                        if(e.getEntity().getType().equals(EntityType.SNOWBALL)){
                            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 99));
                        }
                    }

                    if (e.getEntity().getType().equals(EntityType.ARROW)) {
                        if (stats1.getPerk2()) {
                            PotionEffect effect = new PotionEffect(PotionEffectType.SLOW, 200, 0);
                            p.addPotionEffect(effect);
                        }
                    }

                    d.sendActionBar(Actionbar.buildActionbar(p, stats, stats1.getInfobar1(), stats1.getInfobar2(), stats1.getInfobar3()));

                } catch (SQLException s) {
                    s.printStackTrace();
                }
            }
        }
    }
}
