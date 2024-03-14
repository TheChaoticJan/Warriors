package plugin.events.PlayerOrEntityEvents.Interactions;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.Bed;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;
import plugin.Main;

import java.util.ArrayList;
import java.util.HashMap;

public class MoveEvent implements Listener {

    private static final ArrayList<String> types = new ArrayList<>();
    private static final HashMap<Location, Material> Blockmap = new HashMap<>();

    public MoveEvent(Main main) {
    }

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
    public static void moveEvent(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        types.add("§eSci-Fi");
        types.add("§eErfahren");
        types.add("§eExplosiv");
        types.add("§eKlebrig");

        if (player.getItemInHand().getLore() == null) {
            return;
        }

        /*for (String category : types) {
            if (Objects.requireNonNull(player.getItemInHand().getItemMeta().getLore()).contains(category)) {
                return;
            }
        }*/

        Block block = player.getLocation().subtract(0, 1, 0).getBlock();
        if (event.hasChangedBlock() && validBlock(block) && (Blockmap.get(block.getLocation()) == null)) {


            if (player.getItemInHand().getLore().contains("§eSci-Fi")) {
                Blockmap.put(block.getLocation(), block.getType());
                player.sendBlockChange(block.getLocation(), scifiMaterial().createBlockData());
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        player.sendBlockChange(block.getLocation(), block.getBlockData());
                        Blockmap.remove(block.getLocation());
                    }
                }, 15);
            }
            if (player.getItemInHand().getLore().contains("§eErfahren")) {
                Blockmap.put(block.getLocation(), block.getType());
                block.setType(experiencedMaterial());
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        block.setType(Blockmap.get(block.getLocation()));
                        Blockmap.remove(block.getLocation());
                    }
                }, 15);
            }
        }
    }
}
