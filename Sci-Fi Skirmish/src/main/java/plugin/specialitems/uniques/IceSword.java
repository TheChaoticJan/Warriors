package plugin.specialitems.uniques;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import plugin.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class IceSword implements Listener, Unique {

    private static final NamespacedKey key = new NamespacedKey(Main.getInstance(), "ice_sword");
    private static final HashMap<UUID, Long> cooldownMap = new HashMap<>();

    private static final int effectDuration = 8; //Duration of the effect in Seconds
    private static final int effectCooldown = 45; //Cooldown of the effect in Seconds

    public static ItemStack createItem(){
        ItemStack stack = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = stack.getItemMeta();

        meta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 0);
        meta.getPersistentDataContainer().set(uniqueKey, PersistentDataType.BYTE, (byte) 0);

        meta.displayName(MiniMessage.miniMessage().deserialize("<i:false><obf><white>a</obf> <gradient:#92fff3:#c9fff1><b>Frostige Klinge <obf><white>a"));

        meta.addEnchant(Enchantment.DURABILITY, 4, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);

        ArrayList<Component> lore = new ArrayList<>();
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><gradient:#ffd831:#e7f776>Einzigartig"));
        lore.add(Component.empty());
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Mit einem <green>Rechtsklick <white>verschießt dieses"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Schwert einen Schneeball, der"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>deinen Gegner bei einem Treffer schwächt."));
        lore.add(Component.text("§7§o(Langsamkeit I & verringertes Angriffstempo)"));
        lore.add(Component.empty());
        lore.add(Component.text("§c\uD83D\uDD51 §f" + effectCooldown + " Sekunden Cooldown"));
        lore.add(Component.text("§a\uD83D\uDD51 §f" + effectDuration + " Sekunden §7§o(Bei einem Treffer)"));

        meta.lore(lore);


        stack.setItemMeta(meta);
        return stack;
    }
    @EventHandler
    private void rightClickEvent(PlayerInteractEvent event){

        if(!event.getAction().isRightClick()){return;}

        Player player = event.getPlayer();
        if(player.getItemInHand().getType() == Material.AIR){return;}
        if(!player.getItemInHand().hasItemMeta()){return;}
        if(cooldownMap.getOrDefault(player.getUniqueId(), System.currentTimeMillis() - effectCooldown * 1000) > System.currentTimeMillis() - effectCooldown * 1000) {return;}

        if(player.getItemInHand().getItemMeta().getPersistentDataContainer().has(key))
        {
            Snowball ball = (Snowball) player.getWorld().spawnEntity(player.getLocation().add(player.getLocation().getDirection()).add(0, 1.75, 0), EntityType.SNOWBALL);
            ball.setVelocity(player.getLocation().getDirection().multiply(1.6));
            ball.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 0);

            player.getItemInHand().setDurability((short) (player.getItemInHand().getDurability() + 1));
            player.setCooldown(player.getItemInHand().getType(), 20 * effectCooldown);
            cooldownMap.put(player.getUniqueId(), System.currentTimeMillis());

        }

    }

    @EventHandler
    private void snowBallCollision(ProjectileHitEvent event){

        if(event.getEntity() instanceof Snowball ball && event.getHitEntity() instanceof Player player)
        {
            if(ball.getPersistentDataContainer().has(key))
            {
               player.damage(0.001);
               player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(2.99);
               player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * effectDuration, 1, true));

                Bukkit.getScheduler().runTaskLater(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(30);
                    }
                }, 20 * effectDuration);

            }
        }

    }

}
