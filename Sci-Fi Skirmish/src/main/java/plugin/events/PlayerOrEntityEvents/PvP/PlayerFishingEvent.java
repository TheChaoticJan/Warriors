package plugin.events.PlayerOrEntityEvents.PvP;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import plugin.Main;

import java.util.Objects;

public class PlayerFishingEvent implements Listener{

    private BossBar bossBar;

    @EventHandler
    public void FishingEvent(PlayerFishEvent e){
        Player d = (e.getPlayer());

       if(e.getCaught() == null){
           return;
       }


        if(e.getCaught().getType() == EntityType.PLAYER){
           e.getHook().removePassenger(Objects.requireNonNull(e.getHook().getHookedEntity()));
        }

        if(!d.getItemInHand().getType().equals(Material.AIR)){
            if(d.getItemInHand().getItemMeta().getLore() != null) {
                if (d.getItemInHand().getItemMeta().getLore().contains("§eKlebrig")) {

                    String s = "false";
                    int i = (int) (Math.random() * 100) + 1;
                    if (i == 1) {
                        for(int m = 0; m<= 3; m++){
                            for (int l = 0; l <= 35; l++) {
                                if (d.getInventory().getItem(l) == null || d.getInventory().getItem(l).getType() == Material.COBWEB && d.getInventory().getItem(l).getAmount() <= 63) {
                                    s = "true";
                                }
                            }
                            if (s == "true") {
                                d.getInventory().addItem(new ItemStack(Material.COBWEB));
                                showBossBar3(d);
                            } else {
                                int x = d.getLocation().getBlockX();
                                int y = d.getLocation().getBlockY();
                                int z = d.getLocation().getBlockZ();

                                d.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), new ItemStack(Material.COBWEB));
                                showBossBar3(d);
                            }
                        }
                    }
                }}

            if(d.getItemInHand().getItemMeta().getLore() != null) {
                if (d.getItemInHand().getItemMeta().getLore().contains("§eExplosiv")) {

                    String s = "false";
                    int i = (int) (Math.random() * 100) + 1;
                    if (i == 1) {
                        for(int m = 0; m<= 2; m++){
                            for (int l = 0; l <= 35; l++) {
                                if (d.getInventory().getItem(l) == null || d.getInventory().getItem(l).getType() == Material.TNT && d.getInventory().getItem(l).getAmount() <= 63) {
                                    s = "true";
                                }
                            }
                            if (s == "true") {
                                d.getInventory().addItem(new ItemStack(Material.TNT));
                                showBossBar4(d);
                            } else {
                                int x = d.getLocation().getBlockX();
                                int y = d.getLocation().getBlockY();
                                int z = d.getLocation().getBlockZ();

                                d.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), new ItemStack(Material.TNT));
                                showBossBar4(d);
                            }
                        }
                    }
                }}
        }
    }

    private void showBossBar3 (Player player) {
        if (bossBar != null) {
            bossBar.removeAll();
        }

        bossBar = Bukkit.createBossBar("§x§5§A§D§D§2§D§lK§x§5§8§C§5§2§5§ll§x§5§7§A§C§1§E§le§x§5§5§9§4§1§6§lb§x§4§E§9§B§1§8§lr§x§4§7§A§3§1§A§li§x§4§0§A§A§1§C§lg §7§lDrop", BarColor.GREEN, BarStyle.SOLID);
        bossBar.addPlayer(player);

        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
            bossBar.removeAll();
            bossBar = null;
        }, 60); // 40 ticks = 2 seconds
    }

    private void showBossBar4 (Player player) {
        if (bossBar != null) {
            bossBar.removeAll();
        }

        bossBar = Bukkit.createBossBar("§x§D§D§2§D§2§D§lE§x§C§8§3§E§2§6§lx§x§B§3§4§F§2§0§lp§x§9§E§6§0§1§9§ll§x§9§7§6§A§1§7§lo§x§9§D§6§F§1§9§ls§x§A§4§7§3§1§A§li§x§A§A§7§8§1§C§lv §7§lDrop", BarColor.RED, BarStyle.SOLID);
        bossBar.addPlayer(player);

        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
            bossBar.removeAll();
            bossBar = null;
        }, 60); // 40 ticks = 2 seconds
    }
}
