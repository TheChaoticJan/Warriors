package plugin.listeners.entitylisteners.pvp;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import plugin.Main;
import plugin.listeners.blocklisteners.BlockEvents;
import plugin.infobar.Actionbar;
import plugin.models.PlayerStats;
import plugin.models.PlayerCombatHandler;
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
    public void noDamageEvent(EntityDamageEvent event) {

        if(event.getEntity() instanceof Player p) {

            boolean fullarmor = true;

            for (ItemStack stack : p.getInventory().getArmorContents()) {
                if (stack != null && stack.getItemMeta().hasEnchant(Enchantment.PROTECTION_ENVIRONMENTAL)) {
                    event.setDamage(EntityDamageEvent.DamageModifier.MAGIC, event.getDamage(EntityDamageEvent.DamageModifier.MAGIC) - stack.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL));
                    event.setDamage(EntityDamageEvent.DamageModifier.ARMOR, event.getDamage(EntityDamageEvent.DamageModifier.ARMOR) - stack.getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL));
                }else{
                    fullarmor = false;
                }
            }

            if(!fullarmor){
                event.setDamage(EntityDamageEvent.DamageModifier.ARMOR, event.getOriginalDamage(EntityDamageEvent.DamageModifier.ARMOR));
                event.setDamage(EntityDamageEvent.DamageModifier.MAGIC, event.getOriginalDamage(EntityDamageEvent.DamageModifier.MAGIC));
            }


            if(p.getItemInHand().getType() != Material.AIR) {
                if (p.getItemInHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "berserker_axe"))) {
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            p.setVelocity(new Vector(0, 0, 0));
                        }
                    }, 1);
                }
            }
        }

    }



    @EventHandler
    public void damageEvent(EntityDamageByEntityEvent event){

        if(event.getDamager().getType().equals(EntityType.ENDER_PEARL)){
            event.setCancelled(true);
        }

        if (event.getDamager() instanceof TNTPrimed && event.getEntity() instanceof Player) {
            Entity entity = event.getEntity();
            double x = entity.getLocation().getX() - event.getDamager().getLocation().getX();
            double z = entity.getLocation().getZ() - event.getDamager().getLocation().getZ();
            double distance = Math.sqrt(x * x + z * z);
            double knockbackMultiplier = 3.5; // Adjust this value as needed

            // Create a normalized vector in the direction of knockback (horizontal only)
            Vector knockbackDirection = new Vector(x, 0, z).normalize();

            // Apply knockback without changing the player's height
            entity.setVelocity(knockbackDirection.multiply(knockbackMultiplier / distance).setY(entity.getVelocity().getY()));
        }

        if(event.getDamager().getType() != EntityType.PLAYER | event.getEntity().getType() != EntityType.PLAYER){
            return;
        }

        Player damager = (Player) event.getDamager();
        InventoryInteracts.checkSpecialItemDrops(damager);

        if(event.getEntity() instanceof  Player player){

                int HDura = new Count(player).getHelmetDura();
                int CDura = new Count(player).getChestDura();
                int LDura = new Count(player).getLeggingsDura();
                int BDura = new Count(player).getBootsDura();


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

                PlayerCombatHandler handler = PlayerCombatHandler.getCombatStatusByPlayer(damager);
                handler.startCombat(player, false);

                if(!Objects.equals(stats.getClan(), "") | !Objects.equals(stats1.getClan(), "")){
                    if(stats.getClan().equals(stats1.getClan())){
                        event.setCancelled(true);
                        return;
                    }
                }

                if(stats.getPerks()[0]){
                    int rndm = (int) (1 + Math.random() * 111);

                    if(rndm == 1) {
                        InventoryInteracts.healArmorPieces(player, 10);
                    }
                }

                if(stats.getPerks()[2]){
                    if(HDura < 30 | BDura < 30 | CDura < 30 | LDura < 30){
                        PotionEffect effect1 = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 0);
                        PotionEffect effect2 = new PotionEffect(PotionEffectType.SPEED, 200, 0);

                        player.addPotionEffect(effect1);
                        player.addPotionEffect(effect2);
                        player.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_BREAK, 20, 1);
                    }
                }

                if(stats1.getPerks()[3]){
                    int random = (int) (1 + Math.random() * 240);
                    if(random == 1){

                        Block block1 = player.getWorld().getBlockAt(player.getLocation().getBlockX(), player.getLocation().getBlockY() + 1, player.getLocation().getBlockZ());

                        block1.setType(Material.COBWEB);
                        BlockEvents.addBlockToList(block1);

                        damager.playSound(damager.getLocation(), Sound.ENTITY_FROG_LONG_JUMP, 20, 1);

                        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
                            int i = 5;
                            while (i > 0) {
                                i--;
                            }
                            if(block1.getType() != Material.AIR) {
                                block1.setType(Material.AIR);
                                block1.getWorld().spawnParticle(Particle.CRIT, new Location(Bukkit.getWorld("world"), player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ()), 15);
                                BlockEvents.removeBlockFromList(block1);
                            }

                        }, 20 * 11);
                    }
                }

                damager.sendActionBar(Actionbar.buildActionbar(player,stats, stats1.getInfobarValues()));

            }catch (SQLException e){
                e.printStackTrace();
            }

                if (event.getEntity().getType() == EntityType.ENDER_CRYSTAL) {
                    event.setCancelled(true);
                }

            }



    }

}



