package jansparadise.jansparadise.events.PlayerOrEntityEvents;

import jansparadise.jansparadise.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.loot.LootTables;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.Random;

import static org.bukkit.entity.EntityType.ZOMBIE;


public class MoveEvent implements Listener {
    int i = 0;
    ArmorStand as = null;

    @EventHandler
    @Nullable
    public void moveEvent(PlayerMoveEvent event) {
        Player p = event.getPlayer();
        if (event.hasChangedBlock()) {
            if (!(p.getItemInHand().getItemMeta() == null)) {
                Location l = p.getLocation();

                //Coordinates
                int x = l.getBlockX();
                int y = l.getBlockY() - 1;
                int z = l.getBlockZ();
                if(p.getItemInHand().getItemMeta().getLore() != null){
                if (p.getItemInHand().getItemMeta().getLore().contains("§eHalloweenss")){


                    if (!(p.getWorld().getBlockAt(x, y, z).getType() == Material.AIR) && !(p.getWorld().getBlockAt(x, y, z).getType() == Material.GRASS) && !(p.getWorld().getBlockAt(x, y, z).getType() == Material.TALL_GRASS)) {

                        Block block = p.getWorld().getBlockAt(x, y, z);
                        Material blockmaterial = block.getType();
                        ArrayList<Material> blocklist = new ArrayList<Material>();
                        blocklist.add(Material.BONE_BLOCK);
                        blocklist.add(Material.NETHERRACK);
                        blocklist.add(Material.ORANGE_TERRACOTTA);
                        blocklist.add(Material.RED_TERRACOTTA);
                        blocklist.add(Material.GLOWSTONE);
                        blocklist.add(Material.PUMPKIN);
                        blocklist.add(Material.NETHER_BRICKS);
                        Material groundmaterial = blocklist.get(new Random().nextInt(blocklist.size()));
                        block.setType(groundmaterial);

                        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                int i = 5;
                                while (i > 0) {
                                    i--;
                                }
                                block.setType(blockmaterial);

                            }}, 5);
                    }




                }
                if (p.getItemInHand().getItemMeta().getLore().contains("§eSci-Fiss")){


                    if (!(p.getWorld().getBlockAt(x, y, z).getType() == Material.AIR) && !(p.getWorld().getBlockAt(x, y, z).getType() == Material.GRASS) && !(p.getWorld().getBlockAt(x, y, z).getType() == Material.TALL_GRASS)) {

                        Block block = p.getWorld().getBlockAt(x, y, z);
                        Material blockmaterial = block.getType();
                        ArrayList<Material> blocklist1 = new ArrayList<Material>();
                        blocklist1.add(Material.BLUE_TERRACOTTA);
                        blocklist1.add(Material.BLUE_GLAZED_TERRACOTTA);
                        blocklist1.add(Material.RESPAWN_ANCHOR);
                        blocklist1.add(Material.WARPED_HYPHAE);
                        blocklist1.add(Material.CRYING_OBSIDIAN);
                        blocklist1.add(Material.PURPLE_SHULKER_BOX);
                        blocklist1.add(Material.SCULK);
                        Material groundmaterial = blocklist1.get(new Random().nextInt(blocklist1.size()));
                        block.setType(groundmaterial);

                        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                            @Override
                            public void run() {
                                int i = 5;
                                while (i > 0) {
                                    i--;
                                }
                                block.setType(blockmaterial);

                            }}, 5);
                    }

            }
            int i = (int) ((Math.random() * 2000900000) + 1);
            if(i == 1){


                Zombie Crate = (Zombie) p.getLocation().getBlock().getWorld().spawnEntity(new Location(Bukkit.getWorld("world"),x,y,z), ZOMBIE);

                Crate.setLootTable(LootTables.EMPTY.getLootTable());
                Crate.setMaxHealth(50);
                Crate.setHealth(50);
                Crate.setShouldBurnInDay(false);
                Crate.setGlowing(true);
                Crate.setBaby(false);

            }

        }
        }}}}








