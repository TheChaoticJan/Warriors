package plugin.events.PlayerOrEntityEvents.interactions;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

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
    }
}