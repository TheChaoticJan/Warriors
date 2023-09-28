package jansparadise.jansparadise.events.BlockEvents;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;

public class BlockInteractionEvent implements Listener{

    @EventHandler
    public void blockInteractEvent(BlockFormEvent e){
        e.setCancelled(true);
    }
}
