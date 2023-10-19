package plugin.events.InventoryEvents;

import plugin.Main;
import plugin.models.PlayerStats;
import plugin.utils.Infobar.InfobarEssentials;
import plugin.utils.InventoryBuilder.InfobarInventories;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;

import java.sql.SQLException;
import java.util.Objects;

public class InfobarClick implements Listener{

    Main plugin;

    public InfobarClick(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void clickEvent(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        try {
            PlayerStats stats = this.plugin.getDatabase().findPlayerStatsByUUID(p.getUniqueId().toString());

            if (stats == null) {

                stats = new PlayerStats(p.getUniqueId().toString(), p.getName(), "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", false, false, false, false, false, 1, 2, 3);

                this.plugin.getDatabase().createPlayerStats(stats);
            }


            if (event.getView().getTitle().equals("§6§lConfiguriere deine InfobarEssentials!")) {
                if (event.getClick().isRightClick() && Objects.requireNonNull(event.getCurrentItem()).hasItemFlag(ItemFlag.HIDE_ENCHANTS)) {
                    p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier " + event.getCurrentItem().getItemMeta().getDisplayName()));
                    event.setCancelled(true);
                }else{
                    event.setCancelled(true);
                }
            }

            if(event.getView().getTitle().equals("§c§lPerks")){
                if(Objects.requireNonNull(event.getCurrentItem()).getItemMeta().getDisplayName().equals("§6§lKaufen?")){
                    p.sendMessage("UwU");
                }
                event.setCancelled(true);
            }

            if (event.getView().getTitle().startsWith("§7Bearbeite hier")) {

                if(Objects.requireNonNull(event.getCurrentItem()).getType().equals(Material.RED_DYE)){
                    p.openInventory(InfobarInventories.introduction(p, stats));
                    event.setCancelled(true);
                    return;
                }

                if (event.getView().getTitle().endsWith("1")) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Haltbarkeit - §4Rüstung")){
                        stats.setInfobar1(1);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier §3Modul 1"));
                    }
                    if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§a")){
                        stats.setInfobar1(2);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier §3Modul 1"));
                    }
                    if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§5")){
                        stats.setInfobar1(3);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier §3Modul 1"));
                    }
                    if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§6")){
                        stats.setInfobar1(4);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier §3Modul 1"));
                    }
                    if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§c")){
                        stats.setInfobar1(5);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier §3Modul 1"));
                    }
                    if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§f")){
                        stats.setInfobar1(6);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier §3Modul 1"));
                    }
                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Haltbarkeit - §bMainhand")){
                        stats.setInfobar1(7);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier §3Modul 1"));
                    }
                    event.setCancelled(true);
                }
                if (event.getView().getTitle().endsWith("2")) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Haltbarkeit - §4Rüstung")){
                        stats.setInfobar2(1);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier §3Modul 2"));
                    }
                    if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§a")){
                        stats.setInfobar2(2);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier §3Modul 2"));
                    }
                    if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§5")){
                        stats.setInfobar2(3);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier §3Modul 2"));
                    }
                    if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§6")){
                        stats.setInfobar2(4);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier §3Modul 2"));
                    }
                    if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§c")){
                        stats.setInfobar2(5);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier §3Modul 2"));
                    }
                    if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§f")){
                        stats.setInfobar2(6);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier §3Modul 2"));
                    }
                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Haltbarkeit - §bMainhand")){
                        stats.setInfobar2(7);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier §3Modul 2"));
                    }
                    event.setCancelled(true);
                }
                if (event.getView().getTitle().endsWith("3")) {
                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Haltbarkeit - §4Rüstung")){
                        stats.setInfobar3(1);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier §3Modul 3"));
                    }
                    if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§a")){
                        stats.setInfobar3(2);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier §3Modul 3"));
                    }
                    if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§5")){
                        stats.setInfobar3(3);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier §3Modul 3"));
                    }
                    if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§6")){
                        stats.setInfobar3(4);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier §3Modul 3"));
                    }
                    if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§c")){
                        stats.setInfobar3(5);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier §3Modul 3"));
                    }
                    if (event.getCurrentItem().getItemMeta().getDisplayName().startsWith("§f")){
                        stats.setInfobar3(6);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier §3Modul 3"));
                    }
                    if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§7Haltbarkeit - §bMainhand")){
                        stats.setInfobar3(7);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier §3Modul 3"));
                    }
                    event.setCancelled(true);
                }
            }

            }catch(SQLException e){
            e.printStackTrace();
        }
    }
}