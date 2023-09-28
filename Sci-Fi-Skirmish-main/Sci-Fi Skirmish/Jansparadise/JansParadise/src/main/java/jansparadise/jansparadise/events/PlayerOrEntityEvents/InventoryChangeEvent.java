package jansparadise.jansparadise.events.PlayerOrEntityEvents;

import io.papermc.paper.event.player.PlayerInventorySlotChangeEvent;
import jansparadise.jansparadise.JansParadise;
import jansparadise.jansparadise.sonstiges.ItemBuilder.InventoryEssentials.BuildingBlocks;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.UUID;

public class InventoryChangeEvent implements Listener{




    JansParadise plugin;

    public InventoryChangeEvent(JansParadise plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void slotEvent(PlayerInventorySlotChangeEvent e){
        Player p = e.getPlayer();

        if(e.getSlot() == 8 && e.getNewItemStack().getAmount() == 0){
            e.getPlayer().getInventory().setItem(8, new ItemStack(Material.STICK));
        }
        if(e.getSlot() == 8 && e.getNewItemStack().getAmount() < 32 && e.getNewItemStack().getAmount() < e.getOldItemStack().getAmount()){

}}}
