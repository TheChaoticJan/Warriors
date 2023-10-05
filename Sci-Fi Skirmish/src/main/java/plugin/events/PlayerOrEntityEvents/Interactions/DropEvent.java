package plugin.events.PlayerOrEntityEvents.Interactions;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropEvent implements Listener{

    @EventHandler
    public void DropEvent(PlayerDropItemEvent e){
       if(e.getItemDrop().getItemStack().getType().equals(Material.SANDSTONE)){
           e.setCancelled(true);
       }
    }
}
