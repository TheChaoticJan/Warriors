package jansparadise.jansparadise.events.PlayerOrEntityEvents;

import io.papermc.paper.event.player.PlayerInventorySlotChangeEvent;
import jansparadise.jansparadise.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class InventoryChangeEvent implements Listener{




    Main plugin;

    public InventoryChangeEvent(Main plugin) {
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
