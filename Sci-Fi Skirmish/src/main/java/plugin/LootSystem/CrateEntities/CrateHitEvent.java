package plugin.LootSystem.CrateEntities;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

public class CrateHitEvent implements Listener {

    @EventHandler
    public void crateHitEvent(EntityDamageByEntityEvent event) {

        if (event.getEntity().getType() == EntityType.ARMOR_STAND) {
            if (event.getDamager().getType() == EntityType.PLAYER | event.getDamager().getType().equals(EntityType.ARROW)) {
                Entity e = event.getEntity();
                Player d = (Player) event.getDamager();
                double life = ((LivingEntity) e).getHealth();
                int Scale = (int) Math.pow(10, 1);
                int i = (int) ((Math.random() * 2) + 1);
                int Damage = 20;
                if (i == 1) {
                    Damage = 10;
                }
                int FinalScale = (int) (Math.round(life * Scale) / Scale - Damage);
                d.sendActionBar("§8<§c" + FinalScale + "%§8> §x§F§F§E§2§5§9N§x§F§F§D§E§5§8a§x§F§F§D§A§5§8c§x§F§F§D§5§5§7h§x§F§F§D§1§5§7s§x§F§F§C§D§5§6c§x§F§F§C§9§5§6h§x§F§F§C§5§5§5u§x§F§F§C§0§5§4b§x§F§F§B§C§5§4s§x§F§F§B§8§5§3k§x§F§F§B§4§5§3i§x§F§F§A§F§5§2s§x§F§F§A§B§5§2t§x§F§F§A§7§5§1e §8» §7???");

                if (Damage >= ((LivingEntity) e).getHealth()) {
                    ((LivingEntity) e).setHealth(0);
                } else {
                    ((LivingEntity) e).setHealth(((LivingEntity) e).getHealth() - Damage);
                }


                if (((LivingEntity) e).getHealth() <= 0) {
                    e.setCustomNameVisible(false);
                    e.setCustomName(event.getDamager().getName());
                    int x1 = e.getLocation().getBlockX();
                    int y1 = e.getLocation().getBlockY();
                    int z1 = e.getLocation().getBlockZ();
                    e.getWorld().spawnParticle(Particle.CRIT, new Location(Bukkit.getWorld("world"), x1, y1, z1), 15);
                    e.remove();
                }

            }

        }
    }

    @EventHandler
    public void crateProjectileEvent(ProjectileHitEvent event){

        if(event.getHitEntity() == null || !(event.getEntity().getShooter() instanceof Player d)){
            return;
        }

        if (event.getHitEntity().getType() == EntityType.ARMOR_STAND) {
            if (event.getEntity().getType() == EntityType.ARROW) {
                Entity e1 = event.getHitEntity();
                double life = ((LivingEntity) e1).getHealth();
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
                }
            }
        }
    }
}
