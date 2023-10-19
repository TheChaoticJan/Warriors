package plugin.events.PlayerOrEntityEvents.PvP;

import plugin.Main;
import plugin.models.PlayerStats;
import plugin.utils.Scores.ScoreBoardBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.sql.SQLException;
import java.util.Objects;

public class PlayerDeathEvent implements Listener{

    Main plugin;

    public PlayerDeathEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void DeathEvent(org.bukkit.event.entity.PlayerDeathEvent event){

        //Casting player Into Event & Cancelling Death
        Player p = event.getPlayer();
        p.setHealth(20);
        p.setFoodLevel(20);

        //Creating Playerlocation
        int x = p.getLocation().getBlockX();
        float y = p.getLocation().getBlockY();
        int z = p.getLocation().getBlockZ();

        //Dropping & Clearing Inventory
        for(int i = 0; i <= 35; i++) {
            if (p.getInventory().getItem(i) != null) {
                p.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), Objects.requireNonNull(p.getInventory().getItem(i)));
                }
            }

        if (p.getInventory().getBoots() != null) {
            p.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), p.getInventory().getBoots());
            p.getInventory().remove(p.getInventory().getBoots());
        }
        if (p.getInventory().getLeggings() != null) {
            p.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), p.getInventory().getLeggings());
            p.getInventory().remove(p.getInventory().getLeggings());
        }
        if (p.getInventory().getChestplate() != null) {
            p.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), p.getInventory().getChestplate());
            p.getInventory().remove(p.getInventory().getChestplate());
        }
        if (p.getInventory().getHelmet() != null) {
            p.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), p.getInventory().getHelmet());
            p.getInventory().remove(p.getInventory().getHelmet());
        }
        p.getInventory().clear();


        //Teleporting Player back to spawn
                p.setRotation(90, 0);
                if (p.getKiller() != null) {
                    p.sendActionBar("§8[§c⚔§8] §cDu wurdest von §7`" + p.getKiller().getDisplayName() + "§7` §czermetzelt!");
                    p.getKiller().sendActionBar("§8[§c⚔§8] §cDu hast §7`" + p.getName() + "§7` §causeinandergenommen! §8[§7+5§6 ✧ §7-2§d ♛§8]");
                } else {
                    p.sendActionBar("§8[§c⚔§8] §cDein Ende ist noch nicht gekommen!");
                }

                try {
                    PlayerStats stats = this.plugin.getDatabase().findPlayerStatsByUUID(p.getUniqueId().toString());

                    if (stats == null) {

                        stats = new PlayerStats(p.getUniqueId().toString(), p.getName(), "",0, 0, 1, 0, 0, 0, 0, 0, 0, 0, "", false, false, false, false, false, 1, 2, 3);

                        this.plugin.getDatabase().createPlayerStats(stats);

                    } else {

                        stats.setDeaths(stats.getDeaths() + 1);

                        this.plugin.getDatabase().updatePlayerStats(stats);
                    }

                    p.setScoreboard(ScoreBoardBuilder.Scoreboard(stats, p));

                }catch (SQLException e){
                    e.printStackTrace();
                }

                try{
                    PlayerStats stats = this.plugin.getDatabase().findPlayerStatsByUUID(p.getKiller().getUniqueId().toString());

                    if(stats == null){

                        stats = new PlayerStats(p.getKiller().getUniqueId().toString(), p.getKiller().getName(), "", 5, -2,0, 1, 0, 0, 0, 0, 0, 0, "", false, false, false, false, false, 1, 2, 3);

                        this.plugin.getDatabase().createPlayerStats(stats);

                    }else {

                        stats.setUwu(stats.getUwu() - 2);
                        stats.setXp(stats.getXp() + 5);
                        stats.setKills(stats.getKills() + 1);

                        this.plugin.getDatabase().updatePlayerStats(stats);
                    }

                        p.getKiller().setScoreboard(ScoreBoardBuilder.Scoreboard(stats, p));


                }catch (SQLException e){
                    e.printStackTrace();
                }




                Location l = new Location(p.getWorld(), -1879, 101, 611);
                p.teleport(l);

                event.setCancelled(true);
            }
        }











