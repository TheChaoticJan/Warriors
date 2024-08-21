package plugin.specialitems.royal;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.checkerframework.checker.units.qual.N;
import plugin.Main;

import java.util.ArrayList;
import java.util.HashMap;

public class Scepter implements Listener{

    private final static NamespacedKey key = new NamespacedKey(Main.getInstance(), "scepter");
    private HashMap<Player, Boolean> cooldownMap = new HashMap<>();
    private static final int cooldown = 12;


    public static ItemStack create(){
        ItemStack stack = new ItemStack(Material.GOLDEN_HOE);
        ItemMeta meta = stack.getItemMeta();

        meta.displayName(MiniMessage.miniMessage().deserialize("<i:false><obf><yellow>aa</obf> <gradient:yellow:aqua><b>Königliches Zepter <obf><aqua>aa</obf>"));

        meta.addEnchant(Enchantment.MENDING, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 0);
        meta.setUnbreakable(true);

        ArrayList<Component> lore = new ArrayList<>();
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><gradient:yellow:gold>Royal"));
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray>▸ <yellow>Ein Geschenk der Assasine!"));
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Triffst du einen Gegner mit"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>diesem Zepter, wirst du sofort"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><aqua>hinter <white>diesen teleportiert!"));
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Außerdem <red>erblindet <white>der Gegner kurz!"));
        lore.add(MiniMessage.miniMessage().deserialize(""));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><gray>Cooldown: <red>" + cooldown + " <white>Sekunden"));
        meta.lore(lore);

        stack.setItemMeta(meta);
        return stack;
    }






    @EventHandler
    private void onThrow(PlayerInteractEvent event){
        if(cooldownMap.get(event.getPlayer()) == null || cooldownMap.get(event.getPlayer()))
        if(event.getAction().isLeftClick() && event.getPlayer().getItemInHand().getItemMeta() != null){
            if(event.getPlayer().getItemInHand().getItemMeta().getPersistentDataContainer().has(key)) {
                Player player = event.getPlayer();
                Snowball snowball = (Snowball) player.getWorld().spawnEntity(player.getLocation().add(0, 1.8, 0), EntityType.SNOWBALL);
                snowball.setShooter(player);
                snowball.setVelocity(player.getLocation().getDirection().multiply(2.3));
                snowball.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 0);

                player.setCooldown(Material.GOLDEN_HOE, 20 * cooldown);
                cooldownMap.put(player, false);
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        cooldownMap.put(player, true);
                    }
                }, 20 * cooldown);

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
}
