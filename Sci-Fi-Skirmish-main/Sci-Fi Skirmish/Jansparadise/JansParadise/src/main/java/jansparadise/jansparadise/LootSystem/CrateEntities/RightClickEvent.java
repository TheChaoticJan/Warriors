package jansparadise.jansparadise.LootSystem.CrateEntities;

import jansparadise.jansparadise.JansParadise;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;

public class RightClickEvent implements Listener{

    public RightClickEvent(JansParadise plugin) {
        this.plugin = plugin;
    }

    JansParadise plugin;

    @EventHandler
    public void clickEvent(PlayerInteractEvent e){
        Player p = (Player) e.getPlayer();
        if(p.getItemInHand().getType() == Material.STICK && p.getItemInHand().getItemFlags().contains(ItemFlag.HIDE_ENCHANTS)){

            ArmorstandBuilder.spawnArmorstand(p, p.getLocation().getBlockX(), (float) (p.getLocation().getBlockY() - 0.7), p.getLocation().getBlockZ());


        }

    }
}
