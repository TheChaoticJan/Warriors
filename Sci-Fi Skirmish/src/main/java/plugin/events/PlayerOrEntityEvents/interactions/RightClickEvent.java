package plugin.events.PlayerOrEntityEvents.Interactions;

import com.destroystokyo.paper.Title;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;
import plugin.cratesystem.Loot;
import plugin.models.PlayerStats;
import plugin.utils.PlayerCombatHandler;
import plugin.utils.InventoryBuilder.SelectCandleInventory;
import plugin.utils.Text.Texts;
import plugin.utils.essentials.InventoryInteracts;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class RightClickEvent implements Listener{

    public RightClickEvent(Main plugin) {
        this.plugin = plugin;
    }

    public static HashMap<UUID, Integer> checkChat = new HashMap<>();
    public HashMap<UUID, String> jumpCooldown = new HashMap<>();
    public HashMap<UUID, String> healCooldown = new HashMap<>();
    public HashMap<UUID, String> crateCooldown = new HashMap<>();
    public HashMap<UUID, String> teleportCooldown = new HashMap<>();
    public HashMap<UUID, String> lockCooldown = new HashMap<>();
    Main plugin;

    @EventHandler
    public void clickEvent(PlayerInteractEvent e){
        Player p = e.getPlayer();

        if(p.getItemInHand().getType().equals(Material.AIR)){
            return;
        }

        if(p.getItemInHand().getType().equals(Material.COMPASS) && p.getItemInHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "tracker"))){
            Player nearest = getNearestPlayer(p);
            p.setCompassTarget(nearest.getLocation());

            ItemMeta meta = p.getItemInHand().getItemMeta();
            meta.displayName(MiniMessage.miniMessage().deserialize("<i:false><b><gradient:#6a3e0a:#9d2323:#e5e814>Tracker <dark_gray><b>▸ <red>" + getNearestPlayer(p).getName()));
            p.getItemInHand().setItemMeta(meta);

            p.sendActionBar("§f" + nearest.getName() + " §7- §b" + Math.round(p.getLocation().distance(nearest.getLocation())) + " Blöcke");
        }

        if(p.isSneaking() && e.getAction().isRightClick() && p.getItemInHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "loadable"))){
            e.setCancelled(true);
            p.sendMessage("§cBitte schreib in den Chat wie viele XP aufgeladen werden sollen!");
            checkChat.putIfAbsent(p.getUniqueId(), p.getItemInHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "amount"), PersistentDataType.INTEGER));

        }

        if(p.getItemInHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "candle")) && p.getItemInHand().getType().equals(Material.ORANGE_CANDLE) && e.getAction().isRightClick() && !Objects.equals(jumpCooldown.get(p.getUniqueId()), "jump") && !p.isSneaking()){
            p.setVelocity(p.getLocation().getDirection().add(p.getLocation().getDirection().multiply(0.7).setY(0.2)));
            jumpCooldown.put(p.getUniqueId(), "jump");
            p.setCooldown(Material.ORANGE_CANDLE, 100);
            p.playSound(p.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 20, 1);

            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> jumpCooldown.remove(p.getUniqueId(), "jump"), 20 * 5 );
        }

        if(p.isSneaking() && p.getItemInHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "special")) && e.getAction().isRightClick()){ //&& !teleportCooldown.containsKey(p.getUniqueId()) && !jumpCooldown.containsKey(p.getUniqueId()) && !healCooldown.containsKey(p.getUniqueId()) && !crateCooldown.containsKey(p.getUniqueId())
            p.openInventory(SelectCandleInventory.selectCandle(p, p.getItemInHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "candle"), PersistentDataType.STRING)));
        }

        try {
            PlayerStats stats = this.plugin.getDatabase().findPlayerStats(p);

            if (stats == null) {

                stats = new PlayerStats(p);

                this.plugin.getDatabase().createPlayerStats(stats);

            }

            if(p.getItemInHand().getType().equals(Material.DIAMOND_SWORD) && e.getAction().isRightClick() && PlayerCombatHandler.isInCombat(p) && stats.getPerks()[5] && !lockCooldown.containsKey(p.getUniqueId())){
                Player victim = PlayerCombatHandler.isInCombatWith(p);
                victim.setCooldown(Material.ENDER_PEARL, 200);
                victim.setCooldown(Material.COBWEB, 200);
                victim.setCooldown(Material.BOW, 200);
                victim.setCooldown(Material.FISHING_ROD, 200);
                victim.setCooldown(Material.TNT, 200);
                victim.setCooldown(Material.EXPERIENCE_BOTTLE, 200);
                victim.setCooldown(Material.SANDSTONE, 200);
                if(victim.getCooldown(Material.ORANGE_CANDLE) == 0){
                    victim.setCooldown(Material.ORANGE_CANDLE, 200);
                    jumpCooldown.put(victim.getUniqueId(), "jump");
                }
                if(victim.getCooldown(Material.BLUE_CANDLE) == 0){
                    victim.setCooldown(Material.BLUE_CANDLE, 200);
                    crateCooldown.put(victim.getUniqueId(), "crate");
                }
                if(victim.getCooldown(Material.GREEN_CANDLE) == 0){
                    victim.setCooldown(Material.GREEN_CANDLE, 200);
                    teleportCooldown.put(victim.getUniqueId(), "teleport");
                }
                if(victim.getCooldown(Material.YELLOW_CANDLE) == 0){
                    victim.setCooldown(Material.YELLOW_CANDLE, 200);
                    healCooldown.put(victim.getUniqueId(), "heal");
                }
                p.setCooldown(Material.DIAMOND_SWORD, 1200);
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> jumpCooldown.remove(victim.getUniqueId(), "jump"), 20 * 10 );
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> crateCooldown.remove(victim.getUniqueId(), "crate"), 20 * 10 );
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> teleportCooldown.remove(victim.getUniqueId(), "teleport"), 20 * 10 );
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> healCooldown.remove(victim.getUniqueId(), "heal"), 20 * 10);
                victim.playSound(victim, Sound.BLOCK_RESPAWN_ANCHOR_DEPLETE, 25, 1);

                lockCooldown.put(p.getUniqueId(), "lock");
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> lockCooldown.remove(p.getUniqueId(), "lock"), 20 * 60);
            }

            float x = p.getLocation().getBlockX();
            float y = p.getLocation().getBlockY();
            float z = p.getLocation().getBlockZ();

            if (p.getItemInHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "candle")) && p.getItemInHand().getType().equals(Material.BLUE_CANDLE) && e.getAction().isRightClick() && !Objects.equals(crateCooldown.get(p.getUniqueId()), "crate") && !p.isSneaking()) {
                int rarity = (int) (Math.random() * 100 + 1);
                crateCooldown.put(p.getUniqueId(), "crate");
                p.setCooldown(Material.BLUE_CANDLE, 6000);
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 20, 1);
                if (rarity <= 60) {
                    p.sendActionBar(MiniMessage.miniMessage().deserialize(Texts.get("crate") + " <dark_gray>▸ " + Texts.get("epic")));

                    for (int i = (int) (Math.random() * 3); i < 3; i++) {
                        p.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), Loot.epicDrop());
                    }
                    Objects.requireNonNull(stats).setCrates(new int[]{stats.getCrates()[0], stats.getCrates()[1], stats.getCrates()[2] + 1, stats.getCrates()[3], stats.getCrates()[4]});
                }
                if (rarity <= 93 && rarity > 60) {
                    p.sendActionBar(MiniMessage.miniMessage().deserialize(Texts.get("crate") + " <dark_gray>▸ " + Texts.get("rare")));
                    p.sendTitle(new Title("§6§kaa §x§D§3§D§F§0§0L§x§D§7§D§2§0§1e§x§D§B§C§4§0§3g§x§D§F§B§7§0§4e§x§E§2§A§9§0§5n§x§E§6§9§C§0§6d§x§E§A§8§E§0§8ä§x§E§E§8§1§0§9r §6§kaa", "§7Nachschub", 3, 35, 3));

                    for (int i = (int) (Math.random() * 2); i < 3; i++) {
                        p.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), Loot.legendaryDrop());
                    }
                    Objects.requireNonNull(stats).setCrates(new int[]{stats.getCrates()[0], stats.getCrates()[1], stats.getCrates()[2], stats.getCrates()[3] + 1, stats.getCrates()[4]});
                }
                if (rarity <= 100 && rarity > 93) {
                    p.sendActionBar(MiniMessage.miniMessage().deserialize(Texts.get("crate") + " <dark_gray>▸ " + Texts.get("mythic")));
                    p.sendTitle(new Title("§b§kaa §x§0§0§D§F§C§DM§x§0§1§D§1§B§By§x§0§3§C§4§A§9t§x§0§4§B§6§9§7h§x§0§6§A§9§8§6i§x§0§7§9§B§7§4s§x§0§9§8§E§6§2c§x§0§A§8§0§5§0h §b§kaa", "§7Nachschub", 3, 35, 3));

                    for (int i = (int) (Math.random() * 3); i < 5; i++) {
                        p.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), Loot.mythicDrop());
                    }
                    Objects.requireNonNull(stats).setCrates(new int[]{stats.getCrates()[0], stats.getCrates()[1], stats.getCrates()[2], stats.getCrates()[3], stats.getCrates()[4] + 1});
                }
                this.plugin.getDatabase().updatePlayerStats(stats);

                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> crateCooldown.remove(p.getUniqueId(), "crate"), 20 * 300 );

            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }

        if(p.getItemInHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "candle")) && p.getItemInHand().getType().equals(Material.YELLOW_CANDLE) && e.getAction().isRightClick() && !Objects.equals(healCooldown.get(p.getUniqueId()), "heal") && !p.isSneaking()){
            healCooldown.put(p.getUniqueId(), "heal");
            InventoryInteracts.healArmorPieces(p, 15);
            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 20, 1);
            p.setCooldown(Material.YELLOW_CANDLE, 1200);

            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> healCooldown.remove(p.getUniqueId(), "heal"), 20 * 60);

            }

        if(p.getItemInHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "candle")) && p.getItemInHand().getType().equals(Material.GREEN_CANDLE) && e.getAction().isRightClick() && !Objects.equals(teleportCooldown.get(p.getUniqueId()), "teleport") && !p.isSneaking()){
            if(PlayerCombatHandler.isInCombat(p)){
                p.teleport(Objects.requireNonNull(PlayerCombatHandler.isInCombatWith(p)));
                p.setCooldown(Material.GREEN_CANDLE, 1800);
                p.playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 20, 1);
                teleportCooldown.put(p.getUniqueId(), "teleport");
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> teleportCooldown.remove(p.getUniqueId(), "teleport"), 20 * 90);
            }else{
                p.sendActionBar("§cDu befindest dich nicht im Kampf!");
                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 20, 1);
            }
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
