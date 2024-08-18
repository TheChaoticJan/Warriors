package plugin.specialitems.holy;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import plugin.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HolyCookieBox implements Listener {

    static NamespacedKey key = new NamespacedKey(Main.getInstance(), "cookiebox");

    public static ItemStack create(){
        ItemStack stack = new ItemStack(Material.COOKIE);
        ItemMeta meta = stack.getItemMeta();

        meta.displayName(HolyUtil.createName("Linas Keksdose"));
        meta.addEnchant(Enchantment.MENDING, 10, true);
        meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, 17);

        ArrayList<Component> lore = new ArrayList<>();
        lore.add(MiniMessage.miniMessage().deserialize(HolyUtil.holyGradient + "<i:false>Heilig"));
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray>▸ <yellow>Mhhhm, Lina hat frisch gebacken!"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false>  <white>Einen Keks zu essen bringt euch"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false>  <white>für <b>1 Minute</b> folgende Effekte:"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false>   <dark_gray>· <light_purple>Regeneration III"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false>   <dark_gray>· <dark_red>Stärke II"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false>   <dark_gray>· <aqua>Geschwindigkeit I"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false>   <dark_gray>· <red>Eine zweite Reihe an Herzen <gray>(<red>❤<gray>)"));
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize("  <gold><i>Damit Lina nicht auffällt, dass ihr ihre Kekse klaut,"));
        lore.add(MiniMessage.miniMessage().deserialize("  <gold><i>könnt ihr nur alle <u>3 Minuten</u> einen Keks essen!"));
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize("  <i:false><gray>Diese Dose enthält noch: <red>" + meta.getPersistentDataContainer().get(key, PersistentDataType.INTEGER)));
        meta.lore(lore);

        stack.setItemMeta(meta);
        return stack;
    }

    @EventHandler
    private void denyEat(PlayerItemConsumeEvent event){
        if(event.getPlayer().getItemInHand().hasItemMeta()){
            if(event.getPlayer().getItemInHand().getItemMeta().getPersistentDataContainer().has(key)){
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    private void processEffect(PlayerInteractEvent event){

       Player player = event.getPlayer();

       if(event.getAction().isRightClick() && player.getItemInHand().getItemMeta() != null){
           if(player.getItemInHand().getItemMeta().getPersistentDataContainer().has(key)){
               event.setCancelled(true);

               if(player.hasCooldown(Material.COOKIE)){
                   return;
               }

               int amount = player.getItemInHand().getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.INTEGER);

               if(amount == 1){
                   player.getItemInHand().setAmount(0);
               }
               else{
                   amount--;
               }
               ItemMeta meta = player.getItemInHand().getItemMeta();
               meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, amount);
               List<Component> lore = meta.lore();
               lore.set(13, MiniMessage.miniMessage().deserialize("<i:false>  <gray>Diese Dose enthält noch: <red>" + amount));
               meta.lore(lore);
               player.getItemInHand().setItemMeta(meta);

               PotionEffect regeneration = new PotionEffect(PotionEffectType.REGENERATION, 20 * 60, 2);
               PotionEffect strength = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20 * 60, 1);
               PotionEffect speed = new PotionEffect(PotionEffectType.SPEED, 20 * 60, 0);
               PotionEffect healtboost = new PotionEffect(PotionEffectType.HEALTH_BOOST, 20 * 60, 4);
               player.addPotionEffect(regeneration);
               player.addPotionEffect(strength);
               player.addPotionEffect(speed);
               player.addPotionEffect(healtboost);

               player.setCooldown(Material.COOKIE, 20 * 180);

           }
       }

    }

}
