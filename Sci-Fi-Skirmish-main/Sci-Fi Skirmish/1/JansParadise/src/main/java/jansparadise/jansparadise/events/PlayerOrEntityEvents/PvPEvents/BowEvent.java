package jansparadise.jansparadise.events.PlayerOrEntityEvents.PvPEvents;

import jansparadise.jansparadise.Main;
import jansparadise.jansparadise.models.PlayerStats;
import jansparadise.jansparadise.Infobar.Actionbar;
import jansparadise.jansparadise.sonstiges.Bossbars;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.sql.SQLException;

public class BowEvent implements Listener{

    private BossBar bossBar;

    Main plugin;

    public BowEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void BowEvent(ProjectileHitEvent e) {

        if (e.getHitEntity() == null) {
            return;
        }

        Player d = (Player) e.getEntity().getShooter();


        if (e.getHitEntity().getType() == EntityType.ARMOR_STAND) {
            if (e.getEntity().getType() == EntityType.ARROW) {
                Entity e1 = e.getHitEntity();
                Double life = ((LivingEntity) e1).getHealth();
                int Scale = (int) Math.pow(10, 1);
                int i = (int) ((Math.random() * 2) + 1);
                int Damage = 20;
                if (i == 1) {
                    Damage = 10;
                }
                int FinalScale = (int) (Math.round(life * Scale) / Scale - Damage);
                d.sendActionBar("§8<§c" + FinalScale + "%§8> §x§F§F§E§2§5§9N§x§F§F§D§E§5§8a§x§F§F§D§A§5§8c§x§F§F§D§5§5§7h§x§F§F§D§1§5§7s§x§F§F§C§D§5§6c§x§F§F§C§9§5§6h§x§F§F§C§5§5§5u§x§F§F§C§0§5§4b§x§F§F§B§C§5§4s§x§F§F§B§8§5§3k§x§F§F§B§4§5§3i§x§F§F§A§F§5§2s§x§F§F§A§B§5§2t§x§F§F§A§7§5§1e §8» §7???");

                if (Damage >= ((LivingEntity) e1).getHealth()) {
                    ((LivingEntity) e1).setHealth(0);
                } else {
                    ((LivingEntity) e1).setHealth(((LivingEntity) e1).getHealth() - Damage);
                }


                if (((LivingEntity) e1).getHealth() <= 0) {
                    e1.setCustomNameVisible(false);
                    e1.setCustomName(d.getName());
                    int x1 = e1.getLocation().getBlockX();
                    int y1 = e1.getLocation().getBlockY();
                    int z1 = e1.getLocation().getBlockZ();
                    e1.getWorld().spawnParticle(Particle.CRIT, new Location(Bukkit.getWorld("world"), x1, y1, z1), 15);
                    e1.remove();
                    return;
                }
            }

        }


        if (d != null) {
            if (d.getItemInHand() != null) {
                if (d.getItemInHand().getItemMeta() != null) {
                    if (d.getItemInHand().getItemMeta() != null) {
                        if (d.getItemInHand().getItemMeta().getLore() != null) {
                            if (d.getItemInHand().getItemMeta().getLore().contains("§eSci-Fi")) {

                                String s = "false";
                                int i = (int) (Math.random() * 300) + 1;
                                if (i == 1) {
                                    for (int l = 0; l <= 35; l++) {
                                        if (d.getInventory().getItem(l) == null || d.getInventory().getItem(l).getType() == Material.ENDER_PEARL && d.getInventory().getItem(l).getAmount() <= 15) {
                                            s = "true";
                                        }
                                    }
                                    if (s == "true") {
                                        d.getInventory().addItem(new ItemStack(Material.ENDER_PEARL));
                                    } else {
                                        int x = d.getLocation().getBlockX();
                                        int y = d.getLocation().getBlockY();
                                        int z = d.getLocation().getBlockZ();

                                        d.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), new ItemStack(Material.ENDER_PEARL));
                                    }
                                    new Bossbars().SciFiBar(d);
                                }
                            }

                            if (d.getItemInHand().getItemMeta().getLore().contains("§eErfahren")) {

                                String s = "false";
                                int i = (int) (Math.random() * 300) + 1;
                                if (i == 1) {
                                    for (int m = 0; m <= 5; m++) {
                                        for (int l = 0; l <= 35; l++) {
                                            if (d.getInventory().getItem(l) == null || d.getInventory().getItem(l).getType() == Material.EXPERIENCE_BOTTLE && d.getInventory().getItem(l).getAmount() <= 63) {
                                                s = "true";
                                            }
                                        }
                                        if (s == "true") {
                                            d.getInventory().addItem(new ItemStack(Material.EXPERIENCE_BOTTLE));
                                        } else {
                                            int x = d.getLocation().getBlockX();
                                            int y = d.getLocation().getBlockY();
                                            int z = d.getLocation().getBlockZ();

                                            d.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), new ItemStack(Material.EXPERIENCE_BOTTLE));
                                        }

                                    }
                                    new Bossbars().ErfahrenBar(d);
                                }
                            }

                            if (d.getItemInHand().getItemMeta().getLore().contains("§eKlebrig")) {

                                String s = "false";
                                int i = (int) (Math.random() * 300) + 1;
                                if (i == 1) {
                                    for (int m = 0; m <= 3; m++) {
                                        for (int l = 0; l <= 35; l++) {
                                            if (d.getInventory().getItem(l) == null || d.getInventory().getItem(l).getType() == Material.COBWEB && d.getInventory().getItem(l).getAmount() <= 63) {
                                                s = "true";
                                            }
                                        }
                                        if (s == "true") {
                                            d.getInventory().addItem(new ItemStack(Material.COBWEB));
                                        } else {
                                            int x = d.getLocation().getBlockX();
                                            int y = d.getLocation().getBlockY();
                                            int z = d.getLocation().getBlockZ();

                                            d.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), new ItemStack(Material.COBWEB));
                                        }
                                    }
                                    new Bossbars().KlebrigBar(d);
                                }
                            }

                            if (d.getItemInHand().getItemMeta().getLore().contains("§eExplosiv")) {

                                String s = "false";
                                int i = (int) (Math.random() * 300) + 1;
                                if (i == 1) {
                                    for (int m = 0; m <= 2; m++) {
                                        for (int l = 0; l <= 35; l++) {
                                            if (d.getInventory().getItem(l) == null || d.getInventory().getItem(l).getType() == Material.TNT && d.getInventory().getItem(l).getAmount() <= 63) {
                                                s = "true";
                                            }
                                        }
                                        if (s == "true") {
                                            d.getInventory().addItem(new ItemStack(Material.TNT));
                                        } else {
                                            int x = d.getLocation().getBlockX();
                                            int y = d.getLocation().getBlockY();
                                            int z = d.getLocation().getBlockZ();

                                            d.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), new ItemStack(Material.TNT));
                                        }
                                    }
                                    new Bossbars().ExplosivBar(d);
                                }
                            }
                        }
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
