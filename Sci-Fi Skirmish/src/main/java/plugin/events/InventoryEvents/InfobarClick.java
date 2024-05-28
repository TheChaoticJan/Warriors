package plugin.events.InventoryEvents;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;
import plugin.infobar.InfobarEssentials;
import plugin.models.PlayerStats;
import plugin.infobar.InfobarInventories;

import java.sql.SQLException;
import java.util.Objects;

public class InfobarClick implements Listener{

    Main plugin;

    public InfobarClick(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void clickEvent(InventoryClickEvent event) {

        if(event.getCurrentItem() == null){
            return;
        }

        Player p = (Player) event.getWhoClicked();
        try {
            PlayerStats stats = this.plugin.getDatabase().findPlayerStats(p);

            if (stats == null) {

                stats = new PlayerStats(p);

                this.plugin.getDatabase().createPlayerStats(stats);
            }


            if (event.getView().getTitle().equals("§6§lConfiguriere deine Infobar!")) {
                if (event.getClick().isRightClick() && Objects.requireNonNull(event.getCurrentItem()).hasItemFlag(ItemFlag.HIDE_ENCHANTS)) {
                    p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier " + event.getCurrentItem().getItemMeta().getDisplayName()));
                    event.setCancelled(true);
                }else{
                    event.setCancelled(true);
                }
            }

            if (event.getView().getTitle().startsWith("§7Bearbeite hier")) {

                if(Objects.requireNonNull(event.getCurrentItem()).getItemMeta().getDisplayName().equalsIgnoreCase("§cZurück")){
                    p.openInventory(InfobarInventories.introduction(p, stats));
                    event.setCancelled(true);
                    return;
                }

                if(event.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "index"), PersistentDataType.INTEGER) == null){
                    event.setCancelled(true);
                    return;
                }

                int index = event.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "index"), PersistentDataType.INTEGER);


                for(int i = 1; i <= 3; i++){
                    if(event.getView().getTitle().substring(event.getView().getTitle().length() - 1).equals(String.valueOf(i))){
                        stats.setInfobar(i - 1, index);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        p.openInventory(InfobarInventories.edit(p, InfobarEssentials.neededItemstack(stats), "§7Bearbeite hier §3Modul " + i));
                    }
                }
            }

            }catch(SQLException e){
            e.printStackTrace();
        }
    }
}