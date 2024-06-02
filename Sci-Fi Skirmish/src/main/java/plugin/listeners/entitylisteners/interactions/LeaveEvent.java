package plugin.listeners.entitylisteners.interactions;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;
import plugin.listeners.entitylisteners.pvp.PlayerDeathEvent;
import plugin.models.PlayerCombatHandler;
import plugin.models.TextHandler;

import java.sql.SQLException;

public class LeaveEvent implements Listener{

    @EventHandler
    public static void quitEvent(PlayerQuitEvent event){
        try {
            event.quitMessage(MiniMessage.miniMessage().deserialize("<hover:show_text:'<red>Serverleave.. :('><dark_gray><<red>-<dark_gray>><reset> " + TextHandler.setRankGradient(Main.getInstance().getDatabase().findPlayerStats(event.getPlayer()).getRank()) + event.getPlayer().getName()));
        }catch (SQLException e){ e.printStackTrace();}
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

        if(PlayerCombatHandler.getCombatStatusByPlayer(event.getPlayer()).getCombatStatus()){
            PlayerDeathEvent.processPlayerDeath(event.getPlayer());
            event.getPlayer().getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "combatlog"), PersistentDataType.BOOLEAN, true);
        }
    }


}
