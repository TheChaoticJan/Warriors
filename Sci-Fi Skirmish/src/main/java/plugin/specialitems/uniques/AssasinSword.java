package plugin.specialitems.uniques;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import plugin.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class AssasinSword implements Listener, Unique{

    private final static NamespacedKey key = new NamespacedKey(Main.getInstance(), "assasin_sword");
    private HashMap<UUID, Long> cooldownMap = new HashMap<>();
    private static final int effectCooldown = 32;


    public static ItemStack create(){
        ItemStack stack = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = stack.getItemMeta();

        meta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 0);
        meta.getPersistentDataContainer().set(uniqueKey, PersistentDataType.BYTE, (byte) 0);

        meta.displayName(MiniMessage.miniMessage().deserialize("<i:false><obf><#e22c34>a</obf> <gradient:#b32a2a:#e22c34><b>Assasinensäbel</b> <obf><#e22c34>a"));

        meta.addEnchant(Enchantment.DURABILITY, 4, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);

        ArrayList<Component> lore = new ArrayList<>();
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><gradient:#ffd831:#e7f776>Einzigartig"));
        lore.add(Component.empty());
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Mit einem <green>Rechtsklick <white>verschießt dieses"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Schwert einen Schneeball, der bei"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>dich, bei einem Treffer, hinter deinen"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Gegner teleportiert!"));
        lore.add(Component.text("§7§o(Zudem erblindet dieser Kurz)"));
        lore.add(Component.empty());
        lore.add(Component.text("§c\uD83D\uDD51 §f" + effectCooldown + " Sekunden Cooldown"));

        meta.lore(lore);


        stack.setItemMeta(meta);
        return stack;
    }

    @EventHandler
    private void onThrow(PlayerInteractEvent event){

        if(event.getAction().isRightClick() && event.getPlayer().getItemInHand().getItemMeta() != null) {
            if (event.getPlayer().getItemInHand().getItemMeta().getPersistentDataContainer().has(key)) {
                Player player = event.getPlayer();

                if(!isSpecialized(player.getPersistentDataContainer(), key)){
                    player.sendActionBar("§cDu hast die Verwendung dieser Waffe nicht gelernt!");
                    return;
                }
                if(cooldownMap.getOrDefault(event.getPlayer().getUniqueId(), System.currentTimeMillis() - effectCooldown * 1000) > System.currentTimeMillis() - effectCooldown * 1000){return;}

                Snowball snowball = (Snowball) player.getWorld().spawnEntity(player.getLocation().add(0, 1.8, 0), EntityType.SNOWBALL);
                snowball.setShooter(player);
                snowball.setVelocity(player.getLocation().getDirection().multiply(2.3));
                snowball.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 0);

                player.setCooldown(Material.NETHERITE_SWORD, 20 * effectCooldown);
                player.getItemInHand().setDurability((short) (player.getItemInHand().getDurability() + 1));
                cooldownMap.put(player.getUniqueId(), System.currentTimeMillis());

            }
        }

    }
    @EventHandler
    private void onHit(ProjectileHitEvent event){
        if(event.getEntity().getType().equals(EntityType.SNOWBALL) && event.getHitEntity() != null && event.getEntity().getPersistentDataContainer().has(key)){
            Player player = (Player) event.getEntity().getShooter();
            if(event.getHitEntity().getType().equals(EntityType.PLAYER)){
                Player victim = (Player) event.getHitEntity();

                player.teleport(victim.getLocation().subtract(victim.getLocation().getDirection().multiply(3)).add(0, 0.5, 0));
                victim.damage(0.1);
                victim.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 2, 0, true));
            }
        }
    }

    private Boolean isSpecialized(PersistentDataContainer container, NamespacedKey key) {
        return container.has(key);
    }

}
