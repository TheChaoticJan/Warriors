package plugin.events.PlayerOrEntityEvents.Interactions;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.boss.BossBar;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import plugin.models.PlayerCombatHandler;

public class DropEvent implements Listener{

    @EventHandler
    public void onDropEvent(PlayerDropItemEvent e){
       if(e.getItemDrop().getItemStack().getType().equals(Material.SANDSTONE)){
           e.setCancelled(true);
       }
        if(e.getItemDrop().getItemStack().getType().equals(Material.ENCHANTED_BOOK)){
            e.getItemDrop().setCustomName(e.getItemDrop().getItemStack().getItemMeta().getDisplayName());
            e.getItemDrop().setCustomNameVisible(true);
        }
        BossBar bossBar = PlayerCombatHandler.playerBossBars.remove(e.getPlayer());
        if (bossBar != null) {
            bossBar.removeAll();
        }
        Integer taskID = PlayerCombatHandler.playerTaskIDs.remove(e.getPlayer());
        if (taskID != null) {
            Bukkit.getScheduler().cancelTask(taskID);
        }
    }
}
