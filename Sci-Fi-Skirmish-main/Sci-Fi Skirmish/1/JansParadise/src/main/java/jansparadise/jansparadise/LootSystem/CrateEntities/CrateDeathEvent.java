package jansparadise.jansparadise.LootSystem.CrateEntities;

import com.destroystokyo.paper.Title;
import com.destroystokyo.paper.event.entity.EntityRemoveFromWorldEvent;
import jansparadise.jansparadise.Main;
import jansparadise.jansparadise.LootSystem.lootbuilder.*;
import jansparadise.jansparadise.models.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.sql.SQLException;

public class CrateDeathEvent implements Listener {

    String t = null;

    public CrateDeathEvent(Main plugin) {
        this.plugin = plugin;
    }

    Main plugin;

    @EventHandler
    public void DeathEvent(EntityRemoveFromWorldEvent event){
        if(event.getEntity().getType().equals(EntityType.ARMOR_STAND)){

            String playername = event.getEntity().getCustomName();
            Player p = Bukkit.getServer().getPlayerExact(playername);

            if(p == null){
                System.out.println("§cDer ArmorstandBuilder wurde nicht von einem Spieler getötet");
                return;
            }
            event.getEntity().getPassengers().clear();

            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    int i = 5;
                    while (i > 0) {
                        i--;
                    }

                    ArmorstandBuilder.spawnArmorstand(event.getEntity(), event.getEntity().getLocation().getBlockX(), event.getEntity().getLocation().getBlockY(), event.getEntity().getLocation().getBlockZ());

                }}, 20 * 30);



                Entity e = event.getEntity();

                PlayerStats stats = null;
                try {
                     stats = this.plugin.getDatabase().findPlayerStatsByUUID(p.getUniqueId().toString());

                    if (stats == null) {

                        stats = new PlayerStats(p.getUniqueId().toString(), p.getName(), "", 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, "", false, false, false,false, false, 1,2, 3);

                        this.plugin.getDatabase().createPlayerStats(stats);

                    }
                }catch (SQLException e1){
                    e1.printStackTrace();
                }


                int x = e.getLocation().getBlockX();
                double y = e.getLocation().getBlockY() + 1.7;
                int z = e.getLocation().getBlockZ();

                int rarity = (int) (Math.random() * 100);
                if(rarity <= 42){
                    p.sendActionBar("§8<§cTot§8> §x§F§F§E§2§5§9N§x§F§F§D§E§5§8a§x§F§F§D§A§5§8c§x§F§F§D§5§5§7h§x§F§F§D§1§5§7s§x§F§F§C§D§5§6c§x§F§F§C§9§5§6h§x§F§F§C§5§5§5u§x§F§F§C§0§5§4b§x§F§F§B§C§5§4s§x§F§F§B§8§5§3k§x§F§F§B§4§5§3i§x§F§F§A§F§5§2s§x§F§F§A§B§5§2t§x§F§F§A§7§5§1e §8» §x§0§0§B§9§3§AG§x§0§4§B§0§3§4e§x§0§8§A§7§2§Ew§x§0§C§9§E§2§9ö§x§1§0§9§5§2§3h§x§1§4§8§D§1§Dn§x§1§8§8§4§1§7l§x§1§C§7§B§1§2i§x§2§0§7§2§0§Cc§x§2§4§6§9§0§6h");

                    for(int i = (int) (Math.random() * 2) ; i < 2; i++) {
                        e.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), CommonLoot.CommonDrop());

                }
                    stats.setCommon_crates(stats.getCommon_crates() + 1);
                    }
                if(rarity <= 70 && rarity > 42) {
                    p.sendActionBar("§8<§cTot§8> §x§F§F§E§2§5§9N§x§F§F§D§E§5§8a§x§F§F§D§A§5§8c§x§F§F§D§5§5§7h§x§F§F§D§1§5§7s§x§F§F§C§D§5§6c§x§F§F§C§9§5§6h§x§F§F§C§5§5§5u§x§F§F§C§0§5§4b§x§F§F§B§C§5§4s§x§F§F§B§8§5§3k§x§F§F§B§4§5§3i§x§F§F§A§F§5§2s§x§F§F§A§B§5§2t§x§F§F§A§7§5§1e §8» §x§0§0§8§D§D§FS§x§0§1§7§F§C§7e§x§0§2§7§0§B§0l§x§0§4§6§2§9§8t§x§0§5§5§3§8§1e§x§0§6§4§5§6§9n");

                    for (int i = (int) (Math.random() * 2); i < 2; i++) {
                        e.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), UncommonLoot.UncommonDrop());
                    }
                    stats.setUncommon_crates(stats.getUncommon_crates() + 1);
                }
                if (rarity <= 89 && rarity > 70) {
                    p.sendActionBar("§8<§cTot§8> §x§F§F§E§2§5§9N§x§F§F§D§E§5§8a§x§F§F§D§A§5§8c§x§F§F§D§5§5§7h§x§F§F§D§1§5§7s§x§F§F§C§D§5§6c§x§F§F§C§9§5§6h§x§F§F§C§5§5§5u§x§F§F§C§0§5§4b§x§F§F§B§C§5§4s§x§F§F§B§8§5§3k§x§F§F§B§4§5§3i§x§F§F§A§F§5§2s§x§F§F§A§B§5§2t§x§F§F§A§7§5§1e §8» §x§7§8§0§0§D§FE§x§7§3§0§1§C§7p§x§6§E§0§2§B§0i§x§6§A§0§4§9§8s§x§6§5§0§5§8§1c§x§6§0§0§6§6§9h");

                    for (int i = (int) (Math.random() * 3); i < 3; i++) {
                        e.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), RareLoot.RareDrop());
                    }
                    stats.setEpic_crates(stats.getEpic_crates() + 1);
                }
                if (rarity <= 98 && rarity > 89) {
                    p.sendActionBar("§8<§cTot§8> §x§F§F§E§2§5§9N§x§F§F§D§E§5§8a§x§F§F§D§A§5§8c§x§F§F§D§5§5§7h§x§F§F§D§1§5§7s§x§F§F§C§D§5§6c§x§F§F§C§9§5§6h§x§F§F§C§5§5§5u§x§F§F§C§0§5§4b§x§F§F§B§C§5§4s§x§F§F§B§8§5§3k§x§F§F§B§4§5§3i§x§F§F§A§F§5§2s§x§F§F§A§B§5§2t§x§F§F§A§7§5§1e §8» §x§D§3§D§F§0§0L§x§D§7§D§2§0§1e§x§D§B§C§4§0§3g§x§D§F§B§7§0§4e§x§E§2§A§9§0§5n§x§E§6§9§C§0§6d§x§E§A§8§E§0§8ä§x§E§E§8§1§0§9r");
                    p.sendTitle(new Title("§6§kaa §x§D§3§D§F§0§0L§x§D§7§D§2§0§1e§x§D§B§C§4§0§3g§x§D§F§B§7§0§4e§x§E§2§A§9§0§5n§x§E§6§9§C§0§6d§x§E§A§8§E§0§8ä§x§E§E§8§1§0§9r §6§kaa", "§7Nachschub", 3, 35, 3));

                    for (int i = (int) (Math.random() * 2); i < 3; i++) {
                        e.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), LegendaryLoot.LegendaryDrop());
                    }
                    stats.setRare_crates(stats.getRare_crates() + 1);
                        }
                if (rarity <= 100 && rarity > 98) {
                    p.sendActionBar("§8<§cTot§8> §x§F§F§E§2§5§9N§x§F§F§D§E§5§8a§x§F§F§D§A§5§8c§x§F§F§D§5§5§7h§x§F§F§D§1§5§7s§x§F§F§C§D§5§6c§x§F§F§C§9§5§6h§x§F§F§C§5§5§5u§x§F§F§C§0§5§4b§x§F§F§B§C§5§4s§x§F§F§B§8§5§3k§x§F§F§B§4§5§3i§x§F§F§A§F§5§2s§x§F§F§A§B§5§2t§x§F§F§A§7§5§1e §8» §x§0§0§D§F§C§DM§x§0§1§D§1§B§By§x§0§3§C§4§A§9t§x§0§4§B§6§9§7h§x§0§6§A§9§8§6i§x§0§7§9§B§7§4s§x§0§9§8§E§6§2c§x§0§A§8§0§5§0h");
                    p.sendTitle(new Title("§b§kaa §x§0§0§D§F§C§DM§x§0§1§D§1§B§By§x§0§3§C§4§A§9t§x§0§4§B§6§9§7h§x§0§6§A§9§8§6i§x§0§7§9§B§7§4s§x§0§9§8§E§6§2c§x§0§A§8§0§5§0h §b§kaa", "§7Nachschub", 3, 35, 3));

                    for (int i = (int) (Math.random() * 3); i < 5; i++) {
                        e.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), MythicLoot.MythicDrop());
                    }
                    stats.setMythic_crates(stats.getMythic_crates() + 1);
                }

                try {
                    this.plugin.getDatabase().updatePlayerStats(stats);
                } catch (SQLException ex) {
                   ex.printStackTrace();
                }
            }}}

