package plugin.utils.itembuilder;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import plugin.Main;
import plugin.specialitems.holy.HolyUtil;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class HolyFeather implements Listener{

    public static ItemStack create(){
        ItemStack stack = new ItemStack(Material.FEATHER);
        ItemMeta meta = stack.getItemMeta();

        meta.displayName(HolyUtil.createName("Zornzauber"));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "holy_feather"), PersistentDataType.BYTE, (byte) 0);

        ArrayList<Component> lore = new ArrayList<>();
        lore.add(MiniMessage.miniMessage().deserialize(HolyUtil.holyGradient + "<i:false>Heilig"));
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray>▸ <yellow>Aus dem Himmel gefallen..."));
        lore.add(MiniMessage.miniMessage().deserialize(" <i:false><white>Diese Feder gibt dir die Mächte"));
        lore.add(MiniMessage.miniMessage().deserialize(" <i:false><white>der Götter für eine kurze Zeit"));
        lore.add(Component.text(""));
        lore.add(Component.text("§7'Meine Macht ist unergründlich'"));

        meta.lore(lore);

        stack.setItemMeta(meta);
        return stack;
    }

    private static void processEffect(Player player){

        player.setItemInHand(player.getItemInHand().subtract(1));
        ItemStack [] inventory = player.getInventory().getContents();

        int time = 5;
        double radius = 0.4;
        int numberOfEntities = 25;

        for (int i = 0; i < numberOfEntities; i++) {
            double angle = 2 * Math.PI * i / numberOfEntities;
            double xOffset = radius * Math.cos(angle);
            double zOffset = radius * Math.sin(angle);

            Location spawnLocation = player.getLocation().add(xOffset, 2, zOffset);
            player.getWorld().spawnParticle(Particle.DRIP_LAVA, spawnLocation, 3);
        }

        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, time * 20, 0));
        player.setInvulnerable(true);
        player.getInventory().clear();

        player.getInventory().addItem(godSword());
        player.getInventory().addItem(new ItemStack(Material.COBWEB, 64));
        player.getInventory().addItem(new ItemStack(Material.ENDER_PEARL, 16));

        player.getInventory().setHeldItemSlot(0);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                player.removePotionEffect(PotionEffectType.SLOW);
                player.setInvulnerable(false);
                player.getInventory().setContents(inventory);
                ItemStack [] items = player.getInventory().getContents();

                }
        }, time * 20);

    }
    @EventHandler
    private void rightClickEvent(PlayerInteractEvent event){
        if(event.getAction().isRightClick() && event.getPlayer().getItemInHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "holy_feather"))){
            HolyFeather.processEffect(event.getPlayer());
        }
    }

    private static ItemStack godSword(){
        ItemStack stack = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = stack.getItemMeta();

        meta.displayName(HolyUtil.createName("Gottes Klinge"));
        meta.addEnchant(Enchantment.DAMAGE_ALL, 7, true);
        meta.addEnchant(Enchantment.KNOCKBACK, 1, false);
        meta.setUnbreakable(true);

        stack.setItemMeta(meta);
        return stack;
    }

}
