package plugin.specialitems.uniques;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import plugin.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class TitanSword implements Listener, Unique{

    private static final NamespacedKey key = new NamespacedKey(Main.getInstance(), "titan_sword"); //Key for identifying the Itemstack
    private static final HashMap<UUID, Long> cooldownMap = new HashMap<>(); // Hashmap to contain each players cooldown on the effect
    private static final HashMap<UUID, Boolean> isOnEffect = new HashMap<>(); // Hashmap to contain each players state of effect
    private static final int effectCooldown = 50; //Cooldown of the effect in Seconds
    private static final int effectDuration = 5; //Duration of the effect in Seconds



    public static ItemStack create(){

        ItemStack stack = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = stack.getItemMeta();

        meta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 1);
        meta.getPersistentDataContainer().set(uniqueKey, PersistentDataType.BYTE, (byte) 0);

        meta.displayName(MiniMessage.miniMessage().deserialize("<i:false><#9d2323><obf>a</obf><gradient:#824622:#b5185c> <b>Titanensäbel</b> <#9d2323><obf>a"));

        meta.addEnchant(Enchantment.DURABILITY, 4, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);

        ArrayList<Component> lore = new ArrayList<>();
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><gradient:#ffd831:#e7f776>Einzigartig"));
        lore.add(Component.empty());
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Mit einem <green>Rechtsklick <white>erhältst"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>du für 5 Sekunden keinen Rückstoß,"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>sowie den Schnelligkeit 1 Effekt."));
        lore.add(Component.empty());
        lore.add(Component.text("§c\uD83D\uDD51 §f" + effectCooldown + " Sekunden Cooldown"));
        meta.lore(lore);

        stack.setItemMeta(meta);
        return stack;

    }

    @EventHandler
    private void rightClickEvent(PlayerInteractEvent event){

        if(event.getAction().isRightClick()){

            if(!event.hasItem()){return;}
            if(!event.getItem().hasItemMeta()){return;}
            if(!event.getItem().getItemMeta().getPersistentDataContainer().has(key)){return;}

            Player player = event.getPlayer();

            if(cooldownMap.getOrDefault(player.getUniqueId(), System.currentTimeMillis() - 1000 * effectCooldown) > System.currentTimeMillis() - effectCooldown * 1000){
                return;
            }

            if(!isSpecialized(player.getPersistentDataContainer(), key)){
                player.sendActionBar("§cDu hast die Verwendung dieser Waffe nicht gelernt!");
                return;
            }

            isOnEffect.put(player.getUniqueId(), true);
            cooldownMap.put(player.getUniqueId(), System.currentTimeMillis());
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * effectDuration, 0, true));
            player.setCooldown(Material.NETHERITE_SWORD, 20 * effectCooldown);

            Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    isOnEffect.put(player.getUniqueId(), false);
                }
            }, 20 * effectDuration);

        }

    }

    @EventHandler
    private void getHitEvent(EntityDamageByEntityEvent event){

        if(event.getEntity() instanceof Player player){

            if(!isOnEffect.getOrDefault(player.getUniqueId(), false)){
                return;
            }

            if(player.getInventory().getItemInMainHand().getType() != Material.AIR) {
                if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(key)){

                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            player.setVelocity(new Vector(0, 0, 0));
                        }
                    }, 0);
                }
            }

        }
    }

    private Boolean isSpecialized(PersistentDataContainer container /*PersistentDataContainer of the player, not the item*/, NamespacedKey key) {
        return container.has(key);
    }

}
