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
       if(e.getItemDrop().getItemStack().getItemMeta().hasDisplayName()) {
           e.getItemDrop().setCustomNameVisible(true);
           e.getItemDrop().customName(e.getItemDrop().getItemStack().getItemMeta().displayName());
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
