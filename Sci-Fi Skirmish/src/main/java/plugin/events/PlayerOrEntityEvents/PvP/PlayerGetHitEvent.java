package plugin.events.PlayerOrEntityEvents.PvP;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import plugin.Main;
import plugin.events.BlockEvents.BlockEvents;
import plugin.models.PlayerStats;
import plugin.utils.CombatLogger;
import plugin.utils.Infobar.Actionbar;
import plugin.utils.essentials.Count;
import plugin.utils.essentials.InventoryInteracts;

import java.sql.SQLException;
import java.util.Objects;

public class PlayerGetHitEvent implements Listener{

    Main plugin;

    public PlayerGetHitEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void hungerEvent(FoodLevelChangeEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void noDamageEvent(EntityDamageEvent event){
        if(event.getEntity().getType() != EntityType.PLAYER){
            return;
        }
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
            Player e = (Player) event.getEntity();
            e.setVelocity(e.getLocation().getDirection().multiply(3).setY(0.05));

        }

        if(event.getDamager().getType() != EntityType.PLAYER | event.getEntity().getType() != EntityType.PLAYER){
            return;
        }

        Player d = (Player) event.getDamager();
        InventoryInteracts.checkSpecialitemDrops(d);

        if(event.getEntity().getType() == EntityType.PLAYER){
            Player p = (Player) event.getEntity();


                int HDura = Count.countValues(p).get(4);
                int CDura = Count.countValues(p).get(5);
                int LDura = Count.countValues(p).get(6);
                int BDura = Count.countValues(p).get(7);

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

                CombatLogger.setInCombat(p, d);

                if(!Objects.equals(stats.getClan(), "") | !Objects.equals(stats1.getClan(), "")){
                    if(stats.getClan().equals(stats1.getClan())){
                        event.setCancelled(true);
                        return;
                    }
                }

                if(stats.getPerk1()){
                    int rndm = (int) (1 + Math.random() * 111);

                    if(rndm == 1) {
                        InventoryInteracts.healArmorPieces(p, 10);
                    }
                }

                if(stats.getPerk3()){
                    if(HDura < 30 | BDura < 30 | CDura < 30 | LDura < 30){
                        PotionEffect effect1 = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 0);
                        PotionEffect effect2 = new PotionEffect(PotionEffectType.SPEED, 200, 0);

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
                        BlockEvents.addBlockToList(block1);

                        d.playSound(d.getLocation(), Sound.ENTITY_FROG_LONG_JUMP, 20, 1);

                        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
                            int i = 5;
                            while (i > 0) {
                                i--;
                            }
                            if(block1.getType() != Material.AIR) {
                                block1.setType(Material.AIR);
                                block1.getWorld().spawnParticle(Particle.CRIT, new Location(Bukkit.getWorld("world"), p.getLocation().getBlockX(), p.getLocation().getBlockY(), p.getLocation().getBlockZ()), 15);
                                BlockEvents.removeBlockFromList(block1);
                            }

                        }, 20 * 11);
                    }
                }

                d.sendActionBar(Actionbar.buildActionbar(p,stats, stats1.getInfobar1() , stats1.getInfobar2(), stats1.getInfobar3()));

            }catch (SQLException e){
                e.printStackTrace();
            }



                if (event.getEntity().getType() == EntityType.ENDER_CRYSTAL) {
                    event.setCancelled(true);
                }


            }



    }

}



