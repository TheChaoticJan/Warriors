package jansparadise.jansparadise.events.ExplosionEvents;


import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class ExplodeEvent implements Listener{

    @EventHandler
    public void explodeEvent(EntityExplodeEvent b) {
        if(b.getEntity().getType() == EntityType.PRIMED_TNT){
            b.blockList().clear();
        }
    }
}