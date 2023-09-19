package jansparadise.jansparadise.events.PlayerOrEntityEvents.PvPEvents;

import jansparadise.jansparadise.JansParadise;
import jansparadise.jansparadise.models.PlayerStats;
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

import java.sql.SQLException;

public class BowEvent implements Listener{

    private BossBar bossBar;

    JansParadise plugin;

    public BowEvent(JansParadise plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void BowEvent(ProjectileHitEvent e){

        if(e.getHitEntity() == null){
            return;
        }

        Player  d = (Player) e.getEntity().getShooter();

        if (e.getHitEntity().getType() == EntityType.ARMOR_STAND) {
            Entity e1 =  e.getHitEntity();
            Double life = ((LivingEntity) e1).getHealth();
            int Scale = (int) Math.pow(10, 1);
            int i = (int) ((Math.random() * 2) +1);
            int Damage = 20;
            if(i == 1){
                Damage = 10;
            }
            int FinalScale = (int) (Math.round(life * Scale) / Scale - Damage);
            d.sendActionBar("§8<§c" + FinalScale  + "%§8> §x§F§F§E§2§5§9N§x§F§F§D§E§5§8a§x§F§F§D§A§5§8c§x§F§F§D§5§5§7h§x§F§F§D§1§5§7s§x§F§F§C§D§5§6c§x§F§F§C§9§5§6h§x§F§F§C§5§5§5u§x§F§F§C§0§5§4b§x§F§F§B§C§5§4s§x§F§F§B§8§5§3k§x§F§F§B§4§5§3i§x§F§F§A§F§5§2s§x§F§F§A§B§5§2t§x§F§F§A§7§5§1e §8» §7???");

            if(Damage >= ((LivingEntity) e1).getHealth()){
                ((LivingEntity) e1).setHealth(0);
            }else {
                ((LivingEntity) e1).setHealth(((LivingEntity) e1).getHealth() - Damage);
            }


            if(((LivingEntity) e1).getHealth() <= 0){
                e1.setCustomNameVisible(false);
                ((LivingEntity) e1).setCustomName(d.getName());
                int x1 = e1.getLocation().getBlockX();
                int y1 = e1.getLocation().getBlockY();
                int z1 = e1.getLocation().getBlockZ();
                e1.getWorld().spawnParticle(Particle.CRIT, new Location(Bukkit.getWorld("world"), x1, y1, z1), 15);
                e1.remove();
                return;
            }

        }








        if(d !=null) {
            if (d.getItemInHand() != null) {
                if (d.getItemInHand().getItemMeta() != null) {
                    if (d.getItemInHand().getItemMeta().getLore() != null) {
                        if (d.getItemInHand().getItemMeta().getLore().contains("§eSci-Fi")) {

                            String s = "false";
                            int i = (int) (Math.random() * 250) + 1;
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
                        if (d.getItemInHand().getItemMeta().getLore().contains("§eErfahren")) {

                            String s = "false";
                            int i = (int) (Math.random() * 250) + 1;
                            if (i == 1) {
                                for (int m = 0; m <= 5; m++) {
                                    for (int l = 0; l <= 35; l++) {
                                        if (d.getInventory().getItem(l) == null || d.getInventory().getItem(l).getType() == Material.EXPERIENCE_BOTTLE && d.getInventory().getItem(l).getAmount() <= 63) {
                                            s = "true";
                                        }
                                    }
                                    if (s == "true") {
                                        d.getInventory().addItem(new ItemStack(Material.EXPERIENCE_BOTTLE, 1));
                                        showBossBar2(d);
                                    } else {
                                        int x = d.getLocation().getBlockX();
                                        int y = d.getLocation().getBlockY();
                                        int z = d.getLocation().getBlockZ();

                                        d.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), new ItemStack(Material.EXPERIENCE_BOTTLE, 1));
                                        showBossBar2(d);
                                    }
                                }
                            }
                        }

                        if (d.getItemInHand().getItemMeta().getLore() != null) {
                            if (d.getItemInHand().getItemMeta().getLore().contains("§eKlebrig")) {

                                String s = "false";
                                int i = (int) (Math.random() * 250) + 1;
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
                                int i = (int) (Math.random() * 250) + 1;
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
            }
        }


        if(e.getHitEntity().getType().equals(EntityType.PLAYER)){

            Player  p = (Player) e.getHitEntity();

            try {

                PlayerStats stats = null;
                PlayerStats stats1 = null;

                if(p != null){
                    stats = this.plugin.getDatabase().findPlayerStatsByUUID(p.getUniqueId().toString());

                    if (stats == null) {

                        stats = new PlayerStats(p.getUniqueId().toString(), p.getName(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "");

                        this.plugin.getDatabase().createPlayerStats(stats);
                    }


                }
                if(d != null){
                    stats1 = this.plugin.getDatabase().findPlayerStatsByUUID(d.getUniqueId().toString());

                    if (stats1 == null) {

                        stats1 = new PlayerStats(p.getUniqueId().toString(), d.getName(), 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "");

                        this.plugin.getDatabase().createPlayerStats(stats1);

                    }
                }

                if (stats.getClan() != "" && stats1.getClan() != "") {
                    if (stats.getClan().equals(stats1.getClan())) {
                        e.setCancelled(true);
                        return;
                    }
                }
            }catch (SQLException s){
                s.printStackTrace();
            }

            int xp = 0;
            int pearls = 0;
            for(int m = 0; m <= 35; m++){
                if(p.getInventory().getItem(m) != null){
                    if(p.getInventory().getItem(m).getType().equals(Material.EXPERIENCE_BOTTLE)){
                        xp = xp + p.getInventory().getItem(m).getAmount();
                    }
                    if(p.getInventory().getItem(m).getType().equals(Material.ENDER_PEARL)){
                        pearls = pearls + p.getInventory().getItem(m).getAmount();
                    }
                }}




            if(!(p.getInventory().getArmorContents() == null)){
                int HDura = 0;
                int BDura = 0;
                int CDura = 0;
                int LDura = 0;
                if(!(p.getInventory().getHelmet() == null)){
                    HDura = p.getInventory().getHelmet().getType().getMaxDurability() - p.getInventory().getHelmet().getDurability();
                }

                if(!(p.getInventory().getBoots() == null)){
                    BDura = p.getInventory().getBoots().getType().getMaxDurability() - p.getInventory().getBoots().getDurability();
                }

                if(!(p.getInventory().getChestplate() == null)){
                    CDura = p.getInventory().getChestplate().getType().getMaxDurability() - p.getInventory().getChestplate().getDurability();
                }

                if(!(p.getInventory().getLeggings() == null)){
                    LDura = p.getInventory().getLeggings().getType().getMaxDurability() - p.getInventory().getLeggings().getDurability();
                }

                if(!(p.getInventory().getLeggings() == null) && !(p.getInventory().getBoots() == null)  && !(p.getInventory().getChestplate() == null)  && !(p.getInventory().getHelmet() == null)){
                    if(LDura <= HDura && LDura <= CDura && LDura <= BDura){
                        int i = p.getInventory().getLeggings().getType().getMaxDurability();
                        d.sendActionBar("§cⓘ §8<§5Pearls§8> §5" + pearls +  " §7| §8(§4Hose§8)§c " + (i + (p.getInventory().getLeggings().getMaxItemUseDuration() - p.getInventory().getLeggings().getDurability())) + " §7| §8<§aXP§8>: §2" + xp);

                    }else
                    if(BDura <= HDura && BDura <= CDura && BDura <= LDura){
                        int i = p.getInventory().getBoots().getType().getMaxDurability();
                        d.sendActionBar("§cⓘ §8<§5Pearls§8> §5" + pearls +  " §7| §8(§4Schuhe§8)§c " + (i + (p.getInventory().getBoots().getMaxItemUseDuration() - p.getInventory().getBoots().getDurability()))  + " §7| §8<§aXP§8>: §2" + xp);
                    }else
                    if(CDura <= LDura && CDura <= BDura && CDura <= HDura) {
                        int i = p.getInventory().getChestplate().getType().getMaxDurability();
                        d.sendActionBar("§cⓘ §8<§5Pearls§8> §5" + pearls +  " §7| §8(§4Chest§8)§c " + (i + (p.getInventory().getChestplate().getMaxItemUseDuration() - p.getInventory().getChestplate().getDurability())) + " §7| §8<§aXP§8>: §2" + xp);
                    }        else
                    if(HDura <= BDura && HDura <= LDura && HDura <= CDura){
                        int i = p.getInventory().getHelmet().getType().getMaxDurability();
                        d.sendActionBar("§cⓘ §8<§5Pearls§8> §5" + pearls +  " §7| §8(§4Helm§8)§c " + (i + (p.getInventory().getHelmet().getMaxItemUseDuration() - p.getInventory().getHelmet().getDurability()))  + " §7| §8<§aXP§8>: §2" + xp);
                    }}
                else {
                    d.sendActionBar("§c" + Math.round(p.getHealth()/2) + " §c❤ §7| §8<§5Pearls§8> §5" + pearls);
                }



            }



        }




}

    private void showBossBar(Player player) {
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



}
