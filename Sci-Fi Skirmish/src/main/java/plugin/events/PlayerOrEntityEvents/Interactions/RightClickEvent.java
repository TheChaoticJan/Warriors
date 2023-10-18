package plugin.events.PlayerOrEntityEvents.Interactions;

import com.destroystokyo.paper.Title;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import plugin.LootSystem.Loot;
import plugin.Main;
import plugin.models.PlayerStats;
import plugin.utils.CombatLogger;
import plugin.utils.essentials.InventoryInteracts;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class RightClickEvent implements Listener{

    public RightClickEvent(Main plugin) {
        this.plugin = plugin;
    }

    public HashMap<UUID, String> jumpCooldown = new HashMap<>();
    public HashMap<UUID, String> healCooldown = new HashMap<>();
    public HashMap<UUID, String> crateCooldown = new HashMap<>();
    public HashMap<UUID, String> teleportCooldown = new HashMap<>();
    Main plugin;

    @EventHandler
    public void clickEvent(PlayerInteractEvent e){
        Player p = e.getPlayer();

        if(p.getItemInHand().getItemMeta() == null | p.getItemInHand().getItemMeta().getLore() == null){
            return;
        }

        if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§x§D§D§2§D§2§D§ka§x§A§A§7§8§1§C§ka §8§l[§x§D§D§2§D§2§D§lE§x§C§8§3§E§2§6§lx§x§B§3§4§F§2§0§lp§x§9§E§6§0§1§9§ll§x§9§7§6§A§1§7§lo§x§9§D§6§F§1§9§ls§x§A§4§7§3§1§A§li§x§A§A§7§8§1§C§lv§8§l] §x§F§F§0§0§4§8§lZ§x§F§3§0§E§4§1§lü§x§E§7§1§C§3§A§ln§x§D§B§2§A§3§3§ld§x§C§F§3§9§2§C§lk§x§C§2§4§7§2§4§le§x§B§6§5§5§1§D§lr§x§A§A§6§3§1§6§lz§x§9§E§7§1§0§F§le §x§A§A§7§8§1§C§ka§x§D§D§2§D§2§D§ka") && e.getAction().isRightClick() && !Objects.equals(jumpCooldown.get(p.getUniqueId()), "jump")){
            p.setVelocity(p.getLocation().getDirection().add(p.getLocation().getDirection().multiply(0.7).setY(0.2)));
            jumpCooldown.put(p.getUniqueId(), "jump");
            p.setCooldown(Material.ORANGE_CANDLE, 100);

            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    jumpCooldown.remove(p.getUniqueId(), "jump");
                }
            }, 20 * 5 );
        }
        try {
            PlayerStats stats = this.plugin.getDatabase().findPlayerStatsByUUID(p.getUniqueId().toString());

            if (stats == null) {

                stats = new PlayerStats(p.getUniqueId().toString(), p.getName(), "", 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, "", false, false, false, false, false, 1, 2, 3);

                this.plugin.getDatabase().createPlayerStats(stats);

            }

            float x = p.getLocation().getBlockX();
            float y = p.getLocation().getBlockY();
            float z = p.getLocation().getBlockZ();

            if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§x§C§6§0§B§F§9§ka§x§0§0§8§D§F§F§ka §8§l[§x§0§0§8§D§F§F§lS§x§1§E§5§5§F§F§lc§x§3§D§1§C§F§F§li§x§6§4§0§2§F§E§l-§x§9§5§0§7§F§B§lF§x§C§6§0§B§F§9§li§8§l] §x§0§0§4§4§F§C§lZ§x§0§E§3§C§F§9§la§x§1§B§3§5§F§6§lh§x§2§9§2§D§F§3§ll§x§3§6§2§5§F§0§lu§x§4§4§1§D§E§D§ln§x§5§1§1§6§E§A§lg§x§5§F§0§E§E§7§ls§x§6§C§0§6§E§4§lv§x§7§5§0§5§E§7§lo§x§7§E§0§5§E§B§lr§x§8§7§0§4§E§E§ls§x§9§0§0§3§F§2§lc§x§9§8§0§2§F§5§lh§x§A§1§0§2§F§8§lu§x§A§A§0§1§F§C§ls§x§B§3§0§0§F§F§ls §x§0§0§8§D§F§F§ka§x§C§6§0§B§F§9§ka") && e.getAction().isRightClick() && !Objects.equals(crateCooldown.get(p.getUniqueId()), "crate")) {
                int rarity = (int) (Math.random() * 100 + 1);
                crateCooldown.put(p.getUniqueId(), "crate");
                p.setCooldown(Material.BLUE_CANDLE, 6000);
                if (rarity <= 60) {
                    p.sendActionBar("§x§F§F§E§2§5§9N§x§F§F§D§E§5§8a§x§F§F§D§A§5§8c§x§F§F§D§5§5§7h§x§F§F§D§1§5§7s§x§F§F§C§D§5§6c§x§F§F§C§9§5§6h§x§F§F§C§5§5§5u§x§F§F§C§0§5§4b§x§F§F§B§C§5§4s§x§F§F§B§8§5§3k§x§F§F§B§4§5§3i§x§F§F§A§F§5§2s§x§F§F§A§B§5§2t§x§F§F§A§7§5§1e §8» §x§7§8§0§0§D§FE§x§7§3§0§1§C§7p§x§6§E§0§2§B§0i§x§6§A§0§4§9§8s§x§6§5§0§5§8§1c§x§6§0§0§6§6§9h");

                    for (int i = (int) (Math.random() * 3); i < 3; i++) {
                        p.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), Loot.RareDrop());
                    }
                    stats.setEpic_crates(stats.getEpic_crates() + 1);
                }
                if (rarity <= 93 && rarity > 60) {
                    p.sendActionBar("§x§F§F§E§2§5§9N§x§F§F§D§E§5§8a§x§F§F§D§A§5§8c§x§F§F§D§5§5§7h§x§F§F§D§1§5§7s§x§F§F§C§D§5§6c§x§F§F§C§9§5§6h§x§F§F§C§5§5§5u§x§F§F§C§0§5§4b§x§F§F§B§C§5§4s§x§F§F§B§8§5§3k§x§F§F§B§4§5§3i§x§F§F§A§F§5§2s§x§F§F§A§B§5§2t§x§F§F§A§7§5§1e §8» §x§D§3§D§F§0§0L§x§D§7§D§2§0§1e§x§D§B§C§4§0§3g§x§D§F§B§7§0§4e§x§E§2§A§9§0§5n§x§E§6§9§C§0§6d§x§E§A§8§E§0§8ä§x§E§E§8§1§0§9r");
                    p.sendTitle(new Title("§6§kaa §x§D§3§D§F§0§0L§x§D§7§D§2§0§1e§x§D§B§C§4§0§3g§x§D§F§B§7§0§4e§x§E§2§A§9§0§5n§x§E§6§9§C§0§6d§x§E§A§8§E§0§8ä§x§E§E§8§1§0§9r §6§kaa", "§7Nachschub", 3, 35, 3));

                    for (int i = (int) (Math.random() * 2); i < 3; i++) {
                        p.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), Loot.LegendaryDrop());
                    }
                    stats.setRare_crates(stats.getRare_crates() + 1);
                }
                if (rarity <= 100 && rarity > 93) {
                    p.sendActionBar("§x§F§F§E§2§5§9N§x§F§F§D§E§5§8a§x§F§F§D§A§5§8c§x§F§F§D§5§5§7h§x§F§F§D§1§5§7s§x§F§F§C§D§5§6c§x§F§F§C§9§5§6h§x§F§F§C§5§5§5u§x§F§F§C§0§5§4b§x§F§F§B§C§5§4s§x§F§F§B§8§5§3k§x§F§F§B§4§5§3i§x§F§F§A§F§5§2s§x§F§F§A§B§5§2t§x§F§F§A§7§5§1e §8» §x§0§0§D§F§C§DM§x§0§1§D§1§B§By§x§0§3§C§4§A§9t§x§0§4§B§6§9§7h§x§0§6§A§9§8§6i§x§0§7§9§B§7§4s§x§0§9§8§E§6§2c§x§0§A§8§0§5§0h");
                    p.sendTitle(new Title("§b§kaa §x§0§0§D§F§C§DM§x§0§1§D§1§B§By§x§0§3§C§4§A§9t§x§0§4§B§6§9§7h§x§0§6§A§9§8§6i§x§0§7§9§B§7§4s§x§0§9§8§E§6§2c§x§0§A§8§0§5§0h §b§kaa", "§7Nachschub", 3, 35, 3));

                    for (int i = (int) (Math.random() * 3); i < 5; i++) {
                        p.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), Loot.MythicDrop());
                    }
                    stats.setMythic_crates(stats.getMythic_crates() + 1);
                }
                this.plugin.getDatabase().updatePlayerStats(stats);

                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        crateCooldown.remove(p.getUniqueId(), "crate");
                    }
                }, 20 * 300 );

            }
        }catch (SQLException exception){
            exception.printStackTrace();
        }

        if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§x§E§B§D§7§7§B§ka§x§B§E§D§5§5§6§ka §8§l[§x§E§B§D§7§7§B§lE§x§E§5§D§7§7§6§lr§x§D§E§D§6§7§0§lf§x§D§8§D§6§6§B§la§x§D§1§D§6§6§6§lh§x§C§B§D§6§6§1§lr§x§C§4§D§5§5§B§le§x§B§E§D§5§5§6§ln§8§l] §x§E§4§E§1§7§0§lW§x§D§D§D§F§6§D§lu§x§D§6§D§D§6§9§ln§x§C§F§D§B§6§6§ld§x§C§8§D§9§6§2§le§x§C§1§D§8§5§F§lr§x§B§9§D§6§5§C§lk§x§B§2§D§4§5§8§le§x§A§B§D§2§5§5§lr§x§A§4§D§0§5§1§lz§x§9§D§C§E§4§E§le §x§B§E§D§5§5§6§ka§x§E§B§D§7§7§B§ka") && e.getAction().isRightClick() && !Objects.equals(healCooldown.get(p.getUniqueId()), "heal")){
            healCooldown.put(p.getUniqueId(), "heal");
            InventoryInteracts.healArmorPieces(p, 15);
            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 20, 1);
            p.setCooldown(Material.YELLOW_CANDLE, 1200);

            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    healCooldown.remove(p.getUniqueId(), "heal");
                }
            }, 20 * 60);

            }

        if(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§x§5§A§D§D§2§D§ka§x§4§0§A§A§1§C§ka §8§l[§x§5§A§D§D§2§D§lK§x§5§8§C§5§2§5§ll§x§5§7§A§C§1§E§le§x§5§5§9§4§1§6§lb§x§4§E§9§B§1§8§lr§x§4§7§A§3§1§A§li§x§4§0§A§A§1§C§lg§8§l] §x§5§A§D§D§2§D§lP§x§5§9§C§D§2§8§le§x§5§8§B§D§2§3§li§x§5§7§A§C§1§E§ll§x§5§6§9§C§1§9§ls§x§5§3§9§6§1§7§le§x§4§E§9§B§1§8§ln§x§4§9§A§0§1§9§ld§x§4§5§A§5§1§B§le§x§4§0§A§A§1§C§lr §x§4§0§A§A§1§C§ka§x§5§A§D§D§2§D§ka") && e.getAction().isRightClick() && !Objects.equals(teleportCooldown.get(p.getUniqueId()), "teleport")){
            if(CombatLogger.isInCombat(p)){
                p.teleport(Objects.requireNonNull(CombatLogger.isInCombatWith(p)));
                p.setCooldown(Material.GREEN_CANDLE, 2400);
                p.playSound(p.getLocation(), Sound.ENTITY_ENDER_PEARL_THROW, 20, 1);
                teleportCooldown.put(p.getUniqueId(), "teleport");
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        teleportCooldown.remove(p.getUniqueId(), "teleport");
                    }
                }, 20 * 120);
            }else{
                p.sendActionBar("§cDu befindest dich nicht im Kampf!");
                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 20, 1);
            }
        }
        }

    }
