package plugin.events.BlockEvents;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
public class BlockBreakEvent implements Listener{

    @EventHandler
    public void breakEvent(org.bukkit.event.block.BlockBreakEvent event){
        if(event.getBlock().getType() != Material.COBWEB && event.getBlock().getType() != Material.CHISELED_SANDSTONE){
        event.setCancelled(true);
        }

        event.setDropItems(false);
    }

}
