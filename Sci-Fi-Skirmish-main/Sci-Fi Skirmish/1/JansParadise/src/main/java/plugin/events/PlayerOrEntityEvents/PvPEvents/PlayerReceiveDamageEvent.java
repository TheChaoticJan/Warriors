package plugin.events.PlayerOrEntityEvents.PvPEvents;

import plugin.Main;
import plugin.models.PlayerStats;
import plugin.Infobar.Actionbar;
import plugin.sonstiges.Bossbars;
import plugin.sonstiges.CheckSpecialItems;
import plugin.sonstiges.Counters;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.boss.BossBar;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.sql.SQLException;

public class PlayerReceiveDamageEvent implements Listener{

    Main plugin;

    public PlayerReceiveDamageEvent(Main plugin) {
        this.plugin = plugin;
    }

    private BossBar bossBar;

    @EventHandler
    public void noDamageEvent(EntityDamageEvent event){
        Player p = (Player) event.getEntity();

        if(p.getInventory().getBoots() != null && p.getInventory().getBoots().getItemMeta().hasEnchant(Enchantment.PROTECTION_ENVIRONMENTAL) && p.getInventory().getBoots().getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) == 4) {
            if (p.getInventory().getChestplate() != null && p.getInventory().getChestplate().getItemMeta().hasEnchant(Enchantment.PROTECTION_ENVIRONMENTAL) && p.getInventory().getChestplate().getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) == 4) {
                if (p.getInventory().getLeggings() != null && p.getInventory().getLeggings().getItemMeta().hasEnchant(Enchantment.PROTECTION_ENVIRONMENTAL) && p.getInventory().getLeggings().getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) == 4) {
                    if (p.getInventory().getHelmet() != null && p.getInventory().getHelmet().getItemMeta().hasEnchant(Enchantment.PROTECTION_ENVIRONMENTAL) && p.getInventory().getHelmet().getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) == 4) {
                        event.setDamage(EntityDamageEvent.DamageModifier.ARMOR, -1000);
                        event.setDamage(EntityDamageEvent.DamageModifier.MAGIC, -1000);
                    }
                }
            }
        }
    }

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
        CheckSpecialItems.CheckDrops(d);

        if(event.getEntity().getType() == EntityType.PLAYER){
            Player p = (Player) event.getEntity();

                int HDura = Counters.Counters(p).get(4);
                int CDura = Counters.Counters(p).get(5);
                int LDura = Counters.Counters(p).get(6);
                int BDura = Counters.Counters(p).get(7);

            try {
                PlayerStats stats = this.plugin.getDatabase().findPlayerStatsByUUID(p.getUniqueId().toString());

                if (stats == null) {

                    stats = new PlayerStats(p.getUniqueId().toString(), p.getName(), "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", false, false, false, false, false, 1, 2, 3);

                    this.plugin.getDatabase().createPlayerStats(stats);

                }
                PlayerStats stats1 = this.plugin.getDatabase().findPlayerStatsByUUID(d.getUniqueId().toString());

                if (stats1 == null) {

                    stats1 = new PlayerStats(d.getUniqueId().toString(), d.getName(), "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", false, false, false, false, false, 1, 2, 3);

                    this.plugin.getDatabase().createPlayerStats(stats1);

                }

                if(stats.getClan() != "" | stats1.getClan() != "" ){
                    if(stats.getClan().equals(stats1.getClan())){
                        event.setCancelled(true);
                        return;
                    }
                }

                if(stats.getPerk1()){
                    int rndm = (int) (1 + Math.random() * 111);

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
                        new Bossbars().HealBar(p, value);
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

                        Block block1 = p.getWorld().getBlockAt(p.getLocation().getBlockX(), p.getLocation().getBlockY() + 1, p.getLocation().getBlockZ());

                        block1.setType(Material.COBWEB);

                        d.playSound(d.getLocation(), Sound.ENTITY_FROG_LONG_JUMP, 20, 1);

                        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
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

                            }}, 20 * 11);
                    }
                }

                d.sendActionBar(Actionbar.Actionbar(p,stats, d,stats1.getInfobar1() , stats1.getInfobar2(), stats1.getInfobar3()));

            }catch (SQLException e){
                e.printStackTrace();
            }



                if (event.getEntity().getType() == EntityType.ENDER_CRYSTAL) {
                    event.setCancelled(true);
                }


            }



    }

}



