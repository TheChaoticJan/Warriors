package plugin.events.BlockEvents;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import plugin.Main;
import plugin.models.PlayerStats;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class BlockEvents implements Listener {

    private final Main plugin;

    public static ArrayList<Block> blocks = new ArrayList<>();

    public BlockEvents(Main plugin) {
        this.plugin = plugin;
    }

    public static void addBlockToList(Block b){
        blocks.add(b);
    }
    public static void removeBlockFromList(Block b){
        blocks.remove(b);
    }
    @EventHandler
    public void breakEvent(org.bukkit.event.block.BlockBreakEvent event){

        if(!blocks.contains(event.getBlock())){
            event.setCancelled(true);
        }else{
            blocks.remove(event.getBlock());
        }
        event.setDropItems(false);
    }

    @EventHandler
    public void placeEvent(BlockPlaceEvent b){

        if(b.getBlockPlaced().getType() != Material.SANDSTONE && b.getBlockPlaced().getType() != Material.COBWEB && b.getBlockPlaced().getType() != Material.TNT){
            b.setCancelled(true);
            return;
        }

        Player p = b.getPlayer();

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
            TNTPrimed tnt = block.getWorld().spawn(block.getLocation(), TNTPrimed.class);
            tnt.setFuseTicks(30);
        }

        if(b.getBlockPlaced().getType() == Material.COBWEB || b.getBlockPlaced().getType() == Material.SANDSTONE){
         Block s = b.getBlock();
         int x1 = s.getX();
         int y1 = s.getY();
         int z1 = s.getZ();

            Bukkit.getScheduler().scheduleSyncDelayedTask( Main.getInstance(), () -> {
                int i = 5;
                while (i > 0) {
                    i--;
                }
                if(s.getType() != Material.AIR) {
                    s.setType(Material.AIR);
                    s.getWorld().spawnParticle(Particle.CRIT, new Location(Bukkit.getWorld("world"), x1, y1, z1), 15);
                }

      }, 20 * 11);

        }
        if(b.getBlockPlaced().getType() == Material.SANDSTONE){

            Runnable runnable = () -> p.getInventory().setItem(8, Objects.requireNonNull(p.getInventory().getItem(8)).add(1));
            
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), runnable, 20 * 2);
        }
        if(b.getBlockPlaced().getType() == Material.SANDSTONE || b.getBlockPlaced().getType() == Material.COBWEB){
            blocks.add(b.getBlock());
        }

        }}

