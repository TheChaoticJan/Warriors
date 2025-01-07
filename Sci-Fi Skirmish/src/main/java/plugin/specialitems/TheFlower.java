package plugin.specialitems;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.event.Listener;
import plugin.Main;
import plugin.Utils;
import plugin.models.PlayerCombatHandler;

import java.io.IOException;
import java.util.*;

public class TheFlower implements Listener{

    private static final NamespacedKey key = new NamespacedKey(Main.getInstance(), "love");

    public HashMap<UUID, Long> flowerCD = new HashMap<>();

    public static ItemStack loveFlower(){


        ItemStack stack = new ItemStack(Material.BLUE_ORCHID, 1);
        ItemMeta meta = stack.getItemMeta();

        meta.displayName(MiniMessage.miniMessage().deserialize("<i:false><aqua><obf>aa</obf> <gradient:#EA21ED:#DA1B54>[<red>❤</red>] <b>Nele's Blume </b><aqua><obf>aa"));
        meta.addEnchant(Enchantment.KNOCKBACK, 3 , true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<Component> lore = new ArrayList<>();
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize("        <i:false><gradient:#EA21ED:#DA1B54>Ein wunderschönes Blümchen,</gradient>"));
        lore.add(MiniMessage.miniMessage().deserialize("     <i:false><gradient:#EA21ED:#DA1B54>von einem wunderschönen Mädchen</gradient>"));
        lore.add(Component.text("§r                      §o§b§kaa §o§c❤ §b§kaa"));
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize("<i><gradient:white:yellow>Nele merkt sich deinen Lieblingsort!"));
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize(" <i:false>    <yellow>Rechtsklick: <gray>Teleportiert dich an "));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false>     <gray>deinen Lieblingsort."));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false>  <yellow>\uD83D\uDEC8   "));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false>     <yellow>Sneak + Rechtsklick: <gray>Setzt deinen neuen"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false>     <gray>Lieblingsort. <dark_gray>[<red>N/A<dark_gray>]"));
        meta.lore(lore);
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "");
        stack.setItemMeta(meta);

        return stack;

    }


    @EventHandler
    public void clickEvent(PlayerInteractEvent event) throws IOException {
        Player p = event.getPlayer();

        if (p.getItemInHand().getType().equals(Material.AIR)) {
            return;
        }

        if (p.getItemInHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "love"))) {

                PlayerCombatHandler handler = PlayerCombatHandler.getCombatStatusByPlayer(p);

            if (event.getAction() == Action.RIGHT_CLICK_AIR && p.isSneaking()) {
                Location location = p.getLocation();
                String b64 = Utils.LocationToBase64(location);

                ItemStack stack = p.getItemInHand();
                ItemMeta meta = stack.getItemMeta();
                meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, b64);
                List<Component> list = meta.lore();
                list.remove(11);
                list.add(MiniMessage.miniMessage().deserialize("<i:false>     <gray>Lieblingsort. <dark_gray>[<yellow>" + location.getBlockX() + " <gray>| <yellow>" + location.getBlockY() + " <gray>| <yellow>" + location.getBlockZ() + "<dark_gray>]"));
                meta.lore(list);

                stack.setItemMeta(meta);
                p.sendActionBar("§aErfolgreich einen neuen Lieblingsort festgelegt!");
                return;
            }
            if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {

                if(handler.getCombatStatus()){
                    p.sendActionBar("§cDu darfst nicht zu deinem Lieblingsort, wenn du kämpfst!");
                    return;
                }

                if(Objects.equals(p.getItemInHand().getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.STRING), "")){
                    p.sendActionBar("§cDu hast aktuell keinen Lieblingsort festgelegt!");
                    return;
                }

                Location location = Utils.LocationFromBase64(p.getItemInHand().getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.STRING));

                if(flowerCD.get(p.getUniqueId()) == null){
                    flowerCD.put(p.getUniqueId(), System.currentTimeMillis());
                    p.teleport(location);
                    return;
                }

                if(flowerCD.get(p.getUniqueId()) + 60000 <= System.currentTimeMillis()) {
                    flowerCD.put(p.getUniqueId(), System.currentTimeMillis());
                    p.teleport(location);
                }else{
                    p.sendActionBar("§cDu musst noch §e" + String.valueOf((Math.round(60000 - (System.currentTimeMillis() - flowerCD.get(p.getUniqueId())))/1000)) + " §cSekunden warten!");
                }
            }
        }
    }
}
