package plugin.events.PlayerOrEntityEvents.Interactions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import plugin.Main;

public class LeaveEvent implements Listener{

    @EventHandler
    public static void quitEvent(PlayerQuitEvent event){
        event.setQuitMessage("§8[§c-§8] §f" + event.getPlayer().getName());
        if(Main.getInstance().VanishList.contains(event.getPlayer().getUniqueId())){
            Main.getInstance().VanishList.remove(event.getPlayer());
            for(Player people : Bukkit.getOnlinePlayers()){
                people.showPlayer(Main.getInstance(), event.getPlayer());
            }
            event.getPlayer().setInvulnerable(false);
            event.getPlayer().setAllowFlight(false);
            event.getPlayer().setPlayerListName(event.getPlayer().getDisplayName());
            event.getPlayer().setCustomNameVisible(true);
        }
    }
}
