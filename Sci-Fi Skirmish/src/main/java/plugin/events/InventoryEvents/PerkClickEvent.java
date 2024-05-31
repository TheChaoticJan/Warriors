package plugin.events.InventoryEvents;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;
import plugin.models.PlayerStats;
import plugin.utils.InventoryBuilder.PerkInventories;

import java.sql.SQLException;
import java.util.Objects;

public class PerkClickEvent implements Listener{

    public PerkClickEvent(Main plugin) {
        this.plugin = plugin;
    }

    Main plugin;
    @EventHandler
    public void perkClickEvent(InventoryClickEvent event){
        if(event.getCurrentItem() == null || event.getCurrentItem().getType().equals(Material.AIR)){
            return;
        }
        try {
        Player player = (Player) event.getWhoClicked();
           PlayerStats stats = this.plugin.getDatabase().findPlayerStats(player);
            if (event.getView().getTitle().equalsIgnoreCase("§c§lPerks")) {
                if(Objects.requireNonNull(event.getCurrentItem()).getItemMeta().getDisplayName().equals("§6§lKaufen?")) {
                    player.openInventory(PerkInventories.confirmBuy(player, event.getCurrentItem()));
                }
                event.setCancelled(true);
            }
            if(event.getView().getTitle().equalsIgnoreCase("§c§lPerk kaufen?")){
                if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cZurück")){
                    player.openInventory(PerkInventories.overview(player, stats));
                }
                if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aBestätigen")){
                    int price = Objects.requireNonNull(event.getInventory().getItem(4).getItemMeta().getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "price"), PersistentDataType.INTEGER));
                    if(stats.getXp() < price){
                        player.closeInventory();
                        player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 20, 1);
                        player.sendActionBar("§cDu hast nicht genügend XP auf dem Konto, um dieses Perk zu kaufen!");
                    }else{
                        stats.setXp(stats.getXp() - price);
                        String perk;
                        if(price == 500){
                            stats.setPerk5(true);
                            perk = "§5Spionagemeister";
                        }else if(price == 750){
                            stats.setPerk4(true);
                            perk = "§aKlebrige Angelegenheit";
                        }else if(price == 1000){
                            stats.setPerk1(true);
                            perk = "§3Rüstungsfanatiker";
                        }else if(price == 1300){
                            stats.setPerk2(true);
                            perk = "§2Geübter Schütze";
                        }else if(price == 2100) {
                            stats.setPerk6(true);
                            perk = "§6Taschendieb";
                        }else{
                            stats.setPerk3(true);
                            perk = "§4Risikobehaftet";
                        }
                        player.sendActionBar("§aErfolgreich das Perk §7'" + perk +  "§7' §agekauft!");
                        player.closeInventory();
                        player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 20, 1);
                        this.plugin.getDatabase().updatePlayerStats(stats);
                        Main.getInstance().getTablistManager().setScoreboard(player);
                    }
                }
                event.setCancelled(true);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
