package plugin.listeners.entitylisteners.pvp;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import plugin.Main;
import plugin.models.PlayerStats;
import plugin.models.PlayerCombatHandler;

import java.sql.SQLException;
import java.util.Objects;

public class PlayerDeathEvent implements Listener{

    @EventHandler
    public void DeathEvent(org.bukkit.event.entity.PlayerDeathEvent event) {

        //Casting player Into Event & Cancelling Death
        Player player = event.getPlayer();

        if (player.getKiller() == null) {
            event.setCancelled(true);
            return;
        } else {
            processPlayerDeath(player);
            event.setCancelled(true);
        }
    }


            public static void processPlayerDeath(Player player){
            player.setHealth(20);
            player.setFoodLevel(20);

            //removing both players from combat
            PlayerCombatHandler.getCombatStatusByPlayer(player).setCombatStatus(false);
            PlayerCombatHandler.getCombatStatusByPlayer(player.getKiller()).setCombatStatus(false);
            PlayerCombatHandler.getCombatStatusByPlayer(player).setLastAttacked(null);
            PlayerCombatHandler.getCombatStatusByPlayer(player.getKiller()).setLastAttacked(null);

            //Creating Playerlocation
            int x = player.getLocation().getBlockX();
            float y = player.getLocation().getBlockY();
            int z = player.getLocation().getBlockZ();

            //Dropping & Clearing Inventory
            for(ItemStack stack : player.getInventory().getContents()) {
                if (stack != null) {
                    Item item  = player.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), Objects.requireNonNull(stack));

                    if(item.getItemStack().getItemMeta().hasDisplayName()) {
                        item.setCustomNameVisible(true);
                        item.customName(item.getItemStack().getItemMeta().displayName());
                    }
                }
            }

            for(ItemStack stack : player.getInventory().getArmorContents()){
                if (stack != null) {
                    player.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), stack);
                    player.getInventory().remove(stack);
                }
            }

            player.getInventory().clear();


            //Teleporting Player back to spawn
            player.setRotation(90, 0);
            if (player.getKiller() != null) {
                player.sendActionBar("§8<§c⚔§8> §cDu wurdest von §7`§f" + player.getKiller().getDisplayName() + "§7` §czermetzelt!");
                player.getKiller().sendActionBar("§8<§c⚔§8> §aDu hast §7`§f" + player.getName() + "§7` §aauseinandergenommen! §8▸ §f+5 §6✧");
            } else {
                player.sendActionBar("§8[§c⚔§8] §cDein Ende ist noch nicht gekommen!");
            }

            try {
                PlayerStats stats = Main.getInstance().getDatabase().findPlayerStats(player);

                if (stats == null) {

                    stats = new PlayerStats(player);
                    Main.getInstance().getDatabase().createPlayerStats(stats);

                }

                stats.setDeaths(stats.getDeaths() + 1);
                Main.getInstance().getDatabase().updatePlayerStats(stats);

                PlayerStats stats1 = Main.getInstance().getDatabase().findPlayerStats(player.getKiller());

                if(stats1 == null){

                    stats1 = new PlayerStats(player.getKiller());
                    Main.getInstance().getDatabase().createPlayerStats(stats1);

                }

                stats1.setXp(stats1.getXp() + 5);
                stats1.setKills(stats1.getKills() + 1);
                Main.getInstance().getDatabase().updatePlayerStats(stats1);

                Main.getInstance().getTablistManager().setScoreboard(player);
                Main.getInstance().getTablistManager().setScoreboard(player.getKiller());

            }catch (SQLException e){
                e.printStackTrace();
            }

            Location l = new Location(player.getWorld(), -1879, 101, 611);
            player.teleport(l);
        }

    }












