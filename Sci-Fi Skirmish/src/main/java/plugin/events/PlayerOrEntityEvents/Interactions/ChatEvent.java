package plugin.events.PlayerOrEntityEvents.Interactions;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;

public class ChatEvent implements Listener{

    @EventHandler
    public void onChatEvent (PlayerChatEvent event){
        ArrayList<String> Boeslist = new ArrayList<>();

        Boeslist.add("hitler");
        Boeslist.add("nigger");
        Boeslist.add("nigga");
        Boeslist.add("hurensohn");
        Boeslist.add("bastard");


        for (String s : Boeslist) {
            if (event.getMessage().toLowerCase().contains(s)) {
                Player p = event.getPlayer();
                event.setCancelled(true);
                p.sendMessage("§cDeine Nachricht wurde nicht abgesendet, da sie gegen unsere Regeln verstößt!");
            }
        }
        event.setMessage(event.getMessage().replace("&", "§"));

        if(event.getMessage().startsWith("7")){
            Player p = event.getPlayer();
            event.setCancelled(true);
            p.sendMessage("§cDeine Nachricht wurde nicht abgesendet! \n§7Wolltest du nicht: §e" + event.getMessage().replace("7", "/") + " §7schreiben?");
        }
    }
}
