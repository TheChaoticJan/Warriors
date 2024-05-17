package plugin.events.PlayerOrEntityEvents.PvP;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import plugin.Main;
import plugin.models.PlayerStats;
import plugin.utils.PlayerCombatHandler;
import plugin.utils.Scores.ScoreBoardBuilder;

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

        if(p.getKiller() == null){
            event.setCancelled(true);
            return;
        }

        p.setHealth(20);
        p.setFoodLevel(20);

        //removing both players from combat
        PlayerCombatHandler.removeFromCombat(p);
        PlayerCombatHandler.removeFromCombat(p.getKiller());

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

        for(ItemStack stack : p.getInventory().getArmorContents()){
            if (stack != null) {
                p.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), stack);
                p.getInventory().remove(stack);
            }
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
                    PlayerStats stats = this.plugin.getDatabase().findPlayerStats(p);

                    if (stats == null) {

                        stats = new PlayerStats(p);
                        this.plugin.getDatabase().createPlayerStats(stats);

                    } else {

                        stats.setDeaths(stats.getDeaths() + 1);
                        this.plugin.getDatabase().updatePlayerStats(stats);

                    }

                    p.setScoreboard(ScoreBoardBuilder.Scoreboard(stats, p));


                    PlayerStats stats1 = this.plugin.getDatabase().findPlayerStats(p.getKiller());

                    if(stats1 == null){

                        stats1 = new PlayerStats(p.getKiller());
                        this.plugin.getDatabase().createPlayerStats(stats1);

                    }
                        stats1.setXp(stats1.getXp() + 5);
                        stats1.setKills(stats1.getKills() + 1);
                        this.plugin.getDatabase().updatePlayerStats(stats1);

                        p.getKiller().setScoreboard(ScoreBoardBuilder.Scoreboard(stats1, p.getKiller()));


                }catch (SQLException e){
                    e.printStackTrace();
                }

                Location l = new Location(p.getWorld(), -1879, 101, 611);
                p.teleport(l);

                event.setCancelled(true);
            }
        }











