package plugin.specialitems.uniques;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class SwiftSword implements Listener, Unique{
    private static final NamespacedKey key = new NamespacedKey(Main.getInstance(), "swift_sword");
    public static HashMap<UUID, Long> cooldownMap = new HashMap<>();
    private static final int effectCooldown = 20; //Cooldown of the effect in Seconds

    public static ItemStack create(){
        ItemStack stack = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = stack.getItemMeta();

        meta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 0);
        meta.getPersistentDataContainer().set(uniqueKey, PersistentDataType.BYTE, (byte) 0);

        meta.displayName(MiniMessage.miniMessage().deserialize("<i:false><obf><#df91fc>a</obf> <gradient:#bd31ff:#d476f7><b>Flinker Dolch <obf><#df91fc>a"));

        meta.addEnchant(Enchantment.DURABILITY, 4, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);

        ArrayList<Component> lore = new ArrayList<>();
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><gradient:#ffd831:#e7f776>Einzigartig"));
        lore.add(Component.empty());
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Mit einem <green>Rechtsklick <white>boostest"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>du dich ein Stück in die"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Richtung, in welche du schaust"));
        lore.add(Component.empty());
        lore.add(Component.text("§c\uD83D\uDD51 §f" + effectCooldown + " Sekunden Cooldown"));

        meta.lore(lore);


        stack.setItemMeta(meta);
        return stack;
    }

    @EventHandler
    private void processEffect(PlayerInteractEvent event){
        if(event.getItem() == null){return;}
        if(event.getItem().getItemMeta() == null){return;}

        Player player = event.getPlayer();

        if(cooldownMap.getOrDefault(player.getUniqueId(), System.currentTimeMillis() - effectCooldown * 1000) > System.currentTimeMillis() - effectCooldown * 1000){return;}

        if(player.getItemInHand().getItemMeta().getPersistentDataContainer().has(key) && event.getAction().isRightClick())
        {
            player.setVelocity(player.getLocation().getDirection().add(player.getLocation().getDirection().multiply(0.4).setY(0.2)));
            player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 20, 1);
            player.setCooldown(Material.NETHERITE_SWORD, 20 * effectCooldown);
            player.getItemInHand().setDurability((short) (player.getItemInHand().getDurability() + 1));
        }
    }

}
