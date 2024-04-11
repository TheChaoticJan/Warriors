package plugin.cratesystem.CrateEntities;

import com.destroystokyo.paper.Title;
import com.destroystokyo.paper.event.entity.EntityRemoveFromWorldEvent;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Structure;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;
import plugin.Main;
import plugin.cratesystem.Loot;
import plugin.models.PlayerStats;
import plugin.utils.Text.Texts;

import java.sql.SQLException;
import java.util.Objects;

public class CrateDeathEvent implements Listener {

    @EventHandler
    public void DeathEvent(EntityRemoveFromWorldEvent event){
        if(event.getEntity().getType().equals(EntityType.ARMOR_STAND)){

            @NotNull String playerName = Objects.requireNonNull(event.getEntity().getCustomName());
            Player p = Bukkit.getServer().getPlayerExact(playerName);

            if(p == null){
                return;
            }
            event.getEntity().getPassengers().clear();

            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
                int i = 5;
                while (i > 0) {
                    i--;
                }

                new Crate(event.getEntity(), event.getEntity().getLocation().getBlockX(), event.getEntity().getLocation().getBlockY(), event.getEntity().getLocation().getBlockZ());

            }, 20 * 30);



                Entity e = event.getEntity();

                PlayerStats stats = null;
                try {
                     stats = Main.getInstance().getDatabase().findPlayerStatsByUUID(p.getUniqueId().toString());

                    if (stats == null) {

                        stats = new PlayerStats(p.getUniqueId().toString(), p.getName(), "", 0, 0,   0, 0, 0, 0, 0, 0, "", false, false, false,false, false, false, 1,2, 3);
                        Main.getInstance().getDatabase().createPlayerStats(stats);

                    }
                }catch (SQLException e1) {
                    e1.printStackTrace();
                }

                int x = e.getLocation().getBlockX();
                double y = e.getLocation().getBlockY() + 1.7;
                int z = e.getLocation().getBlockZ();

                int rarity = (int) (Math.random() * 100);
                if(rarity <= 42){
                    p.sendActionBar(MiniMessage.miniMessage().deserialize("<dark_gray><<red>Tot<dark_gray>> " + Texts.get("crate") + " <dark_gray>▸ " + Texts.get("common")));
                    for(int i = (int) (Math.random() * 2) ; i < 2; i++) {
                        Item item = e.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), Loot.commonDrop());
                        if(item.getItemStack().getType().equals(Material.ENCHANTED_BOOK)) {
                            item.setCustomName(item.getItemStack().getItemMeta().getDisplayName());
                            item.setCustomNameVisible(true);
                        }
                }
                    Objects.requireNonNull(stats).setCommon_crates(stats.getCommon_crates() + 1);
                    }
                if(rarity <= 70 && rarity > 42) {
                    p.sendActionBar(MiniMessage.miniMessage().deserialize("<dark_gray><<red>Tot<dark_gray>> " + Texts.get("crate") + " <dark_gray>▸ " + Texts.get("uncommon")));

                    for (int i = (int) (Math.random() * 2); i < 2; i++) {
                        Item item = e.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), Loot.uncommonDrop());
                        if(item.getItemStack().getType().equals(Material.ENCHANTED_BOOK)) {
                            item.setCustomName(item.getItemStack().getItemMeta().getDisplayName());
                            item.setCustomNameVisible(true);
                        }
                    }
                    Objects.requireNonNull(stats).setUncommon_crates(stats.getUncommon_crates() + 1);
                }
                if (rarity <= 89 && rarity > 70) {
                    p.sendActionBar(MiniMessage.miniMessage().deserialize("<dark_gray><<red>Tot<dark_gray>> " + Texts.get("crate") + " <dark_gray>▸ " + Texts.get("epic")));

                    for (int i = (int) (Math.random() * 3); i < 3; i++) {
                        Item item =e.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), Loot.epicDrop());
                        if(item.getItemStack().getType().equals(Material.ENCHANTED_BOOK)) {
                            item.setCustomName(item.getItemStack().getItemMeta().getDisplayName());
                            item.setCustomNameVisible(true);
                        }
                    }
                    Objects.requireNonNull(stats).setEpic_crates(stats.getEpic_crates() + 1);
                }
                if (rarity <= 98 && rarity > 89) {
                    p.sendActionBar(MiniMessage.miniMessage().deserialize("<dark_gray><<red>Tot<dark_gray>> " + Texts.get("crate") + " <dark_gray>▸ " + Texts.get("rare")));
                    p.sendTitle(new Title("§6§kaa §x§D§3§D§F§0§0L§x§D§7§D§2§0§1e§x§D§B§C§4§0§3g§x§D§F§B§7§0§4e§x§E§2§A§9§0§5n§x§E§6§9§C§0§6d§x§E§A§8§E§0§8ä§x§E§E§8§1§0§9r §6§kaa", "§7Nachschub", 3, 35, 3));

                    for (int i = (int) (Math.random() * 2); i < 3; i++) {
                        Item item = e.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), Loot.legendaryDrop());
                        if(item.getItemStack().getType().equals(Material.ENCHANTED_BOOK)) {
                            item.setCustomName(item.getItemStack().getItemMeta().getDisplayName());
                            item.setCustomNameVisible(true);
                        }
                    }
                    Objects.requireNonNull(stats).setRare_crates(stats.getRare_crates() + 1);
                        }
                if (rarity <= 100 && rarity > 98) {
                    p.sendActionBar(MiniMessage.miniMessage().deserialize("<dark_gray><<red>Tot<dark_gray>> " + Texts.get("crate") + " <dark_gray>▸ " + Texts.get("mythic")));
                    p.sendTitle(new Title("§b§kaa §x§0§0§D§F§C§DM§x§0§1§D§1§B§By§x§0§3§C§4§A§9t§x§0§4§B§6§9§7h§x§0§6§A§9§8§6i§x§0§7§9§B§7§4s§x§0§9§8§E§6§2c§x§0§A§8§0§5§0h §b§kaa", "§7Nachschub", 3, 35, 3));

                    for (int i = (int) (Math.random() * 3); i < 5; i++) {
                        Item item = e.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), Loot.mythicDrop());
                        if(item.getItemStack().getType().equals(Material.ENCHANTED_BOOK)) {
                            item.setCustomName(item.getItemStack().getItemMeta().getDisplayName());
                            item.setCustomNameVisible(true);
                        }
                    }
                    Objects.requireNonNull(stats).setMythic_crates(stats.getMythic_crates() + 1);
                }

                try {
                    Main.getInstance().getDatabase().updatePlayerStats(Objects.requireNonNull(stats));
                } catch (SQLException ex) {
                   ex.printStackTrace();
                }
            }}}

