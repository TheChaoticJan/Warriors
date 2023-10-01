package jansparadise.jansparadise.events.PlayerOrEntityEvents.PvPEvents;

import com.destroystokyo.paper.Title;
import jansparadise.jansparadise.JansParadise;
import jansparadise.jansparadise.models.PlayerStats;
import jansparadise.jansparadise.sonstiges.Actionbar;
import net.kyori.adventure.audience.Audience;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.sql.SQLException;

public class PlayerReceiveDamageEvent implements Listener{

    JansParadise plugin;

    public PlayerReceiveDamageEvent(JansParadise plugin) {
        this.plugin = plugin;
    }

    private BossBar bossBar;
    @EventHandler
    public void damageEvent(EntityDamageByEntityEvent event){

        if(event.getDamager().getType().equals(EntityType.ENDER_PEARL)){
            event.setCancelled(true);
        }

        if(event.getDamager().getType().equals(EntityType.PRIMED_TNT)){
            Entity e = event.getEntity();
            e.setVelocity(e.getLocation().getDirection().setY(0.05).multiply(3));
        }

        if(event.getDamager().getType() != EntityType.PLAYER){
            return;
        }
        Player d = (Player) event.getDamager();

        if(event.getEntity().getType() == EntityType.PLAYER){
            Player p = (Player) event.getEntity();

            if (!(p.getInventory().getArmorContents() == null)) {
                int HDura = 0;
                int BDura = 0;
                int CDura = 0;
                int LDura = 0;
                if (!(p.getInventory().getHelmet() == null)) {
                    HDura = p.getInventory().getHelmet().getType().getMaxDurability() - p.getInventory().getHelmet().getDurability();
                }

                if (!(p.getInventory().getBoots() == null)) {
                    BDura = p.getInventory().getBoots().getType().getMaxDurability() - p.getInventory().getBoots().getDurability();
                }

                if (!(p.getInventory().getChestplate() == null)) {
                    CDura = p.getInventory().getChestplate().getType().getMaxDurability() - p.getInventory().getChestplate().getDurability();
                }

                if (!(p.getInventory().getLeggings() == null)) {
                    LDura = p.getInventory().getLeggings().getType().getMaxDurability() - p.getInventory().getLeggings().getDurability();
                }

            try {
                PlayerStats stats = this.plugin.getDatabase().findPlayerStatsByUUID(p.getUniqueId().toString());

                if (stats == null) {

                    stats = new PlayerStats(p.getUniqueId().toString(), p.getName(), "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", false, false, false, false, false);

                    this.plugin.getDatabase().createPlayerStats(stats);

                }
                PlayerStats stats1 = this.plugin.getDatabase().findPlayerStatsByUUID(d.getUniqueId().toString());

                if (stats1 == null) {

                    stats1 = new PlayerStats(d.getUniqueId().toString(), d.getName(), "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", false, false, false, false, false);

                    this.plugin.getDatabase().createPlayerStats(stats1);

                }

                if(stats.getClan() != "" | stats1.getClan() != "" ){
                    if(stats.getClan().equals(stats1.getClan())){
                        event.setCancelled(true);
                        return;
                    }
                }

                if(stats.getPerk1()){
                    int rndm = (int) (1 + Math.random() * 380);

                    if(rndm == 1) {
                        String value = "";
                        if (HDura <= BDura && HDura <= CDura && HDura <= LDura) {
                            value = "§cNichts";
                            if (p.getInventory().getHelmet() != null) {
                                p.getInventory().getHelmet().setDurability((short) (p.getInventory().getHelmet().getDurability() - 10));
                                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 20, 1);
                                value = "Helm";
                            }
                        }
                        if (CDura <= LDura && CDura <= BDura && CDura <= HDura) {
                            value = "§cNichts";
                            if (p.getInventory().getChestplate() != null) {
                                p.getInventory().getChestplate().setDurability((short) (p.getInventory().getChestplate().getDurability() - 10));
                                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 20, 1);
                                value = "Brustplatte";
                            }
                        }
                        if (LDura <= HDura && LDura <= CDura && LDura <= BDura) {
                            value = "§cNichts";
                            if (p.getInventory().getLeggings() != null) {
                                p.getInventory().getLeggings().setDurability((short) (p.getInventory().getLeggings().getDurability() - 10));
                                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 20, 1);
                                value = "Hose";
                            }
                        }
                        if (BDura <= HDura && BDura <= CDura && BDura <= LDura) {
                            value = "§cNichts";
                            if (p.getInventory().getBoots() != null) {
                                p.getInventory().getBoots().setDurability((short) (p.getInventory().getBoots().getDurability() - 10));
                                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 20, 1);
                                value = "Schuhe";
                            }
                        }
                        showBossBar5(p, value);
                    }
                }

                if(stats.getPerk3()){
                    if(HDura < 30 | BDura < 30 | CDura < 30 | LDura < 30){
                        PotionEffect effect1 = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 1);
                        PotionEffect effect2 = new PotionEffect(PotionEffectType.SPEED, 200, 1);

                        p.addPotionEffect(effect1);
                        p.addPotionEffect(effect2);

                        p.playSound(p.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_BREAK, 20, 1);
                    }
                }

                if(stats1.getPerk4()){
                    int random = (int) (1 + Math.random() * 240);
                    if(random == 1){

                        Block block1 = p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ());
                        Block block2 = p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ());

                        block1.setType(Material.COBWEB);
                        block2.setType(Material.COBWEB);

                        d.playSound(d.getLocation(), Sound.ENTITY_FROG_LONG_JUMP, 20, 1);

                        Bukkit.getScheduler().scheduleSyncDelayedTask(JansParadise.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                int i = 5;
                                while (i > 0) {
                                    i--;
                                }
                                if(block1.getType() != Material.AIR) {
                                    block1.setType(Material.AIR);
                                    block1.getWorld().spawnParticle(Particle.CRIT, new Location(Bukkit.getWorld("world"), p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ()), 15);
                                }

                                if(block2.getType() != Material.AIR) {
                                    block2.setType(Material.AIR);
                                    block2.getWorld().spawnParticle(Particle.CRIT, new Location(Bukkit.getWorld("world"), p.getLocation().getBlockX(), p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ()), 15);
                                }

                            }}, 20 * 11);
                    }
                }

                d.sendActionBar(Actionbar.Actionbar(p, d,0 , 0));

            }catch (SQLException e){
                e.printStackTrace();
            }



                if (event.getEntity().getType() == EntityType.ENDER_CRYSTAL) {
                    event.setCancelled(true);
                }
            }
        }













        if(event.getDamager().getType().equals(EntityType.PLAYER)) {
            if (event.getEntity().getType().equals(EntityType.PLAYER)) {

            }
            if(d.getItemInHand().getItemMeta() != null) {
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
                                showBossBar(d);
                            } else {
                                int x = d.getLocation().getBlockX();
                                int y = d.getLocation().getBlockY();
                                int z = d.getLocation().getBlockZ();

                                d.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), new ItemStack(Material.ENDER_PEARL));
                                showBossBar(d);
                            }
                        }
                    }
                }

                if (d.getItemInHand().getItemMeta().getLore() != null) {
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
                                    showBossBar2(d);
                                } else {
                                    int x = d.getLocation().getBlockX();
                                    int y = d.getLocation().getBlockY();
                                    int z = d.getLocation().getBlockZ();

                                    d.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), new ItemStack(Material.EXPERIENCE_BOTTLE));
                                    showBossBar2(d);
                                }
                            }
                        }
                    }
                }

                if (d.getItemInHand().getItemMeta().getLore() != null) {
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
                                    showBossBar3(d);
                                } else {
                                    int x = d.getLocation().getBlockX();
                                    int y = d.getLocation().getBlockY();
                                    int z = d.getLocation().getBlockZ();

                                    d.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), new ItemStack(Material.COBWEB));
                                    showBossBar3(d);
                                }
                            }
                        }
                    }
                }

                if (d.getItemInHand().getItemMeta().getLore() != null) {
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
                                    showBossBar4(d);
                                } else {
                                    int x = d.getLocation().getBlockX();
                                    int y = d.getLocation().getBlockY();
                                    int z = d.getLocation().getBlockZ();

                                    d.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), new ItemStack(Material.TNT));
                                    showBossBar4(d);
                                }
                            }
                        }
                    }
                }
            }

        }


    }    private void showBossBar(Player player) {
        if (bossBar != null) {
            bossBar.removeAll();
        }

        bossBar = Bukkit.createBossBar("§x§0§0§8§D§F§F§lS§x§1§E§5§5§F§F§lc§x§3§D§1§C§F§F§li§x§6§4§0§2§F§E§l-§x§9§5§0§7§F§B§lF§x§C§6§0§B§F§9§li §7§lDrop", BarColor.PURPLE, BarStyle.SOLID);
        bossBar.addPlayer(player);

        Bukkit.getScheduler().runTaskLater(JansParadise.getInstance(), () -> {
            bossBar.removeAll();
            bossBar = null;
        }, 60); // 40 ticks = 2 seconds
    }

    private void showBossBar2 (Player player) {
        if (bossBar != null) {
            bossBar.removeAll();
        }

        bossBar = Bukkit.createBossBar("§x§E§B§D§7§7§B§lE§x§E§5§D§7§7§6§lr§x§D§E§D§6§7§0§lf§x§D§8§D§6§6§B§la§x§D§1§D§6§6§6§lh§x§C§B§D§6§6§1§lr§x§C§4§D§5§5§B§le§x§B§E§D§5§5§6§ln §7§lDrop", BarColor.WHITE, BarStyle.SOLID);
        bossBar.addPlayer(player);

        Bukkit.getScheduler().runTaskLater(JansParadise.getInstance(), () -> {
            bossBar.removeAll();
            bossBar = null;
        }, 60); // 40 ticks = 2 seconds
    }

    private void showBossBar3 (Player player) {
        if (bossBar != null) {
            bossBar.removeAll();
        }

        bossBar = Bukkit.createBossBar("§x§5§A§D§D§2§D§lK§x§5§8§C§5§2§5§ll§x§5§7§A§C§1§E§le§x§5§5§9§4§1§6§lb§x§4§E§9§B§1§8§lr§x§4§7§A§3§1§A§li§x§4§0§A§A§1§C§lg §7§lDrop", BarColor.GREEN, BarStyle.SOLID);
        bossBar.addPlayer(player);

        Bukkit.getScheduler().runTaskLater(JansParadise.getInstance(), () -> {
            bossBar.removeAll();
            bossBar = null;
        }, 60); // 40 ticks = 2 seconds
    }

    private void showBossBar4 (Player player) {
        if (bossBar != null) {
            bossBar.removeAll();
        }

        bossBar = Bukkit.createBossBar("§x§D§D§2§D§2§D§lE§x§C§8§3§E§2§6§lx§x§B§3§4§F§2§0§lp§x§9§E§6§0§1§9§ll§x§9§7§6§A§1§7§lo§x§9§D§6§F§1§9§ls§x§A§4§7§3§1§A§li§x§A§A§7§8§1§C§lv §7§lDrop", BarColor.RED, BarStyle.SOLID);
        bossBar.addPlayer(player);

        Bukkit.getScheduler().runTaskLater(JansParadise.getInstance(), () -> {
            bossBar.removeAll();
            bossBar = null;
        }, 60); // 40 ticks = 2 seconds
    }

    private void showBossBar5 (Player player, String value) {
        if (bossBar != null) {
            bossBar.removeAll();
        }


        bossBar = Bukkit.createBossBar("§7" + value + " geheilt §8» §a+10 Dura ", BarColor.GREEN, BarStyle.SEGMENTED_6);
        if(value == "§cNichts"){
            bossBar = Bukkit.createBossBar(value + " geheilt, deine Rüstung ist kaputt!", BarColor.RED, BarStyle.SOLID);
        }
        bossBar.addPlayer(player);

        Bukkit.getScheduler().runTaskLater(JansParadise.getInstance(), () -> {
            bossBar.removeAll();
            bossBar = null;
        }, 60); // 40 ticks = 2 seconds
    }


}

