package plugin.listeners.entitylisteners.interactions;

import com.destroystokyo.paper.Title;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;
import plugin.cratesystem.Loot;
import plugin.models.PlayerStats;
import plugin.models.PlayerCombatHandler;
import plugin.utils.inventorybuilder.SelectCandleInventory;
import plugin.models.TextHandler;
import plugin.utils.essentials.InventoryInteracts;
import plugin.utils.itembuilder.Feather;
import plugin.utils.itembuilder.candles.JumpCandle;
import plugin.utils.itembuilder.candles.RepairCandle;
import plugin.utils.itembuilder.candles.TeleportCandle;

import java.sql.SQLException;
import java.util.*;

public class RightClickEvent implements Listener{

    public RightClickEvent(Main plugin) {
        this.plugin = plugin;
    }

    public static HashMap<UUID, Integer> checkChat = new HashMap<>();
    public HashMap<UUID, String> lockCooldown = new HashMap<>();
    public HashMap<UUID, Long> flowerCD = new HashMap<>();
    Main plugin;

    private static Material randomFlower(Material material){
        ArrayList<Material> list = new ArrayList<Material>();
        list.add(Material.POPPY);
        list.add(Material.BLUE_ORCHID);
        list.add(Material.TORCHFLOWER);
        list.add(Material.ROSE_BUSH);
        list.add(Material.LILY_OF_THE_VALLEY);
        list.add(Material.ALLIUM);
        list.add(Material.ORANGE_TULIP);
        list.add(Material.PINK_TULIP);
        list.add(Material.WITHER_ROSE);

        if(list.contains(material)){
            list.remove(material);
        }

        return  list.get((int)(Math.random() * list.size() - 1));
    }

    @EventHandler
    public void clickEvent(PlayerInteractEvent event) {
        Player p = event.getPlayer();

        if (p.getItemInHand().getType().equals(Material.AIR)) {
            return;
        }

        if (p.getItemInHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "love"))) {

            if (!String.valueOf(p.getUniqueId()).equals("58c6e186-a994-45f1-b804-cae8ccdec55d") && !String.valueOf(p.getUniqueId()).equals("3686fc60-3ff8-459b-8da6-ce05e8910e3f") && !String.valueOf(p.getUniqueId()).equals("1f965897-539a-4195-b886-8c82e732edad")/*Isys UUID*/) {
                if (!(flowerCD.get(p.getUniqueId()) == null)) {
                    if (System.currentTimeMillis() - 2500 >= flowerCD.get(p.getUniqueId())) {
                        flowerCD.remove(p.getUniqueId());
                    } else {
                        p.sendActionBar("§fDu musst noch kurz warten!");
                        return;
                    }
                }
            }

            flowerCD.put(p.getUniqueId(), System.currentTimeMillis());

            p.getItemInHand().setType(randomFlower(p.getItemInHand().getType()));

            Random random = new Random();
            double radius = 1.1;
            int particleCount = 100;
            double angleIncrement = (2 * Math.PI) / particleCount;

            for (int i = 0; i < particleCount; i++) {

                double angle = i * angleIncrement;

                double offsetX = Math.cos(angle) * radius;
                double offsetZ = Math.sin(angle) * radius;

                p.getWorld().spawnParticle(Particle.HEART, p.getLocation().add(offsetX, 2.4, offsetZ), 1, random.nextDouble(1), random.nextDouble(1), 0);

            }
        }

        if (p.getItemInHand().getType().equals(Material.COMPASS) && p.getItemInHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "tracker"))) {
            Player nearest = getNearestPlayer(p);
            p.setCompassTarget(nearest.getLocation());

            ItemMeta meta = p.getItemInHand().getItemMeta();
            meta.displayName(MiniMessage.miniMessage().deserialize("<i:false><b><gradient:#6a3e0a:#9d2323:#e5e814>Tracker <dark_gray><b>▸ <red>" + getNearestPlayer(p).getName()));
            p.getItemInHand().setItemMeta(meta);

            p.sendActionBar("§f" + nearest.getName() + " §7| §b" + Math.round(p.getLocation().distance(nearest.getLocation())) + " Blöcke");
        }

        try {
            PlayerStats stats = this.plugin.getDatabase().findPlayerStats(p);

            if (stats == null) {

                stats = new PlayerStats(p);

                this.plugin.getDatabase().createPlayerStats(stats);

            }

            if (p.getItemInHand().getType().equals(Material.DIAMOND_SWORD) && event.getAction().isRightClick() && PlayerCombatHandler.getCombatStatusByPlayer(p).getCombatStatus() && stats.getPerks()[5] && !lockCooldown.containsKey(p.getUniqueId())) {
                Player victim = PlayerCombatHandler.getCombatStatusByPlayer(p).getLastAttacked();
                if (victim == null) {
                    return;
                }
                victim.setCooldown(Material.ENDER_PEARL, 200);
                victim.setCooldown(Material.COBWEB, 200);
                victim.setCooldown(Material.BOW, 200);
                victim.setCooldown(Material.FISHING_ROD, 200);
                victim.setCooldown(Material.TNT, 200);
                victim.setCooldown(Material.EXPERIENCE_BOTTLE, 200);
                victim.setCooldown(Material.SANDSTONE, 200);
                if (victim.getCooldown(Material.ORANGE_CANDLE) == 0) {
                    victim.setCooldown(Material.ORANGE_CANDLE, 200);
                    JumpCandle.jumpCooldown.put(victim.getUniqueId(), "jump");
                }
                if (victim.getCooldown(Material.GREEN_CANDLE) == 0) {
                    victim.setCooldown(Material.GREEN_CANDLE, 200);
                    TeleportCandle.teleportCooldown.put(victim.getUniqueId(), "teleport");
                }
                if (victim.getCooldown(Material.YELLOW_CANDLE) == 0) {
                    victim.setCooldown(Material.YELLOW_CANDLE, 200);
                    RepairCandle.healCooldown.put(victim.getUniqueId(), "heal");
                }
                p.setCooldown(Material.DIAMOND_SWORD, 1200);
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> JumpCandle.jumpCooldown.remove(victim.getUniqueId(), "jump"), 20 * 10);
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> TeleportCandle.teleportCooldown.remove(victim.getUniqueId(), "teleport"), 20 * 10);
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> RepairCandle.healCooldown.remove(victim.getUniqueId(), "heal"), 20 * 10);
                victim.playSound(victim, Sound.BLOCK_RESPAWN_ANCHOR_DEPLETE, 25, 1);

                lockCooldown.put(p.getUniqueId(), "lock");
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> lockCooldown.remove(p.getUniqueId(), "lock"), 20 * 60);
            }

            float x = p.getLocation().getBlockX();
            float y = p.getLocation().getBlockY();
            float z = p.getLocation().getBlockZ();

        }catch (SQLException exception){
            exception.printStackTrace();
        }

    }
    private Player getNearestPlayer(Player player){
        double distance = Double.POSITIVE_INFINITY;

        Player target = null;

        for(Player guy : Bukkit.getOnlinePlayers()) {
            double dist = Double.POSITIVE_INFINITY;
            if (guy != player && !(Main.getInstance().VanishList.contains(guy.getUniqueId()))){
                dist = player.getLocation().distance(guy.getLocation());
            }
            if(distance >= dist){
                distance = dist;
                target = guy;
            }
        }

        return target;
    }

    }
