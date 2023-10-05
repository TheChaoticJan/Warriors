package plugin.events.PlayerOrEntityEvents.Interactions;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import plugin.LootSystem.CrateEntities.Crates;
import plugin.Main;
import plugin.sonstiges.essentials.Count;
import plugin.sonstiges.essentials.InventoryInteracts;

public class RightClickEvent implements Listener{

    public RightClickEvent(Main plugin) {
        this.plugin = plugin;
    }

    Main plugin;

    @EventHandler
    public void clickEvent(PlayerInteractEvent e){
        Player p = e.getPlayer();
        if(p.getItemInHand().getItemMeta() == null | p.getItemInHand().getItemMeta().getLore() == null){
            return;
        }
        if(p.getItemInHand().getType() == Material.STICK && p.getItemInHand().getItemFlags().contains(ItemFlag.HIDE_ENCHANTS)){

            Crates.spawnArmorstand(p, p.getLocation().getBlockX(), (float) (p.getLocation().getBlockY() - 0.7), p.getLocation().getBlockZ());
        }

        if(p.getItemInHand().getItemMeta().getLore().contains("§eErfahren") && p.getItemInHand().getType().equals(Material.BLAZE_ROD) && e.getAction().isRightClick()){

            if(Count.CountValues(p).get(0) < 32){
                p.sendActionBar("§cDu hast nicht genug XP im Inventar");
                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 20, 1);
                return;
            }else{
                p.getInventory().removeItem(new ItemStack(Material.EXPERIENCE_BOTTLE, 32));
                int Helmet = Count.CountValues(p).get(4);
                int Chest = Count.CountValues(p).get(5);
                int Leggings = Count.CountValues(p).get(6);
                int Boots = Count.CountValues(p).get(7);

                int lowest = Count.getLowestPiece(Helmet, Chest, Leggings, Boots);

                if(lowest == Helmet){
                    InventoryInteracts.healArmorPieces(p, 35);
                    return;
                }
                if(lowest == Chest){
                    InventoryInteracts.healArmorPieces(p, 35);
                    return;
                }
                if(lowest == Leggings){
                    InventoryInteracts.healArmorPieces(p, 35);
                    return;
                }
                if(lowest == Boots){
                    InventoryInteracts.healArmorPieces(p, 35);
                }
            }
        }

    }
}
