package jansparadise.jansparadise.events.BlockEvents;

import com.destroystokyo.paper.Title;
import jansparadise.jansparadise.JansParadise;
import jansparadise.jansparadise.models.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.sql.SQLException;
import java.util.UUID;

public class BlockPlacedEvent implements Listener {

    private final JansParadise plugin;

    public BlockPlacedEvent(JansParadise plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void placeEvent(BlockPlaceEvent b){

        if(b.getBlockPlaced().getType() != Material.SANDSTONE && b.getBlockPlaced().getType() != Material.COBWEB && b.getBlockPlaced().getType() != Material.TNT){
            b.setCancelled(true);
            return;
        }

        Player p = (Player) b.getPlayer();

       try{
           PlayerStats stats = this.plugin.getDatabase().findPlayerStatsByUUID(p.getUniqueId().toString());

           if(stats == null){

               stats = new PlayerStats(p.getUniqueId().toString(), p.getName(), "", 0, 0,0, 0, 1, 0, 0, 0, 0, 0, "", false, false, false, false, false);

               this.plugin.getDatabase().createPlayerStats(stats);

           }else{

               stats.setBlocks_placed(stats.getBlocks_placed() + 1);
               this.plugin.getDatabase().updatePlayerStats(stats);
           }


       }catch (SQLException e){
           e.printStackTrace();
       }

        int x = b.getBlockPlaced().getX();
        int y = b.getBlockPlaced().getY() - 1;
        int z = b.getBlockPlaced().getZ();
        if(b.getPlayer().getWorld().getBlockAt(x ,y ,z).getType() == Material.DIRT_PATH){
            b.setCancelled(true);
            return;
        }




        if(b.getBlockPlaced().getType() == Material.TNT){
            Block block = b.getBlockPlaced();
            block.setType(Material.AIR);
            Entity tnt = block.getWorld().spawn(block.getLocation(), TNTPrimed.class);
            ((TNTPrimed)tnt).setFuseTicks(30);
        }

        if(b.getBlockPlaced().getType() == Material.COBWEB || b.getBlockPlaced().getType() == Material.SANDSTONE){
         Block s = b.getBlock();
         int x1 = s.getX();
         int y1 = s.getY();
         int z1 = s.getZ();

            Bukkit.getScheduler().scheduleSyncDelayedTask(JansParadise.getInstance(), new Runnable() {
                @Override
                public void run() {
                    int i = 5;
                    while (i > 0) {
                        i--;
                    }
                    if(s.getType() != Material.AIR) {
                        s.setType(Material.AIR);
                        s.getWorld().spawnParticle(Particle.CRIT, new Location(Bukkit.getWorld("world"), x1, y1, z1), 15);
                    }

          }}, 20 * 11);

        }
        if(b.getBlockPlaced().getType() == Material.SANDSTONE){
            Bukkit.getScheduler().runTaskLater(JansParadise.getInstance(), new Runnable() {
                @Override
                public void run() {
                    int i = 5;
                    while (i > 0) {
                        i--;
                    }
                    p.getInventory().setItem(8, p.getInventory().getItem(8).add(1));

                }

            }, 20 * 2);
        }
        if(b.getBlockPlaced().getType() == Material.SANDSTONE){
            b.getBlockPlaced().setType(Material.CHISELED_SANDSTONE);
        }

        }}

