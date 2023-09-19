package jansparadise.jansparadise.events.PlayerOrEntityEvents;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.ArrayList;
import java.util.Locale;

public class ChatEvent implements Listener{

    @EventHandler
    public void ChatEvent (PlayerChatEvent event){
        ArrayList<String> Böslist = new ArrayList();
        Böslist.add("Hitler");
        Böslist.add("hitler");
        Böslist.add("Nigger");
        Böslist.add("Hurensohn");
        Böslist.add("Bastard");


        for(int i = 0; i < Böslist.size(); i++){
        if(     event.getMessage().contains(Böslist.get(i))){
            Player p = (Player) event.getPlayer();
            event.setCancelled(true);
            p.sendMessage("§cDeine Nachricht wurde nicht abgesendet, da sie gegen unsere Regeln verstößt!");
        }}
        event.setMessage(event.getMessage().replace("&", "§"));

        if(event.getMessage().startsWith("7")){
            Player p = event.getPlayer();
            event.setCancelled(true);
            p.sendMessage("§cDeine Nachricht wurde nicht abgesendet! \n§7Wolltest du nicht: §e" + event.getMessage().replace("7", "/") + " §7schreiben?");
        }
    }
}
