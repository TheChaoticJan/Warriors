package plugin.listeners.entitylisteners.pvp;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import plugin.Main;
import plugin.infobar.Actionbar;
import plugin.models.PlayerCombatHandler;
import plugin.models.PlayerStats;
import plugin.utils.essentials.InventoryInteracts;

import java.sql.SQLException;
import java.util.Objects;

public class BowHitEvent implements Listener {
    Main plugin;

    public BowHitEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void BowEvent(org.bukkit.event.entity.ProjectileHitEvent event) {

        if(event.getHitEntity() == null){
            return;
        }

        if (event.getEntity().getShooter() instanceof Player damager) {

            if(damager == event.getHitEntity()){
                event.setCancelled(true);
                return;
            }

                if (!damager.getItemInHand().getType().equals(Material.AIR)) {
                    if (damager.getItemInHand().getItemMeta() != null) {
                        if (damager.getItemInHand().getItemMeta() != null) {
                            InventoryInteracts.checkSpecialItemDrops(damager);
                        }
                    }
                }


                if  (event.getHitEntity() instanceof Player player){

                    PlayerCombatHandler handler = PlayerCombatHandler.getCombatStatusByPlayer(damager);
                    handler.startCombat(player, false);


                    try {

                         PlayerStats stats = this.plugin.getDatabase().findPlayerStats(player);
                            if (stats == null) {
                                stats = new PlayerStats(player);
                                this.plugin.getDatabase().createPlayerStats(stats);
                            }

                        PlayerStats stats1 = this.plugin.getDatabase().findPlayerStats(damager);
                        if (stats1 == null) {
                            stats1 = new PlayerStats(damager);
                            this.plugin.getDatabase().createPlayerStats(stats1);
                        }

                        if (!Objects.equals(stats.getClan(), "") && !Objects.equals(stats1.getClan(), "")) {
                            if (stats.getClan().equals(stats1.getClan())) {
                                event.setCancelled(true);
                                return;
                            }
                        }

                        if (event.getEntity().getType().equals(EntityType.FISHING_HOOK)) {
                            player.damage(0.1);
                            player.setVelocity(damager.getLocation().getDirection().setY(0.2).multiply(1));
                            if (event.getEntity().getType().equals(EntityType.SNOWBALL)) {
                                player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 99));
                            }
                        }

                        if (event.getEntity().getType().equals(EntityType.ARROW)) {
                            if (stats1.getPerks()[1]) {
                                PotionEffect effect = new PotionEffect(PotionEffectType.SLOW, 200, 0);
                                player.addPotionEffect(effect);
                            }
                        }

                        damager.sendActionBar(Actionbar.buildActionbar(player, stats, stats1.getInfobarValues()));

                    } catch (SQLException s) {
                        s.printStackTrace();
                    }
                }
            }
        }
    }

