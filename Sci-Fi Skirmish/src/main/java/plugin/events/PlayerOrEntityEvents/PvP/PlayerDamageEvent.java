package plugin.events.PlayerOrEntityEvents.PvP;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import plugin.Main;

import java.util.HashMap;

public class PlayerDamageEvent implements Listener{

    private static HashMap<Player, Integer> countMap = new HashMap<>();
    private static HashMap<Player, Boolean> cooldownMap = new HashMap<>();


    @EventHandler
    public static void playerDamageEvent(EntityDamageByEntityEvent event){
        if(event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            countMap.put(player, 0);
        }
        if(event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();

            countMap.putIfAbsent(player, 0);
            cooldownMap.putIfAbsent(player, false);

            if (player.getItemInHand().getType() != Material.AIR) {
                if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "Combohoe")) && cooldownMap.get(player).equals(false)) {
                    cooldownMap.put(player, true);
                    ItemStack stack = player.getInventory().getItemInMainHand();
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> cooldownMap.put(player, false), 5);
                    if (countMap.get(player) < 7) {
                        countMap.put(player, 1 + countMap.get(player));
                    }
                    PotionEffect effect = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 5 * 20, countMap.get(player) - 1, false, false, false);
                    player.addPotionEffect(effect);
                }
            }
        }

    }
}
