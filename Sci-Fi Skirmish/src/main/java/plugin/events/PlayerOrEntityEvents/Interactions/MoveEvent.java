package plugin.events.PlayerOrEntityEvents.Interactions;

import io.papermc.paper.event.entity.EntityMoveEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import plugin.Main;

import java.util.ArrayList;

public class MoveEvent implements Listener {

    private static Boolean validBlock(Block block) {
        ArrayList<Material> materials = new ArrayList<>();
        materials.add(Material.GRASS);
        materials.add(Material.TALL_GRASS);
        materials.add(Material.AIR);

        return !materials.contains(block.getType());
    }

    private static Material scifiMaterial() {

        ArrayList<Material> materials = new ArrayList<>();
        materials.add(Material.BLUE_GLAZED_TERRACOTTA);
        materials.add(Material.PURPLE_GLAZED_TERRACOTTA);
        materials.add(Material.BLUE_CONCRETE);
        materials.add(Material.PURPLE_WOOL);
        materials.add(Material.CRYING_OBSIDIAN);
        materials.add(Material.SCULK);

        return materials.get((int) (Math.random() * (materials.size())));
    }

    private static Material experiencedMaterial() {

        ArrayList<Material> materials = new ArrayList<>();
        materials.add(Material.YELLOW_GLAZED_TERRACOTTA);
        materials.add(Material.GLOWSTONE);
        materials.add(Material.ORANGE_CONCRETE);
        materials.add(Material.YELLOW_WOOL);
        materials.add(Material.GOLD_BLOCK);
        materials.add(Material.RAW_GOLD_BLOCK);
        materials.add(Material.WAXED_COPPER_BLOCK);

        return materials.get((int) (Math.random() * (materials.size())));
    }

    @EventHandler
    public static void portalEvent(PlayerPortalEvent event){
        event.setCancelled(true);
    }

    @EventHandler
    public static void moveEvent(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (player.getItemInHand().getLore() == null) {
            return;
        }

        Block block = player.getLocation().subtract(0, 1, 0).getBlock();
        if (event.hasChangedBlock() && validBlock(block)) {

            if (player.getItemInHand().getLore().contains("§eSci-Fi")) {
                player.sendBlockChange(block.getLocation(), scifiMaterial().createBlockData());
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        player.sendBlockChange(block.getLocation(), block.getBlockData());
                    }
                }, 15);
            }
            if (player.getItemInHand().getLore().contains("§eErfahren")) {
                player.sendBlockChange(block.getLocation(), experiencedMaterial().createBlockData());
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        player.sendBlockChange(block.getLocation(), block.getBlockData());
                    }
                }, 15);
            }
        }
    }
}
